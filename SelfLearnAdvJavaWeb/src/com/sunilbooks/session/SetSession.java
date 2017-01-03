package com.sunilbooks.session;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


/**
 * Sets value in session memory
 * 
 * @version 1.0
 * @since 01 June 2015
 * @author Sunil Sahu
 * @Copyright (c) Sunil Sahu
 * @url www.sunilbooks.com
 * 
 */
@WebServlet(urlPatterns = "/SetSession")
public class SetSession extends HttpServlet {

	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		String name = request.getParameter("name");
		String value = request.getParameter("value");

		HttpSession session = request.getSession();
		session.setAttribute(name, value);
		
		//test
		User u = new User();
		u.setName("SunilOS");
		session.setAttribute("user", u);
		session.removeAttribute("user");
		

		response.setContentType("text/html");

		PrintWriter out = response.getWriter();

		out.println("<html><body>");

		out.println("<h3>Set Session</h3>");

		out.println(name + "=" + value);

		out.println("</body></html>");
	}

}
