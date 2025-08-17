package com.tekgrads;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.tekgrads.entities.Employee;

public class JpaDemo11 {

	public static void main(String[] args) {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("springJpaPU");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		Employee employee = entityManager.find(Employee.class, 1);
		Employee employee2 = entityManager.find(Employee.class, 7);
		EntityTransaction transaction = entityManager.getTransaction();
		System.out.println("************** Starting the transaction");		
		transaction.begin();	
		employee.setAge(36);			
		employee.setName("Named Changed after detaching");	
		employee2.setAge(36);			
		employee2.setName("Named Changed after detaching12");	
		
		entityManager.flush();
		transaction.commit();
		System.out.println("**************Transaction Committed");


	}

}
