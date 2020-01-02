package com.revature.service;

public class AuthenticationService {

	public AuthenticationService() {
	}

	public static boolean isValidUser(String username, String password) {
		if (username != null && password != null) {
			return (username.equals("Aretha") && password.equals("awesome"));
		} else {
			return false;
		}
	}

}
