
# Day 10 - Interface VS Polymorphism

## Interface in Java
- Interface is a reference type, containing only method declarations (abstract methods) and constants (public static and final variables).
- It is a completely abstract class used to group related methods with empty bodies.
- The body of the interface method is provided by the "implement" class.
- Interfaces cannot be used to create objects.

### Key Features of Interface:
- All methods in interfaces are implicitly `public` and `abstract`.
- All variables are `public`, `static`, and `final`.
- A class implements an interface (not extends).

### Syntax:
```java
interface Vehicle {
    void start();
    void stop();
}
```

### Implementing an Interface:
```java
class Car implements Vehicle {
    public void start() {
        System.out.println("Car started");
    }
    public void stop() {
        System.out.println("Car stopped");
    }
}
```

## Multiple Interfaces in Java:
- A class can implement more than one interface.
- This is Java’s way of achieving multiple inheritance (unlike classes, which do not support it directly).

### Example:
```java
interface Engine {
    void engineStart();
}
interface Wheels {
    void rotateWheels();
}
class Bike implements Engine, Wheels {
    public void engineStart() {
        System.out.println("Bike engine started");
    }
    public void rotateWheels() {
        System.out.println("Wheels are rotating");
    }
}
```

## Why Use Interfaces?
- To achieve **loose coupling** (i.e., minimal dependency between components).
- To implement **polymorphism**.
- To abstract behavior across unrelated classes.
- To support **multiple inheritance**.

---

## Interface VS Polymorphism

### Polymorphism:
- Polymorphism is one of the OOPs concepts which means **many forms**.
- It allows one interface or method to behave differently based on the object.

### Types of Polymorphisms:
1. **Compile-time Polymorphism** – Method Overloading
2. **Runtime Polymorphism** – Method Overriding

### Compile-time Polymorphism (Overloading):
```java
class Math {
    int add(int a, int b) {
        return a + b;
    }
    double add(double a, double b) {
        return a + b;
    }
}
```

### Runtime Polymorphism (Overriding using Interface):
```java
Animal a;
a = new Dog();
a.makeSound();  // Outputs: Barks
a = new Cat();
a.makeSound();  // Outputs: Meows
```
