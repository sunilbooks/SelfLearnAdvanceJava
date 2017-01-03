package com.sunilbooks.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Alters a Table
 * 
 * @version 1.0
 * @since 01 June 2015
 * @author Sunil Sahu
 * @Copyright (c) Sunil Sahu
 * @url www.sunilbooks.com
 */

public class AlterTable {

	public static void main(String[] args) {

		try {

			Class.forName("com.mysql.jdbc.Driver");

			Connection conn = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/st_adv_java", "root", "");

			Statement stmt = conn.createStatement();

			String sql = "ALTER TABLE person ADD COLUMN dob DATE NULL";

			System.out.println("Altering table...");

			stmt.executeUpdate(sql);

			System.out.println("Table altered");

		} catch (SQLException e) {
			System.out.println("Error : " + e.getMessage());
		} catch (ClassNotFoundException e) {
			System.out.println("Error : " + e.getMessage());
		}

	}
}
