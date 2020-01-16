package com.revature;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;

import com.revature.beans.User;
import com.revature.config.AppConfig;

public class Driver {

	public static void main(String[] args) {

		/*
		 * ApplicationContext ac = new
		 * ClassPathXmlApplicationContext("applicationContext.xml");
		 * 
		 * 
		 * User user = (User) ac.getBean("user");
		 * 
		 * User user2 = (User) ac.getBean("user");
		 * 
		 * System.out.println(user);
		 * 
		 * System.out.println(user == user2);
		 * 
		 * 
		 * UserService us = (UserService) ac.getBean("userService");
		 * 
		 * System.out.println(us);
		 * 
		 * ((ClassPathXmlApplicationContext) ac).close();
		 */
		
		ApplicationContext ac = new
				AnnotationConfigApplicationContext(AppConfig.class);
		
		User user = (User) ac.getBean("user");
		
		System.out.println(user);
		
		((AbstractApplicationContext) ac).close();
	}
}
