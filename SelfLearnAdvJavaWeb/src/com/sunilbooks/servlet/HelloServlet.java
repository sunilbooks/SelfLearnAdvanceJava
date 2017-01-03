package com.sunilbooks.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Simple example servlet
 * 
 * @version 1.0
 * @since 01 June 2015
 * @author Sunil Sahu
 * @Copyright (c) Sunil Sahu
 * @url www.sunilbooks.com
 */

public class HelloServlet extends HttpServlet {

	/**
	 * Handles GET request. Default request is GET.
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		// Set content type
		response.setContentType("text/html");

		// Get writer object
		PrintWriter out = response.getWriter();

		// Write reponse text
		out.println("<HTML><BODY>");
		out.println("<H1>Hello Servlet!</H1>");
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
