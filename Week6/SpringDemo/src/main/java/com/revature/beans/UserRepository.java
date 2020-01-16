package com.revature.beans;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

@Repository
public class UserRepository {

	public List<User> findAll() {
		List<User> list = new ArrayList<>();
		
		list.add(new User("Nick", "Faja", new Account(1200)));
		list.add(new User("Bill", "Gates", new Account(100000000007.32)));
		
		return list;
	}

	@Override
	public String toString() {
		return "UserRepository [findAll()=" + findAll() + "]";
	}
}
