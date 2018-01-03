package com.passbyvalue_passbyreference_example;

import java.util.Random;

/**
 * Proving that primitives are passed by value and objects are two passed by value.
 * 
 * @author patriciaespada
 *
 */
public class PassByValueExample {
	
	public static void changePrimitive(int i) {
		System.out.println("inside changePrimitive: " + i);
		i = i*10;
		System.out.println("inside changePrimitive: " + i);
	}
	
	public static void changeString(String str) {
		System.out.println("inside changeString: " + str);
		str = new String("bye");
		System.out.println("inside changeString: " + str);
	}
	
	public static void changeObject(SampleObject obj) {
		System.out.println("inside changeObject: " + obj.toString());
		obj = new SampleObject();
		System.out.println("inside changeString: " + obj.toString());
	}
	
	public static void main(String[] args) {
		int i = 5;
		System.out.println(i); // prints 5
		changePrimitive(i);
		System.out.println(i); // prints 5, i is passed as a copy to the method changePrimitive and does not applied the changes done in that method
		
		System.out.println();
		
		String str = "hello";
		System.out.println(str); // prints "hello"
		changeString(str);
		System.out.println(str); // prints "hello", str is passed as a copy to the method changeString and does not applied the changes done in that method
		
		System.out.println();
		
		SampleObject sobj = new SampleObject(1);
		System.out.println(sobj.toString()); // prints "SampleObject [id=1]"
		changeObject(sobj);
		System.out.println(sobj.toString()); // prints "SampleObject [id=1]"
	}
	
	static class SampleObject {
		private int id;
		
		public SampleObject() {
			this.id = new Random().nextInt();
		}
		public SampleObject(int id) {
			this.id = id;
		}
		
		public int getId() {
			return id;
		}
		
		public void setId(int id) {
			this.id = id;
		}

		@Override
		public String toString() {
			return "SampleObject [id=" + id + "]";
		}
		
	}

}
