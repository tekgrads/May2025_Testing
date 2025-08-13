Spring Data JPA – Table Creation, Constraints, and One-to-One Mapping
1. Table Creation / Dropping
Controlled via hibernate.hbm2ddl.auto property in persistence.xml.

xml
Copy
Edit
<property name="hibernate.hbm2ddl.auto" value="create-drop" />
create-drop → Creates tables at startup, drops them at shutdown.

Hibernate Output:

sql
Copy
Edit
drop table if exists EMPLOYEE_DATA
create table EMPLOYEE_DATA (
   id integer not null,
   name varchar(255),
   primary key (id)
) engine=InnoDB
insert into EMPLOYEE_DATA (name, id) values (?, ?)
2. Custom Column Name
Use @Column(name="custom_column_name") to change DB column names.

java
Copy
Edit
@Column(name="employee_name")
private String name;
Output:

sql
Copy
Edit
create table EMPLOYEE_DATA (
   id integer not null,
   employee_name varchar(255),
   primary key (id)
)
3. Unique Constraint
Add unique = true in @Column.

java
Copy
Edit
@Column(name="employee_name", unique=true)
private String name;
Output:

sql
Copy
Edit
alter table EMPLOYEE_DATA
   add constraint UK_mf2isb2vhsth54xsnaxq2rluq unique (employee_name)
4. Multiple Columns with Constraints
java
Copy
Edit
@Id
private int id;

@Column(name="employee_name", unique=true)
private String name;

@Column(name="employee_age")
private int age;

@Column(name="employee_ssn", unique=true)
private String ssn;
Output:

sql
Copy
Edit
create table EMPLOYEE_DATA (
   id integer not null,
   employee_age integer,
   employee_name varchar(255),
   employee_ssn varchar(255),
   primary key (id)
)
alter table EMPLOYEE_DATA add constraint ... unique (employee_name)
alter table EMPLOYEE_DATA add constraint ... unique (employee_ssn)
5. Duplicate Data Error Scenarios
Duplicate Primary Key (ID) → ConstraintViolationException

Duplicate Unique Column (SSN) → Unique constraint violation.

Different IDs & SSNs → No violation.

6. Column Length & Nullability
Limit string size:

java
Copy
Edit
@Column(name="employee_ssn", length=10)
Disallow null values:

java
Copy
Edit
@Column(name="employee_ssn", nullable=false, unique=true, length=10)
Output:

sql
Copy
Edit
employee_ssn varchar(10) not null
7. Temporal Annotations
Used for java.util.Date fields.

java
Copy
Edit
@Temporal(TemporalType.DATE)      // Only date
@Temporal(TemporalType.TIME)      // Only time
@Temporal(TemporalType.TIMESTAMP) // Date + time
8. Enum Mapping
Default: Stored as integer (ordinal).

java
Copy
Edit
@Column(name="employee_type")
private EmployeeType type;
As String:

java
Copy
Edit
@Enumerated(EnumType.STRING)
@Column(name="employee_type")
private EmployeeType type;
9. Transient Fields
Ignored by Hibernate (not stored in DB).

java
Copy
Edit
@Transient
private String debugString;
10. Auto-Generated IDs
Hibernate can auto-generate primary keys.

java
Copy
Edit
@Id
@GeneratedValue
private int id;
11. No Schema Update
Disable table creation/modification:

xml
Copy
Edit
<property name="hibernate.hbm2ddl.auto" value="none" />
12. Fetching Data
java
Copy
Edit
Employee emp = entityManager.find(Employee.class, 1);
Hibernate Output:

sql
Copy
Edit
select * from EMPLOYEE_DATA where id=?
13. Removing Data
java
Copy
Edit
transaction.begin();
entityManager.remove(employee1);
transaction.commit();
Output:

sql
Copy
Edit
delete from EMPLOYEE_DATA where id=?