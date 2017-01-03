package com.sunilbooks.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Depicts usage of PreparedStatement.
 * 
 * @version 1.0
 * @since 01 June 2015
 * @author Sunil Sahu
 * @Copyright (c) Sunil Sahu
 * @url www.sunilbooks.com
 */

public class CallPreparedStatement {

	static String url = "jdbc:mysql://localhost/st_adv_java";
	static String login = "root";
	static String password = "";

	/**
	 * Static block is executed before main method is called.
	 */
	static {
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			System.out.println("Error: MySQL driver class ot found");
		}
	}

	/**
	 * Tests sample code.
	 * 
	 * @param args
	 * @throws Exception
	 */

	public static void main(String args[]) throws Exception {
		executeSelect();
		executeUpdate();
	}

	/**
	 * Executes SELECT statement and process ResultSet
	 * 
	 * @throws Exception
	 */
	public static void executeSelect() throws Exception {

		Connection conn = null;
		PreparedStatement stmt = null;

		try {

			conn = DriverManager.getConnection(url, login, password);

			String sql = "SELECT id, name, age FROM person;";

			stmt = conn.prepareStatement(sql);

			// Retrieve result set object
			ResultSet rs = stmt.executeQuery();

			System.out.println("ID\tName\tAge");
			while (rs.next()) {
				System.out.print(rs.getInt(1));
				System.out.print("\t" + rs.getString(2));
				System.out.println("\t" + rs.getInt("Age"));
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			stmt.close();
			conn.close();

		}

	}

	/**
	 * Executes INSERT statement
	 * 
	 * @throws Exception
	 */
	public static void executeUpdate() throws Exception {

		Connection conn = null;
		PreparedStatement stmt = null;

		try {

			conn = DriverManager.getConnection(url, login, password);

			String sql = "INSERT into Person (id,name,age) values (?,?,?)";

			stmt = conn.prepareStatement(sql);

			stmt.setLong(1, 99);
			stmt.setString(2, "Ram");
			stmt.setInt(3, 25);

			int i = stmt.executeUpdate();

			System.out.println(i + " record(s) added.");

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			stmt.close();
			conn.close();
		}

	}

}