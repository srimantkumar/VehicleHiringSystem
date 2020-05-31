package com.infinte.vehiclehiringsystem.bean;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;


@Entity
@Table(name = "vehicle")
public class Vehicle {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private String vehicleid;
	@Column
	private int noOfSeats;
	@Column
	private int vehicleFare;
	@Column
	private int vehicleNo;
	@Column
	private int vehicleType;
	@Column
	private int vehicleName;
	
	@OneToOne(targetEntity =Customer.class)
    private Booking booking;

	public Vehicle() {

	}

	public String getVehicleid() {
		return vehicleid;
	}

	public void setVehicleid(String vehicleid) {
		this.vehicleid = vehicleid;
	}

	public int getNoOfSeats() {
		return noOfSeats;
	}

	public void setNoOfSeats(int noOfSeats) {
		this.noOfSeats = noOfSeats;
	}

	public int getVehicleFare() {
		return vehicleFare;
	}

	public void setVehicleFare(int vehicleFare) {
		this.vehicleFare = vehicleFare;
	}

	public int getVehicleNo() {
		return vehicleNo;
	}

	public void setVehicleNo(int vehicleNo) {
		this.vehicleNo = vehicleNo;
	}

	public int getVehicleType() {
		return vehicleType;
	}

	public void setVehicleType(int vehicleType) {
		this.vehicleType = vehicleType;
	}

	public int getVehicleName() {
		return vehicleName;
	}

	public void setVehicleName(int vehicleName) {
		this.vehicleName = vehicleName;
	}

	public Booking getBooking() {
		return booking;
	}

	public void setBooking(Booking booking) {
		this.booking = booking;
	}

	

}
