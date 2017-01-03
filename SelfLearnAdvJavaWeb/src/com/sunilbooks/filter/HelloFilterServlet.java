package com.sunilbooks.filter;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Hello Servlet to test Filter behavior
 * 
 * @version 1.0
 * @since 01 June 2015
 * @author Sunil Sahu
 * @Copyright (c) Sunil Sahu
 * @url www.sunilbooks.com
 */

@WebServlet(name="HelloFilterServlet",  urlPatterns = "/HelloFilter")
public class HelloFilterServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		// Get writer object
		PrintWriter out = response.getWriter();
		// Write reponse text
		out.println("<H1>Hello Filter!</H1>");
	}
}
