package com.infinte.vehiclehiringsystem.bean;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "customer")
public class Customer {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int customer_id;
	@Column
	private String name;
	@Column
	private int contact_no;
	@Column
	private String password;
	@Column
	private String email;
	@Column
	private String mobile_no;
	@Column
	private String address;

	@OneToOne(targetEntity = Vehicle.class, cascade = CascadeType.ALL)
	private Booking booking;

	@JoinColumn(name = "customer_id")
	@OneToOne(cascade = CascadeType.ALL)
	private Feedback feedback;

	public Customer() {

	}

	public Customer(int customer_id, String name, int contact_no, String password, String email, String mobile_no,
			String address, Booking booking) {
		super();
		this.customer_id = customer_id;
		this.name = name;
		this.contact_no = contact_no;
		this.password = password;
		this.email = email;
		this.mobile_no = mobile_no;
		this.address = address;
		this.booking = booking;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getContact_no() {
		return contact_no;
	}

	public void setContact_no(int contact_no) {
		this.contact_no = contact_no;
	}

	public int getCustomer_id() {
		return customer_id;
	}

	public void setCustomer_id(int customer_id) {
		this.customer_id = customer_id;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public void setBooking(Booking booking) {
		this.booking = booking;
	}

	public Booking getBooking() {
		return booking;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getMobile_no() {
		return mobile_no;
	}

	public void setMobile_no(String mobile_no) {
		this.mobile_no = mobile_no;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

}
