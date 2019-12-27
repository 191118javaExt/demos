# Miscellaneou Topics

Here are a few extra topics that I left as room for you to explore on your own.

## RETURNING clause

RETURNING is an optional clause on INSERT, DELETE, and UPDATE, used to return data from modified row.

Example: Returning the ID of a newly inserted record

```SQL
CREATE OR REPLACE TABLE items (
  id SERIAL PRIMARY KEY,
  name VARCHAR,
  created TIMESTAMP WITH TIME ZONE DEFAULT NOW()
);

INSERT INTO items (name) values ('bear') RETURNING id, created;
```

## HAVING clause

Similar to the WHERE clause, the HAVING clause allows you to specify a condition on the query. The difference lies in the use of the GROUP BY clause. The WHERE clause is used to specify conditions on individual rows *before* GROUP BY, whereas the HAVING clause specifies conditions on the grouped rows *after* the GROUP BY.

Example: Selecting only customers that have a sum total of more than $200 across all transactions.

```SQL
CREATE OR REPLACE TABLE payments (
  payment_id SERIAL PRIMARY KEY
  customer_id INTEGER,
  staff_id INTEGER,
  rental_id INTEGER,
  amount NUMERIC(50, 2)
)

SELECT customer_id, SUM (amount) FROM payments
  GROUP BY customer_id
  HAVING SUM (amount) > 200;
```

## Set Operations

Set operations, such as INTERSECT, UNION, or UNION ALL are similar to joins in the way that they combine information from multiple tables. However the way they go about that is quite different. As we saw previously, joins combine tables through one column. INNER joins grab only overlapping records. Then the result is constructed out of all columns from *both* tables. Set operations will combine information, but the result doesn't include all columns. First of all, in order for a Set operation to work, both tables must have the same number of columns, and those columns must have the same types.
For example, if one table has 3 columns, which are two INTEGER columns and a VARCHAR column, then the set operation would only work if the second table also had only 3 columns, specifically two INTEGER columns and a VARCHAR column. INTERSECT is similar to INNER JOIN, the result includes only the records that had overlapping values. UNION is similar to OUTER JOIN, except repeated results are ignored. If there would be multiple records in the result that have the same value, the duplicates are removed. UNION ALL is exactly the same as UNION, except it keeps the duplicates.

## Wildcards

SQL has a LIKE clause, which is used with the WHERE clause. It allows you to use wild cards to find records that have strings of text that are *similar* to the input, following a Regular Expression-like syntax. There are 2 wildcards, % (Percent) and _ (Underscore). The first wildcard, %, takes the place of any number of characters in a string. It represents 0, 1, or many characters. The second wildcard, _, is used to represent exactly 1 character.

Examples: Finding Customers whose name starts with A or Finding Customers whose name is only 1 letter off from Alex

```SQL
SELECT * FROM customers WHERE LOWER(first_name) LIKE 'A%';
SELECT * FROM customers WHERE LOWER(first_name) LIKE 'Ale_';
```

You can also use the NOT keyword just before LIKE to find records that do not match the pattern.

```SQL
SELECT * FROM customers WHERE LOWER(first_name) NOT LIKE 'A%';
SELECT * FROM customers WHERE LOWER(first_name) NOT LIKE 'Ale_';
```
