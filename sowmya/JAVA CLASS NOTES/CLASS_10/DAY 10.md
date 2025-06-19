# ABSTRACT AND INTERFACES

---

## ABSTRACT

In Java, the `abstract` keyword is a non-access modifier used for classes and methods to achieve **abstraction**, a core concept in Object-Oriented Programming (OOP).

### Abstract Class

An abstract class is a class declared with the `abstract` keyword.

* It **cannot be instantiated** directly.
* It can contain both **abstract methods** (no body) and **concrete methods** (with implementation).
* A subclass must **inherit** from it and provide implementations for the abstract methods.

### Abstract Method

An abstract method:

* Is declared with the `abstract` keyword.
* Has no implementation.
* Can only be declared within abstract classes.
* Must be overridden by subclasses.

### Example 1

```java
abstract class A {
    abstract void m1();
    void m2() {
        System.err.println("method2 on abstract method");
    }
}

class B extends A {
    @Override
    void m1() {
        System.out.println("method1 is calling on subclass");
    }
}

class Main1 {
    public static void main(String[] args) {
        B b = new B();
        b.m1();
        b.m2();
    }
}
```

**Output:**

```
method1 is calling on subclass
method2 on abstract method
```

### Example 2: Abstract and Normal Methods

```java
abstract class A {
    abstract void m1();
    abstract void m2();
    public void m3() {
        System.out.println("method 3 is calling on abstract");
    }
    public void m4() {
        System.out.println("method 4 is calling on abstract");
    }
}

class B extends A {
    @Override
    void m1() {
        System.out.println("method1 is calling on subclass B");
    }

    @Override
    void m2() {
        System.out.println("method 2 is calling on subclass");
    }
}

class Main2 {
    public static void main(String[] args) {
        B b = new B();
        b.m1();
        b.m2();
        b.m3();
        b.m4();
    }
}
```

**Output:**

```
method1 is calling on subclass B
method 2 is calling on subclass
method 3 is calling on abstract
method 4 is calling on abstract
```

### Example 3: Two Abstract Classes

```java
abstract class A {
    abstract void m1();
    void m2() {
        System.out.println("method on class A");
    }
}

class B extends A {
    @Override
    void m1() {
        System.out.println("method1 on subclass");
    }
}

abstract class C {
    void m1_C() {
        System.out.println("Abstract method on class C");
    }
    void m2_C() {
        System.out.println("abstract method on class C");
    }
}

class D extends C {
    @Override
    void m1_C() {
        System.out.println("method1 on C class");
    }
    @Override
    void m2_C() {
        System.out.println("method 2 on c class");
    }
}

class Main3 {
    public static void main(String[] args) {
        B b = new B();
        b.m1();
        b.m2();

        D d = new D();
        d.m1_C();
        d.m2_C();
    }
}
```

**Output:**

```
method1 on subclass
method on class A
method1 on C class
method 2 on c class
```

### Example 4: Static/Instance Members and Abstract Method

```java
abstract class A {
    static int y = 10;
    int x = 20;

    abstract void m1();
    void m2() {
        System.out.println("method2 on class A");
    }
    static void m3() {
        System.out.println("method 3 on static");
    }
}

class B extends A {
    @Override
    void m1() {
        System.out.println("method1 is calling in subclass");
    }
}

class Main4 {
    public static void main(String[] args) {
        B b = new B();
        b.m1();
        b.m2();
        A.m3();

        System.out.println("The instance variable value is :" + b.x);
        System.out.println("the static variable value is :" + A.y);
    }
}
```

**Output:**

```
method1 is calling in subclass
method2 on class A
method 3 on static
The instance variable value is :20
the static variable value is :10
```

### Example 5: Hierarchical Inheritance with Abstract Class

```java
abstract class A {
    abstract void m1();
    abstract void m2();
    void m3() {
        System.out.println("method3 on abstract class");
    }
    void m4() {
        System.out.println("method4 on abstract class");
    }
}

abstract class B extends A {
    @Override
    void m1() {
        System.out.println("method1 on class B");
    }
}

abstract class C extends A {
    @Override
    void m2() {
        System.out.println("method2 on class c");
    }
}

class D extends B {
    @Override
    void m2() {
        System.out.println("method2 on class c");
    }
}

class Main5 {
    public static void main(String[] args) {
        D d = new D();
        d.m1();
        d.m2();
        d.m3();
        d.m4();
    }
}
```

**Output:**

```
method1 on class B
method2 on class c
method3 on abstract class
method4 on abstract class
```

### Example 6: Alternate Hierarchical Inheritance

```java
abstract class A {
    abstract void m1();
    abstract void m2();
    void m3() {
        System.out.println("method3 on abstract class");
    }
    void m4() {
        System.out.println("method4 on abstract class");
    }
}

abstract class B extends A {
    @Override
    void m1() {
        System.out.println("method1 on class B");
    }
}

abstract class C extends A {
    @Override
    void m2() {
        System.out.println("method2 on class c");
    }
}

class D extends C {
    @Override
    void m1() {
        System.out.println("method1 on class d");
    }
}

class E extends D {}

class Main6 {
    public static void main(String[] args) {
        E e = new E();
        e.m1();
        e.m2();
        e.m3();
        e.m4();
    }
}
```

**Output:**

```
method1 on class d
method2 on class c
method3 on abstract class
method4 on abstract class
```

---

## INTERFACES

Interfaces in Java help avoid multiple inheritance issues by allowing classes to implement multiple interfaces.

### Key Points:

* Declared with `interface` keyword.
* Contain **abstract methods** by default (no method body).
* From Java 8, may include **default** and **static** methods.
* **Cannot be instantiated.**
* Classes implement interfaces using the `implements` keyword.

### Example: Interface Implementation

```java
interface A {
    public abstract void m1();
    int x = 10;
    void m2(); // Implicitly abstract
    abstract void m3();
}

class B implements A {
    @Override
    public void m1() {
        System.out.println("method1 on class B");
    }
    @Override
    public void m2() {
        System.out.println("method2 on class B");
    }
    @Override
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

**Output:**

```
method1 on class B
method2 on class B
method3 on class B
value of x is :10
```

---
