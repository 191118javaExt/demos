package com.revature;

import java.util.List;

import com.revature.models.Employee;
import com.revature.services.EmployeeService;

public class Driver {

	public static void main(String[] args) {
		EmployeeService es = new EmployeeService();
		
		Employee emp = new Employee(0, "Jack", "Hill", "Jack.Attack@yahoo.com", 300, null);
		
		List<Employee> list = es.findAll();
		
		for(Employee e : list) {
			System.out.println(e);
		}
		
		emp.setSupervisor(list.get(1));
		
		es.insert(emp);
		
		list = es.findAll();
		
		for(Employee e : list) {
			System.out.println(e);
		}
	}
}
