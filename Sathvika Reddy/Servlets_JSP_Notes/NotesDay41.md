# Spring Data JPA — Entity Relationships Examples:

## 1. One-to-One Mapping:

**Scenario:** An `Employee` has exactly one `AccessCard`.
**Mapping in Employee.java:**

```java
@OneToOne(cascade=CascadeType.PERSIST) // or CascadeType.ALL / CascadeType.REMOVE
@JoinColumn(name="ACCESS_CARD_ID")
AccessCard accessCard;
```

**Explanation:**

* `@OneToOne` defines a one-to-one association between `Employee` and `AccessCard`.
* `cascade` controls how persistence operations are cascaded from `Employee` to `AccessCard`.
* `@JoinColumn` specifies the foreign key column in the `Employee` table pointing to `AccessCard`.

---

## 2. One-to-Many Mapping:

**Scenario:** One `Employee` can have multiple `PayStub` entries.

### PayStub.java:

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
```

### Employee.java (One-to-Many side):

```java
@OneToMany(mappedBy="employee",cascade=CascadeType.PERSIST)
List<PayStub> paystub;
```

**Explanation:**

* `@OneToMany` indicates `Employee` has multiple `PayStub` records.
* `mappedBy="employee"` means `PayStub` owns the foreign key (`employee_id`), so `Employee` is the inverse side.
* `cascade=CascadeType.PERSIST` ensures that when you save an `Employee`, all associated `PayStub` objects are also saved.

---

### JpaDemo4.java — Persisting One-to-Many data:

```java
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
```

---

## 3. Many-to-Many Mapping:

**Scenario:** Many `Employee` objects can belong to many `EmailGroup` objects.

### EmailGroup.java:

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
```

### Employee.java (Many-to-Many side):

```java
@ManyToMany(cascade=CascadeType.PERSIST)
@JoinTable(name="EMAIL_GROUP_SUBSCRIPTIONS",
	joinColumns = @JoinColumn(name="EMPLOYEE_ID"),
	inverseJoinColumns = @JoinColumn(name="EMAIL_GROUP_ID")
)
List<EmailGroup> emailGroups;
```

**Explanation:**

* `@ManyToMany` creates a join table to link employees and email groups.
* `@JoinTable` defines the table and the foreign keys used for the mapping.
* Cascading ensures related entities are persisted together.

---

### JpaDemo5.java — Persisting Many-to-Many Data:

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

public class JpaDemo5 {
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
	
	List<PayStub> payStubs = new ArrayList<>();
	payStubs.add(paystub1);
	payStubs.add(paystub2);
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
	
	EntityManagerFactory entityManagerFactory =Persistence.createEntityManagerFactory("springJpaPU");
	EntityManager entitymanager= entityManagerFactory.createEntityManager();
	EntityTransaction transaction=entitymanager.getTransaction();
	transaction.begin();
	entitymanager.persist(employee1);
	entitymanager.persist(employee2);
	entitymanager.persist(accessCard1);
	entitymanager.persist(accessCard2);
	transaction.commit();
}
}
```

---

## 4. Deleting Entities (Cascade Effect):

**JpaDemo6.java** — Demonstrating deletion and cascading behavior:

```java
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
```

**Explanation:**

* Deleting `Employee` will also delete associated entities if `CascadeType.REMOVE` or `CascadeType.ALL` is used.
* The persistence context ensures the removal is cascaded appropriately based on the mappings.

