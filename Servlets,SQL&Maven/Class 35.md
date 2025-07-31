# Class 35: (30/07/2025)

## Maven: SQL Connector Handling

- No need to manually install SQL connectors anymore.
- Instead, declare dependencies directly in `pom.xml`.

### Every JAR File Has 3 Coordinates:

1. **GroupId**
2. **ArtifactId**
3. **Version**
4. (Optional) Packages

> These must be specified in the `<dependencies>` section of `pom.xml`.

---

## Commands

```bash
mvn test    # Executes test cases
mvn install # Installs the package into local Maven repository
mvn jetty:run # Runs Jetty server
```

---

## BlackDuckScan

- A tool to **check security vulnerabilities** (glitches/loopholes).
- Helps catch issues like `StackOverflowError`.

### StackOverflowError:
- Occurs when recursive method calls **overflow the stack memory**.
- This halts the application.

---

## Dependencies in Maven

### Transitive Dependencies:

- A and B are direct dependencies.
- If A depends on C, then **C is a transitive dependency** for the project.

### Dependency Mediation:

- Maven selects the version of a dependency based on:
  - **Nearest Definition**
  - **First Declaration** in the POM hierarchy

---

## Maven Scopes:

- **compile** – available in all classpaths
- **test** – available only during testing
- **provided** – provided by the runtime environment (e.g., servlet container)
- **runtime** – available only during runtime

---

## Maven Repository Flow

```
Maven Central <--> Company Maven Repo <--> Local Developer Repo
```

---

## Parent and Child Modules in Maven

1. Set packaging type to `pom` in the **parent POM**.
2. Generate module:

```bash
mvn archetype:generate
# groupId: com.tekgrads
# artifactId: Child-1
```

---

## Spring Framework Overview

- Spring **helps with database connections, transaction management, and closing DB connections**.

### Spring Modules:

- **Spring Core** – Handles object creation (Inversion of Control)
- **Spring JDBC** – Helps connect to databases
- **Spring MVC** – Helps design and manage servlets

> **ACID** (for databases) and **SOLID** (for design principles) are crucial to understand when working with Spring.

---
