package com.sunilbooks.jdbc;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Types;

/**
 * Calls a Stored Function.
 * 
 * @version 1.0
 * @since 01 June 2015
 * @author Sunil Sahu
 * @Copyright (c) Sunil Sahu
 * @url www.sunilbooks.com
 */

public class CallStoredFunction {

	static String url = "jdbc:mysql://localhost/st_adv_java";
	static String login = "root";
	static String password = "";

	/**
	 * Tests sample code
	 * 
	 * @param args
	 */
	public static void main(String[] args) throws Exception {
		callStoredFunction();
	}

	/**
	 * Calls Stored Function and prints return value.
	 * 
	 * @throws Exception
	 */
	public static void callStoredFunction() throws Exception {
		
		/*
			CREATE PROCEDURE getAllParts()
			BEGIN
			 SELECT * FROM Part;
			END
		 */

		Class.forName("com.mysql.jdbc.Driver");

		Connection conn = DriverManager.getConnection(url, login, password);

		CallableStatement cstmt = conn.prepareCall("{? = CALL partCount()}");

		// Register OUT parameter.
		cstmt.registerOutParameter(1, Types.INTEGER);

		// Execute SF
		cstmt.execute();

		// Fetch return value
		System.out.println(" Count " + cstmt.getInt(1));
	}

}
