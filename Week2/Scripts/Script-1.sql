
DROP TABLE IF EXISTS employee CASCADE;

-- This is the syntax to create a table
-- The SERIAL datatype will be automatically generated for us, and will be
-- incremented by 1 each time
CREATE TABLE employee (
	emp_id SERIAL PRIMARY KEY,
	first_name VARCHAR (50) NOT NULL,
	last_name VARCHAR (50) NOT NULL,
	email VARCHAR (100),
	-- NUMERIC is a decimal valued numeric type
	-- The 50 represents the total number of digits, and the 2 represents
	-- the number of digits in the fraction part
	salary NUMERIC(50, 2) DEFAULT 0,
	supervisor INTEGER
);

-- We can declare constraints in line like above
-- Or we can alter the table to add constraints
-- Below, we created a constraint named 'supervisor_employee_fk' which is the foreign
-- key from supervisor to emp_id in employee table
ALTER TABLE employee
	ADD CONSTRAINT supervisor_employee_fk
	FOREIGN KEY (supervisor) REFERENCES employee (emp_id);
	
-- This is a SQL comment
-- It will be ignored by the SQL editor

DROP TABLE IF EXISTS phonenumber;

CREATE TABLE phonenumber (
	phone_id SERIAL PRIMARY KEY,
	emp_id INTEGER NOT NULL REFERENCES public.employee (emp_id),
	home VARCHAR (20),
	mobile VARCHAR (20),
	work VARCHAR (20)
);

SELECT * FROM employee;

INSERT INTO employee (first_name, last_name, email, salary)
	VALUES ('Larry', 'King', 'larry@gmail.com', 10000);
	
CREATE SCHEMA project0;

CREATE TABLE project0.employee (
	id SERIAL PRIMARY KEY,
	name VARCHAR (150) NOT NULL
);

SELECT * FROM public.employee;

SELECT * FROM project0.employee;

DROP TABLE project0.employee;

DROP SCHEMA project0;

-- The below statement does not work, since the project0 schema no longer exists
--CREATE TABLE project0.employee (
--	id SERIAL PRIMARY KEY,
--	name VARCHAR (150) NOT NULL
--);

INSERT INTO employee (first_name, last_name, email, salary)
	VALUES ('Sue', 'Queen', 'sue@gmail.com', 1000000);
	
-- We will update Larry's supervisor to employee 2, which is Sue Queen
UPDATE employee SET supervisor = 2 WHERE emp_id = 1;

SELECT * FROM employee;

SELECT first_name || ' ' || last_name as full_name FROM employee WHERE salary > 10000;

--DELETE FROM employee WHERE first_name = 'Larry';

SELECT * FROM employee;

INSERT INTO phonenumber (emp_id, home, mobile)
	VALUES (1, '867-5309', '(604) 222-9192');
	
SELECT * FROM phonenumber;

INSERT INTO phonenumber (emp_id, mobile, work)
	VALUES (2, '555-5551', '555-5555 x55');
	
SELECT * FROM phonenumber;

-- ORDER BY clause which allows you to declare a column which you
-- will order the results by, you can choose ascending or descending
-- ascending is default
SELECT * FROM employee ORDER BY salary DESC;