package org.deepthought.action;

import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.deepthought.bean.User;
import org.deepthought.sqlService.util.SqlService;

/**
 * Servlet implementation class BuyServlet
 */
@WebServlet("/buy.action")
public class BuyServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public BuyServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void service(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		String goods_id = request.getParameter("id");

		String goods_amount = request.getParameter("buyNum");

		User user = (User) request.getSession().getAttribute("user");
		String user_id = null;
		if (user != null && !user.equals("")) {
			Boolean buyCarFlag= (Boolean)request.getSession().getAttribute("buyCarFlag");
			if (buyCarFlag!=null&&buyCarFlag==true) {
				goods_id= (String)request.getSession().getAttribute("id");
				goods_amount=(String)request.getSession().getAttribute("buyNum");
				
				//清除掉session里保存的id，buyNum，buyCarFlag等信息
				request.getSession().removeAttribute("id");
				request.getSession().removeAttribute("buyNum");
				request.getSession().removeAttribute("buyCarFlag");
			} 
			
			
			user_id = user.getId();
		}
		System.out.println("user_id:"+user_id);

		if (user_id != null && !user_id.equals("")) {
			
			Boolean flag = false;
			Boolean flag2 = false;
			if (goods_id != null && !goods_id.equals("")
					&& goods_amount != null && !goods_amount.equals("")
					&& user_id != null && !user_id.equals("")) {

				List<Map<Integer, Integer>> shopCarInfo = SqlService
						.selectShopCar(user_id);
				System.out.println("========================");
				System.out.println("user_id:"+user_id);
					System.out.println(shopCarInfo.toString());
				
//				System.out.println(shopCarInfo.toString());
				System.out.println("========================");
				//如果shopCarInfo 购物车里面没有任何物品则 判断后直接插入goods_id和goods_amount
				if (shopCarInfo!=null&&!shopCarInfo.toString().equals("[]")&&!shopCarInfo.equals("")) {
					Iterator<Map<Integer, Integer>> info = shopCarInfo.iterator();
					// System.out.println(info.toString());

					// 循环遍历list集合
					outer: while (info.hasNext()) {

						Map<Integer, Integer> map = info.next();
						// System.out.println(map.toString());

						// 循环遍历map集合
						for (Map.Entry<Integer, Integer> maps : map.entrySet()) {

							// System.out.println("maps:"+maps.toString());
							//
							// System.out.println(maps.getKey());

							// 判断goods_id和goodsa_amounts是否相等，相等则修改，不相等则跳出循环，插入数据
							if ("goods_id".equals(maps.getKey())
									&& goods_id.equals(maps.getValue())) {

								// System.out.println("111111111111111111");

								flag2 = true;

							} else {
								// System.out.println("+++++++++");
								flag = true;

							}

							if ("goods_amount".equals(maps.getKey()) && flag2) {

								// System.out.println("111111111111111111");

								SqlService.updateShopCar(
										user_id,
										goods_id,
										Integer.parseInt(goods_amount)
												+ maps.getValue() + "");

								// System.out.println("2222222222222");
								flag = false;
								break outer;

							} else {
								// System.out.println("----------");
								flag = true;
							}

						}
					}
				} else {
					System.out.println("购物车里面没有任何信息，直接插入");
					//购物车里没有关于User的任何信息，直接插入物品信息
					
					SqlService.insertShopCar(user_id, goods_id, goods_amount);
					System.out.println("购物车插入完成");
				}
				
				

			}

			if (flag) {
				SqlService.insertShopCar(user_id, goods_id, goods_amount);
			}
			request.getSession().setAttribute("user_id", user_id);
			request.getRequestDispatcher("/showCar.action").forward(request,
					response);

		} else {
			Boolean buyCarFlag = true;
			request.getSession().setAttribute("id", goods_id);
			request.getSession().setAttribute("buyNum", goods_amount);
			request.getSession().setAttribute("buyCarFlag", buyCarFlag);
			request.getRequestDispatcher("/login.action").forward(request,
					response);
		}

	}

}
