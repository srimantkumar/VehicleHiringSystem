package com.infinte.vehiclehiringsystem.bean;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "feedback")
public class Feedback {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int fid;
	 @Column
	private String message;
	 @Column(name="customer_id")
	private int customer_id;
	
	public int getFid() {
		return fid;
	}
	public void setFid(int fid) {
		this.fid = fid;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public int getCustomerid() {
		return customer_id;
	}
	public void setCustomerid(int customerid) {
		this.customer_id = customerid;
	}
	public Feedback(int fid, String message, int customerid) {
		super();
		this.fid = fid;
		this.message = message;
		this.customer_id = customerid;
	}
	public Feedback() {
		super();
	}
	 
	 


}
