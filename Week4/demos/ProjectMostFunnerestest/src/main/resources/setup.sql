DROP TABLE IF EXISTS employee;
CREATE TABLE employee (
	id SERIAL PRIMARY KEY,
	first_name VARCHAR NOT NULL,
	last_name VARCHAR NOT NULL,
	username VARCHAR NOT NULL,
	PASSWORD VARCHAR NOT NULL,
	hire_date TIMESTAMP NOT NULL
);

CREATE OR REPLACE FUNCTION set_current_time_f()
RETURNS TRIGGER AS $$
BEGIN
   NEW.hire_date = now();
   RETURN NEW;
END;
$$ language plpgsql;

CREATE TRIGGER set_current_time
BEFORE INSERT
ON employee
FOR EACH ROW
	EXECUTE PROCEDURE set_current_time_f();

INSERT INTO employee (first_name, last_name, username, password) VALUES ('Larry', 'King', 'lking', 'secure');