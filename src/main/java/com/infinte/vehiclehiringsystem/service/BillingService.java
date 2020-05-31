package com.infinte.vehiclehiringsystem.service;

import java.util.List;

import com.infinte.vehiclehiringsystem.bean.Billing;

public interface BillingService {
	public String insertBilling(Billing billing);

	public String deleteBilling(int bill_no);

	public String getBilling(int bill_no);

	public String updateBilling(int bill_no);

	public List<Billing> getAllbilling();

	

}
