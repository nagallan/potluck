package com.potluck.sql.dao;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

interface BaseDAO<T> {
	
	/**
	 * Executes the given SELECT SQL query and returns a result list object. 
	 * @param sql sql for create PreparedStatement
	 * @param params PreparedStatement params
	 * @return find result list or null on failure.
	 */
	public List<T> find(String sql, Object... params);
	
	/**
	 * Executes the given SELECT SQL query and returns a result object. 
	 * @param sql sql for create PreparedStatement
	 * @param params PreparedStatement params
	 * @return get result object or null on failure.
	 */
	public T get(String sql, Object... params);
	
	/**
	 * Executes the given UPDATE SQL statement.
	 * @param sql sql for create PreparedStatement
	 * @param params PreparedStatement params
	 * @return The number of rows updated or -1 on failure.
	 */
	public int update(String sql, Object... params);
	
	/**
	 * Executes the given INSERT SQL statement. 
	 * @param sql sql for create PreparedStatement
	 * @param params PreparedStatement params
	 * @return trur on success or false on failure.
	 */
	public boolean insert(String sql, Object... params);
	
	/**
	 * Executes the given delete SQL statement. 
	 * @param sql sql for create PreparedStatement
	 * @param params PreparedStatement params
	 * @return trur on success or false on failure.
	 */
	public boolean delete(String sql, Object... params);
	
	/**
	 * Executes the given delete SQL statement. 
	 * @param sql sql for create PreparedStatement
	 * @param params PreparedStatement params
	 * @return trur on success or false on failure.
	 */
	public boolean deleteAll(String sql);

	
	/**
	 * Executes the given INSERT SQL statement. 
	 * @param sql sql for create PreparedStatement
	 * @param params PreparedStatement params
	 * @return generated key or -1 on failure or 0 for none keys was generated.
	 */
	public Object save(String sql, Object... params);
	
	public List<Map<String, Object>> executeQuery(String sql, Object... params) throws SQLException ;

}