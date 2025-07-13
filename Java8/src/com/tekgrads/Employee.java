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
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getAge() {
		return age;
	}
	public void setAge(Integer age) {
		this.age = age;
	}
	public Double getSalary() {
		return salary;
	}
	public void setSalary(Double salary) {
		this.salary = salary;
	}
	public String getCompanyName() {
		return companyName;
	}
	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}	
	
	
}