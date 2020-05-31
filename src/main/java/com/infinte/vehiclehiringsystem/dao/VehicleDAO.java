package com.infinte.vehiclehiringsystem.dao;

import java.util.List;

import com.infinte.vehiclehiringsystem.bean.Vehicle;

public interface VehicleDAO {
	
	public String insertVehicle(Vehicle vehicle);

	public String deleteVehicle(String vehicle_id);

	public String updateVehicle(String vehicle_id);

	public Vehicle getVehicle(String vehicle_id);

	public List<Vehicle> getAllVehicles();

}
