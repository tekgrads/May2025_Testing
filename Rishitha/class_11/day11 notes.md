
# 🌐 Java Interfaces & Polymorphism

---

## 🔹 What is an Interface?

In Java, an `interface` is a blueprint for a class. It provides **abstraction** by defining *what to do* but not *how to do it*.

### ✨ Key Features of Interface:

- All methods are **public** and **abstract** by default.
- Variables are **public static final** (constants).
- From **Java 8**, supports `default` and `static` methods.
- Interfaces support **Multiple Inheritance** (unlike classes).
- Cannot create objects of interface directly.

---

## 🧪 Example 1: Basic Interface

```java
interface A {
    void m1();
    int x = 10;
    void m2();
}

class B implements A {
    public void m1() {
        System.out.println("method1 in B");
    }
    public void m2() {
        System.out.println("method2 in B");
    }
}

class Main {
    public static void main(String[] args) {
        B b = new B();
        b.m1();
        b.m2();
        System.out.println("x = " + A.x);
    }
}
````

### Output:

```
method1 in B
method2 in B
x = 10
```

---

## 🧪 Example 2: Multiple Interfaces

```java
interface A {
    void m1();
}
interface B {
    void m2();
}
class C implements A, B {
    public void m1() {
        System.out.println("A's method");
    }
    public void m2() {
        System.out.println("B's method");
    }
}
```

---

## 🧪 Example 3: Interface Inheritance

```java
interface A {
    void m1();
    static void m2() {
        System.out.println("static in A");
    }
}
interface B extends A {
    void m3();
    static void m4() {
        System.out.println("static in B");
    }
}
```

---

## 🧪 Example 4: Abstract Class + Interface

```java
abstract class A {
    abstract void m1();
}
interface B {
    void m2();
}
class C extends A implements B {
    public void m1() {
        System.out.println("method1 in C");
    }
    public void m2() {
        System.out.println("method2 in C");
    }
}
```

---

# 🔁 Polymorphism in Java

---

## 📘 What is Polymorphism?

Polymorphism means **"many forms"**. It allows a method to behave differently depending on the object that calls it.

### 🔸 Two Types:

1. **Compile-Time Polymorphism** – Method Overloading
2. **Runtime Polymorphism** – Method Overriding

---

## ⚙️ Compile-Time Polymorphism (Overloading)

```java
class Calci {
    public int add(int a, int b) {
        return a + b;
    }
    public int add(int a, int b, int c) {
        return a + b + c;
    }
}

class Main {
    public static void main(String[] args) {
        Calci c = new Calci();
        System.out.println(c.add(2, 3));
        System.out.println(c.add(1, 2, 3));
    }
}
```

### Output:

```
5
6
```

---

## ⚙️ Runtime Polymorphism (Overriding)

```java
class A {
    void show() {
        System.out.println("A class method");
    }
}
class B extends A {
    void show() {
        System.out.println("B class method");
    }
}
class Main {
    public static void main(String[] args) {
        A obj = new B();  // Upcasting
        obj.show();       // Calls B's method at runtime
    }
}
```

### Output:

```
B class method
```

---

## ✅ Why Use Interfaces & Polymorphism?

* 🔁 Reusability
* 🔗 Loose Coupling
* 🛠 Flexibility
* 📈 Maintainability
* 📚 Scalability

---


