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
import javax.servlet.annotation.WebInitParam;

/**
 * Test Filter that performs pre and post processing on a Servlet. It is
 * configured using Annotation.
 * 
 * @version 1.0
 * @since 01 June 2015
 * @author Sunil Sahu
 * @Copyright (c) Sunil Sahu
 * @url www.sunilbooks.com
 * 
 */

@WebFilter(servletNames = "HelloFilterServlet", urlPatterns = "/HelloFilter", initParams = {
		@WebInitParam(name = "login", value = "SunilOSABC"),
		@WebInitParam(name = "pwd", value = "NoPWDABC") })
public class MyFilterA implements Filter {

	private static final long serialVersionUID = 1L;

	private FilterConfig conf = null;

	@Override
	public void destroy() {
		System.out.println("ABC Filter is destroyed " + conf.getFilterName());

	}

	@Override
	public void doFilter(ServletRequest req, ServletResponse res,
			FilterChain chain) throws IOException, ServletException {

		String login = conf.getInitParameter("login");
		System.out.println("A Login value " + login);

		String pwd = conf.getInitParameter("pwd");
		System.out.println("A Pasword value " + pwd);

		Enumeration<String> e = conf.getInitParameterNames();
		ServletContext ctx = conf.getServletContext();

		PrintWriter out = res.getWriter();
		// Pre processing
		out.println("<H2>A Pre Hello</H2><HR>");

		// call next filter or target servlet
		chain.doFilter(req, res);

		// Post Processing
		System.out.println("Post Processing " + conf.getFilterName());
		// out = res.getWriter();
		out.println("<HR><H2>A Post Hello</H2>");
		// out.flush();
	}

	@Override
	public void init(FilterConfig conf) throws ServletException {
		this.conf = conf;
		System.out.println("A Filter is instantiated " + conf.getFilterName());
	}

}
