package com.spring.gouwrmand.dao;

import java.sql.Date;
import java.util.List;

import com.spring.gouwrmand.entity.Invoice;
import com.spring.gouwrmand.entity.Orders;

public interface InvoiceDao {
	public Invoice getInvoice(int invoiceid);
	public void addInvoice(Orders o);
	public List<Invoice> getInvoices(Date from, Date to);
	public void updateInvoice(Invoice in);
	
}
