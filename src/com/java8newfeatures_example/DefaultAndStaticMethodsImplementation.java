package com.java8newfeatures_example;

public class DefaultAndStaticMethodsImplementation implements DefaultAndStaticMethodsInterface1, DefaultAndStaticMethodsInterface2 {

	@Override
	public void method1(String str) {
		System.out.println("DefaultAndStaticMethodsInterface1.method1 implementation: " + str);		
	}

	@Override
	public void method2() {
		System.out.println("DefaultAndStaticMethodsInterface2.method2 implementation");
	}

	@Override
	public void log(String str) {
		System.out.println("DefaultAndStaticMethodsImplementation logging::"+str);
	}
	
	public static void main(String[] args) {
		DefaultAndStaticMethodsImplementation c = new DefaultAndStaticMethodsImplementation();
		c.method1("hello");
		c.method2();
		c.log("hello");
		DefaultAndStaticMethodsInterface1.print("hello");
		DefaultAndStaticMethodsInterface2.print("hello");
	}

}
