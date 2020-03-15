package com.spring.gouwrmand.dao;

import java.sql.Date;

import com.spring.gouwrmand.entity.RestaurantStaff;

public interface RestaurantStaffDao {
	
	public void addStaff(RestaurantStaff staff);

	public void updateStaff(RestaurantStaff staff);

	public RestaurantStaff getRestaurantStaff(int staff_id);

	public void deleteRestaurantStaff(int staff_id);
}
