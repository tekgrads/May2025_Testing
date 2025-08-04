# Java Spring Bean Concepts:

---

## 1. **Default Behaviour of Beans**

- Spring beans are **singleton by default**, meaning one instance is created per Spring container.
- Beans are **eagerly initialized** by default unless marked with `@Lazy`.
- You can switch to **prototype** scope to create a new instance for each request.

---

## 2. **Basic Bean Example**

```java
package com.tekgrads;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;

public class App {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext ctxt = new AnnotationConfigApplicationContext(App.class);    
        Greeter greeter = ctxt.getBean(Greeter.class);
        greeter.greet();
    }

    @Bean
    public Greeter getGreeter(HelloWorldMessage helloWorldMessage) {
        return new Greeter(helloWorldMessage);
    }

    @Bean
    public HelloWorldMessage getHelloWorldMessage(String greetingMessage) {
        return new HelloWorldMessage(greetingMessage);
    }

    @Bean
    String getGreetingMessage() {
        return "hello sathvika";
    }
}
````

```java
package com.tekgrads;

public class HelloWorldMessage {
    private String greetingMessage;

    public HelloWorldMessage(String greetingMessage) {
        this.greetingMessage = greetingMessage;
    }

    public String getMessage() {
        return this.greetingMessage;
    }
}
```

```java
package com.tekgrads;

public class Greeter {
    HelloWorldMessage helloWorldMessage;

    public Greeter(HelloWorldMessage helloWorldMessage) {
        this.helloWorldMessage = helloWorldMessage;
    }

    public void greet() {
        System.out.println(helloWorldMessage.getMessage());
    }
}
```

**Output:**
`hello sathvika`

---

## 3. **Singleton Bean Behavior**

```java
HelloWorldMessage helloWorldMessage1 = ctxt.getBean(HelloWorldMessage.class);
helloWorldMessage1.setGreetingMessage("hello sathvika1");

HelloWorldMessage helloWorldMessage2 = ctxt.getBean(HelloWorldMessage.class);
helloWorldMessage2.setGreetingMessage("hello sathvika2");

greeter.setHelloWorldMessage(helloWorldMessage1);
greeter.greet();

greeter.setHelloWorldMessage(helloWorldMessage2);
greeter.greet();
```

**Output (Singleton):**
`hello sathvika2`

---

## 4. **@Scope("prototype")**

Used to make Spring return a new instance every time bean is requested.

**Output (Prototype):**
`hello sathvika1`
`hello sathvika2`

---

## 5. **Autowired by Type (Ambiguity)**

```java
@Configuration
@ComponentScan("com.tekgrads")
public class App {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext ctxt = new AnnotationConfigApplicationContext(App.class);
        Greeter greeter = ctxt.getBean(Greeter.class);
        greeter.greet();
        ctxt.close();
    }
}
```

```java
package com.tekgrads;

import org.springframework.stereotype.Component;

@Component
public class Hello implements Message {
    public String getMessage() {
        return "hello sathvika";
    }
}
```

```java
package com.tekgrads;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
@Qualifier("hey")
public class Hey implements Message {
    public String getMessage() {
        return "hey sathvika";
    }
}
```

```java
package com.tekgrads;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class Greeter {
    private Message message;

    public Greeter(@Qualifier("hello") Message message) {
        this.message = message;
    }

    public void greet() {
        System.out.println(message.getMessage());
    }
}
```

```java
package com.tekgrads;

public interface Message {
    String getMessage();
}
```

**Output:**
`hello sathvika`

---

## 6. **@Qualifier**

* Used to resolve ambiguity when multiple beans of the same type exist.
* Specifies which bean to inject using the bean name.

---

## 7. **@ComponentScan("com.tekgrads")**

* Instructs Spring to scan the specified package for components like `@Component`, `@Service`, `@Repository`, etc.

---

## 8. **@Configuration**

* Marks a class as a source of bean definitions.
* It is equivalent to traditional `applicationContext.xml`.

---

## 9. **Eager Bean Example (Default)**

```java
public class App {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext ctxt = new AnnotationConfigApplicationContext(App.class);
        System.out.println("context initialised");
        ctxt.close();
    }
}
```

**Output:**

```
HelloWorldMessage Created  
greeter is created  
context initialised  
```

---

## 10. **@Lazy**

* Postpones bean creation until it's requested.
* Saves resources and time during context initialization.

```java
@Bean
@Lazy
public Greeter getGreeter(HelloWorldMessage helloWorldMessage) {
    return new Greeter(helloWorldMessage);
}
```

**Output:**

```
context initialised  
HelloWorldMessage Created  
greeter is created  
hello sathvika  
```

---

## 11. **@Primary**

* Used when multiple beans match a dependency.
* Marks one bean as the default choice for autowiring.

---

## 12. **@DependsOn and @Order**

```java
@Component
@DependsOn("taskB")
public class TaskA implements Task {
    public TaskA() {
        System.out.println("Task A is created");
    }
    public void execute() {
        System.out.println("Task A is executed");
    }
}
```

```java
@Component
@Order(1)
public class TaskB implements Task {
    public TaskB() {
        System.out.println("Task B is created");
    }
    public void execute() {
        System.out.println("Task B is executed");
    }
}
```

**Output:**

```
Task B is created  
Task A is created  
```

---

## 13. **Bean Lifecycle: @PostConstruct and @PreDestroy**

```java
@Component
public class TaskA implements Task {
    public TaskA() {
        System.out.println("Task A is created");
    }

    @PostConstruct
    public void postInit() {
        System.out.println("after task A got created");
    }

    @PreDestroy
    public void preDestroy() {
        System.out.println("before task A got destroyed");
    }

    public void execute() {
        System.out.println("Task A is executed");
    }
}
```

**Output:**

```
Task A is created  
after task A got created  
before task A got destroyed  
```

---

## 14. **@Service and @Repository**

### `@Service`

* Marks a class as a **service layer** component.
* Used to define business logic.
* Behaves like `@Component`.

### `@Repository`

* Marks a class as a **DAO layer** component.
* Used to interact with databases.
* Translates database-related exceptions into Spring's DataAccessException.

```
```
