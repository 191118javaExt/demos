package com.revature.interfaces;

// Note that the syntax for extending must go first
// access-mod class name extends name implements name1, name2, ...
public class Chair extends Furniture implements Sittable {
	
	public int comfiness;
	public int numOfLegs;
	public int numOfTimesSatUpon;

	public void recline(int angle) {
		if(angle < 90 || angle > 180) {
			System.out.println("You cannot recline that far.");
			return;
			// The function is void, so there is nothing to be returned
			// But the return statement  by itself, quits the method early
		}
		if(numOfLegs < 2) {
			System.out.println("This chair cannot recline, silly. You have fallen.");
		} else {
			System.out.println("Click. The chair reclines at an angle of "
					+ angle + " degrees.");
		}
	}

	@Override
	public void massage() {
		System.out.println("The massage begins.");
		System.out.println("You enjoy the " + texture + ", " + color + ", "
				+ style + " chair this much: " + comfiness);
		System.out.println("It is worth $" + cost);
	}

	@Override
	public void sit() {
		if(numOfTimesSatUpon < 10) {
			System.out.println("The comfort level is " + comfiness + ".");
			System.out.println("It feels much less valuable.");
			cost *= 0.9;
		} else {
			System.out.println("The comfort level is " + comfiness / numOfTimesSatUpon + ".");
			System.out.println("What a useless chair...");
			cost *= 0.99;
		}
		
		System.out.println("It is now worth $" + cost);
		numOfTimesSatUpon++;
	}
}
