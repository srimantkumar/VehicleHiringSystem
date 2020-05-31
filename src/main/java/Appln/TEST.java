package Appln;

import java.util.Iterator;
import java.util.List;

import com.infinte.vehiclehiringsystem.bean.Billing;
import com.infinte.vehiclehiringsystem.bean.Booking;
import com.infinte.vehiclehiringsystem.bean.Customer;
import com.infinte.vehiclehiringsystem.bean.Vehicle;
import com.infinte.vehiclehiringsystem.service.BillingService;
import com.infinte.vehiclehiringsystem.service.BillingServiceImpl;
import com.infinte.vehiclehiringsystem.service.BookingService;
import com.infinte.vehiclehiringsystem.service.BookingServiceImpl;
import com.infinte.vehiclehiringsystem.service.CustomerService;
import com.infinte.vehiclehiringsystem.service.CustomerServiceImpl;
import com.infinte.vehiclehiringsystem.service.VehicleService;
import com.infinte.vehiclehiringsystem.service.VehicleServiceImpl;

public class TEST {

	public static void main(String[] args) {
		
		  CustomerService customerService = new CustomerServiceImpl(); 
		  
		  
		  
		  Customer customer = new Customer();
		  customer.setContact_no(324);
		  customer.setName("Gayatri");
		  customer.setPassword("infinte");
		  customerService.insertCustomer(customer);
		  
		  
		 
		  
		  
		  
		  
		 
		
		
	}

}
