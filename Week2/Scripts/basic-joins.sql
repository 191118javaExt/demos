--INSERT INTO phonenumber (emp_id) VALUES (3);
--DELETE FROM phonenumber WHERE emp_id = 3;
--SELECT * FROM phonenumber;

SELECT * FROM employee INNER JOIN phonenumber ON employee.emp_id = phonenumber.emp_id;

-- This statement gets all info for employees that do not have a home phone
SELECT * FROM employee INNER JOIN phonenumber ON employee.emp_id = phonenumber.emp_id WHERE home is null;

-- This statement does the same thing, except using nested queries
SELECT * FROM employee INNER JOIN (
	SELECT * FROM phonenumber WHERE home is null
) AS result1 ON employee.emp_id = result1.emp_id;

-- This gets the name and mobile phone number for all employees whose salary is greater than 500
SELECT first_name || ' ' || last_name AS full_name, mobile FROM employee INNER JOIN phonenumber ON employee.emp_id = phonenumber.emp_id
	WHERE employee.salary > 500;
	
SELECT * FROM employee INNER JOIN (
	SELECT * FROM phonenumber WHERE home is null
) AS result1 ON employee.emp_id = result1.emp_id ORDER BY employee.salary DESC;

