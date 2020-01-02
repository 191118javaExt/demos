package com.revature.util;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletResponse;

/*
 * This is just going to be a convenience, helper class to faciliate
 * creating html documents from Java more easily
 */
public class HtmlTemplate {

	public static void goBack(PrintWriter out) {
		out.println("<hr><input type='button' value='BACK'"
				+ "onclick='goBack()'>"
				+ "<script>"
				+ "function goBack() { window.history.back(); }"
				+ "</script>");
	}
	
	public static PrintWriter getHtmlWriter(HttpServletResponse res) throws IOException {
		res.setContentType("text/html");
		return res.getWriter();
	}
	
	// This ...headers as a parameter is known as varargs, which stands for
	// variable arguments
	// This means, with one method signature
	// I can support any number of parameters
	// You can only have 1 varargs in a method signature,
	// and supports only 1 type
	// In this example, this one method signature supports
	// 1 parameters, which is just the PrintWriter
	// as well as 2 parameters, which is PrintWriter + String
	// and 3, which is PrintWriter + String + String, etc.
	// This varargs parameter must be the last parameter in the signature
	
	
	// printTableHeaders(out, "header1", "header2", "header3");
	// -> PrintWriter + ["header1", "header2", "header3"] named headers
	public static void printTableHeaders(PrintWriter out, String ...headers) {
		out.println("<table border=2px<tr>");
		for(String h : headers) {
			out.println("<th>" + h + "</th>");
		}
		out.println("</tr>");
	}
}
