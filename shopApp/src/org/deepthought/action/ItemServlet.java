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
import org.deepthought.pageService.util.PageService;
/**
 * Servlet implementation class ItemServlet
 */
@WebServlet("/item.action")
public class ItemServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ItemServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
//		ServiceProxy serviceProxy = new ServiceProxy();
//		
//		ArticleService articleService = (ArticleService)serviceProxy.bind(new ArticleServiceImpl());
		//一级物品类型
		List<ArticleType> firstArticleType= PageService.firstArticleType();
		
		System.out.println(firstArticleType);
		request.setAttribute("firstArticleTypeMap", firstArticleType);
		
		//物品详细信息
		String id = request.getParameter("id");
		


		Article itemArticle = PageService.getArticle(id);
//		System.out.println(itemArticle.toString());
	
		request.setAttribute("itemArticle", itemArticle);
		
		request.getRequestDispatcher("/WEB-INF/jsp/item.jsp").forward(request, response);
	
	
	}

}
