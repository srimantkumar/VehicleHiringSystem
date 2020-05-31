package com.infinte.vehiclehiringsystem.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.infinte.vehiclehiringsystem.bean.Customer;
import com.infinte.vehiclehiringsystem.bean.Feedback;
import com.infinte.vehiclehiringsystem.service.CustomerService;
import com.infinte.vehiclehiringsystem.service.CustomerServiceImpl;
import com.infinte.vehiclehiringsystem.service.FeedbackService;
import com.infinte.vehiclehiringsystem.service.FeedbackServiceImpl;

/**
 * Servlet implementation class ViewFeedbackServlet
 */
public class ViewFeedbackServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ViewFeedbackServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		FeedbackService service = new FeedbackServiceImpl();
		List<Feedback> feedbacklist = service.getAllFeedback();
		request.setAttribute("feedbacklist", feedbacklist);
		RequestDispatcher rd = request.getRequestDispatcher("ViewFeedback.jsp");
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
