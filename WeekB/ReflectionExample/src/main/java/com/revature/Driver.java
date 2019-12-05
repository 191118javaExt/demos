package com.revature;

import java.lang.reflect.Field;

public class Driver {

	public static void main(String[] args) {

		/*
		 * Reflection provides ability to inspect and modify the runtime behavior of an
		 * application. Reflection in Java is one the advanced Core Java topic. We can inspect
		 * a classes, interfaces, enums, fields, methods, constructors, etc.
		 */

		// Let's make Strings mutable!
		String s = "Strings are ALWAYS immutable, right?";

		Class<String> stringClass = String.class;
		System.out.println(stringClass);

		System.out.println("Original value of 's': " + s);

		Field stringValue;

		try {

			// Get access to the 'value' field of the String class
			stringValue = stringClass.getDeclaredField("value");

			/*
			 * Change the accessibility of the 'value' field in the String class
			 * to true. The value of true indicates that the reflected object should
			 * suppress Java language access checking when it is used.
			 */
			stringValue.setAccessible(true);

			// Change the value of 'value' to something else...
			stringValue.set(s, "Bahahahahahaha!".toCharArray());

			// Print the new value of 's'
			System.out.println(s);

		} catch (NoSuchFieldException e) {
			e.printStackTrace();
		} catch (SecurityException e) {
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		}

		// Hopefully we didn't break anything...
		System.out.println("Strings are ALWAYS immutable, right?");

		// Let's try to fix this by dereferencing the String object that 's' points to
		s = null;
		stringClass = null;
		stringValue = null;

		// Suggest that the JVM run the garbage collector
		System.gc();

		// Eventually...maybe...probably not
		while("Strings are ALWAYS immutable, right?".equals("Bahahahahahaha!")) {
			System.out.println("Strings are ALWAYS immutable, right?");
		}

		// One day this will get executed...
		System.out.println("All better!");
	}
}
