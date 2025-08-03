
## 🚀 What is an Application Framework?

An **Application Framework** helps solve common programming challenges by providing a structured environment for building and running applications.

### Key Points:

* It is a **platform**, not a library.
* Provides a **structured environment**.
* Handles **common tasks**.
* Supports **consistent development standards**.



---

#### on springs we can use 
*Spring JDBC for connecting to database
*For creating objects we can use Spring core
*instead of writing SQL here we can use ORM(Object Relation Mapping)
*For reducing the servlets we can use Spring MVC

### 📡 Spring JDBC

Simplifies database interaction using JDBC.

#### Key Features:

* Eliminates boilerplate JDBC code.
* Uses `JdbcTemplate` for DB operations.
* Manages connection, exception handling.

#### Uses:

1. Perform CRUD operations.
2. Reduces boilerplate code.
3. Handles SQL exceptions.
4. Eases unit testing of DB logic.

---
## 🔧 SPRING CORE

Spring Core is the main part of the Spring Framework.
It helps manage how objects are created and connected to each other using **Dependency Injection (DI)**.


---
### 🎯 Spring MVC

Web framework following **Model-View-Controller (MVC)** pattern.

#### Components:

* **Model**: Data logic
* **View**: JSP/HTML templates
* **Controller**: Handles user input and maps requests

#### Uses:

1. Build dynamic web apps.
2. Develop REST APIs.
3. Map URLs to controller methods.
4. Separate concerns: UI, business logic, routing.
5. Form data processing & validation.
6. Render views using JSP, Thymeleaf.
7. Integrate with backend & DB.

---


### 🗃️ ORM (Object Relational Mapping)

Maps Java objects to relational database tables.

#### Benefits:

* Interact with DB using objects instead of SQL.
* Perform save/update/delete using Java.

---

### 🛣️ DispatcherServlet

Acts as the **front controller** in Spring MVC. It intercepts HTTP requests and routes them to the appropriate controller.

#### Real-world Analogy:

Like a **traffic controller**: directs requests to the correct controller and returns the view or data.

#### Example:

User submits login form → DispatcherServlet receives request → Matches controller → Returns success page.

---
# 🌱 Spring Framework 

Spring Framework is the most popular Java framework.

## 📦 Spring Includes:

1. Core Framework
2. Family of Frameworks and Libraries
3. Solutions for many concerns

## 🌐 Spring Family:

* Spring Core
* Spring Boot
* Spring MVC
* Spring Data
* Spring Security
* Spring Integration
* Spring Cloud and so on.....

## 🎯 Spring Offers:

* Simplified configuration
* Dependency management
* Data access
* Transactions
* Integration
* Security
* Microservices support

---

## 🔧 SPRING CORE

Spring Core is the main part of the Spring Framework.
It helps manage how objects are created and connected to each other using **Dependency Injection (DI)**.

### ✅ Key Features of Spring Core:

1. **Inversion of Control (IoC):** Objects are created and managed by the Spring container, not manually in the code.
2. **Dependency Injection (DI):** Dependencies are injected at runtime, improving flexibility and testing.
3. **BeanFactory & ApplicationContext:** Two core containers to manage beans (objects).

### 💡 Advantages of Spring Core:

1. **Less Code** – Spring creates and connects objects for you.
2. **Easy to Change** – You can change parts of the code without affecting others.
3. **Better Testing** – You can test small parts of your code easily using mocks.
4. **Reusable Code** – One object can be used in many places.
5. **Easy Configuration** – You can use XML or annotations to tell Spring how to create and manage objects.

---

## 🔁 IoC (Inversion of Control)

**IoC** stands for *Inversion of Control*.
It means giving control to the framework (like Spring) to create and manage objects, instead of doing it manually in your code.

### 🔍 Key Point:

> You don’t create objects — Spring does it for you.

### 💡 Real-Time Example:

> If you buy a laptop with some features, you go to the shop and ask for that laptop. You don’t build it yourself.
>
> * **Shop** = Spring Core
> * **Laptop** = Created Object with Features

---


---

## 📌 Annotations

### `@Component`

Marks a class as a Spring-managed component. Spring will detect it during component scanning.

### `@Configuration`

Indicates that the class declares one or more `@Bean` methods and may be processed by the Spring container.

### `@ComponentScan`

Tells Spring which packages to scan for annotated components (`@Component`, `@Service`, etc.).

---

#### ⚙️ add the spring dependency on the pom.xml

Add the following to your `pom.xml`:

```xml
<project xmlns="http://maven.apache.org/POM/4.0.0" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
  xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 http://maven.apache.org/xsd/maven-4.0.0.xsd">
  <modelVersion>4.0.0</modelVersion>

  <groupId>com.tekgrads</groupId>
  <artifactId>Springcore</artifactId>
  <version>0.0.1-SNAPSHOT</version>
  <packaging>jar</packaging>

  <name>Springcore</name>
  <url>http://maven.apache.org</url>

  <properties>
    <project.build.sourceEncoding>UTF-8</project.build.sourceEncoding>
  </properties>

  <dependencies>
    <dependency>
      <groupId>junit</groupId>
      <artifactId>junit</artifactId>
      <version>3.8.1</version>
      <scope>test</scope>
    </dependency>

<dependency>
			<groupId>org.springframework</groupId>
			<artifactId>spring-context</artifactId>
			<version>6.2.9</version>
		</dependency>

      </dependencies>
</project>
```


# 🌿 Spring Core with Annotations

A simple Spring Core project demonstrating annotation-based configuration using `@Component`, `@Configuration`, and `@ComponentScan`.

---


### `HelloWorldMessage.java`

```java
package com.tekgrads;

import org.springframework.stereotype.Component;

@Component
public class HelloWorldMessage {
    public String getMessage() {
        return "hii hello";
    }
}
```

---

### `App.java`

```java
package com.tekgrads;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan("com.tekgrads")
public class App {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext ctxt = new AnnotationConfigApplicationContext(App.class);
        HelloWorldMessage hm = ctxt.getBean(HelloWorldMessage.class);
        System.out.println(hm.getMessage());
    }
}
```

---

## ✅ Output

```
hii hello
```

---





### 💡 What is Dependency Injection?

Dependency Injection is a technique where one object supplies the dependencies of another object. It helps in creating loosely coupled, testable, and maintainable code.

### 🔧 Real-Time Analogy:

Imagine a team member needs help from a team leader. Instead of the team member creating a team leader object directly, the leader is provided (injected) externally. This keeps the team member independent of how the team leader is created.

---

## 🔧 Types of Dependency Injection

### 1️⃣ Constructor-Based Injection

* Dependency is provided at the time of object creation using the constructor.
* ✅ Used when the dependency is **mandatory**.

```java
public class Greeting {
    private Greeting greeter;

    public Employee(Greeting greeter) {
        this.greeter = greeter;
    }
}
```

### 2️⃣ Setter-Based Injection

* Dependency is set after the object is created using setter methods.
* ✅ Used when the dependency is **optional** or can change later.

```java
public class Greeting {
    private Greeting greeter;

    public void setGreeting(Greeting greeter) {
        this.greeter = greeter;
    }
}
```

### 3️⃣ Circular Dependency Injection

Occurs when two or more beans depend on each other directly or indirectly, forming a loop.

#### 🔁 Example:

```
A needs B
B needs A
```

This situation is called **circular injection**, and must be avoided or handled using:

* Setter Injection
* `@Lazy` annotation

---
Note: use constructor injection if you have many parameters you can use setter injection
---

### 4️⃣  Field Injection(@Autowired):
Spring looks for a matching bean and injects it where @Autowired is placed.

#### 🔁 Real-time Example:
```
Ordering food:
Instead of making food (object) yourself, you ask someone else (Spring) to bring it for you.
```
```
It is not mandatory to use.
```

## 📄 Example 1: constructor based Dependency Injection


### `Greeting.java`

```java
package com.tekgrads;

import org.springframework.stereotype.Component;

@Component
public class Greeting {
    HelloWorldMessage hm;

    // Constructor Injection
    public Greeting(HelloWorldMessage hm) {
        this.hm = hm;
    }

    public void greet() {
        System.out.println(this.hm.getMessage());
    }
}
```

---

### `HelloWorldMessage.java`

```java

package com.tekgrads;

import org.springframework.stereotype.Component;
@Component
public class HelloWorldMessage {
	public String getMessage() {
		return "hii hello";
	}
 
}

```


---

### `App.java`

```java
package com.tekgrads;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan("com.tekgrads")
public class App {
    public static void main(String[] args) {
        // Getting HelloWorldMessage bean directly
        AnnotationConfigApplicationContext ctxt = new AnnotationConfigApplicationContext(App.class);
        HelloWorldMessage hm = ctxt.getBean(HelloWorldMessage.class);
        System.out.println(hm.getMessage());

        // Dependency injection: Getting Greeting bean which depends on HelloWorldMessage
        AnnotationConfigApplicationContext ctxt1 = new AnnotationConfigApplicationContext(App.class);
        Greeting greeter = ctxt1.getBean(Greeting.class);
        greeter.greet();
    }
}
```

---

## ✅ Output

```
hii hello
hii hello
```

---


## 📄 Example 2:– Setter-Based Injection

---

## 📄 Greeting.java

```java
package com.tekgrads;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Greeting {
    HelloWorldMessage hm;

    // Getter
    public HelloWorldMessage getHm() {
        return hm;
    }

    // Setter injection with @Autowired (optional)
    @Autowired(required = false)
    public void setHm(HelloWorldMessage hm) {
        this.hm = hm;
    }

    public void greet() {
        if (this.hm != null) {
            System.out.println(this.hm.getMessage());
        } else {
            System.out.println("message is not found.");
        }
    }
}
```

---

## 📄 HelloWorldMessage.java

```java
package com.tekgrads;

import org.springframework.stereotype.Component;
  
public class HelloWorldMessage {
	public String getMessage() {
		return "hii hello";
	}
 
}
```

---

## 📄 App.java

```java
package com.tekgrads;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan("com.tekgrads")
public class App {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext ctxt2 = new AnnotationConfigApplicationContext(App.class);
        Greeting greeter1 = ctxt2.getBean(Greeting.class);
        greeter1.greet();
    }
}
```

---

## ✅ Output

```
message is not found.
```

---

## 💡 Notes

* `@Autowired(required=false)` tells Spring to inject the bean only if it's available.
* Since there is no `HelloWorldMessage` bean defined in this example, `null` is injected.
* You can define and register `HelloWorldMessage` to test successful injection.

---


## 🔄 Example 3 – Circular Injection (Constructor-Based)


---

## 📄 Greeting.java

```java
package com.tekgrads;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

// Circular injection: Greeting depends on HelloWorldMessage
@Component
	public class Greeting {
	   private  HelloWorldMessage hm;

	    // Constructor-based injection
	   @Autowired
	    public Greeting(HelloWorldMessage hm) {
	        this.hm = hm;
	    }
		public void greet() {
		System.out.println(hm.getMessage());	
		}
	}


```

---

## 📄 HelloWorldMessage.java

```java
package com.tekgrads;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

// HelloWorldMessage depends on Greeting
@Component
public class HelloWorldMessage {
    private Greeting greeting;

    // Constructor injection causes circular dependency
    @Autowired
    public HelloWorldMessage(Greeting greeting) {
        this.greeting = greeting;
    }

    public String getMessage() {
        return "hii hello";
    }
}
```

---

## 📄 App.java

```java
package com.tekgrads;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan("com.tekgrads")
public class App {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext ctxt2 = new AnnotationConfigApplicationContext(App.class);
        Greeting greeter1 = ctxt2.getBean(Greeting.class);
        greeter1.greet();
    }
}
```

---

## ❌ Output / Error

```
Error creating bean with name 'greeting': Requested bean is currently in creation: Is there an unresolvable circular reference?
```

---

## 🛠️ Explanation

* Constructor-based circular dependencies are **not resolvable** by Spring because both beans are waiting for each other’s constructor to finish.
* To fix this, use **setter injection** or `@Lazy` annotations.

---

> ⚠️ Avoid circular constructor dependencies in Spring by using setter or field injection.



#### ✅ Example 4 – Avoid Circular Dependency using Setter Injection

This example shows how to avoid **circular dependency** in Spring using **setter-based injection**.

---

## 📄 `HelloWorldMessage.java`

```java
package com.tekgrads;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class HelloWorldMessage {
    private Greeting greeting;

    // Setter-based injection avoids circular constructor issue
    @Autowired
    public void setGreeting(Greeting greeting) {
        this.greeting = greeting;
    }

    public Greeting getGreeting() {
        return greeting;
    }

    public String getMessage() {
        return "hii hello";
    }
}
```

---

## 📄 `Greeting.java`

```java
package com.tekgrads;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Greeting {
    private HelloWorldMessage hm;

    // Setter-based injection
    @Autowired
    public void setHm(HelloWorldMessage hm) {
        this.hm = hm;
    }

    public HelloWorldMessage getHm() {
        return hm;
    }

    public void greet() {
        if (this.hm != null) {
            System.out.println(this.hm.getMessage());
        } else {
            System.out.println("message is not found.");
        }
    }
}
```

---

## 📄 `App.java`

```java
package com.tekgrads;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan("com.tekgrads")
public class App {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext ctxt2 = new AnnotationConfigApplicationContext(App.class);
        Greeting greeter1 = ctxt2.getBean(Greeting.class);
        greeter1.greet();
    }
}
```

---

## 🖥️ Output

```
hii hello
```

---

## 🔍 Summary

* Circular dependencies can cause runtime errors when using constructor injection.
* Setter injection allows Spring to manage and resolve bean creation order.

> ☑️ Use setter-based injection or `@Lazy` to resolve circular dependencies in Spring.



## 🧱 Types of Classes

### 1. **POJO Class (Plain Old Java Object)**

* A simple class with fields, constructors, getters, and setters — no special logic.
* Used to hold data or models.

### 2. **Configuration Metadata**

* Blueprint of the Spring application.
* Defines the beans and their wiring.

### 3. **Spring Container**

* Manages the Spring beans (creation, configuration, and management).

---

## 📦 Core Packages

### 1. `org.springframework.context`

* Provides `ApplicationContext` and support for dependency injection, event handling, internationalization, etc.

### 2. `org.springframework.beans`

* Provides classes for configuring, creating, and managing beans in the Spring container.

---

## 🧠 ApplicationContext – Simple Definition

`ApplicationContext` is the Spring container that:

* Loads bean definitions.
* Creates and wires beans.
* Provides access to beans throughout the application.

📌 *Think of it as a factory that manages all the objects (beans) your app needs.*

### ✨ Features of ApplicationContext

1. Manages beans and their lifecycle
2. Supports dependency injection
3. Provides internationalization
4. Publishes events
5. Supports annotations like `@Component`, `@Autowired`, etc.

---

## 📘 Bean Registry

A Bean Registry in Spring is where all Spring-managed objects (beans) are registered, stored, and managed.

* Maintains information of all beans.
* Allows lookup by name or type.
* Manages lifecycle: creation, injection, destruction.

---

## 💻 Code Example

### `App.java`

```java
package com.tekgrads;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan("com.tekgrads")
public class App {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext ctxt = new AnnotationConfigApplicationContext(App.class);
        HelloWorldMessage hm = ctxt.getBean(HelloWorldMessage.class);
        System.out.println(hm.getMessage());

        // Dependency injection
        AnnotationConfigApplicationContext ctxt1 = new AnnotationConfigApplicationContext(App.class);
        Greeting greeter = ctxt1.getBean(Greeting.class);
        greeter.greet();

        // Printing all the beans
        String[] beanlist = ctxt.getBeanDefinitionNames();
        for (String name : beanlist) {
            System.out.println(name);
        }
    }
}
```

### 🖨️ Output

```
hii hello
hii hello
org.springframework.context.annotation.internalConfigurationAnnotationProcessor
org.springframework.context.annotation.internalAutowiredAnnotationProcessor
org.springframework.context.event.internalEventListenerProcessor
org.springframework.context.event.internalEventListenerFactory
app
greeting
helloWorldMessage
```


### 🌱  byType and byName

Spring supports multiple types of autowiring for injecting dependencies into beans. Two common types are:

---

#### 🔹 `byType`

Spring injects the dependency by **matching the data type** of the property.

#### 🔹 `byName`

Spring injects the dependency by **matching the property name** with the bean name.

---

---

## 🧾 Bean Scope

Bean scope defines how many times a bean is created and how long it lives in the Spring container.

### 1. **Singleton** (Default)

* One object shared across the app.

### 2. **Prototype**

* Creates a new object each time it's requested.

---



