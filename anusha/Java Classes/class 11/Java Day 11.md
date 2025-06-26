# Interfaces & Polymorphism in Java

## ✅ Why Interfaces?
Interfaces in Java are used to support multiple inheritance and define a contract for implementing classes.

---

### 🔸 Key Characteristics of Interfaces
- Defined using the `interface` keyword.
- Cannot be instantiated.
- A class uses the `implements` keyword to inherit from an interface.
- All variables in interfaces are `public static final` by default.

### ✅ Why Use Interfaces?
- To provide a contract that multiple classes can implement.
- To achieve multiple inheritance.
- To separate "what to do" from "how to do it".

---

## 💡 Example 1: Basic Interface Implementation

```java
interface A {
    public abstract void m1();
    int x = 10;
    void m2();
    abstract void m3();
}

class B implements A {
    public void m1() {
        System.out.println("method1 on class B");
    }
    public void m2() {
        System.out.println("method2 on class B");
    }
    public void m3() {
        System.out.println("method3 on class B");
    }
}

class Main1 {
    public static void main(String[] args) {
        B b = new B();
        b.m1();
        b.m2();
        b.m3();
        System.out.println("value of x is :" + A.x);
    }
}
```

✅ Output:
```
method1 on class B
method2 on class B
method3 on class B
value of x is :10
```

---

## 💡 Example 2: Multiple Interfaces

```java
interface A {
    void m1();
    void m2();
}
interface B {
    void m3();
    void m4();
}

class C implements A, B {
    public void m1() {
        System.out.println("method1 on class C");
    }
    public void m2() {
        System.out.println("method2 on class C");
    }
    public void m3() {
        System.out.println("method3 on class C");
    }
    public void m4() {
        System.out.println("method4 on class C");
    }
}
```

✅ Output:
```
method1 on class C
method2 on class C
method3 on class C
method4 on class C
```

---

## 💡 Example 3: Interface Extending Another Interface

```java
interface A {
    void m1();
    static void m2() {
        System.out.println("the method2 on interface A");
    }
}

interface B extends A {
    void m3();
    static void m4() {
        System.out.println("the static method on interface B");
    }
}

class C implements A, B {
    public void m1() {
        System.out.println("method1 on class C");
    }
    public void m3() {
        System.out.println("method3 on class C");
    }
}
```

✅ Output:
```
method1 on class C
method3 on class C
the method2 on interface A
the static method on interface B
```

---

## 💡 Example 4: Interface Inheritance Chain

```java
interface A {
    void m1();
    void m2();
}
interface B extends A {
    void m3();
}

class C implements B {
    public void m1() {
        System.out.println("method1 on class C");
    }
    public void m2() {
        System.out.println("method2 on class C");
    }
    public void m3() {
        System.out.println("method3 on class C");
    }
}
```

✅ Output:
```
method1 on class C
method2 on class C
method3 on class C
```

---

## 💡 Example 5: Class + Multiple Interfaces

```java
class A {
    void m1() {
        System.out.println("method1 on class A");
    }
}

interface B {
    void m2();
}
interface C {
    void m3();
}

class D extends A implements B, C {
    public void m1() {
        System.out.println("method1 on class D");
    }
    public void m2() {
        System.out.println("method2 on class D");
    }
    public void m3() {
        System.out.println("method3 on class D");
    }
}
```

✅ Output:
```
method1 on class D
method2 on class D
method3 on class D
method1 on class A
```

---

## 💡 Example 6: One Class, One Interface

```java
class A {
    void m1() {
        System.out.println("method1 on class A");
    }
}

interface B {
    void m2();
    void m3();
}

class C extends A implements B {
    void m1() {
        System.out.println("method1 on class C");
    }
    public void m2() {
        System.out.println("method2 on class C");
    }
    public void m3() {
        System.out.println("method3 on class C");
    }
}
```

✅ Output:
```
method1 on class C
method2 on class C
method3 on class C
method1 on class A
```

---

## 💡 Example 7: Abstract Class and Interface

```java
abstract class A {
    public abstract void m1();
}

interface B {
    void m2();
}

class C extends A implements B {
    public void m1() {
        System.out.println("method1 on class C");
    }
    public void m2() {
        System.out.println("method2 on class C");
    }
}
```

✅ Output:
```
method1 on class C
method2 on class C
```

---

# 🔷 What is Polymorphism?

Polymorphism comes from the Greek words:

- **Poly** = many
- **Morph** = forms

It is a fundamental concept in Object-Oriented Programming (OOP) that allows one interface to be used for multiple implementations.

---

### ✨ Benefits of Polymorphism:
- Code reusability
- Flexibility
- Better maintainability

---

## 🔹 Types of Polymorphism in Java

---

### 1️⃣ Compile-time Polymorphism (Method Overloading)

Also known as Static Polymorphism.

```java
class Calci {
    public int multiply(int a, int b) {
        return a * b;
    }

    public int multiply(int a, int b, int c) {
        return a * b * c;
    }

    public int multiply(int a, int b, int c, int d) {
        return a * b * c * d;
    }
}

class Main2 {
    public static void main(String[] args) {
        Calci a = new Calci();
        System.out.println("Multiplication of 2 numbers: " + a.multiply(9, 8));
        System.out.println("Multiplication of 3 numbers: " + a.multiply(8, 6, 4));
        System.out.println("Multiplication of 4 numbers: " + a.multiply(9, 7, 8, 5));
    }
}
```

✅ Output:
```
Multiplication of 2 numbers: 72
Multiplication of 3 numbers: 192
Multiplication of 4 numbers: 2520
```

---

### 2️⃣ Runtime Polymorphism (Method Overriding)

Also known as Dynamic Polymorphism.

```java
class A {
    public void m1() {
        System.out.println("method1 in class A");
    }

    public void m2() {
        System.out.println("method2 in class A");
    }
}

class B extends A {
    @Override
    public void m1() {
        System.out.println("method1 in class B");
    }

    public void m3() {
        System.out.println("method3 in class B");
    }
}

class C extends A {
    @Override
    public void m1() {
        System.out.println("method1 in class C");
    }

    public void m4() {
        System.out.println("method4 in class C");
    }
}

class Runtime {
    public static void main(String[] args) {
        A a = new A();
        a.m1();
        a.m2();

        System.out.println();

        A a1 = new B();  // Upcasting
        a1.m1();         // Calls overridden m1 in B
        a1.m2();

        System.out.println();

        A a2 = new C();  // Upcasting
        a2.m1();         // Calls overridden m1 in C
        a2.m2();

        System.out.println();

        B b = new B();
        b.m1();
        b.m3();

        System.out.println();

        C c = new C();
        c.m1();
        c.m4();
    }
}
```

✅ Output:
```
method1 in class A
method2 in class A

method1 in class B
method2 in class A

method1 in class C
method2 in class A

method1 in class B
method3 in class B

method1 in class C
method4 in class C
```
