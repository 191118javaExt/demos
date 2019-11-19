package com.revature.primitives;

public class Driver {

	/*
	 * This is a multi-line comment
	 * It starts with /* and ends with */
	
	/*
	 * When you create a new multi-line comment
	 * with /*, the IDE will end it for you
	 * And create extra *s for organization
	 */
	
	/*
	 * Java has 8 primitive values
	 * These are NOT objects, they are
	 * specifically different
	 * 
	 * int ==== 4 bytes in size (32 bit)
	 * float === 4 bytes in size (32 bit)
	 * double === 8 bytes in size (64 bit)
	 * short  === 2 bytes (16 bit)
	 * long === 8 bytes (64 bit)
	 * ======== These 5 are the numerical primitives
	 * boolean (size depends on JVM) == True/False
	 * char === 2 bytes (16 bit) letters/numbers
	 * byte === 1 byte (8 bit) === not-negative
	 */
	public static void main(String[] args) {
		// You can declare a variable like this
		int x;
		// This variable is of type int, so it can
		// hold integer values, and can be negative
		// Currently, this variable is not initialized
		// This means it has no value
		// If you want to create a variable with a
		// value, you use the assignment operator =
		int y = 15;
		
		// You can also assign/change values afterwards
		x = 37;
		
		System.out.println(x + y); // 52
		System.out.println(x - y); // 22
		System.out.println(x * y); // 555
		System.out.println(x / y); // 2, the decimal
		// value is truncated
		System.out.println(x % y); // 7
		// This is called the modulus operator,
		// and calculates the remainder after division
		
		double d = 33.597;
		System.out.println(d * d);
		
		// The decimal literals are double
		// by default
		// Adding f at the end, makes it a float
		float f = 1001.336f;
		System.out.println(f * f);
		
		short s = 10;
		System.out.println(s * s);
		
		long l = 3000000000L;
		System.out.println(l);
		
		boolean b1 = true;
		boolean b2 = false;
		
		// There are logical operators that
		// act on boolean values
		
		// AND, OR, NOT
		System.out.println(b1 && b2);
		// true AND false = false
		
		System.out.println(b1 || b2);
		// true OR false = true
		
		System.out.println(!b1);
		// NOT true = false
		
		// && and || are short-circuiting operators
		// We know that if any of the operands in
		// && is false, the result will be false
		// Short-Circuiting means that execution
		// of the program will skip any remaining
		// operands and will immediately evaluate
		// the result
		
		// || also short-circuits if any of the
		// operands are true
		
		System.out.println(false && doTask(true));
		System.out.println(true || doTask(false));
		// The above statements short circuit, so
		// we do not see Task Performed
		
		System.out.println(false & doTask(true));
		System.out.println(true | doTask(false));
		// The above statements use bitwise
		// logical operators, which do not
		// short-circuit
		// Task Performed will be displayed
		
	}
	
	// Outside of the scope for the main method, we can
	// declare other methods/functions
	
	// Methods are declared as follows
	// returnType methodName(parameters) { ... body ... }
	static boolean doTask(boolean b) {
		// This function is named doTask
		// It has 1 parameter of type boolean, which is
		// named b
		
		System.out.println("Task performed!");
		return b;
	}

}
