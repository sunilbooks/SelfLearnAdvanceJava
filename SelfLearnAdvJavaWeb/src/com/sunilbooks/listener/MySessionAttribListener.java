package com.sunilbooks.listener;

import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionAttributeListener;
import javax.servlet.http.HttpSessionBindingEvent;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

/**
 * Listens HttpServletContext attributes events
 * 
 * @version 1.0
 * @since 01 June 2015
 * @author Sunil Sahu
 * @Copyright (c) Sunil Sahu
 * @url www.sunilbooks.com
 */

@WebListener
public class MySessionAttribListener implements HttpSessionAttributeListener {

	@Override
	public void attributeAdded(HttpSessionBindingEvent e) {
		HttpSession s = e.getSession();
		System.out.println("Added " + e.getName());
	}

	@Override
	public void attributeRemoved(HttpSessionBindingEvent e) {
		HttpSession s = e.getSession();
		System.out.println("Removed " + e.getName());
	}

	@Override
	public void attributeReplaced(HttpSessionBindingEvent e) {
		HttpSession s = e.getSession();
		System.out.println("Replaced " + e.getName());
	}

}
