package com.revature.arrays;

import com.revature.objects.*;
// This line will import all class declarations
// into this package

public class Driver {

	/*
	 * Java has something called arrays
	 * These are groups of same typed values
	 * 
	 * For example, in the main method, there is
	 * one parameter that is an array of String values
	 * 
	 * These are the command line arguments
	 * 
	 * The JVM will construct the String array
	 * from the command line arguments and
	 * store them in the args variable
	 */
	public static void main(String[] args) {
		// Arrays have a particular size,
		// and individual values can be accessed
		// using [] brackets
		// Note that the values are stored
		// according to an index
		// Which starts at zero
		
		// The syntax for creating your own array
		// is as follows
		int [] arr = new int[10];
		
		// As you can see, we are using the new keyword,
		// so you can recognize that arrays are objects
		
		// With this in mind, there are some properties
		// and behaviors available for that object
		
		System.out.println(arr.length);
		// length is a property on the array, which
		// is the length

		// You can access the values using []
		
		//System.out.println(arr[3]);
		// Note, this is the fourth value in the array
		
		for(int i = 0; i < arr.length; i++) {
			System.out.println(arr[i]);
		}
		
		for(int i = 0; i < arr.length; i++) {
			arr[i] = i;
			System.out.println(arr[i]);
		}
		
		String[] arr2 = new String[3];
		// This creates an array of size 3,
		// of type String, each String value
		// will be initialized to the default
		// for Strings, which is null
		
		for(int i = 0; i < arr2.length; i++) {
			System.out.println(arr2[i]);
		}
		
		Shape [] shapeArray = new Shape[3];
		// We have an array of 3 Shapes,
		// Note, that these are initialized
		// to null
		
		for(int i = 0; i < shapeArray.length; i++) {
			shapeArray[i] = new Triangle();
		}
		System.out.println(shapeArray[0].area);
	}

}
