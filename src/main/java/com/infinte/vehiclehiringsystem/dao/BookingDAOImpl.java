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

import com.infinte.vehiclehiringsystem.bean.Booking;
 
import com.infinte.vehiclehiringsystem.utils.DBUtils;

public class BookingDAOImpl implements BookingDAO {
	private static SessionFactory sessionFactory=DBUtils.getSessionFactory();

	public String insertBooking(Booking booking) {
		Session session=null;
		Transaction transaction=null;
		try {
			session=sessionFactory.openSession();
			transaction=session.beginTransaction();
			
			session.save(booking);
			transaction.commit();
			return "sucess";
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

	public String deleteBooking(int bookId) {
		Session session=null;
		Transaction transaction=null;
		try {
			session=sessionFactory.openSession();
			transaction=session.beginTransaction();
			Booking booking= session.get(Booking.class, bookId);
			
			
			session.delete(booking);
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

	public Booking getBooking(int bookId) {
		Transaction transaction=null;
		Booking booking = null;
		Session session = DBUtils.getSessionFactory().openSession();
	    transaction = session.beginTransaction();
		
	         try {
	         session=sessionFactory.openSession();
	 	     transaction=session.beginTransaction();
	         CriteriaBuilder builder = session.getCriteriaBuilder();
	         CriteriaQuery<Booking> query = builder.createQuery(Booking.class);
	         Root<Booking> root = query.from(Booking.class);
	         query.select(root).where(builder.equal(root.get("bookId"), bookId));
	         Query<Booking> q=session.createQuery(query);
	        
	         booking=q.getSingleResult();
	         
	         transaction.commit();
	         return booking;
	      } catch (Exception e) {
	         e.printStackTrace();
	         if (transaction != null) {
	            transaction.rollback();
	            
	         }
	      }
			return null;
	}

	public String updateBooking(int bookId) {
		Session session=null;
		Transaction transaction=null;
		try {
			session=sessionFactory.openSession();
			transaction=session.beginTransaction();
			Booking booking = (Booking) session.get(Booking.class, bookId);
			booking.setDroploc("adfs111");
			booking.setPickuploc("jjj");
			
			
			session.update(booking);
			
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

	public List<Booking> getAllBooking() {
		List<Booking> bookinglist = null;
		Transaction transaction = null;
	     Session session = DBUtils.getSessionFactory().openSession();
	     transaction = session.beginTransaction();
	     try {

	    	 CriteriaBuilder builder = session.getCriteriaBuilder();
	         CriteriaQuery<Booking> query = builder.createQuery(Booking.class);
	         Root<Booking> root = query.from(Booking.class);
	         query.select(root);
	         
			 Query<Booking> q=session.createQuery(query);
	         bookinglist=q.getResultList();
	         
	         transaction.commit();
	      }
	     catch (Exception e) {
	         e.printStackTrace();
	         if (transaction != null) {
	            transaction.rollback();
	         }
	   }
	     return bookinglist;
	}
	

}
