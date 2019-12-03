package com.revature;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Driver {
	/*
	 * Exceptions/Errors in Java are issues that can arise during 
	 * the runtime of a Java Application
	 * Java has categorized these "issues" into 2 categories
	 * Exceptions are "issues" that can be "reasonably" recovered from
	 * Errors are "issues" that cannot be "reasonably" recovered from
	 * 
	 * They are both similar in that they are issues that have occurred,
	 * but they are different in nature
	 * 
	 * They are represented in Java as Classes
	 * 
	 * There is a Throwable Class that is at the top
	 * of the Exception hierarchy
	 * 
	 * Throwable
	 * 	- Exception (checked)
	 * 		- IOException (example) (checked)
	 * 			- FileNotFoundException (example) (checked)
	 * 		- RuntimeException (unchecked)
	 * 			- ArithmeticException (example) (unchecked)
	 * 			- NullPointerException (example) (unchecked)
	 * 	- Error
	 * 		- StackOverflowError
	 * 		- OutOfMemoryError
	 * 
	 * Note, these are only SOME of the Exception/Error classes
	 * There are MANY more, and we can also create out own
	 * 
	 * There is a further categorization of Exceptions into
	 * checked and unchecked Exceptions
	 * 
	 * Exceptions that do NOT extend RuntimeException are CHECKED Exceptions
	 * Exceptions that DO extend RuntimeException are UNCHECKED Exceptions
	 * 
	 * Checked vs Unchecked
	 * Some Exceptions can be determined if they are possible of occurring
	 * at compile time
	 * 
	 * Checked Exceptions are issues that are generally considered external
	 * to the application, or perhaps instead that it is not the application's
	 * place to resolve it
	 * 
	 * Examples, File not Found
	 * These IOExceptions are one example of checked Exceptions
	 * We can predict that this can occur, and methods are declared
	 * as having the potential of an IOException occurring
	 * 
	 * If you are using a method that has been declared as "potentially"
	 * 'throwing' a checked Exception, then you MUST write code to handle
	 * that Exception, or your code will not compile
	 * 
	 * Issues that actually occur are said to be 'thrown'
	 * 
	 * We resolve these issues by 'catching' them
	 * Now, in many scenarios, it is as simple as ignoring the problem
	 * and just moving on to the next step
	 * 
	 * A common scenario might be calculating an average of a list of
	 * values
	 * You add them up, and divide by how many there were
	 * But what happens if there was an empty list?
	 * The resolution would be to catch the ArithmeticException
	 * and instead just return zero instead of crashing
	 * 
	 * In other scenarios, we might simply do literally nothing
	 * We just need to declare the catch block
	 */

	public static void main(String[] args) {
		/*
		 * We use the 'try' statement to declare a block
		 * of statements that 'might' throw an Exception/Error
		 */
		
		/*
		 * Note that try blocks will not compile by themselves
		 * They need at least 1 catch block (there can multiple catches)
		 * or instead a 'finally' block
		 */
		try {
			System.out.println("Something");
		} catch(ArithmeticException e) {
			System.out.println("Nothing went wrong");
		}
		// In the above case, no Exception actually occurs
		// So nothing is caught, and the catch block is never run
		
		try {
			String s = null;
			char c = s.charAt(0); // Throws a NullPointerException
			System.out.println(c);
		} catch(NullPointerException e) {
			System.out.println("Resolved");
		}
		
		System.out.println("Do I reach this statement?");
		
//		int[] arr = new int[5];
//		for(int i = 0; i < 5; i++) {
//			System.out.println(arr[i]);
//		}
		
		/*
		 * Input Output
		 * There is a class in Java called Scanner
		 * It allows us to receive input from some source
		 * These "sources" are represented as InputStream objects
		 * InputStreams just represent a stream of input coming from
		 * somewhere
		 * This somewhere might be from the console, or from a file
		 * or from some large array
		 * 
		 * Scanner allows us to step through the input token by token
		 * These "tokens" are generally separated by whitespace, such
		 * as spaces or tabs, or new lines
		 * 
		 * "Hello, my name is Larry." has 5 tokens, which are
		 * "Hello," "my" "name" "is" "Larry."
		 * 
		 * We can also optionally grab entire lines
		 */
		
		// System.in is an InputStream that represents input from the
		// console
		Scanner s = new Scanner(System.in);
		
		String token = s.next();
		System.out.println(token);
		
		String token2 = s.next();
		System.out.println(token2);
		
//		while(s.hasNext()) {
//			System.out.println(s.next());
//		}
		
//		System.out.println(s.nextLine());
		
		s.close();
		
		File f = new File("src/main/resources/coffee");
		
//		Scanner s2 = new Scanner(f);
		// The constructor for Scanner that takes a File
		// as a parameter has declared FileNotFoundException
		// as potentially possible
		
		// This means, our program will NOT compile until
		// we resolve it
		
		try {
			Scanner s2 = new Scanner(f);
			String firstLine = s2.nextLine();
			System.out.println(firstLine);
			
			while(s2.hasNext()) {
				System.out.println(s2.nextLine());
			}
		} catch(FileNotFoundException e) {
			System.out.println("Did I find the file?");
		}
		
		try {
			throwsUnchecked();
		} catch(RuntimeException e) {
			System.out.println("Caught!");
		}
		
		//throwsUnchecked();
		
		try {
			throwsChecked();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/*
	 * The method is declared with a RuntimeException
	 * This means that the compiler is aware that it
	 * might throw a RuntimeException
	 * Not that it definitely will
	 */
	public static void throwsUnchecked() throws RuntimeException {
		// This is the syntax to actually throw an Exception
		// object ourselves
		throw new RuntimeException("This is a RuntimeException");
	}
	
	public static void throwsChecked() throws FileNotFoundException {
		if(false) {
			throw new FileNotFoundException();
		}
		/*
		 * Another name for Checked Exceptions
		 * is Compile-time Exceptions
		 * 
		 * Be careful however, because this only means
		 * that they must be handled, or it will not
		 * compile
		 * 
		 * These Compile-time Exceptions would still occur
		 * at Runtime
		 */
	}
}
