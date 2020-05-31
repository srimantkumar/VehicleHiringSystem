package com.infinte.vehiclehiringsystem.utils;

import java.util.HashMap;
import java.util.Map;

import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.SessionFactoryBuilder;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Environment;

import com.infinte.vehiclehiringsystem.bean.Billing;
import com.infinte.vehiclehiringsystem.bean.Booking;
import com.infinte.vehiclehiringsystem.bean.Customer;
import com.infinte.vehiclehiringsystem.bean.Feedback;
import com.infinte.vehiclehiringsystem.bean.Login;
import com.infinte.vehiclehiringsystem.bean.Vehicle;

public class DBUtils {
	private static StandardServiceRegistry registry;
	private static SessionFactory sessionfactory;

	public static SessionFactory getSessionFactory() {

		try {
			StandardServiceRegistryBuilder registryBuilder = new StandardServiceRegistryBuilder();
			Map<String, String> settings = new HashMap<String, String>();
			settings.put(Environment.DRIVER, "com.mysql.jdbc.Driver");
			settings.put(Environment.URL, "jdbc:mysql://localhost:3306/vehicle_hiring_system?useSSL=false");
			settings.put(Environment.USER, "root");
			settings.put(Environment.PASS, "india@123");
			settings.put(Environment.SHOW_SQL, "true");
			settings.put(Environment.HBM2DDL_AUTO, "update");
			settings.put(Environment.DIALECT, "org.hibernate.dialect.MySQLDialect");
			registryBuilder.applySettings(settings);
			registry = registryBuilder.build();
			MetadataSources sources = new MetadataSources(registry);
			sources.addAnnotatedClass(Login.class).addAnnotatedClass(Billing.class).addAnnotatedClass(Feedback.class).addAnnotatedClass(Customer.class).addAnnotatedClass(Booking.class).addAnnotatedClass(Vehicle.class);
			Metadata metadata = sources.buildMetadata();
			SessionFactoryBuilder sessionFactoryBuilder = metadata.getSessionFactoryBuilder();
			sessionfactory = sessionFactoryBuilder.build();
		} catch (Exception e) {
			e.printStackTrace();
			if (registry != null) {
				StandardServiceRegistryBuilder.destroy(registry);

			}
		}
		return sessionfactory;

	}
	public static void shutdown() {
		if (registry != null) {
			StandardServiceRegistryBuilder.destroy(registry);

		}
		
	}

}
