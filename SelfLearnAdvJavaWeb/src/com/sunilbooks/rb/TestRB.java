package com.sunilbooks.rb;

import java.util.ResourceBundle;
/**
 * @version 1.0
 * @since 01 June 2015
 * @author Sunil Sahu
 * @Copyright (c) Sunil Sahu
 * @url www.sunilbooks.com
 */
public class TestRB {

	public static void main(String[] args) {

		ResourceBundle rb 
		= ResourceBundle.getBundle("com.sunilbooks.config");

		String dbUrl = rb.getString("db.url");
		String dbdriver = rb.getString("db.driver");
		
		System.out.println(dbUrl);

		
	}

}
