package com.tekgrads;

class Employee implements Comparable<Employee>{
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
	
	@Override
	public int compareTo(Employee o) {
		return this.salary.compareTo(o.salary);
	}	
}