# Programming Languages Overview

- The main agenda of these programming languages is to get the user's tasks completed by interacting with the processor.
- Each of these programming languages has different features.
- Based on market trends, new programming languages are emerging with added features.
- Each programming language has its pros and cons.

## C vs C++

- The C language does not support the OOPs concept and does not have classes or objects, whereas C++ supports OOPs.
- In C, the source code is converted into machine-understandable code by the compiler.
- In both C and C++, when compiling a `.c` or `.cpp` file, an `.obj` file is generated.
- Commands differ for each operating system. To run a program, the source code must be passed again and recompiled to regenerate the `.obj` file.

## Platform Definition

- A platform is a combination of an operating system and a processor.

## Java

- Java solves the issue of "compile once, run anywhere" using an intermediate bytecode.
- The source code is compiled into bytecode, which can be run on any platform using the Java Virtual Machine (JVM).
- Java is platform-independent because of its bytecode. The Java compiler is machine-independent.

### Bytecode

- Java source file (`A.java`) is compiled using `javac A.java` to generate a bytecode file `A.class`.
- `A.class` contains bytecode, which is executed by the JVM to produce machine-understandable code.

### Java Software Components

1. **JDK (Java Development Kit)**
   - Tools for developing and running programs.
   - Combination of JRE + JVM.

2. **JRE (Java Runtime Environment)**
   - Used on the client side to run Java applications.

### Java Installation

- The latest version of Java is JDK 24 (x64 Installer).
- Check if Java is installed using:

  ```sh
  java -version
