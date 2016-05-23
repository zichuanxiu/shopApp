package org.deepthought.action;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Properties;
import java.util.UUID;

import javax.mail.Authenticator;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage.RecipientType;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.lf5.PassingLogRecordFilter;
import org.deepthought.bean.ArticleType;
import org.deepthought.bean.User;
import org.deepthought.pageService.util.PageService;
import org.deepthought.userService.UserService;

import com.sun.mail.smtp.SMTPMessage;
import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.Authenticator.Result;

/**
 * Servlet implementation class RegisterServlet
 */
@WebServlet("/register.action")
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegisterServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		System.out.println("注册页面");
		String flag =request.getParameter("flag");
		System.out.println(flag);
		if (flag!=null&&flag.equals("validUser")) {
			String loginName = request.getParameter("loginName");
			User user = (User)PageService.getUserByLoginName(loginName);
			if (user!=null) {
				response.getWriter().print("您输入的用户名已经存在，请重新输入");
			}
			
		}else if (flag!=null&&flag.equals("add")) {
			
			
			
			String tip = "";
			
			String loginName = request.getParameter("loginName");
			String passWord = request.getParameter("passWord");
			String okPassWord = request.getParameter("okPassWord");
			if (passWord!=null&&!passWord.equals(okPassWord)) {
				tip="您输入的密码不一致，请重新输入";
			}
			
			String name = request.getParameter("name");
			String sex = request.getParameter("sex");
			String address = request.getParameter("address");
			String phone = request.getParameter("phone");
			String authcode = request.getParameter("authcode");
			
			String randomData = (String)request.getSession().getAttribute("randomData");
			
			if (randomData!=null&&!randomData.equals(authcode)) {
				tip= "您输入的验证码不正确，请重新输入";
			}
			
			if (tip.equals("")) {
				User user = new User();
				user.setLogin_name(loginName);
				user.setPassword(passWord);
				user.setName(name);
				user.setSex(sex);
				user.setEmail(loginName);
				user.setAddress(address);
				user.setPhone(phone);
				SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
				user.setCreate_date(sdf.format(new Date()));
				
				String activeCode = UUID.randomUUID().toString();
				user.setActive(activeCode);
				System.out.println("-------------------");
				System.out.println(user.toString());
				try {
					UserService.save(user);
					sendEmail(user);
					
					String mail=user.getEmail().substring(user.getEmail().lastIndexOf("@")+1);
				
					System.out.println(user.getEmail().substring(user.getEmail().lastIndexOf("@"))+1);
					
					request.setAttribute("message", "恭喜您！您已注册成功，请查收<a href='https://mail."+mail+"/' target='_blank'>邮件</a>进行激活！");
					request.getRequestDispatcher("/login.action").forward(request, response);
					
					
				} catch (Exception e) {
					e.printStackTrace();
				
				}
				
			}else {
				request.setAttribute("message", tip);
				request.getRequestDispatcher("/WEB-INF/jsp/register.jsp").forward(request, response);
			}
			
			
		} else {
			//一级物品类型
			List<ArticleType> firstArticleType = PageService.firstArticleType();
			
			request.setAttribute("firstArticleType", firstArticleType);
			
			request.getRequestDispatcher("/WEB-INF/jsp/register.jsp").forward(request, response);
		}
		
		
	}

	private void sendEmail(User user) {
		
		Properties properties = new Properties();
		
		properties.setProperty("mail.smtp.host", "smtp.126.com");
		
		properties.setProperty("mail.smtp.auth", "true");
		
		Authenticator authenticator = new Authenticator(){
			protected PasswordAuthentication getPasswordAuthentication(){
				return new PasswordAuthentication("fkmailtest@126.com","fkmailtest1234");
			}
		};
		
		Session session = Session.getInstance(properties,authenticator);
		//通过SMTPMessage执行邮件的详细信息
		SMTPMessage smtpMessage = new SMTPMessage(session);
	
		try {
			
			smtpMessage.setSubject("用户注册激活邮件，请勿回复，按照指引激活");
	
			smtpMessage.setContent("<a href='http://127.0.0.1:8080/shopApp/active.action?activeCode="+user.getActive()+"' target='_blank'>亲，您已注册成功,请点击进行激活!</a>","text/html;charset=utf-8");
			
			smtpMessage.setRecipient(RecipientType.TO, new InternetAddress(user.getLogin_name()));
			
			smtpMessage.setFrom(new InternetAddress("fkmailtest@126.com"));
		
			Transport.send(smtpMessage);
		} catch (MessagingException e) {
			e.printStackTrace();
		}
		
		
		
	}

}
