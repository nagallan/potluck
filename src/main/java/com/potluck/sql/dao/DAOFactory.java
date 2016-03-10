package com.potluck.sql.dao;

public class DAOFactory {
	
	private DAOFactory() {}

    private static UserDAO userDAO = null;
    
    public static UserDAO getUserDAO() {
        return userDAO;
    }
    
    static {
        try {
            Class c = Class.forName("UserDAOImpl.class");
            userDAO = (UserDAO) c.newInstance();
            System.out.println("userDAO = " + userDAO);
        } catch (Exception e) {
        	System.out.println("Error returning the DAOFactory." + e.getMessage());
        	System.out.println("Cannot init MemberDAO, about to use the default implementation.");
            userDAO = new UserDAOImpl();
        }
    }
    
    

}
