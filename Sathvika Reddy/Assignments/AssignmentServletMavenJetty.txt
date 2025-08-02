# Servlet Maven Jetty Assignment:

## Project Name

`Servlet_Maven_Assignment`

## Project Type

* Maven Web Application (`packaging: war`)
* Servlet-based
* Embedded Jetty Server

---

## 1. Directory Structure

```
Servlet_Maven_Assignment/
│
├── pom.xml
├── src/
│   └── main/
│       ├── java/
│       │   └── com/
│       │       └── tekgrads/
│       │           └── Servlet_Maven_Assignment/
│       │               └── HelloServlet.java
│       └── webapp/
│           └── WEB-INF/
│               └── web.xml
```

---

## 2. `HelloServlet.java`

File: `src/main/java/com/tekgrads/Servlet_Maven_Assignment/HelloServlet.java`

```java
package com.tekgrads.Servlet_Maven_Assignment;

import java.io.*;
import jakarta.servlet.*;
import jakarta.servlet.http.*;

public class HelloServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        out.println("<h2>Hello from Servlet running on Jetty!</h2>");
    }
}
```

---

## 3. `pom.xml`

File: `pom.xml`

```xml
<project xmlns="http://maven.apache.org/POM/4.0.0"
         xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
         xsi:schemaLocation="http://maven.apache.org/POM/4.0.0
         http://maven.apache.org/xsd/maven-4.0.0.xsd">
         
    <modelVersion>4.0.0</modelVersion>

    <groupId>com.tekgrads</groupId>
    <artifactId>Servlet_Maven_Assignment</artifactId>
    <version>0.0.1-SNAPSHOT</version>
    <packaging>war</packaging>

    <name>Servlet_Maven_Assignment</name>
    <url>http://maven.apache.org</url>

    <properties>
        <project.build.sourceEncoding>UTF-8</project.build.sourceEncoding>
        <maven.compiler.source>17</maven.compiler.source>
        <maven.compiler.target>17</maven.compiler.target>
    </properties>

    <dependencies>
        <dependency>
            <groupId>junit</groupId>
            <artifactId>junit</artifactId>
            <version>3.8.1</version>
            <scope>test</scope>
        </dependency>

        <dependency>
            <groupId>jakarta.servlet</groupId>
            <artifactId>jakarta.servlet-api</artifactId>
            <version>5.0.0</version>
            <scope>provided</scope>
        </dependency>
    </dependencies>

    <build>
        <plugins>
            <plugin>
                <groupId>org.eclipse.jetty</groupId>
                <artifactId>jetty-maven-plugin</artifactId>
                <version>11.0.11</version>
                <configuration>
                    <webApp>
                        <contextPath>/</contextPath>
                    </webApp>
                    <httpConnector>
                        <port>8080</port>
                    </httpConnector>
                </configuration>
            </plugin>
        </plugins>
    </build>
</project>
```

---

## 4. `web.xml`

File: `src/main/webapp/WEB-INF/web.xml`

```xml
<web-app xmlns="https://jakarta.ee/xml/ns/jakartaee"
         xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
         xsi:schemaLocation="https://jakarta.ee/xml/ns/jakartaee 
         https://jakarta.ee/xml/ns/jakartaee/web-app_5_0.xsd"
         version="5.0">

    <servlet>
        <servlet-name>HelloServlet</servlet-name>
        <servlet-class>com.tekgrads.Servlet_Maven_Assignment.HelloServlet</servlet-class>
    </servlet>

    <servlet-mapping>
        <servlet-name>HelloServlet</servlet-name>
        <url-pattern>/hello</url-pattern>
    </servlet-mapping>

</web-app>
```

---

## 5. How to Run

### Step 1: Open Eclipse

### Step 2: Right-click project → Run As → Maven Build...

* Enter goal:

  ```
  jetty:run
  ```

### Step 3: Open in browser

```
http://localhost:8080/hello
```

### Output

```
Hello from Servlet running on Jetty!
```

