package com.spring.gouwrmand.dao;

import com.spring.gouwrmand.entity.Cart;
import com.spring.gouwrmand.entity.Customer;

public interface CartDao {
	public void addCart(int customer_id);
	
	public void updateCart(Cart cart);
	
	public Cart getCart(int customer_id);
}
