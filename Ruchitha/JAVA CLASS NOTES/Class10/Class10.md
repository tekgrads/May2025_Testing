
# 🧑‍💻 Java Abstract Classes

This document explains the concept of **abstract classes** in Java with examples.

---

## 📘 What is an Abstract Class?

- A class that **cannot be instantiated**.
- Can contain **abstract methods** (no body) and **concrete methods** (with body).
- Used to provide a **base class** for other classes to extend.
- Declared using the `abstract` keyword.

---

## ✅ Basic Declaration

```java
abstract class A {
    abstract public void printname(String[] args);
}
```

---

## 🔹 Example 1: Abstract Class with Concrete Method

```java
abstract class A {
    abstract void m1();

    void m2() {
        System.out.println("A.m2");
    }
}

class B extends A {
    @Override
    void m1() {
        System.out.println("B.m1");
    }
}

class Manager {
    public static void main(String[] args) {
        A a = new B();
        a.m1();
        a.m2();
    }
}
```

---

## 🔹 Example 2: Multiple Abstract Classes

```java
abstract class A {
    abstract void m1();

    void m2() {
        System.out.println("A.m2");
    }
}

abstract class C {
    void m1_C() {
        System.out.println("C.m1");
    }

    void m2_C() {
        System.out.println("C.m2");
    }
}

class B extends A {
    @Override
    void m1() {
        System.out.println("B.m1");
    }
}

class Manager {
    public static void main(String[] args) {
        B b = new B();
        b.m1();
        b.m2();

        // Invalid: Cannot create object of abstract class
        // A a = new A();
        // C c = new C();
    }
}
```

---

## 🔸 Static Members in Abstract Classes

```java
abstract class A {
    static int x = 10;
    int y = 20;

    abstract void m1();

    void m2() {
        System.out.println("A.m2");
    }

    static void m3() {
        System.out.println("A.m3");
    }
}

class B extends A {
    @Override
    void m1() {
        System.out.println("B.m1");
    }
}

class Manager2 {
    public static void main(String[] args) {
        System.out.println("Static variable x: " + A.x);
        A.m3();

        B b = new B();
        b.m1();
        b.m2();
        System.out.println("Instance variable y: " + b.y);
    }
}
```

**Output:**
```
Static variable x: 10
A.m3
B.m1
A.m2
Instance variable y: 20
```

---

## 🔹 Multiple Abstract Methods

```java
abstract class A {
    abstract void test1();
    abstract void test2();

    void test3() {
        System.out.println("A.test3");
    }

    void test4() {
        System.out.println("A.test4");
    }
}

class B extends A {
    @Override
    void test1() {
        System.out.println("B.test1");
    }

    @Override
    void test2() {
        System.out.println("B.test2");
    }
}

public class Manager3 {
    public static void main(String[] args) {
        B b = new B();
        b.test1();
        b.test2();
        b.test3();
        b.test4();
        System.out.println("Manager3.main() completed successfully.");
    }
}
```

**Output:**
```
B.test1
B.test2
A.test3
A.test4
Manager3.main() completed successfully
```

---

## 🏛 Hierarchical Inheritance with Abstract Classes

```java
abstract class A {
    abstract void test1();
    abstract void test2();

    void test3() {
        System.out.println("A.test3");
    }

    void test4() {
        System.out.println("A.test4");
    }
}

abstract class C extends A {
    @Override
    void test1() {
        System.out.println("C.test1");
    }
}

abstract class D extends A {
    @Override
    void test2() {
        System.out.println("D.test2");
    }
}

class E extends C {
    @Override
    void test2() {
        System.out.println("E.test2");
    }
}

class F extends E {}

public class Manager4 {
    public static void main(String[] args) {
        E e = new E();
        e.test1();
        e.test2();
        e.test3();
        e.test4();
    }
}
```

**Output:**
```
C.test1
E.test2
A.test3
A.test4
```

---

## ⚙ Static Method Hiding

```java
abstract class A {
    abstract void m1();

    static void m2() {
        System.out.println("A.m2");
    }

    void m3() {
        System.out.println("A.m3");
    }
}

class B extends A {
    @Override
    void m1() {
        System.out.println("B.m1");
    }

    static void m2() {
        System.out.println("B.m2");
    }

    @Override
    void m3() {
        System.out.println("B.m3");
    }
}

public class Manager {
    public static void main(String[] args) {
        B b = new B();
        b.m1();      // B.m1
        A.m2();      // A.m2
        B.m2();      // B.m2
        b.m3();      // B.m3
        System.out.println("Manager.main() completed successfully.");
    }
}
```

---

## ✅ Summary

- Abstract classes provide a template for subclasses.
- They **must be extended** to create concrete objects.
- Can include **both abstract and non-abstract methods**.
- Static methods belong to the class, not instances.

---

> ✅ Great for interview prep and understanding OOP in Java!
