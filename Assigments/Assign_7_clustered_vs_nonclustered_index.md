
#  Clustered vs Non-Clustered Index in SQL

## What is a Clustered Index?
A **Clustered Index** determines the **physical order** of the data in a table. When you create a clustered index on a column, SQL Server reorders the data in the table based on that index.

- A table can have **only one** clustered index.
- Usually created on the **primary key** by default.
- The data rows are stored in the index order.

###  Clustered Index Diagram

```
Table: Employees (Clustered Index on EmployeeID)

  EmployeeID | Name   | Age
  -----------|--------|-----
  101        | cherry | 30
  102        | janu   | 25
  103        | Varun  | 28

[Clustered Index]
  101 → Row 1 (cherry)
  102 → Row 2 (janu)
  103 → Row 3 (Varun)

(Data is physically stored in order of EmployeeID)
```

---

##  What is a Non-Clustered Index?
A **Non-Clustered Index** is an index that **does not change the physical order** of the data in the table.
It is a separate structure from the data table, where the index contains a copy of the indexed columns and a pointer to the actual data.

- It stores a **copy of indexed columns** and a **pointer** to the actual data row.
- A table can have **multiple** non-clustered indexes.

###  Non-Clustered Index Diagram

```
Table: Employees (Non-Clustered Index on Name)

  EmployeeID | Name   | Age
  -----------|--------|-----
  102        | Janu   | 25
  103        | Varun  | 28
  101        | cherry | 30

[Non-Clustered Index on Name]
  cherry → Pointer to Row 3
  janu  → Pointer to Row 1
  varun → Pointer to Row 2

(Data is NOT ordered by Name, only the index is)
```

---

## Key Differences

| Feature                       | Clustered Index                          | Non-Clustered Index                        |
|-------------------------------|------------------------------------------|--------------------------------------------|
| **Data Storage**              | Data is stored in index order            | Separate index with pointers to data       |
| **Physical Order Affected?**  |  Yes                                     | No                                          |
| **Number Allowed per Table**  | 1 (only one)                             | Many                                       |
| **Use Case**                  | Sorting, range-based queries             | Searching, filtering                       |
| **Includes All Columns?**     | Yes (entire row stored)                  | No (only indexed columns + row pointer)    |

---

>  Use Clustered Index for primary key or when you often retrieve sorted data.  
>  Use Non-Clustered Index to speed up searches on other columns.
