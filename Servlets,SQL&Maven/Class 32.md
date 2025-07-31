# Class 32: (25/07/2025)

## Driver Classes
- Are nothing but the implementation classes according to a particular database. So they can write whatever implementation is needed.

## MySQLConnector
- Is a set of `.class` files which provides an implementation of all these interfaces which are part of JDBC.

## Connection & Prepared Statements
- These are the two most important interfaces required for making a connection.
- `(?,?,?,?,?)` → These are called **placeholders** for values.

## Employees DAO

### Primary Key
- It will uniquely define that particular row.

### ResultSet
- Gives you the result of that particular set.

## 4 Steps to Connect to Database
1. Load the Driver class
2. Get the Connection object
3. Prepare statement
4. Execute update

## What Does a Database Do?
- DB creates a filesystem for us.
- Now we need something to interact with DB.
- That is through the MySQL client called **MySQL Workbench**.

## What are SOLID Principles?

**S: Single Responsibility Principle (SRP)**  
- A class should have only one reason to change.

**O: Open/Closed Principle (OCP)**  
- Software entities should be open for extension but closed for modification.

**L: Liskov Substitution Principle (LSP)**  
- Subtypes must be substitutable for their base types (use inheritance).  
- Anywhere a parent class is expected, a child should run without issue.

**I: Interface Segregation Principle (ISP)**  
- No client should be forced to depend on methods it does not use.  
- Break large interfaces into smaller, role-specific ones.

**D: Dependency Inversion Principle (DIP)**  
- Depend on abstraction, not on concretion.  
- Code should rely on interfaces or abstract classes, not concrete implementations.

## DAO - Data Access Object
- **Design Pattern**: Used to abstract and encapsulate all access to the data source (like a database).
- DAO manages the connection with the data source to obtain and store data.

## How to Handle Anomalies?
- By creating another table.
- `EmpId` can work on two tasks in the new formatted table.

> **Example:**  
If we create two tables, the primary key of the first table will become a foreign key in the second table.

## What is SQL Injection?
- (Need clarification on how SQL injection and prepared statements/statements are related.)

## JPA - Java Persistence API
- To minimize MySQL queries in code, we use JPA.
- For each and every servlet, we were creating Employee service objects manually.  
  This is now handled by Spring IOC and JPA.

### Abstraction Levels:
- **Level 1**: JDBC Template  
- **Level 2**: JPA

## Logging
- Will be adding logger in that.
