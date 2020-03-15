package com.spring.gouwrmand.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="fooditem")
public class FoodItem {
	@Id
	@Column(name="food_id")	
	private int food_id;
	
	@Column(name="food_type")	
	private int food_type;
	
	public int getFood_id() {
		return food_id;
	}

	public void setFood_id(int food_id) {
		this.food_id = food_id;
	}

	public int getFood_type() {
		return food_type;
	}

	public void setFood_type(int food_type) {
		this.food_type = food_type;
	}

	public int getFood_name() {
		return food_name;
	}

	public void setFood_name(int food_name) {
		this.food_name = food_name;
	}

	public double getFood_price() {
		return food_price;
	}

	public void setFood_price(double food_price) {
		this.food_price = food_price;
	}

	

	public int getFood_description() {
		return food_description;
	}

	public void setFood_description(int food_description) {
		this.food_description = food_description;
	}

	public int getFood_status() {
		return food_status;
	}

	public void setFood_status(int food_status) {
		this.food_status = food_status;
	}

	@Column(name="food_name")	
	private int food_name;
	
	@Column(name="food_price")	
	private double food_price;
	
	@Column(name="food_discount")	
	private double food_discount;
	
	@Column(name="food_description")	
	private int food_description;
	
	@Column(name="food_status")	
	private int food_status;
}
