package com.sunilbooks.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Example of Response header, it will refresh this servlet in every 5 seconds.
 * 
 * @version 1.0
 * @since 01 June 2015
 * @author Sunil Sahu
 * @Copyright (c) Sunil Sahu
 * @url www.sunilbooks.com
 * 
 */
@WebServlet(urlPatterns = "/PageRefresh" )
public class PageRefresh extends HttpServlet {

	private static final long serialVersionUID = 1L;

	/**
	 * Handles GET request. Default request is GET.
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		// Set MIME type to text/Html
		response.setContentType("text/html");

		// Set refresh, autoload time as 5 seconds
		response.setIntHeader("Refresh", 5);

		Date d = new Date();

		PrintWriter out = response.getWriter();
		
		response.getWriter();
		
		out.println("<html><body>");
		out.println("<h1>Last Call</h1>");
		out.println("<h2>" + d + "</h2>");
		out.println("</body></html>");
	}
}
