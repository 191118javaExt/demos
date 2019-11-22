package com.revature;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class Driver {

	public static void main(String[] args) {
		List<Integer> l = new ArrayList<>();
		// This is referred to as a generic
		// You would declare what type of objects
		// are allowed in the collection with the < > symbols
		// Inside, you declare a type
		
		// Integer is an object representation of the int primitive
		// There is an object representation for all primitive
		// datatypes
		// These are referred to as Wrapper Classes
		
		/*
		 * Integer
		 * Long
		 * Short
		 * Double
		 * Float
		 * Boolean
		 * Character
		 * Byte
		 * 
		 * One characteristic of these wrapper classes, is that
		 * they are immutable.
		 * 
		 * Additionally, Java has extra support surrounding
		 * these wrapper classes called auto-unboxing and auto-boxing
		 * 
		 * In some methods, there may be parameters that require
		 * a primitive, and if a wrapper object is provided instead
		 * the JVM will auto-unbox that wrapper object into a primitive
		 * to use instead
		 * 
		 * Similarly, if a parameter requires a wrapper object and primitive
		 * is provided, the primitive will be auto-boxed into a wrapper object
		 * 
		 * These are how we will accomplish using collections with primitives
		 */
		
		l.add(100);
		// The primitive int in the above statement is being auto-boxed into
		// an Integer object
		
		System.out.println(l.get(0) + 1);
		// The above statement retrieves an Integer object, which is then
		// auto-unboxed into an int in order to add the +1
		
		System.out.println(add(new Integer(5), new Integer(3)));
		// There are no compiler errors with the above statement
		// as the Integer objects are being auto-unboxed into ints
		
		l.add(1);
		l.add(2);
		l.add(3);
		l.add(4);
		l.add(5);
		
		// An enhanced for-loop or for-each loop looks like this
		for(Integer i : l) {
			System.out.println(i);
		}
		// There are two portions
		// The left portion is the variable that has the individual value
		// in the list for each iteration
		// The right portion is the variable that has the collection object
		// Note, we do not have access to the indexes
		// We are working directly with the values
		
		// This for-each loop works with a primitive int value
		// because each Integer object is being auto-unboxed
		for(int i : l) {
			System.out.println(i);
		}
		
		System.out.println("========================");
		
		Iterator<Integer> iter = l.iterator();
		
		while(iter.hasNext()) {
			int value = iter.next();
			System.out.println(value);
		}
		// We can use iterators directly, instead of using them
		// through an enhanced for loop
		
		// You can still use iterators inside regular for loops
		
		for(Iterator<Integer> iter2 = l.iterator(); iter.hasNext();) {
			int value = iter2.next();
			System.out.println(value);
		}
		
		System.out.println("======================");
		
		Set<Double> s = new HashSet<>();
		// Note for the constructor call, the generic can be left empty
		
		s.add(0.0);
		s.add(1.0);
		s.add(2.0);
		s.add(3.0);
		s.add(4.0);
		s.add(1000.3);
		s.add(231.58);
		
		for(double d : s) {
			System.out.println(d);
		}
		
		// Note, these values are not kept in the same
		// order as they were inserted
		// They aren't particularly sorted, but it might
		// look that way a little
	}
	
	public static int add(int a, int b) {
		return a + b;
	}

}
