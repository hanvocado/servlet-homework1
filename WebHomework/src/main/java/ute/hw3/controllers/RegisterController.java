package ute.hw3.controllers;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

import ute.hw3.dao.impl.*;
import ute.hw3.models.User;
import ute.hw3.dao.*;

@WebServlet(urlPatterns = { "/register" })
public class RegisterController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public RegisterController() {
		super();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.sendRedirect("views/register.jsp");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String fullName = request.getParameter("full-name");
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		String passwordCf = request.getParameter("password-cf");
		UserDao userDao = new UserDao();
		User user = userDao.findByEmail(email);
		if ((!password.equals(passwordCf)) || user != null) {
			response.sendRedirect("views/register.jsp");
		} else {
			userDao.insert(new User(email, fullName, password));
			request.setAttribute("full-name", fullName);
			RequestDispatcher rd = request.getRequestDispatcher("views/home.jsp");
			rd.forward(request, response);
		}
	}

}
