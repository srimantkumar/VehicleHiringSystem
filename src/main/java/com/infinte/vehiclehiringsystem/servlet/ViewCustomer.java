package com.infinte.vehiclehiringsystem.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.infinte.vehiclehiringsystem.bean.Customer;
import com.infinte.vehiclehiringsystem.bean.Vehicle;
import com.infinte.vehiclehiringsystem.service.CustomerService;
import com.infinte.vehiclehiringsystem.service.CustomerServiceImpl;




/**
 * Servlet implementation class ViewCustomer
 */
public class ViewCustomer extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ViewCustomer() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		CustomerService service = new CustomerServiceImpl();
		List<Customer> customerlist = service.getAllCustomers();
		request.setAttribute("customerlist", customerlist);
		RequestDispatcher rd = request.getRequestDispatcher("ViewCustomer.jsp");
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
