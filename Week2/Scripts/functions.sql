/*
	There is a SQL construct called a stored procedure or a function. Some SQL
	dialects have 1 or both. For example, OracleSQL has both, and there are fairly
	significant differences between them. However, in PostgreSQL, there are really
	only just functions. Stored Procedures are effectively just functions that don't
	return anything. PostgreSQL accomplishes this with the 'void' return type with
	functions.
	
	Due to some differences in basic SQL syntax compared to PostgreSQL, as well as
	backwards compatibility, there are some syntax keywords that reference PROCEDURE,
	but don't worry. It still just means functions for PostgreSQL.
	
	Each dialect does have slightly different syntax for declaring stored procedures/
	functions, but here is how we do so for PostgreSQL.
*/

-- Use CREATE OR REPLACE if you want to rerun this script multiple times
CREATE OR REPLACE FUNCTION get_current_time() RETURNS TIME WITH TIME ZONE
AS
$$
	-- current_time is a built in value, that is just the current time
	-- and we do not need a RETURN statement, since the function will
	-- return the last statement's result by default
	SELECT current_time;
$$ LANGUAGE SQL;

SELECT get_current_time();

CREATE OR REPLACE FUNCTION get_string_literal() RETURNS VARCHAR(40)
AS
$func$
	SELECT 'Hello World!';
$func$ LANGUAGE SQL;

SELECT get_string_literal();

SELECT SUBSTRING("FirstName", 1, 1) || SUBSTRING("LastName", 1, 1) FROM customer;

CREATE OR REPLACE FUNCTION get_initials(customer_id INTEGER) RETURNS VARCHAR(2)
AS
$$
	SELECT SUBSTRING("FirstName", 1, 1) || SUBSTRING("LastName", 1, 1)
		FROM employee WHERE "EmployeeId" = customer_id;
$$ LANGUAGE SQL;

SELECT get_initials(2);

SELECT get_initials("CustomerId") FROM customer;

CREATE OR REPLACE FUNCTION employees_before_year(year INTEGER) RETURNS SETOF employee
AS
$$
	SELECT * FROM employee WHERE EXTRACT(YEAR FROM "BirthDate") < year;
$$ LANGUAGE SQL;

SELECT * FROM employees_before_year(1970);

SELECT get_initials("EmployeeId") FROM employees_before_year(1970);

SELECT SUBSTRING("FirstName", 1, 1) || SUBSTRING("LastName", 1, 1) FROM employee
	WHERE EXTRACT(YEAR FROM "BirthDate") < 1970;

CREATE OR REPLACE FUNCTION employee_name() RETURNS TABLE(
	first_name VARCHAR(30),
	last_name VARCHAR(30)
) AS
$$
	SELECT "FirstName", "LastName" FROM employee;
$$ LANGUAGE SQL;

SELECT * FROM employee_name();