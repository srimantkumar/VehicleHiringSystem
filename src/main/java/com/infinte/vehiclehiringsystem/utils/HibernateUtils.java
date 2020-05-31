package com.infinte.vehiclehiringsystem.utils;

import java.util.HashMap;
import java.util.Map;
import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Environment;
import com.infinte.vehiclehiringsystem.bean.Billing;
import com.infinte.vehiclehiringsystem.bean.Booking;
import com.infinte.vehiclehiringsystem.bean.Customer;
import com.infinte.vehiclehiringsystem.bean.Feedback;
import com.infinte.vehiclehiringsystem.bean.Login;
import com.infinte.vehiclehiringsystem.bean.Vehicle;

public class HibernateUtils {

	private static StandardServiceRegistry registry;
	private static SessionFactory sessionFactory;

	public static SessionFactory getSessionFactory() {
		try {
			StandardServiceRegistryBuilder registryBuilder = new StandardServiceRegistryBuilder();
			Map<String, String> setting = new HashMap<String, String>();
			setting.put(Environment.DRIVER, "com.mysql.jdbc.Driver");
			setting.put(Environment.URL, "jdbc:mysql://localhost:3306/doctorappointmentsystem?useSSL=false");
			setting.put(Environment.USER, "root");
			setting.put(Environment.PASS, "root");
			setting.put(Environment.SHOW_SQL, "true");
			setting.put(Environment.HBM2DDL_AUTO, "update");
			registryBuilder.applySettings(setting);
			registry = registryBuilder.build();
			MetadataSources sources = new MetadataSources(registry);
			sources.addAnnotatedClass(Login.class).addAnnotatedClass(Billing.class).addAnnotatedClass(Feedback.class)
					.addAnnotatedClass(Customer.class).addAnnotatedClass(Booking.class)
					.addAnnotatedClass(Vehicle.class);
			Metadata metadata = sources.buildMetadata();
			sessionFactory = metadata.getSessionFactoryBuilder().build();
		} catch (Exception e) {
			e.printStackTrace();
			if (registry != null) {
				StandardServiceRegistryBuilder.destroy(registry);
			}
		}
		return sessionFactory;
	}

	public static void shutdown() {
		if (registry != null) {
			StandardServiceRegistryBuilder.destroy(registry);
		}
	}
}

