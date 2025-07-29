# 🛡️ SQL Injection


**SQL Injection** is a method used by attackers to insert harmful SQL commands into a database query through user input fields (like forms),  
to access or damage data stored in a DBMS.

---

## 🚨 Simplified Meaning
An attacker "injects" fake SQL code into a website’s input box to trick the database into running unwanted actions —  
like logging in without a password or deleting important data.

---

## ❗ Why It's Dangerous
- Can leak private data  
- Can delete or change records  
- May even crash the database  

---

## ✅ Simple Ways to Prevent SQL Injection
- Use **prepared statements** (parameterized queries)  
- **Validate and sanitize** all user inputs  
- Limit **database permissions** for web users  

---

## 🧪 Example

```sql
CREATE DATABASE users;
USE users;

CREATE TABLE users (
   id INT PRIMARY KEY AUTO_INCREMENT,
   username VARCHAR(50),
   password VARCHAR(50)
);

INSERT INTO users (username, password) VALUES
('sowmya', '123'),
('ramya', '345'),
('navya', '678');

SELECT * FROM users;
SELECT * FROM users WHERE username = 'sowmya' AND password = '123';
-- SQL Injection Attack Now suppose the attacker tries:
-- username: ' OR 1=1 --
-- password: (leave blank)
-- these sql becomes as
SELECT * FROM users WHERE username = '' OR 1=1   
-- ' AND password = '';

--   The query returns all rows, logging the attacker in as the first user, likely the sowmya

-- prevent sql injection we can use prepared statement
PREPARE stmt FROM 'SELECT * FROM users WHERE username = ? AND password = ?';
SET @u = 'sowmya';
SET @p = '123';
EXECUTE stmt USING @u, @p;


```