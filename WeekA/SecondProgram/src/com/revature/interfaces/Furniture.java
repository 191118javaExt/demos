package com.revature.interfaces;

public abstract class Furniture {
<<<<<<< HEAD
=======

>>>>>>> c7aa8f1b7228fd2fcb2604990bc660c19e2a68d4
	public String color;
	public String texture;
	public double cost;
	public String style;
	
<<<<<<< HEAD
	public abstract void recline();
	
	public abstract void massage();
	
	public void adjust(int amount) {
		if(amount > 0 ) {
			for(int i = 0; i < amount; i++) {
				System.out.println("Click");
			}
		}
		else {
			amount *= -1;
			for(int i = 0; i < amount; i++) {
				System.out.println("Click, but down");
=======
	public abstract void massage();
	
	public void adjust(int amount) {
		if(amount > 0) {
			for(int i = 0; i < amount; i++) {
				System.out.println("Click. Moved up 1 unit.");
			}
		} else {
			amount *= -1;
			for(int i = 0; i < amount; i++) {
				System.out.println("Click. Moved down 1 unit.");
>>>>>>> c7aa8f1b7228fd2fcb2604990bc660c19e2a68d4
			}
		}
	}
}
