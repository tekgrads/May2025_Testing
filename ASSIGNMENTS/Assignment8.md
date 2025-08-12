# Normalization in DBMS

## 1. What is Normalization?
Normalization is the process of **organizing data** in a database to:
- Reduce **data redundancy** (duplicate data).
- Ensure **data integrity**.
- Make the database **efficient** for querying and updating.

It involves dividing large tables into **smaller, related tables** and defining relationships between them.

---

## 2. Why Normalization is Needed
- **Avoids redundancy** – Saves storage space.
- **Maintains consistency** – No conflicting values for the same data.
- **Improves query performance** – Data retrieval becomes more efficient.
- **Ensures data integrity** – Avoids anomalies in insertion, deletion, and updates.

---

## 3. Types (Normal Forms)

### 3.1 First Normal Form (1NF)
**Rule:**
- Each cell should have **atomic (indivisible) values**.
- No **repeating groups** or **arrays** in a column.

**Example:**

❌ **Not in 1NF:**
| StudentID | Name     | Subjects        |
|-----------|----------|----------------|
| 1         | Alice    | Math, Science  |

✅ **In 1NF:**
| StudentID | Name     | Subject  |
|-----------|----------|----------|
| 1         | Alice    | Math     |
| 1         | Alice    | Science  |

---

### 3.2 Second Normal Form (2NF)
**Rule:**
- Must be in **1NF**.
- No **partial dependency** (i.e., no non-key attribute should depend on only part of a composite primary key).

**Example:**

❌ **Partial Dependency:**
| StudentID | CourseID | StudentName | CourseName |
|-----------|----------|-------------|------------|

Here, `StudentName` depends only on `StudentID` and not on the whole key `(StudentID, CourseID)`.

✅ **In 2NF:**
- **Students(StudentID, StudentName)**
- **Courses(CourseID, CourseName)**
- **Enrollments(StudentID, CourseID)**

---

### 3.3 Third Normal Form (3NF)
**Rule:**
- Must be in **2NF**.
- No **transitive dependency** (non-key attribute should not depend on another non-key attribute).

**Example:**

❌ **Transitive Dependency:**
| EmpID | EmpName | DeptID | DeptName |
|-------|---------|--------|----------|

Here, `DeptName` depends on `DeptID`, which depends on `EmpID`.

✅ **In 3NF:**
- **Employees(EmpID, EmpName, DeptID)**
- **Departments(DeptID, DeptName)**

---

### 3.4 Boyce-Codd Normal Form (BCNF)
**Rule:**
- A stricter version of 3NF.
- For every **functional dependency** `X → Y`, `X` must be a **super key**.

**Example:**
If multiple candidate keys exist, BCNF ensures no anomalies occur.

---

### 3.5 Fourth Normal Form (4NF)
**Rule:**
- Must be in **BCNF**.
- No **multi-valued dependencies**.

---

### 3.6 Fifth Normal Form (5NF)
**Rule:**
- Must be in **4NF**.
- No **join dependency** anomalies.

---

## 4. Summary Table

| Normal Form | Rule |
|-------------|------|
| **1NF**     | Atomic values, no repeating groups |
| **2NF**     | 1NF + No partial dependency |
| **3NF**     | 2NF + No transitive dependency |
| **BCNF**    | Every determinant must be a super key |
| **4NF**     | BCNF + No multi-valued dependency |
| **5NF**     | 4NF + No join dependency anomalies |
