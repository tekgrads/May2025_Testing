package com.tekgrads;

import java.util.Comparator;
import java.util.TreeSet;

public class Example13 {

	public static void main(String[] args) {
		TreeSet treeSet = new TreeSet();
		
		
		treeSet.add(new Employee("Ramesh", 28, 20000d, "HCL"));
		treeSet.add(new Employee("Rakesh", 30, 4000d, "Accenture"));
		treeSet.add(new Employee("Suresh", 31, 1000d, "Infosys"));
		treeSet.add(new Employee("Harish", 31, 100000d, "Cognizant"));
		treeSet.add(new Employee("Chandan", 31, 10000d, "Persistent"));
		treeSet.add(new Employee("Ravi", 31, 50000d, "Flipkart"));
		
		
		
		System.out.println(treeSet);

	}

}



