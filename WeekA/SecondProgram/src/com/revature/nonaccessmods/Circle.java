package com.revature.nonaccessmods;

public class Circle extends Shape {
	private double radius;
	
	public Circle(double radius) {
		super();
		radius = radius;
	}

	public double getRadius() {
		return radius;
	}

	public void setRadius(double radius) {
		this.radius = radius;
	}

	@Override
	void bounce() {
		System.out.println("Boing" + text);

	}

	@Override
	void area() {
		return Math.PI * radius * radius;

	}

}
