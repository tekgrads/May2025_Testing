package com.tekgrads;

import java.util.Date;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.tekgrads.entities.Employee;

public class JpaDemo {

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
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("springJpaPU");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		EntityTransaction transaction = entityManager.getTransaction();
		transaction.begin();
		entityManager.persist(employee1);
		entityManager.persist(employee2);
		transaction.commit();
	}

}
