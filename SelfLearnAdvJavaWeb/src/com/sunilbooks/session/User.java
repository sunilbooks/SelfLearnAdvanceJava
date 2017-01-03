package com.sunilbooks.session;

import java.util.Date;

import javax.servlet.http.HttpSessionBindingEvent;
import javax.servlet.http.HttpSessionBindingListener;

/**
 * UserContext listens the session events when bound or unbound from session
 * 
 * @version 1.0
 * @since 01 June 2015
 * @author Sunil Sahu
 * @Copyright (c) Sunil Sahu
 * @url www.sunilbooks.com
 */
public class User implements HttpSessionBindingListener {

	private String name = null;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public void valueBound(HttpSessionBindingEvent e) {
		User user = (User) e.getValue();
		Date d = new Date();
		System.out.println("User bound " + d);
	}

	@Override
	public void valueUnbound(HttpSessionBindingEvent e) {
		User user = (User) e.getValue();
		Date d = new Date();
		System.out.println("User unbound " + d);
	}

}
