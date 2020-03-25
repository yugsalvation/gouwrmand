package com.spring.gouwrmand.entity;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "cart")
public class Cart {
	@Id
	@Column(name = "cart_id")
	private int order_id;
	
	@Column(name = "customer_id")
	private int customer_id;

	@Column(name = "order_cart")
	private String order_cart;
	
	@Column(name = "item_quantity")
	private String item_quantity;

	@Column(name = "last_update")
	private Date lastUpdate;

	@Column(name = "total")
	private double total;

	public int getOrder_id() {
		return order_id;
	}

	public void setOrder_id(int order_id) {
		this.order_id = order_id;
	}

	public int getCustomer_id() {
		return customer_id;
	}

	public void setCustomer_id(int customer_id) {
		this.customer_id = customer_id;
	}

	public String getOrder_cart() {
		return order_cart;
	}

	public void setOrder_cart(String order_cart) {
		this.order_cart = order_cart;
	}

	public String getItem_quantity() {
		return item_quantity;
	}

	public void setItem_quantity(String item_quantity) {
		this.item_quantity = item_quantity;
	}

	public Date getLastUpdate() {
		return lastUpdate;
	}

	public void setLastUpdate(Date lastUpdate) {
		this.lastUpdate = lastUpdate;
	}

	public double getTotal() {
		return total;
	}

	public void setTotal(double total) {
		this.total = total;
	}

	
	
}
