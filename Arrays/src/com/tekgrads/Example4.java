package com.tekgrads;

import java.util.Arrays;

class Employee {
	String name;
	Integer age;
	Double salary;
	String companyName;
	public Employee(String name, Integer age, Double salary, String companyName) {
		super();
		this.name = name;
		this.age = age;
		this.salary = salary;
		this.companyName = companyName;
	}
	@Override
	public String toString() {
		return "Employee [name=" + name + ", age=" + age + ", salary=" + salary + ", companyName=" + companyName + "]";
	}
	
	
	
	
	
	
}
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
