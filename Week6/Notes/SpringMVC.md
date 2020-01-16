# Spring MVC
- Model-View-Controller Design Pattern
    - Model: Data being passed, rendered, and manipulated
    - View: What will be displayed
    - Controller: Handles logic & routing
- Abstracts Servlets

# Important components
- Single Servlet provided called `DispatcherServlet`
  - `Front Controller` Design Pattern - Single point of entry for all requests
  - Configured in web.xml
- `HandlerMapping` - Maps requests to correct controller
- `@Controller` - Handles requests
- `ViewResolver` - Helps render views

## HandlerMapping
- An Interface
- Tells `DispatcherServlet` which controller to use
- One implementation that we use is `RequestMappingHandlerMapping`


## Controllers
- `@Controller`
  - Stereotype annotation that defines a Spring Bean
  - Says this class will handle Http requests delegated from `DispatcherServlet` based on URI
- `@RequestMapping`
  - Specifies what request this method will handle
  - Can also be used at the class

        @Controller
        public class TestController {

            @RequestMapping(value = "/test", method = RequestMethod.GET)
            public String test() {
                return "test";
            }
        }

## ViewResolver
- Simplifies the String representing the view that controllers return
- Configured in xml file

        <bean id="viewResolver" class="org.springframework.web.servlet.view.InternalResourceViewResolver">
            <property name="prefix" value="/static/"/>
            <property name="suffix" value=".html"/>
        </bean>

## ContextLoadListener
- Ties the Lifecycle of the ApplicationContext with the ServletContext
- Automates the creation of the ApplicationContext so that Tomcat will start it for us
- Configured in web.xml

## Bean Scopes
- Addiitonal Bean Scopes mentioned previously
- Request Scope: Scoped to one HTTP Request
- Session Scope: Scoped to single session, server side
- Global Scope: Scoped to Servlet Container

# Control Flow
1. Http Request arrives at the `DispatcherServlet`
2. `DispatcherServlet` consults the `HandlerMapping` to determine which Controller to delegate to
3. Passes relevant information to the controller
4. Controller consults business layer to process request
5. Controller builds the response (Model and View)
6. The response is handed to the `DispatcherServlet`
7. `DispatcherServlet` consults the `ViewResolver` to process the view
8. `DispatcherServlet` sends response back to client