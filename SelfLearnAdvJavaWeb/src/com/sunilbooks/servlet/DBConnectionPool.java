package com.sunilbooks.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Gets database connection parameter from ServletConfig object.
 * 
 * @version 1.0
 * @since 01 June 2015
 * @author Sunil Sahu
 * @Copyright (c) Sunil Sahu
 * @url www.sunilbooks.com
 */

/*
@WebServlet(urlPatterns = "/DBPool", initParams = {
		@WebInitParam(name = "url", value = "com.mysql.jdbc.Driver "),
		@WebInitParam(name = "login", value = "SunilOS"),
		@WebInitParam(name = "password", value = "pass1234") })
*/
public class DBConnectionPool extends HttpServlet {

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		ServletConfig conf = getServletConfig();
		String dbUrl = conf.getInitParameter("url");
		String dbLogin = conf.getInitParameter("login");
		String dbPassword = conf.getInitParameter("password");

		// Set content type
		response.setContentType("text/html");

		// Get writer object
		PrintWriter out = response.getWriter();

		// Write response text
		out.println("<HTML><BODY>");
		out.println("<H1>Servlet Config Parameters</H1>");
		out.println("Url = " + dbUrl);
		out.println("<BR>");
		out.println("Login = " + dbLogin);
		out.println("<BR>");
		out.println("Password = " + dbPassword);
		out.println("<BR>");
		out.println("</BODY></HTML>");
		out.close();
	}

}
