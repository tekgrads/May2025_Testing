create database employee;

use employee;

CREATE TABLE employees ( id INT NOT NULL,
name VARCHAR(100) NOT NULL
);

CREATE TABLE users (
username VARCHAR(50) UNIQUE, email VARCHAR(100) UNIQUE
);

CREATE TABLE products ( name VARCHAR(100),
status VARCHAR(20) DEFAULT 'in_stock'
);

INSERT INTO products (name) VALUES ('Laptop');

INSERT INTO products (name, status) VALUES ('Mobile Phone', 'out_of_stock');

select * from products;


CREATE TABLE accounts ( id INT,
balance DECIMAL(10,2) CHECK (balance >= 0)
);

INSERT INTO accounts (id, balance) VALUES (1, 1000.00);
INSERT INTO accounts (id, balance) VALUES (2, 250.50);
INSERT INTO accounts (id, balance) VALUES (3, 0.00);
INSERT INTO accounts (id, balance) VALUES (4, 99999.99);

select * from accounts;

-- This will raise an error because balance is negative
INSERT INTO accounts (id, balance) VALUES (5, -100.00);

CREATE TABLE students (
roll_no INT PRIMARY KEY,
age INT CONSTRAINT chk_age CHECK (age >= 5), email VARCHAR(100) UNIQUE
);





