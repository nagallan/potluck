package com.potluck.sql.dao;

import java.util.List;

import com.potluck.springmvc.model.User;

public interface UserDAO extends BaseDAO<User> {

	public List<User> getAll();
	
	public User findByName(String name);
	
	public boolean delete(String name);
	
	public boolean deleteAll();
	
	public boolean add(User u);

	public int update(User u);

}