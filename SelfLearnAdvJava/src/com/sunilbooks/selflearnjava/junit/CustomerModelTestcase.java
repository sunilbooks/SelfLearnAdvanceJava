package com.sunilbooks.selflearnjava.junit;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import org.junit.Ignore;
import org.junit.Test;

import java.util.List;

import com.sunilbooks.selflearnjava.jdbc.CustomerModel;

/**
 * JUnit test case of CustomerModel class.
 * 
 * @version 1.0
 * @since 01 Jan 2015
 * @author Sunil Sahu
 * @Copyright (c) Sunil Sahu
 * @url www.sunilbooks.com
 * 
 */
public class CustomerModelTestcase {

	/**
	 * tests Add method
	 * 
	 * @throws Exception
	 */
	@Ignore
	public void testAdd() throws Exception {

		CustomerModel c = new CustomerModel();
		c.setId(13);
		c.setName("Ravi");
		c.setCity("Indore");
		c.add();

		// Find customer it
		CustomerModel newC = new CustomerModel();
		newC.setId(13);
		newC = newC.findByPk();

		assertNotNull("Error : Customer Add Fail", newC);
	}

	/**
	 * tests Update method
	 * 
	 * @throws Exception
	 */
	@Ignore
	public void testUpdate() throws Exception {

		CustomerModel cm = new CustomerModel();
		cm.setId(13);
		cm.setName("Ravi");
		cm.setCity("Bhopal");
		cm.update();

		CustomerModel newCm = cm.findByPk();

		assertEquals("Error : Test Update Fail", cm.getId(), newCm.getId());

		System.out.println("Success : Test Update Success");
	}

	/**
	 * tests Delete method
	 * 
	 * @throws Exception
	 */
	@Ignore
	public void testDelete() throws Exception {
		CustomerModel cm = new CustomerModel();
		cm.setId(8);
		// Delete
		cm.delete();
		// Find it again
		cm = cm.findByPk();
		// Test fail if record is found
		assertNull("Error : Find by PK ", cm);

	}

	@Test
	public void testFindByPk() throws Exception {

		CustomerModel cm = new CustomerModel();
		cm.setId(13);
		cm = cm.findByPk();

		assertNotNull("Error : Find by PK ", cm);

		System.out.println("Customer Info");
		System.out.println("ID: " + cm.getId());
		System.out.println("Name : " + cm.getName());
		System.out.println("City : " + cm.getCity());

	}

	@Test
	public void testSearch() throws Exception {

		CustomerModel cm = new CustomerModel();
		cm.setCity("Indore");

		List<CustomerModel> list = cm.search();

		assertTrue("Error : Empty list", list.size() > 0);

		System.out.println("Customer List");
		for (CustomerModel c : list) {
			System.out.print(c.getId());
			System.out.print("\t" + c.getName());
			System.out.println("\t" + c.getCity());
		}
	}

	@Test
	public void testSearchByPageSize() throws Exception {

		CustomerModel cm = new CustomerModel();
		cm.setCity("Indore");

		List<CustomerModel> list = cm.search(1, 10);

		assertTrue("Error : Empty list", list.size() > 0);

		System.out.println("Customer List");
		for (CustomerModel c : list) {
			System.out.print(c.getId());
			System.out.print("\t" + c.getName());
			System.out.println("\t" + c.getCity());
		}

	}

}
