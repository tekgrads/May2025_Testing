CREATE TABLE `employees` (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(100) DEFAULT NULL,
  `department` varchar(100) DEFAULT NULL,
  `salary` decimal(10,2) DEFAULT NULL,
  PRIMARY KEY (`id`)
);


INSERT INTO employees (name, department, salary) VALUES ('Alice Johnson', 'HR', 55000.00);
INSERT INTO employees (name, department, salary) VALUES ('Bob Smith', 'IT', 72000.00);
INSERT INTO employees (name, department, salary) VALUES ('Charlie Davis', 'Finance', 68000.00);
INSERT INTO employees (name, department, salary) VALUES ('Diana Green', 'IT', 75000.00);
INSERT INTO employees (name, department, salary) VALUES ('Ethan Brown', 'Sales', 60000.00);
INSERT INTO employees (name, department, salary) VALUES ('Fiona White', 'HR', 53000.00);
INSERT INTO employees (name, department, salary) VALUES ('George King', 'Finance', 70000.00);
INSERT INTO employees (name, department, salary) VALUES ('Hannah Lee', 'Marketing', 59000.00);
INSERT INTO employees (name, department, salary) VALUES ('Ian Black', 'Sales', 61000.00);
INSERT INTO employees (name, department, salary) VALUES ('Julia Adams', 'Marketing', 62000.00);