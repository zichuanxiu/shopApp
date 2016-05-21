package org.deepthought.action;

import java.io.IOException;
import java.text.DecimalFormat;
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
import org.deepthought.pageService.util.PageService;
import org.deepthought.sqlService.util.SqlService;

import sun.security.util.Length;

/**
 * Servlet implementation class ShowCarServlet
 */
@WebServlet("/showCar.action")
public class ShowCarServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ShowCarServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//用户id
				String user_id = (String) request.getSession().getAttribute("user_id");
				
				//一级物品类型
				List<ArticleType> firstArticleType = PageService.firstArticleType();
				
				//购物车商品信息
				List<Map<Integer, Integer>> shopCarInfo = SqlService.selectShopCar(user_id);
			
				System.out.println(shopCarInfo.toString());
				
				//用于保存购物车中商品总数量
			    Integer totalNum = 0;
			    
			    //用于保存购物车中商品总金额
			    Double totalPrice = 0.0;
			    
			    //临时保存goods_id
			    Integer goods_id=0;
			    		
			    //临时保存goods_amount
			    Integer goods_amount=0;
			    
			    
			    List<Article> articleList = new ArrayList<>();
			   
			    if (shopCarInfo!=null&&!shopCarInfo.equals("")) {
			    
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
						
						totalNum +=goods_amount;
						
						totalPrice +=Double.valueOf(article.getDiscountPrice())*goods_amount;
						
						articleList.add(article);
						
					}
			   
			    	request.setAttribute("firstArticleType", firstArticleType);
			    	
					request.setAttribute("articleList", articleList);
					
					request.setAttribute("totalNum", totalNum);
					
					DecimalFormat df= new DecimalFormat("0.00");
					
					request.setAttribute("totalPrice", df.format(totalPrice));
					

					
					request.getRequestDispatcher("/WEB-INF/jsp/showCar.jsp").forward(request, response);
				
			    }else {
					request.getRequestDispatcher("/WEB-INF/jsp/showCar_empty.jsp").forward(request, response);
				}
			
			}


}
