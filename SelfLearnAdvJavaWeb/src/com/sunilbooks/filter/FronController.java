package com.sunilbooks.filter;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

import javax.servlet.DispatcherType;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import sun.security.krb5.Config;

/**
 * Front controller intercepts all requests matching url pattern /app/* and
 * authorize user. If user is not logged-in then add an error message to request
 * object and forward request to Login.jsp page.
 * 
 * @version 1.0
 * @since 01 June 2015
 * @author Sunil Sahu
 * @Copyright (c) Sunil Sahu
 * @url www.sunilbooks.com
 * 
 */

@WebFilter(urlPatterns = "/app/*", dispatcherTypes={DispatcherType.REQUEST, DispatcherType.FORWARD})
public class FronController implements Filter {

	private static final long serialVersionUID = 1L;

	private FilterConfig conf = null;

	@Override
	public void destroy() {
	}

	@Override
	public void doFilter(ServletRequest req, ServletResponse res,
			FilterChain chain) throws IOException, ServletException {

		// Get Session object
		HttpServletRequest httpReq = (HttpServletRequest) req;
		HttpSession session = httpReq.getSession();

		// Get User id from session
		String userId = (String) session.getAttribute("userId");

		if (userId == null) {
			req.setAttribute("error",
					"OOPS your session has been expired, please relogin!");
			RequestDispatcher rd = req.getRequestDispatcher("/Login.jsp");
			rd.forward(req, res);
		} else {
			chain.doFilter(req, res);
		}
	}

	@Override
	public void init(FilterConfig conf) throws ServletException {
		this.conf = conf;
	}

}
