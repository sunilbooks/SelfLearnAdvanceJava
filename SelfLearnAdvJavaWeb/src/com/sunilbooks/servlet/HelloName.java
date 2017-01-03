package com.sunilbooks.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Read input parameters from request.
 * 
 * @version 1.0
 * @since 01 June 2015
 * @author Sunil Sahu
 * @Copyright (c) Sunil Sahu
 * @url www.sunilbooks.com
 * 
 */
@WebServlet(urlPatterns = { "/HelloName" })
public class HelloName extends HttpServlet {

	private static final long serialVersionUID = 1L;

	/**
	 * Handles GET request. Default request is GET.
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		// Get parameters from request
		String name = request.getParameter("name");
		String address = request.getParameter("address");
		
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();

		out.println("<HTML><BODY>");
		out.println("<H1>Hello " + name + " !</H1>");
		out.println("<H2>" + address + "</H2>");
		out.println("</BODY></HTML>");
		out.close();
	}
}
