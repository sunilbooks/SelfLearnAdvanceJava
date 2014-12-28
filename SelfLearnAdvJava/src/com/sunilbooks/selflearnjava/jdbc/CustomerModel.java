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
	 * gets database connection
	 * 
	 * @return
	 * @throws Exception
	 */
	public Connection getConnection() throws Exception {
		return (Connection) DriverManager.getConnection(
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
			PreparedStatement ps = (PreparedStatement) conn
					.prepareStatement("INSERT INTO ST_CUSTOMER VALUES(?,?,?)");
			ps.setLong(1, id);
			ps.setString(2, name);
			ps.setString(3, city);

			int i = ps.executeUpdate();

			conn.commit(); // Save changes

			System.out.println("Customer Record Inserted # " + id);

		} catch (Exception e) {
			conn.rollback();// Revert changes
		}
		return id;
	}

	public long delete() throws Exception {

		Connection conn = getConnection();

		conn.setAutoCommit(false);

		try {
			PreparedStatement ps = (PreparedStatement) conn
					.prepareStatement("DELETE FROM ST_CUSTOMER WHERE ID=?");
			ps.setLong(1, id);

			int i = ps.executeUpdate();

			conn.commit();

			System.out.println("Customer Record Deleted # " + id);

		} catch (Exception e) {
			conn.rollback();
			e.printStackTrace();
		}

		return id;
	}

	public long update() throws Exception {

		Connection conn = getConnection();

		conn.setAutoCommit(false);

		try {
			PreparedStatement ps = (PreparedStatement) conn
					.prepareStatement("UPDATE ST_CUSTOMER SET NAME=?,CITY=? WHERE ID=?");

			ps.setString(1, name);
			ps.setString(2, city);
			ps.setLong(3, id);

			int i = ps.executeUpdate();

			conn.commit();

			System.out.println("Customer Record Update # " + id);
		} catch (Exception e) {
			conn.rollback();
			e.printStackTrace();
		}

		return id;
	}

	public CustomerModel findByPk() throws Exception {

		Connection conn = getConnection();

		PreparedStatement ps = (PreparedStatement) conn
				.prepareStatement("SELECT NAME, CITY FROM ST_CUSTOMER WHERE ID=?");

		ps.setLong(1, id);

		ResultSet rs = ps.executeQuery();

		rs.next();

		name = rs.getString(1);
		city = rs.getString(2);

		rs.close();

		return this;
	}

	public CustomerModel findByName() throws Exception {

		Connection conn = getConnection();

		PreparedStatement ps = (PreparedStatement) conn
				.prepareStatement("SELECT NAME, CITY FROM ST_CUSTOMER WHERE NAME=?");

		ps.setString(1, name);

		ResultSet rs = ps.executeQuery();

		CustomerModel customerModel = new CustomerModel();

		while (rs.next()) {

			customerModel.setName(rs.getString(1));
			customerModel.setCity(rs.getString(2));
		}
		rs.close();

		System.out.println("Customer Record Get # " + customerModel.getName());
		return customerModel;
	}

	public List<CustomerModel> search() throws Exception {

		Connection conn = getConnection();

		PreparedStatement ps = (PreparedStatement) conn
				.prepareStatement("SELECT * FROM ST_CUSTOMER");

		ResultSet rs = ps.executeQuery();

		List list = new ArrayList();

		while (rs.next()) {
			CustomerModel customerModel = new CustomerModel();

			customerModel.setId(rs.getInt(1));
			customerModel.setName(rs.getString(2));
			customerModel.setCity(rs.getString(3));

			list.add(customerModel);
		}
		System.out.println("Customer Record List Search # ");

		return list;
	}

	public List<CustomerModel> search(CustomerModel customerModel)
			throws Exception {

		Connection conn = getConnection();

		StringBuffer sql = new StringBuffer(
				"SELECT * FROM ST_CUSTOMER WHERE TRUE");

		if (customerModel != null) {
			if (customerModel.getName() != null
					&& customerModel.getName().length() > 0) {
				sql.append(" AND Name like '" + customerModel.getName() + "%'");
			}
		}
		PreparedStatement ps = (PreparedStatement) conn.prepareStatement(sql
				.toString());

		ResultSet rs = ps.executeQuery();

		System.out.println("Record Get List Search Method() Filter By Name ");

		List list = new ArrayList();
		while (rs.next()) {
			customerModel = new CustomerModel();
			customerModel.setId(rs.getInt(1));
			customerModel.setName(rs.getString(2));
			customerModel.setCity(rs.getString(3));

			list.add(customerModel);

		}
		return list;
	}

	public List<CustomerModel> search(int pageNo, int pageSize)
			throws Exception {

		Connection conn = getConnection();

		ArrayList list = new ArrayList();

		StringBuffer sql = new StringBuffer(
				"SELECT * FROM ST_CUSTOMER WHERE TRUE");
		if (pageSize > 0) {
			pageNo = (pageNo - 1) * pageSize;
			sql.append(" limit " + pageNo + "," + pageSize);
		}

		PreparedStatement ps = (PreparedStatement) conn.prepareStatement(sql
				.toString());

		ResultSet rs = ps.executeQuery();

		System.out.println("Record List Search(pageNo, PageSize) Methos");

		while (rs.next()) {
			CustomerModel customerModel = new CustomerModel();
			customerModel.setId(rs.getLong(1));
			customerModel.setName(rs.getString(2));
			customerModel.setCity(rs.getString(3));

			list.add(customerModel);

		}
		rs.close();
		return list;
	}

}
