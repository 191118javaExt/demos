package com.revature.objects;

// The extends keyword inherits the properties and
// behaviors of that parent class to this class
public class Triangle extends Shape {
	
	double base;
	double height;
	
	public Triangle() {
		super();
		bounce();
		System.out.println(area);
	}
	
	// This annotation does NOTHING
	// It is simply here for other humans
	// to read and recognize that this
	// method is being overridden
	@Override
	void bounce() {
		System.out.println("Thud...");
	}
	// This is one of the ways that we accomplish
	// polymorphism
	
	// Overloading is declaring a method
	// with the same name, but a different
	// number, or type of parameters
	void bounce(int value) {
		for(int i = 0; i < value; i++) {
			bounce();
		}
	}
	// Overloading is another means of accomplishing
	// polymorphism
}
