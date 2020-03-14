package com.spring.gouwrmand.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table(name="invoice")
public class Invoice {
	
		@Id
		@Column(name="invoice_id")	
		private int invoice_id;
		
		@Column(name="order_id")	
		private int order_id;
		
		public int getInvoice_id() {
			return invoice_id;
		}

		public void setInvoice_id(int invoice_id) {
			this.invoice_id = invoice_id;
		}

		public int getOrder_id() {
			return order_id;
		}

		public void setOrder_id(int order_id) {
			this.order_id = order_id;
		}

		public String getInvoice_document() {
			return invoice_document;
		}

		public void setInvoice_document(String invoice_document) {
			this.invoice_document = invoice_document;
		}

		@Column(name="invoice_document")	
		private String invoice_document;
		
		
	
}
