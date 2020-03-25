package com.spring.gouwrmand.entity;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "orders")
public class Orders {
	@Id
	@Column(name = "order_id")
	private int order_id;

	@Column(name = "order_cart")
	private String order_cart;

	@Column(name = "order_total")
	private double order_total;

	@Column(name = "payment_status")
	private int payment_status;

	@Column(name = "order_status")
	private int order_status;

	@Column(name = "item_quantity")
	private String item_quantity;
	
	@Column(name = "customer_id")
	private int customer_id;
	
	@Column(name = "order_date")
	private Date order_date;


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

	public int getCustomer_id() {
		return customer_id;
	}

	public void setCustomer_id(int customer_id) {
		this.customer_id = customer_id;
	}

	
	public Date getOrder_date() {
		return order_date;
	}

	public void setOrder_date(Date order_date) {
		this.order_date = order_date;
	}
	
	

}


//add
//get order
//delete
//update
//get myorders(cust id from to)
//get orders(from to)
