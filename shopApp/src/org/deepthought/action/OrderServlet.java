package org.deepthought.action;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.deepthought.bean.Article;
import org.deepthought.bean.ArticleType;
import org.deepthought.bean.User;
import org.deepthought.pageService.util.PageService;
import org.deepthought.sqlService.util.SqlService;

/**
 * Servlet implementation class OrderServlet
 */
@WebServlet("/order.action")
public class OrderServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public OrderServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		System.out.println("结算中");
		
		//从购物车页面里取到商品总价格
//		Double totalPrice = Double.valueOf(request.getParameter("totalPrice"));
		Double totalPrice =0.0;
		//第一物品类型
		List<ArticleType> firstArticleType = PageService.firstArticleType();
		//登陆的user对象
		User user = (User)request.getSession().getAttribute("user");
		if (user!=null&&!user.equals("")) {
			//根据user_id找到购物车里面的物品类型list
			List<Map<Integer, Integer>> shopCarInfo = SqlService.selectShopCar(user.getId());
			if (shopCarInfo!=null&&!shopCarInfo.equals("")) {
				
				//商品信息集合
				List<Article> articleList = new ArrayList<>();
				//临时保存goods_id
			    Integer goods_id=0;
			    		
			    //临时保存goods_amount
			    Integer goods_amount=0;
				
			    //遍历购物车，拿到所有商品的详细信息的list
			    
				Iterator<Map<Integer, Integer>> info = shopCarInfo.iterator();
		    	
		    	while (info.hasNext()) {
				
		    		Map<Integer, Integer> map = (Map<Integer, Integer>) info.next();
				
					//这段for循环完以后，得到了goods_id和goods_amount的值
						for (Map.Entry<Integer, Integer> maps : map.entrySet()) {
					
							if ("goods_id".equals(maps.getKey())) {
							
								goods_id=Integer.parseInt(maps.getValue()+"");
						
						}
							
							if ("goods_amount".equals(maps.getKey())) {

							goods_amount =Integer.valueOf(maps.getValue());
						}
							
					}
					
					Article article = PageService.getArticle(goods_id+"");
					
					article.setBuyNum(goods_amount);
					
					
					totalPrice =totalPrice+Double.valueOf(article.getDiscountPrice())*goods_amount;
					
					articleList.add(article);
					
				}
		    	//得到了订单页面的所有信息，存入request，进行跳转
		    	request.setAttribute("user", user);
		    	
		    	request.setAttribute("articleList", articleList);
		    	
		    	request.setAttribute("totalPrice", totalPrice);
		    	
		    	request.setAttribute("firstArticleType", firstArticleType);
				request.getRequestDispatcher("/WEB-INF/jsp/order.jsp").forward(request, response);
		    	
		    	
			}else {
				//后台数据库里面没有该用户 的商品信息，跳转到首页
				request.getRequestDispatcher("/WEB-INF/jsp/index.action").forward(request, response);
			}
			
		} else {
			//用户没有登陆，跳转到登陆页面
			request.getRequestDispatcher("/WEB-INF/jsp/login.action").forward(request, response);
		}

	}

}
