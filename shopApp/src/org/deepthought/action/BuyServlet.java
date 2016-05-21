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

		String user_id = "1";

		Boolean flag = false;
		Boolean flag2 = false;
		if (goods_id != null && !goods_id.equals("") && goods_amount != null
				&& !goods_amount.equals("") && user_id != null
				&& !user_id.equals("")) {

			List<Map<Integer, Integer>> shopCarInfo = SqlService
					.selectShopCar(user_id);

//			System.out.println("000000000000");

			Iterator<Map<Integer, Integer>> info = shopCarInfo.iterator();
//			System.out.println(info.toString());
			
			
			//循环遍历list集合
			outer:
			while (info.hasNext()) {

				Map<Integer, Integer> map = info.next();
//				System.out.println(map.toString());

				//循环遍历map集合
				for (Map.Entry<Integer, Integer> maps : map.entrySet()) {

//					System.out.println("maps:"+maps.toString());
//					
//					System.out.println(maps.getKey());
					
					//判断goods_id和goodsa_amounts是否相等，相等则修改，不相等则跳出循环，插入数据
					if ("goods_id".equals(maps.getKey())&&goods_id.equals(maps.getValue())) {

//						System.out.println("111111111111111111");

						flag2= true;

					} else {
//						System.out.println("+++++++++");
						flag = true;
						
					}
					
					if ("goods_amount".equals(maps.getKey())&&flag2) {

//						System.out.println("111111111111111111");

						SqlService.updateShopCar(
								user_id,
								goods_id,
								Integer.parseInt(goods_amount)+ maps.getValue()+"");

//						System.out.println("2222222222222");
						flag = false;
						break outer;

					} else {
//						System.out.println("----------");
						flag = true;
					}
					
				}
			}

		}

		if (flag) {
//			System.out.println("=========");
			SqlService.insertShopCar(user_id, goods_id, goods_amount);
		}
		request.getSession().setAttribute("user_id", user_id);
		request.getRequestDispatcher("/showCar.action").forward(request,
				response);

	}

}
