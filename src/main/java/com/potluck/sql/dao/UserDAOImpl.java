package com.potluck.sql.dao;

import java.util.List;

import com.potluck.springmvc.model.User;

public class UserDAOImpl extends BaseDaoImpl<User> implements UserDAO {

	/* (non-Javadoc)
	 * @see com.potluck.sql.dao.UserDAO#getAll()
	 */
	
	public List<User> getAll() {
		return super.find("select * from pl_user");
	}
	
	public User findByName(String name) {
		return super.get("select * from pl_user where name = ?", name);
	}
	
	public boolean delete(String name) {
		return super.delete("delete from pl_user where name = ?", name);
	}
	
	public boolean deleteAll() {
		return super.deleteAll("delete from pl_user");
	}
	
	/* (non-Javadoc)
	 * @see com.potluck.sql.dao.UserDAO#save(com.potluck.springmvc.model.User)
	 */	
	public boolean add(User u) {
		return super.insert("insert into pl_user (name, email, phone) values (?, ?, ?)", u.getName(), u.getEmail(), u.getPhone());
	}

	/* (non-Javadoc)
	 * @see com.potluck.sql.dao.UserDAO#save(com.potluck.springmvc.model.User)
	 */	
	public int update(User u) {
		return super.update("update pl_user set email = ?, phone = ? where name = ?", u.getEmail(), u.getPhone(), u.getName());
	}
}