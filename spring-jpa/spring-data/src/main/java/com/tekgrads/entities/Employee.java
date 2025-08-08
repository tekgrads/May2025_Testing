package com.tekgrads.entities;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

import com.tekgrads.EmployeeType;

@Entity
@Table(name="EMPLOYEE_DATA")
public class Employee {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	//(strategy = GenerationType.AUTO)
	private int id;
	@Column(name="employee_name", unique = true)
	private String name;
	
	@Column(name="employee_age")
	int age;
	
	@Column(name="employee_ssn", nullable = false,unique = true, length = 10, updatable = false)
	String ssn;
	
	@Temporal(TemporalType.TIMESTAMP)
	private Date dob;
	
	@Column(name="EMPLOYEE_TYPE")
	@Enumerated(EnumType.STRING)
	private EmployeeType type;
	
	@Transient
	private String debugString;
	
	@OneToOne(mappedBy = "employee", fetch = FetchType.LAZY)
	AccessCard accessCard;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getSsn() {
		return ssn;
	}
	public void setSsn(String ssn) {
		this.ssn = ssn;
	}
	public Date getDob() {
		return dob;
	}
	public void setDob(Date dob) {
		this.dob = dob;
	}
	public EmployeeType getType() {
		return type;
	}
	public void setType(EmployeeType type) {
		this.type = type;
	}
	
	public String getDebugString() {
		return debugString;
	}
	public void setDebugString(String debugString) {
		this.debugString = debugString;
	}
	public AccessCard getAccessCard() {
		return accessCard;
	}
	public void setAccessCard(AccessCard accessCard) {
		this.accessCard = accessCard;
	}
	@Override
	public String toString() {
		return "Employee [id=" + id + ", name=" + name + ", age=" + age + ", ssn=" + ssn + ", dob=" + dob + ", type="
				+ type + ", debugString=" + debugString + "]";
	}
	
	
	
	

}
