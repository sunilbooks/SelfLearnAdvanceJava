package com.sunilbooks.rb;

import java.util.Locale;
import java.util.ResourceBundle;
/**
 *
 * @version 1.0
 * @since 01 June 2015
 * @author Sunil Sahu
 * @Copyright (c) Sunil Sahu
 * @url www.sunilbooks.com
 */
public class TestLanguage {

	public static void main(String[] args) {

		String lang = "en";
		Locale l = new Locale(lang);
		ResourceBundle rb = ResourceBundle.getBundle("com.sunilbooks.language",
				l);

		System.out.println("ID: " + rb.getString("id"));
		System.out.println("PWD: " + rb.getString("password"));

	}

}
