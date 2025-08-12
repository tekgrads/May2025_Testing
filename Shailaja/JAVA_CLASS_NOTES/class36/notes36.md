Spring Framework – Enhanced Notes
1. What is an Application Framework?
An Application Framework is a platform that provides a structured environment to build and run applications, helping developers solve common programming challenges.

Key Points:

It is a platform, not just a library.

Provides a structured development environment.

Handles common repetitive tasks.

Encourages consistent coding standards.

2. Where Spring Fits in an Application
In Spring, we can use:

Spring JDBC → For connecting to a database.

Spring Core → For creating and managing objects.

ORM (Object Relational Mapping) → To avoid writing raw SQL.

Spring MVC → To replace multiple servlets with a structured web MVC pattern.

3. Spring Modules Overview
📡 Spring JDBC
Purpose: Simplifies database interaction using JDBC.

Key Features:

Eliminates boilerplate JDBC code.

Uses JdbcTemplate for database operations.

Manages connection handling and exceptions.

Use Cases:

Perform CRUD operations.

Reduce repetitive code.

Improve DB logic unit testing.

🔧 Spring Core
Purpose: The heart of the Spring Framework—manages object creation and wiring using Dependency Injection (DI).

Advantages:

Less code – Spring creates and connects objects.

Easier maintenance – Change one component without breaking others.

Better testing – Easily test components using mocks.

Reusable objects – Same bean can be reused in multiple places.

Flexible configuration – Use XML, annotations, or Java config.

🎯 Spring MVC
Purpose: Web framework following the Model–View–Controller pattern.

Components:

Model: Handles data & business logic.

View: Presentation layer (JSP, Thymeleaf, HTML).

Controller: Handles user requests and maps them to services.

Uses:

Build dynamic web applications.

Develop REST APIs.

Separate concerns (UI, logic, routing).

Validate & process form data.

🗃️ ORM (Object Relational Mapping)
Purpose: Maps Java objects to database tables.

Benefits:

Interact with DB using objects instead of SQL.

Save, update, and delete data with Java methods.

🛣️ DispatcherServlet
Purpose: Acts as the Front Controller in Spring MVC.

Receives all HTTP requests.

Routes them to the correct controller.

Returns the appropriate view/data.

Real-world analogy: Like a traffic controller directing cars (requests) to their destinations (controllers).

4. Spring Framework at a Glance
Popular Java framework with a family of modules:

Spring Core

Spring Boot

Spring MVC

Spring Data

Spring Security

Spring Integration

Spring Cloud …and more.

Spring Offers:

Simplified configuration.

Dependency management.

Data access & transactions.

Integration with other systems.

Security & microservices support.

5. Core Spring Concepts
🔁 Inversion of Control (IoC)
Framework creates & manages objects instead of the developer.

Example: You buy a ready-made laptop instead of assembling it yourself.

📌 Dependency Injection (DI)
A technique where dependencies are provided externally instead of being created inside the class.

Types of DI:

Constructor Injection – Dependency passed via constructor.

Used when dependency is mandatory.

Setter Injection – Dependency passed via setter method.

Used when dependency is optional/changeable.

Field Injection (@Autowired) – Spring injects directly into the field.

Circular Dependency Handling – Use setter injection or @Lazy to avoid constructor loops.

6. Annotations
@Component → Marks a class as a Spring-managed bean.

@Configuration → Declares a configuration class.

@ComponentScan → Scans packages for beans.

@Autowired → Automatically injects dependencies.

7. Spring Core Example (Annotation-Based Config)
HelloWorldMessage.java

java
Copy
Edit
@Component
public class HelloWorldMessage {
    public String getMessage() {
        return "Hi, Hello!";
    }
}
App.java

java
Copy
Edit
@Configuration
@ComponentScan("com.tekgrads")
public class App {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext ctxt = new AnnotationConfigApplicationContext(App.class);
        HelloWorldMessage hm = ctxt.getBean(HelloWorldMessage.class);
        System.out.println(hm.getMessage());
    }
}
Output:

Copy
Edit
Hi, Hello!
8. Circular Dependency
Problem: Two beans depend on each other via constructors → Spring cannot resolve.

Solution:

Use Setter Injection.

Use @Lazy on one dependency.

9. ApplicationContext
The Spring container that:

Loads bean definitions.

Creates and wires beans.

Manages their lifecycle.

Features:

Supports DI.

Manages events.

Supports i18n.

Handles annotations like @Component, @Autowired.

10. Bean Scope
Singleton (default): One instance per container.

Prototype: New instance each time requested.

Other scopes (for web apps):

request, session, application, websocket.

11. byType vs byName (Autowiring)
byType: Matches dependency by class type.

byName: Matches dependency by bean name.