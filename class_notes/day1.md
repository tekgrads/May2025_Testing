# Programming

Programming is a set of instructions used to perform a specific task.  
There are many programming languages such as **C**, **Java**, **Python**, etc.

---

# Operating System

An **Operating System (OS)** is software that acts as an interface between the user and the computer system.  
**Examples:** Windows, Unix, etc.

---

# Platform

A **Platform** can be defined as the combination of an operating system and a microprocessor.

---

## Java and Platform Independence

Java is a **platform-independent** programming language because it uses an intermediate file called **Bytecode**.

- In Java, the source code is saved in a file with the extension `.java`.
- The Java compiler converts this source code into a `.class` file (Bytecode).
- This **Bytecode** can be executed on any platform using the **Java Virtual Machine (JVM)**.

Hence, Java follows the principle:  
**"Write Once, Run Anywhere" (WORA)**

---

## Java Compilation and Execution Commands

- **Compilation:** `javac Filename.java`  
- **Execution:** `java Filename`

---

## Java Installation

1. Install Java from the [Oracle official website](https://www.oracle.com/java/technologies/javase-downloads.html).
2. Open **Command Prompt**.
3. Type: `java -version`

   - If Java is installed, it will display the Java version.
   - If not, it will return: **'Java not found'**.

---

## Path Variable

The **Path Variable** is used to define the path of the Java source file.

- If the path is not set correctly, you'll get the error:  
  `"internal or external command not found"`

### Types of Path Variables:

1. **User Variables:**  
   - Created by users.  
   - Multiple user variables can exist.  
   - Defined within the source code.

2. **System Variables:**  
   - Defined within the system.  
   - Only one system variable exists.

---

## Java Components

### JDK (Java Development Kit)

- Contains development tools and JRE.
- Used for writing and compiling Java code.

### JRE (Java Runtime Environment)

- Used on the client-side.
- Responsible for executing the code.
- Contains the **JVM**.

### JVM (Java Virtual Machine)

- Executes Java bytecode.
- Provides platform independence by interpreting `.class` files. 
-Jvm is important .
