
# What is Maven

Maven is an open-source build automation and project management tool supported by Apache, primarily used for Java projects.

Maven helps with:

- Managing source and test code
- Organizing project structure
- Handling external libraries (dependencies)
- Simplifying builds and configuration
- Running tasks such as compile, test, and package
- Generating reports

## POM (Project Object Model)

Maven uses an XML file named `pom.xml` to define:

1. Project structure and configurations
2. Dependencies (external libraries)
3. Plugins (for builds, testing, packaging)
4. Goals/tasks (compile, test, package, etc.)

## Why Use Maven

Before Maven, developers had to manually manage dependencies and project builds. Maven simplifies this by automating:

- Dependency resolution
- Project builds
- Configuration and standardization

Example dependency in `pom.xml`:

```xml
<dependency>
  <groupId>junit</groupId>
  <artifactId>junit</artifactId>
  <version>4.13.2</version>
  <scope>test</scope>
</dependency>
```

## Installing Maven

1. Download from the Apache website
2. Extract the archive
3. Add the `bin` path to your system’s PATH environment variable

Verify installation:

```sh
mvn
mvn -version
```

## Creating a Maven Project

```sh
mvn archetype:generate
```

Specify the groupId, artifactId, and version when prompted.

## Maven Archetype

A Maven archetype is a template for a new project. It saves time by generating a project with standard structure and files.

## Maven Coordinates

Each project has a unique identifier:

- `groupId`: Organization or group name
- `artifactId`: Project or module name
- `version`: Version of the project

Example:

```xml
<groupId>com.example</groupId>
<artifactId>demo-app</artifactId>
<version>1.0.0</version>
```

## Maven Lifecycle and Commands

Maven has several lifecycle phases:

| Phase     | Description                       |
|----------|-----------------------------------|
| validate | Validates the project structure    |
| compile  | Compiles source code               |
| test     | Runs unit tests                    |
| package  | Packages compiled code into JAR/WAR |
| install  | Installs package to local repo     |
| deploy   | Deploys to remote repository       |

Common commands:

```sh
mvn clean       # Removes target directory
mvn compile     # Compiles the code
mvn test        # Runs tests
mvn package     # Builds JAR/WAR
mvn install     # Installs to local Maven repository
mvn deploy      # Deploys to remote repository
```

## Dependency Management

Dependencies are defined in `pom.xml` and automatically downloaded by Maven.

### Syntax:

```xml
<dependency>
  <groupId>group-id</groupId>
  <artifactId>artifact-id</artifactId>
  <version>version</version>
</dependency>
```

### Scopes:

- **compile** (default): Needed at compile, test, and runtime
- **runtime**: Needed at runtime only
- **provided**: Provided by container or server (e.g. servlet API)
- **test**: Used only for testing

## Transitive Dependencies

Maven automatically includes dependencies of your dependencies.

## Plugins

Plugins help automate common tasks like compiling and testing.

Example configuration:

```xml
<build>
  <plugins>
    <plugin>
      <groupId>org.apache.maven.plugins</groupId>
      <artifactId>maven-compiler-plugin</artifactId>
      <version>3.8.1</version>
    </plugin>
  </plugins>
</build>
```

## Maven Properties

Define reusable values in `pom.xml`:

```xml
<properties>
  <java.version>17</java.version>
</properties>
```

Use it like:

```xml
<version>${java.version}</version>
```

## Parent and Child Projects

### Parent Project

- Shared configuration
- `<packaging>pom</packaging>`

### Child Project

- Inherits from parent
- Defined using `<parent>` tag

Parent example:

```xml
<modules>
  <module>child1</module>
  <module>child2</module>
</modules>
```

## Useful Tools

### Black Duck

Security tool for checking vulnerabilities in third-party libraries.

### mvnrepository.com

Website to search and copy Maven dependency snippets.

Use Maven to standardize builds, manage dependencies, and simplify Java project development.
