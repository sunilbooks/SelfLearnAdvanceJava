package com.sunilbooks.filter;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;

import sun.security.krb5.Config;

/**
 * Test Filter that performs pre and post processing on a Servlet.
 * 
 * @version 1.0
 * @since 01 June 2015
 * @author Sunil Sahu
 * @Copyright (c) Sunil Sahu
 * @url www.sunilbooks.com
 * 
 */

public class MyFilter implements Filter {

	private static final long serialVersionUID = 1L;

	private FilterConfig conf = null;

	@Override
	public void destroy() {
		System.out.println("Filter is destroyed " + conf.getFilterName());

	}

	@Override
	public void doFilter(ServletRequest req, ServletResponse res,
			FilterChain chain) throws IOException, ServletException {
		
		String login = conf.getInitParameter("login");
		System.out.println("Login value " + login);

		Enumeration<String> e = conf.getInitParameterNames();
		ServletContext ctx = conf.getServletContext();
		
		
		PrintWriter out = res.getWriter();
		// Pre processing
		out.println("<H2>Pre Hello</H2><HR>");

		// call next filter or target servlet
		chain.doFilter(req, res);

		// Post Processing
		System.out.println("Post Processing " + conf.getFilterName());
		//out = res.getWriter();
		out.println("<HR><H2>Post Hello</H2>");
		//out.flush();
	}

	@Override
	public void init(FilterConfig conf) throws ServletException {
		this.conf = conf;
		System.out.println("Filter is instantiated " + conf.getFilterName());
	}

}
