package com.infinte.vehiclehiringsystem.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.infinte.vehiclehiringsystem.bean.Billing;
import com.infinte.vehiclehiringsystem.bean.Booking;
import com.infinte.vehiclehiringsystem.service.BillingService;
import com.infinte.vehiclehiringsystem.service.BillingServiceImpl;
import com.infinte.vehiclehiringsystem.service.BookingService;
import com.infinte.vehiclehiringsystem.service.BookingServiceImpl;



/**
 * Servlet implementation class BillingServlet
 */
public class BillingServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BillingServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session=request.getSession(false);  
        int amount =(Integer)session.getAttribute("amount");  
       
        
		
		request.setAttribute("amount", amount);
        //out.print(amount);
		RequestDispatcher rd =request.getRequestDispatcher("Billing.jsp");
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 int book_id = Integer.parseInt(request.getParameter("book_id"));
		
		 
		  int total_amount = Integer.parseInt(request.getParameter("amount"));
		  BillingService billingService = new BillingServiceImpl(); 
		  Billing billing =
		  new Billing(); 
		  billing.setBill_no(book_id);
		  billing.setTotal_amount(total_amount);
		  
		  
		  
		  
		  String execute = billingService.insertBilling(billing);
		 
		
		  if (execute.equals("sucess")) {
		  
		  RequestDispatcher dispatcher = request.getRequestDispatcher("Booked.jsp");
		  dispatcher.forward(request, response);
		  
		  }
		  else {
		 
		   RequestDispatcher rd =request.getRequestDispatcher("Billing.jsp");
		  rd.forward(request, response);}
		
	}

}
