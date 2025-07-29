# Differences between Clustered Index and Non Clustered and what are index:


##  What Are Indexes?

*Definition:*  
An index in a database is a data structure that improves the speed of data retrieval operations by helping the database engine quickly locate the rows in a table based on values in one or more columns. Think of it like the index in a book: instead of reading every page, you use the index to find exactly where a topic appears.

- *Purpose:* Speeds up queries, especially on large tables.
- *Data Structure:* Often implemented as B-trees.
- *Trade-off:* Consumes extra storage space and can slow down write operations (INSERT, UPDATE, DELETE), since indexes need to be updated too.

*Analogy:*  
Just as an index at the back of a textbook helps you find topics instantly without searching every page, a database index helps you find data fast without scanning every row[1][2][3][4].

##  Types of Indexes:

The two most common types are *Clustered* and *Non-Clustered* indexes.

##  Clustered Index:

- *Stores table rows in sorted order based on the index column(s).*
- *There can be only ONE clustered index per table* because the data rows themselves can only be sorted in one order.
- By default, the primary key of a table is often used as the clustered index[5][6][7].
- *Physical data order* in the database stays matched to the clustered index.

### Example:  
Suppose a Student table is sorted by StudentID (which is the clustered index):

| StudentID (clustered) | Name      | Age |
|-----------------------|-----------|-----|
| 101                   | Asha      | 20  |
| 102                   | Bharat    | 21  |
| 103                   | Chitra    | 22  |

Data is stored on disk in the order of StudentID.

##  Non-Clustered Index:

- *Has a separate structure from the actual table data.*
- DOES NOT affect the physical order of table rows – it maintains a logical order of the indexed data.
- *Multiple non-clustered indexes can be created on a single table.*
- Points (via references or pointers) to the location of the data row in the table[5][6][7].
- Useful for searching or filtering on columns other than the primary key.

### Example:  
For the above table, a non-clustered index could be created on the Name column.

- The index holds Name values in order with pointers to the row where actual data is stored.
- You can have non-clustered indexes on Age, Class, or any column needed for fast searching.

##  Major Differences: Clustered vs Non-Clustered Index:

| Feature                       | Clustered Index                                                | Non-Clustered Index                                        |
|-------------------------------|---------------------------------------------------------------|------------------------------------------------------------|
| *Data Storage*              | Table rows sorted by index; index and data in same structure   | Separate from table; index contains pointers to table rows  |
| *Number per Table*          | Only one                                                      | Multiple (up to 999 in SQL Server, varies in DBMS)         |
| *Impact on Physical Order*  | Alters physical row order                                      | Does not change actual row order in table                  |
| *Speed*                     | Faster for range/sorting queries                              | Faster for individual value lookups                        |
| *Use Case*                  | Primary key or the column accessed most often                  | Secondary columns for frequent searching/filtering          |
| *Leaf Nodes*                | Contain actual data                                           | Contain key and row locator (pointer)                      |
| *Storage Requirement*       | No extra storage beyond table                                 | Requires extra disk space for index                        |
| *Default On*                | Primary key (usually)                                         | Any key/column                                             |

##  Simple Example Queries:

*Create a Clustered Index (usually automatic on primary key):*
sql
CREATE TABLE Student (
  StudentID INT PRIMARY KEY, -- this becomes clustered index
  Name VARCHAR(50),
  Age INT
);


*Create a Non-Clustered Index:*
sql
CREATE INDEX idx_name ON Student(Name);

