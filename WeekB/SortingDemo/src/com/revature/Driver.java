package com.revature;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.revature.fib.Fibonacci;
import com.revature.sort.Sort;

public class Driver {

	public static void main(String[] args) {
		//int[] arr = new int[10]; // These 10 values CANNOT be null
		//Integer[] arr2 = new Integer[10]; // These 10 values CAN be null
		// Only reference variables may be null
		// Primitives do NOT have reference variables
		// So, primitives cannot be null
		// Null represents a non-existent memory location
		
		//String s = "Hello World";
		//System.out.println(s.split(" "));
		// The above statement works as intended.
		
		//s = null;
		//s.split(" ");
		// This statement compiles, however, there's an issue
		// We are trying to call a method on an object that does
		// not exist
		
		// This will crash your program when you run it, however, it DOES
		// compile
		// You will receive what is called a NullPointerException
		
		// The above stuff is an aside, unrelated to Fibonacci or sorting
		
		final int AMOUNT = 1000000;
		// The naming scheme for constants is different than
		// the naming scheme for changing values
		// Normally, we start lowercase and use camel-casing
		// However, constants are all caps, and use underscores
		// between words
		
		// This is so other humans reading our code, can recognize
		// at a glance if a value is constant or not
		for(int i = 0; i < AMOUNT; i++) {
			//System.out.println(i + ": " + Fibonacci.recursiveFib(i));
			//System.out.println(i + ": " + Fibonacci.iterativeFib(i));
			//System.out.println(i + ": " + Fibonacci.cachedRecursiveFib(i));
		}
		
		List<Integer> l1 = new ArrayList<>();
		List<Integer> l2 = new ArrayList<>();
		
		final int SIZE = 90000;
		for(int i = 0; i < SIZE; i++) {
			int value = (int) (Math.random() * SIZE);
			// The above statement is using what is called casting
			// This is converting the type of a value into what
			// is declared in parenthesis
			// There are many rules associated with casting
			// As sometimes values cannot be properly converted
			// For example, the String "Larry" cannot be casted into
			// an int or any primitive value (byte might work)
			
			// In this example, we are casting a decimal value into an
			// int primitive. This will cause us to lose precision, as ints
			// cannot have decimal values
			// But in this case, this is what we want the result to be
			// We want to truncate the decimal from the double
			// Ex: 44.9747621 -> 44
			l1.add(value);
			l2.add(value);
		}
		
		// Now we have filled the list with 45 values, between 0 and 44
		// Note, that repeats can occur
		
		
		//System.out.println(Arrays.toString(new int[10]));
		
		long before = System.nanoTime();
		//System.out.println(l.toString());
		// This will convert the list into a nice format to display
		Sort.bubbleSort(l1);
		//Sort.mergeSort(l);
		//System.out.println(l.toString());
		
		long after = System.nanoTime();
		long result1 = after - before;
		System.out.println("BubbleSort took " + result1 + "ns to complete.");
		
		before = System.nanoTime();
		
		Sort.mergeSort(l2);
		
		after = System.nanoTime();
		long result2 = after - before;
		
		System.out.println("MergeSort took " + result2 + "ns to complete.");
		
		System.out.println("MergeSort is " + ((result1 - result2) / result2) * 100 
				+ "% faster than BubbleSort");
	}
}
