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


import com.infinte.vehiclehiringsystem.bean.Feedback;
import com.infinte.vehiclehiringsystem.utils.DBUtils;

public class FeedbackDAOImpl implements FeedbackDAO{
	private static SessionFactory sessionFactory=DBUtils.getSessionFactory();

	public String insertFeedback(Feedback feedback) {
		Session session=null;
		Transaction transaction=null;
		try {
			session=sessionFactory.openSession();
			transaction=session.beginTransaction();
			
			session.save(feedback);
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

	public String deleteFeedback(int fid) {
		Session session=null;
		Transaction transaction=null;
		try {
			session=sessionFactory.openSession();
			transaction=session.beginTransaction();
			Feedback feedback= session.get(Feedback.class, fid);
			
			
			session.delete(feedback);
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

	public String getFeedback(int fid) {
		Session session=null;
		Transaction transaction=null;
		
	         try {
	         session=sessionFactory.openSession();
	 	     transaction=session.beginTransaction();
	         CriteriaBuilder builder = session.getCriteriaBuilder();
	         CriteriaQuery<Feedback> query = builder.createQuery(Feedback.class);
	         Root<Feedback> root = query.from(Feedback.class);
	         query.select(root).where(builder.equal(root.get("fid"), fid));
	         Query<Feedback> q=session.createQuery(query);
	         @SuppressWarnings("deprecation")
			Feedback feedback=q.getSingleResult();
	         
	         transaction.commit();
	         return feedback.getMessage();
	      } catch (Exception e) {
	         e.printStackTrace();
	         if (transaction != null) {
	            transaction.rollback();
	            return "failure";
	         }
	      }
			return null;
	}

	public String updateFeedBack(int fid) {
		Session session=null;
		Transaction transaction=null;
		try {
			session=sessionFactory.openSession();
			transaction=session.beginTransaction();
			Feedback feedback = (Feedback) session.get(Feedback.class, fid);
			feedback.setCustomerid(2);
			feedback.setMessage("fdh");
			
			
			session.update(feedback);
			
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

	public List<Feedback> getAllFeedback() {
		List<Feedback> feedbacklist = null;
		Transaction transaction = null;
	     Session session = DBUtils.getSessionFactory().openSession();
	     transaction = session.beginTransaction();
	     try {

	    	 CriteriaBuilder builder = session.getCriteriaBuilder();
	         CriteriaQuery<Feedback> query = builder.createQuery(Feedback.class);
	         Root<Feedback> root = query.from(Feedback.class);
	         query.select(root);
	         
			 Query<Feedback> q=session.createQuery(query);
	         feedbacklist=q.getResultList();
	         
	         transaction.commit();
	      }
	     catch (Exception e) {
	         e.printStackTrace();
	         if (transaction != null) {
	            transaction.rollback();
	         }
	   }
	     return feedbacklist;
	}

}
