package com.revature.controlflow;

public class Driver {

	// Execution of a Java program always begins
	// at the main method
	// Statements will be executed in order, one by one
	
	// There are some control flow statements
	// that allow us to modify the organization
	// of the statements that are executed
	public static void main(String[] args) {
		// The first is the if statement
		// This will only execute if the condition
		// is true
		
		// The inside of the parenthesis must
		// evaluate to a boolean value
		// So this means using logical and
		// relational operators
		// if( ) { ... }
		
		int x = 100;
		int y = 10;
		
		// Relational operators are the comparison
		// operators such as greater than or less than
		System.out.println(x < y); // true
		// These operators will evaluate to a boolean
		
		// Geater than or equal to
		System.out.println(x >= y); // false
		
		// Equality
		System.out.println(x == y); // false
		System.out.println(x != y); // true
		
		System.out.println( (x != y) && (x > y) );
		// true && false = false
		
		if(x < y) {
			System.out.println("X was smaller than Y");
		} else {
			// The else keyword can be chained to
			// an if statement, and will execute
			// only if the if statement
			// does not run
			System.out.println("X wasn't smaller than Y");
		}
		
		// Furthermore, if statements can be chained
		// onto the else statements, to see long
		// chains of control flow statements
		
		if(x == y) {
			System.out.println("Equals");
		} else if(x > y) {
			System.out.println("Greater");
		} else {
			System.out.println("Less");
		}
		
		// Switch statements
		// These are large branching control flow
		// statements, that have many different cases
		// usually far more than would be
		// easy to read in a chain of if-elses
		int var = 100;
		switch(var) {
		case 100:
			System.out.println("One hundred");
			break;
			// This keyword will "break" out of the
			// control flow statement, skipping to the end
		case 200:
			System.out.println("Two hundred");
			break;
		}
		
		int month = 6;
		String name;
		
		switch(month) {
		case 1:
			name = "January";
			break;
		case 2:
			name = "February";
			break;
		case 12:
			name = "December";
			break;
		default:
			name = "N/A";
			break;
		}
		
		System.out.println(name);
		
		// There are control flow statements
		// called loops to repeat a group
		// of statements a number of times
		// based on some condition
		
		// The while loop
		while(var < 200) {
			//var = var + 1;
			//var++; // Called post-increment operator
			++var; // Called pre-increment operator
			System.out.println("Inside loop");
		}
		// This while loop will start executing
		// if the condition is true, and continue
		// to repeat as long as it is still
		// true at the end of the loop
		
		System.out.println(var++);
		System.out.println(var);
		
		// The next loop structure is called
		// the for loop
		// We like to use for loops to execute
		// a block of code a specified number of times
		
		// Has 3 sections
		// Initialization
		// Condition
		// Incrementation
		for(int i = 0; i < 10; i++) {
			System.out.println(i);
		}
		
		// The next loop structure is called
		// a do-while loop
		
		int var2 = 0;
		
		while(var2 > 100) {
			System.out.println("while loop: " + var2);
		}
		
		// The syntax is as follows
		do {
			System.out.println("do-while loop: " + var2);
		} while(var2 > 100);
		
		System.out.println("Outside loops");
	}

}
