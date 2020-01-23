package com.revature.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SomeController {

	@GetMapping(value = "/hello")
	public String hello() {
		return "Hello, this is my 2nd random service!";
	}
}
