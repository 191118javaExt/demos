package com.revature.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class HelloWorldServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	/*
	 * Servlets have 3 primary methods in their lifecycle
	 * The first is init(), which is called to instantiate the servlet
	 * if it is not already (Since Servlets are Singletons).
	 */
	
	public void init() throws ServletException {
		System.out.println(this.getServletName() + " IS INSTANTIATED!");
		super.init();
	}
	
	/*
	 * The next method we'll write is the service() method. This is used for
	 * the business logic and to populate the response.
	 * 
	 * When using Servlets normally, you should NEVER EVER override the service
	 * method.
	 */
	
	protected void service(HttpServletRequest req, HttpServletResponse res)
		throws ServletException, IOException {
		System.out.println(this.getServletName() + " SERVICE METHOD CALLED!");
		
		/*
		 * So in order to create the response, we must write to it.
		 * The way we write to the response is with its own PrintWriter object.
		 */
		PrintWriter out = res.getWriter();
		res.setContentType("text/html");
		
		/*
		 * This is going to send back an html page that says "Hello World!"
		 */
		out.println("<h1 style='font-family:comic-sans; color:green'><em>Hello World!</em></h1>");
		
		out.println("<hr><input type='button' value='BACK'"
				+ "onclick='goBack()'>"
				+ "<script>"
				+ "function goBack() { window.history.back(); }"
				+ "</script>");
		
		/*
		 * At the end of the service() method, the request and response objects are sent back
		 * to the Web Container (WC).
		 */
	}
	
	/*
	 * After a very long time of not being used, the Web Container will invoke the
	 * destroy() method on your Servlet
	 */
	
	public void destroy() {
		System.out.println(this.getServletName() + " DESTROY METHOD CALLED!");
		super.destroy();
	}
}
