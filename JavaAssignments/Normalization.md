# 📚 Database Normalization

**Normalization** is a process in relational database design to organize data efficiently, eliminate redundancy, and ensure data integrity.

---

## ✅ **Goals of Normalization**

- Minimize data redundancy
- Avoid update, insert, and delete anomalies
- Simplify queries and maintenance
- Ensure logical data organization

---

## 🔢 Normal Forms (NF)

Normalization involves organizing the data into **normal forms**, each building upon the previous one.

---

## 1️⃣ First Normal Form (1NF)

**Rule**:  
- Each column must have **atomic (indivisible)** values  
- Each record must be **unique**  
- No repeating groups or arrays

### 💡 Example (Before 1NF):

| StudentID | Name  | Subjects         |
|-----------|-------|------------------|
| 1         | Alice | Math, Science    |

### ✅ After 1NF:

| StudentID | Name  | Subject   |
|-----------|--------|-----------|
| 1         | Alice  | Math      |
| 1         | Alice  | Science   |

---

## 2️⃣ Second Normal Form (2NF)

**Rule**:  
- Must be in **1NF**
- **No partial dependency** (i.e., all non-key attributes should depend on the **whole** primary key)

> Partial Dependency: When a non-key attribute depends only on **part of a composite key**

### 💡 Example (Before 2NF):

| StudentID | CourseID | StudentName | CourseName |
|-----------|----------|-------------|------------|
| 1         | 101      | Alice       | Math       |

> `StudentName` depends only on `StudentID`, not on both `StudentID + CourseID`

### ✅ After 2NF:

**Students Table**

| StudentID | StudentName |
|-----------|-------------|
| 1         | Alice       |

**Courses Table**

| CourseID | CourseName |
|----------|------------|
| 101      | Math       |

**Enrollments Table**

| StudentID | CourseID |
|-----------|----------|
| 1         | 101      |

---

## 3️⃣ Third Normal Form (3NF)

**Rule**:  
- Must be in **2NF**
- **No transitive dependency** (i.e., non-key attributes should not depend on other non-key attributes)

> Transitive Dependency: A → B → C, then A → C is transitive

### 💡 Example (Before 3NF):

| EmployeeID | Name  | DeptID | DeptName  |
|------------|-------|--------|-----------|
| 1          | Alice | 10     | HR        |

> `DeptName` depends on `DeptID`, not on `EmployeeID`

### ✅ After 3NF:

**Employees Table**

| EmployeeID | Name  | DeptID |
|------------|-------|--------|
| 1          | Alice | 10     |

**Departments Table**

| DeptID | DeptName |
|--------|----------|
| 10     | HR       |

---

## 4️⃣ Boyce-Codd Normal Form (BCNF)

**Rule**:  
- A stronger version of 3NF  
- For every functional dependency A → B, **A must be a super key**

> All candidate keys should be considered for checking dependencies

---

## 5️⃣ Fourth Normal Form (4NF)

**Rule**:  
- Must be in **BCNF**
- No **multi-valued dependencies**

### 💡 Example:

| StudentID | Hobby     | Language  |
|-----------|-----------|-----------|
| 1         | Painting  | English   |
| 1         | Painting  | French    |
| 1         | Dancing   | English   |
| 1         | Dancing   | French    |

> One-to-many relationships should be separated.

---

## 6️⃣ Fifth Normal Form (5NF)

**Rule**:  
- Deals with **join dependencies**  
- A relation should be **reconstructible** from its projections (subtables)

---

## Summary Table

| Normal Form | Main Rule                                 | Removes                      |
|-------------|--------------------------------------------|-------------------------------|
| 1NF         | Atomic values, unique rows                 | Repeating groups              |
| 2NF         | No partial dependencies                   | Partial dependencies          |
| 3NF         | No transitive dependencies                | Transitive dependencies       |
| BCNF        | Every determinant is a candidate key       | Anomalies not covered by 3NF  |
| 4NF         | No multi-valued dependencies               | Multivalued dependencies      |
| 5NF         | No join dependencies                       | Join anomalies                |

---

## 🚨 Anomalies Resolved by Normalization

- **Update anomaly** – Redundant data needs to be updated in many places
- **Insert anomaly** – Cannot insert data due to missing other values
- **Delete anomaly** – Deleting one data removes other useful data

---

## 🔄 Denormalization

In some cases (like reporting or analytics), **denormalization** is used to improve read performance at the cost of some redundancy.

---

> ✅ Normalize for **data integrity**
> ⚡️ Denormalize for **performance**, when needed
