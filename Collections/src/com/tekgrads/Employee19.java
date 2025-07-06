package com.tekgrads;

import java.util.HashMap;
import java.util.Map.Entry;

public class Employee19 {

	public static void main(String[] args) {
		HashMap<Integer, String> map = new HashMap();
		map.put(1, "Raju");
		map.put(6, "Rajesh");
		map.put(3, "Rakesh");
		map.put(2, "Ramesh");
		map.put(4, "Suresh");
		
		System.out.println(map);
		
		 for (Entry<Integer, String> entry : map.entrySet()) {
	            System.out.println("Key = " + entry.getKey() + ", Value = " + entry.getValue());
	        }

	}

}
