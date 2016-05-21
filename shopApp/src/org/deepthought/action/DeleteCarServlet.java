package org.deepthought.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.deepthought.sqlService.util.SqlService;

/**
 * Servlet implementation class DeleteCarServlet
 */
@WebServlet("/deleteCar.action")
public class DeleteCarServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteCarServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("000000000");
		String user_id = (String) request.getSession().getAttribute("user_id");
		
		String goods_id =	request.getParameter("id");
		System.out.println(user_id+"和"+goods_id);
		
		SqlService.deleteShopCar(user_id, goods_id);
		
		request.getRequestDispatcher("/showCar.action").forward(request, response);
		
		
	
	}

}
