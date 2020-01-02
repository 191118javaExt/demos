package com.revature.repositories;

import java.util.List;

import com.revature.models.Employee;

public interface EmployeeDAO {
	public boolean insert(Employee e);
	public boolean update(Employee e);
	
	public List<Employee> findAll();
}
