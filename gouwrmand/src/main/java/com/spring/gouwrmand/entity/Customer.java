package com.spring.gouwrmand.entity;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "customer")
public class Customer {

	@Id
	@Column(name = "customer_id")
	private int customer_id;

	@Column(name = "name")
	private String name;

	@Column(name = "address")
	private String address;

	@Column(name = "date_of_birth")
	private Date date_of_birth;

	@Column(name = "password")
	private String password;

	@Column(name = "email")
	private String email;

	@Column(name = "phone_no")
	private long phone_no;

	@Column(name = "role_id")
	private int role_id;

	@Column(name = "user_status")
	private int user_status;

	public int getCustomer_id() {
		return customer_id;
	}

	public void setCustomer_id(int customer_id) {
		this.customer_id = customer_id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Date getDate_of_birth() {
		return date_of_birth;
	}

	public void setDate_of_birth(Date date_of_birth) {
		this.date_of_birth = date_of_birth;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public long getPhone_no() {
		return phone_no;
	}

	public void setPhone_no(long phone_no) {
		this.phone_no = phone_no;
	}

	public int getRole_id() {
		return role_id;
	}

	public void setRole_id(int role_id) {
		this.role_id = role_id;
	}

	public int getUser_status() {
		return user_status;
	}

	public void setUser_status(int user_status) {
		this.user_status = user_status;
	}

}

//create(cus)
//update(cusobj)
//retrieve(id) return cus
//delete(id), update(cus_status)
//get_cus_report(from to date)

//