package com.sunilbooks.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Inserts a record
 * 
 * @version 1.0
 * @since 01 June 2015
 * @author Sunil Sahu
 * @Copyright (c) Sunil Sahu
 * @url www.sunilbooks.com
 */

public class InsertRecord {

	public static void main(String args[]) throws Exception {

		String databaseURL = "jdbc:mysql://localhost/st_adv_java";
		String login = "root";
		String password = "";

		Class.forName("com.mysql.jdbc.Driver");

		Connection conn = null;
		Statement stmt = null;

		try {

			conn = DriverManager.getConnection(databaseURL, login, password);

			stmt = conn.createStatement();

			int i = stmt
					.executeUpdate("INSERT into Person (id,name,age) values (1,'Ram',25)");

			System.out.print(i + " Record(s) Updated");

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			stmt.close();
			conn.close();

		}

	}

	/**
	 * Executes INSERT statement with help of Prepared Statement.
	 * 
	 * @throws Exception
	 */

	public static void testPreparedInsert() throws Exception {

		Class.forName("com.mysql.jdbc.Driver").newInstance();

		Connection conn = DriverManager.getConnection(
				"jdbc:mysql://localhost/test", "root", "root");

		conn.setAutoCommit(false);

		PreparedStatement ps = conn
				.prepareStatement("INSERT into part values (?,?,?,?)");

		ps.setInt(1, 7);
		ps.setString(2, "Plat2");
		ps.setString(3, "Red");
		ps.setInt(4, 1);
		int recCount = ps.executeUpdate();

		System.out.println("# of Records" + recCount);

		System.out.print(recCount + " Record(s) Updated");

		conn.commit();
		ps.close();
		conn.close();
	}

}