package com.revature;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.revature.beans.UserService;

public class Driver {

	public static void main(String[] args) {
		
		ApplicationContext ac = 
				new ClassPathXmlApplicationContext("applicationContext.xml");
		
		/*
		 * User user = (User) ac.getBean("user");
		 * 
		 * User user2 = (User) ac.getBean("user");
		 * 
		 * System.out.println(user);
		 * 
		 * System.out.println(user == user2);
		 */
		
		UserService us = (UserService) ac.getBean("userService");
		
		System.out.println(us);
	}
}
