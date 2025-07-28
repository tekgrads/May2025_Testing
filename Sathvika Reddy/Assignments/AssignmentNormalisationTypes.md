# Types of Normalization in DBMS (With Student Database Examples):

Normalization is a technique in relational database design that reduces data redundancy and improves data integrity by organizing data into related tables. The process is broken into levels called normal forms (1NF, 2NF, 3NF, BCNF, etc.), each addressing specific types of data anomalies.

## 1. First Normal Form (1NF)
- *Requirement:* Each cell contains only atomic (indivisible) values. There are no repeating groups or arrays.
- *Example (Before 1NF):*

  | StudentID | StudentName | Courses         |
  |-----------|-------------|----------------|
  | 1         | Anil        | Math, Physics  |

  - Issue: The "Courses" column has multiple values.

- *Example (After 1NF):*

  | StudentID | StudentName | Course   |
  |-----------|-------------|----------|
  | 1         | Anil        | Math     |
  | 1         | Anil        | Physics  |

## 2. Second Normal Form (2NF)
- *Requirement:* Table is already in 1NF; all non-key attributes are fully functionally dependent on the entire primary key (no partial dependency).
- *Example (Before 2NF):*

  | StudentID | Course   | StudentName | CourseInstructor |
  |-----------|----------|-------------|-----------------|
  | 1         | Math     | Anil        | Dr. Patel       |
  | 1         | Physics  | Anil        | Dr. Rao         |

  - Issue: StudentName depends only on StudentID (a part of the key, if the key is (StudentID, Course)).

- *Solution (After 2NF):*
  - Separate tables:
    - *Student Table*

      | StudentID | StudentName |
      |-----------|-------------|
      | 1         | Anil        |

    - *Enrollment Table*

      | StudentID | Course   | CourseInstructor |
      |-----------|----------|-----------------|
      | 1         | Math     | Dr. Patel       |
      | 1         | Physics  | Dr. Rao         |

## 3. Third Normal Form (3NF)
- *Requirement:* Table is already in 2NF; all non-key attributes are only dependent on the primary key (no transitive dependency).
- *Example (Before 3NF):*

  | StudentID | Course   | Instructor  | InstructorPhone |
  |-----------|----------|-------------|----------------|
  | 1         | Math     | Dr. Patel   | 555-1234       |

  - Issue: InstructorPhone depends on Instructor, not directly on the primary key.

- *Solution (After 3NF):*
  - Separate "Instructor" details into a new table:

    - *Course Table*

      | Course   | Instructor  |
      |----------|-------------|
      | Math     | Dr. Patel   |

    - *Instructor Table*

      | Instructor  | InstructorPhone |
      |-------------|----------------|
      | Dr. Patel   | 555-1234       |

## 4. Boyce-Codd Normal Form (BCNF)
- *Requirement:* For every non-trivial functional dependency, the determinant must be a superkey.
- *Example:* If "Course, Instructor" together determine the classroom, but neither Course nor Instructor alone is a superkey, this structure violates BCNF. BCNF requires the table to be decomposed so each determinant is a candidate key[1][2].

## 5. Fourth Normal Form (4NF)
- *Requirement:* No multi-valued dependencies, and already in BCNF.
- *Example:* Student can have multiple hobbies and multiple languages; storing (StudentID, Hobby, Language) in a single table causes redundancy. Split into:

  - *Hobbies Table:* (StudentID, Hobby)
  - *Languages Table:* (StudentID, Language)

## 6. Fifth Normal Form (5NF)
- *Requirement:* Table is in 4NF and all join dependencies are trivial (no redundancy caused by join dependencies).
- *Example:* If student-project-mentor assignments are only meaningful as combinations, but not all combinations exist, 5NF splits the table to avoid redundancy[3][4].

## Memory Table:

| Normal Form | Key Rule                                         | Example in Student DB                                     |
|-------------|--------------------------------------------------|-----------------------------------------------------------|
| 1NF         | Atomic values, no repeating groups               | Split Courses into separate rows                          |
| 2NF         | Full functional dependence on entire primary key | StudentName split from Enrollment when using composite key|
| 3NF         | No transitive dependency                         | InstructorPhone moved to separate Instructor table        |
| BCNF        | Superkey as determinant for every dependency     | Composite keys must be candidate keys                     |
| 4NF         | No multi-valued dependencies                     | Hobbies and Languages split into separate tables          |
| 5NF         | No join dependencies                             | Data split for complex relationships to remove redundancy |