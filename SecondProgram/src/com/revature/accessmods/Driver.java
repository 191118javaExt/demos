package com.revature.accessmods;

public class Driver {
	
	// In Java, there are 4 access modifiers
	// public
	// protected
	// default
	// private
	
	// These are in descending order of visibility
	// public is the most visible
	// private is the least visible
	
	/*
	 * public access fields/methods are available
	 * everywhere.
	 * 
	 * protected access fields/methods are available
	 * only within the same package and subclasses
	 * 
	 * default access fields/methods are available
	 * only within the same package
	 *  This access modifier is only used by not
	 *  writing any keyword
	 * 
	 * private access fields/methods are available
	 * only within the class itself
	 */

	public static void main(String[] args) {
		// The main method is public
		// This method can be invoked/called
		// anywhere
		
		Student s = new Student();
		
		s.setStudentId(10001);
		s.setName("Larry");
		s.setAge(74);
		s.setMajor("Underwater Basket Weaving");
		
		s.setAge(-33);
		s.setName(null);
		
		s.print();
	}

}
