package com.sunilbooks.filter;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Login Controller, takes User ID submitted from Login.jsp and store into
 * Session object
 * 
 * @version 1.0
 * @since 01 June 2015
 * @author Sunil Sahu
 * @Copyright (c) Sunil Sahu
 * @url www.sunilbooks.com
 */

@WebServlet(urlPatterns = "/LoginCtl")
public class LoginCtl extends HttpServlet {

	protected void doPost(HttpServletRequest req,
 HttpServletResponse res) throws ServletException, IOException {

		String userId = req.getParameter("userId");

		// Get Session object
		HttpSession session = req.getSession();

		// Store User ID in session
		session.setAttribute("userId", userId);

		// Forward to Welcone JSP
		RequestDispatcher rd = req.getRequestDispatcher("/Welcome.jsp");
		rd.forward(req, res);

	}
}
