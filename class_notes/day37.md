Spring Beans – Complete Guide
🔹 What is a Spring Bean?

A Spring Bean is an object that is managed by the Spring IoC (Inversion of Control) container.

In simple terms, any Java object that is instantiated, assembled, and managed by the Spring container is called a bean.

Beans are defined in configuration metadata (XML, Java annotations, or Java configuration classes).

🔹 Lifecycle of a Spring Bean

Instantiation → Spring creates the bean instance.

Dependency Injection → Spring injects required dependencies.

Initialization → Custom init methods (if defined) are executed.

Bean is Ready → Available for use in the application.

Destruction → On application shutdown, Spring calls destroy methods.

🔹 Declaring Beans
1. Using XML Configuration
<beans xmlns="http://www.springframework.org/schema/beans"
       xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
       xsi:schemaLocation="
         http://www.springframework.org/schema/beans
         http://www.springframework.org/schema/beans/spring-beans.xsd">

    <!-- Defining a bean -->
    <bean id="greetingService" class="com.example.GreetingService" />

</beans>

2. Using Annotations
import org.springframework.stereotype.Component;

@Component
public class GreetingService {
    public String greet() {
        return "Hello from Spring Bean!";
    }
}

3. Using Java Configuration
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {
    
    @Bean
    public GreetingService greetingService() {
        return new GreetingService();
    }
}

🔹 Bean Scopes

Spring defines different scopes for how beans are created and shared.

Scope	Description
singleton (default)	One shared instance per Spring container.
prototype	A new instance is created each time it is requested.
request	One instance per HTTP request (Spring Web only).
session	One instance per HTTP session (Spring Web only).
application	One instance per ServletContext.
Example
<!-- Singleton bean -->
<bean id="singletonBean" class="com.example.MyBean" scope="singleton"/>

<!-- Prototype bean -->
<bean id="prototypeBean" class="com.example.MyBean" scope="prototype"/>

🔹 Dependency Injection in Beans

Spring can inject dependencies into beans in two ways:

1. Constructor Injection
public class MyApp {
    private GreetingService greetingService;

    public MyApp(GreetingService greetingService) {
        this.greetingService = greetingService;
    }

    public void run() {
        System.out.println(greetingService.greet());
    }
}

2. Setter Injection
public class MyApp {
    private GreetingService greetingService;

    public void setGreetingService(GreetingService greetingService) {
        this.greetingService = greetingService;
    }

    public void run() {
        System.out.println(greetingService.greet());
    }
}

🔹 Bean Lifecycle Methods
Example
import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

public class MyBean {

    @PostConstruct
    public void init() {
        System.out.println("Bean is initialized!");
    }

    public void doWork() {
        System.out.println("Bean is working...");
    }

    @PreDestroy
    public void destroy() {
        System.out.println("Bean is being destroyed!");
    }
}


Output during lifecycle:

Bean is initialized!
Bean is working...
Bean is being destroyed!

🔹 Example: Using Spring Beans
Configuration
@Configuration
@ComponentScan(basePackages = "com.example")
public class AppConfig {}

Bean
@Component
public class GreetingService {
    public String greet() {
        return "Hello, Spring Bean!";
    }
}

Main Class
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MainApp {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(AppConfig.class);

        GreetingService service = context.getBean(GreetingService.class);
        System.out.println(service.greet());

        context.close();
    }
}


Output:

Hello, Spring Bean!

🔹 Summary

A Spring Bean is any Java object managed by Spring.

Beans are declared in XML, with annotations, or Java configuration.

Scopes define how beans are created and shared.

Dependency Injection removes tight coupling.

Beans follow a lifecycle (creation → initialization → destruction).