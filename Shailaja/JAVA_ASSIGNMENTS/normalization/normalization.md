Database Normalization – Simplified Notes
Normalization is a process in relational database design used to:

✅ Eliminate data redundancy

✅ Avoid anomalies during data operations

✅ Maintain data integrity

✅ Organize data efficiently

🎯 Goals of Normalization
Goal	Description
Reduce Redundancy	Avoid storing the same data in multiple places
Avoid Anomalies	Prevent update, insert, and delete anomalies
Simplify Queries	Makes querying easier and faster
Maintain Consistency	Ensure data integrity and reduce conflicts

🔢 Normal Forms (NF)
Each normal form addresses a specific kind of redundancy or dependency. Let’s understand each step-by-step:

1️⃣ First Normal Form (1NF)
Rules:

Each cell must hold atomic (indivisible) values.

All rows must be unique.

No repeating columns or arrays.

📌 Example: Before 1NF

StudentID	Name	Subjects
1	Alice	Math, Science

✅ After 1NF

StudentID	Name	Subject
1	Alice	Math
1	Alice	Science

2️⃣ Second Normal Form (2NF)
Rules:

Must be in 1NF

No partial dependency (non-key attributes must depend on the whole composite key)

Partial Dependency = When an attribute depends on part of a composite key, not the whole key.

📌 Example: Before 2NF

StudentID	CourseID	StudentName	CourseName
1	101	Alice	Math

Here, StudentName depends only on StudentID.

✅ After 2NF

Students Table

StudentID	StudentName
1	Alice

Courses Table

CourseID	CourseName
101	Math

Enrollments Table

StudentID	CourseID
1	101

3️⃣ Third Normal Form (3NF)
Rules:

Must be in 2NF

No transitive dependency: Non-key attributes should not depend on other non-key attributes

Transitive Dependency = A → B → C implies A → C indirectly

📌 Example: Before 3NF

EmployeeID	Name	DeptID	DeptName
1	Alice	10	HR

Here, DeptName depends on DeptID, not directly on EmployeeID.

✅ After 3NF

Employees Table

EmployeeID	Name	DeptID
1	Alice	10

Departments Table

DeptID	DeptName
10	HR

4️⃣ Boyce-Codd Normal Form (BCNF)
Rules:

Must be in 3NF

For every functional dependency A → B, A must be a super key

Stronger version of 3NF — handles exceptions not covered by 3NF.

5️⃣ Fourth Normal Form (4NF)
Rules:

Must be in BCNF

No multi-valued dependencies: An attribute should not have multiple independent values for a single entity

📌 Example:

StudentID	Hobby	Language
1	Painting	English
1	Painting	French
1	Dancing	English
1	Dancing	French

Should be split into:

StudentHobbies

StudentLanguages

6️⃣ Fifth Normal Form (5NF)
Rules:

Must be in 4NF

No join dependencies: A relation should be reconstructible from its projections without losing information

Used in complex relational structures, rarely applied in day-to-day scenarios.

📊 Normalization Summary Table
Normal Form	Key Rule	Removes
1NF	Atomic values, no repeating columns	Repeating groups
2NF	No partial dependencies	Partial dependency
3NF	No transitive dependencies	Transitive dependency
BCNF	Every determinant is a candidate key	Anomalies not covered by 3NF
4NF	No multi-valued dependencies	Multivalued dependency
5NF	No join dependencies	Join anomalies

🚨 Anomalies Handled by Normalization
Anomaly	Description
Update Anomaly	Change in one place must be updated everywhere
Insert Anomaly	Cannot insert data due to missing required fields
Delete Anomaly	Deleting data causes unintended loss of related data

🔄 Denormalization (Opposite of Normalization)
In some cases (e.g., reporting, dashboards, analytics), denormalization is applied to:

Improve read performance

Allow faster queries

Reduce need for joins

⚠️ Comes with a trade-off: increased redundancy and potential inconsistency

🔁 Normalize when you need consistency and clean design
⚡ Denormalize when you prioritize performance and faster access