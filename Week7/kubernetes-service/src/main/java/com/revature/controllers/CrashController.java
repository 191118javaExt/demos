package com.revature.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CrashController {

	@GetMapping("/crash")
	public void crash() {
		System.out.println("Exiting program!");
		System.exit(0);
	}
}
