# User input

- Input can be retrieved in many manners, but the simplest is to read it from the console
  - The `Scanner` class from `java.util` can accomplish this conveniently
  - `Scanner s = new Scanner(System.in)`
- Can be used on any InputStream object but `System.in` is the one synced to the console
- methods:
  - `next`: Reads next token from input
  - `hasNextInt` (and similar): Determines if the next token can be parsed to Int
    - Or to the corresponding wrapper class if a different type is used
  - `nextLine`: Reads next line from input
  - `findInLine`: Can search for pattern in next input line, returns the matched portion of the input
  - `close`: Close the resource
- This input can be parsed into different primitive values as well by using wrapper classes
- Each wrapper class has methods such as `Integer.parseInt(String)`
  - This way you can read in values needed to construct more complex objects
- Using `Scanner` is a simple way to create interaction with a user
- Later you will see more modern means of user interaction
