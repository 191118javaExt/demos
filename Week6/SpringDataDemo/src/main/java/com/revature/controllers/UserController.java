package com.revature.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.revature.models.User;
import com.revature.services.UserService;

@RestController
public class UserController {
	
	@Autowired
	private UserService us;
	
	@GetMapping("/users")
	public ResponseEntity<List<User>> findAllUsers() {
		List<User> users = us.findAll();
		if(users.size() > 0) {
			return ResponseEntity.ok(users);
		} else {
			return ResponseEntity.noContent().build();
		}
	}
	
	@PutMapping("/users")
	public ResponseEntity<User> upsert(@RequestBody User u) {
		if(u != null) {
			return ResponseEntity.ok(us.upsert(u));
		} else {
			return ResponseEntity.badRequest().build();
		}
	}
}
