package com.sunilbooks.selflearnjava.jdbc;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.naming.directory.SearchControls;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.Statement;

public class CustomerModel {

	static {
  	   Class.forName("com.mysql.jdbc.Driver");
	}

	private long id = 0;
	private String name = null;
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

    public static Connection getConnection() throws Exception {
        return (Connection) DriverManager.getConnection(
				"jdbc:mysql://localhost:3306/test1", "root", "root");
    }
 

	public long add() throws Exception {

		Connection conn = getConnection();

		PreparedStatement ps = (PreparedStatement) conn
				.prepareStatement("INSERT INTO INTO ST_CUSTOMER VALUES(?,?,?)");
		ps.setLong(1, id);
		ps.setString(2, name);
		ps.setString(3, city);

		int i = ps.executeUpdate();

		System.out.println("Customer Record Inserted # " + id);
		
		return i;
	}

	public static long delete(CustomerModel customerModel) throws Exception {
		Class.forName("com.mysql.jdbc.Driver");
		Connection conn = (Connection) DriverManager.getConnection(
				"jdbc:mysql://localhost:3306/test1", "root", "root");

		PreparedStatement ps = (PreparedStatement) conn
				.prepareStatement("delete from Customer where id=?");
		System.out.println("in Delete Service");
		ps.setLong(1, customerModel.getId());

		int i = ps.executeUpdate();
		System.out.println("Record Delete ");
		return i;
	}

	public static long update(CustomerModel customerModel) throws Exception {
		Class.forName("com.mysql.jdbc.Driver");
		Connection conn = (Connection) DriverManager.getConnection(
				"jdbc:mysql://localhost:3306/test1", "root", "root");

		PreparedStatement ps = (PreparedStatement) conn
				.prepareStatement("update Customer set name=?,city=? where id=?");
		System.out.println("in Upadte service");
		ps.setString(1, customerModel.getName());
		ps.setString(2, customerModel.getCity());
		ps.setLong(3, customerModel.getId());

		int i = ps.executeUpdate();
		System.out.println("Record Update ");
		return i;
	}

	public static CustomerModel findByPk(CustomerModel customerModel)
			throws Exception {
		Class.forName("com.mysql.jdbc.Driver");
		Connection conn = (Connection) DriverManager.getConnection(
				"jdbc:mysql://localhost:3306/test1", "root", "root");

		PreparedStatement ps = (PreparedStatement) conn
				.prepareStatement("select * from Customer where id=?");
		System.out.println("in findByPk Service");
		ps.setLong(1, customerModel.getId());

		ResultSet rs = ps.executeQuery();

		System.out.println("Record FindByPk");
		System.out.println("ID\t" + "Name\t" + "City");
		while (rs.next()) {
			customerModel = new CustomerModel();
			customerModel.setId(rs.getLong(1));
			customerModel.setName(rs.getString(2));
			customerModel.setCity(rs.getString(3));

			System.out.print(+rs.getLong(1));
			System.out.print("\t" + rs.getString(2));
			System.out.print("\t" + rs.getString(3));
		}

		rs.close();
		return customerModel;
	}

	public static CustomerModel findByName(CustomerModel customerModel)
			throws Exception {
		Class.forName("com.mysql.jdbc.Driver");
		Connection conn = (Connection) DriverManager.getConnection(
				"jdbc:mysql://localhost:3306/test1", "root", "root");

		PreparedStatement ps = (PreparedStatement) conn
				.prepareStatement("select * from Customer where name=?");
		System.out.println("in findByName Service");
		ps.setString(1, customerModel.getName());

		ResultSet rs = ps.executeQuery();

		System.out.println("Record FindByName");
		System.out.println("ID\t" + "Name\t" + "City");
		while (rs.next()) {
			customerModel = new CustomerModel();
			customerModel.setId(rs.getLong(1));
			customerModel.setName(rs.getString(2));
			customerModel.setCity(rs.getString(3));

			System.out.print(rs.getLong(1));
			System.out.print("\t" + rs.getString(2));
			System.out.print("\t" + rs.getString(3));
		}
		rs.close();
		return customerModel;
	}

	public static List<CustomerModel> search() throws Exception {
		Connection conn = (Connection) DriverManager.getConnection(
				"jdbc:mysql://localhost:3306/test1", "root", "root");
		PreparedStatement ps = (PreparedStatement) conn
				.prepareStatement("select * from Customer");
		ResultSet rs = ps.executeQuery();
		System.out.println("Record Get List Search Method() ");

		List list = new ArrayList();
		while (rs.next()) {
			CustomerModel customerModel = new CustomerModel();

			customerModel.setId(rs.getInt(1));
			customerModel.setName(rs.getString(2));
			customerModel.setCity(rs.getString(3));

			list.add(customerModel);

			System.out.print(rs.getLong(1));
			System.out.print("\t" + rs.getString(2));
			System.out.print("\t" + rs.getString(3));
			System.out.println();
		}
		return list;
	}

	public static List<CustomerModel> search(CustomerModel customerModel)
			throws Exception {
		Connection conn = (Connection) DriverManager.getConnection(
				"jdbc:mysql://localhost:3306/test1", "root", "root");
		StringBuffer sql = new StringBuffer("select * from Customer where true");

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
			System.out.print(rs.getLong(1));
			System.out.print("\t" + rs.getString(2));
			System.out.print("\t" + rs.getString(3));
			System.out.println();
		}
		return list;
	}

	public static List<CustomerModel> search(int pageNo, int pageSize)
			throws Exception {
		ArrayList list = new ArrayList();
		StringBuffer sql = new StringBuffer("select * from Customer where true");
		if (pageSize > 0) {
			// Calculate start record index
			pageNo = (pageNo - 1) * pageSize;
			sql.append(" limit " + pageNo + "," + pageSize);
		}
		Connection conn = (Connection) DriverManager.getConnection(
				"jdbc:mysql://localhost:3306/test1", "root", "root");

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

			System.out.print(rs.getLong(1));
			System.out.print("\t" + rs.getString(2));
			System.out.print("\t" + rs.getString(3));
			System.out.println();
		}
		rs.close();
		return list;
	}

	public static void main(String[] args) throws Exception {
		CustomerModel m = new CustomerModel();

		/*// Add Method
		m.setId(10);
		m.setName("Hemendra");
		m.setCity("Bhopal");
		add(m);*/

		/*// Delete Method
		m.setId(2);
		delete(m);*/

		/*// Update Method
		m.setId(1);
		m.setName("SunRays");
		m.setCity("Indore");
		update(m);*/

		/*// FindByPk() Method
		m.setId(1);
		findByPk(m);*/

		/*// FindByName() Method
		m.setName("SunRays");
		findByName(m);*/

		/*// Serach By List Method
		search();*/

		/*// Search List Method Filter By Name
		m.setName("Hemendra");
		search(m);*/

		// Search PageNo pageSize
		search(1, 3);

	}
}
