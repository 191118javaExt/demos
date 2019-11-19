package com.revature.objects;

public class Driver {

	public static void main(String[] args) {
		// The new keyword, is used to declare
		// a new object, and we are invoking
		// the no-argument constructor of the
		// Shape class
		Shape s = new Shape(10.5, 27);
		
		// If you do not create ANY constructors
		// at all, the compiler will create
		// one for you
		// It is called the default constructor
		// And is a no-argument constructor,
		// that simply calls super()
		
		System.out.println(s.area);
		
		s.bounce("Twice!");
		
		Triangle t = new Triangle();
		
		t.bounce(5);
		
		// This is covariance
		// We have a Triangle object stored
		// in a Shape reference variable
		Shape s2 = new Triangle();
		
		// This means that any methods
		// called, will be implemented from
		// the Triangle class
		
		// However, since we are using a Shape
		// reference variable, the only methods
		// visible, are the ones declared in the
		// Shape class
		
		//s2.bounce(5);
		// This method is not visible
		// because we are using a Shape
		// reference variable
		
		System.out.println("=============");
		
		s2.bounce();
		// The implementation is based on the
		// Triangle class
		
		s2.bounce("Splat!");
		
		System.out.println("=============");
		
		System.out.println(s.area);
		System.out.println(t.area);
		System.out.println(t.base);
		System.out.println(t.height);
		
		System.out.println(s2.area);
		
		// The statement below does not compile
		// Since base is not visible with a
		// Shape reference type
		//System.out.println(s2.base);
	}

}
