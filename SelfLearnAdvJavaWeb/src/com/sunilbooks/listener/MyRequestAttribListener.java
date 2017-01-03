package com.sunilbooks.listener;

import javax.servlet.ServletRequest;
import javax.servlet.ServletRequestAttributeEvent;
import javax.servlet.ServletRequestAttributeListener;
import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;
import javax.servlet.annotation.WebListener;

/**
 * Listens HttpServletRequest attributes events
 * 
 * @version 1.0
 * @since 01 June 2015
 * @author Sunil Sahu
 * @Copyright (c) Sunil Sahu
 * @url www.sunilbooks.com
 */

@WebListener
public class MyRequestAttribListener implements ServletRequestAttributeListener {

	@Override
	public void attributeAdded(ServletRequestAttributeEvent e) {
		ServletRequest req = e.getServletRequest();
		System.out.println("attributeAdded" + e.getName());
	}

	@Override
	public void attributeRemoved(ServletRequestAttributeEvent e) {
		ServletRequest req = e.getServletRequest();
		System.out.println("attributeRemoved" + e.getName());
	}

	@Override
	public void attributeReplaced(ServletRequestAttributeEvent e) {
		ServletRequest req = e.getServletRequest();
		System.out.println("attributeReplaced" + e.getName());
	}

}
