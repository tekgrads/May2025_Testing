package com.tekgrads;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import com.tekgrads.entities.Employee;



public class JpqlDemo7 {

	public static void main(String[] args) {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("springJpaPU");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		//Query query = entityManager.createQuery("select e from Employee e");
		//List resultList = query.getResultList();
		
		TypedQuery<String> query = entityManager.createQuery("select e.name from Employee e", String.class);
		List<String> resultList = query.getResultList();
		resultList.forEach(System.out::println);
		entityManager.close();
		entityManagerFactory.close();

	}

}
