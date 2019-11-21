package com.revature.interfaces;

public interface Sittable {

	void sit();
	// Note, that the above statement does not declare public or abstract
	// This is fine for compilation, as the compiler will automatically
	// add in those keywords
	// This method is still public and abstract
	
	// If you attempt to use a different access modifier, such as private or protected
	// it will not compile
	
	//private void someMethod();
	
	// The default keyword was added in Java 8 to allow interfaces
	// to provide an implementation for abstract methods
	// This was created so Java could have backwards compatibility
	// with previous versions
	default void sit2() {
		System.out.println("Inside sit2 method from interface!");
	}
	// The above method works, but is generally inadvisable
	
	int x = 1000;
	// This variable will be changed to public static final
}
