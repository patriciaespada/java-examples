package com.failfast_failsafe_example;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * Fail-fast iterator while iterating over a collection instantly throws concurrent modification exception if there is structural 
 * modification in the collection. So in that scenario the iterator fails quickly and cleanly rather than risking arbitrary, 
 * non-deterministic behavior. To check if the collection has been modified the iterator checks the mods flag whenever gets the 
 * next value. The value of mods flag is changed whenever there is a structural modification.
 * 
 * @author patriciaespada
 *
 */
public class FailFastExample {

	public static void main(String[] args) {
        Map<String,String> premiumPhone = new HashMap<String,String>();
        premiumPhone.put("Apple", "iPhone");
        premiumPhone.put("HTC", "HTC one");
        premiumPhone.put("Samsung","S5");
        
        Iterator<String> iterator = premiumPhone.keySet().iterator();
        
        while (iterator.hasNext()) {
            System.out.println(premiumPhone.get(iterator.next()));
            premiumPhone.put("Sony", "Xperia Z");
        }
	}
	
}
