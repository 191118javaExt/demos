package com.revature;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
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
		
		
		System.out.println("================");
		
		Queue<String> q = new LinkedList<>();
		// First In, First Out datastructure
		
		q.add("Larry");
		System.out.println(q.peek());
		// peek() method returns the value at the front of the
		// queue, without removing them from the queue
		System.out.println(q.size());
		// Note, the method to determine the length of the queue,
		// is called size() instead of what we saw for Strings or arrays
		
		System.out.println(q.poll());
		// poll() method returns the value at the front of the queue,
		// but ALSO removes it
		System.out.println(q.size());
		
		q.add("Harry");
		q.add("Larry");
		q.add("Harry");
		
		for(String name : q) {
			System.out.println(name);
		}
		
		Map<String, Integer> m = new HashMap<>();
		
		m.put("Larry", 8675309);
		m.put("Harry", 6753098);
		m.put("Terry", 0010023);
		
		for(String name : m.keySet()) {
			System.out.println(name + " : " + m.get(name));
		}
		
		for(Map.Entry<String, Integer> entry : m.entrySet()) {
			System.out.println(entry.getKey() + " : " + entry.getValue());
			entry.setValue(10000000);
		}
		
		for(String name : m.keySet()) {
			System.out.println(name + " : " + m.get(name));
		}
		// Note, normally Enhanced for-loops create copies, so the original
		// values cannot be changed. But Maps access enhanced for-loops
		// indirectly, since they are not collections, so we can technically
		// change values. Be careful with this!
		
		Collections.sort(l);
		// Collections is the utility class for Collection objects
		// It has many helper methods that are static
		// So, we access these static methods through the Class
		// We do NOT need to create an instance of the Collections
		// class.
		
		// There are many methods available
		// We don't have time to talk about all of them, but the most commonly
		// used ones are sort, binarySearch, min, and max
		// Sometimes you might also see disjoint
		
		System.out.println(l);
		l.add(5);
		Collections.sort(l);
		System.out.println(l);
		
		/*
		 * For List implementations:
		 * One of the most commonly used List implementations is ArrayList
		 * It works similarly to an array, and is built out of an array
		 * But it has some nice features
		 * Unlike regular arrays, ArrayLists will expand in size as needed
		 * 
		 * LinkedLists are structured as a series of nodes
		 * O - O - O - O - O
		 * Where each O is a specific node, and each - is a link
		 * We only have access to the front most node
		 * And in order to get access to the others, we must step down each
		 * link
		 * 
		 * They can be either Singly Linked or Doubly Linked
		 * SinglyLinked: O -> O -> O -> O -> O
		 * DoublyLinked: O <-> O <-> O <-> O <-> O
		 * 
		 * Stacks are structured as a Last In, First Out data structure
		 * If you think about a stack of plates,
		 * You would always grab the top most plate
		 * That plate is the most recent plate that was added
		 * The oldest plate is on the bottom, and will only
		 * grabbed last
		 * The last plate added, as the first to be removed
		 * 
		 * In Java specifically, the Stack in memory, works exactly
		 * like this data structure
		 * The main method would be called first, and then perhaps
		 * other methods would be called
		 * These other methods must complete first, BEFORE returning to
		 * the main method
		 * Note, you may also say First In, Last Out, which means the same
		 * thing
		 * FILO or LIFO are exactly the same thing
		 * 
		 * Queues were already talked about, but they are a
		 * First In, First Out data structure
		 * Think of a line at a bank or some store
		 * The first person in line is the first to be done with the
		 * line
		 * Note, Last In, Last Out technically means the same thing,
		 * but this terminology is not really used
		 * People will look at you weirdly if you say this
		 * even though it is technically correct
		 * 
		 * Deque is kind of similar to Queue, except it is structured in
		 * reverse.
		 * So, while queues focus on the first person in line
		 * Deques are double ended, however, new values can be
		 * inserted at either end, so it can be used as a Queue or
		 * a Stack
		 * 
		 * Vector exists in Java, but it is a bit of a legacy Class
		 * It predates the Collection API
		 * It also predates the synchronized keyword
		 * The purpose was to have a list-like structure in Java
		 * that was thread-safe
		 * It technically still works as such, but it is far less
		 * efficient than more modern choices
		 * So at this point, we never use Vector
		 * 
		 * Other languages such as C++ still use Vector as a common
		 * data structure, but in Java, it is legacy
		 * You may be tempted to use it, but don't
		 * 
		 * Set and Map have 2 common implementations
		 * HashSet, and TreeSet as well as
		 * HashMap and TreeMap
		 * This similar naming scheme is on purpose, as
		 * they operate similarly
		 * 
		 * Hash implementations such as HashSet or HashMap
		 * utilize the hashcode() method to determine where
		 * to store a value
		 * Each object is turned into an index or sorts, via the hashcode()
		 * method
		 * Hashcode() calculates an integer based on the contents
		 * of an object
		 * 
		 * TreeSet and TreeMap store values in a binaryTree
		 * Binary Trees are another very common data structure, and
		 * one of the benefits is that you can maintain the order
		 * of the values, regardless of when they are inserted
		 * 
		 * So TreeSet and TreeMap are considered ordered versions of
		 * Set and Map
		 */
	}
	
	public static int add(int a, int b) {
		return a + b;
	}

}
