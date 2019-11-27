package com.revature.fib;

import java.util.HashMap;
import java.util.Map;

public class Fibonacci {
	
	private static Map<Integer, Long> cache = new HashMap<>();

	/*
	 * This method is very short, clean, and easy to follow
	 * However, as we talked about, this is rather inefficient
	 */
	public static long recursiveFib(int n) {
		// The first thing we do, is calculate the base cases
		if(n <= 0) {
			return 0L;
		}
		if(n == 1) {
			return 1L;
		}
		
		// Then we calculate the result recursively
		return recursiveFib(n - 2) + recursiveFib(n - 1);
	}
	
	public static long iterativeFib(int n) {
		if(n <= 0) {
			return 0L;
		}
		if(n == 1) {
			return 1L;
		}
		
		long prevFib = 0L;
		long fib = 1L;
		for(int i = 1; i < n; i++) {
			long temp = fib;
			fib += prevFib;
			prevFib = temp;
		}
		
		return fib;
	}
	
	public static long cachedRecursiveFib(int n) {
		if(n <= 0) {
			return 0L;
		}
		if(n == 1) {
			return 1L;
		}
		if(cache.containsKey(n)) {
			return cache.get(n);
		} else {
			long result = cachedRecursiveFib(n - 2) + cachedRecursiveFib(n - 1);
			cache.put(n, result);
			return result;
		}
	}
}
