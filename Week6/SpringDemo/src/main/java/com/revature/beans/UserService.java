package com.revature.beans;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

	@Autowired
	private UserRepository userRepository;

	public UserService() {
		super();
		System.out.println("Inside no-arg constructor");
	}

	public UserService(UserRepository userRepository) {
		super();
		System.out.println("Inside 1-arg constructor");
		this.userRepository = userRepository;
	}
	
	public UserRepository getUserRepository() {
		return userRepository;
	}

	public void setUserRepository(UserRepository userRepository) {
		System.out.println("Inside UserRepository Setter");
		this.userRepository = userRepository;
	}

	public List<User> findAll() {
		return userRepository.findAll();
	}

	@Override
	public String toString() {
		return "UserService [userRepository=" + userRepository + "]";
	}
}
