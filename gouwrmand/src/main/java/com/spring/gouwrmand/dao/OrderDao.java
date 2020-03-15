package com.spring.gouwrmand.dao;

import java.sql.Date;
import java.util.List;

import com.spring.gouwrmand.entity.Order;

public interface OrderDao {
	public void addOrder(Order o);
	public Order getOrder(int oid);
	public void deleteOrder(int oid);
	public void updateOrder(Order o);
	public List<Order> getMyOrders(int custid,Date from, Date to);
	public List<Order> getOrders(Date from, Date to);
	
	
	
}
