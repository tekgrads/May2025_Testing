
## JpaDemo7.java -- Relationships and Persistence

-   Creates entities: `Employee`, `AccessCard`, `PayStub`, `EmailGroup`.
-   Demonstrates relationships:
    -   **One-to-One** → `Employee` ↔ `AccessCard`
    -   **One-to-Many** → `Employee` ↔ `PayStub`
    -   **Many-to-Many** → `Employee` ↔ `EmailGroup`
-   Uses `EntityManager.persist()` to save employee with related
    entities.
-   Demonstrates **finding an entity** by `id`.

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

------------------------------------------------------------------------

## JpaDemo8.java -- Remove and Persist

-   Fetches an employee from DB.
-   Removes it with `entityManager.remove()`.
-   Modifies the entity and persists it again within the same
    transaction.
-   Shows that entities can be deleted and re-persisted.

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
------------------------------------------------------------------------

## JpaDemo9.java -- Remove with Flush

-   Removes an employee.
-   Calls `entityManager.flush()` to immediately synchronize the
    deletion with the DB.
-   Flush ensures DB changes happen before committing.

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

------------------------------------------------------------------------

## JpaDemo10.java -- Detach, Clear, and Merge

-   Demonstrates detaching entities using `clear()`.
-   Entity changes made after detachment are **not tracked**
    automatically.
-   `entityManager.merge()` is used to reattach the modified entity and
    update the DB.

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

------------------------------------------------------------------------

## JpaDemo11.java -- Multiple Entities with Flush

-   Loads two employees.
-   Updates their properties inside a transaction.
-   Calls `flush()` to synchronize both updates with the DB before
    commit.

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
------------------------------------------------------------------------

## JpqlDemo1.java -- Basic JPQL Select

-   Runs JPQL query: `select e from Employee e`
-   Fetches **all employees** and prints them.

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

------------------------------------------------------------------------

## JpqlDemo2.java -- Order By

-   Fetches employees ordered by `age desc`.

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

------------------------------------------------------------------------

## JpqlDemo3.java -- Like Query

-   Uses JPQL `like` to find employees whose name starts with "Named".

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

------------------------------------------------------------------------

## JpqlDemo4 & JpqlDemo5 -- Between Clause

-   Fetches employees whose age is between 22 and 35.
-   Both demos show the same logic.

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

------------------------------------------------------------------------

## JpqlDemo6.java -- Query by Related Entity

-   Navigates through relationships in JPQL.
-   Fetches employees whose `AccessCard.isActive = true`.

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

------------------------------------------------------------------------

## JpqlDemo7.java -- Single Field Projection

-   Fetches only **employee names** instead of full `Employee` entities.

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

------------------------------------------------------------------------

## JpqlDemo8.java -- SQL Injection Risk

-   Concatenates user input directly in query → **bad practice**.
-   Example: `25; delete * from EMPLOYEE_DATA`.
-   Should use parameters to prevent injection.

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

------------------------------------------------------------------------

## JpqlDemo9 & JpqlDemo10 -- Integer Projection

-   Fetch only employee ages using JPQL.

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
------------------------------------------------------------------------

## JpqlDemo11.java -- Named Parameter

-   Uses `:minAge` parameter to fetch employees above a given age
    safely.
-   Prevents SQL injection.

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

------------------------------------------------------------------------

## JpqlDemo12.java -- Named Query

-   Uses a query defined in `@NamedQuery` annotation inside the entity.
-   Example: `"emp by age name desc"`.

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

------------------------------------------------------------------------

## JpqlDemo13.java -- Reusable Parameterized Query

-   Similar to Demo11 but highlights reusability of queries with
    parameters.

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

------------------------------------------------------------------------
