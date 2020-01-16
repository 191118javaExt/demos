# Spring Framework 
- A framework built on Java which supports development of enterprise applications
- Utilizes Dependency Injection as an implementation of inversion of control
- Spring is an umbrella term. It refers to the overall framework itself, as well as the many projects built on top of it

## Why Spring?

We can turn this code


    public class BeanAImpl implements BeanA {

        private BeanB dog = new BeanBImpl();

    }


into this code

    public class BeanAImpl implements BeanA {

        private BeanB dog;

    }

## IOC
- Inversion of Control:
    - Inverts control of the application flow and object creation to a framework
        - DI achieves loose coupling
    - Abstract design where behavior is injected into your classes
- Service locator:
    - Bean controls the instantiation of its dependencies

### Dependency Injection 
- An implementation of IOC
    - Dependency: some object to be used
    - Injection: passing dependency to a dependent object at creation time
    - Spring bean is provided its dependencies by the framework
    - Decouples configuration from implementation

In Spring this is done with the "spring container" (IOC, or Inversion of Control, Container) which injects our registered objects, or our "spring beans"
- IOC container is represented by an ApplicationContext or BeanFactory
- We can register beans with the IOC so that it may manage the lifecycle of objects, providing dependencies where necessary 

## Spring Modules
The Spring Framework is subdivided into different modules.

- Spring Core
- Spring Beans
- Spring Context 

Spring Core + Beans provide the essential DI features with the BeanFactory interface

Spring Context builds on core and beans to add additional functionality; access to ApplicationContext

Additional Modules:
- Web module
- AOP module
- JDBC module
- ORM module

#### Spring Projects
Spring Projects are built on top of a set of modules 
- Spring Boot
- Spring Data
- Spring Security

## BeanFactory vs. ApplicationContext
- Both represent the IOC container, manage the lifecycle of spring managed objects

#### BeanFactory
- Older
- Lazily instantiates our spring beans
- Must provide a resource object configured for our beans.xml

Ex
- XmlBeanFactory

        XmlBeanFactory factory = new XmlBeanFactory(new ClassPathResource("beans.xml")); 


#### ApplicationContext 
- Newer
- Eagerly instantiates spring beans
- Provides support for annotations 
- Creates and manages its own resource object
- Naming convention changed to use applicationContext.xml

ApplicationContext is a sub-interface which adds more enterprise-specific functionality on top of the basic functionality of the BeanFactory.
- Easier integration with Spring’s AOP features
- Message resource handling (for use in internationalization)
- Event publication
- Application-layer specific contexts such as the WebApplicationContext for use in web applications.

Ex
- ClassPathXmlApplicationContext
- FileSystemXmlApplicationContext
- XmlWebApplicationContext


        ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");


## Spring Bean
In Spring, the objects that form the backbone of your application and that are managed by the Spring IoC container are called beans. A bean is an object that is instantiated, assembled, and otherwise managed by a Spring IoC container. Otherwise, a bean is simply one of many objects in your application. Beans, and the dependencies among them, are reflected in the configuration metadata used by a container.
- An object whose lifecycle is managed by spring's IOC container 

![Role of the IOC container](https://docs.spring.io/spring/docs/current/spring-framework-reference/images/container-magic.png "Role of the IOC container")

### Configuration
#### XML config

- Defined in applicationContext.xml (src > main > resources > applicationContext.xml)

        <bean name="beanA" class="com.revature.BeanA"></bean>


#### Annotation config
1. Enable Component Scanning in applicationContext.xml

2. Annotate classes with stereotype annotations 
    - @Component: general spring-managed component 
    - @Repository: DAO
    - @Controller
    - @Service


- There's also a way of creating a class with the @Configuration annotation, with methods using @Bean to register beans in a centralized location without having a applicationContext.xml file

## Bean Lifecycle
0. Request bean from ApplicationContext
    - Instantiation
    - Populate properties
1. BeanNameAware's setBeanName method
2. BeanClassLoaderAware's setBeanClassLoader method
3. BeanFactoryAware's setBeanFactory method
4. EnvironmentAware's setEnvironment method
5. BeanPostProcessors' postProcessBeforeInitialization method
6. InitializingBean's afterPropertiesSet method
7. Custom init method
    - Init-method in our bean declaration (applicationContext.xml)
    - @PostConstruct
8. BeanPostProcessors' postProcessAfterInitialization method

#### On Shutdown
1. DestructionAwareBeanPostProcessors' postProcessBeforeDestruction method
2. DisposableBean's destroy
3. Custom destroy method
    - destroy-method in our bean declaration (applicationContext.xml)
    - @PreDestroy

## Bean Scopes
1. Singleton - Single object instance in the IOC container, each consecutive call for this bean from the AC will return the same object
    - This is the *DEFAULT*
2. Prototype - many instances of the bean a new instance is created whenever requeted from A.C.

For web-aware:
3. Request (Http)
4. Session (Http session)
5. Global Session (Global http session; has to do with portlets)

## Bean Wiring 
- Just as there are various ways to register beans with our IOC container, there are a few ways we can wire our beans together
- Bean wiring is the process of providing configuration to our application to indicate which 
- How we connect our beans via DI

### Setter Injection
- Uses setter methods to provide dependencies
- More readable
- Doesn't ensure DI because an instance can be created without configuring a particular field (no issue if we don't configure), will still be created (@Required will make sure there is configuration for that dependency -- prevents NullPointerExceptions later down the line)

### Constructor
- Uses constructor injection, similarly to Angular, when we provide a constructor with the necessary dependencies as constructor arguments
- Does not allow you to create objects until dependencies are ready

### Autowiring
- Let spring figure out dependencies itself ("automagically")

##### By Type
- Automagically determines DI based on the type of the dependencies and the setters in the class


        <bean name="beanA" class="com.ex.BeanA" autowire="byType"></bean>
        <bean name="beanB" class="com.ex.BeanB"></bean>



        public class BeanA{
            private BeanB beanB;

            public void setBeanB(BeanB beanB){
                this.beanB=beanB;
            }
            // looks to inject based on the type of object 
        }

##### By Name
- Automagically determines DI based on the name of the dependencies and the setters in the class

        <bean name="beanA" class="com.ex.BeanA" autowire="byName"></bean>
        <bean name="beanB" class="com.ex.BeanB"></bean>

        public class BeanA{
            private BeanB beanB;

            public void setBeanB(BeanB beanB){
                this.beanB=beanB;
            }
            // looks to inject based on the name of the field and name of the setter 
        }

### Autowiring using Annotations
- Enable component scanning in applicationContext.xml

        <context:component-scan base-package="com.ex"></context:component-scan>

- Include @Autowired over the field which needs to be injected

        @Component
        public class BeanA{
            
            @Autowired
            private BeanB beanB;


            // looks to perform type based setter injection, or constructor injection if no suitable setter
        }

@Qualifier annotation can be used if there is more than one bean of the same type to identify, 
generally considered a bad practice if it can be avoided