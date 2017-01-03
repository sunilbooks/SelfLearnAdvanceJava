package com.sunilbooks.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import java.util.Enumeration;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.catalina.deploy.SessionConfig;

import com.sun.jmx.snmp.Enumerated;

/**
 * Reads initialization parameters and attributes from session context object.
 * 
 * @version 1.0
 * @since 01 June 2015
 * @author Sunil Sahu
 * @Copyright (c) Sunil Sahu
 * @url www.sunilbooks.com
 * 
 */
@WebServlet(urlPatterns = "/GetContext")
public class GetContext extends HttpServlet {

	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		ServletContext ctx = getServletContext();

		response.setContentType("text/html");

		PrintWriter out = response.getWriter();

		out.println("<html><body>");

		out.println("<h1>All Initialization Parameters</h1>");

		String name = null;
		Object value = null;
		
		// Get all init param names
		Enumeration<String> e = ctx.getInitParameterNames();

		while (e.hasMoreElements()) {
			name = e.nextElement();
			value = ctx.getInitParameter(name);
			out.println("<B>" + name + "</B> = " + value);
			out.println("<BR>");
		}

		out.println("<h1>All Attributes</h1>");

		// Get All Attrbute names
		e = ctx.getAttributeNames();
		while (e.hasMoreElements()) {
			name = e.nextElement();
			value = ctx.getAttribute(name);
			out.println("<B>" + name + "</B> = " + value);
			out.println("<BR>");
		}

		out.println("</body></html>");
	}

}
