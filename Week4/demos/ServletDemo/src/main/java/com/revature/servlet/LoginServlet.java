package com.revature.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.revature.service.AuthenticationService;

public class LoginServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 817105812389880890L;

	// return login page for GET request
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.getRequestDispatcher("login.html").forward(req, resp);
	}
	
	// perform authentication for POST request
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession();
		//PrintWriter pw = resp.getWriter();
		resp.setContentType("text/html");
		//grab params from request
		String username = req.getParameter("username");
		String password = req.getParameter("password");
		if (AuthenticationService.isValidUser(username, password)) {
			//pw.println("welcome, "+username);
			//pw.println("<a href=\"helloWorld.html\">Go Back</a>");
			session.setAttribute("username", username);
			session.setAttribute("problem", null);
			resp.sendRedirect("profile");
		} else {
			session.setAttribute("problem", "incorrect password");
			resp.sendRedirect("login");
		}
	}
}
