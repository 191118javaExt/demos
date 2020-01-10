package com.revature.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.reavture.model.SuperPrisons;
import com.reavture.util.HibernateUtil;



public class SuperPrisonDao {

	public void insert(SuperPrisons myPrison) {
		Session ses = HibernateUtil.getSession();
		Transaction tx = ses.beginTransaction();
		
		ses.save(myPrison);
		
		tx.commit();
		//ses.close();
	}
	
	public void update(SuperPrisons myPrison) {
		Session ses = HibernateUtil.getSession();
		Transaction tx = ses.beginTransaction();
		
		ses.update(myPrison);
		
		tx.commit();
		//ses.close();
	}
	
	public SuperPrisons selectById(int id) {
		Session ses = HibernateUtil.getSession();
		
		SuperPrisons pris = ses.get(SuperPrisons.class, id);
		
		//ses.close();
		return pris;
	}
	
	public List<SuperPrisons> selectAll() {
		Session ses= HibernateUtil.getSession();
		
		//THIS is HQL
		List<SuperPrisons> prisonList=
				ses.createQuery("from SuperPrisons", SuperPrisons.class).list();
		
		//ses.close();
		
		return prisonList;
	}
}

