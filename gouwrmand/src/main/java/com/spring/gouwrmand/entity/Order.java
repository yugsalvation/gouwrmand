package com.spring.gouwrmand.entity;

import javax.persistence.Column;
import javax.persistence.Id;

public class Order {
	@Id
	@Column(name="order_id")	
	private int order_id;
	
	@Column(name="order_cart")	
	private String order_cart;
	
	@Column(name="order_total")	
	private double order_total;
	
	@Column(name="payment_status")	
	private int payment_status;
	
	@Column(name="order_status")	
	private int order_status;
	
	@Column(name="item_quantity")	
	private String item_quantity;
	
	public int getOrder_id() {
		return order_id;
	}

	public void setOrder_id(int order_id) {
		this.order_id = order_id;
	}

	public String getOrder_cart() {
		return order_cart;
	}

	public void setOrder_cart(String order_cart) {
		this.order_cart = order_cart;
	}

	public double getOrder_total() {
		return order_total;
	}

	public void setOrder_total(double order_total) {
		this.order_total = order_total;
	}

	public int getPayment_status() {
		return payment_status;
	}

	public void setPayment_status(int payment_status) {
		this.payment_status = payment_status;
	}

	public int getOrder_status() {
		return order_status;
	}

	public void setOrder_status(int order_status) {
		this.order_status = order_status;
	}

	public String getItem_quantity() {
		return item_quantity;
	}

	public void setItem_quantity(String item_quantity) {
		this.item_quantity = item_quantity;
	}

	public String getCustomer_id() {
		return customer_id;
	}

	public void setCustomer_id(String customer_id) {
		this.customer_id = customer_id;
	}

	@Column(name="customer_id")	
	private String customer_id;
	
	
}
