package com.sunilbooks.jdbc;

import java.io.FileReader;
import java.io.IOException;

/**
 * Simple test of try-with-resources statement with IO classes. This statement
 * is available in JDK 1.7
 * 
 * FileReader object will be closed after the execution of block, whether try
 * block is executed normally or IOException is raised.
 * 
 * @version 1.0
 * @since 01 June 2015
 * @author Sunil Sahu
 * @Copyright (c) Sunil Sahu
 * @url www.sunilbooks.com
 */

public class TryWithResourcesTest {

	public static void main(String[] args) {
		try (FileReader in = new FileReader("c:/test.txt")) {
			System.out.println(in.read());
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
	}

}
