package com.sunilbooks.listener;

import java.util.Date;

import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

/**
 * Listens HttpServletContext lifecycle events
 * 
 * @version 1.0
 * @since 01 June 2015
 * @author Sunil Sahu
 * @Copyright (c) Sunil Sahu
 * @url www.sunilbooks.com
 */

@WebListener
public class MySessionLifeListener implements HttpSessionListener {

	public void sessionCreated(HttpSessionEvent e) {
		HttpSession s = e.getSession();
		Date d = new Date();
		System.out.print("Session: " + s.getId());
		System.out.println("Created @" + d);
	}

	@Override
	public void sessionDestroyed(HttpSessionEvent e) {
		HttpSession s = e.getSession();
		Date d = new Date();
		System.out.print("Session: " + s.getId());
		System.out.println("Destroyed @" + d);
	}
}
