# 📊 Clustered Index vs Non-Clustered Index (SQL)

## ✅ Clustered Index
- Determines the **physical order** of data in the table.
- Table data is **sorted and stored** based on this index.
- Only **one clustered index** is allowed per table.

### 📌 Real-time Example:
> A phone displays contacts in alphabetical order — the data is physically arranged by the index.

---

## ✅ Non-Clustered Index
- Creates a **separate structure** for indexed columns.
- Stores **pointers to actual data** rather than sorting table itself.
- You can have **multiple non-clustered indexes** on a table.
- Table data is **not sorted** physically by this index.

### 📌 Real-time Example:
> Like an index at the back of a textbook — it tells you where a topic appears without rearranging the book.

---

## 🔍 Differences Between Clustered and Non-Clustered Index

| Feature                      | Clustered Index                    | Non-Clustered Index                       |
|-----------------------------|------------------------------------|------------------------------------------|
| Data Storage                | Stored in physical order           | Not stored in physical order             |
| Number Allowed              | Only one per table                 | Multiple allowed                         |
| Structure                   | Stores actual data rows in index   | Has separate index with row pointers     |
| Query Speed                 | Generally faster                   | Slightly slower than clustered           |

---



>Example:
###Clustered Index (Data stored in order)
*Clustered Index on EmpID

+--------+----------+---------+
| EmpID  | Name     | Salary  |
+--------+----------+---------+
| 101    |sowmya    | 50000   |
| 102    |ramya     | 60000   |
| 103    |laxmi     | 70000   |
+--------+----------+---------+

*Data is **physically sorted** by EmpID.


###Non-Clustered Index (Pointers to data)

* Non-Clustered Index on Salary

[50000] --> Points to row with EmpID 101
[60000] --> Points to row with EmpID 102
[70000] --> Points to row with EmpID 103

* Data is NOT sorted by Salary. Index just helps in fast lookup.




Data is **not sorted** by `Salary`. Index only helps in quick lookup.

---

## 🧪 SQL Example: Clustered and Non-Clustered Index

```sql
-- Use your database
USE employeedb;

-- Clustered Index (created by PRIMARY KEY)
CREATE TABLE Employees (
    EmpID INT PRIMARY KEY,  -- Clustered index
    Name VARCHAR(100),
    Salary INT
);

-- Insert data
INSERT INTO Employees (EmpID, Name, Salary) VALUES
(101, 'sowmya', 50000),
(102, 'ramya', 60000),
(103, 'pranavi', 55000),
(104, 'navya', 70000),
(105, 'sneha', 48000);

-- View data
SELECT * FROM Employees;

-- Create a Non-Clustered Index
CREATE INDEX idx_salary ON Employees(Salary);

-- Query using Non-Clustered Index
SELECT * FROM Employees WHERE Salary > 60000;
```


