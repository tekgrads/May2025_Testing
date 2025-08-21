Day42
# Spring Data JPA Continuation

---

### JpaDemo7.java

This demo shows how to create entities (`Employee`, `AccessCard`, `PayStub`, `EmailGroup`) and persist them into the database using `EntityManager`. It demonstrates one-to-one, one-to-many, and many-to-many relationships.

```java
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
        employee1.setName("First Employee");
        employee1.setSsn("123");
        employee1.setAge(30);
        employee1.setDob(new Date());
        employee1.setType(EmployeeType.FULL_TIME);

        Employee employee2 = new Employee();
        employee2.setName("Second Employee");
        employee2.setSsn("1234");
        employee2.setAge(30);
        employee2.setDob(new Date());
        employee2.setType(EmployeeType.CONTRACTOR);

        AccessCard accessCard1 = new AccessCard();
        accessCard1.setFirmwareVersion("v1");
        accessCard1.setIsActive(true);
        accessCard1.setIssueDate(new Date());
        accessCard1.setEmployee(employee1);

        AccessCard accessCard2 = new AccessCard();
        accessCard2.setFirmwareVersion("v1");
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
        employee1.setPaystub(payStubs);

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

        System.out.println("************** Created Employee Instance");

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

        transaction.commit();
        System.out.println("**************Transaction Committed");
    }
}
```

---

### JpaDemo8.java

Demonstrates `remove()` and `persist()` operations. It removes an employee, modifies it, and persists again within a single transaction.

```java
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
```

---

### JpaDemo9.java

Shows how `flush()` works after a removal. The removed entity is immediately synchronized with the database before committing.

```java
package com.tekgrads;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.tekgrads.entities.Employee;

public class JpaDemo9 {
    public static void main(String[] args) {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("springJpaPU");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        Employee employee = entityManager.find(Employee.class, 1);
        EntityTransaction transaction = entityManager.getTransaction();
        System.out.println("************** Starting the transaction");
        transaction.begin();
        entityManager.remove(employee);
        System.out.println("************** Employee removed");
        System.out.println("************** Flushing it out");
        entityManager.flush();
        System.out.println("************** Flushed it out");
        transaction.commit();
        System.out.println("**************Transaction Committed");
    }
}
```

### JpaDemo10.java

Demonstrates `detach()`/`clear()` and `merge()`. The entity is detached, changes are made, then `merge()` is used to reattach and update the database.

```java
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
        entityManager.clear();
        transaction.begin();
        employee.setAge(36);
        employee.setName("Named Changed after detaching");
        entityManager.merge(employee);
        transaction.commit();
        System.out.println("**************Transaction Committed");
    }
}
```

---

### JpaDemo11.java

Shows how multiple entities can be modified and synchronized with the database using `flush()` inside a transaction.

```java
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
```

---

### JpqlDemo1.java

Executes a JPQL query to fetch all employees from the database using `TypedQuery`.

```java
package com.tekgrads;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import com.tekgrads.entities.Employee;

public class JpqlDemo1 {
    public static void main(String[] args) {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("springJpaPU");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        TypedQuery<Employee> query = entityManager.createQuery("select e from Employee e", Employee.class);
        List<Employee> resultList = query.getResultList();
        resultList.forEach(System.out::println);
        entityManager.close();
        entityManagerFactory.close();
    }
}
```

---

### JpqlDemo2.java

Fetches employees ordered by age in descending order using JPQL.

```java
package com.tekgrads;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import com.tekgrads.entities.Employee;

public class JpqlDemo2 {
    public static void main(String[] args) {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("springJpaPU");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        TypedQuery<Employee> query = entityManager.createQuery("select e from Employee e order by e.age desc", Employee.class);
        List<Employee> resultList = query.getResultList();
        resultList.forEach(System.out::println);
        entityManager.close();
        entityManagerFactory.close();
    }
}
```

---

### JpqlDemo3.java

Demonstrates a `LIKE` query in JPQL to filter employees by name pattern.

```java
package com.tekgrads;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import com.tekgrads.entities.Employee;

public class JpqlDemo3 {
    public static void main(String[] args) {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("springJpaPU");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        TypedQuery<Employee> query = entityManager.createQuery("select e from Employee e where e.name like 'Named%'", Employee.class);
        List<Employee> resultList = query.getResultList();
        resultList.forEach(System.out::println);
        entityManager.close();
        entityManagerFactory.close();
    }
}
```

### JpqlDemo4.java

Fetches employees whose age falls within a specific range using JPQL `between` clause.

```java
package com.tekgrads;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import com.tekgrads.entities.Employee;

public class JpqlDemo4 {
    public static void main(String[] args) {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("springJpaPU");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        TypedQuery<Employee> query = entityManager.createQuery(
                "select e from Employee e where e.age between 22 and 35", Employee.class);
        List<Employee> resultList = query.getResultList();
        resultList.forEach(System.out::println);
        entityManager.close();
        entityManagerFactory.close();
    }
}
```

---

### JpqlDemo5.java

Another example of filtering employees within an age range (similar to Demo4).

```java
package com.tekgrads;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import com.tekgrads.entities.Employee;

public class JpqlDemo5 {
    public static void main(String[] args) {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("springJpaPU");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        TypedQuery<Employee> query = entityManager.createQuery(
                "select e from Employee e where e.age between 22 and 35", Employee.class);
        List<Employee> resultList = query.getResultList();
        resultList.forEach(System.out::println);
        entityManager.close();
        entityManagerFactory.close();
    }
}
```

---

### JpqlDemo6.java

Shows querying employees by a related entity’s field (`accessCard.isActive = true`). Demonstrates navigation in JPQL.

```java
package com.tekgrads;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import com.tekgrads.entities.Employee;

public class JpqlDemo6 {
    public static void main(String[] args) {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("springJpaPU");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        TypedQuery<Employee> query = entityManager.createQuery(
                "select e from Employee e where e.accessCard.isActive = true", Employee.class);
        List<Employee> resultList = query.getResultList();
        resultList.forEach(System.out::println);
        entityManager.close();
        entityManagerFactory.close();
    }
}
```

---

### JpqlDemo7.java

Fetches only employee names (single field projection) instead of full entity objects.

```java
package com.tekgrads;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

public class JpqlDemo7 {
    public static void main(String[] args) {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("springJpaPU");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        TypedQuery<String> query = entityManager.createQuery("select e.name from Employee e", String.class);
        List<String> resultList = query.getResultList();
        resultList.forEach(System.out::println);
        entityManager.close();
        entityManagerFactory.close();
    }
}
```

---

### JpqlDemo8.java

Demonstrates SQL injection risk by concatenating user input directly in JPQL (bad practice). Should instead use parameters.

```java
package com.tekgrads;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import com.tekgrads.entities.Employee;

public class JpqlDemo8 {
    public static void main(String[] args) {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("springJpaPU");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        String minAge = "25;delete * from EMPLOYEE_DATA";
        TypedQuery<Employee> query = entityManager.createQuery(
                "select e from Employee e where e.age > " + minAge, Employee.class);
        List<Employee> resultList = query.getResultList();
        resultList.forEach(e -> System.out.println(e));
        entityManager.close();
        entityManagerFactory.close();
    }
}
```

---

### JpqlDemo9.java

Fetches only employee ages (integer field projection).

```java
package com.tekgrads;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import com.tekgrads.entities.Employee;

public class JpqlDemo9 {
    public static void main(String[] args) {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("springJpaPU");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        TypedQuery<Integer> query = entityManager.createQuery("select e.age from Employee e", Integer.class);
        List<Integer> resultList = query.getResultList();
        resultList.forEach(System.out::println);
        entityManager.close();
        entityManagerFactory.close();
    }
}
```

---

### JpqlDemo10.java

Another projection example fetching employee ages. Similar to Demo9.

```java
package com.tekgrads;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import com.tekgrads.entities.Employee;

public class JpqlDemo10 {
    public static void main(String[] args) {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("springJpaPU");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        TypedQuery<Integer> query = entityManager.createQuery("select e.age from Employee e", Integer.class);
        List<Integer> resultList = query.getResultList();
        resultList.forEach(System.out::println);
        entityManager.close();
        entityManagerFactory.close();
    }
}
```

---

### JpqlDemo11.java

Uses a named parameter (`:minAge`) to safely query employees above a certain age.

```java
package com.tekgrads;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import com.tekgrads.entities.Employee;

public class JpqlDemo11 {
    public static void main(String[] args) {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("springJpaPU");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        Integer minAge = 25;
        TypedQuery<Employee> query = entityManager.createQuery(
                "select e from Employee e where e.age > :minAge", Employee.class);
        query.setParameter("minAge", minAge);
        List<Employee> resultList = query.getResultList();
        resultList.forEach(e -> System.out.println(e));
        entityManager.close();
        entityManagerFactory.close();
    }
}
```

---

### JpqlDemo12.java

Shows how to use a **named query** (`@NamedQuery`) defined in the entity for fetching employees.

```java
package com.tekgrads;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import com.tekgrads.entities.Employee;

public class JpqlDemo12 {
    public static void main(String[] args) {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("springJpaPU");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        Integer minAge = 25;
        TypedQuery<Employee> query = entityManager.createNamedQuery("emp by age name desc", Employee.class);
        query.setParameter("minAge", minAge);
        List<Employee> resultList = query.getResultList();
        resultList.forEach(e -> System.out.println(e));
        entityManager.close();
        entityManagerFactory.close();
    }
}
```

---

### JpqlDemo13.java

Another example with a named parameter query (`:minAge`) showing reusable JPQL queries.

```java
package com.tekgrads;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import com.tekgrads.entities.Employee;

public class JpqlDemo13 {
    public static void main(String[] args) {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("springJpaPU");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        Integer minAge = 25;
        TypedQuery<Employee> query = entityManager.createQuery(
                "select e from Employee e where e.age > :minAge", Employee.class);
        query.setParameter("minAge", minAge);
        List<Employee> resultList = query.getResultList();
        resultList.forEach(e -> System.out.println(e));
        entityManager.close();
        entityManagerFactory.close();
    }
}
```

---


