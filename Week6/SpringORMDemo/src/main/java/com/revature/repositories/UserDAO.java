package com.revature.repositories;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.revature.models.User;

@Repository
public class UserDAO implements IUserDAO {
	
	@Autowired
	private SessionFactory sf;

	@SuppressWarnings({ "deprecation", "unchecked" })
	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public List<User> findAll() {
		Session s = sf.getCurrentSession();
		return (List<User>) s.createCriteria(User.class).list();
	}

	@Override
	@Transactional
	public User findById(int id) {
		Session s = sf.getCurrentSession();
		return s.get(User.class, id);
	}

	@Override
	@Transactional
	public void save(User u) {
		Session s = sf.getCurrentSession();
		s.save(u);
	}
	
	@Override
	@Transactional
	public void update(User u) {
		Session s = sf.getCurrentSession();
		s.update(u);
	}
}
