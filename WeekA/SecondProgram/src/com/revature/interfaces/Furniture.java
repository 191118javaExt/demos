package com.revature.interfaces;

public abstract class Furniture {

	public String color;
	public String texture;
	public double cost;
	public String style;
	
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
			}
		}
	}
}
