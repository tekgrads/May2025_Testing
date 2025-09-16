

### Create - Drop (in Hibernate Properties)
- Whatever you have created, it will get created and dropped.  
- Drops the existing tables and recreates them.

---

### Renaming a Column
```java
@Column(name = "employee-name")

Not Null or Unique
@Column(name = "employee-name", unique = true)  private String name;

Length Restriction
@Column(name = "employee-name", unique = true, length = 10)

Not Null
nullable = false

Prevent Updating a Column
updatable = false

Date of Birth
@Temporal(TemporalType.DATE)
private Date dob;
	•	DATE → only date
	•	TIME → only time
	•	TIMESTAMP → considers both date and time
Enum Column
@Column(name = "EMP-TYP")
@Enumerated(EnumType.STRING) 
private EmployeeType type;
•	If you don’t want to save the order and want to store the exact value, use EnumType.STRING.
Transient
•	Used at the time of Serialization.
•	If you don’t want to consider a column for JPA transactions:
@Transient
•	These columns are not considered for table creation.
Auto Generated I’d 
@GeneratedValue(strategy = GenerationType.AUTO)
•	Automatically incremented.
•	Simply using @GeneratedValue also gives auto increment.

Sequence
•	Default sequence is from the database.
•	You can also set your sequence to start from a necessary value.

Creating Entities
If you want to find an entity in JPA:
Employee emp = entityManager.find(Employee.class, 1);
System.out.println(emp);

Updating or Removing Records
To update, first fetch details.
EntityTransaction transaction = entityManager.getTransaction();
transaction.begin();
entityManager.remove(employee);
transaction.commit();

Entity & Table Mapping
@Entity
@Table(name = "ACCESS_CARD")
Create 2 access cards in JPA demo 3.
Access card and employee should have a 1-1 connection.
@OneToOne
private Employee employee;
Then set your access card to employee, and employee to access card.
@OneToOne(mappedBy = "employee")
• Don’t again do mapping on employee.

Relationships
•	@OneToOne → 1 record mapped to another 1 record.
•	@OneToMany → Used in different scenarios.
Lazy Fetch
If you don’t want to fetch with your access card without permission:
@OneToOne(mappedBy = "employee", fetch = FetchType.LAZY)
•	By default, fetch type is EAGER.
•	By making it LAZY, it will fetch only when required.
