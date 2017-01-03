package com.sunilbooks.log;

import org.apache.log4j.Logger;
/**
 * Test Log
 * 
 * @version 1.0
 * @since 01 June 2015
 * @author Sunil Sahu
 * @Copyright (c) Sunil Sahu
 * @url www.sunilbooks.com
 */

public class TestLog {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Logger log = Logger.getLogger(TestLog.class);

		// Print messages
		log.debug("This is Debug Statement");
		log.info("This is Info Statement");
		log.warn("This is Warn Statement");
		log.error("This is Error Statement");
		log.fatal("This is Fatal Statement");

		int i = 0;
		try {
			int x = 5 / i;
		} catch (RuntimeException e) {
			log.error("My Error ", e);
		}

	}

}
