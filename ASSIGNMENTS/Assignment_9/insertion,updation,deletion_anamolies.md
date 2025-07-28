
# Insertion, Update, and Deletion Anomalies – Student_Course Example

## Scenario: Unnormalized `Student_Course` Table

```sql
CREATE TABLE Student_Course (
    student_id INT,
    student_name VARCHAR(50),
    course_id INT,
    course_name VARCHAR(50),
    instructor_name VARCHAR(50)
);

INSERT INTO Student_Course VALUES 
(1, 'Alice', 101, 'Maths', 'Mr. Kumar'),
(2, 'Bob',   102, 'Physics', 'Dr. Mehta'),
(3, 'Alice', 102, 'Physics', 'Dr. Mehta'),
(4, 'Charlie', 101, 'Maths', 'Mr. Kumar');
```

---

## 1. Insertion Anomaly

**Problem:**  
We want to add a new course, but no student has enrolled in it yet.

**Issue:**  
We cannot insert course data without student information, as student_id and student_name are required.

**Example:**

```sql
INSERT INTO Student_Course (course_id, course_name, instructor_name)
VALUES (103, 'Chemistry', 'Dr. Rao');
```

**Solution:**  
Separate course details into a dedicated `Course` table.

---

## 2. Update Anomaly

**Problem:**  
We want to update the instructor for the Physics course.

**Issue:**  
The instructor's name appears in multiple rows. Missing any row during update may lead to inconsistent data.

**Correct Update:**

```sql
UPDATE Student_Course
SET instructor_name = 'Dr. Sinha'
WHERE course_name = 'Physics';
```

**Incorrect Update:**

```sql
-- Only one row updated
UPDATE Student_Course
SET instructor_name = 'Dr. Sinha'
WHERE student_id = 2;
```

**Result:**  
"Physics" course ends up with multiple instructor names in different rows.

---

## 3. Deletion Anomaly

**Problem:**  
A student withdraws and is removed from the table.

**Issue:**  
If that student was the only one enrolled in a course, deleting them removes the course information as well.

**Example:**

```sql
DELETE FROM Student_Course WHERE student_id = 4;
```

If Charlie was the only student enrolled in Maths, deleting him deletes all info about Maths and Mr. Kumar.

---

## Summary Table

| Anomaly Type | Cause                                            | Risk Example                                 |
| ------------ | ------------------------------------------------ | -------------------------------------------- |
| Insertion    | Cannot insert course without a student           | Cannot add Chemistry course                  |
| Update       | Redundant data must be updated in many rows      | Inconsistent instructor name for Physics     |
| Deletion     | Deleting a student may delete course information | Maths course info lost if only student leaves |

---

## Solution: Normalize the Table

### 1. Student Table

```sql
CREATE TABLE Student (
    student_id INT PRIMARY KEY,
    student_name VARCHAR(50)
);
```

### 2. Course Table

```sql
CREATE TABLE Course (
    course_id INT PRIMARY KEY,
    course_name VARCHAR(50),
    instructor_name VARCHAR(50)
);
```

### 3. Enrollment Table

```sql
CREATE TABLE Enrollment (
    student_id INT,
    course_id INT,
    FOREIGN KEY (student_id) REFERENCES Student(student_id),
    FOREIGN KEY (course_id) REFERENCES Course(course_id)
);
```

**Benefits:**  
- You can add courses without students  
- Instructor details exist only once  
- Deleting a student does not delete course or instructor information  
- Data is consistent, scalable, and reliable
