package com.sunilbooks.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Performs Batch updates
 * 
 * @version 1.0
 * @since 01 June 2015
 * @author Sunil Sahu
 * @Copyright (c) Sunil Sahu
 * @url www.sunilbooks.com
 */

public class CallBatchProcessing {

	static String url = "jdbc:mysql://localhost/st_adv_java";
	static String login = "root";
	static String password = "";

	/**
	 * Loads Database driver. Static block is executed before main method is
	 * called.
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
		executeBatchUsingStatement();
		executeBatchUsingPreparedStatement();
		printPersons();
	}

	/**
	 * Executes batch using Statement object.
	 * 
	 * @throws Exception
	 */
	public static void executeBatchUsingStatement() throws Exception {

		Connection conn = null;
		Statement stmt = null;

		try {

			conn = DriverManager.getConnection(url, login, password);

			stmt = conn.createStatement();
			stmt.addBatch("INSERT into Person (id,name,age) values (101,'Ram',20)");
			stmt.addBatch("INSERT into Person (id,name,age) values (102,'Shyam',25)");
			stmt.addBatch("INSERT into Person (id,name,age) values (103,'Sonu',16)");
			stmt.addBatch("INSERT into Person (id,name,age) values (104,'Monu',18)");

			int[] recordsAffected = stmt.executeBatch();

			for (int i : recordsAffected) {
				System.out.println(i);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			stmt.close();
			conn.close();
		}

	}

	/**
	 * Executes batch using PreparedStatement object.
	 * 
	 * @throws Exception
	 */
	public static void executeBatchUsingPreparedStatement() throws Exception {

		Connection conn = null;
		PreparedStatement stmt = null;

		try {

			conn = DriverManager.getConnection(url, login, password);

			String sql = "INSERT into Person (id,name,age) values (?,?,?)";

			stmt = conn.prepareStatement(sql);

			stmt.setLong(1, 201);
			stmt.setString(2, "Ram");
			stmt.setInt(3, 20);
			stmt.addBatch();

			stmt.setLong(1, 202);
			stmt.setString(2, "Syam");
			stmt.setInt(3, 25);
			stmt.addBatch();

			stmt.setLong(1, 203);
			stmt.setString(2, "Sonu");
			stmt.setInt(3, 16);
			stmt.addBatch();

			stmt.setLong(1, 204);
			stmt.setString(2, "Monu");
			stmt.setInt(3, 18);
			stmt.addBatch();

			int[] recordsAffected = stmt.executeBatch();

			for (int i : recordsAffected) {
				System.out.println(i);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			stmt.close();
			conn.close();
		}

	}

	/**
	 * Prints all records of Person table
	 * 
	 * @throws Exception
	 */
	public static void printPersons() throws Exception {

		Connection conn = DriverManager.getConnection(url, login, password);

		Statement stmt = conn.createStatement();

		ResultSet rs = stmt.executeQuery("SELECT id, name, age FROM person");

		System.out.println("ID\tName\tAge");
		while (rs.next()) {
			System.out.print(rs.getInt(1));
			System.out.print("\t" + rs.getString(2));
			System.out.println("\t" + rs.getInt("Age"));
		}

		stmt.close();
		conn.close();
	}

}