package com.revature.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import com.revature.beans.Account;
import com.revature.beans.User;
import com.revature.beans.UserRepository;
import com.revature.beans.UserService;

@Configuration
@ComponentScan("com.revature")
public class AppConfig {

	@Bean(name = "user")
	public User getUser() {
		return new User();
	}
	
	@Bean(name = "account")
	public Account getAccount() {
		return new Account();
	}
	
	@Bean(name = "userService")
	public UserService getUserService() {
		return new UserService();
	}
	
	@Bean(name = "userRepository")
	public UserRepository getUserRepository() {
		return new UserRepository();
	}
}
