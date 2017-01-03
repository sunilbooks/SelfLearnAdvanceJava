package com.sunilbooks.jdbc;

import java.util.ArrayList;

/**
 * Testcase of MarksheetModel class.
 * 
 * @version 1.0
 * @since 01 June 2015
 * @author Sunil Sahu
 * @Copyright (c) Sunil Sahu
 * @url www.sunilbooks.com
 */

public class TestMarksheetModel {

	public static void main(String[] args) throws Exception {
		testGet();
		testMeritList();
		testSearch();
		testAdd();
		testUpdate();
		testDelete();
	}

	/**
	 * Tests get method of MarksheetModel
	 * 
	 * @throws Exception
	 */

	public static void testGet() {

		System.out.println("\nTesting get method.");

		// Creates Model instance
		MarksheetModel model = new MarksheetModel();

		try {
			// Gets Marksheet
			Marksheet bean = model.get("A1");
			System.out.println("Roll No " + bean.getRollNo());
			System.out.println("Name " + bean.getName());
			System.out.println("Maths " + bean.getMaths());
			System.out.println("Chemistry " + bean.getChemistry());
			System.out.println("Physics " + bean.getPhysics());

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	/**
	 * Tests MeritList method of MarksheetModel
	 * 
	 * @throws Exception
	 */

	public static void testMeritList() {

		System.out.println("\nTesting meritList method.");

		// Creates Model instance
		MarksheetModel model = new MarksheetModel();

		try {
			ArrayList<Marksheet> list = model.getMeritList();

			System.out.println("Roll No\tName\tMaths\tPhysics\tChemistry");
			for (Marksheet marskheet : list) {
				System.out.print(marskheet.getRollNo());
				System.out.print("\t");
				System.out.print(marskheet.getName());
				System.out.print("\t");
				System.out.print(marskheet.getMaths());
				System.out.print("\t");
				System.out.print(marskheet.getPhysics());
				System.out.print("\t");
				System.out.println(marskheet.getChemistry());
			}

		} catch (Exception e1) {
			e1.printStackTrace();
		}
	}

	/**
	 * Tests search method of MarksheetModel
	 * 
	 * @throws Exception
	 */

	public static void testSearch() {

		System.out.println("\nTesting search method.");

		// Creates Model instance
		MarksheetModel model = new MarksheetModel();
		Marksheet marksheet = new Marksheet();
		marksheet.setName("Yuvraj");

		try {

			ArrayList<Marksheet> list = model.search(marksheet);

			System.out.println("Roll No\tName\tMaths\tPhysics\tChemistry");
			for (Marksheet marskheet : list) {
				System.out.print(marskheet.getRollNo());
				System.out.print("\t");
				System.out.print(marskheet.getName());
				System.out.print("\t");
				System.out.print(marskheet.getMaths());
				System.out.print("\t");
				System.out.print(marskheet.getPhysics());
				System.out.print("\t");
				System.out.println(marskheet.getChemistry());
			}

		} catch (Exception e1) {
			e1.printStackTrace();
		}
	}

	/**
	 * Tests add method of MarksheetModel
	 * 
	 * @throws Exception
	 */
	public static void testAdd() {

		Marksheet bean = new Marksheet();

		bean.setRollNo("B1");
		bean.setName("Saniya Mirja");
		bean.setMaths(50);
		bean.setChemistry(0);
		bean.setPhysics(60);

		// Creates Model instance
		MarksheetModel model = new MarksheetModel();

		try {
			// Adds a Marksheet
			model.add(bean);

			bean = model.get("B1");
			if (bean == null) {
				System.err.println("Add fail");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	/**
	 * Tests delete a Marksheet
	 */
	public static void testDelete() {

		MarksheetModel model = new MarksheetModel();

		// Create Model instance
		try {
			model.delete("B1");
			Marksheet deletedbean = model.get("B1");
			if (deletedbean != null) {
				System.err.println("Delete fail");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Tests update a Marksheet
	 */
	public static void testUpdate() {

		MarksheetModel model = new MarksheetModel();

		try {

			Marksheet bean = model.get("A1");
			bean.setMaths(66);
			model.update(bean);

			Marksheet updatedbean = model.get("A1");

			if (updatedbean.getMaths() != 66) {
				System.err.println("Update fail");
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}
