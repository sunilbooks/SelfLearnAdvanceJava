package com.sunilbooks.session;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.sun.jmx.snmp.Enumerated;

/**
 * Prints session details and its attributes
 * 
 * @version 1.0
 * @since 01 June 2015
 * @author Sunil Sahu
 * @Copyright (c) Sunil Sahu
 * @url www.sunilbooks.com
 * 
 */
@WebServlet(urlPatterns = "/GetSession")
public class GetSession extends HttpServlet {

	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		HttpSession session = request.getSession();

		String country = (String) session.getAttribute("country");

		response.setContentType("text/html");
		PrintWriter out = response.getWriter();

		out.println("<html><body>");

		out.println("<h1>Session Information</h1>");
		out.println("Session ID = " + session.getId());
		out.println("<BR>");

		out.println("Is New = " + session.isNew());
		out.println("<BR>");

		out.println("Created Time = " + new Date(session.getCreationTime()));
		out.println("<BR>");

		out.println("Last access time = "
				+ new Date(session.getLastAccessedTime()));

		out.println("<h1>Get Session</h1>");
		out.println("Country = " + country);
		out.println("<BR>");

		out.println("<h1>Session Attributes</h1>");

		String name = null;
		String value = null;
		// Get all attribute names
		Enumeration<String> e = session.getAttributeNames();
		while (e.hasMoreElements()) {
			name = e.nextElement();
			value = (String) session.getAttribute(name);
			out.println(name + " = " + value);
			out.println("<BR>");
		}

		out.println("</body></html>");
	}

}
