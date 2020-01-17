# AOP -> Aspect Oriented Program
- Breaking down program logic into distinct cross cutting concerns
- Aspect Oriented Programming - aspect is our unit of modularity
- Aspect handles a cross cutting concerns
    - Logging, security, validation, etc.
- Annotate our class with @Aspect and @Component
    - @Aspect is an annotation we get from Aspect J which is a full AOP framework; we just use the AspectJ annotations rather than xml config

### Join Point 
- Point in application where code will be injected
- JP is represented by a method execution
- Where you **can** inject

### Point Cut
- Predicate specifies which methods will be affected
- A collection of JP's matching a particular criteria
- Where you **will** inject

### Advice 
- Code to be injected at a join point
- **What** you will inject
- Types of advice:
    - @Before - execute before JP
    - @After - executes after JP, regardless of JP's success
        - @AfterReturning - executes after JP executes successfully
        - @AfterThrowing - executes after JP throws an exception
    - @Around
        - Allows for advice to be injected before and after the JP execution
        - Most powerful type of advice and should not be used if Before or After could achieve what's needed

- Advice is associated with point cuts and run at matching join points
- JoinPoint interface can be passed into any aspect method
    - Gives access to the target object (the object being advised; this is a Spring AOP proxy object)
    - Allows us to get the JP method signature, arguments, etc.
- ProceedingJoinPoint is a subinterface of JoinPoint that can be passed into a method which handles Around advice only
    - Allows you to control if/when the join point is actually executed relative to the surrounding advice

### Types of Point Cut Expressions
- execution: most common, method execution 
    - `"execution([type] [methodSignature](..))`
    - `"execution(* doSomething())"`
    - `"execution(* set*(..))`
- within: limits to method execution within certain classes
    - `"within(com.revature.beans.*)"`
- this: limits matching to jp's where the AOP proxy being advised
- target: limits matching to jp's where the target object is being proxied 
- args: limits matching to jp's where arguments are instances of the given types

# AOP Timer Challenge
- Write an aspect to time methods