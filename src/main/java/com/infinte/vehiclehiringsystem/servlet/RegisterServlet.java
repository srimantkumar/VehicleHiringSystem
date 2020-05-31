package com.infinte.vehiclehiringsystem.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.infinte.vehiclehiringsystem.bean.Customer;
import com.infinte.vehiclehiringsystem.service.CustomerService;
import com.infinte.vehiclehiringsystem.service.CustomerServiceImpl;

/**
 * Servlet implementation class RegisterServlet
 */
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegisterServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name = request.getParameter("name");
		
		String password = request.getParameter("password");
		int contact = Integer.parseInt(request.getParameter("contact"));
		
		Customer customer = new Customer();
		customer.setContact_no(contact);
		customer.setName(name);
		customer.setPassword(password);
		CustomerService customerService = new CustomerServiceImpl();
		String sucess = customerService.insertCustomer(customer);
		if (sucess.equals("sucess")) {
			RequestDispatcher rd =request.getRequestDispatcher("Login.jsp");
			rd.forward(request, response);}
		else {
			RequestDispatcher rd =request.getRequestDispatcher("Register.jsp");
		    rd.forward(request, response);}
		
			
		}
			
		
	
	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
