package com.reflection_example;

import java.util.Arrays;

public class ClassesReflection {

	public static void getClassUsingReflection() {
		// Get Class using reflection
		Class<?> concreteClass = ConcreteClass.class;
		concreteClass = new ConcreteClass(5).getClass();
		try {
			/*
			 * Below method is used most of the times in frameworks like JUnit, Spring dependency injection, Tomcat web container, 
			 * Eclipse auto completion of method names, hibernate, Struts2 etc.
			 * Because ConcreteClass is not available at compile time
			 */
			concreteClass = Class.forName("com.reflection_example.ConcreteClass");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		System.out.println(concreteClass.getCanonicalName()); // prints com.reflection_example.ConcreteClass

		//for primitive types, wrapper classes and arrays
		Class<?> booleanClass = boolean.class;
		System.out.println(booleanClass.getCanonicalName()); // prints boolean

		Class<?> cDouble = Double.TYPE;
		System.out.println(cDouble.getCanonicalName()); // prints double

		try {
			Class<?> cDoubleArray = Class.forName("[D");
			System.out.println(cDoubleArray.getCanonicalName()); //prints double[]
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

		Class<?> twoDStringArray = String[][].class;
		System.out.println(twoDStringArray.getCanonicalName()); // prints java.lang.String[][]
	}
	
	public static void getSuperclassUsingReflection() {
		try {
			Class<?> superClass = Class.forName("com.reflection_example.ConcreteClass").getSuperclass();
			System.out.println(superClass); // prints "class com.reflection_example.BaseClass"
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		System.out.println(Object.class.getSuperclass()); // prints "null"
		System.out.println(String[][].class.getSuperclass());// prints "class java.lang.Object"
	}
	
	public static void getPublicMemberClassesUsingReflection() {
		Class<?> concreteClass = ConcreteClass.class;
		concreteClass = new ConcreteClass(5).getClass();
		try {
			concreteClass = Class.forName("com.reflection_example.ConcreteClass");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		Class<?>[] classes = concreteClass.getClasses();
		//[class com.journaldev.reflection.ConcreteClass$ConcreteClassPublicClass, 
		//class com.journaldev.reflection.ConcreteClass$ConcreteClassPublicEnum, 
		//interface com.journaldev.reflection.ConcreteClass$ConcreteClassPublicInterface,
		//class com.journaldev.reflection.BaseClass$BaseClassInnerClass, 
		//class com.journaldev.reflection.BaseClass$BaseClassMemberEnum]
		System.out.println(Arrays.toString(classes));
	}
	
	public static void getDeclaredClassesUsingReflection() {
		try {
			//getting all of the classes, interfaces, and enums that are explicitly declared in ConcreteClass
			Class<?>[] explicitClasses = Class.forName("com.reflection_example.ConcreteClass").getDeclaredClasses();
			//prints [class com.journaldev.reflection.ConcreteClass$ConcreteClassDefaultClass, 
			//class com.journaldev.reflection.ConcreteClass$ConcreteClassDefaultEnum, 
			//class com.journaldev.reflection.ConcreteClass$ConcreteClassPrivateClass, 
			//class com.journaldev.reflection.ConcreteClass$ConcreteClassProtectedClass, 
			//class com.journaldev.reflection.ConcreteClass$ConcreteClassPublicClass, 
			//class com.journaldev.reflection.ConcreteClass$ConcreteClassPublicEnum, 
			//interface com.journaldev.reflection.ConcreteClass$ConcreteClassPublicInterface]
			System.out.println(Arrays.toString(explicitClasses));
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		ClassesReflection.getClassUsingReflection();
		System.out.println("*******");
		ClassesReflection.getSuperclassUsingReflection();
		System.out.println("*******");
		ClassesReflection.getPublicMemberClassesUsingReflection();
		System.out.println("*******");
		ClassesReflection.getDeclaredClassesUsingReflection();
	}
	
}
