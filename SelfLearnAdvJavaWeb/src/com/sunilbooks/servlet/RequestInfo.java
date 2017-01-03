package com.sunilbooks.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Displays information of Client's request
 * 
 * @version 1.0
 * @since 01 June 2015
 * @author Sunil Sahu
 * @Copyright (c) Sunil Sahu
 * @url www.sunilbooks.com
 * 
 */
@WebServlet(urlPatterns = { "/RequestInfo" })
public class RequestInfo extends HttpServlet {

	private static final long serialVersionUID = 1L;

	/**
	 * Handles GET request. Default request is GET.
	 */
	protected void doGet(HttpServletRequest req,
			HttpServletResponse res) throws ServletException, IOException {

		res.setContentType("text/html");
		
		PrintWriter out = res.getWriter();
		
		out.println("<html><body>");

		out.println("<h3>Request Information</h3>");

		// Method of request GET/POST/OUT/DELETE etc.
		out.println("Method: " + req.getMethod());
		out.println("<BR>");
		// Name of servlet or JSP
		out.println("Request URI: " + req.getRequestURI());
		out.println("<BR>");

		out.println("Query String: " + req.getQueryString());
		out.println("<BR>");

		// Request protocol
		out.println("Protocol: " + req.getProtocol());
		out.println("<BR>");

		// Request Path
		out.println("Servlet Path: " + req.getServletPath());
		out.println("<BR>");

		// IP Address of Client
		out.println("Client IP: " + req.getRemoteAddr());
		out.println("<BR>");
		
		out.println("Server Name: " + req.getServerName());
		out.println("<BR>");

		out.println("Server Port: " + req.getServerPort());
		out.println("<BR>");

		out.println("Content Type: " + req.getContentType());
		out.println("<BR>");
		
		out.println("Content Length: " + req.getContentLength());
		out.println("<BR>");

		out.println("Context Path: " + req.getContextPath());
		out.println("<BR>");

		out.println("</body></html>");
	}

}
