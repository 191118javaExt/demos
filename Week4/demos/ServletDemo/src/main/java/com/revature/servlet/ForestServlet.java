package com.revature.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.revature.util.DispatcherUtil;

/**
 * Servlet implementation class ForestServlet
 */
public class ForestServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private DispatcherUtil dispatch = new DispatcherUtil();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ForestServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession(false);
		// check whether a Session exists
		if (session != null && session.getAttribute("username") != null) {
			// check for desired entity (bears or caves?)
			String entity = request.getParameter("entity");
			String get = request.getParameter("get");
			if(entity != null && get != null) {
				response.setContentType("application/json");
				response.getWriter().write(dispatch.processGet(entity, get));
			}
		} else {
			response.sendError(403,"Stay out of the forest, Harry");
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
