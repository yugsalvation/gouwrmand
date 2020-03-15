package com.spring.gouwrmand.dao;

import java.sql.Date;
import java.util.List;

import com.spring.gouwrmand.entity.Invoice;

public interface InvoiceDao {
	public Invoice getInvoice(int invoiceid);
	public void addInvoice(Invoice in);
	public List<Invoice> getInvoices(Date from, Date to);
	public void updateInvoice(Invoice in);
	
}
