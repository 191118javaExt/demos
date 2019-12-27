package com.revature;

public class Driver {

	public static void main(String[] args) {
		int[] arr;
		arr = new int[5];
		// arr is an array of 5 ints
		
		int[][] arr2;
		// This is a reference variable of a 2-dimensional array
		// It is an array of an array of ints
		
		arr2 = new int[5][];
		// This declares the arr2 object as 5 arrays of ints
		// Each of the nested 5 arrays, are currently null
		// arr2 = [null, null, null, null, null]

		for(int i = 0; i < 5; i++) {
			arr2[i] = new int[5];
			// Changing each of those nulls to be [0, 0, 0, 0, 0]
		}
		
		// arr2 = [ [0, 0, 0, 0, 0], [0, 0, 0, 0, 0], [0, 0, 0, 0, 0], [0, 0, 0, 0, 0], [0, 0, 0, 0, 0] ]
		arr2[0][3] = 5;
		// arr2 = [ [0, 0, 0, 5, 0], [0, 0, 0, 0, 0], [0, 0, 0, 0, 0], [0, 0, 0, 0, 0], [0, 0, 0, 0, 0] ]
		
		System.out.println(arr2.length); // 5
		System.out.println(arr2[0].length); // 5
		
		int[][] arr3 = new int[5][];
		
		for(int i = 0; i < 5; i++) {
			arr3[i] = new int[i + 1];
		}
		/*
		 * arr3 looks like this:
		 * [ [0], [0, 0], [0, 0, 0], [0, 0, 0, 0], [0, 0, 0, 0, 0] ]
		 */
		
		System.out.println(arr3.length); // 5
		System.out.println(arr3[0].length); // 1
	}

}
