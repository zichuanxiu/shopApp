package org.deepthought.action;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.deepthought.bean.ArticleType;
import org.deepthought.bean.User;
import org.deepthought.pageService.util.PageService;
import org.deepthought.sqlService.util.SqlService;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/login.action")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		// 一级物品类型
		List<ArticleType> firstArticleType = PageService.firstArticleType();
	
		
	
		String flag = request.getParameter("flag");
		if (flag!=null&&flag.equals("true")) {
			//获取用户名和密码
			String loginName = request.getParameter("loginName");
			String password  = request.getParameter("password");
			System.out.println(loginName+"和"+password);
			
			User user = PageService.getUserByNameAndPass(loginName,password);
			String url = null;
			if (user==null) {
				request.setAttribute("message", "您输入的用户名或密码不正确，请重新输入");
				url="/WEB-INF/jsp/login.jsp";
			}else if (user.getDisabled()=="0") {
				request.setAttribute("message", "您尚未激活，请登录邮箱["+user.getEmail()+"]激活后再登录！");
				url="/WEB-INF/jsp/login.jsp";
			}else if ("2".equals(user.getRole())) {
				//这里是管理员账户
//				System.out.println("这里是管理员账户");
				request.getSession().setAttribute("user", user);
				url="/adminIndex.action";
			}else {
				request.getSession().setAttribute("user", user);
				Boolean buyCarFlag =(Boolean)request.getSession().getAttribute("buyCarFlag");
				
				if (buyCarFlag!=null&&buyCarFlag==true) {
					
					url = "/buy.action";
				} else {
					url = "/index.action";
				}
			
			}
//			System.out.println("url"+url);
			request.getRequestDispatcher(url).forward(request, response);
		}else {
			request.setAttribute("firstArticleType", firstArticleType);
			request.getRequestDispatcher("/WEB-INF/jsp/login.jsp").forward(request, response);
		}
		
		
	}

}
