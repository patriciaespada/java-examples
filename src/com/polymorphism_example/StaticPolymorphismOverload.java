package com.polymorphism_example;

/**
 * Describes a language ability to process objects of various types and classes through a single, uniform interface. In Java there 
 * is two types: Compile time polymorphism (static binding) and Runtime polymorphism (dynamic binding). Method overloading is an 
 * example of static polymorphism, while method overriding is an example of dynamic polymorphism.
 * 
 * Any object that satisfies more than one IS-A relationship is polymorphic in nature. In Java every object is polymorphic in 
 * nature, as each one passes an IS-A test for itself and also for Object class.
 * 
 * In this example, there are four versions of add methods. The first method takes two parameters while the second one takes three. 
 * For the third and fourth methods there is a change of order of parameters.  The compiler looks at the method signature and decides 
 * which method to invoke for a particular method call at compile time.
 * 
 * @author patriciaespada
 *
 */
public class StaticPolymorphismOverload {

	public int add(int x, int y) {
		return x + y;
	}

	public int add(int x, int y, int z) {
		return x + y + z;
	}

	public int add(double x, int y) {
		return (int) x + y;
	}

	public int add(int x, double y) {
		return x + (int) y;
	}
	
	public static void main(String[] args) {
		StaticPolymorphismOverload demo = new StaticPolymorphismOverload();

		// Method add(int x, int y) call
	    System.out.println(demo.add(2, 3));

	    // Method add(int x, int y, int z) call
	    System.out.println(demo.add(2, 3, 4));
	    
	    // Method add(double x, int y) call
	    System.out.println(demo.add(2, 3.4));
	    
	    // Method add(int x, double y) call
	    System.out.println(demo.add(2.5, 3));
	}

}
