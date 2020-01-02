package com.revature.util;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class CloseStreams {

	public static void close(Statement s) {
		try {
			s.close();
		} catch(Exception e) {
		}
	}
	
	public static void close(Scanner s) {
		try {
			s.close();
		} catch(Exception e) {
		}
	}
	
	public static void close(Connection c) {
		try {
			c.close();
		} catch(Exception e) {
		}
	}
}
