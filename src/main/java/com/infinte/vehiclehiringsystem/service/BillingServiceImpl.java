package com.infinte.vehiclehiringsystem.service;

import java.util.List;

import com.infinte.vehiclehiringsystem.bean.Billing;
import com.infinte.vehiclehiringsystem.dao.BillingDAO;
import com.infinte.vehiclehiringsystem.dao.BillingDAOImpl;

public class BillingServiceImpl implements BillingService {
	BillingDAO billingDAO = new BillingDAOImpl();

	public String insertBilling(Billing billing) {
		// TODO Auto-generated method stub
		return billingDAO.insertBilling(billing);
	}

	public String deleteBilling(int bill_no) {
		// TODO Auto-generated method stub
		return billingDAO.deleteBilling(bill_no);
	}

	public String getBilling(int bill_no) {
		// TODO Auto-generated method stub
		return billingDAO.deleteBilling(bill_no);
	}

	public String updateBilling(int bill_no) {
		// TODO Auto-generated method stub
		return billingDAO.updateBilling(bill_no);
	}

	public List<Billing> getAllbilling() {
		// TODO Auto-generated method stub
		return billingDAO.getAllbilling();
	}

}
