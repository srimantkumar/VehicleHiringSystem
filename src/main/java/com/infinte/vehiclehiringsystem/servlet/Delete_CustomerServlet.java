package com.infinte.vehiclehiringsystem.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.infinte.vehiclehiringsystem.service.CustomerService;
import com.infinte.vehiclehiringsystem.service.CustomerServiceImpl;
import com.infinte.vehiclehiringsystem.service.VehicleService;
import com.infinte.vehiclehiringsystem.service.VehicleServiceImpl;

/**
 * Servlet implementation class Delete_CustomerServlet
 */
public class Delete_CustomerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Delete_CustomerServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher rd = null;
		int customer_id = Integer.parseInt(request.getParameter("customer_id"));
		CustomerService service = new CustomerServiceImpl();
		String success = service.deleteCustomer(customer_id);
		if (success.equals("sucess")) {
			rd = request.getRequestDispatcher("ViewCustomer");
			
			
		}
		else {
			rd = request.getRequestDispatcher("AdminMenu.jsp");
			
		}
		rd.forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
