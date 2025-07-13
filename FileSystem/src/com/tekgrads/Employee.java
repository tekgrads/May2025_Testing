package com.tekgrads;

import java.io.Serializable;

public class Employee implements Serializable{

	public Employee(String name, Integer salary, String compName) {		
		this.name = name;
		this.salary = salary;
		this.compName = compName;
	}
	private String name;
	private Integer salary;
	private transient String compName;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getSalary() {
		return salary;
	}
	public void setSalary(Integer salary) {
		this.salary = salary;
	}
	public String getCompName() {
		return compName;
	}
	public void setCompName(String compName) {
		this.compName = compName;
	}
	@Override
	public String toString() {
		return "Employee [name=" + name + ", salary=" + salary + ", compName=" + compName + "]";
	}
	
	
	
}
