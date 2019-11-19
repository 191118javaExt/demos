package com.revature.scopes;

public class Driver {

	// There are 4 variable scopes in Java
	// Instance
	// Static/global
	// Method
	// Block
	
	// Static scope is available for the entire
	// lifetime of the class
	// Generally, it is available for the entire
	// runtime of the Java application
	
	static int x;
	// x is declared with the static scope, so it is
	// always available
	
	int y;
	// y is declared with the instance scope
	// It is available to instances of this class
	public static void main(String[] args) {
		System.out.println(x);
		x = 200;
		System.out.println(x);
		
		// We have created a Driver class
		// We can therefore create instances of this
		// blueprint using the new keyword
		
		Driver d = new Driver();
		// d is a variable, of type Driver
		// it is NOT a primitive value, it is an object
		
		// Since x is static scope, x belongs to the Driver
		// class, not to d
		
		// Since y is instance scope, y belongs to d, and any
		// other instances of Driver
		
		// Each instance of this class has their own copies
		// of instance scoped variables
		
		System.out.println(d.y);
		d.y = 100;
		System.out.println(d.y);
		// The dot operator is how we access member variables
		// of an object
		
		// The variable d is method scope
		// It is a variable that only exists inside
		// the method in which it was declared
		// So d only exists inside the main method

		otherMethod();
		
		// The last scope is Block scope
		// It works similarly to method scope
		// except variables are only visible
		// within that block of code
		// Blocks are defined with { .. }
		
		// This creates a block
		{
			int z = 100;
		}
		
		//System.out.println(z);
		// Error: z cannot be resolved to a variable
		// z is scoped to that block
		
		// Block scopes are visible to further nested
		// blocks, but not outer blocks
		
		{
			int z = 1000;
			{
				System.out.println(z);
				int z2 = 2000;
			}
			//System.out.println(z2);
			// z2 cannot be resolved to a variable
		}
	}
	
	// void is the return type that means it does not
	// return anything
	static void otherMethod() {
		//System.out.println(d.y);
		// The above line gives an error that
		// d cannot be resolved to a variable
		// d is not visible outside of the main method
		
		// However, since we are still inside the Driver
		// class, we have access to any static scoped
		// variables, such as x
		
		System.out.println(x);
	}

}
