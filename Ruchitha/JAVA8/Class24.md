
# JAVA 8

Java 8 introduced significant improvements to the language and libraries, bringing in a more functional programming style.

---

## Types of Programming Languages

- Procedural Programming Language  
- Object Oriented Programming Language  
- Scripting Language

---

## Java 8 Core Features

- Lambda Expressions  
- Functional Interfaces  
- Default Methods  
- Predicates  
- Functions  
- Double Colon Operator (`::`)  
- Stream API  
- Date and Time API

---

## Lambda Expression

- First introduced in **LISP**
- Enables **functional programming** in Java
- **Anonymous functions** or **closures**
- No name, return type, or access modifiers

### Examples:

**Example 1:**

```java
public void m1() {
    System.out.println("hello");
}

// Lambda equivalent:
() -> System.out.println("hello");
```

**Example 2:**

```java
public void add(int a, int b){
    System.out.println(a + b);
}

// Lambda equivalent:
(int a, int b) -> System.out.println(a + b);

// Type inference:
(a, b) -> System.out.println(a + b);
```

**Example 3:**

```java
public String str(String str){
    return str;
}

// Lambda equivalent:
(str) -> str;
```

---

### Key Points

- Zero or more parameters possible  
- Types can be omitted if compiler infers them  
- Use `()` if no parameters  
- Use `{}` if body has multiple statements  
- Functional interfaces are required to call lambda expressions

---

### Advantages

- Less code, better readability  
- Solves anonymous inner class complexity  
- Can pass lambda as method argument  
- Can be used in place of objects

---

## Functional Interface

An interface with only **one abstract method** is a functional interface.

### Examples:

- `Runnable` → `run()`  
- `Comparable` → `compareTo()`  
- `ActionListener` → `actionPerformed()`  
- `Callable` → `call()`

### Additional Notes:

- Can contain **default** and **static** methods
- Annotated with `@FunctionalInterface` (optional but recommended)

### Example:

```java
@FunctionalInterface
interface Interf {
    void m1();
}
```

---

### Invalid Functional Interface Example:

```java
@FunctionalInterface
interface Interf {
    void m1();
    void m2(); // Compilation error!
}
```

---

### Inheritance in Functional Interface:

```java
@FunctionalInterface
interface A {
    void methodOne();
}

@FunctionalInterface
interface B extends A {
    // OK if no new abstract methods
}
```

---

### Anonymous Inner Class vs Lambda Expression

#### Anonymous Inner Class Example:

```java
interface Interf {
    void m1();
}

class InterfImp1 implements Interf {
    public void m1() {
        System.out.println("Inside m1 of InterfImp1");
    }
}

public class Example1 {
    public static void main(String[] args) {
        Interf i = new InterfImp1();
        i.m1();
    }
}
```

**Output:**
```
Inside m1 of InterfImp1
```

---

### Lambda Expression Example:

```java
interface Interf3 {
    void m1();
}

public class Example3 {
    public static void main(String[] args) {
        Interf3 i = () -> System.out.println("in lambda expression m1 method");
        i.m1();
    }
}
```

**Output:**
```
in lambda expression m1 method
```

---

## Important Notes

- **Anonymous inner class** ≠ **Lambda Expression**
- Anonymous inner class:
  - Can implement multiple methods
  - Can have instance variables
  - `this` refers to the inner class object
- Lambda expression:
  - Must implement only one abstract method
  - Cannot have instance variables
  - `this` refers to the **enclosing class**

---
