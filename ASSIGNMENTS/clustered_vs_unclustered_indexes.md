# Database Indexes 

## What is an Index?

An **index** is a database feature that improves the speed of data retrieval operations on a table.

### Simple Analogy:

Think of a **library book index**. If you want to find the page for a topic, you use the index at the back of the book rather than flipping every page.

In the same way, a **database index** lets you quickly locate the rows in a table without scanning every row.

---

## Why Use Indexes?

- To speed up SELECT queries
- To sort data faster
- To improve performance of JOINs and WHERE conditions
- To reduce full table scans

Without indexes, queries can be slow on large tables.

---

## Types of Indexes

### 1. Clustered Index

- Sorts and stores the data physically in the table based on the indexed column.
- The table can only have one clustered index.
- The rows are stored in order of the index.
- Ideal for range queries.

#### Example:

If a clustered index is on `employee_id`, the database stores the entire table in sorted order by `employee_id`.

### 2. Non-Clustered Index

- Creates a separate structure that stores the index and a pointer to the actual data row.
- A table can have many non-clustered indexes.
- Does not change the physical order of data.

#### Example:

If a non-clustered index is created on `employee_name`, it builds a separate index with names and row locations.

---

## Real-Life Example

### Employee Table:

| EmpID | Name   | Dept  |
|-------|--------|-------|
| 3     | Ravi   | HR    |
| 1     | Anjali | IT    |
| 2     | Meena  | Admin |

### Clustered Index on `EmpID`:

The table will be reordered as:

| EmpID | Name   | Dept  |
|-------|--------|-------|
| 1     | Anjali | IT    |
| 2     | Meena  | Admin |
| 3     | Ravi   | HR    |

### Non-Clustered Index on `Name`:

- A separate index like:

| Name   | Row Pointer |
|--------|-------------|
| Anjali | → Row 2     |
| Meena  | → Row 3     |
| Ravi   | → Row 1     |

---

## Key Differences: Clustered vs Non-Clustered Index

| Feature                      | Clustered Index                               | Non-Clustered Index                            |
|-----------------------------|-----------------------------------------------|------------------------------------------------|
| Storage                     | Data stored in sorted order of index column   | Separate index structure with row pointers     |
| Number per Table            | Only one                                      | Multiple allowed                               |
| Speed                       | Faster for range and sorted queries           | Good for point lookups                         |
| Data Retrieval              | Direct from table                             | Needs to follow pointer                        |
| Example                     | Index on Primary Key                          | Index on Name, Email, etc.                     |
| Use Case                    | Sorting, range-based search                   | Filtering on non-key fields                    |
| Size                        | No separate storage required                  | Requires additional storage                    |

---

## Advantages of Using Indexes

- Faster query performance
- Speeds up search conditions using WHERE, JOIN, ORDER BY
- Improves sorting and filtering
- Helps enforce uniqueness (in case of unique index)

---

## Disadvantages of Using Indexes

- Takes extra space (especially non-clustered)
- Slows down write operations (INSERT, UPDATE, DELETE)
- Needs to be maintained whenever data changes

---

## When to Use Clustered or Non-Clustered Index

| Use Case                                 | Recommended Index Type     |
|------------------------------------------|-----------------------------|
| Frequently sorted or range queries       | Clustered Index             |
| Searching non-primary key columns        | Non-Clustered Index         |
| Frequently updated columns               | Avoid indexing              |
| Enforcing uniqueness (e.g., Email)       | Unique Non-Clustered Index  |
| Composite key lookups                    | Composite (Multi-column) Index |

---


- Use indexes wisely—too many indexes can slow down write operations.
- Start with indexing primary keys and columns used in WHERE, JOIN, or ORDER BY clauses.
