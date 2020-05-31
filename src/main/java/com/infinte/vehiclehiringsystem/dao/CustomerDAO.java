package com.infinte.vehiclehiringsystem.dao;

import java.util.List;

import com.infinte.vehiclehiringsystem.bean.Customer;

public interface CustomerDAO {
	
	public String insertCustomer(Customer customer);

	public String deleteCustomer(int customer_id);
	
	public Customer getCustomer(Integer customer_id);

	public String updateCustomer(Integer customer_id);


	public List<Customer> getAllCustomers();



}
