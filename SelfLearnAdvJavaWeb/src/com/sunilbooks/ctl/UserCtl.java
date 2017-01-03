package com.sunilbooks.ctl;

import java.io.IOException;
import java.sql.SQLException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sunilbooks.model.UserModel;

/**
 * User Controller
 * 
 * @version 1.0
 * @since 01 June 2015
 * @author Sunil Sahu
 * @Copyright (c) Sunil Sahu
 * @url www.sunilbooks.com
 * 
 */

@WebServlet(urlPatterns = "/user")
public class UserCtl extends HttpServlet {

	private long getValue(String val) {
		long id = 0;
		try {
			id = Integer.parseInt(val);
		} catch (NumberFormatException e) {
			id = 0;
		}
		return id;
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse res)
			throws ServletException, IOException {

		UserModel model = new UserModel();
		long id = 0;

		id = getValue(req.getParameter("id"));

		if (id > 0) {
			try {
				model = model.get(id);
			} catch (SQLException e) {
				req.setAttribute("error", e.getMessage());
			}
		}

		req.setAttribute("user", model);
		RequestDispatcher rd = req.getRequestDispatcher("/view/User.jsp");
		rd.forward(req, res);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse res)
			throws ServletException, IOException {

		long id = 0;
		id = getValue(req.getParameter("id"));

		UserModel model = new UserModel();
		model.setId(id);
		model.setFirstName(req.getParameter("firstName"));
		model.setLastName(req.getParameter("lastName"));
		model.setLogin(req.getParameter("login"));
		model.setPassword(req.getParameter("password"));
		model.setGender(req.getParameter("gender"));

		try {

			if (id > 0) {
				model.update();
				req.setAttribute("message", "Successfully  updated");

			} else {
				model.setId(model.getNextPk());
				model.add();
				req.setAttribute("message", "Successfully Added");
			}
		} catch (SQLException e) {
			req.setAttribute("error", "Fail");
			e.printStackTrace();
		}

		req.setAttribute("user", model);
		RequestDispatcher rd = req.getRequestDispatcher("/view/User.jsp");
		rd.forward(req, res);

	}

}
