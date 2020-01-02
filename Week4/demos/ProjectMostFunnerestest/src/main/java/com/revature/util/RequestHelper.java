package com.revature.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.models.Employee;
import com.revature.models.EmployeeDTO;
import com.revature.models.LoginTemplate;
import com.revature.services.EmployeeService;

public class RequestHelper {
	
	private static Logger logger = Logger.getLogger(RequestHelper.class);
	private static ObjectMapper om = new ObjectMapper();

	public static void processLogin(HttpServletRequest req, HttpServletResponse res) throws IOException {
		BufferedReader reader = req.getReader();
		
		StringBuilder s = new StringBuilder();
		String line = reader.readLine();
		while(line != null) {
			s.append(line);
			line = reader.readLine();
		}
		
		String body = s.toString();
		System.out.println(body);
		LoginTemplate loginAttempt = om.readValue(body, LoginTemplate.class);
		String username = loginAttempt.getUsername();
		String password = loginAttempt.getPassword();
		
		logger.info("User attempted to login with username " + username);
		Employee e = EmployeeService.confirmLogin(username, password);
		if(e != null) {
			HttpSession session = req.getSession();
			// Gets the current session, or creates one if it did not exist
			session.setAttribute("username", username);
			
			PrintWriter out = res.getWriter();
			res.setContentType("application/json");
			EmployeeDTO eDTO = EmployeeService.convertToDTO(e);
			
			out.println(om.writeValueAsString(eDTO));
			
			logger.info(username + " has successfully logged in");
		} else {
			res.setContentType("application/json");
			res.setStatus(204);
		}
	}

	public static void processLogout(HttpServletRequest req, HttpServletResponse res) {
		HttpSession session = req.getSession(false);
		
		if(session != null) {
			String username = (String) session.getAttribute("username");
			logger.info(username + " has logged out");
			session.invalidate();
		}
		
		res.setStatus(200);
	}

	public static void processEmployees(HttpServletRequest req, HttpServletResponse res) throws IOException {
		res.setContentType("application/json");
		List<Employee> all = EmployeeService.findAll();
		List<EmployeeDTO> allDTO = new ArrayList<>();
		
		for(Employee e : all) {
			allDTO.add(new EmployeeDTO(e.getId(),
					e.getFirstName(),
					e.getLastName(),
					e.getUsername(),
					e.getPassword(),
					e.getHireDate().toString()));
		}
		
		String json = om.writeValueAsString(all);
		
		PrintWriter out = res.getWriter();
		out.println(json);
	}
}
