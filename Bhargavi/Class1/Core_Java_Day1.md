Day-1  01-06-2025

#  Java Notes

##  Programming Languages Overview
- Programming languages help users interact with the processor to perform tasks.
- Every language has unique features, pros, and cons.
- New languages keep emerging based on market needs.

##  C vs C++
- **C**: No OOPs, no classes/objects.
- **C++**: Supports OOPs.
- Both generate `.obj` files during compilation.
- Commands and compiling steps vary by OS.

##  Platform
- A **Platform = Operating System + Processor**

##  Java Overview
- Java solves the "write once, run anywhere" problem using **bytecode** and **JVM**.
- Java code is compiled into bytecode by the **compiler** and executed by the **JVM**.
- Java is **platform-independent** at the source level.

##  Java Software Components
### 1. **JDK (Java Development Kit)**
- Used to develop and run Java programs.
- Contains **JRE + JVM**.

### 2. **JRE (Java Runtime Environment)**
- Used to **run Java applications**.
- Includes the **JVM**.

##  Java Installation
- **Latest version**: JDK 24 (x64 Installer)
- Check if installed:
  java -version
- Set environment path:
    This PC > Properties > Advanced system settings > Environment Variables > Path

##  Hello World Program in Java

class A {
    public static void main(String[] args) {
        System.out.println("Hello World");
    }
}

###  Steps:
1. Save the file as `A.java`  
2. Compile:
   javac A.java
3. Run:
   java A

##  Java Basics
- Java = **General-purpose**, **OOP-based**, **multi-paradigm** language.

##  Java Program Execution Flow
   Write code in `.java` (high-level language)
   **Compiler** converts it to `.class` (bytecode)
   **JVM (Interpreter)** executes bytecode as machine code