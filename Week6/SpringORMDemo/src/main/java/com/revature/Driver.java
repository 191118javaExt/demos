package com.revature;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.revature.models.User;
import com.revature.repositories.IUserDAO;

public class Driver {

	public static void main(String[] args) {
		ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
		
		IUserDAO dao = (IUserDAO) ac.getBean("userDAO");
		
//		dao.save(new User(0, "Larry", "King"));
//		dao.save(new User(0, "Harry", "Potter"));
		
		User u = dao.findById(1);
		User u2 = dao.findById(2);
		System.out.println(u);
		System.out.println(u2);
//		System.out.println(u.addFriend(u2));
//		dao.update(u);

//		System.out.println(dao.findAll());
	}
}
