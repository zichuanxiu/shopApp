package org.deepthought.action;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.deepthought.bean.Article;
import org.deepthought.bean.ArticleType;
import org.deepthought.pageService.util.PageService;
import org.deepthought.service.ArticleContextService;
import org.deepthought.service.ArticleContextServiceImpl;
import org.deepthought.service.ArticleService;
import org.deepthought.service.ArticleServiceImpl;
import org.deepthought.service.util.ServiceProxy;


/**
 * @author linhe
 * ��ҳ
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
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		ServiceProxy serviceProxy = new ServiceProxy();
//
//		ArticleService articleService = (ArticleService)serviceProxy.bind(new ArticleServiceImpl());

		//一级物品类型参数获取
		String articleTypeCode = request.getParameter("typecode");
		
		//一级物品类型
		List<ArticleType> firstArticleType=PageService.firstArticleType();
		
		//二级物品类型
		List<ArticleType> secondArticleType = PageService.secondArticleType(firstArticleType, articleTypeCode);
		
		
//		System.out.println(articleTypeCode);
		
		String firstName= null;
		if (articleTypeCode==null||articleTypeCode.equals("")) {
			articleTypeCode= firstArticleType.get(0).getCode();
			firstName= firstArticleType.get(0).getName();
		}
		
		
		String firstCode= articleTypeCode;
//		System.out.println(Integer.parseInt(firstCode.replace("0", "")));
		
		if (firstName==null||firstName.equals("")) {
			firstName= firstArticleType.get(Integer.parseInt(firstCode)-1).getName();
		}
		
//		System.out.println(firstCode+"和"+artilleFormTypeWord);
		
		//正文商品信息
		List<Article> ArticleContext=(List<Article>)request.getAttribute("ArticleContext");
		if (ArticleContext==null) {
			ArticleContext = PageService.articleContext(firstCode);
		} 

	
		
		
		request.setAttribute("ArticleContext", ArticleContext);
		request.setAttribute("firstCode", firstCode);
		request.setAttribute("firstName", firstName);
		request.setAttribute("secondArticleType", secondArticleType);
		request.setAttribute("firstArticleTypeMap", firstArticleType);
		request.getRequestDispatcher("/WEB-INF/jsp/list.jsp").forward(request, response);
	}

}
