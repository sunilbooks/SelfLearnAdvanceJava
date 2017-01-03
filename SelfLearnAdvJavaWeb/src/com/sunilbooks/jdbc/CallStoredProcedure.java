package com.sunilbooks.jdbc;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Types;

/**
 * Calls a Stored Procedure.
 * 
 * @version 1.0
 * @since 01 June 2015
 * @author Sunil Sahu
 * @Copyright (c) Sunil Sahu
 * @url www.sunilbooks.com
 */

public class CallStoredProcedure {

	static String url = "jdbc:mysql://localhost/st_adv_java";
	static String login = "root";
	static String password = "";

	/**
	 * Tests sample code
	 * 
	 * @param args
	 */
	public static void main(String[] args) throws Exception {
		callStoredProcedure();
		getResultSet();
	}

	/**
	 * Calls Stored Procedure and prints OUT parameter value.
	 * 
	 * @throws Exception
	 */
	public static void callStoredProcedure() throws Exception {
		
		/*
			CREATE PROCEDURE getPartName(IN i INTEGER, OUT n VARCHAR(20))
			BEGIN
				SELECT name FROM Part WHERE ID = i INTO  n;
			END
		 */

		Class.forName("com.mysql.jdbc.Driver");

		Connection conn = DriverManager.getConnection(url, login, password);
		CallableStatement cstmt = conn.prepareCall("{CALL getPartName(?,?)}");

		// Set IN Parameter
		cstmt.setInt(1, 1);

		// Register OUT parameter
		cstmt.registerOutParameter(2, Types.VARCHAR);

		// Execute procedure
		cstmt.execute();

		System.out.println(" Part Name: " + cstmt.getString(2));
	}

	/**
	 * Gets ResultSet from Stored Procedure.
	 * 
	 * @throws Exception
	 */
	
	public static void getResultSet() throws Exception {

		
		 /*
			CREATE PROCEDURE `st_adv_java`.`getAllParts` ()
			BEGIN
			 SELECT * FROM Part;
			END
		  */

		
		Class.forName("com.mysql.jdbc.Driver");

		Connection conn = DriverManager.getConnection(url, login, password);
		CallableStatement cstmt = conn.prepareCall("{CALL getAllParts()}");

		// Execute procedure
		cstmt.execute();

		ResultSet rs = cstmt.getResultSet();

		while (rs.next()) {
			System.out.print(rs.getString(1));
			System.out.print(rs.getString(2));
			System.out.println(rs.getString(3));
		}

	}

}
