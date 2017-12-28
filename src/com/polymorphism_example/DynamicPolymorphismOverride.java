package com.polymorphism_example;

/**
 * Describes a language ability to process objects of various types and classes through a single, uniform interface. In Java there 
 * is two types: Compile time polymorphism (static binding) and Runtime polymorphism (dynamic binding). Method overloading is an 
 * example of static polymorphism, while method overriding is an example of dynamic polymorphism.
 * 
 * Any object that satisfies more than one IS-A relationship is polymorphic in nature. In Java every object is polymorphic in 
 * nature, as each one passes an IS-A test for itself and also for Object class.
 * 
 * It should be noted that in the first call to move(), the reference type is Vehicle and the object being referenced is MotorBike. 
 * So, when a call to move() is made, Java waits until runtime to determine which object is actually being pointed to by the reference.
 * In this case, the object is of the class MotorBike. So, the move() method of MotorBike class will be called. In the second call to 
 * move(), the object is of the class Vehicle. So, the move() method of Vehicle will be called.
 * 
 * As the method to call is determined at runtime, this is called dynamic binding or late binding.
 * 
 * @author patriciaespada
 *
 */
public class DynamicPolymorphismOverride {
	static class Vehicle {

		public void move() {
			System.out.println("Vehicles can move!!");
		}

	}

	static class MotorBike extends Vehicle {

		@Override
		public void move() {
			System.out.println("MotorBike can move and accelerate too!!");
		}
		
	}
	
	public static void main(String[] args) {
	    Vehicle vehicle = new MotorBike();
	    vehicle.move();

	    vehicle = new Vehicle();
	    vehicle.move();
	}

}
