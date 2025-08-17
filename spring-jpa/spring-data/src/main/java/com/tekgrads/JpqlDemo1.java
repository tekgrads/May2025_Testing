package com.tekgrads;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import com.tekgrads.entities.Employee;



public class JpqlDemo1 {

	public static void main(String[] args) {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("springJpaPU");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		//Query query = entityManager.createQuery("select e from Employee e");
		//List resultList = query.getResultList();
		
		TypedQuery<Employee> query = entityManager.createQuery("select e from Employee e", Employee.class);
		List<Employee> resultList = query.getResultList();
		resultList.forEach(System.out::println);
		entityManager.close();
		entityManagerFactory.close();

	}

}
