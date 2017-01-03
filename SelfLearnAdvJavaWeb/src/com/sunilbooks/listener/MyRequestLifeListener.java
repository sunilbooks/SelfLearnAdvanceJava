package com.sunilbooks.listener;

import javax.servlet.ServletRequest;
import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;
import javax.servlet.annotation.WebListener;

/**
 * Listens HttpServletRequest lifecycle events
 * 
 * @version 1.0
 * @since 01 June 2015
 * @author Sunil Sahu
 * @Copyright (c) Sunil Sahu
 * @url www.sunilbooks.com
 */

@WebListener
public class MyRequestLifeListener implements ServletRequestListener {

	@Override
	public void requestDestroyed(ServletRequestEvent e) {
		ServletRequest req = e.getServletRequest();
		System.out.println("requestDestroyed" + req.getRemoteAddr());
	}

	@Override
	public void requestInitialized(ServletRequestEvent e) {
		ServletRequest req = e.getServletRequest();
		System.out.println("requestInitialized" + req.getRemoteAddr());
	}

}
