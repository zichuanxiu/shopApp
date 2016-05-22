package org.deepthought.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.deepthought.sqlService.util.SqlService;

/**
 * Servlet implementation class UpdateCarServlet
 */
@WebServlet("/updateCar.action")
public class UpdateCarServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateCarServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("111111111");
		String user_id = (String) request.getSession().getAttribute("user_id");
		
		String goods_id= request.getParameter("id");
		
		String goods_number = request.getParameter("buyNum");
		
		SqlService.updateShopCar(user_id, goods_id, goods_number);
		
		request.getRequestDispatcher("/showCar.action").forward(request, response);
	}

}
