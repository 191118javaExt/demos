package com.revature.driver;

import com.reavture.util.HibernateUtil;
import com.revature.dao.SuperVillainDao;
import com.revature.model.SuperVillain;

public class Maindriver {
public static SuperVillainDao svdao = new SuperVillainDao();
	
	public static void main(String[] args) {
		insertInitialValues();
		
		///SELECT BY NAME
		System.out.print("\nABOUT TO SELECT BY NAME: ");
		System.out.println(svdao.selectByName("ScreenSlaver"));
		
		//SELECT ALL SUPERVILLAINS
		System.out.println("\nAll Villains: "+ svdao.selectAll());
		
		System.out.println("\nDone");
		HibernateUtil.closeSes();

	}
	
	public static void insertInitialValues() {
		
		
		SuperVillain vill = new SuperVillain(105, "ScreenSlaver", "Hypnotism",
				45_000);
		svdao.insert(vill);
		
		vill= new SuperVillain(110, "Joker", "Infectious Laugh", 125_000);
		svdao.insert(vill);
		
		vill= new SuperVillain(115, "Swiper", "Swiping", 100_000);
		svdao.insert(vill);
		
		vill= new SuperVillain(120, "Kid Buu", "Too much power", 200_000);
		svdao.insert(vill);
	}


}
