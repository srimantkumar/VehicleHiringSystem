package com.infinte.vehiclehiringsystem.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.infinte.vehiclehiringsystem.bean.Customer;
import com.infinte.vehiclehiringsystem.service.CustomerService;
import com.infinte.vehiclehiringsystem.service.CustomerServiceImpl;

/**
 * Servlet implementation class LoginServlet
 */
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public LoginServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		RequestDispatcher rd = null;
		String name = request.getParameter("customer_name");
		String password = request.getParameter("password");
		if (name.equalsIgnoreCase("ADMIN")&& password.equalsIgnoreCase("ADMIN")) {
			rd = request.getRequestDispatcher("AdminMenu.jsp");
			
			
		}
		else {
		CustomerService customerService = new CustomerServiceImpl();
		HttpSession session = request.getSession();

		List<Customer> customerlist = customerService.getAllCustomers();
		for (Customer customer2 : customerlist) {
			String dbname = customer2.getName();
			String dbpassword = customer2.getPassword();
			int customer_id = customer2.getCustomer_id();
			
			if (dbname.equals(name) && dbpassword.equals(password)) {
				
				session.setAttribute("cust_id", customer_id);
				rd = request.getRequestDispatcher("VehicleView");
				//rd.forward(request, response);
				break;

			}
			rd = request.getRequestDispatcher("Login.jsp");
			//rd.forward(request, response);
			
			    
				
			
				
		}
	}
		rd.forward(request, response);

}
}
