package com.revature.repositories;

import java.util.List;

import com.revature.models.Employee;

public interface EmployeeDAO {

	public List<Employee> findAll();
	public Employee findById(int id);
	public boolean insert(Employee e);
	public boolean update(Employee e);
}
