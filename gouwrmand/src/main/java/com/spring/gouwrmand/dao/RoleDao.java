package com.spring.gouwrmand.dao;

import com.spring.gouwrmand.entity.Role;

public interface RoleDao {
	
	public void addRole(Role role);

	public void updateRole(Role role);

	public void deleteRole(int role_id);
}
