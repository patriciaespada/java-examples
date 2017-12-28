package com.failfast_failsafe_example;
import java.util.Iterator;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Fail-safe iterator makes copy of the internal data structure and iterates over the copied data structure. Any structural 
 * modification done to the iterator affects the copied data structure. Two issues associated with Fail-safe iterator are: Overhead 
 * of maintaining the copied data structure in memory; Fail-safe iterator does not guarantee that the data being read is the data 
 * currently in the original data structure.
 * 
 * @author patriciaespada
 *
 */
public class FailSafeExample {

	public static void main(String[] args) {
		ConcurrentHashMap<String,String> premiumPhone = new ConcurrentHashMap<String,String>();
		premiumPhone.put("Apple", "iPhone");
		premiumPhone.put("HTC", "HTC one");
		premiumPhone.put("Samsung","S5");

		Iterator<String> iterator = premiumPhone.keySet().iterator();

		while (iterator.hasNext()) {
			System.out.println(premiumPhone.get(iterator.next()));
			premiumPhone.put("Sony", "Xperia Z");
		}
		
		System.out.println("********");
		
		for (String phone : premiumPhone.keySet()) {
			System.out.println(phone);
		}
	}

}
