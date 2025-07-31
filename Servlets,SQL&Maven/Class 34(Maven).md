# Class 34: (Maven) – 27/07/2025

## MAVEN

- Maven is **not just a build tool**
- It is a **project management tool**
- Maven helps **automate and manage the entire project lifecycle**, replacing manual steps

### What does Maven help with?

- Source code management  
- Test code management  
- Project structure  
- Library/Dependency management  
- Configuration handling  
- Open-source standardization  
- Apache project integration  
- Task runner (build, test, run)
- Reporting and documentation

### Key Features

- Provides **standard project structure**
- Manages project contents and dependencies
- Offers **configurable Project Object Model (POM)**
- Supports **Maven tasks** like goals and targets

---

## IDE
- IDEs (Integrated Development Environments) are **feature-rich editors** that support project execution, build, testing, and debugging.

---

## Archetypes

- Archetypes are **template-based project structures**
- Each project type has a corresponding archetype available at:  
  `https://repo1.maven.apache.org/`

**Definition**:  
> Archetypes are predefined project templates or structures.

### Command Example

```bash
C:\...path...\> mvn archetype:generate
```

- **Artifact ID**: The name of the project

---

## Compiler Phase

- Converts `.java` files → `.class` files
- Runs test cases
- Prepares `.jar` file

---

## Maven Build Lifecycle

1. **validate** – Validate the project is correct and all info is available  
2. **compile** – Compile the source code  
3. **test** – Run tests using a suitable testing framework  
4. **package** – Package the compiled code into a JAR/WAR  
5. **verify** – Run any checks to verify the package is valid  
6. **install** – Install the package into the local repository  
7. **deploy** – Deploy the final package to a remote repository

---

## Example Commands

```bash
cd firstmavenproject
mvn compile
mvn package
```

---
