# Testing

There are different kinds of testing, some are small scale with many tests, down to a few very comprehensive tests.

- Unit Tests
  - Most micro level of testing
  - Test each component standalone without dependencies
  - Usually requires mocking with a library like Mockito
  - Unit Testing examples: JUnit and TestNG
- Integration Tests
  - Test components with dependencies
  - Components work with each other correctly
  - Logically related modules are tested as a group
  - Ex: Selenium
- System Tests
  - Test the entire application as a whole
  - Make sure the entire application works without errors
- UAT: User Acceptance Tests
  - Test that all requirements/user stories are met
  - Simulate the end-user to guarantee that users can actually use the features that should be available

## JUnit

- Java unit testing library to create test classes
  - Need to add dependendency separately, or use Maven to add it automatically
  - JUnit 4 or 5 can be used, but they are slightly different
  - JUnit 5 may be more powerful, as it has more configuration options, but these are for JUnit 4
- Generally make a test class for each class under test
- Generally test classes go in `src/test/java`
- In IDE, can use `Run As -> JUnit Test` to run tests
- These test classes govern setup, configuration, as well as the tests themselves
- Annotations:
  - @BeforeClass
    - Used above a static method to prepare global test environment
    - First method to be called, before class is instantiated
  - @AfterClass
    - Used above a static method to clean up any test data
    - Last method to be called
  - @Before
    - Executed before every test case (or @Test annotation)
    - Should be used to reset test instances that are used for each test
  - @After
    - Executed after every test case (or @Test annotation)
    - should be used for cleaning of instances that were used by prior tests
  - @Test
    - Is the actual test case and should either pass or fail
    - The total result summary is based off the amount of @Test there are
    - There are some options that can be added to configure specific test cases
  - @Ignore
    - Can be used with @Test for the test class to ignore a particular test

### Assertions

- Statements from JUnit library that interact with @Test annotation
- Used to determine tests as pass/fail
- Assertions:
  - `assertEquals`
  - `assertNotEquals`
  - `assertNull`
  - `assertNotNull`
  - `assertArrayEquals`
  - `assertTrue`
  - `assertFalse`

### Test Suites

- Multiple test classes can be configured to run together in a test suite class
- Uses `@RunWith` annotation to use a test runner class
  - JUnit comes with a `Suite` class that can be used
- `@SuiteClasses` annotation is used to declare which test classes are part of this test suite
- The test suite can be run just like any other test class individually

## TestNG

- TestNG is another unit testing library similar to JUnit
- It has a few more annotations to configure more intricate test groups
- It also supports using an xml configuration file
- Due to this, TestNG is considered more powerful than JUnit 4, but roughly equivalent to JUnit 5
- Annotations (in order of execution):
  - @BeforeSuite
  - @BeforeTest
  - @BeforeClass
  - @BeforeMethod
    - Repeats before each @Test
  - @Test
  - @AfterMethod
    - Repeats after each @Test
  - @AfterClass
  - @afterTest
  - @AfterSuite
- There are test groups that can be configured, running only select tests from different test classes
- Data can be provided, with tests rerunning for each set of data
