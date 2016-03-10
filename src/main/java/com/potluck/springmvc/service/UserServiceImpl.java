package com.potluck.springmvc.service;

import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.potluck.springmvc.model.User;
import com.potluck.sql.dao.DAOFactory;
import com.potluck.sql.dao.UserDAO;

@Service("userService")
@Transactional
public class UserServiceImpl implements UserService {
	
	private static final AtomicLong counter = new AtomicLong();
	private UserDAO userDAO = DAOFactory.getUserDAO();
	
	
	public List<User> findAllUsers() {
		 return userDAO.getAll();
	}
	
	public User findByName(String name) {		
		return userDAO.findByName(name);
	}
	
	public void saveUser(User user) {
		userDAO.add(user);
	}

	public void updateUser(User user) {
		userDAO.update(user);
	}

	public void deleteUser(String name) {		
		userDAO.delete(name);
	}

	public boolean isUserExist(User user) {
		return findByName(user.getName())!=null;
	}
	
	public void deleteAllUsers(){
		userDAO.deleteAll();
	}
	
}
