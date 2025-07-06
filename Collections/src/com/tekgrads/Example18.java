package com.tekgrads;

import java.util.HashMap;

public class Example18 {

	public static void main(String[] args) {
		HashMap map = new HashMap();
		
		map.put(6, new Employee("Ravi", 31, 50000d, "Flipkart"));

		map.put(1, new Employee("Ramesh", 28, 20000d, "HCL"));
		map.put(2, new Employee("Rakesh", 30, 4000d, "Accenture"));
		map.put(3, new Employee("Suresh", 31, 1000d, "Infosys"));
		map.put(4, new Employee("Harish", 31, 100000d, "Cognizant"));
		map.put(5, new Employee("Chandan", 31, 10000d, "Persistent"));
				
		System.out.println(map);
				
		

	}

}
