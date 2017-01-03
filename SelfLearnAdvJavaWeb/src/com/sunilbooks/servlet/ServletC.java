package com.sunilbooks.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Reads login input parameters. It handles GET and POST methods .
 * 
 * @version 1.0
 * @since 01 June 2015
 * @author Sunil Sahu
 * @Copyright (c) Sunil Sahu
 * @url www.sunilbooks.com
 * 
 */
@WebServlet(urlPatterns = "/C")
public class ServletC extends HttpServlet {

	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		// Get parameters from request
		String aValue = (String) request.getAttribute("aVal");
		String bValue = (String) request.getAttribute("bVal");

		response.setContentType("text/html");
		PrintWriter out = response.getWriter();

		out.println("<HTML><BODY>");
		out.println("<H1>Hi I am C Servlet ");
		out.println("<BR>");
		out.println("Value set by A  " + aValue);
		out.println("<BR>");
		out.println("Value set by B " + bValue);
		out.println("</BODY></HTML>");
		out.close();
	}

}
