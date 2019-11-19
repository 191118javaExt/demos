package com.revature.memory;

public class Driver {

	public static void main(String[] args) {
		// When objects are created, they are stored
		// on what is called the stack
		
		// When local variables (block or method scope primitives)
		// are declared, they are stored on
		// what is called the heap
		
		// There is 1 stack shared for the entire program
		// There is more detail here that we will discuss
		// later
		
		// However, objects are not deleted immediately
		// when the variable that refers it is not
		// visible

		otherMethod();
		// When we call this method, it creates a new
		// Driver object
		// But, the reference variable is out of scope
		// so we do not have access to it
		
		// In older languages, such as C or C++, this leads
		// to a memory leak
		// We have reserved for the Driver object, and have
		// not deleted it, so it is still in use
		
		// However, in Java, the Garbage Collector, will
		// eventually recognize that the instance is not
		// accessible, and will delete it for us
		
		// This is not immediate
		// We cannot force this to happen
		// At best, we can recommend that the garbage
		// collector starts acting
		
		// Generally though, recommending the GC to act
		// will not be as fast as letting it work
		// by itself
		
		// The driver instance is stored at some memory
		// address/location
		
		// Your memory is structured into many different
		// slots of a certain size, generally 64 bits
		// As that is what your operating system is built
		// in mind
		
		// Each of those slots has a number associated with it
		// Called its address
		
		// For example, perhaps that driver instance is stored
		// at location 10,000
		
		// d, as the reference variable for the object simply has
		// the value 10,000
		
		// At the memory location itself, there are the values
		// for y and any other instance scoped variables
		
		// This is how instances can have their own copies of
		// instance variables
	}
	
	static void otherMethod() {
		// We create a new instance of the Driver class
		// This object is stored on the stack
		// And the variable d is stored on the heap
		Driver d = new Driver();
		
		// d and the new Driver() are different things
		
		// d is called the reference variable
		// It has a value which is the memory location
		// of the object itself (the new Driver)
		
		// The new Driver is an object that is stored on
		// the stack
		
		// What this means, is that when d is no longer
		// within scope, the new Driver still exists
		// Even though we do not have access to it.
		
		System.gc();
	}

}
