# 📦 What is Maven

**Maven** is an open-source build automation and project management tool supported by Apache, primarily used for Java projects.

Maven helps with:

* Source code and test code management
* Project structure
* Dependency management
* Configuration
* Task running (build, test, run)
* Reporting

## 🗂️ POM (Project Object Model)

Maven uses an XML file called `pom.xml` to define:

1. **Project structure** (default folder setup)
2. **Dependencies** (external libraries or JARs)
3. **Plugins** (project-specific configurations)
4. **Goals/tasks** (e.g., compile, test, package, install)

## ❓ Why Use Maven?

Before Maven, developers had to:

* Manually download JAR files
* Track versions and dependencies
* Write complex build scripts
* Handle project structure manually

This caused:

* Confusion
* Errors
* Wasted time
* Inconsistent builds

With Maven, you just add this to `pom.xml`:

```xml
<dependency>
  <groupId>junit</groupId>
  <artifactId>junit</artifactId>
  <version>4.13.2</version>
  <scope>test</scope>
</dependency>
```

## ⬇️ Downloading and Installing Maven

1. Download from: [Maven Downloads](https://maven.apache.org/download.cgi)
2. Extract the ZIP file
3. Add the `bin` path to **Environment Variables > Path**

### Check Installation

Open Command Prompt:

```sh
mvn
mvn -version
```

## 🧱 Creating a Maven Project

```sh
mvn archetype:generate
```

Follow the prompts:

* **groupId**: com.tekgrads
* **artifactId**: firstMavenProject
* **version**: (press Enter for default)

## 🧩 Maven Archetype

A **Maven Archetype** is a project template with predefined structure and files.

Benefits:

* Saves time
* Avoids manual folder creation
* Ensures standard Maven structure

## 🆔 groupId, artifactId, version

* `groupId`: Company/organization name (e.g., `com.tekgrads`)
* `artifactId`: Project/module name (e.g., `my-app`)
* `version`: Project version (e.g., `1.0.0`)

### Versioning:

* `1.0.0` = major.minor.bugfix
* `2.0.0` = major update
* `1.1.0` = minor changes
* `1.0.1` = bug fix

### Unique ID Example:

```xml
<groupId>com.tekgrads</groupId>
<artifactId>my-app</artifactId>
<version>1.0.0</version>
```

## ✅ Advantages of Maven

| Advantage                       | Description                                                    |
| ------------------------------- | -------------------------------------------------------------- |
| **Dependency Management**       | Automatically downloads external libraries (JARs)              |
| **Standardization**             | Promotes consistent project structure and build lifecycle      |
| **Easy Project Setup**          | Uses archetypes to generate starter projects                   |
| **Build Automation**            | Automates compile, test, package, deploy using simple commands |
| **Central Repository**          | Integrates with Maven Central                                  |
| **Integration Support**         | Works with Jenkins, Eclipse, IntelliJ, Spring Boot             |
| **Extensibility**               | Extendable via plugins for analysis, Docker, reporting, etc.   |
| **Easy to Use and Share**       | One `pom.xml` can be shared across teams                       |
| **Version Control**             | Manages dependency versions and conflicts                      |
| **Documentation and Reporting** | Generates reports and project documentation                    |

## 🛠️ Common Maven Commands

```sh
mvn clean       : Deletes 'target' directory
mvn compile     : Compiles source code
mvn test        : Runs unit tests
mvn package     : Creates .jar or .war file
mvn install     : Installs to local Maven repository (~/.m2)
mvn deploy      : Deploys to remote repository
```

## 📦 Dependencies

A dependency is an external library your project needs to compile or run.
Maven downloads them automatically.

### Syntax:

```xml
<dependencies>
  <dependency>
    <groupId>group-id</groupId>
    <artifactId>artifact-id</artifactId>
    <version>version</version>
    <scope>scope</scope> <!-- Optional -->
  </dependency>
</dependencies>
```

### Example:

```xml
<dependencyManagement>
  <dependencies>
    <dependency>
      <groupId>org.junit</groupId>
      <artifactId>junit-bom</artifactId>
      <version>5.11.0</version>
      <type>pom</type>
      <scope>import</scope>
    </dependency>
  </dependencies>
</dependencyManagement>
```

## 🔌 Plugins

Plugins automate tasks like compiling, packaging, and testing.

### Syntax:

```xml
<build>
  <plugins>
    <plugin>
      <groupId>group-id</groupId>
      <artifactId>artifact-id</artifactId>
      <version>version</version>
      <configuration>
        <!-- plugin config -->
      </configuration>
    </plugin>
  </plugins>
</build>
```

### Example:

```xml
<build>
  <pluginManagement>
    <plugins>
      <plugin>
        <artifactId>maven-compiler-plugin</artifactId>
        <version>3.13.0</version>
      </plugin>
      <plugin>
        <artifactId>maven-surefire-plugin</artifactId>
        <version>3.3.0</version>
      </plugin>
    </plugins>
  </pluginManagement>
</build>
```

## 🔁 Maven Life Cycle

| Phase    | Description                         |
| -------- | ----------------------------------- |
| validate | Check project is correct            |
| compile  | Compile source code                 |
| test     | Run unit tests                      |
| package  | Package code into .jar/.war         |
| verify   | Run integration tests               |
| install  | Install .jar to local repo (\~/.m2) |
| deploy   | Deploy to remote repository         |

### Example:

#### 🧪 Maven Lifecycle Commands in CMD

```sh
1. mvn compile
```

* Generates files in `target` folder
* Includes `src`, `test` folders

```sh
2. mvn package
```

* Generates JAR files

```sh
3. mvn test
```

* Runs all test cases

```sh
4. mvn clean
```

* Deletes files in `target` folder

```sh
4. mvn install
```

* Install .jar to local repo

```sh
5. mvn depoly
```

* Deploy to remote repository 

```sh
6. mvn site
```

* it will gives reports




If we run `mvn package`, it will connect to the central Maven repository and download required files into the `.m2` folder.

---

# 📦 Maven Coordinates

Each JAR file is uniquely identified by:

* **groupId**
* **artifactId**
* **version**

```xml
<groupId>com.tekgrads</groupId>
<artifactId>my-app</artifactId>
<version>1.0.0</version>
```

---

# 🔍 Finding JAR Files

Go to:
[mvnrepository.com](https://mvnrepository.com/artifact/org.apache.commons/commons-lang3)

Pick a version → Copy the dependency snippet → Paste it into your `pom.xml` inside `<dependencies>`.

---

# 🛡️ Black Duck Scan

Black Duck is a security tool used to detect vulnerabilities in open-source libraries.

### It helps:

1. Detect bugs or risks in 3rd-party libraries
2. Ensure your code is safe and legal to use

### Vulnerabilities

Security loopholes. The "Vulnerabilities" section on Maven Repository links shows known issues in that library.

---

# 📚 Maven Dependencies

## 1. Declarative Dependency

Defined in `pom.xml`, Maven auto-manages download and usage.

## 2. Transitive Dependency

Library B is included because Library A (which you added) depends on it.

**Example:**

* You add Library A
* A depends on Library B
* Maven includes B automatically (transitive)

## 3. Nearest Dependency

If multiple versions of the same library exist, Maven uses the one closest to your project.

**Example:**

```xml
<dependency> <!-- B:2.0 directly -->
<groupId>org.example</groupId>
<artifactId>lib-B</artifactId>
<version>2.0</version>
</dependency>
```

Overrides transitive `B:1.0` from other dependencies.

## 4. First Declaration

If same-level conflicts occur, Maven picks the one that appears **first** in the `pom.xml`.

---

# 📏 Dependency Scope

Scope defines when and how a dependency is used.

### 1. Runtime Scope

Used at runtime, not compile time.
Used for: JDBC drivers(mysql connector), logging frameworks

```xml
<dependency>
  <groupId>mysql</groupId>
  <artifactId>mysql-connector-java</artifactId>
  <version>8.0.33</version>
  <scope>runtime</scope>
</dependency>
```

### 2. Provided Scope

Available at compile time, but not included in final JAR.
Used for: Servlet APIs, server libraries

```xml
<dependency>
  <groupId>javax.servlet</groupId>
  <artifactId>javax.servlet-api</artifactId>
  <version>4.0.1</version>
  <scope>provided</scope>
</dependency>
```

### 3. Compile Scope (Default)

Used during compile, runtime, and test.

```xml
<dependency>
  <groupId>org.apache.commons</groupId>
  <artifactId>commons-lang3</artifactId>
  <version>3.12.0</version>
</dependency>
```

### 4. Test Scope

Used only during testing phase (JUnit, Mockito, etc.)

```xml
<dependency>
  <groupId>junit</groupId>
  <artifactId>junit</artifactId>
  <version>4.13.2</version>
  <scope>test</scope>
</dependency>
```

---

# ⚙️ Maven Properties

You can define reusable values using `<properties>` in `pom.xml`:

```xml
<project>
  <properties>
    <java.version>17</java.version>
    <apache.version>3.1.0</apache.version>
  </properties>

  <dependencies>
    <dependency>
      <groupId>org.springframework.boot</groupId>
      <artifactId>spring-boot-starter</artifactId>
      <version>${apache.version}</version>
    </dependency>
  </dependencies>
</project>
```

Benefits:

* Easy version management
* Change once, update everywhere

---

## 👪 Maven Parent and Child Modules

### 1. Parent Module

A **Parent Module** in Maven is a project that manages shared configuration (like dependencies, plugin versions, properties) for one or more child modules.

- Contains a `pom.xml` with `<packaging>pom</packaging>`
- Usually doesn't have source code
- May include `<modules>` block to list child projects

## 2. Child Module

A **Child Module** is a Maven project that inherits settings from its parent module.

- Has its own `pom.xml`
- Includes a `<parent>` tag to reference the parent
- Can override or add to the parent’s configuration

## ▶️ Creating Modules in CMD

```bash
mvn archetype:generate
# select default values
# groupId: com.tekgrads
# artifactId: child-1
```

Repeat with artifactId as `child-2`.

Now you have 3 `pom.xml` files:
- Parent (with all configuration)
- Child-1 (minimal config)
- Child-2 (minimal config)

## 🧾 Example `pom.xml` Files

### Parent `pom.xml`

```xml
<project xmlns="http://maven.apache.org/POM/4.0.0"
         xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
         xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 http://maven.apache.org/xsd/maven-4.0.0.xsd">
  <modelVersion>4.0.0</modelVersion>
  <groupId>com.tekgrads</groupId>
  <artifactId>SecondMavenProject</artifactId>
  <version>1.0-SNAPSHOT</version>
  <packaging>pom</packaging>
  <name>SecondMavenProject</name>
  <url>http://www.example.com</url>

  <properties>
    <project.build.sourceEncoding>UTF-8</project.build.sourceEncoding>
    <maven.compiler.release>17</maven.compiler.release>
  </properties>

  <dependencyManagement>
    <dependencies>
      <dependency>
        <groupId>org.junit</groupId>
        <artifactId>junit-bom</artifactId>
        <version>5.11.0</version>
        <type>pom</type>
        <scope>import</scope>
      </dependency>
    </dependencies>
  </dependencyManagement>

  <dependencies>
    <dependency>
      <groupId>org.junit.jupiter</groupId>
      <artifactId>junit-jupiter-api</artifactId>
      <scope>test</scope>
    </dependency>
    <dependency>
      <groupId>org.junit.jupiter</groupId>
      <artifactId>junit-jupiter-params</artifactId>
      <scope>test</scope>
    </dependency>
  </dependencies>

  <build>
    <pluginManagement>
      <plugins>
        <plugin>
          <artifactId>maven-clean-plugin</artifactId>
          <version>3.4.0</version>
        </plugin>
        <plugin>
          <artifactId>maven-resources-plugin</artifactId>
          <version>3.3.1</version>
        </plugin>
        <plugin>
          <artifactId>maven-compiler-plugin</artifactId>
          <version>3.13.0</version>
        </plugin>
        <plugin>
          <artifactId>maven-surefire-plugin</artifactId>
          <version>3.3.0</version>
        </plugin>
        <plugin>
          <artifactId>maven-jar-plugin</artifactId>
          <version>3.4.2</version>
        </plugin>
        <plugin>
          <artifactId>maven-install-plugin</artifactId>
          <version>3.1.2</version>
        </plugin>
        <plugin>
          <artifactId>maven-deploy-plugin</artifactId>
          <version>3.1.2</version>
        </plugin>
        <plugin>
          <artifactId>maven-site-plugin</artifactId>
          <version>3.12.1</version>
        </plugin>
        <plugin>
          <artifactId>maven-project-info-reports-plugin</artifactId>
          <version>3.6.1</version>
        </plugin>
      </plugins>
    </pluginManagement>
  </build>

  <modules>
    <module>child-2</module>
    <module>child-1</module>
  </modules>
</project>
```

### Child-1 `pom.xml`

```xml
<project xmlns="http://maven.apache.org/POM/4.0.0"
         xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
         xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 http://maven.apache.org/xsd/maven-4.0.0.xsd">
  <modelVersion>4.0.0</modelVersion>
  <parent>
    <groupId>com.tekgrads</groupId>
    <artifactId>SecondMavenProject</artifactId>
    <version>1.0-SNAPSHOT</version>
  </parent>
  <groupId>com.tekgrads</groupId>
  <artifactId>child-1</artifactId>
  <version>1.0-SNAPSHOT</version>
  <name>child-1</name>
</project>
```

### Child-2 `pom.xml`

```xml
<project xmlns="http://maven.apache.org/POM/4.0.0"
         xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
         xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 http://maven.apache.org/xsd/maven-4.0.0.xsd">
  <modelVersion>4.0.0</modelVersion>
  <parent>
    <groupId>com.tekgrads</groupId>
    <artifactId>SecondMavenProject</artifactId>
    <version>1.0-SNAPSHOT</version>
  </parent>
  <groupId>com.tekgrads</groupId>
  <artifactId>child-2</artifactId>
  <version>1.0-SNAPSHOT</version>
  <name>child-2</name>
</project>
```

## 🖥️ CMD Commands

```sh
mvn install
# builds all modules and generates individual JARs under target/

mvn site
## generates project reports into target/site/
```

All files will also appear in the local `.m2` Maven repository.
