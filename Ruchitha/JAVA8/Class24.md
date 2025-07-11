
# Java 8 – Functional Programming Features

Java 8 introduced significant improvements to the language and libraries, bringing in a more functional programming style.

---

## 📌 Types of Programming Languages

- **Procedural Programming Language**
- **Object-Oriented Programming Language**
- **Scripting Language**

---

## 🔥 Java 8 Core Features

- Lambda Expressions
- Functional Interfaces
- Default Methods
- Predicates
- Functions
- Double Colon Operator (`::`)
- Stream API
- Date and Time API

---

## 🧠 Lambda Expressions

- Originated from **LISP** language.
- Enables **functional programming** in Java.
- It is an **anonymous function** (no name, return type, or access modifier).
- Also called **closures**.

### 📌 Syntax Examples

```java
// Traditional
public void m1() {
    System.out.println("hello");
}

// Lambda
() -> System.out.println("hello");

// Another example
public void add(int a, int b) {
    System.out.println(a + b);
}

// Lambda version
(int a, int b) -> System.out.println(a + b);

// Type inference
(a, b) -> System.out.println(a + b);

// Return type example
(str) -> str;
```

### ✅ Conclusion

- Lambda can have zero or more parameters.
- Data types can be omitted if inferred by compiler.
- Use `{}` if the body contains multiple statements.
- Lambda expressions require **Functional Interfaces**.

### ✅ Advantages

- Reduces code length → Improves readability.
- Simplifies anonymous inner classes.
- Can be passed as method arguments.
- Can be used in place of objects.

---

## 🧩 Functional Interface

A **Functional Interface** contains **only one abstract method** (also called a **Single Abstract Method / SAM**).

### Examples:

- `Runnable` → `run()`
- `Comparable` → `compareTo()`
- `ActionListener` → `actionPerformed()`
- `Callable` → `call()`

### 🔍 Features:

- Can include **default** and **static** methods.
- Marked with `@FunctionalInterface` annotation.
- Compilation error if:
  - More than one abstract method.
  - No abstract method at all.

### ✅ Examples:

```java
@FunctionalInterface
interface Interf {
    void m1();
}

// Valid inheritance
@FunctionalInterface
interface B extends Interf {
    void m1();
}

// Invalid – multiple abstract methods
@FunctionalInterface
interface Invalid {
    void m1();
    void m2();  // ❌ Compilation error
}
```

---

## ⚙️ Functional Interface with Lambda – Examples

### Example 1 – Regular Implementation

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
// Output: Inside m1 of InterfImp1
```

---

### Example 2 – Anonymous Inner Class

```java
interface Interf2 {
    void m1();
}

abstract class Test {
    public abstract void m1();
}

class Test2 {
    public void m1() {
        System.out.println("In Test2 m1");
    }
}

class TestImpl extends Test {
    public void m1() {
        System.out.println("In Concrete m1 method");
    }
}

public class Example2 {
    public static void main(String[] args) {
        Interf2 i = new Interf2() {
            public void m1() {
                System.out.println("Inside m1 of InterfImpl2");
            }
        };
        i.m1();

        Test t = new TestImpl();
        t.m1();

        Test t2 = new Test() {
            public void m1() {
                System.out.println("Another Impl of m1 in anonymous inner class");
            }
        };
        t2.m1();

        Test2 t3 = new Test2() {
            public void m1() {
                System.out.println("In Anonymous m1 method");
            }
        };
        t3.m1();
    }
}

// Output:
// Inside m1 of InterfImpl2
// In Concrete m1 method
// Another Impl of m1 in anonymous inner class
// In Anonymous m1 method
```

---

### Example 3 – Lambda Expression

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
// Output: in lambda expression m1 method
```

---

### Example 4 – `this` Reference in Lambda vs Anonymous Class

```java
interface Interf4 {
    void m1();
}

class Test3 {
    int x = 888;

    public void m2() {
        Interf4 i = new Interf4() {
            int x = 999;

            public void m1() {
                System.out.println(this.x);  // refers to anonymous class
            }
        };
        i.m1();
    }
}

class Test4 {
    int x = 888;

    public void m2() {
        int y = 20;

        Interf4 i2 = () -> {
            int x = 999;
            System.out.println(this.x);  // refers to outer class
            System.out.println(y);
        };
        i2.m1();
    }
}

public class Example4 {
    public static void main(String[] args) {
        new Test3().m2();
        new Test4().m2();
    }
}

// Output:
// 999
// 888
// 20
```

---

## ⚠️ Notes

- **Anonymous Inner Class**
  - Can extend concrete/abstract classes.
  - Can implement interfaces with **multiple** methods.
  - Can declare instance variables.
  - `"this"` → refers to inner class object.

- **Lambda Expression**
  - Only for **Functional Interfaces**.
  - Cannot declare instance variables.
  - `"this"` → refers to **enclosing class**.

---
