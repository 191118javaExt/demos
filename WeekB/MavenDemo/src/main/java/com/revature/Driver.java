package com.revature;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

public class Driver {
	
	private static final Logger log = Logger.getLogger(Driver.class);
	// Loggers are created with the static getLogger method
	// from the log4j.Logger class
	// You provide the class object of the class being logged here
	// Class objects are Java's internal representation of
	// Classes
	// You  can access them with the .class property on a Class
	// Such as above
	
	/*
	 * We have mentioned some of the logging levels
	 * Here they are in more detail
	 * OFF: No logging at all
	 * ALL: Turns on all levels of logging
	 * TRACE: Adds more information to debug level logs
	 * DEBUG: Basically for developers, turns on all of the following
	 *  levels in addition to DEBUG
	 * INFO: Important business processes that have finished and good news
	 *  is "as expected"
	 *  System administrators will also use this level to see what is
	 *  happening
	 * WARN: Suggests that the application might be continued but you
	 *  should take extra caution
	 * ERROR: Shouts that something has gone very wrong and should be
	 *  investigated immediately
	 * FATAL: Very uncommon, but signals that something is catastrophically
	 *  wrong, and will likely result in application failure
	 */

	public static void main(String[] args) {
		log.info("PROGRAM START");

		try {
			int x = 1 / 0;
			log.info("Computation Successful");
		} catch(ArithmeticException e) {
			log.warn("WARNING: Division by zero occurred!", e);
		}
		
//		List<String> list = new ArrayList<>();
//		try {
//			while(true) {
//				list.add(new String("Larry"));
//			}
//		} catch(Error e) {
//			log.fatal("Oh no! Something is wrong!", e);
//		}
		
		log.info("PROGRAM END");
	}

}
