package com.sunilbooks.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.URL;
import java.net.URLConnection;
import java.util.Scanner;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Http Client to display raw response text
 * 
 * @version 1.0
 * @since 01 June 2015
 * @author Sunil Sahu
 * @Copyright (c) Sunil Sahu
 * @url www.sunilbooks.com
 */

public class HttpClient {
	public static void main(String[] args) throws Exception {

		URL u = new URL("http://localhost:8080/SelfLearnAdvJavaWeb/Hello");
		Scanner in = new Scanner(u.openStream());

		while (in.hasNext()) {
			System.out.println(in.nextLine());
		}
		in.close();
	}

}
