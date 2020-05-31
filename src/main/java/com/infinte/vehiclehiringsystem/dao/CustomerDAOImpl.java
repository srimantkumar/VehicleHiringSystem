package com.infinte.vehiclehiringsystem.dao;

import java.util.Iterator;
import java.util.List;

import javax.persistence.criteria.*;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.infinte.vehiclehiringsystem.bean.Customer;
import com.infinte.vehiclehiringsystem.utils.DBUtils;






public class CustomerDAOImpl implements CustomerDAO {
	private static SessionFactory sessionFactory=DBUtils.getSessionFactory();
	
	
	public String insertCustomer(Customer customer) {
		Session session=null;
		Transaction transaction=null;
		try {
			session=sessionFactory.openSession();
			transaction=session.beginTransaction();
			
			session.save(customer);
			transaction.commit();
			return "success";
		}
		catch(HibernateException e) {
			e.printStackTrace();
			transaction.rollback();
			return "fail";
		}
		finally {
			session.close();
			
		}
	}
	
	public String deleteCustomer(int customer_id) {
		Session session=null;
		Transaction transaction=null;
		try {
			session=sessionFactory.openSession();
			transaction=session.beginTransaction();
			Customer customer= session.get(Customer.class, customer_id);
			
			
			session.delete(customer);
			transaction.commit();
			return "sucess";
		}catch (HibernateException e) {
			e.printStackTrace();
		}
		finally {
			
			session.close();
			
			
		}
		
		return "failure";
		

	}
	public Customer getCustomer(Integer customer_id) {
		
		Transaction transaction=null;
		Customer customer = null;
		Session session = DBUtils.getSessionFactory().openSession();
	    transaction = session.beginTransaction();
		
	         try {
	         
	         CriteriaBuilder builder = session.getCriteriaBuilder();
	         CriteriaQuery<Customer> query = builder.createQuery(Customer.class);
	         Root<Customer> root = query.from(Customer.class);
	         query.select(root).where(builder.equal(root.get("customer_id"), customer_id));
	         Query<Customer> q=session.createQuery(query);
	         customer=q.getSingleResult();
	         
	         transaction.commit();
	         return customer;
	      } catch (Exception e) {
	         e.printStackTrace();
	         if (transaction != null) {
	            transaction.rollback();
	            
	         }
	      }
			return customer;
	      
	}
	public String updateCustomer(Integer customer_id) {
		// TODO Auto-generated method stub
		Session session=null;
		Transaction transaction=null;
		try {
			session=sessionFactory.openSession();
			transaction=session.beginTransaction();
			Customer customer = (Customer) session.get(Customer.class, customer_id);
			customer.setContact_no(13242314);
			customer.setCustomer_id(customer_id);
			customer.setName("gayu");
			customer.setPassword("12343233");
			
			
			session.update(customer);
			
			transaction.commit();
			return "sucess";
		}
		catch (HibernateException e) {
			e.printStackTrace();
			transaction.rollback();
		}
		finally {
			session.close();
			
			
		}
		return "failure";
		
	}

	@SuppressWarnings("deprecation")
	public List<Customer> getAllCustomers() {
		List<Customer> customerlist = null;
		Transaction transaction = null;
	     Session session = DBUtils.getSessionFactory().openSession();
	     transaction = session.beginTransaction();
	     try {

	    	 CriteriaBuilder builder = session.getCriteriaBuilder();
	         CriteriaQuery<Customer> query = builder.createQuery(Customer.class);
	         Root<Customer> root = query.from(Customer.class);
	         query.select(root);
	         
			 Query<Customer> q=session.createQuery(query);
	         customerlist=q.getResultList();
	         transaction.commit();
	      }
	     catch (Exception e) {
	         e.printStackTrace();
	         if (transaction != null) {
	            transaction.rollback();
	         }
	   }
	     return customerlist;
}
	}

	

	
