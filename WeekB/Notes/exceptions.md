# Exception Handling

- When an issue arises during the **runtime** of a Java application, an Exception or an Error occurs.
- Exceptions refer to those issues that can be reasonably recovered from
  - 2 types: `Checked` and `Unchecked`
  - Ex:
    - Division by zero
    - Accessed an array out of bounds
- Errors are issues that cannot be reasonably recovered from
  - Ex:
    - Some of the compiled program files are missing
- Exception handling refers to how you deal with these exceptions that can be recovered from
  - Keywords: `try`, `catch`, `finally`, `throw`, `throws`
- Exceptions offer a great way for a developer to offer information about issues that arise

## Terminology

- When an Exception or Error occurs, the current stack frame will `throw` it
- If it is not handled, then the current stack frame `throws` it to the next stack frame to handle
  - If it reaches the top of the stack frame without being handled, the program crashes
- Exceptions are said to be either `Checked` or `Unchecked` exceptions
  - `Checked` exceptions must be handled or declared as handled elsewhere if they can occur
    - The program will not compile if a checked exception is not declared as handled somewhere
      - You **can** declare that a checked exception is handled elsewhere repeatedly, all the way to the top
        - This will allow the program to compile, however if the exception occurs, the program will crash
    - Often these are about outside resources, such as if a file cannot be accessed
    - Checked exceptions are used when you know that something can go wrong, but it is not that function's place to solve it
  - `Unchecked` exceptions do not **have** to be handled, but it is still a good idea
    - The program will compile just fine if these are not declared as handled

## Class Heirarchy

- Throwable (checked)
  - Exception (checked)
    - IOException (checked)
    - RuntimeException (unchecked)
      - NullPointerException (unchecked)
  - Error
- Not exhaustive
- Any class that extends Exception (but not RuntimeException) is a checked exception
- Any class that extends RuntimeException is an unchecked exception

### Try

- Keyword to attempt a block of code, but to allow for handling in case an exception is thrown
- Must be followed by at least 1 `catch` block, or a `finally` block

        try {

        } catch (Exception e) {

        }

### Catch

- Allows you to resolve the problem
- Must specify the Exception type

        try {

        } catch (NullPointerException e) {

        }

- Can be chained together

        try {

        } catch (NullPointerException e) {

        } catch (ArithmeticException e) {

        }

Be careful, Java will not compile if you have Unreachable Code.This can happen if you try to catch a parent class before a subclass

    try {

    } catch (Exception e) {

    } catch (RuntimeException e) {

    }

The RuntimeException catch block will never be executed since RuntimeExceptions are also Exceptions, so are caught by the first catch block

### Finally

- This block will always run before continuing **no matter what**
- Must be the last block in the chain or will not compile

        try {
            System.out.println("cat");

            String s = null;
            s.length(); <-- Causes NullPointerException

            System.out.println("dog"); <-- This line is skipped

        } catch(NullPointerException e) {
            System.out.println("catch");

        } finally {
            System.out.println("finally");
        }

- Finally blocks will still run even if a second exception is thrown inside a catch block or there is a return statement
- The only way to prevent the finally block from being run is `System.exit(0)` which immediately terminates the program

### Throw

The `throw` keyword indicates that a problem is occuring now. Anything that extends `Throwable` can be thrown with this keyword

    throw new Exception();

    Exception e = new Exception();
    throw e;

### Throws

The `throws` keyword is declared on a method which indicates that if a problem occurs, it will be sent to the next stack frame to handle.
Multiple exceptions can be declared, separated by commas.

    public void methodOne() {
        try {
            methodTwo();
        } catch (Exception e) {
            // Do something
        }
    }

    public void methodTwo() throws Exception {
        throw new Exception();
    }

This keyword can be used on both `methodOne` and `methodTwo`, and even added to `main`. If main also throws an exception, the JVM will catch it and terminates the program.

### Custom Exceptions

You can create your own custom exception classes. They just need to extend `Throwable` or a sublass

    public class My Exception extends Exception {

    }

Exception has a message property that helps debug the exception

    throw new Exception("Something went wrong");

There is a constructor that can take a `Throwable` to indicate that as the *cause* of the exception.
This lets you wrap exceptions into a more appropriate one

    public class MyException extends Exception {

        public MyException(){}

        public MyException(String message) {
            super(message);
        }

        public MyException(String message, Throwable cause) {
            super(message, cause);
        }
    }
