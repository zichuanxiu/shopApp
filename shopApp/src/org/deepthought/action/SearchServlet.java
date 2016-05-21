package org.deepthought.action;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.deepthought.bean.Article;
import org.deepthought.service.ArticleSearchService;
import org.deepthought.service.ArticleSearchServiceImpl;
import org.deepthought.service.util.ServiceProxy;

/**
 * Servlet implementation class SearchServlet
 * 接收处理搜索框信息
 */
@WebServlet("/search.action")
public class SearchServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SearchServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		ServiceProxy serviceProxy = new ServiceProxy();

		ArticleSearchService articleSearchService = (ArticleSearchService)serviceProxy.bind(new ArticleSearchServiceImpl());
		
		
		//二级物品类型表单参数接收
		String typeCode1 = request.getParameter("typeCode1");
		
		request.setAttribute("typeCode1", typeCode1);
		
		String keyWord = request.getParameter("keyWord");
		
		request.setAttribute("keyWord", keyWord);
		
//		System.out.println("00000000000000");
//		System.out.println(typeCode1+"和"+keyWord);
//		System.out.println("00000000000000");

		
		List<Article> ArticleContext = articleSearchService.getAllArticleContextBySearch(typeCode1+"%",keyWord==null?null:"%"+keyWord+"%");
		
		request.setAttribute("ArticleContext", ArticleContext);
		
		request.getRequestDispatcher("/index.action").forward(request, response);
	}

}
