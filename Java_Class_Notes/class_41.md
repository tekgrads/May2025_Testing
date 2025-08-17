
# JPA Relationships

## 1. One-to-One (`@OneToOne`)

**Definition:**  
One entity is associated with exactly **one other entity**.

**Example:**  
- An `Employee` has exactly **one** `AccessCard`.  
- One `AccessCard` belongs to exactly **one** `Employee`.

```java
@Entity
public class Employee {
    @Id
    @GeneratedValue
    private int id;
    private String name;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "ACCESS_CARD_ID")
    private AccessCard accessCard;
}
```

```java
@Entity
public class AccessCard {
    @Id
    @GeneratedValue
    private int id;
    private String firmwareVersion;

    @OneToOne(mappedBy = "accessCard")
    private Employee employee;
}
```


## 2. One-to-Many (`@OneToMany` and `@ManyToOne`)

**Definition:**  
One entity can be associated with **multiple entities**.  
But each of those entities belongs to **only one parent**.

**Example:**  
- One `Employee` can have **many** `PayStub` records.  
- But each `PayStub` belongs to **only one** `Employee`.

```java
@Entity
public class Employee {
    @Id
    @GeneratedValue
    private int id;
    private String name;

    @OneToMany(mappedBy = "employee", cascade = CascadeType.ALL)
    private List<PayStub> paystubs;
}
```

```java
@Entity
public class PayStub {
    @Id
    @GeneratedValue
    private int id;
    private float salary;

    @ManyToOne
    private Employee employee;
}
```
## PayStub.java:
```java
package com.tekgrads.entities;

import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.GeneratedValue;

@Entity
@Table(name="EMPLOYEE_PAYSTUB")
public class PayStub {

	@Id
	@GeneratedValue
	private int Id;
	private Date payStartDate;
	private Date payEndDate;
	public Employee getEmployee() {
		return employee;
	}
	public void setEmployee(Employee employee) {
		this.employee = employee;
	}
	private float salary;
	
	@ManyToOne
	private Employee employee;
	
	public int getId() {
		return Id;
	}
	public void setId(int id) {
		Id = id;
	}
	public Date getPayStartDate() {
		return payStartDate;
	}
	public void setPayStartDate(Date payStartDate) {
		this.payStartDate = payStartDate;
	}
	public Date getPayEndDate() {
		return payEndDate;
	}
	public void setPayEndDate(Date payEndDate) {
		this.payEndDate = payEndDate;
	}
	public float getSalary() {
		return salary;
	}
	public void setSalary(float salary) {
		this.salary = salary;
	}
}

## JpaDemo4.java:
package com.tekgrads;

import java.util.Date;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import com.tekgrads.entities.AccessCard;
import com.tekgrads.entities.Employee;
import com.tekgrads.entities.PayStub;

public class JpaDemo4 {
public static void main(String args[]){
	Employee employee1=new Employee();
	employee1.setName("first employee");
	employee1.setAge(22);
	employee1.setSsn("123");
	employee1.setDob(new Date());
	employee1.setType(EmployeeType.FULL_TIME);
	
	Employee employee2=new Employee();
	employee2.setName("second employee");
	employee2.setAge(22);
	employee2.setSsn("1234");
	employee2.setDob(new Date());
	employee2.setType(EmployeeType.CONTRACTOR);
	
	AccessCard accessCard1=new AccessCard();
	accessCard1.setFirmwareVersion("v1");
	accessCard1.setIsActive(true);
	accessCard1.setIssueDate(new Date());
	accessCard1.setEmployee(employee1);
	
	AccessCard accessCard2=new AccessCard();
	accessCard2.setFirmwareVersion("v1");
	accessCard2.setIsActive(true);
	accessCard2.setIssueDate(new Date());
	accessCard1.setEmployee(employee2);
	
	employee1.setAccessCard(accessCard1);
	employee1.setAccessCard(accessCard2);
	
	PayStub paystub1=new PayStub();
	paystub1.setPayEndDate(new Date());
	paystub1.setPayStartDate(new Date());
	paystub1.setSalary(100000);
	paystub1.setEmployee(employee1);
	
	PayStub paystub2=new PayStub();
	paystub2.setPayEndDate(new Date());
	paystub2.setPayStartDate(new Date());
	paystub2.setSalary(100000);
	paystub2.setEmployee(employee1);
	
	EntityManagerFactory entityManagerFactory =Persistence.createEntityManagerFactory("springJpaPU");
	EntityManager entitymanager= entityManagerFactory.createEntityManager();
	EntityTransaction transaction=entitymanager.getTransaction();
	transaction.begin();
	entitymanager.persist(employee1);
	entitymanager.persist(employee2);
	entitymanager.persist(accessCard1);
	entitymanager.persist(accessCard2);
	entitymanager.persist(paystub1);
	entitymanager.persist(paystub1);
	transaction.commit();
}
}

## 3. Many-to-Many (`@ManyToMany`)

**Definition:**  
Many entities can be associated with **many entities**.  
This requires a **join table**.

**Example:**  
- Many `Employee`s can join many `EmailGroup`s.  
- Each `EmailGroup` can have many `Employee`s.

```java
@Entity
public class Employee {
    @Id
    @GeneratedValue
    private int id;
    private String name;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(
        name = "EMAIL_GROUP_SUBSCRIPTIONS",
        joinColumns = @JoinColumn(name = "EMPLOYEE_ID"),
        inverseJoinColumns = @JoinColumn(name = "EMAIL_GROUP_ID")
    )
    private List<EmailGroup> emailGroups;
}
```

```java
@Entity
public class EmailGroup {
    @Id
    @GeneratedValue
    private int id;
    private String name;

    @ManyToMany(mappedBy = "emailGroups")
    private List<Employee> employees;
}
```
## EmailGroup.java:
```java
package com.tekgrads.entities;

import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="EMPLOYEE_EMAIL_GROUP")
public class EmailGroup {

	@Id
	@GeneratedValue
	private int id;
	
	private String name;
	
	@ManyToOne
	private List<Employee> employees;

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

	public List<Employee> getEmployees() {
		return employees;
	}

	public void setEmployees(List<Employee> employees) {
		this.employees = employees;
	}
}

## Employee.java (Many-to-Many side):
@ManyToMany(cascade=CascadeType.PERSIST)
@JoinTable(name="EMAIL_GROUP_SUBSCRIPTIONS",
	joinColumns = @JoinColumn(name="EMPLOYEE_ID"),
	inverseJoinColumns = @JoinColumn(name="EMAIL_GROUP_ID")
)
List<EmailGroup> emailGroups;

## 4. Deleting Entities

**Definition:**  
When we delete a parent entity, the child entities can also be deleted **if cascade is enabled**.  
If cascade is not set, you must remove the child entities manually.

**Example:**

```java
@Entity
public class Employee {
    @Id
    @GeneratedValue
    private int id;

    @OneToOne(cascade = CascadeType.REMOVE) // deletes AccessCard automatically
    private AccessCard accessCard;

    @OneToMany(mappedBy = "employee", cascade = CascadeType.REMOVE) 
    private List<PayStub> paystubs;
}
```

### Deleting Employee

```java
EntityManager em = emf.createEntityManager();
EntityTransaction tx = em.getTransaction();

Employee employee = em.find(Employee.class, 1);

tx.begin();
em.remove(employee); // will also remove accessCard + paystubs
tx.commit();

JpaDemo6.java:
```java```
package com.tekgrads;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import com.tekgrads.entities.Employee;

public class JpaDemo6 {
public static void main(String args[]){
	EntityManagerFactory entityManagerFactory =Persistence.createEntityManagerFactory("springJpaPU");
	EntityManager entitymanager= entityManagerFactory.createEntityManager();
	Employee employee = entitymanager.find(Employee.class, 1);
	EntityTransaction transaction = entitymanager.getTransaction();
	transaction.begin();
	entitymanager.remove(employee);
	transaction.commit();
}
}
