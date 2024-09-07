package vn.iostar.controllers;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = {"/home"})
public class HomeController extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		/*
		 * resp.setContentType("text/html");
		 * 
		 * String ten = req.getParameter("ten"); String holot =
		 * req.getParameter("holot");
		 * 
		 * PrintWriter printW = resp.getWriter(); printW.println("<h1>Hello " + holot +
		 * " " + ten + "</h1>"); printW.close();
		 */
		resp.sendRedirect("Views/index.html");
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html");
		
		String ten = req.getParameter("ten");
		String holot = req.getParameter("holot");	
		
		req.setAttribute("ten", ten);
		req.setAttribute("holot", holot);
		
		RequestDispatcher rd = req.getRequestDispatcher("Views/home.jsp");
		rd.forward(req, resp);
	}
}
