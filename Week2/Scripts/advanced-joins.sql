SELECT * FROM album;

SELECT * FROM album INNER JOIN artist ON album."ArtistId" = artist."ArtistId";

SELECT * FROM invoice INNER JOIN (
		SELECT * FROM employee INNER JOIN 
		customer ON employee."EmployeeId" = customer."SupportRepId")  AS result1
	ON invoice."CustomerId" = result1."CustomerId";

SELECT * FROM (
		SELECT * FROM (
			employee e1 INNER JOIN employee e2 ON
				e1."EmployeeId" = e2."ReportsTo") AS result1
		 INNER JOIN customer ON result1."EmployeeId" = customer."SupportRepId") AS result2
	INNER JOIN invoice ON invoice."CustomerId" = result2."CustomerId";

SELECT * FROM invoice INNER JOIN (
	(customer INNER JOIN employee ON employee."EmployeeId" = customer."SupportRepId"
	) AS result1 INNER JOIN employee ON result1."ReportsTo" = employee."EmployeeId")
		AS result2 ON invoice."CustomerId" = result2."CustomerId" ORDER BY "InvoiceId" DESC;

SELECT * FROM invoice INNER JOIN (
	(customer INNER JOIN employee ON employee."EmployeeId" = customer."SupportRepId"
	) AS result1 INNER JOIN employee ON result1."ReportsTo" = employee."EmployeeId")
		AS result2 ON invoice."CustomerId" = result2."CustomerId" ORDER BY "InvoiceId" DESC;

SELECT * FROM invoice;
SELECT * FROM customer WHERE "FirstName" = 'Aaron';
SELECT * FROM employee;