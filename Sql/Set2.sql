CREATE DATABASE schooldb;

USE schooldb;

CREATE TABLE student ( 
id INT PRIMARY KEY, 
name VARCHAR(100),
age INT,
grade VARCHAR(10),
date_of_birth DATE
);

INSERT INTO student (id, name, age, grade, date_of_birth) VALUES (1, 'Ayesha Khan', 16, '10th', '2007-05-15');
INSERT INTO student (id, name, age, grade, date_of_birth) VALUES (2, 'Ravi Sharma', 17, '11th', '2006-03-22');
INSERT INTO student (id, name, age, grade, date_of_birth) VALUES (3, 'Meena Joshi', 15, '9th', NULL);
INSERT INTO student (id, name, age, grade, date_of_birth) VALUES (4, 'Arjun Verma', 18, '12th', NULL);

INSERT INTO student (id, name, age, grade) VALUES (15, 'Ayesha Khan', 16, '10th'),
(25, 'Ravi Sharma', 17, '11th'),
(35, 'Meena Joshi', 15, '9th'),
(45, 'Arjun Verma', 18, '12th'),
(55, 'Sara Ali', 16, '10th'),
(65, 'Karan Mehta', 17, '11th'),
(75, 'Tanya Roy', 15, '9th'),
(85, 'Vikram Singh', 18, '12th');

select * from student;

SELECT name, grade FROM student;

SELECT * FROM student WHERE grade = '10th';

SELECT * FROM student WHERE age > 16;

SELECT * FROM student WHERE date_of_birth = NULL;

SELECT * FROM student WHERE date_of_birth is NULL;

SELECT * FROM student WHERE date_of_birth is not NULL;

SELECT * FROM student WHERE grade = '10th' AND age > 15;

SELECT * FROM student WHERE grade = '9th' OR grade = '12th';


SELECT * FROM student
WHERE (grade = '10th' OR grade = '11th') AND age >= 16;


SELECT * FROM student ORDER BY age ASC;


SELECT * FROM student ORDER BY name DESC;

select * from student;

SELECT * FROM student LIMIT 5;

SELECT * FROM student LIMIT 2, 6;

SELECT * FROM student WHERE name LIKE 'A%';


UPDATE student
SET grade = '12th' WHERE id = 2;

UPDATE student
SET age = 17, grade = '10th' WHERE id = 3;


UPDATE student SET age = 18;

UPDATE student
SET grade = '10th' WHERE grade = '9th';



UPDATE student
SET age = age + 1 WHERE age < 18;

UPDATE student
SET grade = 'Unknown' WHERE grade IS NULL;

DELETE FROM student WHERE id = 2;

select * from student;


DELETE FROM student WHERE grade = '9th';

DELETE FROM student WHERE age < 16;

DELETE FROM student WHERE grade IS NULL;

SELECT @@autocommit;

SET autocommit = 0;


start transaction;

UPDATE student SET age = age + 1 WHERE age < 18;

commit;


start transaction;

UPDATE student SET grade = '10th' WHERE grade = '9th';
-- exception
rollback;


start transaction;

UPDATE student SET grade = '10th' WHERE grade = '9th';
-- exception
commit;

select * from student;

SET autocommit = 1;



SELECT CURRENT_DATE;

SELECT CURRENT_TIME;


SELECT CURRENT_TIMESTAMP;
-- or
SELECT NOW();


SELECT LOCALTIME;
SELECT LOCALTIMESTAMP;

CREATE TABLE logs (
    id INT AUTO_INCREMENT PRIMARY KEY,
    event VARCHAR(255) NOT NULL,
    created_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP
);


INSERT INTO logs (event, created_at) VALUES ('data_import', NOW());

select * from logs;