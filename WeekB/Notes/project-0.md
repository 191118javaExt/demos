# Project 0: Banking App

### Part 1
**Description**

Leveraging Java 8, create an application that simulates simple banking transactions

**Requirements**
*	Build the application using Java 8
*	All interaction with the user should be done through the console using the `Scanner` class
*	Customers of the bank should be able to register with a username and password, and apply to open an account.
*	Once the account is open, customers should be able to withdraw, deposit, and transfer funds between accounts
  * All basic validation should be done, such as trying to input negative amounts, overdrawing from accounts etc.
*	Employees of the bank should be able to view all of their customers information. This includes:
  * Account information
  * Account balances
  * Personal information
*	Employees should be able to approve/deny open applications for accounts
*	Bank admins should be able to view and edit all accounts
  * This includes:
  * Approving/denying accounts
  * withdrawing, depositing, transferring from all accounts
  * canceling accounts
*	Reasonable test coverage is expected using JUnit (for important methods written by yourself)
  * Recommend using TDD (Test Driven Development) as it generally makes your application better
*	Logging should be accomplished using Log4J
  * All transactions should be logged

### Part 2
**Requirements**
* Create an SQL script that will create a user in an SQL database and a table schema for storing your bank users and account information.
* Your database should include at least 1 stored procedure/function.
* Have your bank application connect to your SQL database using JDBC and store all information that way.
* You should use the DAO design pattern for data connectivity.
