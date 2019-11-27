package com.revature.nonaccessmods;

public class Triangle extends Shape {
<<<<<<< HEAD
	private double base;
	private double height;
	
	publice Triangle(double base, double height) {
		super();
		
	}
	
	@Override
	public void bounce(String text) {
		System.out.println("Thud" + text);
	}
	
=======
	
	private double base;
	private double height;
	
	public Triangle(double base, double height) {
		super();
		this.base = base;
		this.height = height;
	}

	@Override
	public void bounce(String text) {
		System.out.println("Thud..." + text);
	}

>>>>>>> c7aa8f1b7228fd2fcb2604990bc660c19e2a68d4
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
