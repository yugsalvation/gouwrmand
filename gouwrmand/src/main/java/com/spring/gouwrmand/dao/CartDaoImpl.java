package com.spring.gouwrmand.dao;

import javax.persistence.EntityManager;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.spring.gouwrmand.entity.Cart;
import com.spring.gouwrmand.entity.Customer;

@Repository
public class CartDaoImpl implements CartDao {

	@Autowired
	private EntityManager entitymanager;
	
	@Override
	@Transactional
	public void addCart(int customer_id) {
		// TODO Auto-generated method stub

	}

	@Override
	@Transactional
	public void updateCart(Cart cart) {
		// TODO Auto-generated method stub

	}

	@Override
	@Transactional
	public Cart getCart(int customer_id) {
		Session session;
		Cart cart = null;
		try {
			session = entitymanager.unwrap(Session.class);
			cart = session.get(Cart.class, customer_id);
			//session.close();
		} catch (Exception e) {
			System.out.print("failed updatecustomer operation");
		}
		return cart;
		
	}

}
