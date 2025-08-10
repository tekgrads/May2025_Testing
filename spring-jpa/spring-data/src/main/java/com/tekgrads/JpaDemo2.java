package com.tekgrads;

import java.util.Date;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.tekgrads.entities.AccessCard;
import com.tekgrads.entities.Employee;
import com.tekgrads.entities.PayStub;

public class JpaDemo2 {

	public static void main(String[] args) {

		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("springJpaPU");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
//		Employee employee1 = entityManager.find(Employee.class, 1);
//		Employee employee2 = entityManager.find(Employee.class, 2);
//		System.out.println(employee1);
//		System.out.println(employee2);
//		System.out.println(employee1.getAccessCard());
//		System.out.println(employee2.getAccessCard());
		
//		EntityTransaction transaction = entityManager.getTransaction();
//		transaction.begin();
//		entityManager.remove(employee1);
//		transaction.commit();
		
//		AccessCard accessCard = entityManager.find(AccessCard.class, 3);
//		System.out.println(accessCard);
//		System.out.println("*********** Go accessCard********");
//		System.out.println(accessCard.getEmployee());
//		System.out.println("*********** Go Employee********");
		
//		Employee employee = entityManager.find(Employee.class, 1);
//		System.out.println("*********** Got Employee********");
//		System.out.println(employee);
//		System.out.println("*********** Got EmployeePaystub********");
//		System.out.println(employee.getPayStub());
//		
		PayStub payStub = entityManager.find(PayStub.class, 5);
		System.out.println("*********** Got EmployeePaystub********");
		System.out.println(payStub);
		System.out.println("*********** Got Employee********");
		System.out.println(payStub.getEmployee());
	}

}
