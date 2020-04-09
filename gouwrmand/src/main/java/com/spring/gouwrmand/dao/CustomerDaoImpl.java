package com.spring.gouwrmand.dao;


import java.sql.Date;
import java.util.List;

import javax.persistence.EntityManager;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.spring.gouwrmand.entity.Customer;
import com.spring.gouwrmand.entity.Orders;

@Repository
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
			//session.close();
		} catch (Exception e) {
			System.out.print("failed addcustomer operation");
		}

	}

	@Override
	@Transactional
	public void updateCustomer(Customer c) {
		Session session;
		Transaction tx = null;  
		try {
			session = entitymanager.unwrap(Session.class);
//			tx = session.beginTransaction();
			String query="update Customer c set c.name=\'"+c.getName()+"\',c.address=\'"+c.getAddress()+"\',c.date_of_birth=\'"+c.getDate_of_birth()+"\',c.email=\'"+c.getEmail()+"\',c.phone_no="+c.getPhone_no()+" where c.customer_id="+c.getCustomer_id();

		System.out.println(query);
			Query thequery=session.createQuery(query);
			
			int result=thequery.executeUpdate();
			
			session.update(c);
//			tx.commit();
			//session.close();
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
			//session.close();
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
			//session.close();
		} catch (Exception e) {
			System.out.print("failed delete customer operation");
		}
	}

	@Override
	@Transactional
	public List<Orders> getCustReport(int customer_id, Date from, Date to) {
		Session session;
		List<Orders> result = null;
		try {
			session = entitymanager.unwrap(Session.class);
			String query = "from customer c where c.customer_id=\'" + customer_id + "\' and order_date BETWEEN \'"
					+ from + "\' and \'" + to + "\'";
			Query<Orders> theQuery = session.createQuery(query, Orders.class);
			result = theQuery.getResultList();
		} catch (Exception e) {
			System.out.print("failed get customer report operation");
		}
		return result;
	}

	@Override
	public Customer getByEmail(String email) {
		Session session;
		try {
			session = entitymanager.unwrap(Session.class);
			String query = "from customer c where c.email=\'" + email ;
				
			Query theQuery = session.createQuery(query, Customer.class);
//			Customer customer = theQuery.
			//session.close();
		} catch (Exception e) {
			System.out.print("failed delete customer operation");
		}
		return null;
	}

}
