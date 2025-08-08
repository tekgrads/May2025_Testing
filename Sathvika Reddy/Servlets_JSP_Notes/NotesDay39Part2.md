## Why we use Spring Data JPA instead of plain Spring MVC with JDBC:

### Problems with Spring MVC + JDBC:
1. **Manual SQL Handling** – We need to write SQL queries for all CRUD operations, making development slow.
2. **Manual Mapping** – Developers must map `ResultSet` rows to Java objects manually.
3. **Error-Prone Transactions** – Managing transactions and rollbacks manually can be cumbersome and prone to errors.

---

# Java apps with DB

       +-------------------+
       | Java Application  |
       +-------------------+
                 |
                 v
          +-------------+
          |    JDBC     |
          +-------------+
                 |
                 v
          +-------------+
          |  Database   |
          +-------------+

---

# Example: Mapping Employee Class to Employee Table

Employee Class:
+--------------------------+
|       Employee           |
+--------------------------+
| - firstName              |
| - lastName               |
| - department             |
| - address                |
+--------------------------+

          |    |    |    |
          v    v    v    v

Employee Table:
+----+-------------+------------+-------------+---------+
| ID | firstName   | lastName   | department  | address |
+----+-------------+------------+-------------+---------+
| 1  | Sathvika    | Reddy      | IT          | Hyd     |
-----

### Read operation:
Desired result: Collection of Employee instances  
1. Prepare SQL query  
2. Run the query  
3. Loop through the result set  
4. Create a new instance of Employee per row  
5. Extract each column and assign to new instance  
6. Put instance in a collection  
7. Handle errors  

### Write operation:
Desired result: Employee object added / updated as a row in Employee table  
1. Get all attributes of the instance  
2. Prepare a SQL query  
3. Manage keys  
4. Run the query  
5. Manage transactions  
6. Handle errors  

---

## Java apps with Hibernate:
 
Hibernate acts as an Object-Relational Mapping (ORM) tool, automatically converting Java objects to database tables and vice versa. It eliminates most manual SQL writing, manages transactions, and provides caching for better performance. Relationships between entities are easier to manage compared to plain JDBC.

# Java apps with DB

       +-------------------+
       | Java Application  |
       +-------------------+
                 |
                 v
         +----------------+
         |   Hibernate    |
         +----------------+
                 |
                 v
          +-------------+
          |    JDBC     |
          +-------------+
                 |
                 v
          +-------------+
          |  Database   |
          +-------------+

---

# Example: Mapping Employee Class to Employee Table

Employee Class:
+--------------------------+
|       Employee           |
+--------------------------+
| - firstName              |
| - lastName               |
| - department             |
| - address                |
+--------------------------+

          |    |    |    |
          v    v    v    v

Employee Table:
+----+-------------+------------+-------------+---------+
| ID | firstName   | lastName   | department  | address |
+----+-------------+------------+-------------+---------+
| 1  | Sathvika    | Reddy      | IT          | Hyd     |
+----+-------------+------------+-------------+---------+

## Mapping:
Employee class ---> Employee Table  
- firstName   ---> FIRST_NAME  
- lastName    ---> LAST_NAME  
- department  ---> DEPARTMENT  
- address     ---> ADDRESS  

---

## Caching and performance:
Large applications:  
- You need to focus on the problem domain  
- SQL is a lower level primitive  
- Common actions you'll need to do all the time makes it cumbersome  
- But yes... SQL is sometimes faster  

---

## Tricky parts:
- Modeling relations  
- Interacting with relations  
- Implementing transactions  
- Object queries  
- JPQL - 'freeform' querying  

---

pom.xml:
```xml
<!-- https://mvnrepository.com/artifact/org.hibernate/hibernate-entitymanager -->
<dependency>
    <groupId>org.hibernate</groupId>
    <artifactId>hibernate-entitymanager</artifactId>
    <version>5.6.15.Final</version>
</dependency>
<dependency>
    <groupId>mysql</groupId>
    <artifactId>mysql-connector-java</artifactId>
    <version>8.0.33</version>
</dependency>
```

---

### Dependency hierarchy:
1. **hibernate-entitymanager** internally brings Hibernate core ORM libraries required for JPA operations.  
2. Hibernate dependencies internally depend on JDBC API for database interaction.  
3. **mysql-connector-java** is the JDBC driver that Hibernate uses to connect to MySQL.  

---

persistence.xml:
```xml
<?xml version="1.0" encoding="UTF-8"?>
<persistence xmlns="http://java.sun.com/xml/ns/persistence"
             xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
             xsi:schemaLocation="http://java.sun.com/xml/ns/persistence
                                 http://java.sun.com/xml/ns/persistence/persistence_2_0.xsd"
             version="2.0">

    <persistence-unit name="springJpaPU" transaction-type="RESOURCE_LOCAL">
        <!-- JPA Provider -->
        <provider>org.hibernate.jpa.HibernatePersistenceProvider</provider>
        
        <class>com.tekgrads.entities.Employee</class>

        <!-- Database Connection Settings -->
        <properties>
            <!-- JDBC Connection -->
            <property name="javax.persistence.jdbc.driver" value="com.mysql.cj.jdbc.Driver" />
            <property name="javax.persistence.jdbc.url" value="jdbc:mysql://localhost:3306/jpademo?" />
            <property name="javax.persistence.jdbc.user" value="root" />
            <property name="javax.persistence.jdbc.password" value="password" />

            <!-- Hibernate Properties -->
            <property name="hibernate.dialect" value="org.hibernate.dialect.MySQL8Dialect" />
            <property name="hibernate.hbm2ddl.auto" value="update" />
            <property name="hibernate.show_sql" value="true" />
            <property name="hibernate.format_sql" value="true" />
            
            <!-- JPA behavior -->
            <property name="hibernate.use_sql_comments" value="true"/>
        </properties>
    </persistence-unit>
</persistence>
```

---

Employee.java:
```java
package com.tekgrads.entities;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="EMPLOYEE_DATA")
public class Employee {

    @Id
    private int id;
    private String name;

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
}
```

---

JpaDemo.java:
```java
package com.tekgrads;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.tekgrads.entities.Employee;

public class JpaDemo {
    public static void main(String args[]){
        Employee employee = new Employee();
        employee.setId(1);
        employee.setName("first employee");
        
        EntityManagerFactory entityManagerFactory =
                Persistence.createEntityManagerFactory("springJpaPU");
        EntityManager entitymanager = entityManagerFactory.createEntityManager();
        EntityTransaction transaction = entitymanager.getTransaction();
        transaction.begin();
        entitymanager.persist(employee);
        transaction.commit();
    }
}
```

---

### Output:
```
Hibernate: 
    
    create table EMPLOYEE_DATA (
       id integer not null,
        name varchar(255),
        primary key (id)
    ) engine=InnoDB
Hibernate: 
    /* insert com.tekgrads.entities.Employee
        */ insert 
        into
            EMPLOYEE_DATA
            (name, id) 
        values
            (?, ?)
```
And then a table is created at `jpademo` database named `employee_data`.
