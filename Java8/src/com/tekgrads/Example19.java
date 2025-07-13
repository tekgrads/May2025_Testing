package com.tekgrads;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Example19 {

	public static void main(String[] args) {		
		List<Employee> employeeList = new ArrayList<>();
		employeeList.add(new Employee("Ramesh", 28, 10000d, "HCL"));
		employeeList.add(new Employee("Rakesh", 30, 20000d, "Accenture"));
		employeeList.add(new Employee("Suresh", 31, 30000d, "Infosys"));
		employeeList.add(new Employee("Harish", 32, 40000d, "CTS"));
		employeeList.add(new Employee("Ankit", 34, 50000d, "Persistent"));
		employeeList.add(new Employee("Likit", 37, 60000d, "JPMC"));
		
		List<String> names = employeeList.stream().filter(e->e.salary>30000)
		.map(e->e.name)
		.collect(Collectors.toList());
		
		System.out.println(names);

	}

}
