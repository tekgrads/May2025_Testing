# Spring Core (Class 36)

## What is Spring Core?
- It is an application framework.
- Helps in building Java projects.
- Supports Spring JDBC, ORM (Object Relational Mapping), and Servlets (MVC) to cut down scrolls.
- Makes programming in Java quicker, easier, and safer.
- Focuses on speed, simplicity, and productivity.
- It is modular, but has many modules.

## What does Spring Provide?
- Dependency management

## Introduction

### Understanding Inversion of Control (IoC)
- We don’t want to create objects ourselves; instead, we delegate object creation to Spring.
- This is based on the Factory Controller Design Pattern.
- IoC = Dependency Inversion / Inversion of Object
- We give away the required need of object creation to Spring.
- Tightly coupled code will be handed over to Spring Core to manage.

## Getting Started with Spring Core
1. Create a new workspace for Spring Core.
2. Create a new Maven project.
   - Go to All Catalogs → Maven → Archetype → Quickstart
   - Group Id: `com.tk.groots`
   - Artifact Id: `spring-core`
3. Go to `pom.xml` file.
   - Copy Spring dependency (spring-context Maven dependency, version 6.2.9).
   - Paste into `pom.xml`.
4. Run Maven → Update Project → it will automatically pull dependencies (transitive dependencies).

## Object Creation with Annotations
- To overcome manual object creation, we use `@Component`.
- Tells Spring to create objects for classes qualifying with `@Component`.

## Configuration
- Main class:
  ```java
  @Configuration  // enabling configuration
  @ComponentScan("com.tk.groots")  // scans given package for components

By this, Spring starts doing the configuration automatically.
	•	Use:

AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(App.class)

•	It looks for annotation type configuration and performs the rest.
•	Now object creation is controlled by Spring.

Accessing Objects
ctx.getBean(HelloWorld.class);
	•	Whatever objects Spring creates are called Beans.

Dependency Injection

Example:
	•	Greeter class depends on HelloWorld.
	•	This is called Dependency Injection (DI).

Types of Injection:
	•	@Autowired – commonly used.
	•	If you run the Greeter method, it will output from HelloWorld.

Types of Classes
	1.	Data holders
	2.	Functionality holders

POJO
	•	Plain Old Java Object

Common Packages
	•	org.springframework.beans
	•	org.springframework.context

Bean Factory vs Application Context
	•	BeanFactory → Just creates objects and gives them.
	•	ApplicationContext → Provides additional features beyond BeanFactory.

Beans
	•	Meaning: Objects managed by Spring.

Scope of Beans
	•	Singleton (default) → only one object created.
	•	Prototype → creates a new object each time.

Autowiring Options
@Autowired(required = false)

Tells Spring to ignore if a dependency (like HelloWorld) is not available.

Circular Dependency

Example:
	•	To create Greeter, we need HelloWorld.
	•	To create HelloWorld, we need Greeter.
	•	This causes a Circular Dependency (CD).

Solution
	•	Use Setter Injection instead of Constructor Injection.

Which is better?
	•	Setter Injection is better.