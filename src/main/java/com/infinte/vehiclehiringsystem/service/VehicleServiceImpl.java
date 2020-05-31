package com.infinte.vehiclehiringsystem.service;
import java.util.List;

import com.infinte.vehiclehiringsystem.bean.Vehicle;
import com.infinte.vehiclehiringsystem.dao.VehicleDAO;
import com.infinte.vehiclehiringsystem.dao.VehicleDAOImpl;

public class VehicleServiceImpl implements VehicleService {
	private VehicleDAO vehicleDAO=new VehicleDAOImpl();
	public String insertVehicle(Vehicle vehicle) {
		
		return vehicleDAO.insertVehicle(vehicle);
	}

	public String deleteVehicle(String vehicle_id) {
		// TODO Auto-generated method stub
		return vehicleDAO.deleteVehicle(vehicle_id);
	}

	public String updateVehicle(String vehicle_id) {
		// TODO Auto-generated method stub
		return vehicleDAO.updateVehicle(vehicle_id);
	}

	public Vehicle getVehicle(String vehicle_id) {
		// TODO Auto-generated method stub
		return vehicleDAO.getVehicle(vehicle_id);
	}

	public List<Vehicle> getAllVehicles() {
		// TODO Auto-generated method stub
		return vehicleDAO.getAllVehicles();
	}
	
}
