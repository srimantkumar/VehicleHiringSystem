package com.infinte.vehiclehiringsystem.bean;


import java.util.Date;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "booking")
public class Booking {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int bookId;
	@Column
	private String pickuploc;
	@Column
	private String droploc;
	@Column
	private Date to_time;
	@Column
	private Date from_time;

	@OneToOne
	private Customer customer;

	@OneToOne
	private Vehicle vehicle;

	public Booking() {
		super();
	}

	public int getBookId() {
		return bookId;
	}

	public Date getTo_time() {
		return to_time;
	}

	public void setTo_time(Date to_time) {
		this.to_time = to_time;
	}

	public Date getFrom_time() {
		return from_time;
	}

	public void setFrom_time(Date from_time) {
		this.from_time = from_time;
	}

	public void setBookId(int bookId) {
		this.bookId = bookId;
	}

	public String getPickuploc() {
		return pickuploc;
	}

	public void setPickuploc(String pickuploc) {
		this.pickuploc = pickuploc;
	}

	public String getDroploc() {
		return droploc;
	}

	public void setDroploc(String droploc) {
		this.droploc = droploc;
	}

	public void setVehicle(Vehicle vehicle) {
		this.vehicle = vehicle;
	}

	public Vehicle getVehicle() {
		return vehicle;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

}
