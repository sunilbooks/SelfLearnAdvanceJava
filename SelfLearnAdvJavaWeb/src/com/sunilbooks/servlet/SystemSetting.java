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
 * Reads System Setting initialization parameters stored in application scope.
 * 
 * @version 1.0
 * @since 01 June 2015
 * @author Sunil Sahu
 * @Copyright (c) Sunil Sahu
 * @url www.sunilbooks.com
 * 
 */
@WebServlet(urlPatterns = "/SystemSetting")
public class SystemSetting extends HttpServlet {

	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		ServletContext ctx = getServletContext();

		// Get initialization parameter
		// Admin Email ID of applcation
		String adminEmail = ctx.getInitParameter("adminEmail");
		// deafult page size of List page
		String pageSize = ctx.getInitParameter("pageSize");

		// maximum zise of uploaded file
		String fileSize = ctx.getInitParameter("fileSize");

		response.setContentType("text/html");

		PrintWriter out = response.getWriter();

		out.println("<html><body>");

		out.println("<h1>Application Configuration</h1>");

		out.println("Admin Email ID: " + adminEmail);
		out.println("<BR>");
		out.println("Page Size: " + pageSize);
		out.println("<BR>");
		out.println("File Size: " + fileSize);
		out.println("<BR>");
		
		// Get all Init parameters from context
		out.println("<h1>All Init Parameters</h1>");

		// Get all attribute names
		Enumeration<String> e = ctx.getInitParameterNames();
		
		String name = null;
		Object value = null;
		
		while (e.hasMoreElements()) {
			name = e.nextElement();
			value = ctx.getInitParameter(name);
			out.println("<B>" + name + "</B> = " + value);
			out.println("<BR>");
		}

		out.println("</body></html>");
	}

}
