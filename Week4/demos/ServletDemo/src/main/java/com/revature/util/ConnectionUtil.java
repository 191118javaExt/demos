package com.revature.util;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class ConnectionUtil {

	//this is terrible, don't do it this way! 
	public static Connection getConnection() throws SQLException {
		String url = "";
		String username = "";
		String password = "";
		return DriverManager.getConnection(url, username, password);
	}
	
	//better, if you don't push the connection.properties file
	public static Connection getConnectionFromFile(String filename) throws SQLException, IOException {
		
		//check that driver is being seen
		try {
			Class.forName("org.postgresql.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		Properties prop = new Properties();
		ClassLoader loader = Thread.currentThread().getContextClassLoader();
		prop.load(loader.getResourceAsStream(filename));
		String url = prop.getProperty("url");
		String username = prop.getProperty("username");
		String password = prop.getProperty("password");
		return DriverManager.getConnection(url, username, password);
	}

}
