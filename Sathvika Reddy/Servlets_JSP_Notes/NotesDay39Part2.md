\# Spring Data-JPA: 



\## Why we use Spring Data JPA instead of plain Spring MVC with JDBC:



\### Problems with Spring MVC + JDBC:

1\. \*\*Manual SQL Handling\*\* – We need to write SQL queries for all CRUD operations, making development slow.

2\. \*\*Manual Mapping\*\* – Developers must map `ResultSet` rows to Java objects manually.

3\. \*\*Error-Prone Transactions\*\* – Managing transactions and rollbacks manually can be cumbersome and prone to errors.



---



\## Java apps with DB:



&nbsp;      +-------------------+

&nbsp;      | Java Application  |

&nbsp;      +-------------------+

&nbsp;                |

&nbsp;                v

&nbsp;         +-------------+

&nbsp;         |    JDBC     |

&nbsp;         +-------------+

&nbsp;                |

&nbsp;                v

&nbsp;         +-------------+

&nbsp;         |  Database   |

&nbsp;         +-------------+



---



\## Example: Mapping Employee Class to Employee Table



Employee Class:

+--------------------------+

|       Employee           |

+--------------------------+

| - firstName              |

| - lastName               |

| - department             |

| - address                |

+--------------------------+



&nbsp;         |    |    |    |

&nbsp;         v    v    v    v



Employee Table:

+----+-------------+------------+-------------+---------+

| ID | firstName   | lastName   | department  | address |

+----+-------------+------------+-------------+---------+

| 1  | Sathvika    | Reddy      | IT| Hyd|

-----



\### Read operation

Desired result: Collection of Employee instances  

1\. Prepare SQL query  

2\. Run the query  

3\. Loop through the result set  

4\. Create a new instance of Employee per row  

5\. Extract each column and assign to new instance  

6\. Put instance in a collection  

7\. Handle errors  



\### Write operation

Desired result: Employee object added / updated as a row in Employee table  

1\. Get all attributes of the instance  

2\. Prepare a SQL query  

3\. Manage keys  

4\. Run the query  

5\. Manage transactions  

6\. Handle errors  



---



\## Java apps with Hibernate:

&nbsp;

Hibernate acts as an Object-Relational Mapping (ORM) tool, automatically converting Java objects to database tables and vice versa. It eliminates most manual SQL writing, manages transactions, and provides caching for better performance. Relationships between entities are easier to manage compared to plain JDBC.



\## Java apps with DB:



&nbsp;      +-------------------+

&nbsp;      | Java Application  |

&nbsp;      +-------------------+

&nbsp;                |

&nbsp;                v

&nbsp;        +----------------+

&nbsp;        |   Hibernate    |

&nbsp;        +----------------+

&nbsp;                |

&nbsp;                v

&nbsp;         +-------------+

&nbsp;         |    JDBC     |

&nbsp;         +-------------+

&nbsp;                |

&nbsp;                v

&nbsp;         +-------------+

&nbsp;         |  Database   |

&nbsp;         +-------------+



---



\## Example: Mapping Employee Class to Employee Table:



Employee Class:

+--------------------------+

|       Employee           |

+--------------------------+

| - firstName              |

| - lastName               |

| - department             |

| - address                |

+--------------------------+



&nbsp;         |    |    |    |

&nbsp;         v    v    v    v



Employee Table:

+----+-------------+------------+-------------+---------+

| ID | firstName   | lastName   | department  | address |

+----+-------------+------------+-------------+---------+

| 1  | Sathvika    | Reddy      | IT| Hyd|

+----+-------------+------------+-------------+---------+



\## Mapping:

Employee class ---> Employee Table  

\- firstName   ---> FIRST\_NAME  

\- lastName    ---> LAST\_NAME  

\- department  ---> DEPARTMENT  

\- address     ---> ADDRESS  



---



\## Caching and performance:

Large applications:  

* You need to focus on the problem domain  
* SQL is a lower level primitive  
* Common actions you'll need to do all the time makes it cumbersome  
* But yes... SQL is sometimes faster  

&nbsp;Tricky parts:

* Modeling relations  
* Interacting with relations  
* Implementing transactions  
* Object queries  
* JPQL - 'freeform' querying  



---



pom.xml:

```xml

<!-- https://mvnrepository.com/artifact/org.hibernate/hibernate-entitymanager -->

<dependency>

&nbsp;   <groupId>org.hibernate</groupId>

&nbsp;   <artifactId>hibernate-entitymanager</artifactId>

&nbsp;   <version>5.6.15.Final</version>

</dependency>

<dependency>

&nbsp;   <groupId>mysql</groupId>

&nbsp;   <artifactId>mysql-connector-java</artifactId>

&nbsp;   <version>8.0.33</version>

</dependency>

````



---



\### Dependency hierarchy:



1\. \*\*hibernate-entitymanager\*\* internally brings Hibernate core ORM libraries required for JPA operations.

2\. Hibernate dependencies internally depend on JDBC API for database interaction.

3\. \*\*mysql-connector-java\*\* is the JDBC driver that Hibernate uses to connect to MySQL.



---



persistence.xml:



```xml

<?xml version="1.0" encoding="UTF-8"?>

<persistence xmlns="http://java.sun.com/xml/ns/persistence"

&nbsp;            xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"

&nbsp;            xsi:schemaLocation="http://java.sun.com/xml/ns/persistence

&nbsp;                                http://java.sun.com/xml/ns/persistence/persistence\_2\_0.xsd"

&nbsp;            version="2.0">



&nbsp;   <persistence-unit name="springJpaPU" transaction-type="RESOURCE\_LOCAL">

&nbsp;       <!-- JPA Provider -->

&nbsp;       <provider>org.hibernate.jpa.HibernatePersistenceProvider</provider>

&nbsp;       

&nbsp;       <class>com.tekgrads.entities.Employee</class>



&nbsp;       <!-- Database Connection Settings -->

&nbsp;       <properties>

&nbsp;           <!-- JDBC Connection -->

&nbsp;           <property name="javax.persistence.jdbc.driver" value="com.mysql.cj.jdbc.Driver" />

&nbsp;           <property name="javax.persistence.jdbc.url" value="jdbc:mysql://localhost:3306/jpademo?" />

&nbsp;           <property name="javax.persistence.jdbc.user" value="root" />

&nbsp;           <property name="javax.persistence.jdbc.password" value="password" />



&nbsp;           <!-- Hibernate Properties -->

&nbsp;           <property name="hibernate.dialect" value="org.hibernate.dialect.MySQL8Dialect" />

&nbsp;           <property name="hibernate.hbm2ddl.auto" value="update" />

&nbsp;           <property name="hibernate.show\_sql" value="true" />

&nbsp;           <property name="hibernate.format\_sql" value="true" />

&nbsp;           

&nbsp;           <!-- JPA behavior -->

&nbsp;           <property name="hibernate.use\_sql\_comments" value="true"/>

&nbsp;       </properties>

&nbsp;   </persistence-unit>

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

@Table(name="EMPLOYEE\_DATA")

public class Employee {



&nbsp;   @Id

&nbsp;   private int id;

&nbsp;   private String name;



&nbsp;   public int getId() {

&nbsp;       return id;

&nbsp;   }

&nbsp;   public void setId(int id) {

&nbsp;       this.id = id;

&nbsp;   }

&nbsp;   public String getName() {

&nbsp;       return name;

&nbsp;   }

&nbsp;   public void setName(String name) {

&nbsp;       this.name = name;

&nbsp;   }

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

&nbsp;   public static void main(String args\[]){

&nbsp;       Employee employee = new Employee();

&nbsp;       employee.setId(1);

&nbsp;       employee.setName("first employee");

&nbsp;       

&nbsp;       EntityManagerFactory entityManagerFactory =

&nbsp;               Persistence.createEntityManagerFactory("springJpaPU");

&nbsp;       EntityManager entitymanager = entityManagerFactory.createEntityManager();

&nbsp;       EntityTransaction transaction = entitymanager.getTransaction();

&nbsp;       transaction.begin();

&nbsp;       entitymanager.persist(employee);

&nbsp;       transaction.commit();

&nbsp;   }

}

```



---



\### Output:



```

Hibernate: 

&nbsp;   

&nbsp;   create table EMPLOYEE\_DATA (

&nbsp;      id integer not null,

&nbsp;       name varchar(255),

&nbsp;       primary key (id)

&nbsp;   ) engine=InnoDB

Hibernate: 

&nbsp;   /\* insert com.tekgrads.entities.Employee

&nbsp;       \*/ insert 

&nbsp;       into

&nbsp;           EMPLOYEE\_DATA

&nbsp;           (name, id) 

&nbsp;       values

&nbsp;           (?, ?)

```



And then a table is created at `jpademo` database named `employee\_data`.







