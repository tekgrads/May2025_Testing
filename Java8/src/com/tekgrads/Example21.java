package com.tekgrads;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Example21 {

	public static void main(String[] args) {
		List<Employee> employeeList = new ArrayList<>();
		employeeList.add(new Employee("Ramesh", 28, 10000d, "HCL"));
		employeeList.add(new Employee("Rakesh", 30, 20000d, "HCL"));
		employeeList.add(new Employee("Suresh", 31, 30000d, "Infosys"));
		employeeList.add(new Employee("Harish", 32, 40000d, "Infosys"));
		employeeList.add(new Employee("Ankit", 34, 50000d, "Persistent"));
		employeeList.add(new Employee("Likit", 37, 60000d, "Persistent"));
		
		Map<String, List<Employee>> group = employeeList.stream()
				.collect(Collectors.groupingBy(Employee::getCompanyName));
		System.out.println(group);
		
		List<Employee> employeeSortedList = employeeList.stream().sorted((o1,o2)->{
			if(o1.salary>o2.salary) {
				return -1;
			} else if(o1.salary<o2.salary) {
				return 1;
			} else {
				return 0;
			}
		}).collect(Collectors.toList());
		
		System.out.println(employeeSortedList);

	}

}
