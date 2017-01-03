package com.sunilbooks.servlet;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Returns PDF file as response data.
 * 
 * @version 1.0
 * @since 01 June 2015
 * @author Sunil Sahu
 * @Copyright (c) Sunil Sahu
 * @url www.sunilbooks.com
 * 
 */
@WebServlet(urlPatterns = "/PdfResponse")
public class PdfResponse extends HttpServlet {

	private static final long serialVersionUID = 1L;

	/**
	 * Handles GET request. Default request is GET.
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		//Read File
		String filePath = "G:/nenosystems/office/Vision-Mission-Statement.pdf";
		File f = new File(filePath);
		FileInputStream in = new FileInputStream(f);

		// Set MIME type for JPG Image file
		response.setContentType("application/pdf");
		response.setContentLength((int)f.length());
		
		//Get Servlet Binary Stream
		ServletOutputStream out = response.getOutputStream();

		//Write file content
		byte[] array = new byte[512];
		int readBytes = in.read(array);
		while (readBytes > 0) {
			out.write(array, 0, readBytes);
			readBytes = in.read(array);
		}

		in.close();
		out.close();
	}
}
