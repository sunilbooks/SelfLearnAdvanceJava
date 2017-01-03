package com.sunilbooks.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Handles a transaction during fund-transfer business operation. It transfers
 * amount Rs 1000 from one account to another.
 * 
 * @version 1.0
 * @since 01 June 2015
 * @author Sunil Sahu
 * @Copyright (c) Sunil Sahu
 * @url www.sunilbooks.com
 */

public class TrnHandlingFundTransfer {

	public static void main(String args[]) throws Exception {

		String databaseURL = "jdbc:mysql://localhost/st_adv_java";
		String login = "root";
		String password = "";

		// Load Driver
		Class.forName("com.mysql.jdbc.Driver");

		Connection conn = null;
		Statement stmt = null;

		try {

			// Create Connection
			conn = DriverManager.getConnection(databaseURL, login, password);
			
			// Begin transaction
			conn.setAutoCommit(false);

			// Create Statement
			stmt = conn.createStatement();
			// Transfer fund
			stmt.executeUpdate("UPDATE ACCOUNT SET BALANCE=BALANCE-1000 WHERE ID='2'");
			stmt.executeUpdate("UPDATE ACCOUNT SET BALANCE=BALANCE+1000 WHERE ID='1'");
			
			//conn.commit();

			System.out.print(" Fund successfully transferred!");

		} catch (SQLException e) {
			conn.rollback();
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