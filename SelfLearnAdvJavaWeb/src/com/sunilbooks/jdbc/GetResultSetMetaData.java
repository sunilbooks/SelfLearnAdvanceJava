package com.sunilbooks.jdbc;

import java.sql.*;

/**
 * Gets Meta Data of SQL Statement and print
 * 
* @version 1.0
 * @since 01 June 2015
 * @author Sunil Sahu
 * @Copyright (c) Sunil Sahu
 * @url www.sunilbooks.com
 */

public class GetResultSetMetaData {

	public static void main(String args[]) throws Exception {

		String url = "jdbc:mysql://localhost/st_adv_java";
		String login = "root";
		String password = "";
		String sql = "SELECT id, name, age FROM person;";

		Class.forName("com.mysql.jdbc.Driver");

		Connection conn = DriverManager.getConnection(url, login, password);

		Statement stmt = conn.createStatement();

		ResultSet rs = stmt.executeQuery(sql);

		ResultSetMetaData rsmt = rs.getMetaData();

		System.out.println("Catelog Name : " + rsmt.getCatalogName(1));
		System.out.println("Table Name : " + rsmt.getTableName(1));

		int columnCount = rsmt.getColumnCount();
		System.out.println("Total Columns :" + columnCount);
		System.out.println();

		for (int i = 1; i <= columnCount; i++) {
			System.out.println("Column:" + (i));
			System.out.println("Label: " + rsmt.getColumnLabel(i));
			System.out.println("Name: " + rsmt.getColumnName(i));
			System.out.println("Type: " + rsmt.getColumnTypeName(i));
			System.out.println("Size: " + rsmt.getColumnDisplaySize(i));
			System.out.println("Precision: " + rsmt.getPrecision(i));
			System.out.println();
		}

		stmt.close();
		conn.close();

	}

}