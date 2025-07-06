package com.tekgrads;

import java.util.Arrays;


public class Example4 {

	public static void main(String[] args) {
		Employee [] employees = {
				new Employee("Ramesh", 28, 10000d, "HCL"),
				new Employee("Rakesh", 30, 20000d, "Accenture"),
				new Employee("Suresh", 31, 30000d, "Infosys"),
		};
		
		System.out.println(Arrays.toString(employees));

	}

}
