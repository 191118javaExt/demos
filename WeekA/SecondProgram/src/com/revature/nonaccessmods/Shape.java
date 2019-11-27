package com.revature.nonaccessmods;

public abstract class Shape {
<<<<<<< HEAD
	abstract void bounce();
	
	abstract void area();

=======
	
	private int val;

	public void bounce() {
		System.out.println("Boing!");
	}
	
	public abstract void bounce(String text);
	// Abstract methods do not have an implementation
	// We are simply declaring the method signature
	
	// Attempting to provide a body to an abstract method
	// will not compile
	
	//abstract void bounce2() { }
	// The above declaration does not compile
	
	// The purpose of abstract methods
	// Is to allow methods to be visible at the parent class
	// but the implementation can only be provided by a subclass
	
	public abstract double area();
>>>>>>> c7aa8f1b7228fd2fcb2604990bc660c19e2a68d4
}
