package com.reavture.driver;

import java.util.ArrayList;
import java.util.List;

import com.reavture.model.Crimes;
import com.reavture.model.SuperPrisons;
import com.reavture.model.SuperVillain;
import com.revature.dao.CrimeDao;
import com.revature.dao.SuperPrisonDao;
import com.revature.dao.SuperVillainDao;

public class MainDriver {

	public static void main(String[] args) {
		initialValues();
		/*
		 * System.out.println("Do the things"); SuperVillain vill2= new
		 * SuperVillain("Rickie", "Mimic", 1_500_000_000);
		 * 
		 * System.out.println(vill2); SuperVillainDao svdao = new SuperVillainDao();
		 * svdao.insert(vill2); System.out.println(svdao.selectById(1));
		 * System.out.println(svdao.selectByName("Rickie")); svdao.selectByName("Byrd");
		 */


	}
	
	public static void initialValues() {
		
		Crimes c1 = new Crimes("Arson","Fire Fire Fire Fire Mwhahahahah");
		Crimes c2 = new Crimes("Stealing pepperoni","Pepperoni pepperoni bring me the forumuloni");
		Crimes c3 = new Crimes("Ice cream in back pocket","Why? Because Why not....");
		Crimes c4 = new Crimes("Stealing the cookie from the cookie jar?","COOOOOOOKIESSSSS");
		Crimes c5 = new Crimes("Whistleling above 47 decibals on a Tuesday afternoon","Saddly I can't whistle");
		CrimeDao cd = new CrimeDao();
		cd.insert(c1);
		cd.insert(c2);
		cd.insert(c3);
		cd.insert(c4);
		cd.insert(c5);
		List<Crimes> cList1 = new ArrayList<Crimes>();
		cList1.add(c2);
		cList1.add(c3);
		cList1.add(c4);
		
		SuperPrisons sp1 = new SuperPrisons("Azkaban","Beverly Hills");
		
		SuperVillain sv1 = new SuperVillain("Alan Rickman","Stunning good looks and disapointment",
				1_000_000,cList1,sp1);
		SuperVillainDao svd= new SuperVillainDao();
		svd.insert(sv1);
		List<SuperVillain> svL1 = new ArrayList<>();
		svL1.add(sv1);
		sp1.setVillList(svL1);
		SuperPrisonDao spd =new SuperPrisonDao();
		//spd.insert(sp1);
		
	}

}
