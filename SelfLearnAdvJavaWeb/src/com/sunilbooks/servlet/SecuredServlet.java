package com.sunilbooks.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.HttpConstraint;
import javax.servlet.annotation.HttpMethodConstraint;
import javax.servlet.annotation.ServletSecurity;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Apply role based security to the servlet using @ServletSecurity annotation
 * 
 * @version 1.0
 * @since 01 June 2015
 * @author Sunil Sahu
 * @Copyright (c) Sunil Sahu
 * @url www.sunilbooks.com
 */
@WebServlet(urlPatterns = "/SecuredServlet")
@ServletSecurity(value = @HttpConstraint(rolesAllowed = { "tomcat" }), httpMethodConstraints = {
		@HttpMethodConstraint(value = "GET", rolesAllowed = "tomcat"),
		@HttpMethodConstraint(value = "POST", rolesAllowed = "tomcat") })
public class SecuredServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	/**
	 * Handles GET request. Default request is GET.
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		response.setContentType("text/html");
		PrintWriter out = response.getWriter();

		out.println("<HTML><BODY>");
		out.println("<H1>You can see this Servlet after authentication</H1>");
		out.println("</BODY></HTML>");
		out.close();
	}

	/**
	 * Handles POST request
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
