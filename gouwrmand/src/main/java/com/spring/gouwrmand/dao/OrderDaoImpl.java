
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
import com.spring.gouwrmand.entity.Invoice;

import com.spring.gouwrmand.entity.Orders;



@Repository
public class OrderDaoImpl implements OrderDao {
	@Autowired
	private EntityManager entityManager;

	@Override
	@Transactional
	public void addOrder(Orders o) {
		Session session;
		try {
			
			session = entityManager.unwrap(Session.class);
			
			int id=(Integer)session.save(o);
			System.out.println(id);

			
			
		} catch (Exception e) {
			System.out.print("failed addcustomer operation");
			
		}
	
	}
	@Override
	@Transactional
	public Orders getOrder(int oid) {
		Session currentSession=entityManager.unwrap(Session.class);
		String query="from Orders o where o.order_id="+oid;
		Query<Orders>theQuery=currentSession.createQuery(query,Orders.class);
		Orders o=theQuery.getSingleResult();
		return o;
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
	public List<Orders> getMyOrders(int cid) {
		Session currentSession=entityManager.unwrap(Session.class);
		String query="from Orders o where o.customer_id="+cid;
		Query <Orders> theQuery=currentSession.createQuery(query,Orders.class);
		List<Orders>l=theQuery.getResultList();
		return l;
	}

	@Override
	@Transactional
	public List<Orders> getOrders(Date from, Date to) {
		Session currentSession=entityManager.unwrap(Session.class);
		String query="from Orders o where o.order_date between \'"+from+"\' and \'"+to+"\'";
		Query <Orders> theQuery=currentSession.createQuery(query,Orders.class);
		List<Orders>l=theQuery.getResultList();
		return l;
	
	}

	
	@Override
	@Transactional
	public List<Orders> getTodayOrders(Date today) {
		Session currentSession=entityManager.unwrap(Session.class);
	
		String query="from Orders o where o.order_date=\'"+today+"\' and o.order_status=0  order by order_id";
		Query <Orders> theQuery=currentSession.createQuery(query,Orders.class);
		List<Orders>l=theQuery.getResultList();
		return l;
	}

	@Override
	@Transactional
	public void changeStatustoReady(int oid) {
		Session currentSession=entityManager.unwrap(Session.class);
		String query="update Orders o set o.order_status=1 where o.order_id="+oid;
		
		Query thequery=currentSession.createQuery(query);
		
		int result=thequery.executeUpdate();
		
	}
	
	@Override
	public List<Orders> getAllOrder() {
		Session currentSession=entityManager.unwrap(Session.class);
		String query="from Orders";
		Query <Orders> theQuery=currentSession.createQuery(query,Orders.class);
		List<Orders>l=theQuery.getResultList();
		return l;
	}

}

