package com.revature.controllers;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

// This annotation allows us to refresh the configuration for this controller
// without having to restart the application
@RefreshScope
@RestController
public class ConfigController {

	@Value("${message}")
	private String message;
	
	@Value("${response}")
	private String response;
	
	@GetMapping("/message")
	public String getMessage() {
		return message;
	}
	
	@GetMapping("/response")
	public String getResponse() {
		return response;
	}
}
