package com.tekgrads.entities;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="EMPLOYEE_PAYSTUB")
public class PayStub {
	
	@Id
	@GeneratedValue
	private int id;	
	private Date payStartDate;	
	private Date payEndDate;
	private float salary;
	
	@ManyToOne
	private Employee employee;
	
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Date getPayStartDate() {
		return payStartDate;
	}
	public void setPayStartDate(Date payStartDate) {
		this.payStartDate = payStartDate;
	}
	public Date getPayEndDate() {
		return payEndDate;
	}
	public void setPayEndDate(Date payEndDate) {
		this.payEndDate = payEndDate;
	}
	public float getSalary() {
		return salary;
	}
	public void setSalary(float salary) {
		this.salary = salary;
	}
	public Employee getEmployee() {
		return employee;
	}
	public void setEmployee(Employee employee) {
		this.employee = employee;
	}
	@Override
	public String toString() {
		return "PayStub [id=" + id + ", payStartDate=" + payStartDate + ", payEndDate=" + payEndDate + ", salary="
				+ salary + ", employee=" + employee + "]";
	}
	
	
	
}
