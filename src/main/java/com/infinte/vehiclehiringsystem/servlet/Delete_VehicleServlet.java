package com.infinte.vehiclehiringsystem.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.infinte.vehiclehiringsystem.service.VehicleService;
import com.infinte.vehiclehiringsystem.service.VehicleServiceImpl;

/**
 * Servlet implementation class Delete_VehicleServlet
 */
public class Delete_VehicleServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Delete_VehicleServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		RequestDispatcher rd = null;
		String vehicleid = request.getParameter("vehicleid");
		VehicleService service = new VehicleServiceImpl();
		String success = service.deleteVehicle(vehicleid);
		if (success.equals("success")) {
			rd = request.getRequestDispatcher("Update_Delete_VehicleServlet");
			
			
		}
		else {
			rd = request.getRequestDispatcher("Homepage.jsp");
			
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
