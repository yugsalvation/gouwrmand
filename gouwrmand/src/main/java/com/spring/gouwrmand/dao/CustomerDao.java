package com.spring.gouwrmand.dao;

import java.sql.Date;
import java.util.List;

import com.spring.gouwrmand.entity.Customer;
import com.spring.gouwrmand.entity.Orders;

public interface CustomerDao {

	public void addCustomer(Customer c);

	public void updateCustomer(Customer c);

	public Customer getCustomer(int customer_id);

	public void deleteCustomer(int customer_id);

	public List<Orders> getCustReport(int customer_id, Date from, Date to);
	
	public Customer getByEmail(String email);
}
