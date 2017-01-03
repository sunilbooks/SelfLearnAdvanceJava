package com.sunilbooks.listener;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

/**
 * Listens ServletContext lifecycle events
 * 
 * @version 1.0
 * @since 01 June 2015
 * @author Sunil Sahu
 * @Copyright (c) Sunil Sahu
 * @url www.sunilbooks.com
 */

@WebListener
public class MyServletContextLifeListener implements ServletContextListener {

	@Override
	public void contextDestroyed(ServletContextEvent e) {
		ServletContext ctx = e.getServletContext();
		System.out.println("contextDestroyed" + ctx.getContextPath());
	}

	@Override
	public void contextInitialized(ServletContextEvent e) {
		ServletContext ctx = e.getServletContext();
		System.out.println("contextInitialized" + ctx.getContextPath());

	}

}
