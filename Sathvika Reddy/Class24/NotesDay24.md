

# Java 8 Core Notes – Lambda, Functional Interfaces:

---

## Types of Programming Languages

1. **Procedural Programming**

   * Focuses on procedures/functions.
   * Executes step-by-step instructions.

2. **Object-Oriented Programming (OOP)**

   * Based on objects and classes.
   * Encapsulation, Inheritance, Polymorphism, and Abstraction.

3. **Functional Programming**

   * Emphasizes immutability and pure functions.
   * Functions are first-class citizens.

4. **Scripting Languages**

   * Interpreted at runtime.
   * Often used for automation and rapid development.

---

## Java 8 Core Features

### 1. **Lambda Expression (No Parameters)**

Lambda expressions enable writing anonymous methods in a concise way.

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

**Explanation:**

* Used to implement `m1()` in a single line.
* `A` is a functional interface (only one abstract method).

---

### 2. **Lambda Expression (With Parameters)**

```java
@FunctionalInterface
interface B {
    void add(int x, int y);
}

public class Ex2 {
    public static void main(String[] args) {
        B b = (x, y) -> System.out.println(x + y + " is the result");
        b.add(10, 20);
        b.add(30, 80);
    }
}
```

**Explanation:**

* Parameters can be passed directly in lambda.
* Used here to add and print the sum.

---

### 3. **Functional Interface with Default and Static Methods**

```java
@FunctionalInterface
interface D {
    void m1(); // abstract

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
        d.m1();       // Lambda
        d.m2();       // Default method
        D.m3();       // Static method via interface
    }
}
```

**Explanation:**

* `@FunctionalInterface` allows **one abstract method**, others can be static/default.
* Default methods can be overridden by implementing classes.
* Static methods accessed via interface.

---

### 4. **Interface, Abstract Class, Class – Combo Possibilities**

```java
interface M {
    void m1();
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
    public void m1() {
        System.out.println("In T m1 method");
    }
}

public class Example9 {
    public static void main(String[] args) {
        M m = new M() {
            public void m1() {
                System.out.println("Inside m1 on M");
            }
        };
        m.m1();

        N n = new T(); // Concrete subclass of abstract class
        n.m1();

        N n2 = new N() {
            public void m1() {
                System.out.println("calling m1 on N interface");
            }
        };
        n2.m1();

        P n3 = new P() {
            public void m1() {
                System.out.println("In Anonymous m1 method");
            }
        };
        n3.m1();
    }
}
```

**Explanation:**

* Demonstrates various object creation and method overriding patterns using interfaces, abstract, and concrete classes.
* Anonymous inner class syntax is shown.

---

### 5. **Lambda vs Anonymous Class – Scope Difference**

```java
interface Inter1 {
    void m1();
}

class Test1 {
    int x = 888;

    public void m2() {
        Inter1 i = new Inter1() {
            int x = 999;

            public void m1() {
                System.out.println(this.x); // refers to anonymous class variable
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
            System.out.println(this.x); // refers to enclosing class variable
        };
        i2.m1();
    }
}

public class Example10 {
    public static void main(String[] args) {
        Test1 t1 = new Test1();
        t1.m2(); // Output: 999

        Test2 t2 = new Test2();
        t2.m2(); // Output: 888
    }
}
```

**Explanation:**

* **Anonymous class**: `this` refers to the anonymous inner class.
* **Lambda**: `this` refers to the enclosing class (`Test2` here).
* Key difference in how scope and variables are accessed.

---


