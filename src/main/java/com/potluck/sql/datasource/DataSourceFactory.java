package com.potluck.sql.datasource;

import java.io.PrintWriter;

import javax.sql.ConnectionPoolDataSource;
import javax.sql.DataSource;

public class DataSourceFactory {

	private static final Object lock = new Object();
	private static DataSource dataSource;
	
	/**	 
	 * @param dataSource
	 */
	public static void initDataSource() {
		synchronized (lock) {
			if (dataSource == null) {
				dataSource = (DataSource)createDataSource();
			}
		}
	}
	
	public static DataSource getDataSource() {
		if (dataSource == null) {
			initDataSource();
		}
		return dataSource;
	}

	public static ConnectionPoolDataSource createDataSource() {
		
		try {
	
	   // Version for H2:
	     // org.h2.jdbcx.JdbcDataSource dataSource = new org.h2.jdbcx.JdbcDataSource();
	      // dataSource.setURL("jdbc:h2:file:c:/work/potluck/potluck/db/h2PotluckDb");
	      //dataSource.setURL("jdbc:h2:mem:test;DB_CLOSE_DELAY=-1");    // in-memory database
	
	   // Version for Apache Derby:
	   /*
	      org.apache.derby.jdbc.EmbeddedConnectionPoolDataSource dataSource = new org.apache.derby.jdbc.EmbeddedConnectionPoolDataSource();
	      dataSource.setDatabaseName("c:/temp/tempTestMiniConnectionPoolManagerDb");
	      dataSource.setCreateDatabase("create");
	      dataSource.setLogWriter(new PrintWriter(System.out));
	   */
	
	   // Version for JTDS:
	   /*
	      net.sourceforge.jtds.jdbcx.JtdsDataSource dataSource = new net.sourceforge.jtds.jdbcx.JtdsDataSource();
	      dataSource.setAppName("TestMiniConnectionPoolManager");
	      dataSource.setDatabaseName("Northwind");
	      dataSource.setServerName("localhost");
	      dataSource.setUser("sa");
	      dataSource.setPassword(System.getProperty("saPassword"));
	   */
	
	   // Version for the Microsoft SQL Server driver (sqljdbc.jar):
	   
	      com.microsoft.sqlserver.jdbc.SQLServerXADataSource dataSource = new com.microsoft.sqlserver.jdbc.SQLServerXADataSource();
	      dataSource.setApplicationName("PotLuckConnectionPoolManager");
	      dataSource.setDatabaseName("potluckDB");
	      dataSource.setServerName("localhost");
	      dataSource.setInstanceName("EDM5000");
	      //dataSource.setPortNumber(1433);
	      dataSource.setUser("potluckAdmin");
	      dataSource.setPassword("zaq12345");
	      dataSource.setLogWriter(new PrintWriter(System.out));   
	
	   // Version for Oracle:
	   /*
	      oracle.jdbc.pool.OracleConnectionPoolDataSource dataSource = new oracle.jdbc.pool.OracleConnectionPoolDataSource();
	      dataSource.setDriverType("thin");
	      dataSource.setServerName("vm1");
	      dataSource.setPortNumber(1521);
	      dataSource.setServiceName("vm1.inventec.ch");
	      dataSource.setUser("system");
	      dataSource.setPassword("x");
	   */
	
	      return dataSource; 
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

} // end class DataSourceFactory