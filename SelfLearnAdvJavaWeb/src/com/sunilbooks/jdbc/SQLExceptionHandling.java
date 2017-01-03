package com.sunilbooks.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * SQLException Handling
 * 
 * @version 1.0
 * @since 01 June 2015
 * @author Sunil Sahu
 * @Copyright (c) Sunil Sahu
 * @url www.sunilbooks.com
 */

public class SQLExceptionHandling {

	public static void main(String args[]) throws Exception {

		String databaseURL = "jdbc:mysql://localhost/st_adv_java";
		String login = "root";
		String password = "";

		String sql = "INSERT into Person (id,name,age) values (1,'Ram',25)";

		// Load Driver
		Class.forName("com.mysql.jdbc.Driver");

		Connection conn = null;
		Statement stmt = null;

		try {

			// Create Connection
			conn = DriverManager.getConnection(databaseURL, login, password);

			// Create Statement
			stmt = conn.createStatement();

			// Execute Query
			int i = stmt.executeUpdate(sql);

			System.out.print(i + " Record(s) inserted");

		} catch (SQLException e) {
			System.out.println("Error: " + e.getMessage());
			System.out.println("SQL State: " + e.getSQLState());
			System.out.println("Error Code: " + e.getErrorCode());
			System.out.println("Cause: " + e.getCause());
			e.printStackTrace();

		} finally {// Close resources
			if (stmt != null) {
				stmt.close();
			}
			if (conn != null) {
				conn.close();
			}
		}

	}

}