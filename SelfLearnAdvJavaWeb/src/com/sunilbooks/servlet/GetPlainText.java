package com.sunilbooks.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Example of Response object that returns plain text. Servlet returns plain
 * text as response to the client request.
 * 
 * @version 1.0
 * @since 01 June 2015
 * @author Sunil Sahu
 * @Copyright (c) Sunil Sahu
 * @url www.sunilbooks.com
 * 
 */

@WebServlet(urlPatterns = { "/GetPlainText" })
public class GetPlainText extends HttpServlet {

	/**
	 * Handles GET request. Default request is GET.
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		// Set MIME type to plain text.
		response.setContentType("text/plain");

		PrintWriter out = response.getWriter();

		out.println("This is plian text, returned as response.");
		out.println("You must set content type text/plain.");

		out.close();
	}

}
