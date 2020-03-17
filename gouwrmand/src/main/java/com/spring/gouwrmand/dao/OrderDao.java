package com.spring.gouwrmand.dao;

import java.sql.Date;
import java.util.List;

import com.spring.gouwrmand.entity.Order;

public interface OrderDao {
	public void addOrder(Order o);
	public Order getOrder(String oid);
	public void deleteOrder(String oid);
	public void updateOrder(Order o);
	public List<Order> getMyOrders(String custid,Date from, Date to);
	public List<Order> getOrders(Date from, Date to);
	
	
	
}
