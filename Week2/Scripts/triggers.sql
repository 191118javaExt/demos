/*
	Triggers will perform some task (a function) in response to
	UPDATEs, INSERTs, and DELETEs on the DB or table.
	We can set these triggers up to perform their task BEFORE, AFTER, or INSTEAD OF
	Note that INSTEAD OF is limited to work on Views
*/

-- This is called a trigger function
-- It can take no parameters and must return a trigger
CREATE OR REPLACE FUNCTION skip_delete_invoice_too_expensive() RETURNS TRIGGER
AS
$$
	BEGIN
		-- RAISE keyword is used to cause exception-like events in SQL
		RAISE 'Deleting expensive invoices is prohibited';
	END;
$$ LANGUAGE plpgsql;

-- plpgsql stands for Procedural Language PostgreSQL
-- it IS an entire programming LANGUAGE built INTO Postgres

DROP TRIGGER IF EXISTS prevent_expensive_invoice_deletion ON invoice;
CREATE TRIGGER prevent_expensive_invoice_deletion
BEFORE DELETE
ON invoice
FOR EACH ROW -- This operates BY record INSTEAD OF BY STATEMENT.
			 -- alternatively, there IS FOR EACH STATEMENT
		-- IN Triggers, we have ACCESS TO SOME special TABLES CALLED
		-- OLD AND NEW. They represent the OLD VERSION OF the row AND
		-- the NEW VERSION. Note that DELETE does NOT have NEW
		-- AND INSERT does NOT have OLD
	WHEN (OLD."Total" > 20) -- IF the total IS MORE than $20
		EXECUTE PROCEDURE skip_delete_invoice_too_expensive();

SELECT * FROM invoice;

-- Trigger our Trigger and will cause our exception
DELETE FROM invoice WHERE "InvoiceId" = 96;

