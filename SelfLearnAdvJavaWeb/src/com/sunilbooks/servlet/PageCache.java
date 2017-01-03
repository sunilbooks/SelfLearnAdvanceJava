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
 * Cache page content with max age
 * 
 * @version 1.0
 * @since 01 June 2015
 * @author Sunil Sahu
 * @Copyright (c) Sunil Sahu
 * @url www.sunilbooks.com
 * 
 */
@WebServlet(urlPatterns = "/PageCache")
public class PageCache extends HttpServlet {

	private static final long serialVersionUID = 1L;

	/**
	 * Handles GET request. Default request is GET.
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		// Set MIME type to text/Html
		response.setContentType("text/html");

		// Set cache to "public". You may set following values
		// public: allows source browser and intermediate proxy servers to cache
		// the page
		// private: allows only source browser to cache page
		// no-cache: will not allow any caching

		response.setHeader("Cache-Control", "public");

		// Set maximun age of cache is 1 hour. Browse will force to refresh
		// cache after 1 hour.
		response.setIntHeader("max-age", 60 * 60);

		//Compress response
		response.setHeader("Content-Language", "de-DE");


		Date d = new Date();

		PrintWriter out = response.getWriter();

		response.getWriter();

		out.println("<html><body>");
		out.println("<h1>This is cached value</h1>");
		out.println("<IMG src='SunilOSLogoOSLC.png' />");
		out.println("<h2>" + d + "</h2>");
		out.println("</body></html>");
	}
}
