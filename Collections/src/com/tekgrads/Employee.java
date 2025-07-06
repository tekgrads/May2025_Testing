package com.tekgrads;

import java.util.Objects;

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
	@Override
	public int hashCode() {
		return name.hashCode()+age.toString().hashCode()+salary.toString().hashCode()+companyName.toString().hashCode();
	}
	@Override
	public boolean equals(Object obj) {
		if(!(obj instanceof Employee)){
			return false;
		}
		return this.name.equals(((Employee)obj).name)&&
				this.age.equals(((Employee)obj).age)&&this.salary.equals(((Employee)obj).salary)
				&&this.companyName.equals(((Employee)obj).companyName);	
	}	
	
	
}