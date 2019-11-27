package com.revature.stringbuilder;

public class Driver {

	public static void main(String[] args) {
		// We have seen earlier that Strings are immutable
		// When you want a different string, we get a new
		// String object
		
		// In our previous example with finding the index of all
		// instances of a pattern in a string
		// We used string concatenation multiple times
		// This can be really inefficient
		// As we are creating many String objects
		
		// If we need to construct a String it would be
		// better if we have a mutable string
		
		// The StringBuilder class is a class that allows
		// for mutable Strings
		
		StringBuilder sb = new StringBuilder("Hello");
		StringBuilder sb2 = sb;
		
		String s = "Hello";
		String s2 = s;
		
		// We have 2 StringBuilder objects that are pointing to the same
		// object in memory
		
		System.out.println(sb == sb2.append(" World!")); // true
		System.out.println(s == s2.concat(" World!")); // false
		
		// The above statements show that String objects are immutable
		// but StringBuilder objects ARE mutable
		
		// If we were to use StringBuilder in our previous example
		// that found all indices of a pattern in a String,
		// it would have been slightly more efficient
		// As we would no longer be creating multiple String objects
		
		StringBuffer sb3 = new StringBuffer("Larry");
		// StringBuffer is similar to StringBuilder in that it
		// is a mutable version of Strings
		
		// The difference is that StringBuffer is thread-safe, while
		// StringBuilder is not thread-safe
		
		// The extra complexity in order to allow StringBuffer to become
		// thread-safe also makes it slightly slower than StringBuilder
		
		/*
		 * Summary:
		 * Differences between String, StringBuilder, and StringBuffer
		 * 
		 * String is immutable, but StringBuilder AND StringBuffer are mutable
		 * 
		 * StringBuilder is not thread-safe, but StringBuffer is
		 * 
		 * StringBuilder is faster than StringBuffer
		 * 
		 * 
		 * Since Strings are immutable, they are inherently thread-safe
		 * Although this is kind of irrelevant
		 */
	}
}
