# Week 4b Study Guide

This week we only really learned Angular. You need to know Angular in far more
detail than if we learned both Servlets and Angular together in 1 week.

# Overall topics
- Angular
  - What is it? Frontend Framework
  - What does it do? To Design Single Page Applications (SPAs)
  - What version do we use?
    - Current Version is 8
    - What the heck is AngularJS?
      - The first version, very different
      - What is Angular 2?
        - There were some issues with the Angular versioning
          so Angular 2 might be the 2nd or 3rd version of Angular
  - How is it structured?
    - Follows MVC Design Pattern
    - Components/Modules/Services
  - What is a Component?
    - Segment of a webpage
      - By that, I mean that it represents html, css, and typescript
  - What is TypeScript?
    - A Superset of JavaScript (All JavaScript is also legitimate TypeScript)
    - Supports Strict typing
    - Supports OOP
    - Can browsers execute TypeScript?
      - NO!!!!! TypeScript is TRANSPILED into JavaScript
  - What is a Module?
    - A group of closely related Components
  - What is a Service?
    - Some set of logic that transcends an individual component
    - Services can be used by multiple components
    - Can (and should) be Dependency Injected
  - What is Dependency Injection?
    - It is a way to "de-couple" (separate/abstract) dependencies
    - It is used to achieve "loose-coupling" which allows for easier
      to maintain code.
    - Effectively, objects are directly injected when they are needed
      so constructors do not have to be explicitly invoked
      (Not to say that you are not allowed to use constructors, you still can)
    - It is performed by the Angular Framework
      - Note however, that Dependency Injection DOES NOT BELONG to Angular
        It is much more generic than that
  - Databinding
    - Property Binding
    - String Interpolation
    - Event Binding
    - 2-way Binding
  - Directives
    - What is a Directive?
      - A statement that will modify the DOM, or other html properties/characteristics
        - Generally, inline to the html element
        - There are 2 kinds, Structural and Attribute Directives
        - Many examples:
          - *ngIf
          - *ngFor
          - *ngSwitch
          - ngClass
          - ngStyle
    - Structural Directives
      - Uses asterisks (*)
      - Manipulate the DOM
    - Attribute Directives
      - Don't use astrisks
      - Modify other characteristics of the html element
  - Decorators
    - What is a Decorator?
      - A declaration, similar to annotations in Java
      - Defines some metadata about a TypeScript class
      - Modules, Components, and Services
      - Modules: @NgModule
      - Components: @Component
      - Services: @Injectable
  - Routing
    - How does routing work in a Single Page Application?
    - Uses RoutingModule
      - Defines paths, with specified components
      - Replaces <router-outlet> with the corresponding component
      - Can use Routers in TypeScript classes by injecting
        Router or ActivatedRoute in the constructor
  - Pipes
    - What is a Pipe?
      - An operator to transform data in some way
      - A few examples are to transform strings so that they are uppercase,
        or lowercase, or to transform numbers so that they display as proper currency, etc
      - It's not actually particularly efficient, however, you can filter the contents
        of an array with a pipe
      - There is an @Pipe decorator, and you override the transform method
  - Filtering
    - As mentioned previously, you can filter using pipes, but it is not the most efficient
      - Generally, it is better to filter back in SQL, as SQL is specifically designed
        for such tasks
- HTTP : Hyper Text Transfer Protocol (in the context of Angular)
  - Uses HttpClient to send HTTP Requests
  - Receives data back in Observables
  - What is an Observable?
    - A class that wraps the result/response from some asynchronous task
    - It is used to perform asynchronous tasks, HTTP requests/responses are one
      very common asynchronous task
    - Follows a Publisher-Subscriber Design Pattern
    - Effectively, the data is published, and subscribed to, to watch for changes
    - You can think of the server as "publishing" the data, and we "watch" that
      data for changes
      - A common change is that the data went from being empty, to having data
    - Observables are VERY good for processing streams of data
  - How do Promises compare to Observables?
    - Observables are newer
    - Promises are guarantee a response (They WILL absolutely eventually execute
      some code in response)
    - This is not always desirable, as sometimes we no longer need the results of
      an asynchronous task.
      - You CANNOT cancel a promise, but you CAN cancel an Observable
        ( You can unsubscribe from an observable )
      - Promises also do not process streams very well
      - You effectively can handle exactly 1 response in a Promise
  - What is NPM?
    - Node Package Manager
    - What does it do?
      - Manages packages
        - Bundles related files into 1 package
        - Install packages
        - Upgrade packages
        - Uninstall packages
        - Manage multi-versions of the same package
        - Of particular note, Angular was installed using npm
      - What kind?
      - Node.js packages
      - Packages design generally for server-side JavaScript
      - However, it has since seen wide use for other things
      - So you can even see some things like Python packages distributed through npm
  - CORS
    - Cross-Origin Resource Sharing
    - An issue with communicating with a resource on a different domain (or origin)
    - Generally, we need to add a filter that will allow for communication across origins
    - This is technically considered un-safe, which is why it is blocked by default
