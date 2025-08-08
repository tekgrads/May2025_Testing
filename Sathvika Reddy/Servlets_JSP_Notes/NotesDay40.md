# Spring Data JPA – Table Creation, Constraints, and One-to-One Mapping:

## 1. Creating or Dropping Tables

### `persistence.xml` setting:

```xml
<property name="hibernate.hbm2ddl.auto" value="create-drop" />
```

**Hibernate Output:**

```sql
Hibernate: 
    drop table if exists EMPLOYEE_DATA
Hibernate: 
    create table EMPLOYEE_DATA (
       id integer not null,
        name varchar(255),
        primary key (id)
    ) engine=InnoDB
Hibernate: 
    /* insert com.tekgrads.entities.Employee */ 
    insert into EMPLOYEE_DATA (name, id) values (?, ?)
```

---

## 2. Custom Column Name

### Employee.java:

```java
@Column(name="employee_name")
private String name;
```

**Hibernate Output:**

```sql
create table EMPLOYEE_DATA (
       id integer not null,
        employee_name varchar(255),
        primary key (id)
) engine=InnoDB
insert into EMPLOYEE_DATA (employee_name, id) values (?, ?)
```

---

## 3. Unique Constraint on Column

```java
@Column(name="employee_name", unique=true)
private String name;
```

**Hibernate Output:**

```sql
alter table EMPLOYEE_DATA 
       add constraint UK_mf2isb2vhsth54xsnaxq2rluq unique (employee_name)
```

---

## 4. Multiple Columns with Constraints

```java
@Id
private int id;

@Column(name="employee_name", unique=true)
private String name;

@Column(name="employee_age")
int age;

@Column(name="employee_ssn", unique=true)
String ssn;
```

**Hibernate Output:**

```sql
create table EMPLOYEE_DATA (
       id integer not null,
        employee_age integer,
        employee_name varchar(255),
        employee_ssn varchar(255),
        primary key (id)
) engine=InnoDB

alter table EMPLOYEE_DATA 
       add constraint UK_mf2isb2vhsth54xsnaxq2rluq unique (employee_name)

alter table EMPLOYEE_DATA 
       add constraint UK_2ii6vt88p52o15l5wntdb35sy unique (employee_ssn)

insert into EMPLOYEE_DATA (employee_age, employee_name, employee_ssn, id) values (?, ?, ?, ?)
```

---

## 5. Duplicate Data Error Scenarios

### Case 1 – Duplicate ID and SSN

```java
Employee employee1 = new Employee();
employee1.setId(1);
employee1.setName("first employee");
employee1.setAge(22);
employee1.setSsn("123");

Employee employee2 = new Employee();
employee2.setId(1); // Duplicate Primary Key
employee2.setName("second employee");
employee2.setAge(22);
employee2.setSsn("123"); // Duplicate Unique Column
```

**Possible Errors:**

1. **Duplicate ID (Primary Key)** – Database will throw a `ConstraintViolationException` because primary key values must be unique.
2. **Duplicate SSN (Unique Column)** – Even if IDs are different, a duplicate SSN violates the unique constraint.

---

### Case 2 – Different IDs, Different SSNs

```java
Employee employee1 = new Employee();
employee1.setId(1);
employee1.setName("first employee");
employee1.setAge(22);
employee1.setSsn("123");

Employee employee2 = new Employee();
employee2.setId(2);
employee2.setName("second employee");
employee2.setAge(22);
employee2.setSsn("1234");

entitymanager.persist(employee1);
entitymanager.persist(employee2);
```

**Hibernate Output:**

```sql
insert into EMPLOYEE_DATA (employee_age, employee_name, employee_ssn, id) values (?, ?, ?, ?)
insert into EMPLOYEE_DATA (employee_age, employee_name, employee_ssn, id) values (?, ?, ?, ?)
```

(No constraint violation here.)

---

## 6. Column Length and Nullability

### With Length:

```java
@Column(name="employee_ssn", unique=true, length=10)
String ssn;
```

**Output:**

```sql
employee_ssn varchar(10)
```

---

### With Nullability:

```java
@Column(name="employee_ssn", nullable=false, unique=true, length=10)
String ssn;
```

**Output:**

```sql
create table EMPLOYEE_DATA (
       id integer not null,
        employee_age integer,
        employee_name varchar(255),
        employee_ssn varchar(10) not null,
        primary key (id)
) engine=InnoDB
```

---

## 7. Temporal Annotations

```java
@Temporal(TemporalType.DATE)
private Date dob;
```

**Hibernate Output:**

```sql
insert into EMPLOYEE_DATA (employee_age, dob, employee_name, employee_ssn, id) values (?, ?, ?, ?, ?)
```

* **TemporalType.DATE** → Only date stored.
* **TemporalType.TIME** → Only current time stored.
* **TemporalType.TIMESTAMP** → Both current date and time stored.

---

## 8. Enum Mapping

### Default (Ordinal)

```java
@Column(name="employee_type")
private EmployeeType type;
```

**Stored as Integer in DB.**

---

### As String:

```java
@Enumerated(EnumType.STRING)
@Column(name="employee_type")
private EmployeeType type;
```

**Output:**

```sql
employee_type varchar(255)
```

**Example DB Rows:**

```
1	22	2025-08-08	first employee	123	FULL_TIME
2	22	2025-08-08	second employee	1234	CONTRACTOR
```

---

## 9. Transient Fields

```java
@Transient
private String debugString;
```

**Purpose:** This field will not be stored in the database.

---

## 10. Auto-Generated IDs

```java
@Id
@GeneratedValue
private int id;
```

Even without explicitly setting `id`, Hibernate generates values using `hibernate_sequence`.

**Hibernate Output (sequence update):**

```sql
select next_val as id_val from hibernate_sequence for update
update hibernate_sequence set next_val=? where next_val=?
```

---

## 11. Setting `hibernate.hbm2ddl.auto` to None

```xml
<property name="hibernate.hbm2ddl.auto" value="none" />
```

No table updates will occur; Hibernate only performs queries.

---

## 12. Fetching Data

```java
Employee employee = entitymanager.find(Employee.class, 1);
System.out.println(employee);
```

**Hibernate Output:**

```sql
select employee0_.id as id1_0_0_, ... from EMPLOYEE_DATA employee0_ where employee0_.id=?
```

---

## 13. Removing Data

```java
transaction.begin();
entitymanager.remove(employee1);
transaction.commit();
```

**Hibernate Output:**

```sql
delete from EMPLOYEE_DATA where id=?
```

---

## 14. AccessCard Entity

```java
@Entity
@Table(name="ACCESS_CARD")
public class AccessCard {
    @Id
    @GeneratedValue
    private int id;

    @Column(name="ISSUE_DATE")
    private Date issueDate;

    @Column(name="IS_ACTIVE")
    private Boolean isActive;

    @Column(name="FIRMWARE_VERSION")
    private String firmwareVersion;
}
```

---

## 15. JpaDemo3 Persisting Multiple Entities

**Hibernate Output (IDs generated for both Employee and AccessCard):**

```sql
insert into EMPLOYEE_DATA (...)
insert into ACCESS_CARD (...)
```

---

## 16. One-to-One Mapping

### In `AccessCard`:

```java
@OneToOne
private Employee employee;
```

### In `Employee`:

```java
@OneToOne
private AccessCard accessCard;
```

### Using `mappedBy`:

```java
@OneToOne(mappedBy="employee")
private AccessCard accessCard;
```

### With Lazy Loading:

```java
@OneToOne(mappedBy="employee", fetch=FetchType.LAZY)
private AccessCard accessCard;
```

