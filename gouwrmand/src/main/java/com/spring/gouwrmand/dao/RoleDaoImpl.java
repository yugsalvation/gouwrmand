package com.spring.gouwrmand.dao;


import javax.persistence.EntityManager;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.spring.gouwrmand.entity.Customer;
import com.spring.gouwrmand.entity.RestaurantStaff;
import com.spring.gouwrmand.entity.Role;

@Repository
public class RoleDaoImpl implements RoleDao {
	
	@Autowired
	private EntityManager entitymanager;

	@Override
	@Transactional
	public void addRole(Role role) {
		Session session;
		try {
			
			System.out.println(role.getRole_title());
			session = entitymanager.unwrap(Session.class);
			session.save(role);
			//session.close();
		} catch (Exception e) {
			System.out.print("failed add role operation"+e);
		}
//
	}

	@Override
	@Transactional
	public void updateRole(Role role) {
		Session session;
		try {
			session = entitymanager.unwrap(Session.class);
			session.update(role);
			//session.close();
		} catch (Exception e) {
			System.out.print("failed update role operation");
		}

	}

	@Override
	@Transactional
	public void deleteRole(int role_id) {
		Session session;
		try {
			session = entitymanager.unwrap(Session.class);
			Role role = session.load(Role.class, role_id);
			role.setRole_status(0);
			session.update(role);
			//session.close();
		} catch (Exception e) {
			System.out.print("failed add staff operation");
		}

	}

	@Override
	@Transactional
	public Role getRole(int role_id) {
		Session session;
		Role role = null;
		try {
			session = entitymanager.unwrap(Session.class);
			role = session.get(Role.class, role_id);
			//session.close();
		} catch (Exception e) {
			System.out.print("failed update staff operation");///
		}
		return role;
		
	}
//
}
