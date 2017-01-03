package com.sunilbooks.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.concurrent.ExecutorService;

/**
 * Contains sample code to depicts usage of Statement.execute(sql) method.
 * 
 * @version 1.0
 * @since 01 June 2015
 * @author Sunil Sahu
 * @Copyright (c) Sunil Sahu
 * @url www.sunilbooks.com
 */

public class CallExecuteMethod {

	/**
	 * Tests sample code.
	 * 
	 * @param args
	 * @throws Exception
	 */

	public static void main(String args[]) throws Exception {
		executeSelect();
		executeUpdate();
		executeDDL();
	}

	/**
	 * Executes SELECT statement and process ResultSet
	 * 
	 * @throws Exception
	 */
	public static void executeSelect() throws Exception {

		Class.forName("com.mysql.jdbc.Driver");

		String url = "jdbc:mysql://localhost/st_adv_java";
		String login = "root";
		String password = "";

		Connection conn = null;
		Statement stmt = null;

		try {

			conn = DriverManager.getConnection(url, login, password);

			stmt = conn.createStatement();

			String sql = "SELECT id, name, age FROM person;";

			boolean status = stmt.execute(sql);

			// Status will be true if ResultSet object is ready to retrieve.
			if (!status) {
				System.out.println("Error : SELECT did not executed !");
			}

			// Retrieve result set object
			ResultSet rs = stmt.getResultSet();

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

		String databaseURL = "jdbc:mysql://localhost/st_adv_java";
		String login = "root";
		String password = "";

		Class.forName("com.mysql.jdbc.Driver");

		Connection conn = null;
		Statement stmt = null;

		try {

			conn = DriverManager.getConnection(databaseURL, login, password);

			stmt = conn.createStatement();

			String sql = "INSERT into Person (id,name,age) values (99,'Ram',25)";

			boolean status = stmt.execute(sql);
			//Get number of records affected.
			int count = stmt.getUpdateCount();

			System.out.println("Status: " + status);
			System.out.println(count + " record(s) added.");

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			stmt.close();
			conn.close();
		}

	}

	/**
	 * Executes DDL Statement
	 */
	public static void executeDDL() {

		try {

			Class.forName("com.mysql.jdbc.Driver");

			Connection conn = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/st_adv_java", "root", "");

			Statement stmt = conn.createStatement();

			String sql = "CREATE  TABLE PERSON (id INT NOT NULL, Name VARCHAR(45), age INT, PRIMARY KEY(id))";

			System.out.println("Creating table...");

			stmt.execute(sql);

			System.out.println("Table created");

		} catch (SQLException e) {
			System.out.println("Error : " + e.getMessage());
		} catch (ClassNotFoundException e) {
			System.out.println("Error : " + e.getMessage());
		}

	}
}