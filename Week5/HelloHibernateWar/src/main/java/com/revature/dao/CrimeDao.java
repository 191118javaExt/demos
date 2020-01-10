package com.revature.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.reavture.model.Crimes;
import com.reavture.model.Crimes;
import com.reavture.util.HibernateUtil;

public class CrimeDao {
	
	public CrimeDao() {
		
	}
	
	public void insert(Crimes myVill) {
		Session ses = HibernateUtil.getSession();
		Transaction tx = ses.beginTransaction();
		
		ses.save(myVill);
		tx.commit();
		//ses.close();
	}
	
	public void update(Crimes myVill) {
		Session ses = HibernateUtil.getSession();
		Transaction tx =ses.beginTransaction();
		
		ses.update(myVill);
		tx.commit();
		//ses.close();
	}
	
	public Crimes selectById(int id) {
		Session ses = HibernateUtil.getSession();
		Crimes supe = ses.get(Crimes.class, id);
		//ses.close();
		return supe;
	}
	
	
	public Crimes selectByName(String name){
		Session ses = HibernateUtil.getSession();
	///////HQL- HIbernate Query Language
			//Creates complex queries using a combination of OOP and Native SQL
			//HQL targets java objects NOT SQL tables
			//notice: we needed the single quotes around the variable
		List<Crimes> villList = ses.createQuery("from Crimes where crimeName='"
				+name+"'", Crimes.class).list();
////////CRITERIA API
		//Creates complex queries programmatically. That is, it does so using ONLY OOP
		//	principles.
		//Criteria targets java objects NOT SQL tables
		//notice: we did NOT need the single quotes around the variable
		/*
		 * List<Crimes> villList2= ses.createCriteria(Crimes.class)
		 * .add(Restrictions.like("name", name)).list();
		 */
		
	/////NATIVE SQL
			//Creates complex queries by using plain old SQL queries
			//Native targets SQL tables NOT java objects
			//notice: we needed the single quotes around the variable
		/*
		 * List<Crimes> villList3=
		 * ses.createNativeQuery("select * from Super_Villain where" +
		 * " name='"+name+"'", Crimes.class).list();
		 */
		
		//ses.close();
		if(villList.size()==0) {
			System.out.println("PANIC!!!!!");
			return null;
		}
		return villList.get(0);

	}
	
	public List<Crimes> selectAll(){
		Session ses = HibernateUtil.getSession();
		//This is HQL
		List<Crimes> villList=ses.createQuery("from Crimes", Crimes.class).list();
		//ses.close();
		return villList;
		
	}

}
