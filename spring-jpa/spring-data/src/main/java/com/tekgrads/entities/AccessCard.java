package com.tekgrads.entities;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="ACCESS_CARD")
public class AccessCard {
	
	@Id
	@GeneratedValue
	private int id;
	
	@Column(name="ISSUE_DATE")
	private Date issueDate;
	
	@Column(name="IS_ACTIVE")
	private Boolean isActive;
	
	@Column(name="FIRMWARE_VERSION")
	private String firmWareVersion;
	
	@OneToOne(fetch = FetchType.LAZY)	
	private Employee employee;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Date getIssueDate() {
		return issueDate;
	}

	public void setIssueDate(Date issueDate) {
		this.issueDate = issueDate;
	}

	public Boolean getIsActive() {
		return isActive;
	}

	public void setIsActive(Boolean isActive) {
		this.isActive = isActive;
	}

	public String getFirmWareVersion() {
		return firmWareVersion;
	}

	public void setFirmWareVersion(String firmWareVersion) {
		this.firmWareVersion = firmWareVersion;
	}

	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

	@Override
	public String toString() {
		return "AccessCard [id=" + id + ", issueDate=" + issueDate + ", isActive=" + isActive + ", firmWareVersion="
				+ firmWareVersion + ", employee=" + employee + "]";
	}

	
	 
	

}
