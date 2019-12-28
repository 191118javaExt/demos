package com.revature.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class HelloWorldServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4217738150363355737L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		// PrintWriter - object obtained from response object
		// allows us to write directly to HTTP response's body
		/*
		 * PrintWriter pw = resp.getWriter(); pw.println("<h1>Hello World!</h1>");
		 * pw.println("<h3>testing 1 2 3</h3>");
		 */
		
		//to access servlet config, getServletConfig().getInitParameter
		//to access servlet context, getServletContext().getInitParameter
		
		// forward the request to our HelloWorld.html page from "hello"
		RequestDispatcher rd = req.getRequestDispatcher("helloWorld.html");
		rd.forward(req, resp);
	}
}
