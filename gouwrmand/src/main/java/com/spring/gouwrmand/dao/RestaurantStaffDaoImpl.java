package com.spring.gouwrmand.dao;


import javax.persistence.EntityManager;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.spring.gouwrmand.entity.Customer;
import com.spring.gouwrmand.entity.RestaurantStaff;

@Repository
public class RestaurantStaffDaoImpl implements RestaurantStaffDao {

	@Autowired
	private EntityManager entitymanager;
	
	@Override
	@Transactional
	public void addStaff(RestaurantStaff staff) {
		Session session;
		try {
			session = entitymanager.unwrap(Session.class);
			session.save(staff);
			//session.close();
		} catch (Exception e) {
			System.out.print("failed add staff operation");
		}

	}

	@Override
	@Transactional
	public void updateStaff(RestaurantStaff staff) {
		Session session;
		try {
			session = entitymanager.unwrap(Session.class);
			session.update(staff);
//			session.close();
		} catch (Exception e) {
			System.out.print("failed update staff operation");
		}
		
	}

	@Override
	@Transactional
	public RestaurantStaff getRestaurantStaff(int staff_id) {
		Session session;
		RestaurantStaff staff = null;
		try {
			session = entitymanager.unwrap(Session.class);
			staff = session.get(RestaurantStaff.class, staff_id);
//			session.close();
		} catch (Exception e) {
			System.out.print("failed update staff operation");
		}
		return staff;
	}

	@Override
	@Transactional
	public void deleteRestaurantStaff(int staff_id) {
		Session session;
		try {
			session = entitymanager.unwrap(Session.class);
			RestaurantStaff staff = session.load(RestaurantStaff.class, staff_id);
			staff.setStaff_status(0);
			session.update(staff);
//			session.close();
		} catch (Exception e) {
			System.out.print("failed add staff operation");
		}
		
	}

}
