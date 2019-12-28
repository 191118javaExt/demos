# Week 4 Study Guide

We talked about several things this week, starting with some information on XML to finish up last week and we spent a lot of time on Servlets. We also began talking about Angular.

## General Topics
- XML
  - Language Agnostic
  - XML vs JSON
  - Well Formed vs Valid
  - XML Validators
    - DTD: Document Type Definition
    - XSD: XML Schema Definition
  - Namespaces
  - XML Parsing
    - JAXP
    - SAX
    - DOM
- HTTP
  - Verbs/Methods
  - Status Codes
- Sessions
- sendRedirect vs forward
  - Remember that forward uses RequestDispatcher but sendRedirect does not
- Servlet Config vs Servlet Context
- Life Cycle of HTTP Request/Response
  - Steps 1 through 7
- Servlet Life Cycle
  - Steps 4a through 4c of the HTTP Request/Response Life Cycle
- Servlet Inheritance Tree
- How do you handle Forms in a Servlet?
- PrintWriter
- REST: REpresentational State Transfer
  - Everything is a resource identified by a unique endpoint (aka url)
  - Uses JSON or XML (But mainly JSON nowadays)
  - Our backend will be a REST API, what does this mean?
    - It does not send back HTML, it ONLY sends/receives JSON
    - The HTML navigation is handled by HTML and JavaScript (Or Angular)
- MVC Design Pattern: Model - View - Controller
  - What is it?
  - Why do we use it?
  - Model: The data
  - View: What is being seen
  - Controller: The logic
  - Note: Angular follows MVC Design Pattern
- Angular
  - First version was called AngularJS
    - Current version is Angular 8
    - Now just called Angular
  - Frontend Framework to create Single Page Applications (SPAs)
  - How does an SPA work?
    - Inserts/Removes segments of HTML to make it look like there are many pages
      but it still only has 1 entire html file
  - Uses TypeScript, which is a Superset of JavaScript
    - Is basically JavaScript but with support for strict typing
    - Note that TypeScript actually has MANY more features, but we haven't
      talked about them, it's quite a lot bigger than just JavaScript with types
  - Decorators
    - @Component for Components
      - What is a Component?
      - What files does it consist of?
    - @NgModule for Modules
      - What is a Module?
      - What files does it consist of?
    - @Injectable for Services
      - What is a Service?
      - What files does it consist of?
      - This namesake comes from the fact that Angular uses Dependency Injection (DI)
        - What is Dependency Injection?
        - Automatically having *something else* create instances of objects for you
          - Meaning that you DO NOT use constructors directly, the framework is doing
            that for you
          - Frameworks can execute a lot of code for you that you don't have to write
            kind of like how Tomcat does a bunch of stuff for you, so does Angular
  - Databinding
    - What is it?
    - Why is it used?
    - String Interpolation
      - Ex: {{varname.firstName}}
    - Property binding
      - Ex: <p [value]="varname">
    - Event binding
      - Ex: <button (click)="someFunc()">
    - Two-Way Databinding
      - Ex: <input [(ngModel)]="varname">
  - Directives
    - What is it?
    - Why is it used?
    - Used inside html
    - There are different kinds
      - Directives that begin with an asterisk * are called Structural Directives
        - Ex: *ngIf, *ngFor, *ngSwitch, etc
        - Structural Directives will modify the DOM in some way
      - Non-Structural Ex: ngStyle, ngClass
        - Does something, but not modifying the DOM

Make sure to look more into these Angular topics in particular, since I only offered a brief overview. We will still discuss them again next week, but there's many other more advanced topics that we need to go into as well.
