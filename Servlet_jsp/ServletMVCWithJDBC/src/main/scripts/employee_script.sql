create database tekgrads;
use tekgrads;
CREATE TABLE employee (
    id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(100),
    age INT,
    salary DOUBLE,
    city VARCHAR(100),
    profession VARCHAR(100),employeeemployee
    project VARCHAR(100)
);

CREATE TABLE employee_tasks (
    id INT AUTO_INCREMENT PRIMARY KEY,
    employee_id INT,
    task VARCHAR(255),
    FOREIGN KEY (employee_id) REFERENCES employee(id)
);