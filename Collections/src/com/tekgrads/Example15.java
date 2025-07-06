package com.tekgrads;

import java.util.Comparator;
import java.util.HashSet;
import java.util.TreeSet;

public class Example15 {

	public static void main(String[] args) {
		HashSet hashSet = new HashSet();
		
		
		hashSet.add(new Employee("Ramesh", 28, 20000d, "HCL"));
		hashSet.add(new Employee("Ramesh", 28, 20000d, "HCL"));
		hashSet.add(new Employee("Rakesh", 30, 4000d, "Accenture"));
		hashSet.add(new Employee("Suresh", 31, 1000d, "Infosys"));
		hashSet.add(new Employee("Harish", 31, 100000d, "Cognizant"));
		hashSet.add(new Employee("Chandan", 31, 10000d, "Persistent"));
		hashSet.add(new Employee("Ravi", 31, 50000d, "Flipkart"));
		
		
		
		System.out.println(hashSet);

	}

}








