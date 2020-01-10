package com.reavture.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.reavture.model.Crimes;
import com.reavture.model.SuperPrisons;
import com.reavture.model.SuperVillain;
import com.revature.dao.CrimeDao;
import com.revature.dao.SuperPrisonDao;
import com.revature.dao.SuperVillainDao;

public class OurHibernateServlet extends HttpServlet{
	
	public static SuperVillainDao svdao = new SuperVillainDao();
	public static CrimeDao crdao = new CrimeDao();
	public static SuperPrisonDao prdao = new SuperPrisonDao();
	
	public OurHibernateServlet() {
		initialValues();
		
	}
	
	protected void doGet(HttpServletRequest req, HttpServletResponse res)
	throws ServletException, IOException{
		System.out.println("In doGet");
		
		System.out.println("\nAbout to select by name: ");
		System.out.println(svdao.selectByName("Alan Rickman"));
		
	}
	
	protected void doPost(HttpServletRequest req, HttpServletResponse res)
			throws ServletException, IOException{
				System.out.println("In doPost");
				
				System.out.println("\nAbout to select All: ");
				System.out.println(svdao.selectAll());
				
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
				1000000,cList1,sp1);
		SuperVillainDao svd= new SuperVillainDao();
		svd.insert(sv1);
		List<SuperVillain> svL1 = new ArrayList<SuperVillain>();
		svL1.add(sv1);
		sp1.setVillList(svL1);
		SuperPrisonDao spd =new SuperPrisonDao();
		//spd.insert(sp1);
		
	}

}
