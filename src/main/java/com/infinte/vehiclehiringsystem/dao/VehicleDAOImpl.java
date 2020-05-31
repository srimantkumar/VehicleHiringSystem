package com.infinte.vehiclehiringsystem.dao;


	import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
	import org.hibernate.SessionFactory;
	import org.hibernate.Transaction;


import com.infinte.vehiclehiringsystem.bean.Vehicle;
import com.infinte.vehiclehiringsystem.utils.DBUtils;

	public class VehicleDAOImpl implements VehicleDAO {
		private static SessionFactory sessionFactory = DBUtils.getSessionFactory();

		public String insertVehicle(Vehicle vehicle) {
			Session session = null;
			Transaction transaction = null;
			try {
				session = sessionFactory.openSession();
				transaction = session.beginTransaction();

				session.save(vehicle);
				transaction.commit();
				return "success";
			} catch (HibernateException e) {
				e.printStackTrace();
				return "fail";
			} finally {
				session.close();
			}
		}

		public String deleteVehicle(String vehicleid) {
			Session session=null;
			Transaction transaction=null;
			try {
				session=sessionFactory.openSession();
				transaction=session.beginTransaction();
				Vehicle vehicle= session.get(Vehicle.class, vehicleid);
				
				
				session.delete(vehicle);
				transaction.commit();
				return "success";
			}catch (HibernateException e) {
				e.printStackTrace();
			}
			finally {
				
				session.close();
				
				
			}
			
			return "failure";
		}


		public String updateVehicle(String vehicle_id) {
	    Session session =null;
			
			try {			
				session= sessionFactory.openSession();
				session.getTransaction().begin();
				session.update(vehicle_id);
				session.getTransaction().commit();
				return "success";
				
			}catch (HibernateException e){
				e.printStackTrace();
				return "fail";
			}
			finally{
				session.close();
			}
		}
	 

		public Vehicle getVehicle(String vehicle_id) {
			
			Transaction transaction=null;
			Vehicle vehicle = null;
			Session session = DBUtils.getSessionFactory().openSession();
		    transaction = session.beginTransaction();
			
			
			
		         try {		         	 	    
		         CriteriaBuilder builder = session.getCriteriaBuilder();
		         CriteriaQuery<Vehicle> query = builder.createQuery(Vehicle.class);
		         Root<Vehicle> root = query.from(Vehicle.class);
		         query.select(root).where(builder.equal(root.get("vehicleid"), vehicle_id));
		         Query<Vehicle> q=session.createQuery(query);
		         vehicle=q.getSingleResult();
		         
		         transaction.commit();
		         return vehicle;
		      } catch (Exception e) {
		         e.printStackTrace();
		         if (transaction != null) {
		            transaction.rollback();
		            
		         }
		      }
				return vehicle;
		}
		@SuppressWarnings("deprecation")

		public List<Vehicle> getAllVehicles() {
			List<Vehicle> vehiclelist = null;
			Transaction transaction=null;
			
			Session session = DBUtils.getSessionFactory().openSession();
		    transaction = session.beginTransaction();
		     try {

		    	 CriteriaBuilder builder = session.getCriteriaBuilder();
		         CriteriaQuery<Vehicle> query = builder.createQuery(Vehicle.class);
		         Root<Vehicle> root = query.from(Vehicle.class);
		         query.select(root);
		         
				 Query<Vehicle> q=session.createQuery(query);
		         vehiclelist=q.getResultList();
		         
		         transaction.commit();
		      }
		     catch (Exception e) {
		         e.printStackTrace();
		         if (transaction != null) {
		            transaction.rollback();
		         }
		   }
		     return vehiclelist;
	}

	}



