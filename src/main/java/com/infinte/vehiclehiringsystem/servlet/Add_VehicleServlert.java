package com.infinte.vehiclehiringsystem.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.infinte.vehiclehiringsystem.bean.Vehicle;
import com.infinte.vehiclehiringsystem.service.VehicleService;
import com.infinte.vehiclehiringsystem.service.VehicleServiceImpl;

/**
 * Servlet implementation class Add_VehicleServlert
 */
public class Add_VehicleServlert extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Add_VehicleServlert() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		  
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter printWriter = response.getWriter();
		RequestDispatcher dispatcher;
		String vehicleid = request.getParameter("vehicleid"); 
		int nos =Integer.parseInt(request.getParameter("noOfSeats"));
		
		
		
		  Vehicle vehicle = new Vehicle(); vehicle.setNoOfSeats(nos);
		  vehicle.setVehicleNo(1); vehicle.setVehicleid(vehicleid);
		  
		  VehicleService service = new VehicleServiceImpl(); String success =
		  service.insertVehicle(vehicle); if (success.equals("success")) { dispatcher =
		  request.getRequestDispatcher("Update_Delete_VehicleServlet");
		  
		  
		  } else { dispatcher = request.getRequestDispatcher("Booked.jsp");
		  
		  } dispatcher.forward(request, response);
		 
	}

}
