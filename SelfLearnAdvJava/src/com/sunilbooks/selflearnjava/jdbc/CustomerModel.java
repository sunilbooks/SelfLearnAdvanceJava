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

	public static long add(CustomerModel customerModel) throws Exception {
		Class.forName("com.mysql.jdbc.Driver");
		Connection conn = (Connection) DriverManager.getConnection(
				"jdbc:mysql://localhost:3306/test1", "root", "root");

		PreparedStatement ps = (PreparedStatement) conn
				.prepareStatement("insert into Customer values(?,?,?)");
		System.out.println("in Add service");
		ps.setLong(1, customerModel.getId());
		ps.setString(2, customerModel.getName());
		ps.setString(3, customerModel.getCity());

		int i = ps.executeUpdate();
		System.out.println("Record insert ");
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

	public List<CustomerModel> search()  {
		
		return null;
	}

	public static List<CustomerModel> search(int pageNo, int pageSize) throws Exception {
		ArrayList list = new ArrayList();
		StringBuffer sql = new StringBuffer("select * from ST_USER");
		if (pageSize > 0) {
			// Calculate start record index
			pageNo = (pageNo - 1) * pageSize;
			sql.append(" limit " + pageNo + "," + pageSize);
		}
		Connection conn = (Connection) DriverManager.getConnection(
				"jdbc:mysql://localhost:3306/test1", "root", "root");

		PreparedStatement ps = (PreparedStatement) conn
				.prepareStatement(sql.toString());
		System.out.println("in List Service");
		

		ResultSet rs = ps.executeQuery();

		System.out.println("Record List");
		System.out.println("ID\t" + "Name\t" + "City");
		while (rs.next()) {
		CustomerModel customerModel = new CustomerModel();
			customerModel.setId(rs.getLong(1));
			customerModel.setName(rs.getString(2));
			customerModel.setCity(rs.getString(3));
			
			list.add(customerModel);
			
			System.out.print(rs.getLong(1));
			System.out.print("\t" + rs.getString(2));
			System.out.print("\t" + rs.getString(3));
		}
		rs.close();
		return list;
	}

	public static void main(String[] args) throws Exception {
		CustomerModel m = new CustomerModel();

	/*	// Add Method
		m.setId(2);
		m.setName("Sunrays");
		m.setCity("Technoogies");
		add(m);

		// Delete Method
		m.setId(2);
		delete(m);

		// Update Method
		m.setId(1);
		m.setName("SunRays");
		m.setCity("Indore");
		update(m);

		// findByPk() Method
		m.setId(1);
		findByPk(m);
*/
		// findByName() Method
		//m.setName("SunRays");
		//findByName(m);
		
		
		
		// Search
		CustomerModel s = new CustomerModel(); s.setName("Sunil");
		 List l = s.search();
		 

	}

}

