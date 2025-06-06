# JAVA – Platform Independent Language

## Purpose of Programming Languages

The main purpose of any programming language is to **solve problems**.

---

## Why Java?

Compared to C and C++, **Java offers more features**, including:

- Object-Oriented Programming (OOPs) concepts
- Built-in **garbage collection**
- No pointers (safer memory handling)

C and C++ have their own pros and cons:
- Some areas where **Java is stronger**
- Other areas where **C/C++ are preferred**

For example:
- **C** doesn't support OOP concepts.

---

## What Problem is Java Solving?

C and C++ are powerful, but have **platform dependency issues**.

Java was designed to **overcome platform dependency** with features like:

- **JVM (Java Virtual Machine)**
- **Bytecode**
- **Platform independence**

> **Write Once, Run Anywhere**

---

## Platform = Operating System + Processor

---

## Bytecode in Java

- **Bytecode** is the intermediate code generated after compiling Java source code.
- It is the **primary output** of the Java compiler.
- Bytecode is **platform-independent**, allowing Java to run across various systems.

---

## Java Toolkits 

### JDK – Java Development Kit (Developer side)
- A full software development kit to **write, compile, and run** Java programs.

### JRE – Java Runtime Environment (Client side)
- Only used for **running** Java programs.
- Cannot compile programs using just JRE.

---

## Commands

```bash
# Compile Java program
javac filename.java

# Run Java program
java filename
javac – Java compiler → generates platform-independent bytecode

java – Java interpreter (JVM) → runs bytecode → platform-independent

Why PATH Environment Setup is Required?
Without it, the Command Prompt (cmd) won't find the javac or java commands unless you navigate to their directories manually.

Libraries in Java
A library is a set of files designed to perform specific tasks.

