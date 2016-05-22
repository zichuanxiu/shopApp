package org.deepthought.action;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.deepthought.bean.Article;
import org.deepthought.bean.ArticleType;
import org.deepthought.bean.User;
import org.deepthought.pageService.util.PageService;
import org.deepthought.tag.Page;


/**
 * @author linhe ��ҳ
 */
@WebServlet("/index.action")
public class IndexServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public IndexServlet() {
		super();
	}

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void service(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		// 一级物品类型参数获取
		String firstCode = request.getParameter("typecode");

		// 一级物品类型
		List<ArticleType> firstArticleType = PageService.firstArticleType();

		// 二级物品类型
		List<ArticleType> secondArticleType = PageService.secondArticleType(
				firstArticleType, firstCode);

		// 三级标题
		String firstName = null;
		if (firstCode == null || firstCode.equals("")) {
			firstCode = firstArticleType.get(0).getCode();
			firstName = firstArticleType.get(0).getName();
		}

		if (firstName == null || firstName.equals("")) {
			firstName = firstArticleType.get(Integer.parseInt(firstCode) - 1)
					.getName();
		}

		// List<Article>
		// ArticleContext=(List<Article>)request.getAttribute("ArticleContext");
		// if (ArticleContext==null) {
		// ArticleContext = PageService.articleContext(firstCode);
		// }

		// 搜索框参数接收
		String typeCode1 = request.getParameter("typeCode1");

		String keyWord = request.getParameter("keyWord");

		// typeCode1为空则指定一个值
		if (typeCode1 == null || typeCode1.equals("")) {
			typeCode1 = firstArticleType.get(0).getCode();
		}

		// 获取当前页码
		String pageIndex = request.getParameter("pageIndex");
		if (pageIndex == null || pageIndex.equals("")) {
			pageIndex = "1";
		}

		// 创建分页实体 8:代表每页显示的记录数 pageIndex：当前页码
		Page page = new Page(8, Integer.valueOf(pageIndex));

		int totalNumber = PageService.getTotalNumber(typeCode1+"%",keyWord==null?null:"%"+keyWord+"%");
		
		System.out.println("totalNumber:"+totalNumber);
		
		page.setTotalNumber(totalNumber);
		
		
		request.setAttribute("page", page);
		// 正文商品信息分页查询
		List<Article> ArticleContext = PageService.articleContext(typeCode1
				+ "%", keyWord == null ? null : "%" + keyWord + "%", page);

		
		
		//用户登录的user 临时
//		User user = (User)request.getAttribute("user");
//		if (user!=null) {
//			System.out.println(user.getName());
//			System.out.println("=====================");
//			request.setAttribute("name", user.getName());
//			System.out.println(request.getSession().getAttribute("user").toString());
//		}
//		request.setAttribute("name", user.getName());
		
		
		
		request.setAttribute("ArticleContext", ArticleContext);
		request.setAttribute("firstCode", firstCode);
		request.setAttribute("firstName", firstName);
		request.setAttribute("secondArticleType", secondArticleType);
		request.setAttribute("firstArticleTypeMap", firstArticleType);
		request.getRequestDispatcher("/WEB-INF/jsp/list.jsp").forward(request,
				response);
	}

}
