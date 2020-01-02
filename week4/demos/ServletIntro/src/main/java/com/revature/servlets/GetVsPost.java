package com.revature.servlets;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.revature.util.HtmlTemplate;

public class GetVsPost extends HttpServlet {
/*
 * GET and POST are both HTTP verbs/methods. These two verbs are different
 * ways that we can send requests to a server.
 * 
 * GET requests will request information to be sent back in response
 * POST requests will send information that needs to be saved in response
 * 
 * You can still put information in the body of a GET request, however,
 * it is limited to 2048 characters.
 * POST requests have a near limitless capacity in the body.
 * 
 * In both cases the parameters passed are stored in a header called
 * QUERY_STRING
 */
	
	/*
	 * It is customary to create a doGet and doPost method for a Servlet
	 * We do not generally override the service/init/destroy methods
	 */
	
	protected void doGet(HttpServletRequest req, HttpServletResponse res)
		throws ServletException, IOException {
		String username = req.getParameter("username");
		
		System.out.println(username);
		
		PrintWriter out = HtmlTemplate.getHtmlWriter(res);
		Map<String, String[]> inputs = req.getParameterMap();
		
		out.println("<h3>GET</h3>");
		
		out.println("<table border='2px'><tr><th>PARAMETER</th><th>VALUE</th>");
		
		for(String k : inputs.keySet()) {
			out.println("<tr><td>" + k + "</td>");
			String values = "<td>";
			for(String value : inputs.get(k)) {
				values += (value + " ");
			}
			out.println(values + "</td></tr>");
		}
		
		out.println("</table>");
		HtmlTemplate.goBack(out);
	}
	
	protected void doPost(HttpServletRequest req, HttpServletResponse res)
			throws ServletException, IOException {
//			doGet(req, res);
	
		
		PrintWriter out = HtmlTemplate.getHtmlWriter(res);
//		Map<String, String[]> inputs = req.getParameterMap();
		
		Map<String, String[]> inputs = new HashMap<>();
		
		System.out.println("Trying to get body");
		BufferedReader body = req.getReader();
		System.out.println("Retrieved Body");
		
		System.out.println("Checking first line");
		if(!body.readLine().equals("{")) {
			System.out.println("Input not proper JSON!");
			res.setStatus(400);
		}
		
		System.out.println("Reading line by line");
		
		String line = body.readLine();
		while(!line.equals("}")) {
			String param = line.split(":")[0];
			param = param.replace("\t", "");
			param = param.replace("\"", "");
			String value = line.split(":")[1];
			value = value.replace("\"", "");
			String[] arr = new String[1];
			arr[0] = value;
			inputs.put(param, arr);
			
			line = body.readLine();
		}
		
		System.out.println(inputs);
		
		out.println("<h3>POST</h3>");
		
		out.println("<table border='2px'><tr><th>PARAMETER</th><th>VALUE</th>");
		
		for(String k : inputs.keySet()) {
			out.println("<tr><td>" + k + "</td>");
			String values = "<td>";
			for(String value : inputs.get(k)) {
				values += (value + " ");
			}
				out.println(values + "</td></tr>");
			}
			
			out.println("</table>");
			HtmlTemplate.goBack(out);
		}
}
