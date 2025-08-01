#  Spring Framework Overview:

---

## What is an Application Framework?

* An application framework is a **software platform** (not a library) that provides a **structured environment** for building and running applications.
* It **solves common challenges** like configuration, security, and data access.
* Provides **pre-built components**, tools, and libraries to support development standards and consistency.

---

## Spring Framework Overview

* **Spring** is an **application development framework** for Java.
* It simplifies Java programming by handling boilerplate code and promoting **loose coupling**.
* You **“place” your code** inside the Spring environment by following its rules.

---

## Problems Spring Solves

* Tight coupling between classes.
* Complex configuration and boilerplate code.
* Difficulty in managing dependencies.
* Manual handling of transactions, security, data access, and integration.

---

## How Spring Provides Solutions

* **Inversion of Control (IoC)**: Handles dependency injection automatically.
* **Annotations & Java Config**: Reduces XML and manual configuration.
* **Modules**: Different parts like Spring Boot, Spring MVC, etc., for specific needs.
* **Microservices**: With Spring Boot & Spring Cloud.

---

## Key Features of Spring

| Feature           | Description                                      |
| ----------------- | ------------------------------------------------ |
| **IoC**           | Spring container manages dependencies.           |
| **DI**            | Objects receive dependencies from the container. |
| **Data Access**   | Integrates with JDBC, JPA, Hibernate.            |
| **Transactions**  | Declarative transaction management.              |
| **Security**      | Simplified authentication & authorization.       |
| **Integration**   | Connect with JMS, REST, mail, etc.               |
| **Microservices** | Spring Boot + Spring Cloud support.              |

---

## Spring Modules

* **Spring Core** – IoC & Dependency Injection
* **Spring Boot** – Simplifies app setup
* **Spring MVC** – Web app framework
* **Spring Data** – Access to databases
* **Spring Security** – Authentication and authorization
* **Spring Batch, Integration, Cloud**, etc.

---

## Tight Coupling (Without Spring)

```java
public class OrderService {
    private PaymentService paymentService;

    public OrderService() {
        paymentService = new PaymentService();
    }

    public void processPayment() {
        paymentService.processPayment();
    }
}
```

### Problems:

* Tight coupling
* Not flexible
* Difficult to test and maintain

---

## Inversion of Control (IoC)

### What is it?

* Control over object creation and dependencies is given to an external container (like Spring).
* Promotes **loose coupling**, **flexibility**, and **easy testing**.

```java
public class OrderService {
    private PaymentService paymentService;

    public OrderService(PaymentService paymentService) {
        this.paymentService = paymentService;
    }

    public void processPayment() {
        paymentService.processPayment();
    }
}
```

---

## Spring Core – IoC Container

* **Spring Container**: Responsible for managing beans (objects).
* Provides objects (beans) based on configuration metadata.
* Metadata can be defined using annotations, XML, or Java classes.

---

## Maven Setup for Spring Core Project

```xml
<dependency>
  <groupId>org.springframework</groupId>
  <artifactId>spring-context</artifactId>
  <version>6.2.9</version>
</dependency>
```

---

## Spring Bean Example

```java
@Component
public class HelloWorldMessage {
    public String getMessage() {
        return "Hello World";
    }
}
```

```java
@Configuration
@ComponentScan("com.tekgrads")
public class App {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext ctxt = new AnnotationConfigApplicationContext(App.class);
        HelloWorldMessage message = ctxt.getBean(HelloWorldMessage.class);
        System.out.println(message.getMessage());
        ctxt.close();
    }
}
```

---

## Constructor-Based Dependency Injection

```java
@Component
public class Greeter {
    private HelloWorldMessage helloWorldMessage;

    public Greeter(HelloWorldMessage helloWorldMessage) {
        this.helloWorldMessage = helloWorldMessage;
    }

    public void greet() {
        System.out.println(helloWorldMessage.getMessage());
    }
}
```

---

## Setter-Based Dependency Injection

```java
@Component
public class Greeter {
    private HelloWorldMessage helloWorldMessage;

    public HelloWorldMessage getHelloWorldMessage() {
        return helloWorldMessage;
    }

    @Autowired
    public void setHelloWorldMessage(HelloWorldMessage helloWorldMessage) {
        this.helloWorldMessage = helloWorldMessage;
    }

    public void greet() {
        if (helloWorldMessage != null) {
            System.out.println(helloWorldMessage.getMessage());
        } else {
            System.out.println("Hello World message is not there");
        }
    }
}
```

---

## Constructor vs Setter Injection

| Aspect                 | Constructor Injection | Setter Injection |
| ---------------------- | --------------------- | ---------------- |
| Mandatory Dependencies | Enforced              | Optional         |
| Immutability           | Promotes it           | No guarantee     |
| Too Many Params        | Can be hard to manage | More readable    |
| Null Safety            | Always initialized    | May be null      |

---

## Field Injection

```java
@Component
public class Greeter {
    @Autowired
    private HelloWorldMessage helloWorldMessage;
}
```

> **Not recommended** due to lack of visibility and testability.

---

## Spring Application Architecture

* **POJOs** – Data and logic classes
* **Configuration Metadata** – Beans and dependencies defined using annotations or Java classes
* **Spring Container** – Manages lifecycle and injection

---

## Important Interfaces

* `ApplicationContext` – Full-featured container
* `BeanFactory` – Basic IoC support

---

## Get Bean Definitions

```java
String[] names = ctxt.getBeanDefinitionNames();
for (String name : names) {
    System.out.println(name);
}
```

---

## Scopes in Spring

* **Singleton** – One shared instance per container (default)
* **Prototype** – New instance every time

---

## Circular Dependency

### Problem Code (Setter Injection)

```java
@Component
public class HelloWorldMessage {
    private Greeter greeter;

    @Autowired
    public void setGreeter(Greeter greeter) {
        this.greeter = greeter;
    }
}
```

```java
@Component
public class Greeter {
    private HelloWorldMessage message;

    @Autowired
    public void setMessage(HelloWorldMessage message) {
        this.message = message;
    }
}
```

### Why it causes Deadlock?

* During instantiation, both beans wait for each other to be created.
* Setter injection allows circular dependencies, but constructor injection does not.
* This can lead to `BeanCurrentlyInCreationException`.

---

## Why Constructor Injection is Preferred?

* Ensures all required dependencies are provided.
* Encourages immutability.
* Avoids circular dependency.
* Ideal for mandatory dependencies.
* Prevents null values.

---

## Defining Beans with @Bean

```java
@Configuration
public class AppConfig {

    @Bean
    public String greetingMessage() {
        return "Hello";
    }

    @Bean
    public HelloWorldMessage getHelloWorldMessage(String greetingMessage) {
        return new HelloWorldMessage(greetingMessage);
    }

    @Bean
    public Greeter getGreeter(HelloWorldMessage helloWorldMessage) {
        return new Greeter(helloWorldMessage);
    }
}
```

