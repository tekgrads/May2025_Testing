package com.tekgrads;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import com.tekgrads.entities.Employee;

public class JpqlDemo11 {

	public static void main(String[] args) {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("springJpaPU");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		// Query query = entityManager.createQuery("select e from Employee e");
		// List resultList = query.getResultList();
		Integer minAge = 25;
		TypedQuery<Employee> query = entityManager.createQuery("select e from Employee e where e.age > :minAge" ,
				Employee.class);
		query.setParameter("minAge", minAge);
		List<Employee> resultList = query.getResultList();
		resultList.forEach(e -> System.out.println(e));
		entityManager.close();
		entityManagerFactory.close();

	}

}
