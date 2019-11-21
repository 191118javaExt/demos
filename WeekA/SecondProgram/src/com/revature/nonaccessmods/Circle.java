package com.revature.nonaccessmods;

public class Circle extends Shape {
	
	private final double pi = 3.1415926535;
	
	private double radius;
	
	public Circle(double radius) {
		super();
		this.radius = radius;
	}

	@Override
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
}
