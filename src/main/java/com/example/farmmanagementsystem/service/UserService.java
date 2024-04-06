package com.example.farmmanagementsystem.service;

import com.example.farmmanagementsystem.model.User;

public interface UserService {

	User getUserById(Long userId);

	User getUserByUsername(String username);

	void saveUser(User user);

	void updateUser(User user);

	void deleteUser(Long userId);
}
