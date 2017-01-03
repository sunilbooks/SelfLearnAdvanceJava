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
 * Send status code as response
 * 
 * @version 1.0
 * @since 01 June 2015
 * @author Sunil Sahu
 * @Copyright (c) Sunil Sahu
 * @url www.sunilbooks.com
 * 
 */
@WebServlet(urlPatterns = "/StatusCode")
public class SendStatusCode extends HttpServlet {

	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		// response.sendError(406, "This is my status code message!!!");

		/*
		 * String encodeUrl = response.encodeURL("Hello");
		 * System.out.println(encodeUrl); response.sendRedirect(encodeUrl);
		 */

		locationIsMoved(response);
	}

	/**
	 * When a resource location is moved
	 * 
	 * @param response
	 */
	public void locationIsMoved(HttpServletResponse response) {
		System.out.println(300);
		response.setStatus(300);
		response.setHeader("Location", "Hello");
	}
}
