package com.revature.services;

import java.util.List;

import com.revature.models.Employee;
import com.revature.repositories.EmployeeDAO;
import com.revature.repositories.EmployeeDAOImpl;

public class EmployeeService {
	
	EmployeeDAO repository = new EmployeeDAOImpl();

	/**
	 * This is a very simple method, that doesn't add in any extra logic
	 * It simply uses what was grabbed from the database through the DAO
	 * @return
	 */
	public List<Employee> findAll() {
		return repository.findAll();
	}
	
	public boolean insert(Employee e) {
		return repository.insert(e);
	}
}
