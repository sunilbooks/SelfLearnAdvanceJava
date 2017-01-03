package com.sunilbooks.dcp;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.sql.DataSource;

import com.mchange.v2.c3p0.ComboPooledDataSource;

/**
 * Creates Data Connection Pool (DCP) with help C3P0 library. It depics how to
 * create ComboPooledDataSource object.
 * 
 * Download dependent library from http://www.mchange.com/projects/c3p0/
 * 
 * Dependent jars to compile this program are
 * mysql-connector-java-5.1.36-bin.jar, c3p0-0.9.5.1.jar, and
 * mchange-commons-java-0.2.10.jar
 * 
 * @version 1.0
 * @since 01 June 2015
 * @author Sunil Sahu
 * @Copyright (c) Sunil Sahu
 * @url www.sunilbooks.com
 */
public class C3P0DataSource {

	/**
	 * Creates Data Source (DCP) connection.
	 * 
	 * @return
	 */
	public static DataSource createDCP() throws Exception {
		// Create data source
		ComboPooledDataSource ds = new ComboPooledDataSource();
		// Set DS Properties
		ds.setDriverClass("com.mysql.jdbc.Driver");
		ds.setJdbcUrl("jdbc:mysql://localhost/st_adv_java");
		ds.setUser("root");
		ds.setPassword("");
		ds.setInitialPoolSize(5); // Minimum number of connections
		ds.setAcquireIncrement(5); // Increament connection when more users
		ds.setMaxPoolSize(50); // Maximum number of connections
		return ds;
	}

	/**
	 * Test Datasource
	 * 
	 * @param args
	 * @throws Exception
	 */
	public static void main(String[] args) throws Exception {

		String sql = "SELECT id, name, age FROM person;";

		// Create connection pool
		DataSource ds = createDCP();

		// Get connection from pool
		Connection conn = ds.getConnection();

		Statement stmt = conn.createStatement();

		ResultSet rs = stmt.executeQuery(sql);

		System.out.println("DB Pool Connection");
		System.out.println("ID\tName\tAge");
		while (rs.next()) {
			System.out.print(rs.getInt(1));
			System.out.print("\t" + rs.getString(2));
			System.out.println("\t" + rs.getInt("Age"));
		}
		// Return connection to pool
		conn.close();
	}
}
