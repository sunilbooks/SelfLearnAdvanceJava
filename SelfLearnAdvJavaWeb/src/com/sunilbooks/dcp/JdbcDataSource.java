package com.sunilbooks.dcp;

import java.beans.PropertyVetoException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mchange.v2.c3p0.ComboPooledDataSource;

/**
 * JDBC Datasource is the factory of jdbc connection. It creates DCP with help
 * of C3P0 library. It is a single and factory class.
 * 
 * @version 1.0
 * @since 01 June 2015
 * @author Sunil Sahu
 * @Copyright (c) Sunil Sahu
 * @url www.sunilbooks.com
 */
public final class JdbcDataSource {

	// JDBC Datasource static object
	private static JdbcDataSource jds = null;

	// C3P0 database connection pool
	private ComboPooledDataSource ds = null;

	// Make default constructor private
	private JdbcDataSource() {
		try {
			// Create data source
			ds = new ComboPooledDataSource();
			// Set DS Properties
			ds.setDriverClass("com.mysql.jdbc.Driver");
			ds.setJdbcUrl("jdbc:mysql://localhost/st_adv_java");
			ds.setUser("root");
			ds.setPassword("");

			// Minimum number of connections
			ds.setInitialPoolSize(5);
			// Increase connection when existing users are increased
			ds.setAcquireIncrement(5);
			// Maximum number of connections
			ds.setMaxPoolSize(50);
		} catch (PropertyVetoException e) {
			e.printStackTrace();
		}
	}

	/**
	 * gets instance of JdbcDataSource using factory method getInstance
	 * 
	 * @return
	 */
	public static JdbcDataSource getInstance() {
		if (jds == null) {
			jds = new JdbcDataSource();
		}
		return jds;
	}

	/**
	 * returns JDBC connection from DCP
	 * 
	 * @return Connection
	 */
	public static Connection getConnection() {
		try {
			return getInstance().ds.getConnection();
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}

	/**
	 * close connection and returns to DCP
	 * 
	 * @param conn
	 * @param stmt
	 * @param rs
	 */
	public static void closeConnection(Connection conn, Statement stmt,
			ResultSet rs) {
		try {
			if (rs != null)
				rs.close(); // memory will be cleaned
			if (stmt != null)
				stmt.close();// Cursor will be closed
			if (conn != null)
				conn.close(); // Conn will be returned to pool
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	/**
	 * close connection and returns to DCP
	 * 
	 * @param conn
	 * @param stmt
	 */
	public static void closeConnection(Connection conn, Statement stmt) {
		closeConnection(conn, stmt, null);
	}

	/**
	 * close connection and returns to DCP
	 * 
	 * @param conn
	 * @param stmt
	 */
	public static void closeConnection(Connection conn) {
		closeConnection(conn, null, null);
	}

	public static void main(String[] args) throws SQLException {

		String sql = "SELECT id, name, age FROM person;";

		// Get connection from DCP
		Connection conn = JdbcDataSource.getConnection();

		Statement stmt = conn.createStatement();

		ResultSet rs = stmt.executeQuery(sql);

		System.out.println("DB Pool Connection");
		System.out.println("ID\tName\tAge");
		while (rs.next()) {
			System.out.print(rs.getInt(1));
			System.out.print("\t" + rs.getString(2));
			System.out.println("\t" + rs.getInt("Age"));
		}
		// Return connection to pool
		JdbcDataSource.closeConnection(conn, stmt, rs);
	}

}
