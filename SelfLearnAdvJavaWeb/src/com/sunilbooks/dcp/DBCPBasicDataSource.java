package com.sunilbooks.dcp;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.sql.DataSource;

import org.apache.commons.dbcp2.BasicDataSource;

/**
 * Creates Data Connection Pool (DCP) with help DBCP library. It depics how to
 * create BasicDataSource object.
 * 
 * Download dependent library from
 * https://commons.apache.org/proper/commons-dbcp/download_dbcp.cgi
 * 
 * Dependent jars to compile this program are
 * mysql-connector-java-5.1.36-bin.jar, commons-dbcp2-2.1.1.jar,
 * commons-pool2-2.4.2.jar, commons-logging-1.2.jar
 * 
 * @version 1.0
 * @since 01 June 2015
 * @author Sunil Sahu
 * @Copyright (c) Sunil Sahu
 * @url www.sunilbooks.com
 */
public class DBCPBasicDataSource {

	/**
	 * Creates Data Source (DCP) connection.
	 * 
	 * @return
	 */
	public static DataSource createDCP() {

		// Create data source
		BasicDataSource ds = new BasicDataSource();

		// Set DS Properties
		ds.setDriverClassName("com.mysql.jdbc.Driver");
		ds.setUrl("jdbc:mysql://localhost/st_adv_java");
		ds.setUsername("root");
		ds.setPassword("");
		ds.setInitialSize(5); // Minimum number of connections
		ds.setMaxTotal(50); // Maximum number of connections

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
		//Return connection to pool
		conn.close();
	}
}
