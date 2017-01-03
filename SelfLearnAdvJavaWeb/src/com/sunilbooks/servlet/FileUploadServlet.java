package com.sunilbooks.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Collection;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
/**
 * 
 * @version 1.0
 * @since 01 June 2015
 * @author Sunil Sahu
 * @Copyright (c) Sunil Sahu
 * @url www.sunilbooks.com
 */
@WebServlet(name = "upload", urlPatterns = { "/upload" })
@MultipartConfig(location = "g:/upload", fileSizeThreshold = 1024 * 1024, maxFileSize = 5 * 1024 * 1024, maxRequestSize = 2 * 5 * 1024 * 1024)
public class FileUploadServlet extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		response.setContentType("text/html");
		PrintWriter out = response.getWriter();

		Collection<Part> parts = request.getParts();

		out.write("<h2>Number of parts : " + parts.size() + "</h2>");
		for (Part part : parts) {
			info(part, out);
			String filename = getFileName(part);
			if (filename != null) {
				// file will be stored in location in @MultipartConfig
				part.write(filename);
			}
		}
		out.close();
	}

	// Prints part information 
	private void info(Part part, PrintWriter out) {
		out.println("Name: " + part.getName());
		out.println("<br>");
		out.println("ContentType: " + part.getContentType());
		out.println("<br>");
		out.println("Size: " + part.getSize() + " bytes");
		out.println("<br>");
		Collection<String> headers = part.getHeaderNames();

		for (String h : headers) {
			out.println(h + ": " + part.getHeader(h));
			out.println("<br>");
		}
	}

	// Gets the file name from the "content-disposition" header
	private String getFileName(Part part) {
		// Gets string form-data; name="doc1"; filename="logo.png"
		for (String token : part.getHeader("content-disposition").split(";")) {
			if (token.trim().startsWith("filename")) {
				return token.substring(token.indexOf('=') + 1).trim()
						.replace("\"", "");
			}
		}
		return null;
	}
}