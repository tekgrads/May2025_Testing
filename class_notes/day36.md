Spring Framework – Complete Guide
🔹 What is Spring Framework?

Spring is a powerful, lightweight, open-source framework for building enterprise-level Java applications.

It helps developers by providing:

Dependency Injection (DI)

Aspect-Oriented Programming (AOP)

Data access (JDBC, ORM, JPA support)

Web development (Spring MVC, Spring Boot)

Security (Spring Security)

Cloud support (Spring Cloud)

🔹 Key Features

Dependency Injection (IoC Container)

Manages object creation and lifecycle.

Eliminates tight coupling between classes.

Aspect-Oriented Programming (AOP)

Adds cross-cutting concerns like logging, security, and transactions without changing business logic.

Spring MVC

Model-View-Controller architecture for web applications.

Data Access Layer

Simplifies database access (JDBC, Hibernate, JPA).

Spring Boot

Simplifies Spring application development with embedded servers, auto-configuration, and starter dependencies.

🔹 Spring Architecture

The Spring framework consists of multiple modules:

Spring Framework
│── Core Container
│   ├── Beans
│   ├── Core
│   ├── Context
│   └── Expression Language
│
│── Data Access/Integration
│   ├── JDBC
│   ├── ORM
│   └── JMS
│
│── Web
│   ├── Web
│   ├── Web MVC
│   └── WebSocket
│
│── AOP (Aspect Oriented Programming)
│── Test (JUnit/TestNG support)

🔹 Example 1: Dependency Injection with Spring
1. Define a simple service
public class GreetingService {
    public String greet() {
        return "Hello, Spring!";
    }
}

2. Define a consumer class
public class MyApp {
    private GreetingService greetingService;

    // Constructor injection
    public MyApp(GreetingService greetingService) {
        this.greetingService = greetingService;
    }

    public void run() {
        System.out.println(greetingService.greet());
    }
}

3. Spring Configuration (beans.xml)
<beans xmlns="http://www.springframework.org/schema/beans"
       xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
       xsi:schemaLocation="
         http://www.springframework.org/schema/beans
         http://www.springframework.org/schema/beans/spring-beans.xsd">

    <!-- Define GreetingService bean -->
    <bean id="greetingService" class="com.example.GreetingService" />

    <!-- Inject GreetingService into MyApp -->
    <bean id="myApp" class="com.example.MyApp">
        <constructor-arg ref="greetingService"/>
    </bean>

</beans>

4. Run Application
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
    public static void main(String[] args) {
        ApplicationContext context =
            new ClassPathXmlApplicationContext("beans.xml");

        MyApp app = context.getBean("myApp", MyApp.class);
        app.run();
    }
}


Output:

Hello, Spring!

🔹 Example 2: Spring Boot Quick Example

With Spring Boot, you can avoid boilerplate XML config.

1. pom.xml (dependencies)
<dependencies>
    <dependency>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter</artifactId>
    </dependency>
</dependencies>

2. Application Code
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.*;

@SpringBootApplication
@RestController
public class DemoApplication {

    @GetMapping("/hello")
    public String hello() {
        return "Hello, Spring Boot!";
    }

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }
}

3. Run the app
mvn spring-boot:run


Visit in browser:
👉 http://localhost:8080/hello

Output:

Hello, Spring Boot!

🔹 Advantages of Spring

Loose coupling with Dependency Injection.

Cleaner separation of concerns with AOP.

Easier testing due to POJO-based development.

Rich ecosystem (Spring Boot, Spring Security, Spring Cloud).

Reduces boilerplate code.

🔹 Real-Life Use Cases

Web applications (Spring MVC + Spring Boot).

Microservices (Spring Boot + Spring Cloud).

REST APIs.

Enterprise apps with transaction management.

Secure applications using Spring Security.

✅ With Spring, you can build everything from small applications to large enterprise systems efficiently.