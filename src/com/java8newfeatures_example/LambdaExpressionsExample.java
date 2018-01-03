package com.java8newfeatures_example;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.IntStream;

public class LambdaExpressionsExample {
	
	// Traditional approach
	private static boolean isPrime(int number) {		
		if(number < 2) {
			return false;
		}
		for (int i=2; i<number; i++) {
			if (number % i == 0) {
				return false;
			}
		}
		return true;
	}
	
	// Declarative approach
	private static boolean isPrimeWithLambda(int number) {		
		return number > 1
				&& IntStream.range(2, number).noneMatch(index -> number % index == 0);
	}
	
	public static int sumWithCondition(List<Integer> numbers, Predicate<Integer> predicate) {
	    return numbers.parallelStream()
	    		.filter(predicate)
	    		.mapToInt(i -> i)
	    		.sum();
	}
	
	private static int findSquareOfMaxOdd(List<Integer> numbers) {
		int max = 0;
		for (int i : numbers) {
			if (i % 2 != 0 && i > 3 && i < 11 && i > max) {
				max = i;
			}
		}
		return max * max;
	}
	
	public static int findSquareOfMaxOddWithLambda(List<Integer> numbers) {
		return numbers.stream()
				.filter(LambdaExpressionsExample::isOdd) 		//Predicate is functional interface and
				.filter(LambdaExpressionsExample::isGreaterThan3)	// we are using lambdas to initialize it
				.filter(LambdaExpressionsExample::isLessThan11)	// rather than anonymous inner classes
				.max(Comparator.naturalOrder())
				.map(i -> i * i)
				.get();
	}

	public static boolean isOdd(int i) {
		return i % 2 != 0;
	}
	
	public static boolean isGreaterThan3(int i){
		return i > 3;
	}
	
	public static boolean isLessThan11(int i){
		return i < 11;
	}

	public static void main(String[] args) {
		// Since functional interfaces have only one method, lambda expressions can easily provide the method implementation
		Runnable r1 = new Runnable() {
			@Override
			public void run() {
				System.out.println("My Runnable");
			}
		};
		
		Runnable r2 = () -> { System.out.println("My Runnable with lambda expression"); };
		
		r1.run();
		r2.run();
		
		// DefaultAndStaticMethodsInterface1 anonymous class can be instantiated
		DefaultAndStaticMethodsInterface1 i1 = (s) -> System.out.println(s);
		i1.method1("Hello world!");
		
		// Sequential and Parallel Execution Support
		System.out.println(isPrime(7));
		System.out.println(isPrimeWithLambda(7));
		
		// Passing Behaviors into methods
		List<Integer> numbers = Arrays.asList(1,2,3,4,5,6,7);
		System.out.println(sumWithCondition(numbers, n -> true)); //sum of all numbers
		System.out.println(sumWithCondition(numbers, i -> i%2==0)); //sum of all even numbers
		System.out.println(sumWithCondition(numbers, i -> i>5)); //sum of all numbers greater than 5
		
		
		// Higher Efficiency with Laziness
		List<Integer> square = Arrays.asList(1,2,3,4,5,6,7);
		System.out.println(findSquareOfMaxOdd(square));
		System.out.println(findSquareOfMaxOddWithLambda(square));

	}
}
