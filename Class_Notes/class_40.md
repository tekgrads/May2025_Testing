

# Spring Data JPA – Table Creation, Constraints, and One-to-One Mapping

## 1. Creating or Dropping Tables

**`persistence.xml` setting:**

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

**`Employee.java`:**

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
private int age;

@Column(name="employee_ssn", unique=true)
private String ssn;
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
```

---

## 5. Duplicate Data Error Scenarios

### Case 1 – Duplicate ID and SSN

```java
Employee employee1 = new Employee(1, "first employee", 22, "123");
Employee employee2 = new Employee(1, "second employee", 22, "123");
```

**Possible Errors:**

1. **Duplicate ID** → Primary key violation.
2. **Duplicate SSN** → Unique constraint violation.

---

### Case 2 – Different IDs, Different SSNs

```java
Employee employee1 = new Employee(1, "first employee", 22, "123");
Employee employee2 = new Employee(2, "second employee", 22, "1234");
```

**Hibernate Output:**

```sql
insert into EMPLOYEE_DATA (...) values (?, ?, ?, ?)
insert into EMPLOYEE_DATA (...) values (?, ?, ?, ?)
```

No constraint violation.

---

## 6. Column Length and Nullability

**With length:**

```java
@Column(name="employee_ssn", unique=true, length=10)
private String ssn;
```

Output:

```sql
employee_ssn varchar(10)
```

**With nullability:**

```java
@Column(name="employee_ssn", nullable=false, unique=true, length=10)
private String ssn;
```

Output:

```sql
employee_ssn varchar(10) not null
```

---

## 7. Temporal Annotations

```java
@Temporal(TemporalType.DATE)
private Date dob;
```

* `TemporalType.DATE` → Date only
* `TemporalType.TIME` → Time only
* `TemporalType.TIMESTAMP` → Date + Time

---

## 8. Enum Mapping

**Default (Ordinal):**

```java
@Column(name="employee_type")
private EmployeeType type;
```

Stored as **integer** in DB.

**As String:**

```java
@Enumerated(EnumType.STRING)
@Column(name="employee_type")
private EmployeeType type;
```

Output:

```sql
employee_type varchar(255)
```

---

## 9. Transient Fields

```java
@Transient
private String debugString;
```

*Not stored in DB.*

---

## 10. Auto-Generated IDs

```java
@Id
@GeneratedValue
private int id;
```

Uses `hibernate_sequence` to generate IDs.

---

## 11. `hibernate.hbm2ddl.auto` = none

```xml
<property name="hibernate.hbm2ddl.auto" value="none" />
```

No schema changes; Hibernate only queries.

---

## 12. Fetching Data

```java
Employee employee = entitymanager.find(Employee.class, 1);
```

Hibernate generates a **SELECT** query.

---

## 13. Removing Data

```java
transaction.begin();
entitymanager.remove(employee1);
transaction.commit();
```

Generates a **DELETE** query.

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

    @OneToOne
    @JoinColumn(name="employee_id", unique=true)
    private Employee employee;
}
```

---

## 15. One-to-One Mapping

**In AccessCard (owning side):**

```java
@OneToOne
@JoinColumn(name="employee_id", unique=true)
private Employee employee;
```

**In Employee (inverse side):**

```java
@OneToOne(mappedBy="employee", fetch=FetchType.LAZY)
private AccessCard accessCard;
```

---

## 16. ER Diagram (One-to-One)

```
+-----------------+        1 : 1        +----------------+
|   EMPLOYEE      |<------------------->|  ACCESS_CARD   |
+-----------------+                     +----------------+
| id (PK)         |                     | id (PK)         |
| name            |                     | issue_date      |
| age             |                     | is_active       |
| ssn (unique)    |                     | firmware_version|
+-----------------+                     | employee_id (FK)|
                                         +----------------+
```

