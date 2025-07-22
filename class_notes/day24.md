 📘 Java 8, Types of Programming Languages, Lambda Expressions & Functional Interfaces

---

## ☕ Java 8 Overview

Java 8 is a major release that introduced several powerful features to simplify coding and improve performance.

### 🚀 Key Features:
- Lambda Expressions
- Functional Interfaces
- Stream API
- Default & Static methods in interfaces
- Optional class
- New Date and Time API (`java.time`)

---

## 🧾 Types of Programming Languages

### 1. **Procedural Programming**
- Based on procedures or routines.
- Focuses on "how" a task is performed.
- Example: C, Pascal

### 2. **Object-Oriented Programming (OOP)**
- Based on objects and classes.
- Focuses on "what" to perform using objects.
- Example: Java, C++, Python

### 3. **Functional Programming**
- Based on mathematical functions.
- Avoids shared state and mutable data.
- Example: Haskell, Scala, JavaScript (with ES6+), Java 8+

### 4. **Logical Programming**
- Based on formal logic.
- Uses facts and rules to derive conclusions.
- Example: Prolog

---

## 🔻 Lambda Expressions (Java 8)

Lambda expression is a **short block of code** that takes in parameters and returns a value. It's used to **implement functional interfaces** in a cleaner and more concise way.

### 🔧 Syntax:
```java
(parameters) -> expression
🧪 Example:
java
Copy
Edit
interface Greeting {
    void sayHello();
}

public class LambdaExample {
    public static void main(String[] args) {
        Greeting g = () -> System.out.println("Hello, Lambda!");
        g.sayHello();
    }
}
✅ Benefits:
Less code.

More readable.

Enables functional-style programming.

🧩 Functional Interfaces
A functional interface is an interface with only one abstract method. It can have default and static methods too.

📘 Examples in Java:
Runnable

Callable

Comparator

Function, Consumer, Predicate (from java.util.function package)

🧪 Example:
java
Copy
Edit
@FunctionalInterface
interface Calculator {
    int add(int a, int b);
}

public class Main {
    public static void main(String[] args) {
        Calculator calc = (a, b) -> a + b;
        System.out.println(calc.add(10, 20));  // Output: 30
    }
}
✅ @FunctionalInterface Annotation:
Optional, but helps the compiler ensure the interface meets the functional interface requirements.

