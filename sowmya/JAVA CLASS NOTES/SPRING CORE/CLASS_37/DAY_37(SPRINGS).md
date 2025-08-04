
## 📘 What is `@Bean`?

`@Bean` is a Spring annotation used to **manually define a bean** in a configuration class. It tells Spring:

> Create and manage this method’s return object as a Spring bean.

---

## 💡 Example 1: Creating Beans Using `@Bean`

### 📄 `HelloWorldMessage.java`

```java
package com.tekgrads;

public class HelloWorldMessage {

    String greetingMessage;

    // Constructor injection
    public HelloWorldMessage(String greetingMessage) {
        this.greetingMessage = greetingMessage;
    }

    public String getMessage() {
        return this.greetingMessage;
    }
}
```

---

### 📄 `Greeting.java`

```java
package com.tekgrads;

public class Greeting {
    private HelloWorldMessage helloworldmsg;

    // Constructor injection
    public Greeting(HelloWorldMessage helloworldmsg) {
        this.helloworldmsg = helloworldmsg;
    }

    public void greet() {
        System.out.println(helloworldmsg.getMessage());
    }
}
```

---

### 📄 `App.java`

```java
package com.tekgrads;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class App {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext ctxt = new AnnotationConfigApplicationContext(App.class);
        Greeting greeting = ctxt.getBean(Greeting.class);
        greeting.greet();
    }

    // Define beans

    // msg ➝ HelloWorldMessage ➝ Greeting

    @Bean
    Greeting getGreeting(HelloWorldMessage helloworldmsg) {
        return new Greeting(helloworldmsg);
    }

    @Bean
    HelloWorldMessage getHelloWorldMessage(String greetingMessage) {
        return new HelloWorldMessage(greetingMessage);
    }

    @Bean
    String getGreetingMessage() {
        return "hii hello welcome to beans";
    }
}
```

---

## 🖥️ Output

```
hii hello welcome to beans
```

---

## 📝 Note

If we pass the message ➝ it goes to `HelloWorldMessage` ➝ which goes to `Greeting`. This shows proper **constructor injection** with Spring-managed beans.



## 🔍 What is Bean Scope?

Bean scope defines:

* **How many instances** of a bean are created.
* **How long** they live in the Spring container.

## 📌 Types of Bean Scopes

1. ### `Singleton` (Default)

   * Only **one shared instance** of the bean is created.
   * Used by default in Spring.

2. ### `Prototype`

   * A **new instance** is created each time the bean is requested.

---

## 🧠 Lazy vs Eager Beans

### 🔹 Lazy Bean

* Created **only when first requested**.
* Use `@Lazy` annotation.

### 🔹 Eager Bean

* Created **as soon as Spring container starts**.
* This is the **default behavior**.

---

## ✅ Example 2: Singleton Bean

### 📄 `HelloWorldMessage.java`

```java
package com.tekgrads;

public class HelloWorldMessage {
    String greetingMessage;

    public HelloWorldMessage(String greetingMessage) {
        this.greetingMessage = greetingMessage;
    }

    public String getGreetingMessage() {
        return greetingMessage;
    }

    public void setGreetingMessage(String greetingMessage) {
        this.greetingMessage = greetingMessage;
    }

    public String getMessage() {
        return this.greetingMessage;
    }
}
```

### 📄 `Greeting.java`

```java
package com.tekgrads;

public class Greeting {
    private HelloWorldMessage helloworldmsg;

    public Greeting(HelloWorldMessage helloworldmsg) {
        this.helloworldmsg = helloworldmsg;
    }

    public void greet() {
        System.out.println(helloworldmsg.getMessage());
    }

    public void setHelloworldmsg(HelloWorldMessage helloworldmsg) {
        this.helloworldmsg = helloworldmsg;
    }
}
```

### 📄 `App.java`

```java
package com.tekgrads;

import org.springframework.context.annotation.*;

@Configuration
public class App {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext ctxt = new AnnotationConfigApplicationContext(App.class);
        Greeting greeting = ctxt.getBean(Greeting.class);
        greeting.greet();

        HelloWorldMessage hm1 = ctxt.getBean(HelloWorldMessage.class);
        hm1.setGreetingMessage("creating hello world for 1st time");

        HelloWorldMessage hm2 = ctxt.getBean(HelloWorldMessage.class);
        hm2.setGreetingMessage("creating hello world for 2nd time");

        greeting.setHelloworldmsg(hm1);
        greeting.greet();
        greeting.setHelloworldmsg(hm2);
        greeting.greet();
    }

    @Bean
    Greeting getGreeting(HelloWorldMessage helloworldmsg) {
        return new Greeting(helloworldmsg);
    }

    @Bean
    HelloWorldMessage getHelloWorldMessage() {
        return new HelloWorldMessage(getGreetingMessage());
    }

    @Bean
    String getGreetingMessage() {
        return "hii hello welcome to beans";
    }
}
```

### 🖥️ Output

```
hii hello welcome to beans
creating hello world for 2nd time
creating hello world for 2nd time
```

---

## ✅ Example 3: Prototype Bean

### 📄 `HelloWorldMessage.java`

```java
package com.tekgrads;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("prototype")
public class HelloWorldMessage {
    String greetingMessage;

    public String getGreetingMessage() {
        return greetingMessage;
    }

    public void setGreetingMessage(String greetingMessage) {
        this.greetingMessage = greetingMessage;
    }

    public String getMessage() {
        return this.greetingMessage;
    }
}
```

### 📄 `Greeting.java`

```java
package com.tekgrads;

import org.springframework.stereotype.Component;

@Component
public class Greeting {
    private HelloWorldMessage helloworldmsg;

    public Greeting(HelloWorldMessage helloworldmsg) {
        this.helloworldmsg = helloworldmsg;
    }

    public void greet() {
        System.out.println(helloworldmsg.getMessage());
    }

    public void setHelloworldmsg(HelloWorldMessage helloworldmsg) {
        this.helloworldmsg = helloworldmsg;
    }
}
```

### 📄 `App.java`

```java
package com.tekgrads;

import org.springframework.context.annotation.*;

@Configuration
@ComponentScan("com.tekgrads")
public class App {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext ctxt = new AnnotationConfigApplicationContext(App.class);
        Greeting greeting = ctxt.getBean(Greeting.class);
        greeting.greet();

        HelloWorldMessage hm1 = ctxt.getBean(HelloWorldMessage.class);
        hm1.setGreetingMessage("creating hello world for 1st time");

        HelloWorldMessage hm2 = ctxt.getBean(HelloWorldMessage.class);
        hm2.setGreetingMessage("creating hello world for 2nd time");

        greeting.setHelloworldmsg(hm1);
        greeting.greet();
        greeting.setHelloworldmsg(hm2);
        greeting.greet();
    }
}
```

### 📝 Note:

Every time a `HelloWorldMessage` is requested, a **new instance** is created due to `@Scope("prototype")`.

### 🖥️ Output

```
null
creating hello world for 1st time
creating hello world for 2nd time
```

---



## 📌 Example 4: Eager Bean Initialization

### 📄 `HelloWorldMessage.java`

```java
package com.tekgrads;

public class HelloWorldMessage {
    String greetingMessage;

    public HelloWorldMessage(String greetingMessage) {
        System.out.println("HelloWorldMessage constructor Created");
        this.greetingMessage = greetingMessage;
    }

    public String getMessage() {
        return this.greetingMessage;
    }

    public String getGreetingMessage() {
        return greetingMessage;
    }

    public void setGreetingMessage(String greetingMessage) {
        this.greetingMessage = greetingMessage;
    }
}
```

### 📄 `Greeting.java`

```java
package com.tekgrads;

public class Greeting {
    private HelloWorldMessage helloWorldMessage;

    public Greeting(HelloWorldMessage helloWorldMessage) {
        System.out.println("Greeting constructor Created");
        this.helloWorldMessage = helloWorldMessage;
    }

    public void greet() {
        System.out.println(helloWorldMessage.getMessage());
    }
}
```

### 📄 `App.java`

```java
package com.tekgrads;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class App {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext ctxt = new AnnotationConfigApplicationContext(App.class);
        System.out.println("Contextconfig created");
    }

    @Bean
    Greeting getGreeter(HelloWorldMessage helloWorldMessage) {
        return new Greeting(helloWorldMessage);
    }

    @Bean
    HelloWorldMessage getHelloWorldMessage(String greetingMessage) {
        return new HelloWorldMessage(greetingMessage);
    }

    @Bean
    String getGreetingMessage() {
        return "eager bean";
    }
}
```

### ✅ Output:

```
HelloWorldMessage constructor Created
Greeting constructor Created
Contextconfig created
```

> 🔍 **Note**: All beans are created at context initialization. If we want to delay creation, use `@Lazy`.

---

## 🐢 Example 5: Lazy Bean Initialization

### 📄 `HelloWorldMessage.java`

```java
package com.tekgrads;

public class HelloWorldMessage {
    String greetingMessage;

    public HelloWorldMessage(String greetingMessage) {
        System.out.println("HelloWorldMessage constructor Created");
        this.greetingMessage = greetingMessage;
    }

    public String getMessage() {
        return this.greetingMessage;
    }

    public String getGreetingMessage() {
        return greetingMessage;
    }

    public void setGreetingMessage(String greetingMessage) {
        this.greetingMessage = greetingMessage;
    }
}
```

### 📄 `Greeting.java`

```java
package com.tekgrads;

public class Greeting {
    private HelloWorldMessage helloWorldMessage;

    public Greeting(HelloWorldMessage helloWorldMessage) {
        System.out.println("Greeting constructor Created");
        this.helloWorldMessage = helloWorldMessage;
    }

    public void greet() {
        System.out.println(helloWorldMessage.getMessage());
    }
}
```

### 📄 `App.java`

```java
package com.tekgrads;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;

@Configuration
public class App {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext ctxt = new AnnotationConfigApplicationContext(App.class);
        System.out.println("Contextconfig created");
        Greeting greeting = ctxt.getBean(Greeting.class);
        greeting.greet();
    }

    @Bean
    @Lazy
    Greeting getGreeter(HelloWorldMessage helloWorldMessage) {
        return new Greeting(helloWorldMessage);
    }

    @Bean
    //@Lazy
    HelloWorldMessage getHelloWorldMessage(String greetingMessage) {
        return new HelloWorldMessage(greetingMessage);
    }

    @Bean
    String getGreetingMessage() {
        return "lazy bean";
    }
}
```

### ✅ Output:

```
HelloWorldMessage constructor Created
Contextconfig created
Greeting constructor Created
lazy bean
```

> 💡 **Note**: Putting `@Lazy` on `getHelloWorldMessage` instead of `getGreeter` changes the creation order. The Greeting bean will then depend on lazy initialization.

---




## 🔁 Bean Scopes in Spring

Spring supports several bean scopes. Here are three common ones:

1. **Request Scope**
   ➤ Used for a single HTTP request.

2. **Session Scope**
   ➤ Used for a single browser session.

3. **Application Scope**
   ➤ Used for the entire lifecycle of the application context.

---

## 🔧 Autowiring: `byType` vs `byName`

Spring provides multiple ways to autowire dependencies into beans:

* **byType**: Injects the dependency by matching the **data type**.
* **byName**: Injects the dependency by matching the **property name** with the bean name.

> 🔸 The previous examples were `byType`. Below is an example using `byName` via `@Qualifier`.

---

## 💻 Example 6: Autowiring Using `@Qualifier` (byName)

### 📄 `Message.java`

```java
package com.tekgrads;

public interface Message {
    String getMessage();
}
```

### 📄 `FirstMessage.java`

```java
package com.tekgrads;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
@Qualifier("1st msg")
public class FirstMessage implements Message {
    @Override
    public String getMessage() {
        return "this is 1st message";
    }
}
```

### 📄 `SecondMessage.java`

```java
package com.tekgrads;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
@Qualifier("2nd msg")
public class SecondMessage implements Message {
    @Override
    public String getMessage() {
        return "this is 2nd message";
    }
}
```

### 📄 `Greeting.java`

```java
package com.tekgrads;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class Greeting {
    private Message message;

    // Injecting SecondMessage using Qualifier
    public Greeting(@Qualifier("2nd msg") Message message) {
        this.message = message;
    }

    public void greet() {
        System.out.println(message.getMessage());
    }
}
```

### 📄 `App.java`

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
        Greeting greeting = ctxt.getBean(Greeting.class);
        greeting.greet();
    }
}
```

---

## ✅ Output

```
this is 2nd message
```

---

> 📌 You can switch the output by changing `@Qualifier("2nd msg")` to `@Qualifier("1st msg")` in the `Greeting` constructor.




## 🎯 `@Qualifier`

`@Qualifier` is used when multiple beans of the same type exist, and you want to specify exactly **which one** to inject.

---

## ⭐ `@Primary` – Default Bean

`@Primary` marks a bean as the **default** when there are multiple candidates and **no `@Qualifier`** is used.

---

## 🧪 Example 7: Using `@Primary`

### 📄 `Message.java`

```java
package com.tekgrads;

public interface Message {
    public String getMessage();
}
```

### 📄 `FirstMessage.java`

```java
package com.tekgrads;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
@Qualifier("1st msg")
@Primary
public class FirstMessage implements Message {
    @Override
    public String getMessage() {
        return "this is 1st message";
    }
}
```

### 📄 `SecondMessage.java`

```java
package com.tekgrads;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
@Qualifier("2nd msg")
public class SecondMessage implements Message {
    @Override
    public String getMessage() {
        return "this is 2nd message";
    }
}
```

### 📄 `Greeting.java`

```java
package com.tekgrads;

import org.springframework.stereotype.Component;

@Component
public class Greeting {
    private Message message;

    public Greeting(Message message) {
        this.message = message;
    }

    public void greet() {
        System.out.println(message.getMessage());
    }
}
```

### 📄 `App.java`

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
        Greeting greeting = ctxt.getBean(Greeting.class);
        greeting.greet();
    }
}
```

---

## 🖥️ Output

```
this is 1st message
```

📌 **Note**: Since `FirstMessage` is marked with `@Primary`, it gets injected automatically when no `@Qualifier` is specified.

---



## 🔁 `@Order`

`@Order` is used to set the **priority or execution order** of Spring components like beans, filters, or aspects.

* Lower numbers run first (higher priority).

---

## 🔗 `@DependsOn`

`@DependsOn` tells Spring to initialize a bean **only after** another specified bean has been initialized.

---

## 📌 Example 8: Program on `@DependsOn`

### 🔹 `Task.java`

```java
package com.tekgrads;

public interface Task {
    public void print();
}
```

### 🔹 `FirstTask.java`

```java
package com.tekgrads;

import org.springframework.stereotype.Component;

@Component
public class FirstTask implements Task {
    public FirstTask() {
        System.out.println("1st task created");
    }

    @Override
    public void print() {
        System.out.println("1st task printed");
    }
}
```

### 🔹 `SecondTask.java`

```java
package com.tekgrads;

import org.springframework.context.annotation.DependsOn;
import org.springframework.stereotype.Component;

@Component
@DependsOn("thirdTask")
public class SecondTask implements Task {
    public SecondTask() {
        System.out.println("2nd task created");
    }

    @Override
    public void print() {
        System.out.println("2nd task printed");
    }
}
```

### 🔹 `ThirdTask.java`

```java
package com.tekgrads;

import org.springframework.stereotype.Component;

@Component
public class ThirdTask implements Task {
    public ThirdTask() {
        System.out.println("3rd task created");
    }

    @Override
    public void print() {
        System.out.println("3rd task printed");
    }
}
```

### 🔹 `App.java`

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
        System.out.println("Context is using");
    }
}
```

### ✅ Output:

```
1st task created
3rd task created
2nd task created
Context is using
```

> Here the `SecondTask` depends on `ThirdTask`, so `ThirdTask` is created first.

---

## 📌 Example 9: Program on `@Order`

### 🔹 `Task.java`

```java
package com.tekgrads;

public interface Task {
    public void print();
}
```

### 🔹 `FirstTask.java`

```java
package com.tekgrads;

import org.springframework.context.annotation.DependsOn;
import org.springframework.stereotype.Component;

@Component
@DependsOn("secondTask")
public class FirstTask implements Task {
    public FirstTask() {
        System.out.println("1st task created");
    }

    @Override
    public void print() {
        System.out.println("1st task printed");
    }
}
```

### 🔹 `SecondTask.java`

```java
package com.tekgrads;

import org.springframework.stereotype.Component;

@Component
public class SecondTask implements Task {
    public SecondTask() {
        System.out.println("2nd task created");
    }

    @Override
    public void print() {
        System.out.println("2nd task printed");
    }
}
```

### 🔹 `OrderTest.java`

```java
package com.tekgrads;

import org.springframework.stereotype.Component;

@Component
public class OrderTest {
    private FirstTask firsttask;
    private SecondTask secondtask;

    public OrderTest(FirstTask firsttask, SecondTask secondtask) {
        this.firsttask = firsttask;
        this.secondtask = secondtask;
    }

    public FirstTask getFirstTask() {
        return firsttask;
    }

    public SecondTask getSecondTask() {
        return secondtask;
    }
}
```

### 🔹 `App.java`

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
        System.out.println("Context is using");

        OrderTest orderTest = ctxt.getBean(OrderTest.class);
        orderTest.getFirstTask().print();
        orderTest.getSecondTask().print();
    }
}
```

### ✅ Output:

```
2nd task created
1st task created
Context is using
1st task printed
2nd task printed
```

> `FirstTask` is initialized after `SecondTask` because of `@DependsOn("secondTask")`, and then used first.

---


---

## 📘 Example 10: Program using `@DependsOn`

### 🔹 Task.java
```java
package com.tekgrads;

public interface Task {
    public void print();
}
```

### 🔹 FirstTask.java
```java
package com.tekgrads;

import org.springframework.context.annotation.DependsOn;
import org.springframework.stereotype.Component;

@Component
@DependsOn("secondTask")
public class FirstTask implements Task {
    public FirstTask() {
        System.out.println("1st task created");
    }

    @Override
    public void print() {
        System.out.println("1st task printed");
    }
}
```

### 🔹 SecondTask.java
```java
package com.tekgrads;

import org.springframework.stereotype.Component;

@Component
public class SecondTask implements Task {
    public SecondTask() {
        System.out.println("2nd task created");
    }

    @Override
    public void print() {
        System.out.println("2nd task printed");
    }
}
```

### 🔹 OrderTestOne.java
```java
package com.tekgrads;

import java.util.List;
import org.springframework.stereotype.Component;

@Component
public class OrderTestOne {
    private List<Task> tasks;

    public OrderTestOne(List<Task> tasks) {
        this.tasks = tasks;
    }

    public List<Task> getTasks() {
        return tasks;
    }

    public void setTasks(List<Task> tasks) {
        this.tasks = tasks;
    }
}
```

### 🔹 App.java
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
        System.out.println("Context is using");
        OrderTestOne orderTestone = ctxt.getBean(OrderTestOne.class);
        for(Task task : orderTestone.getTasks()) {
            task.print();
        }
        ctxt.close();
    }
}
```

### ✅ Output
```
2nd task created
1st task created
Context is using
1st task printed
2nd task printed
```

---

## 📘 Example 11: Program using `@Order(1)`
### 🔹 Task.java
```java
package com.tekgrads;

public interface Task {
    public void print();
}
```

### 🔹 FirstTask.java
```java
package com.tekgrads;

import org.springframework.context.annotation.DependsOn;
import org.springframework.stereotype.Component;

@Component
@DependsOn("secondTask")
public class FirstTask implements Task {
    public FirstTask() {
        System.out.println("1st task created");
    }

    @Override
    public void print() {
        System.out.println("1st task printed");
    }
}
```


### 🔹 SecondTask.java
```java
package com.tekgrads;

import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Order(1)
public class SecondTask implements Task {
    public SecondTask() {
        System.out.println("2nd task created");
    }

    @Override
    public void print() {
        System.out.println("2nd task printed");
    }
}
```
### 🔹 OrderTestOne.java
```java
package com.tekgrads;

import java.util.List;
import org.springframework.stereotype.Component;

@Component
public class OrderTestOne {
    private List<Task> tasks;

    public OrderTestOne(List<Task> tasks) {
        this.tasks = tasks;
    }

    public List<Task> getTasks() {
        return tasks;
    }

    public void setTasks(List<Task> tasks) {
        this.tasks = tasks;
    }
}
```

### 🔹 App.java
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
        System.out.println("Context is using");
        OrderTestOne orderTestone = ctxt.getBean(OrderTestOne.class);
        for(Task task : orderTestone.getTasks()) {
            task.print();
        }
        ctxt.close();
    }
}
```

### ✅ Output
```
2nd task created
1st task created
Context is using
2nd task printed
1st task printed
```

### Spring Lifecycle Callbacks

Lifecycle callbacks are special methods that Spring calls automatically when a bean is **created (initialized)** or **destroyed (closed)**.

---

## 🔹 Common Lifecycle Annotations

* `@PostConstruct`: Runs *after* the bean is created
* `@PreDestroy`: Runs *before* the bean is destroyed

---

## 📄 Example 12: Program Lifecycle Callbacks

### **Task.java**

```java
package com.tekgrads;

public interface Task {
    public void print();
}
```

### **FirstTask.java**

```java
package com.tekgrads;

import org.springframework.context.annotation.DependsOn;
import org.springframework.stereotype.Component;
import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;

@Component
@DependsOn("secondTask")
public class FirstTask implements Task {
    public FirstTask() {
        System.out.println("1st task created");
    }

    @Override
    public void print() {
        System.out.println("1st task printed");
    }

    @PostConstruct
    public void postInit() {
        System.out.println("After task one has created");
    }

    @PreDestroy
    public void preDestroy() {
        System.out.println("Before task one is getting destroyed");
    }
}
```

### **SecondTask.java**

```java
package com.tekgrads;

import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Order(1)
public class SecondTask implements Task {
    public SecondTask() {
        System.out.println("2nd task created");
    }

    @Override
    public void print() {
        System.out.println("2nd task printed");
    }
}
```

### **OrderTestOne.java**

```java
package com.tekgrads;

import java.util.List;
import org.springframework.stereotype.Component;

@Component
public class OrderTestOne {
    private List<Task> tasks;

    public OrderTestOne(List<Task> tasks) {
        this.tasks = tasks;
    }

    public List<Task> getTasks() {
        return tasks;
    }

    public void setTasks(List<Task> tasks) {
        this.tasks = tasks;
    }
}
```

### **App.java**

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
        System.out.println("Context is using");

        OrderTestOne orderTestone = ctxt.getBean(OrderTestOne.class);
        for (Task task : orderTestone.getTasks()) {
            task.print();
        }

        ctxt.close();
    }
}
```

---

## 🖨️ Output

```
2nd task created
1st task created
After task one has created
Context is using
2nd task printed
1st task printed
Before task one is getting destroyed
```
