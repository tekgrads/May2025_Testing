package com.tekgrads;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.tekgrads.entities.Employee;

public class JpaDemo8 {

	public static void main(String[] args) {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("springJpaPU");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		Employee employee = entityManager.find(Employee.class, 1);
		EntityTransaction transaction = entityManager.getTransaction();
		System.out.println("************** Starting the transaction");
		transaction.begin();	
		entityManager.remove(employee);
		System.out.println("************** Employee removed");
		employee.setAge(35);
		entityManager.persist(employee);
		System.out.println("************** Employee persisted");
	
		transaction.commit();
		System.out.println("**************Transaction Committed");


	}

}
