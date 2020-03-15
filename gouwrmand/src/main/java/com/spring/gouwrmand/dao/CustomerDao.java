package com.spring.gouwrmand.dao;

import java.sql.Date;

import com.spring.gouwrmand.entity.Customer;

public interface CustomerDao {

	public void addCustomer(Customer c);

	public void updateCustomer(Customer c);

	public Customer getCustomer(int customer_id);

	public void deleteCustomer(int customer_id);

	public String getCustReport(int customer_id, Date from, Date to);
}
