# Database Anomalies and the Need for Normalization:
(Student Database Example)

## 1. Introduction:

In relational database design, *anomalies* are problems that arise when data is redundantly stored or not properly structured. These anomalies can lead to inconsistency, loss of data, and unnecessary complexity. *Normalization* is the process used to organize a database into well-structured tables to minimize these issues.

## 2. Types of Anomalies:

### 2.1 Insertion Anomaly

Occurs when certain attributes cannot be inserted into the database without the presence of other attributes.

*Example:*  
Consider a table storing information about students and their enrolled courses:

| StudentID | StudentName | CourseCode | CourseName |
|-----------|-------------|------------|------------|
| 101       | Ravi Kumar  | CS101      | DBMS       |
| 102       | Asha Singh  | MA203      | Calculus   |

Suppose a new course “AI101: Artificial Intelligence” is to be offered but no student has enrolled yet.

- *Issue:* Cannot insert ("", "", "AI101", "Artificial Intelligence") as StudentID and StudentName are mandatory, leading to insertion anomaly.

### 2.2 Update Anomaly

Occurs when a single update must be made in multiple places, causing data inconsistency.

*Example:*  
If “DBMS” is renamed to “Database Management Systems”, we must update every row where CourseCode is "CS101".

- *Issue:* If one row is updated but others are not, database becomes inconsistent.

### 2.3 Deletion Anomaly

Occurs when deletion of data representing certain facts accidentally causes loss of completely unrelated data.

*Example:*  
If Ravi Kumar (StudentID 101) drops out and his entire record is deleted:

| StudentID | StudentName | CourseCode | CourseName |
|-----------|-------------|------------|------------|
| 101       | Ravi Kumar  | CS101      | DBMS       |

- *Issue:* Information about the course “CS101: DBMS” is lost as well, even though the course still exists.

## 3. Need for Normalization:

To minimize or eliminate these anomalies, we use *Normalization*. This process divides larger tables into smaller, related tables and links them using keys.

### 3.1 Normalized Student Database

#### Student Table

| StudentID | StudentName   |
|-----------|--------------|
| 101       | Ravi Kumar   |
| 102       | Asha Singh   |

#### Course Table

| CourseCode | CourseName                  |
|------------|----------------------------|
| CS101      | Database Management Systems|
| MA203      | Calculus                   |

#### Enrollment Table

| StudentID | CourseCode |
|-----------|------------|
| 101       | CS101      |
| 102       | MA203      |

*Benefits:*  
- *Insertion*: Can add new courses or students without needing the other’s information.
- *Update*: Changing a course name is done in one place (Course table).
- *Deletion*: Deleting a student does not remove course information.


