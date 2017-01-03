package com.sunilbooks.listener;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextAttributeEvent;
import javax.servlet.ServletContextAttributeListener;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

/**
 * Listens ServletContext attribute events
 * 
 * @version 1.0
 * @since 01 June 2015
 * @author Sunil Sahu
 * @Copyright (c) Sunil Sahu
 * @url www.sunilbooks.com
 */

@WebListener
public class MyServletContextAttribListener implements
		ServletContextAttributeListener {

	@Override
	public void attributeAdded(ServletContextAttributeEvent e) {
		ServletContext ctx = e.getServletContext();
		System.out.println("attributeAdded" + e.getName());

	}

	@Override
	public void attributeRemoved(ServletContextAttributeEvent e) {
		ServletContext ctx = e.getServletContext();
		System.out.println("attributeRemoved" +  e.getName());

	}

	@Override
	public void attributeReplaced(ServletContextAttributeEvent e) {
		ServletContext ctx = e.getServletContext();
		System.out.println("attributeReplaced" +  e.getName());

	}

}
