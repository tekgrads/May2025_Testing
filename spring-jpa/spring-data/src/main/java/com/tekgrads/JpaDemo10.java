package com.tekgrads;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.tekgrads.entities.Employee;

public class JpaDemo10 {

	public static void main(String[] args) {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("springJpaPU");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		Employee employee = entityManager.find(Employee.class, 1);
		EntityTransaction transaction = entityManager.getTransaction();
		System.out.println("************** Starting the transaction");
		//entityManager.detach(employee);
		entityManager.clear();
		transaction.begin();	
		employee.setAge(36);			
		employee.setName("Named Changed after detaching");	
		entityManager.merge(employee);
		
		
		transaction.commit();
		System.out.println("**************Transaction Committed");


	}

}
