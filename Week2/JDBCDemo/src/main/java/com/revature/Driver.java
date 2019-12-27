package com.revature;

import java.util.List;
import java.util.Scanner;

import com.revature.models.Employee;
import com.revature.models.User;
import com.revature.services.EmployeeService;

public class Driver {

	public static void main(String[] args) {
//		EmployeeService es = new EmployeeService();
//		
//		Employee emp = new Employee(0, "Jack", "Hill", "Jack.Attack@yahoo.com", 300, null);
//		
//		List<Employee> list = es.findAll();
//		
//		for(Employee e : list) {
//			System.out.println(e);
//		}
//		
//		emp.setSupervisor(list.get(1));
//		
//		es.insert(emp);
//		
//		list = es.findAll();
//		
//		for(Employee e : list) {
//			System.out.println(e);
//		}
		System.out.println(Integer.MAX_VALUE);
		System.out.println(Integer.MIN_VALUE);
		Scanner s = new Scanner(System.in);
		
		System.out.println("Please enter your username");
		String username = s.nextLine();
		
		// Get User from database, with the username that they entered
		
		System.out.println("Now please enter your password");
		int password = s.nextLine().hashCode();
		
		System.out.println("Your password was " + password);
		
		System.out.println("Correct? " + (password == 1677836391));
		
		User u = new User(1, "myUsername", 1677836391, "Matthew", "Oberlies");
		
		System.out.println(u.hashCode());
	}
}
