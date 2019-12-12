--CREATE SCHEMA advanced;

DROP TABLE IF EXISTS advanced.employee;
DROP TABLE IF EXISTS advanced.department;
CREATE TABLE advanced.department (
	dept_id SERIAL PRIMARY KEY,
	name VARCHAR (10) UNIQUE NOT NULL
);

CREATE TABLE advanced.employee (
	emp_id SERIAL PRIMARY KEY,
	first_name VARCHAR (50) NOT NULL,
	last_name VARCHAR (50) NOT NULL,
	salary NUMERIC(50, 2) NOT NULL CHECK (salary > 10000) DEFAULT 30000,
	department INTEGER NOT NULL REFERENCES advanced.department(dept_id)
);

INSERT INTO advanced.department (name) VALUES ('Sales');
INSERT INTO advanced.department (name) VALUES ('HR');
INSERT INTO advanced.department (name) VALUES ('Accounting');
INSERT INTO advanced.department (name) VALUES ('Marketing');
INSERT INTO advanced.department (name) VALUES ('Technology');
INSERT INTO advanced.department (name) VALUES ('Housing');

INSERT INTO advanced.employee (first_name, last_name, salary, department)
	VALUES ('Matthew', 'Oberlies', 10001, 5);
	
INSERT INTO advanced.employee (first_name, last_name, salary, department)
	VALUES ('Avril', 'Douglas', 100000, 3);
	
INSERT INTO advanced.employee (first_name, last_name, salary, department)
	VALUES ('Ram', 'Kb', 160000, 5);
	
INSERT INTO advanced.employee (first_name, last_name, salary, department)
	VALUES ('Larry', 'King', 10001, 1);
	
INSERT INTO advanced.employee (first_name, last_name, salary, department)
	VALUES ('Sindu', 'Ragunathram', 25000, 6);
	
INSERT INTO advanced.employee (first_name, last_name, salary, department)
	VALUES ('Avery', 'Rose', 50000, 2);
	
INSERT INTO advanced.employee (first_name, last_name, salary, department)
	VALUES ('Hari', 'Tamang', 200000, 4);

SELECT * FROM advanced.department;
SELECT * FROM advanced.employee;

-- avg or max are examples of aggregate functions
-- They reduce an entire column to a single value
-- They can be used in conjunction with the GROUP BY clause
-- to get a result of multiple averages
SELECT name, avg(salary) FROM advanced.employee INNER JOIN advanced.department
	ON advanced.department.dept_id = advanced.employee.department GROUP BY department.name;

-- You can still use these aggregate functions without the GROUP BY clause,
-- but you only have 1 value as a result
-- This prevents you from getting a result with multiple columns, if those columns
-- would have multiple rows
SELECT avg(salary) FROM advanced.employee INNER JOIN advanced.department
	ON advanced.department.dept_id = advanced.employee.department;
	
-- A scalar is a term that just means a single value
-- You can query for multiple columns, or multiple scalars, but you cannot
-- mix and match columns with scalars
SELECT max(salary), avg(salary) FROM advanced.employee INNER JOIN advanced.department
	ON advanced.department.dept_id = advanced.employee.department;
-- aggregate functions give a single result for all of the inputs
-- there are also scalar functions, which give back a result for EACH input
-- so the result will be a column, and the input will be a COLUMN

-- these scalar functions give back a column, one example just uppercases the
-- string inputs and the second calculates the cosine of the inputs
SELECT upper(first_name || ' ' || last_name) FROM advanced.employee;
SELECT cos(salary) FROM advanced.employee;