
# Spring Data JPA – Table Creation, Constraints, and One-to-One Mapping

## 1. Creating or Dropping Tables
**persistence.xml setting:**
```xml
<property name="hibernate.hbm2ddl.auto" value="create-drop" />
```
**Hibernate Output:**
```sql
drop table if exists EMPLOYEE_DATA
create table EMPLOYEE_DATA (
   id integer not null,
    name varchar(255),
    primary key (id)
) engine=InnoDB
insert into EMPLOYEE_DATA (name, id) values (?, ?)
```

## 2. Custom Column Name
**Employee.java:**
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

## 5. Duplicate Data Error Scenarios

**Case 1 – Duplicate ID and SSN**
- Duplicate ID (Primary Key) → `ConstraintViolationException`
- Duplicate SSN (Unique Column) → Violates unique constraint

**Case 2 – Different IDs, Different SSNs**
```java
entitymanager.persist(employee1);
entitymanager.persist(employee2);
```
**Hibernate Output:**
```sql
insert into EMPLOYEE_DATA (employee_age, employee_name, employee_ssn, id) values (?, ?, ?, ?)
insert into EMPLOYEE_DATA (employee_age, employee_name, employee_ssn, id) values (?, ?, ?, ?)
```
(No constraint violation)

## 6. Column Length and Nullability
With Length:
```java
@Column(name="employee_ssn", unique=true, length=10)
String ssn;
```
Output:
```sql
employee_ssn varchar(10)
```

With Nullability:
```java
@Column(name="employee_ssn", nullable=false, unique=true, length=10)
String ssn;
```
Output:
```sql
create table EMPLOYEE_DATA (
       id integer not null,
        employee_age integer,
        employee_name varchar(255),
        employee_ssn varchar(10) not null,
        primary key (id)
) engine=InnoDB
```

## 7. Temporal Annotations
```java
@Temporal(TemporalType.DATE)
private Date dob;
```
**Hibernate Output:**
```sql
insert into EMPLOYEE_DATA (employee_age, dob, employee_name, employee_ssn, id) values (?, ?, ?, ?, ?)
```
- `TemporalType.DATE` → Only date stored  
- `TemporalType.TIME` → Only current time stored  
- `TemporalType.TIMESTAMP` → Both date and time stored  

## 8. Enum Mapping
Default (Ordinal):
```java
@Column(name="employee_type")
private EmployeeType type;
```
Stored as Integer.

As String:
```java
@Enumerated(EnumType.STRING)
@Column(name="employee_type")
private EmployeeType type;
```
Output:
```sql
employee_type varchar(255)
```
Example DB Rows:
```
1	22	2025-08-08	first employee	123	Manager
2	22	2025-08-08	second employee	1234	Business
```

## 9. Transient Fields
```java
@Transient
private String debugString;
```
Purpose: This field will not be stored in the database.

## 10. Auto-Generated IDs
```java
@Id
@GeneratedValue
private int id;
```
Hibernate Output:
```sql
select next_val as id_val from hibernate_sequence for update
update hibernate_sequence set next_val=? where next_val=?
```

## 11. Setting hibernate.hbm2ddl.auto to None
```xml
<property name="hibernate.hbm2ddl.auto" value="none" />
```
No table updates occur; Hibernate only performs queries.

## 12. Fetching Data
```java
Employee employee = entitymanager.find(Employee.class, 1);
System.out.println(employee);
```
Hibernate Output:
```sql
select employee0_.id as id1_0_0_, ... from EMPLOYEE_DATA employee0_ where employee0_.id=?
```

## 13. Removing Data
```java
transaction.begin();
entitymanager.remove(employee1);
transaction.commit();
```
Hibernate Output:
```sql
delete from EMPLOYEE_DATA where id=?
```


```
