package com.potluck.springmvc.service;

import java.util.List;

import com.potluck.springmvc.model.User;



public interface UserService {	
	
	User findByName(String name);
	
	void saveUser(User user);
	
	void updateUser(User user);
	
	void deleteUser(String name);

	List<User> findAllUsers(); 
	
	void deleteAllUsers();
	
	public boolean isUserExist(User user);
	
}
