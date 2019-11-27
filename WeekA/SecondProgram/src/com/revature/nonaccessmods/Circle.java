package com.revature.nonaccessmods;

public class Circle extends Shape {
<<<<<<< HEAD
=======
	
	private final double pi = 3.1415926535;
	
>>>>>>> c7aa8f1b7228fd2fcb2604990bc660c19e2a68d4
	private double radius;
	
	public Circle(double radius) {
		super();
<<<<<<< HEAD
		radius = radius;
	}

	public double getRadius() {
		return radius;
	}

	public void setRadius(double radius) {
=======
>>>>>>> c7aa8f1b7228fd2fcb2604990bc660c19e2a68d4
		this.radius = radius;
	}

	@Override
<<<<<<< HEAD
	void bounce() {
		System.out.println("Boing" + text);

	}

	@Override
	void area() {
		return Math.PI * radius * radius;

	}

=======
	public void bounce(String text) {
		System.out.println("Boing!!! " + text);
		
	}

	@Override
	public double area() {
		return Math.PI * radius * radius;
	}

	public double getRadius() {
		return radius;
	}

	public void setRadius(double radius) {
		this.radius = radius;
	}
>>>>>>> c7aa8f1b7228fd2fcb2604990bc660c19e2a68d4
}
