package com.revature.nonaccessmods;

public class Triangle extends Shape {
	private double base;
	private double height;
	
	publice Triangle(double base, double height) {
		super();
		
	}
	
	@Override
	public void bounce(String text) {
		System.out.println("Thud" + text);
	}
	
	@Override
	public double area() {
		return 0.5 * base * height;
	}

	public double getBase() {
		return base;
	}

	public void setBase(double base) {
		this.base = base;
	}

	public double getHeight() {
		return height;
	}

	public void setHeight(double height) {
		this.height = height;
	}
}
