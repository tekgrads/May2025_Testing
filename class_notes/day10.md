# Interfaces and Polymorphism in Java

## Interfaces in Java

### What is an Interface?

An **interface** in Java is a reference type, similar to a class, that can contain only constants, method signatures, default methods, static methods, and nested types. Interfaces cannot contain instance fields or constructors. All methods in interfaces are implicitly **public** and **abstract** (except static and default methods).

### Syntax:

```java
interface Animal {
    void makeSound();
}
```

### Key Points:

* Interfaces define a contract — what a class **must** do, but not **how**.
* A class implements an interface using the `implements` keyword.
* A class can implement **multiple interfaces** (unlike classes, which support only single inheritance).

### Example:

```java
interface Animal {
    void makeSound();
}

class Dog implements Animal {
    public void makeSound() {
        System.out.println("Woof");
    }
}

class Cat implements Animal {
    public void makeSound() {
        System.out.println("Meow");
    }
}
```

---

## Polymorphism in Java

### What is Polymorphism?

**Polymorphism** means "many forms." In Java, polymorphism allows objects of different classes to be treated as objects of a common super class or interface.

There are two types of polymorphism in Java:

1. **Compile-time polymorphism (Method Overloading)**
2. **Runtime polymorphism (Method Overriding)**

---

### 1. Compile-time Polymorphism (Method Overloading)

Method overloading occurs when multiple methods have the same name but different parameters (different type or number).

#### Example:

```java
class MathUtils {
    int add(int a, int b) {
        return a + b;
    }

    double add(double a, double b) {
        return a + b;
    }
}
```

---

### 2. Runtime Polymorphism (Method Overriding)

Occurs when a subclass provides a specific implementation of a method already defined in its superclass or interface.

#### Example:

```java
class Animal {
    void makeSound() {
        System.out.println("Some sound");
    }
}

class Dog extends Animal {
    void makeSound() {
        System.out.println("Woof");
    }
}

public class Main {
    public static void main(String[] args) {
        Animal a = new Dog();
        a.makeSound();  // Output: Woof
    }
}
```

Here, the type of object `a` is `Animal`, but it refers to a `Dog`, so the `Dog`'s version of `makeSound()` is called.

---

## Interfaces and Polymorphism Together

Interfaces support **runtime polymorphism** because any class that implements an interface can be referred to by the interface type.

### Example:

```java
interface Shape {
    void draw();
}

class Circle implements Shape {
    public void draw() {
        System.out.println("Drawing Circle");
    }
}

class Square implements Shape {
    public void draw() {
        System.out.println("Drawing Square");
    }
}

public class TestShapes {
    public static void main(String[] args) {
        Shape s1 = new Circle();
        Shape s2 = new Square();

        s1.draw();  // Output: Drawing Circle
        s2.draw();  // Output: Drawing Square
    }
}
```

---

