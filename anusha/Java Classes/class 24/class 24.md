# Java 8 Overview

Java 8 brought major enhancements to the language, focusing on a more functional and expressive programming style.

---

## 🧠 Programming Paradigms

### 1. Procedural Programming

* Emphasizes a step-by-step approach using functions and methods
* Focuses on the "how" and "what" of the task
* Involves the use of variables, loops, and conditional logic

### 2. Object-Oriented Programming (OOP)

* Structures programs using objects and classes
* Key OOP concepts:

  * **Class**: Blueprint to create objects
  * **Object**: Instance of a class
  * **Encapsulation**: Hiding implementation details
  * **Inheritance**: Sharing properties through `extends`
  * **Polymorphism**: Same method with different behavior
  * **Abstraction**: Showing only essential features

### 3. Scripting Languages

* Designed for short, automatable tasks
* Examples: JavaScript, Python, Bash

---

## 🚀 Java 8 Core Enhancements

1. Lambda Expressions
2. Functional Interfaces
3. Default and Static Methods in Interfaces
4. Built-in Functional Interfaces (Predicate, Function)
5. Method References
6. Stream API
7. Improved Date and Time API

---

## 🔁 1. Lambda Expressions

Lambda expressions are anonymous functions that help implement functional-style operations.

### Example 1: No Parameters

```java
@FunctionalInterface
interface A {
    void m1();
}

public class Example1 {
    public static void main(String[] args) {
        A a = () -> System.out.println("lambda example");
        a.m1();
    }
}
```

**Output:**

```
lambda example
```

### Example 2: With Parameters

```java
@FunctionalInterface
interface B {
    void add(int x, int y);
}

public class Example2 {
    public static void main(String[] args) {
        B b = (x, y) -> System.out.println(x + y + " is the result");
        b.add(10, 20);
        b.add(30, 80);
    }
}
```

**Output:**

```
30 is the result
110 is the result
```

---

### 📝 Lambda Syntax Examples

```java
() -> System.out.println("Hi")
(a) -> System.out.println(a)
(a, b) -> a + b
```

---

## Lambda with One Parameter

### Traditional vs Lambda

```java
(str) -> str
```

### Complete Example

```java
@FunctionalInterface
interface C {
    public void String(String str);
}

public class Example3 {
    public static void main(String[] args) {
        C c = (str) -> System.out.println(str);
        c.String("this is using lambda expression");
    }
}
```

**Output:**

```
this is using lambda expression
```

---

## Functional Interfaces

A Functional Interface is an interface with a **single abstract method (SAM)**.

### Examples

* `Runnable`: run()
* `Comparable`: compareTo()
* `Comparator`: compare()
* `ActionListener`: actionPerformed()
* `Callable`: call()

They may include default or static methods.

### Example

```java
interface Interf1 {
    void m1(); // SAM

    default void m2() {
        System.out.println("Hi");
    }
}
```

---

### Example 4: With Default and Static Methods

```java
@FunctionalInterface
interface D {
    void m1();

    default void m2() {
        System.out.println("this is a default method on functional interface");
    }

    static void m3() {
        System.out.println("this is a static method on functional interface");
    }
}

public class Example4 {
    public static void main(String[] args) {
        D d = () -> System.out.println("this is an abstract method");
        d.m1();
        d.m2();
        D.m3();
    }
}
```

**Output:**

```
this is an abstract method  
this is a default method on functional interface  
this is a static method on functional interface
```

---

## Functional Interface Inheritance Rules

### ✅ Valid Example

```java
@FunctionalInterface
interface A {
    void m1();
}

@FunctionalInterface
interface B extends A {
    void m1();
}
```

### ❌ Invalid Example

```java
@FunctionalInterface
interface A {
    void m1();
}

@FunctionalInterface
interface B extends A {
    void m2();
}
```

This results in a compilation error due to multiple abstract methods.

---

### Example 5: With Parameters

```java
@FunctionalInterface
interface E {
    void m1(int a);
}

@FunctionalInterface
interface F extends E {
    void m1(int a);
}

public class Example5 {
    public static void main(String[] args) {
        F f = (a) -> System.out.println("value of a is " + a);
        E e = (a) -> System.out.println("value of a is " + a);

        e.m1(10);
        f.m1(20);
    }
}
```

**Output:**

```
value of a is 10  
value of a is 20
```

---

### Example 6: Lambda with Interface Inheritance

```java
@FunctionalInterface
interface G {
    void m1(int a);
}

interface H extends G {
    void m2(int a);
}

public class Example6 {
    public static void main(String[] args) {
        G g = (a) -> System.out.println("value of a is " + a);
        g.m1(90);

        H h = new H() {
            public void m1(int a) {
                System.out.println("a value in m1 is " + a);
            }
            public void m2(int a) {
                System.out.println("a value in m2 is " + a);
            }
        };
        h.m1(10);
        h.m2(20);
    }
}
```

**Output:**

```
value of a is 90
 a value in m1 is 10
 a value in m2 is 20
```

---

### Example 7: Using Lambda with Multiple Interfaces

```java
@FunctionalInterface
interface G {
    void m1(int a);
}

interface H {
    void m2(int x, int y);
}

public class Example6 {
    public static void main(String[] args) {
        G g = (a) -> System.out.println("value of a is " + a);
        H h = (x, y) -> System.out.println(x + y + " is the result");

        g.m1(90);
        h.m2(30, 70);
    }
}
```

**Output:**

```
value of a is 90
100 is the result
```

---

## Interface and Class Inheritance Behavior

### Example 8

```java
interface K {
    public void m1();
}

class L implements K {
    @Override
    public void m1() {
        System.out.println("Inside m1 on L interface");
    }
}

public class Example8 {
    public static void main(String[] args) {
        L l = new L();
        l.m1();
    }
}
```

**Output:**

```
Inside m1 on L interface
```

---

### Example 9: Mixed Inheritance Patterns

```java
interface M {
    public void m1();
}

abstract class N {
    public abstract void m1();
}

class P {
    public void m1() {
        System.out.println("In P m1 method");
    }
}

class T extends N {
    @Override
    public void m1() {
        System.out.println("In T m1 method");
    }
}

public class Example9 {
    public static void main(String[] args) {
        M m = new M() {
            @Override
            public void m1() {
                System.out.println("Inside m1 on M");
            }
        };
        m.m1();

        N n = new T();
        n.m1();

        N n2 = new N() {
            @Override
            public void m1() {
                System.out.println("calling m1 on N interface");
            }
        };
        n2.m1();

        P n3 = new P() {
            @Override
            public void m1() {
                System.out.println("In Anonymous m1 method");
            }
        };
        n3.m1();
    }
}
```

**Output:**

```
Inside m1 on M
In T m1 method
calling m1 on N interface
In Anonymous m1 method
```

---

## Lambda vs Anonymous Inner Classes

### Example 10

```java
interface Inter1 {
    public void m1();
}

class Test1 {
    int x = 888;

    public void m2() {
        Inter1 i = new Inter1() {
            int x = 999;

            @Override
            public void m1() {
                System.out.println(this.x);
            }
        };
        i.m1();
    }
}

class Test2 {
    int x = 888;

    public void m2() {
        Inter1 i2 = () -> {
            int x = 999;
            System.out.println(this.x);
        };
        i2.m1();
    }
}

public class Example10 {
    public static void main(String[] args) {
        Test1 t1 = new Test1();
        t1.m2();

        Test2 t2 = new Test2();
        t2.m2();
    }
}
```

**Output:**

```
999
888
```

---

### Key Differences

| Feature                             | Anonymous Inner Class | Lambda Expression    |
| ----------------------------------- | --------------------- | -------------------- |
| Supports multiple abstract methods? | ✅ Yes                 | ❌ No (SAM only)      |
| Can extend a class?                 | ✅ Yes                 | ❌ No                 |
| Variables declared inside?          | ✅ Allowed             | ❌ Not allowed        |
| Instantiation                       | ✅ Can instantiate     | ❌ Cannot instantiate |
| `this` keyword refers to            | Inner class object    | Outer class object   |
| `.class` file                       | ✅ Created             | ❌ Not created        |

---

### 👍 Lambda Expression Advantages

* Reduces boilerplate code
* Supports functional programming
* Easier to pass as method arguments

---
