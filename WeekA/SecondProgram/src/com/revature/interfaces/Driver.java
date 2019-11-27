package com.revature.interfaces;

public class Driver {
<<<<<<< HEAD
	public static void main(String[] args) {
		Chair c = new Chair();
		c.color = "red";
		c.comfiness = 4;
		c.cost = 12;
		c.numOfTimesSatUpon = 0;
		c.style = "Eclectic";
		c.texture = "sharp";
		
		c.sit();
		c.recline(100);
		c.massage();
=======

	/*
	 * Interfaces are Java's means of sort of accomplishing
	 * multiple-inheritance, but not quite
	 * 
	 * interface is a keyword that can be used similarly to class
	 * Inside the brackets, you can declare methods and some static fields
	 * Note, the fields can only be static, they cannot be instance
	 * All methods in an interface are public abstract
	 * All fields in an interface are public static final
	 * 
	 * Classes use the implements keyword for interfaces
	 * Classes can implement MULTIPLE interfaces
	 * But classes can extend only ONE other class
	 * 
	 * Classes that implement an interface inherit the abstract methods
	 * and therefore, if the class is not abstract, must provide its own
	 * implementation
	 * 
	 * Abstract classes can still implement interfaces, they just inherit the
	 * abstract methods
	 * 
	 * Since abstract classes can still have concrete methods, the abstract class
	 * can provide an implementation for any interface methods it wants
	 * while leaving some others as abstract
	 */
	public static void main(String[] args) {
		Chair c = new Chair();
		c.color = "Blue";
		c.comfiness = 10000;
		c.cost = 23000;
		c.numOfLegs = 4;
		c.numOfTimesSatUpon = 0;
		c.style = "Eclectic";
		c.texture = "Bird leathery";
		
		for(int i = 0; i < 850; i++) {
			c.sit();
		}
		c.recline(100);
		c.massage();
		
		Sittable d = new Chair();
		d.sit();
		// Using interfaces and abstract classes allows us to accomplish
		// Abstraction
		
		// It hides all of the complexity of the object, and the only visible
		// characteristics are what is relevant
>>>>>>> c7aa8f1b7228fd2fcb2604990bc660c19e2a68d4
	}

}
