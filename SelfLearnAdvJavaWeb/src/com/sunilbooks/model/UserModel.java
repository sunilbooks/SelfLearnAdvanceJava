package com.sunilbooks.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.sunilbooks.dcp.JdbcDataSource;

/**
 * User Model contains attributes for USER table. It contains methods to
 * manipulate attributes in database.
 * 
 * @version 1.0
 * @since 01 June 2015
 * @author Sunil Sahu
 * @Copyright (c) Sunil Sahu
 * @url www.sunilbooks.com
 * 
 */
public class UserModel {

	private long id = 0;
	private String firstName = null;
	private String lastName = null;
	private String login = null;
	private String password = null;
	private String gender = null;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	/**
	 * returns next auto-generated primary key
	 * 
	 * @param id
	 * @throws Exception
	 */
	public long getNextPk() throws SQLException {

		Connection conn = JdbcDataSource.getConnection();

		String sql = "select max(id) + 1 from USER ";
		PreparedStatement stmt = conn.prepareStatement(sql);
		long nextPk = 1;
		ResultSet rs = stmt.executeQuery();

		if (rs.next()) {
			nextPk = rs.getLong(1);
		}

		return nextPk;

	}

	/**
	 * returns User by ID
	 * 
	 * @param id
	 * @throws Exception
	 */
	public UserModel get(long id) throws SQLException {

		Connection conn = JdbcDataSource.getConnection();

		String sql = "select ID, FIRST_NAME, LAST_NAME, LOGIN, PASSWORD, GENDER from USER where ID= ?";
		PreparedStatement stmt = conn.prepareStatement(sql);
		stmt.setLong(1, id);

		UserModel user = new UserModel();

		ResultSet rs = stmt.executeQuery();

		if (rs.next()) {
			user.id = rs.getLong(1);
			user.firstName = rs.getString(2);
			user.lastName = rs.getString(3);
			user.login = rs.getString(4);
			user.password = rs.getString(5);
			user.gender = rs.getString(6);
		}

		JdbcDataSource.closeConnection(conn, stmt, rs);

		return user;

	}

	/**
	 * loads data from database
	 * 
	 * @param id
	 * @return
	 * @throws Exception
	 */
	public void load(long id) throws Exception {

		Connection conn = JdbcDataSource.getConnection();

		String sql = "select ID, FIRST_NAME, LAST_NAME, LOGIN, PASSWORD, GENDER from USER where ID= ?";
		PreparedStatement stmt = conn.prepareStatement(sql);
		stmt.setLong(1, id);
		ResultSet rs = stmt.executeQuery();

		if (rs.next()) {
			this.id = rs.getLong(1);
			this.firstName = rs.getString(2);
			this.lastName = rs.getString(3);
			this.login = rs.getString(4);
			this.password = rs.getString(5);
			this.gender = rs.getString(6);
		}

		JdbcDataSource.closeConnection(conn, stmt, rs);

	}

	/**
	 * finds user by login id
	 * 
	 * @param name
	 * @throws Exception
	 */
	public UserModel findByLogin(String name) throws Exception {

		Connection conn = JdbcDataSource.getConnection();

		String sql = "select ID, FIRST_NAME, LAST_NAME, LOGIN, PASSWORD, GENDER from USER where LOGIN = ?";
		PreparedStatement stmt = conn.prepareStatement(sql);
		stmt.setString(1, login);

		UserModel user = new UserModel();

		ResultSet rs = stmt.executeQuery();

		if (rs.next()) {
			user.id = rs.getLong(1);
			user.firstName = rs.getString(2);
			user.lastName = rs.getString(3);
			user.login = rs.getString(4);
			user.password = rs.getString(5);
			user.gender = rs.getString(6);
		}

		JdbcDataSource.closeConnection(conn, stmt, rs);

		return user;
	}

	/**
	 * authenticates a User by login and password
	 * 
	 * @param name
	 * @throws Exception
	 */

	public UserModel authenticate(String login, String password)
			throws Exception {

		Connection conn = JdbcDataSource.getConnection();

		String sql = "select ID, FIRST_NAME, LAST_NAME, LOGIN, PASSWORD, GENDER from USER where LOGIN = ?";
		PreparedStatement stmt = conn.prepareStatement(sql);
		stmt.setString(1, login);
		stmt.setString(1, password);

		ResultSet rs = stmt.executeQuery();

		UserModel user = new UserModel();
		if (rs.next()) {
			user.id = rs.getLong(1);
			user.firstName = rs.getString(2);
			user.lastName = rs.getString(3);
			user.login = rs.getString(4);
			user.password = rs.getString(5);
			user.gender = rs.getString(6);
		}

		JdbcDataSource.closeConnection(conn, stmt, rs);

		return user;
	}

	public ArrayList<UserModel> search() throws Exception {

		Connection conn = JdbcDataSource.getConnection();

		StringBuffer sql = new StringBuffer(
				"select ID, FIRST_NAME, LAST_NAME, LOGIN, PASSWORD, GENDER from USER where true ?");

		if (firstName != null && firstName.length() > 0) {
			sql.append(" and FIRST_NAME like '" + firstName + "%'");
		}

		if (lastName != null && lastName.length() > 0) {
			sql.append(" and LAST_NAME like '" + lastName + "%'");
		}

		if (login != null && login.length() > 0) {
			sql.append(" and LOGIN like '" + login + "%'");
		}

		if (gender != null && gender.length() > 0) {
			sql.append(" and GENDER like '" + gender + "%'");
		}

		PreparedStatement stmt = conn.prepareStatement(sql.toString());

		System.out.println(sql);

		ResultSet rs = stmt.executeQuery();

		ArrayList<UserModel> userList = new ArrayList<UserModel>();

		UserModel user = null;

		while (rs.next()) {

			user = new UserModel();

			user.id = rs.getLong(1);
			user.firstName = rs.getString(2);
			user.lastName = rs.getString(3);
			user.login = rs.getString(4);
			user.password = rs.getString(5);
			user.gender = rs.getString(6);
			userList.add(user);
		}

		JdbcDataSource.closeConnection(conn, stmt, rs);

		return userList;
	}

	public int add() throws SQLException {

		String sql = "insert into USER (ID,FIRST_NAME, LAST_NAME, LOGIN, PASSWORD, GENDER ) values (?,?,?,?,?,?)";

		Connection conn = JdbcDataSource.getConnection();

		PreparedStatement stmt = conn.prepareStatement(sql);
		stmt.setLong(1, id);
		stmt.setString(2, firstName);
		stmt.setString(3, lastName);
		stmt.setString(4, login);
		stmt.setString(5, password);
		stmt.setString(6, gender);

		System.out.println(sql);

		int recordCount = stmt.executeUpdate();

		JdbcDataSource.closeConnection(conn, stmt);

		return recordCount;
	}

	/**
	 * Updates User record
	 * 
	 * @return
	 * @throws Exception
	 */
	public int update() throws SQLException {

		String sql = "UPDATE USER SET FIRST_NAME=?,LAST_NAME=?,LOGIN=?,PASSWORD=?,GENDER=?  WHERE ID=?";

		Connection conn = JdbcDataSource.getConnection();

		PreparedStatement stmt = conn.prepareStatement(sql);
		stmt.setString(1, firstName);
		stmt.setString(2, lastName);
		stmt.setString(3, login);
		stmt.setString(4, password);
		stmt.setString(5, gender);
		stmt.setLong(6, id);

		System.out.println(sql);

		int recordCount = stmt.executeUpdate();

		JdbcDataSource.closeConnection(conn, stmt);

		return recordCount;
	}

	/**
	 * changes user password
	 * 
	 * @param oldPassword
	 * @param newPassword
	 * @return
	 * @throws Exception
	 */
	public boolean changePassword(String login, String oldPassword,
			String newPassword) throws Exception {

		UserModel user = findByLogin(login);
		if (oldPassword.equals(user.getPassword())) {
			user.setPassword(newPassword);
			user.update();
			return true;
		} else {
			return false;
		}
	}

	/**
	 * Deletes User record
	 * 
	 * @return
	 * @throws Exception
	 */
	public int delete() throws Exception {

		String sql = "DELETE FROM USER WHERE ID=?";

		Connection conn = JdbcDataSource.getConnection();

		PreparedStatement stmt = conn.prepareStatement(sql);
		stmt.setLong(1, id);

		System.out.println(sql);

		int recordCount = stmt.executeUpdate();

		JdbcDataSource.closeConnection(conn, stmt);

		return recordCount;
	}

	public static void main(String[] args) throws Exception {
		UserModel model = new UserModel();
		model.get(1);
		model.findByLogin("shyam");
		System.out.println("First Name:" + model.getFirstName());
	}

}
