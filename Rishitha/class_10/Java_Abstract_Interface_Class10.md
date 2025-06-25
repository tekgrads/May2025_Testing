
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

... (Content continues as provided earlier)

