# ABSTRACT AND INTERFACES

---

## ABSTRACT

In Java, the `abstract` keyword is a non-access modifier used for classes and methods to achieve **abstraction**, a core concept in Object-Oriented Programming (OOP).

### Abstract Class

An abstract class is a class declared with the `abstract` keyword.

* It **cannot be instantiated** directly; you cannot create objects of an abstract class.
* It can contain both **abstract methods** (methods without a body) and **concrete methods** (methods with an implementation).
* To use an abstract class, it must be **inherited** by another class (a subclass).
* That subclass must provide implementations for all abstract methods inherited from the abstract class.

### Abstract Method

An abstract method is a method declared with the `abstract` keyword and without a body (no implementation).

* Abstract methods can **only exist** within abstract classes.
* Subclasses that extend an abstract class containing abstract methods are **obligated to provide** a concrete implementation for those methods.

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

### Output

```
method1 is calling on subclass
method2 on abstract method
```
