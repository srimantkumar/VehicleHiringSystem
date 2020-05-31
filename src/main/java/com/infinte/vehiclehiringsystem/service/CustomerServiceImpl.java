package com.infinte.vehiclehiringsystem.service;

import java.util.List;

import com.infinte.vehiclehiringsystem.bean.Customer;
import com.infinte.vehiclehiringsystem.dao.CustomerDAO;
import com.infinte.vehiclehiringsystem.dao.CustomerDAOImpl;

public class CustomerServiceImpl implements CustomerService{
	CustomerDAO customerDAO = new CustomerDAOImpl();

	public String insertCustomer(Customer customer) {
		
		return customerDAO.insertCustomer(customer);
	}

	public String deleteCustomer(int customer_id) {
		// TODO Auto-generated method stub
		return customerDAO.deleteCustomer(customer_id);
	}

	public Customer getCustomer(Integer customer_id) {
		// TODO Auto-generated method stub
		return customerDAO.getCustomer(customer_id);
	}

	public String updateCustomer(Integer customer_id) {
		// TODO Auto-generated method stub
		return customerDAO.updateCustomer(customer_id);
	}

	public List<Customer> getAllCustomers() {
		// TODO Auto-generated method stub
		return customerDAO.getAllCustomers();
	}

}
