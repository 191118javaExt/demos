# Topics to look into for December 5 - 6
- Comparable / Comparator
- Design Patterns: Factory and Singleton
- Threads
- Reflection API
- Optional: Lambdas and Functional Programming

We will review these topics the next week

Comparable is a generic interface that can be implemented. It has methods that are used
to compare values of the current class (the one that is implementing this interface) with the type that is
declared in the generic. Objects of this class are said to be "comparable" with values of the other type.
Comparable defines a "compareTo()" method.

Comparator is a generic interface that can be implemented. It serves a similar purpose to Comparable,
except the perspective is slightly different. Comparator is an interface that would be implemented
by a specific Comparator class, such as a PersonAgeComparator, which might compare people based on their
ages (as opposed to comparing based on alphabetical order of names). Comparator defines a "compare()" method.

Factory and Singleton are what are called Design Patterns. These are ways we like to design our Java classes
so that they have some particular characteristics which are commonly used. The first one, Factory, is a Design
Pattern where the class is designed so that it simply constructs objects of whatever type is needed at a given time.
Singleton is a Design Pattern where the class is structured so there is only ever at most ONE instance of the class at a given time. We generally do this by making the only constructors private. Private constructors compile without issue, but it means
only the class itself may use the new keyword for that class. Then, a public method is created that checks to see if
an object has been created, and if not, will create one. If it has an instance already, that one is used.
Think back to the Logger class in log4j. We didn't use the new keyword. We used a static getLogger method, which
used the new keyword for us. This is an example of the Singleton Design Pattern.

Threads, as a concept, are individual lines of execution. For example, when we see an Exception occur that crashes
our application, we see "Exception in thread main". This is the primary thread of a Java application. When you run your
application, it will begin with a single thread only, named "main". We can create additional threads as well. These threads
will run concurrently/simultaneously with each other. One thread might be executing at method1, while another thread
could be executing at method2. As each Thread executes, it still executes statements in sequence, one by one, in the same
manner that we would expect our program to function. Using multiple threads is called multi-threading, and can sometimes
offer VAST improvements in performance (not always, depends on the task they are doing). The downside is that dealing
with this can be complex, and there are a host of issues that can arise when 2 threads try to interact with the same
object in memory. Note that, since each thread is a separate line of execution, each thread will get its own stack.
(Remember the stack frame? Each thread needs its own stack to have separate methods executing) But all threads will share
the same heap (where all objects are stored).

Reflection allows us to inspect and/or modify runtime attributes of classes, fields, methods, and constructors.
There are classes and interfaces to accomodate this, such as Class (mentioned earlier), Field, Method, etc.
No need to know class names at runtime. Everything can be inspected and modified at runtime.

Lambdas are effectively methods that can be declared without names, in-side another method.
This allows us to create quick methods that do something very specific, without creating a class
or any of the overhead that Java normally requires.

Functional Programming is a paradigm of programming, where you focus on creating functions
that compute something, and creating new data to return. In this paradigm, we never modify the
original data, we instead create new data that is modified, leaving the original alone. This doesn't
have a major downside since memory is so cheap. With this in mind, we like to structure things to ideally
represent EVERYTHING as immutable.
