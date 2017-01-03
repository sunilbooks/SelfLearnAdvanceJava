package com.sunilbooks.servlet;

import java.io.FileInputStream;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Example of Response object that returns binary data as image. Servlet
 * returns image as response to the client request.
 * 
 * @version 1.0
 * @since 01 June 2015
 * @author Sunil Sahu
 * @Copyright (c) Sunil Sahu
 * @url www.sunilbooks.com
 * 
 */
@WebServlet(urlPatterns = { "/GetImage" })
public class GetImage extends HttpServlet {

	private static final long serialVersionUID = 1L;

	/**
	 * Handles GET request. Default request is GET.
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		// Set MIME type to jpg image
		response.setContentType("image/jpg");

		// Open image file
		FileInputStream in = new FileInputStream("G:/sunRays/images/12_196.JPG");

		// Open Servlet output
		ServletOutputStream out = response.getOutputStream();

		// Create data buffer
		byte[] buffer = new byte[256];

		// Read bytes from image
		int readBytes = in.read(buffer);

		while (readBytes > 0) {
			// Write bytes to response
			out.write(buffer, 0, readBytes);
			readBytes = in.read(buffer);
		}

		// Close resources
		in.close();
		out.close();
	}

}
