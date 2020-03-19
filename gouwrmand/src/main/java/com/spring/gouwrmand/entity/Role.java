package com.spring.gouwrmand.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "role")
public class Role {

	@Id
	@Column(name = "role_id")
	private int role_id;
	

	@Column(name = "role_title")
	private String role_title;

	@Column(name = "role_description")
	private String role_description;
	
	@Column(name = "role_status")
	private int role_status;

	public int getRole_status() {
		return role_status;
	}

	public void setRole_status(int role_status) {
		this.role_status = role_status;
	}

	public int getRole_id() {
		return role_id;
	}

	public void setRole_id(int role_id) {
		this.role_id = role_id;
	}

	public String getRole_title() {
		return role_title;
	}

	public void setRole_title(String role_title) {
		this.role_title = role_title;
	}

	public String getRole_description() {
		return role_description;
	}

	public void setRole_description(String role_description) {
		this.role_description = role_description;
	}

}

//add
//update
//delete
