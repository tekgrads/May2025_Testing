
# Normalization in DBMS

## What is Normalization?

Normalization is a process of organizing data in a database to reduce data redundancy and improve data integrity.

It divides large tables into smaller, well-structured tables without losing data.

---

## Objectives of Normalization

- Eliminate data redundancy (duplicate data)
- Ensure data dependencies make sense
- Make database efficient in terms of space and queries

---

## Types of Normal Forms

---

### 1NF – First Normal Form

**Rule:**  
Each column should contain atomic (indivisible) values, and each record should be unique.

**Violation Example:**

| StudentID | Name     | Courses           |
|-----------|----------|-------------------|
| 101       | Sathvika | Math, Physics     |
| 102       | Nitthu   | Chemistry         |

Here, Courses has multiple values.

**1NF Conversion:**

| StudentID | Name     | Course    |
|-----------|------- --|-----------|
| 101       | Sathvika | Math      |
| 101       | Sathvika | Physics   |
| 102       | Nitthu   | Chemistry |

---

### 2NF – Second Normal Form

**Rule:**  
It must be in 1NF and every non-key column must be fully dependent on the entire primary key.

**Violation Example:**

| StudentID | Course   | StudentName |
|-----------|----------|-------------|
| 101       | Math     | Sathvika    |
| 101       | Physics  | Sathvika    |

Here, StudentName depends only on StudentID, not the whole composite key (StudentID + Course).

**2NF Conversion:**

**Students Table**

| StudentID | StudentName |
|-----------|-------------|
| 101       | Sathvika    |

**Enrollments Table**

| StudentID | Course   |
|-----------|----------|
| 101       | Math     |
| 101       | Physics  |

---

### 3NF – Third Normal Form

**Rule:**  
It must be in 2NF and all non-key columns should depend only on the primary key, not on another non-key column (no transitive dependency).

**Violation Example:**

| EmpID | EmpName | DeptID | DeptName |
|-------|---------|--------|----------|
| 1     | John    | 101    | HR       |

Here, DeptName depends on DeptID, not directly on EmpID

**3NF Conversion:**

**Employee Table**

| EmpID | EmpName | DeptID |
|-------|---------|--------|
| 1     | John    | 101    |

**Department Table**

| DeptID | DeptName |
|--------|----------|
| 101    | HR       |

---

### BCNF – Boyce-Codd Normal Form

**Rule:**  
A modified version of 3NF. Every determinant must be a candidate key.

**Violation Example:**

| Course | Name       | Room  |
|--------|------------|-------|
| Math   | John       | R101  |
| Math   | John       | R102  |

If one course is always taught by the same instructor, but room varies, Course → Instructor is a dependency, but not a candidate key.

**BCNF Conversion:**

**Course Table**

| Course | Name       |
|--------|------------|
| Math   | John       |

**CourseRoom Table**

| Course | Room  |
|--------|-------|
| Math   | R101  |
| Math   | R102  |

---

### 4NF – Fourth Normal Form

**Rule:**  
Must be in BCNF and no multivalued dependencies(a record shouldn't have two or more independent multi-valued facts).

**Violation Example:**

| Student | Course   | Hobby     |
|---------|----------|-----------|
| Alice   | Math     | Painting  |
| Alice   | Physics  | Painting  |
| Alice   | Math     | Dancing   |
| Alice   | Physics  | Dancing   |

Course and Hobby are independent, both related to Student.

**4NF Conversion:**

**StudentCourse Table**

| Student | Course   |
|---------|----------|
| Alice   | Math     |
| Alice   | Physics  |

**StudentHobby Table**

| Student | Hobby     |
|---------|-----------|
| Alice   | Painting  |
| Alice   | Dancing   |

---

### 5NF – Fifth Normal Form

**Rule:**  
Must be in 4NF and no join dependency that is not implied by candidate keys.


---

## Summary Table

| Normal Form | Rule                                                          | Goal                            |
|-------------|---------------------------------------------------------------|---------------------------------|
| 1NF         | Atomic values, unique rows                                    | Eliminate repeating groups      |
| 2NF         | No partial dependency (on part of primary key)                | Eliminate partial dependency    |
| 3NF         | No transitive dependency                                      | Eliminate transitive dependency |
| BCNF        | Determinants must be candidate keys                           | Eliminate anomalies in 3NF      |
| 4NF         | No multivalued dependency                                     | Remove independent multi-values |
| 5NF         | No join dependency                                            | Ensure correct join results     |

---
