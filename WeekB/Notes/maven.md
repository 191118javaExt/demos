# Maven

- Maven is a Java build tool that helps handle external dependencies
  - Has an online repository of many dependencies
  - Builds project
- We will create maven projects instead of Java projects in IDE
  - Has some folders already declared in classpath such as `src/main/java` and `src/main/resources`

## Managing Dependencies

- Each maven project will have a `pom.xml`
  - Project Object Model
  - This is where we declare some configurations as well as dependencies
- Dependencies are downloaded and stored in `~/.m2/repository` directory

## Maven Lifecycle

- There are 3 maven lifecycles: default, clean, and site
  - Default is what we will focus on, but know that the other 2 exist
- Default Lifecycle:
  1. Validate
      - Validate project is correct and all necessary info is available
      - Check pom.xml, parse it and locate/download dependencies
  2. Compile
      - Compile the source code
  3. Test
      - Test code using suitable unit testing framework (JUnit)
  4. Package
      - Take the compiled code and package it in its distributable format (jar or war)
  5. Integration Test
      - Process and deploy the package if necessary into an environment where integration tests can be run
  6. Verify
      - Run any checks (like results of Integration tests) to verify the package is valid and meets quality criteria
  7. Install
      - Install the package into the local repository, for use as a dependency in other projects **locally**
  8. Deploy
      - Done in integration/release environment
      - Copies the final package to **remote** repository for sharing with other developers and projects
- Each of these above steps requires all of the preceeding steps to be completed first
  - Cannot run tests if the project has not been compiled
- These steps are also commands that can be run from a command line or IDE
  - `mvn validate`, `mvn integration-test`, `mvn test`, etc
- Similarly `mvn clean` and `mvn site` are available commands
  - `clean` cleans up artifacts created by prior builds
    - Deletes `target/` or `bin/` folder contents where the compiled classes are
  - `site` generates documentation for the project
  