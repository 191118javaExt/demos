package com.revature.nonaccessmods;

public class Driver {
	
	/*
	 * There are several non-access modifiers
	 * 
	 * They can be used in conjunction with access modifiers
	 * 
	 * The first is static, which we can see in the main method
	 * 
	 * Static as mentioned before with variable scopes
	 * sets the scope of the variable or method
	 * Can be declared on fields or methods
	 * 
	 * final:
	 * The final keyword can be used on classes, methods, or fields
	 * If used on a field, the value cannot be changed (constant)
	 * If used on a method, the method cannot be overridden
	 * If used on a class, the class cannot be extended
	 * 
	 * One example, the String class is final
	 * Additionally, internal to the String class, the char[] that represents
	 * the text is also final, this makes the String immutable
	 * 
	 * Additionally, the final keyword can also be used for local variables
	 * 
	 * abstract:
	 * The abstract keyword can be used on classes or methods
	 * It prevents the class from being instantiated
	 * Example: new Person() would not compile if Person was an abstract class
	 * abstract can only be used on methods inside an abstract class
	 * abstract methods are optional in abstract classes, you CAN still have
	 * regular, concrete methods
	 * You don't need to have a single abstract method if you do not want to
	 * 
	 * synchronized:
	 * The synchronized keyword can be used on variables
	 * It prevents multiple threads from accessing it at once, only
	 * one thread at a time can access it
	 * 
	 * volatile:
	 * The volatile keyword can be used on variables
	 * It loads the value in main memory, instead of the stack/heap
	 * This means that any value that would normally be on the stack,
	 * would now be accessible by all threads
	 * This also means that it shares the same value with any volatile variable
	 * of the same name
	 * 
	 * transient:
	 * The transient keyword is used on fields
	 * It prevents the field from being serialized
	 * 
	 * strictfp:
	 * This keyword is used on classes
	 * Any class declared with strictfp will have all methods, and
	 * any variables declared in them follow strict
	 * IEEE floating point format
	 * 
	 * native:
	 * The native keyword is used for methods
	 * This means that the implementation of the method will
	 * be provided somewhere else in a different language
	 */
	
	static int z;

	public static void main(String[] args) {
		final int x = otherMethod();
		
		System.out.println(x);
		
		//x = 100;
		// The above statement fails to compile since x is
		// declared as final, the value may not be changed
		
		//static int y = 100;
		// The above statement does not compile
		// since static cannot be used for method/block scope variables
		
		Shape[] arr = new Shape[4];
		
		arr[0] = new Triangle(5.36, 4.27);
		arr[1] = new Triangle(Math.PI, 4.0);
		arr[2] = new Circle(1.0);
		arr[3] = new Circle(7.321);
		
		for(int i = 0; i < arr.length; i++) {
			System.out.println(arr[i].area());
		}
	}
	
	public static int otherMethod() {
		return 101;
	}
}
