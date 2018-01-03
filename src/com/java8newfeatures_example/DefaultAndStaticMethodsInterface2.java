package com.java8newfeatures_example;

@FunctionalInterface
public interface DefaultAndStaticMethodsInterface2 {

	void method2();
	
	default void log(String str){
		System.out.println("DefaultAndStaticMethodsInterface2 logging::"+str);
	}
	
	static void print(String str){
		System.out.println("Printing I2 "+str);
	}
	
}
