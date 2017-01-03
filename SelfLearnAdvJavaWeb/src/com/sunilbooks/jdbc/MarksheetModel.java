package com.sunilbooks.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.ResourceBundle;

/**
 * Model provides Marksheet create, read, update, and delete (CRUD) operations.
 * Its search method creates dynamic SELECT query.
 * 
 * @version 1.0
 * @since 01 June 2015
 * @author Sunil Sahu
 * @Copyright (c) Sunil Sahu
 * @url www.sunilbooks.com
 */

public class MarksheetModel {

	// Static block will be executed when Class is loaded in memory.
	static {
		try {
			// Load Driver
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	static String url = "jdbc:mysql://localhost/st_adv_java";
	static String login = "root";
	static String password = "";

	/**
	 * Gets a Marksheet by Roll Number
	 * 
	 * @param rollNo
	 * @return
	 * @throws Exception
	 */
	public Marksheet get(String rollNo) throws Exception {

		Connection conn = DriverManager.getConnection(url, login, password);

		String sql = "select rollNo,name,physics,chemistry,maths from MARKSHEET where rollNo= ?";

		PreparedStatement stmt = conn.prepareStatement(sql);
		stmt.setString(1, rollNo);

		ResultSet rs = stmt.executeQuery();

		Marksheet bean = null;

		if (rs.next()) {

			bean = new Marksheet();
			bean.setRollNo(rollNo);
			bean.setName(rs.getString(2));
			bean.setPhysics(rs.getInt(3));
			bean.setChemistry(rs.getInt(4));
			bean.setMaths(rs.getInt(5));
		}

		rs.close(); // memory will be cleaned
		stmt.close(); // Cursor will be closed
		conn.close(); // Connection will be closed.

		return bean;
	}

	/**
	 * Gets list of Marksheet
	 * 
	 * @return
	 * @throws Exception
	 */

	public ArrayList<Marksheet> search(Marksheet bean) throws Exception {

		Connection conn = DriverManager.getConnection(url, login, password);

		StringBuffer sql = new StringBuffer(
				"select rollNo,name,physics,chemistry,maths from MARKSHEET where true");

		if (bean != null) {

			if (bean.getRollNo() != null && bean.getRollNo().length() > 0) {
				sql.append(" AND rollNo LIKE '" + bean.getRollNo() + "%'");
			}
			if (bean.getName() != null && bean.getName().length() > 0) {
				sql.append(" AND name LIKE '" + bean.getName() + "%'");
			}
			if (bean.getPhysics() > 0) {
				sql.append(" AND physics = " + bean.getPhysics());
			}
			if (bean.getChemistry() > 0) {
				sql.append(" AND chemistry = " + bean.getChemistry());
			}
			if (bean.getMaths() > 0) {
				sql.append(" AND maths = '" + bean.getMaths());
			}
		}

		PreparedStatement stmt = conn.prepareStatement(sql.toString());

		System.out.println(sql);

		ResultSet rs = stmt.executeQuery();

		ArrayList<Marksheet> marksheetList = new ArrayList<Marksheet>();

		Marksheet marksheet = null;

		while (rs.next()) {

			marksheet = new Marksheet();
			marksheet.setRollNo(rs.getString(1));
			marksheet.setName(rs.getString(2));
			marksheet.setPhysics(rs.getInt(3));
			marksheet.setChemistry(rs.getInt(4));
			marksheet.setMaths(rs.getInt(5));

			marksheetList.add(marksheet);
		}

		return marksheetList;
	}

	/**
	 * Gets merit list
	 * 
	 * @return
	 * @throws Exception
	 */
	public ArrayList<Marksheet> getMeritList() throws Exception {

		Connection conn = DriverManager.getConnection(url, login, password);

		String sql = "select rollNo,name,physics,chemistry,maths from MARKSHEET order by (physics+chemistry+maths) desc limit 10";

		PreparedStatement stmt = conn.prepareStatement(sql);

		ResultSet rs = stmt.executeQuery();

		ArrayList<Marksheet> marksheetList = new ArrayList<Marksheet>();

		Marksheet bean = null;

		int count = 0;

		while (rs.next()) {

			bean = new Marksheet();
			bean.setRollNo(rs.getString(1));
			bean.setName(rs.getString(2));
			bean.setPhysics(rs.getInt(3));
			bean.setChemistry(rs.getInt(4));
			bean.setMaths(rs.getInt(5));

			marksheetList.add(bean);

			count++;
			if (count == 10) {
				break;
			}

		}

		return marksheetList;
	}

	/**
	 * Adds a Marksheet from Marksheet bean
	 * 
	 * @param bean
	 * @return
	 * @throws Exception
	 */

	public int add(Marksheet bean) throws Exception {

		Connection conn = DriverManager.getConnection(url, login, password);

		String sql = "insert into MARKSHEET (rollNo,name, chemistry,physics,maths ) values (?,?,?,?,?)";

		PreparedStatement stmt = conn.prepareStatement(sql);
		stmt.setString(1, bean.getRollNo());
		stmt.setString(2, bean.getName());
		stmt.setInt(3, bean.getChemistry());
		stmt.setInt(4, bean.getPhysics());
		stmt.setInt(5, bean.getMaths());

		System.out.println(sql);

		int recordCount = stmt.executeUpdate();

		stmt.close(); // Cursor will be closed
		conn.close(); // Connection will be closed.

		return recordCount;
	}

	/**
	 * Updates a marksheet
	 * 
	 * @param bean
	 * @return
	 * @throws Exception
	 */
	public int update(Marksheet bean) throws Exception {

		Connection conn = DriverManager.getConnection(url, login, password);

		String sql = "update MARKSHEET set name=?, physics = ?, chemistry =?,  maths =?  where rollNo = ?";

		PreparedStatement stmt = conn.prepareStatement(sql);
		stmt.setString(1, bean.getName());
		stmt.setInt(2, bean.getPhysics());
		stmt.setInt(3, bean.getChemistry());
		stmt.setInt(4, bean.getMaths());
		stmt.setString(5, bean.getRollNo());

		System.out.println(sql);

		int recordCount = stmt.executeUpdate();

		stmt.close(); // Cursor will be closed
		conn.close(); // Connection will be closed.

		return recordCount;
	}

	/**
	 * Deletes Marksheet
	 * 
	 * @param bean
	 * @return
	 * @throws Exception
	 * 
	 */
	public int delete(String rollNo) throws Exception {

		Connection conn = DriverManager.getConnection(url, login, password);

		String sql = "delete from MARKSHEET where rollNo= ?";

		PreparedStatement stmt = conn.prepareStatement(sql);
		stmt.setString(1, rollNo);
		int recordCount = stmt.executeUpdate();

		stmt.close(); // Cursor will be closed
		conn.close(); // Connection will be closed.

		return recordCount;
	}

}
