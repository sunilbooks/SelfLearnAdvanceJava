package com.sunilbooks.test;

/**
 * 
 * @version 1.0
 * @since 01 June 2015
 * @author Sunil Sahu
 * @Copyright (c) Sunil Sahu
 * @url www.sunilbooks.com
 * 
 */

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertNull;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;

import com.sunilbooks.model.UserModel;

public class UserModelTest {

	@BeforeClass
	public static void beforeClass() throws Exception {
		System.out.println("Called only once before Testcase");
	}

	@AfterClass
	public static void afterClass() throws Exception {
		System.out.println("Called only once after Testcase");
	}

	@Before
	public void beforeTest() throws Exception {
		System.out.println("Executed before each test method");
	}

	@After
	public void afterTest() throws Exception {
		System.out.println("Executed after each test method");
	}

	/**
	 * tests add() method
	 * 
	 * @throws Exception
	 */
	@Ignore
	public void testAdd() throws Exception {

		UserModel model = new UserModel();
		model.setId(5);
		model.setFirstName("Shyam");
		model.setLastName("Yadav");
		model.setLogin("shyam");
		model.setPassword("shyam");
		model.setGender("Male");

		int i = model.add();

		model = model.get(5);

		assertNotNull("User is not added", model);

	}

	@Ignore
	public void testUpdate() throws Exception {

		System.out.println("**Test Update**");

		UserModel model = new UserModel();
		model.setId(5);
		model.setFirstName("Shyam");
		model.setLastName("Yadav123");
		model.setLogin("shyam");
		model.setPassword("shyam");
		model.setGender("Male");
		int i = model.update();
		assertTrue("User is not added", i == 1);

		System.out.println("-----------------------");

	}

	@Ignore
	public void testDelete() throws Exception {

		System.out.println("**Test Update**");

		UserModel model = new UserModel();
		model.setId(5);
		model.delete();

		model = model.get(5);
		assertNull("User is not deleted", model);

		System.out.println("-----------------------");

	}

	@Ignore
	public void testAuthenticate() throws Exception {

		System.out.println("**Test Authenticate**");

		UserModel model = new UserModel();
		model = model.authenticate("ram", "ram");
		System.out.println("First Name:" + model.getFirstName());
		System.out.println("Last Name:" + model.getLastName());
		System.out.println("Login:" + model.getLogin());
		System.out.println("Password:" + model.getPassword());
		System.out.println("Gender:" + model.getGender());
		assertNotNull("User is not added", model);

		System.out.println("-----------------------");

	}

	@Test
	public void testGet() throws Exception {

		System.out.println("**Test Get**");

		UserModel model = new UserModel();
		model = model.get(1);

		System.out.println("First Name:" + model.getFirstName());
		System.out.println("Last Name:" + model.getLastName());
		System.out.println("Login:" + model.getLogin());
		System.out.println("Password:" + model.getPassword());
		System.out.println("Gender:" + model.getGender());

		assertNotNull("User is not added", model);

		System.out.println("-----------------------");

	}

	@Ignore
	public void testLoad() throws Exception {

		System.out.println("**Test Load**");

		UserModel model = new UserModel();
		model.load(1);

		System.out.println("First Name:" + model.getFirstName());
		System.out.println("Last Name:" + model.getLastName());
		System.out.println("Login:" + model.getLogin());
		System.out.println("Password:" + model.getPassword());
		System.out.println("Gender:" + model.getGender());
		assertNotNull("User is not added", model);
	}

}
