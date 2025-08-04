# 🚀 Jetty Servlet Project 

## 📦 Step 1: Generate Maven Project

```bash
mvn archetype:generate
```

Choose archetype number `2227`

## 🛠️ Step 2: Configure Maven Group and Package

```
groupId: com.tekgrads
artifactId: my-servlet-app
version: 1.0-SNAPSHOT (press Enter)
package: com.tekgrads (press Enter)
```

## 📁 Step 3: Create Folder Structure

```bash
mkdir -p src/main/java/com/tekgrads/servlet
mkdir -p src/main/webapp/WEB-INF
```

---

## 🧾 `pom.xml`

```xml
<project xmlns="http://maven.apache.org/POM/4.0.0"
         xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
         xsi:schemaLocation="http://maven.apache.org/POM/4.0.0
                             http://maven.apache.org/xsd/maven-4.0.0.xsd">

  <modelVersion>4.0.0</modelVersion>
  <groupId>com.tekgrads </groupId>
  <artifactId>my-servlet-app</artifactId>
  <version>1.0-SNAPSHOT</version>
  <packaging>war</packaging>

  <properties>
    <maven.compiler.source>11</maven.compiler.source>
    <maven.compiler.target>11</maven.compiler.target>
  </properties>

  <dependencies>
    <!-- Jakarta Servlet API -->
    <dependency>
      <groupId>jakarta.servlet</groupId>
      <artifactId>jakarta.servlet-api</artifactId>
      <version>6.0.0</version>
      <scope>provided</scope>
    </dependency>
  </dependencies>

  <build>
    <plugins>
      <!-- Jetty Plugin -->
      <plugin>
        <groupId>org.eclipse.jetty</groupId>
        <artifactId>jetty-maven-plugin</artifactId>
        <version>11.0.15</version>
        <configuration>
          <webApp>
            <contextPath>/</contextPath>
          </webApp>
        </configuration>
      </plugin>
    </plugins>
  </build>
</project>
```

---

## 🧑‍💻 `HelloServlet.java`

```java
package com.tekgrads.servlet;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import java.io.IOException;

public class HelloServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
        throws ServletException, IOException {
        resp.setContentType("text/html");
        resp.getWriter().write("<h1>this is a jetty project!</h1>");
    }
}
```

---

## 🧾 `web.xml`

```xml
<web-app xmlns="https://jakarta.ee/xml/ns/jakartaee"
         xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
         xsi:schemaLocation="https://jakarta.ee/xml/ns/jakartaee
                             https://jakarta.ee/xml/ns/jakartaee/web-app_6_0.xsd"
         version="6.0">

  <servlet>
    <servlet-name>HelloServlet</servlet-name>
    <servlet-class>com.tekgrads.servlet.HelloServlet</servlet-class>
  </servlet>

  <servlet-mapping>
    <servlet-name>HelloServlet</servlet-name>
    <url-pattern>/jetty</url-pattern>
  </servlet-mapping>
</web-app>
```

---

## 🧪 Run the Project

```bash
mvn clean compile
mvn jetty:run
```

Open your browser:

```
http://localhost:8080/jetty
```

You will see the output:

```
this is a jetty project!
```
