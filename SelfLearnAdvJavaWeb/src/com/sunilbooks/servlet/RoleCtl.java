package com.sunilbooks.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * View RoleView.jsp submits form to this controller. View will submit code and
 * name of role to controller. Controller will check if name is null then set
 * error message “Name is required” in request scope and forward control to
 * View. View gets error message from request scope and displays at page.
 * 
 * @version 1.0
 * @since 01 June 2015
 * @author Sunil Sahu
 * @Copyright (c) Sunil Sahu
 * @url www.sunilbooks.com
 * 
 */
@WebServlet(urlPatterns = { "/RoleCtl" })
public class RoleCtl extends HttpServlet {

	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest req, HttpServletResponse res)
			throws ServletException, IOException {
		
		
		// Get parameters from request
		String code = req.getParameter("code");
		String name = req.getParameter("name");

		if (name == null || name.length() == 0) {
			req.setAttribute("error", "Name is required");
			RequestDispatcher rd = req.getRequestDispatcher("RoleView.jsp");
			rd.forward(req, res);
		}

		res.setContentType("text/html");
		PrintWriter out = res.getWriter();

		out.println("<HTML><BODY>");
		out.println("This is Role Controller");
		
		RequestDispatcher rd = req.getRequestDispatcher("/Footer");
		rd.include(req, res);
		
		out.println("</BODY></HTML>");
		out.close();
	}

}
