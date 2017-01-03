package com.sunilbooks.cookie;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Sets the cookie
 * 
 * @version 1.0
 * @since 01 June 2015
 * @author Sunil Sahu
 * @Copyright (c) Sunil Sahu
 * @url www.sunilbooks.com
 * 
 */
@WebServlet(urlPatterns = { "/SetCookie" })
public class SetCookie extends HttpServlet {

	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		String name = request.getParameter("name");
		String value = request.getParameter("value");


		// Create cookie
		Cookie c = new Cookie(name, value);
		c.setMaxAge(3600);
		//c.setDomain("www.sunilbooks.com");

		// Add cookie to response
		response.addCookie(c);

		response.setContentType("text/html");

		PrintWriter out = response.getWriter();

		out.println("<html><body>");

		out.println("<h3>Set Cookie</h3>");

		out.println(name + "=" + value);

		out.println("</body></html>");
	}

}
