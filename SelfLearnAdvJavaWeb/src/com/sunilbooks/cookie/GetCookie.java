package com.sunilbooks.cookie;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Gets the cookie
 * 
 * @version 1.0
 * @since 01 June 2015
 * @author Sunil Sahu
 * @Copyright (c) Sunil Sahu
 * @url www.sunilbooks.com
 * 
 */
@WebServlet(urlPatterns = { "/GetCookie" })
public class GetCookie extends HttpServlet {

	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		//Get Cookies
		Cookie[] cArray = request.getCookies();
		System.out.println("Size " +cArray.length);
		
		String name = null;
		String value = null;

		response.setContentType("text/html");
		PrintWriter out = response.getWriter();

		out.println("<html><body>");
		out.println("<h3>Get Cookie</h3>");

		//Print all cookies
		for(Cookie c: cArray){
			name = c.getName();
			value = c.getValue();
			out.println(name + "=" + value );
			out.println("<br>");
		}
		out.println("</body></html>");
	}

}
