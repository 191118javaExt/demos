package com.revature.dao;



import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

import com.revature.model.SuperVillain;
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
		/*ses.close();*/
	}
	
	public void update(SuperVillain myVill) {
		Session ses = HibernateUtil.getSession();
		Transaction tx = ses.beginTransaction();
		
		ses.update(myVill);
		
		tx.commit();
		/*ses.close();*/
	}
	
	public SuperVillain selectById(int id) {
		Session ses = HibernateUtil.getSession();
		SuperVillain supe= ses.get(SuperVillain.class, id);
		/*ses.close();*/
		return supe;
	}
	
	public SuperVillain selectByName(String name) {
		Session ses =HibernateUtil.getSession();
		
		///////HQL
		//Hibernate Query Language
		//the attribute needs to be in single quotes (if string)
		//HQL uses Hibernate uses class names instead of the table names
		// HQL is essentially, a mix between programmatic and sql
		/*List<SuperVillain> villList = ses.createQuery("from SuperVillain"+
				" where name='"+ name + "'", SuperVillain.class).list();*/
		//we can also use the select keyword if we'd like:
		/*List<SuperVillain> villList = ses.createQuery("select bounty"
				+ " from SuperVillain where name='"+ name + "'"
				, SuperVillain.class).list();*/
		
		///////CRITERIA API
		//no single quotes on the attribute
		//Criteria is a PROGRAMMIC solution to complex queries
		/*List<SuperVillain> villList = ses.createCriteria(SuperVillain.class)
				.add(Restrictions.like("name",  name)).list();*/
		//The new version of the criteria api uses "CriteriaBuilder"
		
		///////NATIVE SQL
		//uses db table names
		//single quotes again
		List<SuperVillain> villList = ses.getNamedQuery(
				"HQL_GET_VILLAIN_BY_NAME").list();
		
		//returning
		if(villList.size()==0) {
			System.out.println("PANIC!!!!!!");
			return null;
		}
		/*ses.close();*/
		return villList.get(0);
	}
	
	public List<SuperVillain> selectAll() {
		Session ses = HibernateUtil.getSession();
		
		List<SuperVillain> villList=
				ses.getNamedQuery("HQL_GET_ALL").list();
		/*ses.close();*/
		return villList;
	}

}
