package com.sunilbooks.selflearnjava.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 * Encapsulates attributes and Create Read Update and Delete ( CRUD ) operations
 * of Customer.
 * 
 * @version 1.0
 * @since 01 Jan 2015
 * @author Sunil Sahu
 * @Copyright (c) Sunil Sahu
 * @url www.sunilbooks.com
 */
public class CustomerModel {

	/**
	 * Primary Key Customer ID
	 */
	private long id = 0;

	/**
	 * Name of the Customer
	 */
	private String name = null;

	/**
	 * City of Customer
	 */
	private String city = null;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	/**
	 * Load driver
	 */
	static {
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * gets database connection
	 * 
	 * @return
	 * @throws Exception
	 */
	public Connection getConnection() throws Exception {
		return DriverManager.getConnection(
				"jdbc:mysql://localhost:3306/ST_JAVA", "root", "");
	}

	/**
	 * Adds customer
	 * 
	 * @return
	 * @throws Exception
	 */
	public long add() throws Exception {

		// Get connection
		Connection conn = getConnection();

		// Start transaction
		conn.setAutoCommit(false);

		try {

			// Create Statement
			PreparedStatement ps = conn
					.prepareStatement("INSERT INTO ST_CUSTOMER VALUES(?,?,?)");

			// Set parameters
			ps.setLong(1, id);
			ps.setString(2, name);
			ps.setString(3, city);

			// Execute query
			int i = ps.executeUpdate();

			conn.commit(); // Save changes

			System.out.println("Customer Record Inserted # " + id);

		} catch (Exception e) {
			conn.rollback();// Revert changes
		}
		return id;
	}

	/**
	 * Updates a customer record
	 * 
	 * @return
	 * @throws Exception
	 */
	public long update() throws Exception {

		// Get connection
		Connection conn = getConnection();

		// Start Transaction
		conn.setAutoCommit(false);

		try {
			// Create Statement
			PreparedStatement ps = (PreparedStatement) conn
					.prepareStatement("UPDATE ST_CUSTOMER SET NAME=?,CITY=? WHERE ID=?");
			// Set parameters
			ps.setString(1, name);
			ps.setString(2, city);
			ps.setLong(3, id);

			// Execute query
			int i = ps.executeUpdate();

			conn.commit();// Save changes
			System.out.println("Customer Record Update # " + id);

		} catch (Exception e) {
			conn.rollback(); // revert changes
		}
		return id;
	}

	/**
	 * Deletes Customer Record
	 * 
	 * @return
	 * @throws Exception
	 */
	public long delete() throws Exception {

		// Get Collection
		Connection conn = getConnection();

		// Start transaction
		conn.setAutoCommit(false);

		try {
			// Create Statement
			PreparedStatement ps = (PreparedStatement) conn
					.prepareStatement("DELETE FROM ST_CUSTOMER WHERE ID=?");
			ps.setLong(1, id);

			// Execute query
			int i = ps.executeUpdate();

			conn.commit(); // Save changes

			System.out.println("Customer Record Deleted # " + id);

		} catch (Exception e) {
			conn.rollback(); // Revert changes
		}

		return id;
	}

	/**
	 * Finds Customer by primary key Customer ID.
	 * 
	 * @return
	 * @throws Exception
	 */
	public CustomerModel findByPk() throws Exception {

		// Get connection
		Connection conn = getConnection();
		// Create statement
		PreparedStatement ps = conn
				.prepareStatement("SELECT NAME, CITY FROM ST_CUSTOMER WHERE ID=?");
		ps.setLong(1, id);

		// Execute query
		ResultSet rs = ps.executeQuery();

		// move cursor to first row
		rs.next();

		// Get data
		name = rs.getString(1);
		city = rs.getString(2);

		// Close result set
		rs.close();

		return this;
	}

	/**
	 * Searches Customer by ID, Name, and City
	 * 
	 * @return
	 * @throws Exception
	 */
	public List<CustomerModel> search() throws Exception {

		// Get connection
		Connection conn = getConnection();

		// Create dynamic query
		StringBuffer sql = new StringBuffer("select * from ST_CUSTOMER ");
		// Add where class with a true condition
		sql.append(" where true ");

		// if id > 0 then add to query
		if (id > 0) {
			sql.append(" and  ID = " + id);
		}
		// if name is not empty then add to query
		if (name != null && name.trim().length() > 0) {
			sql.append(" and NAME like  '" + name + "'");
		}
		// if city is not empty then add to query
		if (city != null && city.trim().length() > 0) {
			sql.append(" and  CITY like  '" + city + "'");
		}

		// Create Statement
		PreparedStatement ps = conn.prepareStatement(sql.toString());
		// Execute query
		ResultSet rs = ps.executeQuery();

		List<CustomerModel> list = new ArrayList<CustomerModel>();

		// move cursor to next row
		while (rs.next()) {
			// Create model object
			CustomerModel customerModel = new CustomerModel();
			customerModel.setId(rs.getInt(1));
			customerModel.setName(rs.getString(2));
			customerModel.setCity(rs.getString(3));
			// Add to list
			list.add(customerModel);
		}
		return list;
	}

	/**
	 * Search and return number of records as per page number and size. It is
	 * used for pagination
	 * 
	 * @param pageNo
	 * @param pageSize
	 * @return
	 * @throws Exception
	 */
	public List<CustomerModel> search(int pageNo, int pageSize)
			throws Exception {

		// get connection
		Connection conn = getConnection();

		// create dynamic query
		StringBuffer sql = new StringBuffer("select * from ST_CUSTOMER ");
		// add where class with a true condition
		sql.append(" where true ");

		// if id > 0 then add to query
		if (id > 0) {
			sql.append(" and  ID = " + id);
		}
		// if name is not empty then add to query
		if (name != null && name.trim().length() > 0) {
			sql.append(" and NAME like  '" + name + "'");
		}
		// if city is not empty then add to query
		if (city != null && city.trim().length() > 0) {
			sql.append(" and  CITY like  '" + city + "'");
		}

		// apply pagination
		if (pageSize > 0) {
			// calculate start record no
			int recNo = (pageNo - 1) * pageSize;
			sql.append(" limit " + recNo + "," + pageSize);
		}

		// Create Statement
		PreparedStatement ps = conn.prepareStatement(sql.toString());
		// Execute query
		ResultSet rs = ps.executeQuery();

		List<CustomerModel> list = new ArrayList<CustomerModel>();

		// move cursor to next row
		while (rs.next()) {
			CustomerModel customerModel = new CustomerModel();
			customerModel.setId(rs.getInt(1));
			customerModel.setName(rs.getString(2));
			customerModel.setCity(rs.getString(3));
			list.add(customerModel);
		}
		return list;
	}

	/**
	 * Test Method
	 */
	public static void main(String[] args) throws Exception {
		CustomerModel cm = new CustomerModel();
		cm.setId(5);
		cm.setName("Rajesh");
		cm.setCity("Mumbai");
		cm.add();
	}

}
