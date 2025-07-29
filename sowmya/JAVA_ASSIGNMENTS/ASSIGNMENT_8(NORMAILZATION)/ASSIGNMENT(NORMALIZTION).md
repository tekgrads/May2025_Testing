## Normalization:

Normalization is the process of organizing data in a database to remove duplicate data and ensure data is stored efficiently.

### Why Normalization?

* Avoid data redundancy (no repeating data)
* Ensure data consistency
* Make database easier to maintain and update

---

## 1NF – First Normal Form

A table is in 1NF if:

* All columns have atomic (single) values
* No repeating groups

**Not in 1NF:**

| ID | Name  | Subject        |
| -- | ----- | -------------- |
| 1  | Sowmy | Maths, Science |

**In 1NF:**

| ID | Name  | Subject |
| -- | ----- | ------- |
| 1  | Sowmy | Maths   |
| 1  | Sowmy | Science |

---

## 2NF – Second Normal Form

* Table must be in 1NF
* Every non-key column should depend on the whole primary key

**Not in 2NF:**

| StudentID | SubjectID | StudentName |
| --------- | --------- | ----------- |
| 101       | M01       | Ramya       |

**In 2NF:**

**Student Table:**

| StudentID | StudentName |
| --------- | ----------- |
| 101       | Ramya       |

**Student Details Table:**

| StudentID | SubjectID |
| --------- | --------- |
| 101       | M01       |

---

## 3NF – Third Normal Form

* Table must be in 2NF
* No indirect dependencies (non-key → non-key)

**Not in 3NF:**

| EmpID | EmpName | DeptID | DeptName |
| ----- | ------- | ------ | -------- |
| 1     | Sam     | D1     | HR       |

**In 3NF:**

**Employees Table:**

| EmpID | EmpName | DeptID |
| ----- | ------- | ------ |
| 1     | Sam     | D1     |

**Departments Table:**

| DeptID | DeptName |
| ------ | -------- |
| D1     | HR       |

---

## BCNF – Boyce-Codd Normal Form

* Table is in 3NF
* Every determinant must be a super key

**Example:**
Say, one room has only one teacher, and one teacher teaches only one subject.
But Room → Teacher, Teacher → Subject, but Room is not a super key.

**Solution:** Break the table to remove dependency problems.

---
