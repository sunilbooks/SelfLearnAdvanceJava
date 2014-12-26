package com.sunilbooks.selflearnjava.jdbc;

import java.util.List;

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

	public long add() {
		return 0;
	}

	public long delete() {
		return 0;
	}

	public long update() {
		return 0;
	}

	public CustomerModel findByPk() {
		return null;
	}

	public CustomerModel findByName() {
		return null;
	}

	public List<CustomerModel> search() {
		return null;
	}

	public List<CustomerModel> search(int page, int size) {
		return null;
	}

	public static void main(String[] args) {
		CustomerModel m = new CustomerModel();
		m.setId(1);
		m.setName("Pankaj");
		m.setCity("Indore");
		m.add();
		
		//Search
		CustomerModel s = new CustomerModel();
		s.setName("Sunil");
		List l = s.search();
		
		
		

	}

}
