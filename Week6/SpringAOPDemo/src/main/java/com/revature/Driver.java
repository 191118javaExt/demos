package com.revature;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.revature.models.Digimon;
import com.revature.models.Partner;

public class Driver {

	public static void main(String[] args) {
		ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
		
		Digimon d = (Digimon) ac.getBean("digimon");
		
		System.out.println(d);
		
		d.setId(1);
		d.setName("Miles");
		d.setType("Tired Dinosaur, overworked from doing taxes");
		d.setEvolutionLevel("Champion");
		
		Partner p = (Partner) ac.getBean("partner");
		
		p.setBuddy(d);
		p.setId(1);
		p.setName("Solomon");
		
		System.out.println(p);
		
		p.hug(2);
	}

}
