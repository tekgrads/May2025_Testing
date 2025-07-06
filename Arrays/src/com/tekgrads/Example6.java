package com.tekgrads;

import java.util.Arrays;

public class Example6 {

	public static void main(String[] args) {
		Employee [] employees = {
				new Employee("Ramesh", 28, 20000d, "HCL"),
				new Employee("Rakesh", 30, 4000d, "Accenture"),
				new Employee("Suresh", 31, 1000d, "Infosys"),
				new Employee("Harish", 31, 100000d, "Cognizant"),
				new Employee("Chandan", 31, 10000d, "Persistent"),
				new Employee("Ravi", 31, 50000d, "Flipkart"),
		};
		
		System.out.println(Arrays.toString(employees));
		
		Arrays.sort(employees);
		
		System.out.println(Arrays.toString(employees));

	}

}
