package com.infinte.vehiclehiringsystem.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.infinte.vehiclehiringsystem.bean.Feedback;
import com.infinte.vehiclehiringsystem.service.FeedbackService;
import com.infinte.vehiclehiringsystem.service.FeedbackServiceImpl;

/**
 * Servlet implementation class FeedbackServlet
 */
public class FeedbackServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FeedbackServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		/*
		 * HttpSession session=request.getSession(false); int cust_id
		 * =(Integer)session.getAttribute("cust_id");
		 * 
		 * 
		 * 
		 * request.setAttribute("cust_id", cust_id);
		 * 
		 * RequestDispatcher rd =request.getRequestDispatcher("Feedback.jsp");
		 * rd.forward(request, response);
		 */
		HttpSession session=request.getSession(false);  
		String msg = request.getParameter("msg");
		FeedbackService feedbackService = new FeedbackServiceImpl();
		Feedback feedback = new Feedback();
		int customer_id =(Integer)session.getAttribute("cust_id");  
		feedback.setCustomerid(customer_id);
		feedback.setMessage(msg);
		String execute = feedbackService.insertFeedback(feedback);
		if (execute.equals("sucess")) {
			RequestDispatcher dispatcher = request.getRequestDispatcher("Booked.jsp");
			dispatcher.forward(request, response);
		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		/*
		 * HttpSession session=request.getSession(false); String msg =
		 * request.getParameter("msg"); FeedbackService feedbackService = new
		 * FeedbackServiceImpl(); Feedback feedback = new Feedback(); int customer_id
		 * =(Integer)session.getAttribute("cust_id");
		 * feedback.setCustomerid(customer_id); feedback.setMessage(msg); String execute
		 * = feedbackService.insertFeedback(feedback); if (execute.equals("sucess")) {
		 * RequestDispatcher dispatcher = request.getRequestDispatcher("Booked.jsp");
		 * dispatcher.forward(request, response); }
		 */
		
	}

}
