Apache Maven Project Guide
🔹 What is Maven?

Apache Maven is a build automation and project management tool mainly used for Java projects. It simplifies:

Dependency management

Project build lifecycle

Documentation & reporting

Consistent project structure

It uses a file called pom.xml (Project Object Model) to configure the project.

🔹 Maven Project Structure

A typical Maven project follows this structure:

my-app
│── pom.xml
└── src
    ├── main
    │   ├── java
    │   │   └── com/example/App.java
    │   └── resources
    └── test
        └── java
            └── com/example/AppTest.java


src/main/java → Application source code

src/test/java → Unit test source code

src/main/resources → Configuration files (like application.properties)

pom.xml → Core configuration file (dependencies, plugins, etc.)

🔹 Example pom.xml

Here’s a basic example:

<project xmlns="http://maven.apache.org/POM/4.0.0"
         xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
         xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 
                             http://maven.apache.org/xsd/maven-4.0.0.xsd">
    <modelVersion>4.0.0</modelVersion>

    <groupId>com.example</groupId>
    <artifactId>my-app</artifactId>
    <version>1.0-SNAPSHOT</version>
    <packaging>jar</packaging>

    <dependencies>
        <!-- Example: JUnit for testing -->
        <dependency>
            <groupId>junit</groupId>
            <artifactId>junit</artifactId>
            <version>4.13.2</version>
            <scope>test</scope>
        </dependency>
    </dependencies>
</project>

🔹 Steps to Download & Install Maven
1. Install Java

Maven requires Java.

Install JDK (preferably version 11 or later).

Verify installation:

java -version

2. Download Maven

Go to Apache Maven Download Page.

Download the binary zip archive (e.g., apache-maven-3.x.x-bin.zip).

3. Extract Maven

Extract the archive to a directory, e.g.:

C:\Program Files\Apache\Maven


or on Linux:

/opt/maven

4. Set Environment Variables

Windows

Add M2_HOME = path to Maven folder

Add MAVEN_HOME = path to Maven folder

Add %M2_HOME%\bin to PATH

Linux/Mac (add to ~/.bashrc or ~/.zshrc):

export M2_HOME=/opt/maven
export PATH=$M2_HOME/bin:$PATH

5. Verify Installation

Run:

mvn -version


Expected output:

Apache Maven 3.x.x
Java version: 11.0.x

🔹 Creating a Maven Project

Run this command to generate a simple Maven project:

mvn archetype:generate -DgroupId=com.example \
                       -DartifactId=my-app \
                       -DarchetypeArtifactId=maven-archetype-quickstart \
                       -DinteractiveMode=false


This will create the folder structure automatically with a sample class and test.

🔹 Building the Project

Compile the code:

mvn compile


Run tests:

mvn test


Create a JAR:

mvn package


→ Output JAR will be in target/ folder.

Clean build (removes target directory):

mvn clean

🔹 Example

Let’s say you created my-app.

Main class: App.java

package com.example;

public class App {
    public static void main(String[] args) {
        System.out.println("Hello, Maven!");
    }
}


Run the project:

java -cp target/my-app-1.0-SNAPSHOT.jar com.example.App


Output:

Hello, Maven!