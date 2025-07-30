# Anomalies in Database

When a database is not properly normalized, it may lead to the following anomalies:

---

## 1. Insertion Anomaly

Occurs when certain data cannot be inserted into the database without the presence of other data.

**Real-Time Example:**

If a student table includes both Student and Course details, and you want to add a new course that no student has enrolled in yet, you can’t insert it unless you also enter dummy student data.

**Problem with Insertion Anomaly:**

- Leads to incomplete data entry.
- Forces the insertion of null or dummy values.

---

## 2. Updation Anomaly

Occurs when the same piece of data appears in multiple rows, and updating one instance does not automatically update others.

**Real-Time Example:**

If an instructor's phone number is repeated in multiple records, updating their number in one row but not others causes inconsistency.

**Problem with Updation Anomaly:**

- Leads to data inconsistency.
- Requires multiple updates for one change.

---

## 3. Deletion Anomaly

Occurs when the deletion of one piece of data unintentionally leads to the loss of additional data.

**Real-Time Example:**

If you delete the only student enrolled in a course, you might also lose information about the course itself.

**Problem with Deletion Anomaly:**

- Causes unintentional loss of important data.
- Hard to maintain data integrity.

---



## To Overcome This: Use Normalization helps in:

*1.Organizing data properly

*2.Eliminating redundancy (no duplicate data)

*3.Maintaining data accuracy and consistency

*4.Avoiding data loss and inconsistency

*5.Making future changes easier


**Normalization is the process of organizing data in a database to remove duplicate data and ensure data is stored efficiently.
