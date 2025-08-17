package com.tekgrads;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.tekgrads.entities.AccessCard;
import com.tekgrads.entities.EmailGroup;
import com.tekgrads.entities.Employee;
import com.tekgrads.entities.PayStub;

public class JpaDemo7 {

	public static void main(String[] args) {
		Employee employee1 = new Employee();
		//employee1.setId(1);
		employee1.setName("First Employee");
		employee1.setSsn("123");
		employee1.setAge(30);
		employee1.setDob(new Date());
		employee1.setType(EmployeeType.FULL_TIME);
		Employee employee2 = new Employee();
		//employee2.setId(2);
		employee2.setName("Second Employee");
		employee2.setSsn("1234");
		employee2.setAge(30);
		employee2.setDob(new Date());
		employee2.setType(EmployeeType.CONTRACTOR);
		
		AccessCard accessCard1 = new AccessCard();
		accessCard1.setFirmWareVersion("v1");
		accessCard1.setIsActive(true);
		accessCard1.setIssueDate(new Date());
		accessCard1.setEmployee(employee1);
		
		
		AccessCard accessCard2 = new AccessCard();
		accessCard2.setFirmWareVersion("v1");
		accessCard2.setIsActive(true);
		accessCard2.setIssueDate(new Date());
		accessCard2.setEmployee(employee2);
		
		employee1.setAccessCard(accessCard1);
		employee2.setAccessCard(accessCard2);
		
		PayStub payStub1 = new PayStub();
		payStub1.setPayStartDate(new Date());
		payStub1.setPayEndDate(new Date());
		payStub1.setSalary(10000);
		payStub1.setEmployee(employee1);
		PayStub payStub2 = new PayStub();
		payStub2.setPayStartDate(new Date());
		payStub2.setPayEndDate(new Date());
		payStub2.setSalary(10000);
		payStub2.setEmployee(employee1);
		
		List<PayStub> payStubs = new ArrayList<>();
		payStubs.add(payStub1);
		payStubs.add(payStub2);
		employee1.setPayStub(payStubs);
		
		EmailGroup emailGroup = new EmailGroup();
		emailGroup.setName("Team1");
		
		EmailGroup emailGroup2 = new EmailGroup();
		emailGroup2.setName("HYD Employees");
		
		List<Employee> employees = new ArrayList<Employee>();		
		employees.add(employee1);
		employees.add(employee2);
		emailGroup.setEmployees(employees);
		emailGroup2.setEmployees(employees);
		
		List<EmailGroup> emailGroups = new ArrayList<EmailGroup>();
		emailGroups.add(emailGroup);
		emailGroups.add(emailGroup2);
		employee1.setEmailGroups(emailGroups);
		employee2.setEmailGroups(emailGroups);
		System.out.println("************** Created Enployee Instance");
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("springJpaPU");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		EntityTransaction transaction = entityManager.getTransaction();
		transaction.begin();
		System.out.println("************** Starting the transaction");
		entityManager.persist(employee1);		
		System.out.println("************** Employee persisted");
		Employee employeeFound = entityManager.find(Employee.class, 1);
		System.out.println("************** Employee found");
		System.out.println(employeeFound == employee1);
		//Employee 
		transaction.commit();
		System.out.println("**************Transaction Committed");

	}

}
