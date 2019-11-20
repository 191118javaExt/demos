package com.revature.strings;

import java.util.Arrays;

public class Driver {

	public static void main(String[] args) {
		String L = "Larry";
		L.concat(L);
		System.out.println(L); // Larry
		
		//L = "Larry" + "Larry"; // Gets constructed in String Pool
		L = L + "Larry"; // Gets constructed outside the String Pool
		System.out.println(L); // LarryLarry
		
		String m = "LarryLarry";
		
		System.out.println(L == m); // true
		
		L = L.intern(); // Returns the reference to the String
		// in the String Pool that has the same value as L
		System.out.println(L == m);
		
		
		String k = L.substring(2); // k = "rryLarry
		System.out.println(k.indexOf("arr"));
		
		// ALL String methods return NEW Strings
		// They do NOT modify the original String
		// String objects are immutable
		L.toLowerCase();
		System.out.println(L.equals("larrylarry")); // false
		
		L = L.toLowerCase();
		System.out.println(L.equals("larrylarry")); // true
		
		System.out.println(L == "larrylarry"); // false
		
		// When comparing Strings
		// It is best practice to use .equals method
		// It is FAR more useful to compare the value
		// than to compare memory locations
		
		int[] result = findIndexes("mississippi", "s");
		
		for(int i = 0; i < result.length; i++) {
			System.out.println(result[i]);
		}
	}

	// This method should return the indexes for where
	// the pattern matches the input,
	// returns all instances
	public static int[] findIndexes(String input, String pattern) {
		int first = input.indexOf(pattern);
		
		if(first == -1) {
			return new int[0]; // array of size 0
		}
		
		
		String indices = "" + first;
		
		int index = first;
		int smallIndex = first;
		while(smallIndex != -1) {
			String remainder = input.substring(index + 1);
			// remainder is the remaining portion of the string
			// after the first pattern
			
			smallIndex = remainder.indexOf(pattern);
			// smallIndex is the index of the next pattern
			// based on the smaller remaining string
			
			index += smallIndex + 1;
			// Gives you the actual index based on the
			// input string
			
			if(smallIndex != -1) {
				indices += "," + index;
				// Track the new index
			}
		}
		
		String[] stringValues = indices.split(",");
		int[] arr = new int[stringValues.length];
		
		for(int i = 0; i < arr.length; i++) {
			arr[i] = Integer.parseInt(stringValues[i]);
		}
		
		return arr;
	}
	
	/* Example:
	 * input = "LarryLarry"
	 * pattern = "arr"
	 * 
	 * return [1, 6]
	 */
	
	/*
	 * Steps:
	 * Find first instance
	 * Start at that point for next loop to find next instance
	 * Track how many times we find an instance
	 * Keep track of where we start each loop to get full index
	 */
}
