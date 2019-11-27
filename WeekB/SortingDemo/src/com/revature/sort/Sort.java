package com.revature.sort;

import java.util.ArrayList;
import java.util.List;

public class Sort {

	/*
	 * This works, it's not too inefficient.
	 * Still much better than our recursive fibonacci
	 * function. However, it can still take a while
	 * with really large inputs
	 * Remember, this is O(n^2)
	 * Which is pretty much barely acceptable
	 */
	public static void bubbleSort(List<Integer> list) {
		
		// Loop through the entire list n - 1 times
		for(int i = 0; i < list.size() - 1; i++) {
			//System.out.println(list);
			// Need to step through the list
			// The bounds are from 1 to n - i
			// This is because previous iterations will
			// have already partially sorted the list
			// and there is no need to sort it again
			for(int j = 1; j < list.size() - i; j++) {
				// Each step, we need to compare the value
				// at this index to the previous one
				// and swap if necessary
				
				// If the value at the right is smaller
				// than the value at the left
				// then swap them
				if(list.get(j) < list.get(j - 1)) {
					int temp = list.get(j);
					list.set(j, list.get(j - 1));
					list.set(j - 1, temp);
					// The above 3 statements will
					// swap the values
					// at index j and j - 1
				}
			}
		}
	}
	
	// We're going to want to create a helper method
	// to merge two smaller sorted lists back together
	public static void mergeSort(List<Integer> list) {
		
		// Recursive algorithms need base cases
		// As we talked about previously, the base
		// cases for mergeSort are when the list
		// has either 0 or 1 elements left
		if(list.size() < 2) {
			// We just quit the method early in this case
			// since they are already sorted
			return;
		}
		// Note that our base cases NEED to prevent the
		// recursive call
		
		
		// Start by determining the middle of the list
		int middle = list.size() / 2;
		
		// The left list will be of size middle
		// The right list will be of size n - middle
		// (all of the remaining values)
		
		List<Integer> left = new ArrayList<>();
		
		// This new left list is empty, so we should copy
		// the values over
		
		for(int i = 0; i < middle; i++) {
			left.add(list.get(i));
		}
		
		List<Integer> right = new ArrayList<>();
		
		for(int i = middle; i < list.size(); i++) {
			right.add(list.get(i));
		}
		
		// Now, the left and right arrays are still not sorted
		// But, we can recursively sort them using MergeSort
		// However, we need to make sure we add in the base cases
		
		mergeSort(left);
		mergeSort(right);
		
		merge(list, left, right);
		//System.out.println(list);
	}
	
	// The first parameter is the resulting list, and the next
	// 2 are the left and right lists to be merged
	// The assumption here is that left and right are already sorted
	// After the method is done, list will contain
	// all of the values from left and right, and will also
	// be sorted
	private static void merge(List<Integer> list, List<Integer> left, List<Integer> right) {
		// We will have separate indexes to track how far
		// we have copied from the left and right lists
		// respectively
		// We can add those 2 indexes together to determine
		// the index that we will copy into for the result
		int i = 0;
		int j = 0; // These will be the indexes for left and right
		// respectively
		
		// Additionally, I am assuming that the sizes of these lists
		// are already determined, and we are simply changing
		// the values
		
		
		// We will continue to loop as long as there is
		// something left to copy in both sub lists
		while(i < left.size() && j < right.size()) {
			// Copy the value from left array
			if(left.get(i) < right.get(j)) {
				list.set(i + j, left.get(i));
				i++;
			} else {
				list.set(i + j, right.get(j));
				j++;
			}
		}
		// Outside this while loop, one of our sub arrays has finished copying
		// But the other hasn't
		
		// So I can copy the values in order to the result
		for(; i < left.size(); i++) {
			list.set(i + j, left.get(i));
		}
		
		// Do the same thing for the right array
		for(; j < right.size(); j++) {
			list.set(i + j, right.get(j));
		}
	}
}
