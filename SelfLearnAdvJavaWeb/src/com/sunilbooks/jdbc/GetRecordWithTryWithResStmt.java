package com.sunilbooks.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Gets records from Person table. It will connection to MySQL Database.
 * 
 * It applies try-with-resources statement that automatically closes connection
 * and statement objects.
 * 
 * @version 1.0
 * @since 01 June 2015
 * @author Sunil Sahu
 * @Copyright (c) Sunil Sahu
 * @url www.sunilbooks.com
 */

public class GetRecordWithTryWithResStmt {

	public static void main(String args[]) throws Exception {

		String url = "jdbc:mysql://localhost/st_adv_java";
		String login = "root";
		String password = "";
		String sql = "SELECT id, name, age FROM person;";

		Class.forName("com.mysql.jdbc.Driver");

		try (Connection conn = DriverManager
				.getConnection(url, login, password);

		Statement stmt = conn.createStatement();) {

			ResultSet rs = stmt.executeQuery(sql);

			System.out.println("ID\tName\tAge");
			while (rs.next()) {
				System.out.print(rs.getInt(1) + "\t");
				System.out.print(rs.getString(2) + "\t");
				System.out.println(rs.getInt("Age"));
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

}