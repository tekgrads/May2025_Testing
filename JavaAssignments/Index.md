# 📚 Indexes in SQL and Differences between Clustered & Non-Clustered Indexes

---

## 🔍 What is an Index?

An **Index** in SQL is a **database object** used to speed up the **retrieval of rows** from a table, just like an index in a book helps quickly locate a topic.

### 🧠 Why Use Indexes?

- ⚡ Faster SELECT queries
- 📈 Better performance on large tables
- 🔍 Avoid full table scans

> 🔔 **Note**: Indexes consume **extra storage** and can **slow down INSERT/UPDATE/DELETE** operations due to maintenance overhead.

---

## 🧱 Types of Indexes

### 1. Clustered Index

- Determines the **physical order** of data in a table
- Each table can have **only one** clustered index
- Data **rows are stored in the index itself**

📌 Example: Phonebook arranged alphabetically by name — the data follows the same order as the index

---

### 2. Non-Clustered Index

- **Separate structure** that stores a copy of indexed columns and a **pointer** to actual data
- Table can have **multiple** non-clustered indexes
- Data is **not physically sorted** by this index

📌 Example: Index at the back of a textbook — points to pages where the content exists

---

## 🔄 Syntax for Creating Indexes

```sql
-- Clustered Index (usually created by default on Primary Key)
CREATE CLUSTERED INDEX idx_emp_id
ON employees(id);

-- Non-Clustered Index
CREATE NONCLUSTERED INDEX idx_emp_name
ON employees(name);
```

---

## 🆚 Difference Table: Clustered vs Non-Clustered Index

| Feature                  | Clustered Index                        | Non-Clustered Index                        |
|--------------------------|----------------------------------------|--------------------------------------------|
| Data Storage             | Data is stored **in the index itself** | Index stores **pointers** to actual data   |
| Sorting                  | Physically **sorts** the table data    | Does **not** affect physical order         |
| Count Allowed            | Only **1 per table**                   | **Multiple** allowed per table             |
| Speed                    | **Faster** for range queries           | Slightly **slower**                        |
| Use Case                 | Efficient for **primary key lookups**  | Efficient for **searches on other columns**|
| Storage                  | Requires more **restructuring**        | Takes **additional** storage               |

---

## 🧠 When to Use Which?

- ✅ Use **Clustered Index** when:
  - Your queries mostly use **range-based searches**
  - You are retrieving **sorted data**

- ✅ Use **Non-Clustered Index** when:
  - You often search on **non-primary columns**
  - You need **multiple indexes** on different columns

---

> 🧩 Indexes are essential for improving database performance but must be used wisely to balance speed vs. storage & maintenance overhead.

