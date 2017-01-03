package com.sunilbooks.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Creates a Table
 * 
 * @version 1.0
 * @since 01 June 2015
 * @author Sunil Sahu
 * @Copyright (c) Sunil Sahu
 * @url www.sunilbooks.com
 */

public class CreateTable {

	public static void main(String[] args) {

		try {

			Class.forName("com.mysql.jdbc.Driver");

			Connection conn = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/st_adv_java", "root", "");

			Statement stmt = conn.createStatement();

			String sql = "CREATE  TABLE PERSON (id INT NOT NULL, Name VARCHAR(45), age INT, PRIMARY KEY(id))";

			System.out.println("Creating table...");

			stmt.executeUpdate(sql);

			System.out.println("Table created");

		} catch (SQLException e) {
			System.out.println("Error : " + e.getMessage());
		} catch (ClassNotFoundException e) {
			System.out.println("Error : " + e.getMessage());
		}

	}
}
