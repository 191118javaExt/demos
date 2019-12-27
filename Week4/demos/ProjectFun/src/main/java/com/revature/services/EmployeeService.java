package com.revature.services;

import java.util.List;

import com.revature.models.Employee;
import com.revature.repositories.EmployeeDAOImpl;

public class EmployeeService {

	public static boolean insert(Employee e) {
		return new EmployeeDAOImpl().insert(e);
	}
	
	public static boolean update(Employee e) {
		return new EmployeeDAOImpl().update(e);
	}
	
	public static List<Employee> findAll() {
		return new EmployeeDAOImpl().findAll();
	}
	
	public static Employee findByUsername(String username) {
		List<Employee> all = new EmployeeDAOImpl().findAll();
		
		for(Employee e : all) {
			if(e.getUsername().equals(username)) {
				return e;
			}
		}
		
		return null;
	}
	
	public static Employee confirmLogin(String username, String password) {
		Employee e = findByUsername(username);
		if(e == null) {
			return null;
		}
		if(e.getPassword().equals(password)) {
			return e;
		} else {
			return null;
		}
	}
}
