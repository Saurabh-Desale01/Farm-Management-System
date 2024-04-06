package com.example.farmmanagementsystem.service;

import java.util.List;

import com.example.farmmanagementsystem.model.Role;

public interface RoleService {

	Role getRoleById(Long roleId);

	Role getRoleByName(String roleName);

	List<Role> getAllRoles();
}
