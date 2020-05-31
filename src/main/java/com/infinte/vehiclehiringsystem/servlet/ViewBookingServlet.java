package com.infinte.vehiclehiringsystem.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.infinte.vehiclehiringsystem.bean.Booking;
import com.infinte.vehiclehiringsystem.service.BookingService;
import com.infinte.vehiclehiringsystem.service.BookingServiceImpl;



/**
 * Servlet implementation class ViewBookingServlet
 */
public class ViewBookingServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ViewBookingServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		BookingService service = new BookingServiceImpl();
		List<Booking> bookinglist = service.getAllBooking();
		request.setAttribute("bookinglist", bookinglist);
		RequestDispatcher rd = request.getRequestDispatcher("ViewBooking.jsp");
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
