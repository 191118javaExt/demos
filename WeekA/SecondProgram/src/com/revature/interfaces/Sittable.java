package com.revature.interfaces;

public interface Sittable {
	void sit(); //Compiler adds in public or abstract keywords, others will not compile
	
	default void sit2() {
		System.out.println("In side sit2 method from interface.");
	}
	
	int x = 1000; // Variables will be changed to public static final
}
