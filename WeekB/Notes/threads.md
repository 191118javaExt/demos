# Threads

- A `Thread` is a line of execution
- Other threads can be created and managed
  - Multiple concurrent threads is referred to as multithreading
- They are not *truly* simultaneous, as a single CPU core can only perform 1 action at a time
  - The CPU just switches between the threads very rapidly that it appears simultaneous
  - However, most computers have hardware that makes multiple threads *very* efficient
- Note that the `synchronized` keyword is important for threads

## Main Thread

- Java applications *always* begin with 1 thread named `main`
- The first method on the stack is `public static void main(String[])`

## Other Threads

- Each thread gets its own **stack**
- The first method on the stack is `void run()` method
- Two ways to create Threads
  - Extending the `Thread` class
  - Implementing the `Runnable` interface
- Should override the `run` method
- Start the new thread by calling `start` method
  - Note that as the developer, you do not have control over when threads are given CPU cycles
  - This is chosen by the JVM Thread Scheduler

### Useful Methods

- `start`
- `wait`
- `notify`
- `notifyAll`
- `sleep`
  - Static method for the `Thread` class
- `setPriority`
- `setDaemon`

## Thread States

- There are 6 different thread states
  - NEW
  - RUNNABLE
  - BLOCKED
  - WAITING
  - TIMED_WAITING
  - TERMINATED
    - Cannot restart thread

## Thread Priorities

- Threads can be given a priority ( 1 - 10 ) that the scheduler will take into account
- 5 is the default priority
- Higher value means higher priority
- Use `setPriority(int)` method

## Daemon vs User Thread

- 2 kinds of threads: daemon and user
- **Daemon** threads are meant to indicate small background processes
  - The Java garbage collector is a daemon thread
- use `setDaemon(boolean)` method
- The JVM terminates when there are no more **user** threads

## Producer-Consumer Problem

- A commonly considered problem for threads
- There is a common buffer of limited size
- Producer threads add values to the buffer
  - Producer threads die if the buffer is full when they try to add
- Consumer threads remove values from the buffer
  - Consumer threads die if the buffer is empty when they try to remove
- The solution is to have the producer threads wait if the buffer is full and the consumer threads wait if the buffer is empty
- The other type will wake them up when it is appropriate
