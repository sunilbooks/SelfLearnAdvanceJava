package com.sunilbooks.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Reads visitor count from context and after incrementing store count back to
 * context.
 * 
 * @version 1.0
 * @since 01 June 2015
 * @author Sunil Sahu
 * @Copyright (c) Sunil Sahu
 * @url www.sunilbooks.com
 * 
 */
@WebServlet(urlPatterns = "/VisitorCount")
public class VisitorCount extends HttpServlet {

	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		ServletContext ctx = getServletContext();

		// Get user visit count
		Integer count = (Integer) ctx.getAttribute("visitCount");

		// Increase count
		if (count == null) {
			count = 1;
		} else {
			count++;
		}

		ctx.setAttribute("visitCount", count);

		response.setContentType("text/html");

		PrintWriter out = response.getWriter();

		out.println("<html><body>");
		// Get all attributes from context
		out.println("<h1>Visitor Count: " + count + "</h1>");

		out.println("</body></html>");
	}

}
