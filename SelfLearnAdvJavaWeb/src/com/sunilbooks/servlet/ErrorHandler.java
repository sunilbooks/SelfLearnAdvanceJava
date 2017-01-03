package com.sunilbooks.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * It handles all uncaught exceptions of application and displays a user
 * friendly message
 * 
 * @version 1.0
 * @since 01 June 2015
 * @author Sunil Sahu
 * @Copyright (c) Sunil Sahu
 * @url www.sunilbooks.com
 */

@WebServlet(urlPatterns = "/ErrorHandler")
public class ErrorHandler extends HttpServlet {

	/**
	 * Handles GET request. Default request is GET.
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		// Analyze the servlet exception and status code that invoked
		// ErrorHandler
		Throwable e = (Throwable) request
				.getAttribute("javax.servlet.error.exception");
		Integer statusCode = (Integer) request
				.getAttribute("javax.servlet.error.status_code");
		String servletName = (String) request
				.getAttribute("javax.servlet.error.servlet_name");

		System.out.println("Exception:" + e);
		System.out.println("Status:" + statusCode);
		System.out.println("servlet Name:" + servletName);

		// Set content type
		response.setContentType("text/html");

		// Get writer object
		PrintWriter out = response.getWriter();

		// Write response text
		out.println("<HTML><BODY>");
		out.println("<H1>Application is down please contact to administrator help@sunilos.com !</H1>");
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
