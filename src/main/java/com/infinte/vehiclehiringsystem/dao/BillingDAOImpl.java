package com.infinte.vehiclehiringsystem.dao;

import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.hibernate.HibernateException;
import org.hibernate.query.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.infinte.vehiclehiringsystem.bean.Billing;

import com.infinte.vehiclehiringsystem.utils.DBUtils;

public class BillingDAOImpl implements BillingDAO {
	private static SessionFactory sessionFactory = DBUtils.getSessionFactory();

	public String insertBilling(Billing billing) {
		Session session = null;
		Transaction transaction = null;
		try {
			session = sessionFactory.openSession();
			transaction = session.beginTransaction();

			session.save(billing);
			transaction.commit();
			return "sucess";
		} catch (HibernateException e) {
			e.printStackTrace();
			transaction.rollback();
			return "fail";
		} finally {
			session.close();

		}
	}

	public String deleteBilling(int bill_no) {
		Session session = null;
		Transaction transaction = null;
		try {
			session = sessionFactory.openSession();
			transaction = session.beginTransaction();
			Billing billing = session.get(Billing.class, bill_no);

			session.delete(billing);
			transaction.commit();
			return "sucess";
		} catch (HibernateException e) {
			e.printStackTrace();
		} finally {

			session.close();

		}

		return "failure";
	}

	public String getBilling(int bill_no) {
		Session session = null;
		Transaction transaction = null;

		try {
			session = sessionFactory.openSession();
			transaction = session.beginTransaction();
			CriteriaBuilder builder = session.getCriteriaBuilder();
			CriteriaQuery<Billing> query = builder.createQuery(Billing.class);
			Root<Billing> root = query.from(Billing.class);
			query.select(root).where(builder.equal(root.get("bill_no"), bill_no));
			Query<Billing> q = session.createQuery(query);
			Billing billing = q.getSingleResult();
			transaction.commit();
			return String.valueOf(billing.getTotal_amount());
		} catch (Exception e) {
			e.printStackTrace();
			if (transaction != null) {
				transaction.rollback();
				return "failure";
			}
		}
		return null;
	}

	public String updateBilling(int bill_no) {
		Session session = null;
		Transaction transaction = null;
		try {
			session = sessionFactory.openSession();
			transaction = session.beginTransaction();
			Billing billing =  session.get(Billing.class, bill_no);
			billing.setTotal_amount(233);
			session.update(billing);
			transaction.commit();
			return "sucess";
		} catch (HibernateException e) {
			e.printStackTrace();
			transaction.rollback();
		} finally {
			session.close();

		}
		return "failure";
	}

	public List<Billing> getAllbilling() {
		List<Billing> billinglist = null;
		Transaction transaction = null;
		Session session = DBUtils.getSessionFactory().openSession();
		transaction = session.beginTransaction();
		try {

			CriteriaBuilder builder = session.getCriteriaBuilder();
			CriteriaQuery<Billing> query = builder.createQuery(Billing.class);
			Root<Billing> root = query.from(Billing.class);
			query.select(root);

			Query<Billing> q = session.createQuery(query);
			billinglist = q.getResultList();

			transaction.commit();
		} catch (Exception e) {
			e.printStackTrace();
			if (transaction != null) {
				transaction.rollback();
			}
		}
		return billinglist;
	}

}
