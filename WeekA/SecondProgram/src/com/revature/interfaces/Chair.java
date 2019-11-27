package com.revature.interfaces;

public abstract class Chair extends Furniture implements Sittable {
	public int comfiness;
	public int numOfLegs;
	public int numOfTimesSatUpon;
	
	
	public void recline(int angle) {
		if(angle < 90 || angle > 180) {
			System.out.println("You can't recline that far. Lose 3 intelligence");
			return;
		}
		if(numOfLegs < 2) {
			System.out.println("This chair cannot recline. You fall. Take 2 damage.");
		}
		else {
			System.out.println("Click* by " + angle + "degrees. ");
		}
	}
	
	public void massage() {
		System.out.println("Massage begins restore 10MP");
	}
	
	public void sit() {
		if(numOfTimesSatUpon < 10) {
			System.out.println("The comfort level is " + comfiness + ".");
			System.out.println("It feels much less valuable.");
			cost *= 0.9;
		}
		else {
			System.out.println("The comfort level is " + comfiness/numOfTimesSatUpon + ".");
			System.out.println("What a useless chair...");
			cost *= .99;
		}
	
	}
}
