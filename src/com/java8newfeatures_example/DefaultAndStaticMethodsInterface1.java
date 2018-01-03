package com.java8newfeatures_example;

@FunctionalInterface
public interface DefaultAndStaticMethodsInterface1 {
	
	void method1(String str);
	
	default void log(String str){
		System.out.println("DefaultAndStaticMethodsInterface1 logging::"+str);
	}
	
	static void print(String str){
		System.out.println("Printing "+str);
	}
	
}
