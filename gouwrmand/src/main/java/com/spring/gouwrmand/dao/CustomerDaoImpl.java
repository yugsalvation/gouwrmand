package com.spring.gouwrmand.dao;

import java.sql.Date;
import java.util.List;

import javax.persistence.EntityManager;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.spring.gouwrmand.entity.Customer;
import com.spring.gouwrmand.entity.Order;

public class CustomerDaoImpl implements CustomerDao {

	@Autowired
	private EntityManager entitymanager;

	@Override
	@Transactional
	public void addCustomer(Customer c) {
		Session session;
		try {
			session = entitymanager.unwrap(Session.class);
			session.save(c);
			session.close();
		} catch (Exception e) {
			System.out.print("failed addcustomer operation");
		}

	}

	@Override
	@Transactional
	public void updateCustomer(Customer c) {
		Session session;
		try {
			session = entitymanager.unwrap(Session.class);
			session.update(c);
			session.close();
		} catch (Exception e) {
			System.out.print("failed updatecustomer operation");
		}

	}

	@Override
	@Transactional
	public Customer getCustomer(int customer_id) {
		Session session;
		Customer customer = null;
		try {
			session = entitymanager.unwrap(Session.class);
			customer = session.get(Customer.class, customer_id);
			session.close();
		} catch (Exception e) {
			System.out.print("failed updatecustomer operation");
		}
		return customer;
	}

	@Override
	@Transactional
	public void deleteCustomer(int customer_id) {
		Session session;
		try {
			session = entitymanager.unwrap(Session.class);
			Customer customer = session.load(Customer.class, customer_id);
			customer.setUser_status(0);
			session.update(customer);
			session.close();
		} catch (Exception e) {
			System.out.print("failed delete customer operation");
		}
	}

	@Override
	@Transactional
	public List<Order> getCustReport(int customer_id, Date from, Date to) {
		Session session;
		List<Order> result = null;
		try {
			session = entitymanager.unwrap(Session.class);
			String query = "from customer c where c.customer_id=\'" + customer_id + "\' and order_date BETWEEN \'"
					+ from + "\' and \'" + to + "\'";
			Query<Order> theQuery = session.createQuery(query, Order.class);
			result = theQuery.getResultList();
		} catch (Exception e) {
			System.out.print("failed get customer report operation");
		}
		return result;
	}

}
