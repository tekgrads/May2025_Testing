# Evolution of Java Web Development

Java has been one of the most widely used programming languages for building web applications. Over the years, the ecosystem of Java web development has evolved significantly.  
Below is a **detailed timeline with examples**.

---

## 1. Early Days (Servlets — late 1990s)

- **Servlets** were the first way to build dynamic web applications in Java.  
- They extended `HttpServlet` and handled HTTP requests and responses.

### Example: Simple Servlet

```java
import java.io.*;
import jakarta.servlet.*;
import jakarta.servlet.http.*;

public class HelloServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) 
        throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        out.println("<h1>Hello from Servlet!</h1>");
    }
}
```

**Drawbacks:** Too much boilerplate, HTML inside Java code, not developer-friendly.

---

## 2. JSP (JavaServer Pages — early 2000s)

- Introduced to simplify Servlets.  
- Allowed embedding Java code directly into HTML using special tags.

### Example: Simple JSP

```jsp
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head><title>Hello JSP</title></head>
<body>
   <h1>Hello, <%= request.getParameter("name") %>!</h1>
</body>
</html>
```

**Drawbacks:** Mixing Java logic with HTML → hard to maintain large projects.

---

## 3. Struts Framework (2000s)

- Apache Struts introduced MVC (Model-View-Controller) architecture.  
- Encouraged separation of concerns: Model (business), View (JSP), Controller (Servlet).  

### Example: Struts Action Class

```java
import org.apache.struts.action.*;

public class HelloAction extends Action {
    public ActionForward execute(ActionMapping mapping, ActionForm form,
                                 HttpServletRequest request, HttpServletResponse response)
                                 throws Exception {
        request.setAttribute("message", "Hello from Struts!");
        return mapping.findForward("success");
    }
}
```

---

## 4. JSF (JavaServer Faces — mid 2000s)

- Standard Java EE web framework.  
- Component-based (UI widgets like buttons, forms).  
- Integrated with tools like NetBeans.  

### Example: JSF Page

```xhtml
<html xmlns:h="http://xmlns.jcp.org/jsf/html">
<h:body>
    <h:form>
        <h:outputText value="Enter your name:" />
        <h:inputText value="#{userBean.name}" />
        <h:commandButton value="Submit" action="#{userBean.sayHello}" />
    </h:form>
</h:body>
</html>
```

---

## 5. Spring MVC (2003 onwards)

- Part of the **Spring Framework**.  
- Provided a flexible and lightweight MVC pattern.  
- Used Controllers, Services, DAOs with Dependency Injection.

### Example: Spring MVC Controller

```java
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HelloController {
    @GetMapping("/hello")
    public String sayHello(Model model) {
        model.addAttribute("message", "Hello from Spring MVC!");
        return "hello"; // refers to hello.jsp or hello.html
    }
}
```

---

## 6. Hibernate & JPA (2000s onwards)

- Replaced JDBC boilerplate code with **ORM (Object-Relational Mapping)**.  
- Hibernate became the de-facto ORM framework.  
- Later standardized as **JPA (Java Persistence API)**.

### Example: JPA Entity

```java
import jakarta.persistence.*;

@Entity
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private double price;
}
```

---

## 7. Spring Boot (2014 onwards)

- Revolutionized Java web development.  
- Convention-over-configuration, embedded servers (Tomcat/Jetty).  
- Very easy to create REST APIs and microservices.

### Example: REST Controller

```java
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class HelloRestController {
    @GetMapping("/hello")
    public String hello() {
        return "Hello from Spring Boot!";
    }
}
```

Run with:
```bash
mvn spring-boot:run
```

---

## 8. Microservices & Cloud Era (2016 onwards)

- Java applications moved towards **microservices** using **Spring Boot + Spring Cloud**.  
- Features: Service discovery (Eureka), Config Server, API Gateway, Distributed Tracing.  
- Deployments on Kubernetes and Docker.

---

## 9. Modern Java Web Development (2020s)

- Java is widely used with **Spring Boot, Quarkus, Micronaut**.  
- REST APIs + GraphQL for modern applications.  
- Reactive programming using **Spring WebFlux**.  
- Integration with **Angular, React, Vue** for frontend.

### Example: Reactive REST API (Spring WebFlux)

```java
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;

@RestController
@RequestMapping("/products")
public class ProductController {
    @GetMapping
    public Flux<String> getProducts() {
        return Flux.just("Laptop", "Phone", "Tablet");
    }
}
```

---

# 🔑 Summary of Java Web Evolution

| Era                | Technology         | Key Features |
|--------------------|-------------------|--------------|
| 1990s              | Servlets          | Basic request/response handling |
| Early 2000s        | JSP               | Java in HTML |
| 2000s              | Struts            | MVC pattern |
| Mid 2000s          | JSF               | Component-based |
| 2003 onwards       | Spring MVC        | Flexible MVC, DI |
| 2000s onwards      | Hibernate / JPA   | ORM framework |
| 2014 onwards       | Spring Boot       | REST, Microservices |
| 2016 onwards       | Spring Cloud      | Cloud-native microservices |
| 2020s              | WebFlux, Quarkus  | Reactive, Cloud-ready |

---

✨ Java web development has evolved from **simple servlets** to **cloud-native microservices** with frameworks like **Spring Boot, Spring Cloud, and WebFlux**.
