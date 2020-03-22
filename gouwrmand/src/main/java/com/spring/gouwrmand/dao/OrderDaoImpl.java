package com.spring.gouwrmand.dao;

import java.sql.Date;
import java.util.List;

import javax.persistence.EntityManager;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.spring.gouwrmand.entity.FoodItem;
import com.spring.gouwrmand.entity.Orders;

@Repository
public class OrderDaoImpl implements OrderDao {
	@Autowired
	private EntityManager entityManager;

	@Override
	public void addOrder(Orders o) {
		// TODO Auto-generated method stub

	}

	@Override
	public Orders getOrder(int oid) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteOrder(int oid) {
		// TODO Auto-generated method stub

	}

	@Override
	public void updateOrder(Orders o) {
		// TODO Auto-generated method stub

	}

	@Override
	public List<Orders> getMyOrders(int custid, Date from, Date to) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	@Transactional
	public List<Orders> getOrders(Date from, Date to) {
		Session currentSession=entityManager.unwrap(Session.class);
		String query="from Order o where o.order_date between \'"+from+"\' and \'"+to+"\'";
		Query <Orders> theQuery=currentSession.createQuery(query,Orders.class);
		List<Orders>l=theQuery.getResultList();
		return l;
	
	}

	
	@Override
	@Transactional
	public List<Orders> getTodayOrders(Date today) {
		Session currentSession=entityManager.unwrap(Session.class);
	
		String query="from Orders o where o.orders_date=\'"+today+"\' and o.order_status=0";
		Query <Orders> theQuery=currentSession.createQuery(query,Orders.class);
		List<Orders>l=theQuery.getResultList();
		return l;
	}

}
