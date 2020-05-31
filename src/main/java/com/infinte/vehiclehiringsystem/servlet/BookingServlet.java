package com.infinte.vehiclehiringsystem.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.infinte.vehiclehiringsystem.bean.Booking;
import com.infinte.vehiclehiringsystem.bean.Customer;
import com.infinte.vehiclehiringsystem.bean.Vehicle;
import com.infinte.vehiclehiringsystem.service.BookingService;
import com.infinte.vehiclehiringsystem.service.BookingServiceImpl;
import com.infinte.vehiclehiringsystem.service.CustomerService;
import com.infinte.vehiclehiringsystem.service.CustomerServiceImpl;
import com.infinte.vehiclehiringsystem.service.VehicleService;
import com.infinte.vehiclehiringsystem.service.VehicleServiceImpl;





/**
 * Servlet implementation class BookingServlet
 */
public class BookingServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public BookingServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		  String vehicleid = request.getParameter("vehicleid");
		 
		  request.setAttribute("vehicleid", vehicleid); 
		  RequestDispatcher dispatcher = request.getRequestDispatcher("Booking.jsp");
		  dispatcher.forward(request, response);
		 
		

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		PrintWriter pw = response.getWriter();
		HttpSession session=request.getSession(false);  
        int cust_id =(Integer)session.getAttribute("cust_id");  
		String vehicleid = request.getParameter("vehicle_id");
		String droploc=request.getParameter("droploc");
		String pickuploc=request.getParameter("pickup");
		
		VehicleService vehicleService = new VehicleServiceImpl();
		
		CustomerService service = new CustomerServiceImpl(); 
		
		BookingService bookingService = new BookingServiceImpl();
 
		Vehicle vehicle = vehicleService.getVehicle(vehicleid);
		
		Customer customer =service.getCustomer(cust_id);
		
		Booking booking = new Booking();
		booking.setDroploc(droploc);
		booking.setPickuploc(pickuploc);
		booking.setCustomer(customer);
		booking.setVehicle(vehicle);
		 
        
		

		int sfare = 3;
		int mfare = 5;
		int lfare = 7;
		int totalamount;
		

		int dist = Integer.parseInt(request.getParameter("distance"));
		if (dist > 0 && dist <= 10) {
			totalamount = dist * sfare;
		} else if (dist >= 11 && dist <= 20) {
			totalamount = dist * mfare;

		} else {
			totalamount = dist * lfare;
		}
		session.setAttribute("amount", totalamount);
		if (totalamount>0) {
			String execute = bookingService.insertBooking(booking);
			
			if (execute.equals("sucess")) {
				request.setAttribute("book_id", booking.getBookId());
				RequestDispatcher dispatcher = request.getRequestDispatcher("Billing.jsp");
				dispatcher.forward(request, response);
				
			}
			else {
				RequestDispatcher dispatcher = request.getRequestDispatcher("ErrorPage.jsp");
			    dispatcher.forward(request, response);}
			
			
			 
			
			
		}
		else {
			RequestDispatcher dispatcher = request.getRequestDispatcher("Booking.jsp");
		    dispatcher.forward(request, response);}

	}

}
