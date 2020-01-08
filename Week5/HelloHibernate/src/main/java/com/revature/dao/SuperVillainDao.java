package com.revature.dao;



import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

import com.reavture.model.SuperVillain;
import com.reavture.util.HibernateUtil;

/*Session methods:
 * 
 * save() and persist()		result in a sql insert
 * update() and merge()		result in a sql update
 * delete()					result in sql delete
 * saveOrUpdate()			result in either a sql insert or update (depending)
 * get() and load()			result in a sql select
 * 
 * 
 * There are 3 different ways to create complex queries in Hibernate:
 * -HQL- Hibernate Query Language
 * -Criteria API-
 * -Native
 * 
 */


public class SuperVillainDao {
	
	public SuperVillainDao() {
		
	}
	
	public void insert(SuperVillain myVill) {
		Session ses = HibernateUtil.getSession();
		Transaction tx = ses.beginTransaction();
		
		ses.save(myVill);
		tx.commit();
		ses.close();
	}
	
	public void update(SuperVillain myVill) {
		Session ses = HibernateUtil.getSession();
		Transaction tx =ses.beginTransaction();
		
		ses.update(myVill);
		tx.commit();
		ses.close();
	}
	
	public SuperVillain selectById(int id) {
		Session ses = HibernateUtil.getSession();
		SuperVillain supe = ses.get(SuperVillain.class, id);
		ses.close();
		return supe;
	}
	
	
	public SuperVillain selectByName(String name){
		Session ses = HibernateUtil.getSession();
	///////HQL- HIbernate Query Language
			//Creates complex queries using a combination of OOP and Native SQL
			//HQL targets java objects NOT SQL tables
			//notice: we needed the single quotes around the variable
		List<SuperVillain> villList = ses.createQuery("from SuperVillain where name='"
				+name+"'", SuperVillain.class).list();
////////CRITERIA API
		//Creates complex queries programmatically. That is, it does so using ONLY OOP
		//	principles.
		//Criteria targets java objects NOT SQL tables
		//notice: we did NOT need the single quotes around the variable
		/*
		 * List<SuperVillain> villList2= ses.createCriteria(SuperVillain.class)
		 * .add(Restrictions.like("name", name)).list();
		 */
		
	/////NATIVE SQL
			//Creates complex queries by using plain old SQL queries
			//Native targets SQL tables NOT java objects
			//notice: we needed the single quotes around the variable
		/*
		 * List<SuperVillain> villList3=
		 * ses.createNativeQuery("select * from Super_Villain where" +
		 * " name='"+name+"'", SuperVillain.class).list();
		 */
		
		ses.close();
		if(villList.size()==0) {
			System.out.println("PANIC!!!!!");
			return null;
		}
		return villList.get(0);

	}
	
	public List<SuperVillain> selectAll(){
		Session ses = HibernateUtil.getSession();
		//This is HQL
		List<SuperVillain> villList=ses.createQuery("from SuperVillain", SuperVillain.class).list();
		ses.close();
		return villList;
		
	}
}
