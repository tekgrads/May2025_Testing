Spring Framework – Complete Detailed Notes
1. What is an Application Framework?
An Application Framework is a platform that provides tools, libraries, and a structured environment to develop applications efficiently.

Key Points:

Provides a foundation for application development.

Offers ready-made solutions for common problems.

Encourages standard coding practices.

Handles repetitive tasks like object creation, configuration, and lifecycle management.

2. Where Spring Fits in an Application
In a typical enterprise app:

Spring JDBC → Handles database connectivity.

Spring Core → Creates and manages objects (Dependency Injection).

ORM → Eliminates raw SQL by mapping objects to DB tables.

Spring MVC → Replaces multiple servlets with a cleaner MVC pattern.

3. Spring Modules Overview
📌 Spring JDBC
Simplifies database access.

Uses JdbcTemplate to remove boilerplate JDBC code.

Handles:

Connection management

SQL execution

Exception translation

Use Cases:

CRUD operations

DB integration with minimal boilerplate

Unit test-friendly DB access

📌 Spring Core
The heart of Spring — responsible for:

Dependency Injection (DI)

Inversion of Control (IoC)

Advantages:

Reduces boilerplate code.

Improves testability.

Promotes loose coupling.

Supports multiple configuration methods (XML, annotations, Java config).

📌 Spring MVC
Implements the Model–View–Controller pattern:

Model: Data + business logic.

View: Presentation (JSP, Thymeleaf, HTML).

Controller: Handles incoming requests.

Use Cases:

Web applications

REST APIs

Form handling

Validation

📌 ORM (Object Relational Mapping)
Maps Java objects to DB tables.

Reduces need for SQL.

Works with JPA, Hibernate, etc.

📌 DispatcherServlet
Acts as Front Controller.

Routes incoming requests to controllers.

Coordinates between View and Model.

4. Spring Ecosystem
Spring includes:

Spring Core

Spring Boot

Spring MVC

Spring Data

Spring Security

Spring Integration

Spring Cloud

5. Core Concepts
Inversion of Control (IoC)
Objects are created and managed by the Spring container instead of manually.

Analogy: Like ordering a ready-made pizza instead of making it from scratch.

Dependency Injection (DI)
Injecting required dependencies from outside a class.

Types:

Constructor Injection – For mandatory dependencies.

Setter Injection – For optional/changeable dependencies.

Field Injection – Using @Autowired.

Circular Dependency Issue:

Happens when two beans depend on each other.

Solutions:

Setter Injection

@Lazy

6. Annotations
@Component – Marks class as Spring bean.

@Configuration – Marks class as config provider.

@ComponentScan – Scans packages for beans.

@Autowired – Injects dependencies automatically.

7. Example: Spring Core (Annotation Config)
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
8. ApplicationContext
Spring container that:

Loads bean definitions.

Creates and wires beans.

Manages lifecycle and events.

Supports i18n and annotation processing.

9. Bean Scope
Singleton (default) – One instance per container.

Prototype – New instance every request.

Request, Session, Application, Websocket – For web contexts.

10. Autowiring Modes
byType – Matches bean by class type.

byName – Matches bean by bean name.

11. Interaction Flow Diagram
pgsql
Copy
Edit
                   ┌─────────────────────┐
                   │   User / Browser    │
                   └─────────┬───────────┘
                             │ HTTP Request
                             ▼
                   ┌─────────────────────┐
                   │  DispatcherServlet  │  ← (Front Controller)
                   └─────────┬───────────┘
                             │
                  ┌──────────┴───────────┐
                  │      Controller      │  ← (Handles requests)
                  └──────────┬───────────┘
                             │ Calls Service Layer
                             ▼
                   ┌─────────────────────┐
                   │  Service (Business) │  ← (Contains logic)
                   └──────────┬──────────┘
                             │ Uses Spring Core DI to inject DAO
                             ▼
                      ┌─────────────┐
                      │   DAO /     │
                      │ Repository  │  ← (Data Access Layer)
                      └──────┬──────┘
                             │ Uses Spring JDBC (JdbcTemplate)
                             ▼
                      ┌─────────────┐
                      │  Database   │
                      └─────────────┘
12. Summary Table
Module	Purpose	Key Feature
Spring Core	Object creation & DI	IoC, DI
Spring JDBC	DB access simplification	JdbcTemplate
Spring MVC	Web MVC framework	Controller, ViewResolver
ORM	Object–DB mapping	Works with JPA/Hibernate
DispatcherServlet	Front Controller	Request routing