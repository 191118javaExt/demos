package com.revature.objects;

public class Shape {

	public double area;
	public int extraVal;
	
	// Classes use what are called constructors
	// to actually construct an object
	
	// These are not quite methods, but are very
	// similar
	
	// There is NO return type, not even void
	// The constructor must be named
	// the same as the class
	
	// This is a constructor
	// If empty, the compiler will add a call to
	// the parent class constructor
	// Called a no-argument constructor
	Shape() {
		super();
		// super, is a keyword that refers to the parent
		// class, the parentheses indicate that
		// we are calling the constructor of the
		// parent class
		
		// This will call the no-argument
		// constructor of the Object class
		
		// The Object class was written by the
		// developers of Java itself
		
		// The constructor of the Object class
		// handles the complicated logic of
		// reserving memory, and actually
		// constructing and initializing
		// any instance variables
		
		System.out.println("Inside no-argument constructor");
	}
	
	Shape(double value) {
		super();
		area = value;
		System.out.println("Inside 1-arg constructor");
	}
	
	Shape(double value, int value2) {
		this(value);
		// The this keyword, refers to this object that
		// is currently being created
		// The parenthesis indicate that we are
		// calling the 1-argument constructor
		// of the Shape class
		extraVal = value2;
		System.out.println("Inside 2-arg constructor");
	}
	
	void bounce() {
		System.out.println("Boing!");
	}
	
	// This is called overloading
	// The same method name, but with a different
	// number, or type of parameters
	void bounce(String text) {
		System.out.println("Boing! " + text);
	}
}
