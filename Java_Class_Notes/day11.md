# Interfaces, Abstract Classes, and Polymorphism in Java


---

## 🔷 Interface in Java
An **interface** is like a contract. It defines *what* a class should do, but not *how*.

```java
interface Animal {
    void makeSound();
}

class Dog implements Animal {
    public void makeSound() {
        System.out.println("Dog barks");
    }
}

class Cat implements Animal {
    public void makeSound() {
        System.out.println("Cat meows");
    }
}
```


- All methods in interfaces are public and abstract by default.
- A class can implement **multiple interfaces**.

---

##  Multiple Interfaces
Java allows a class to implement more than one interface.

interface Flyable {
    void fly();
}

interface Swimmable {
    void swim();
}

class Duck implements Flyable, Swimmable {
    public void fly() {
        System.out.println("Duck flies");
    }
    public void swim() {
        System.out.println("Duck swims");
    }
}
```

---

## Abstract Class + Interface
An **abstract class** gives partial implementation, while **interfaces** specify behavior.


abstract class Vehicle {
    abstract void start();
    void fuelType() {
        System.out.println("Diesel/Petrol");
    }
}

interface Electric {
    void charge();
}

class ElectricCar extends Vehicle implements Electric {
    void start() {
        System.out.println("Car starts silently");
    }
    public void charge() {
        System.out.println("Charging electric car");
    }
}
```

---

##  Interface Inheritance
Interfaces can **extend other interfaces**.

```java
interface A {
    void methodA();
}

interface B extends A {
    void methodB();
}

class Demo implements B {
    public void methodA() {
        System.out.println("Method A implemented");
    }
    public void methodB() {
        System.out.println("Method B implemented");
    }
}
```

---

##  Polymorphism in Java
Polymorphism means **many forms**. It allows one interface to be used for a general class of actions.

### Types:
1. **Compile-time Polymorphism (Static Binding)**
2. **Runtime Polymorphism (Dynamic Binding)**

---

###  Compile-Time Polymorphism
Achieved by **method overloading**.

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

> At compile time, the compiler determines which `add()` to use based on the arguments.

---

###  Run-Time Polymorphism
Achieved by **method overriding**.

```java
class Animal {
    void makeSound() {
        System.out.println("Animal makes sound");
    }
}

class Lion extends Animal {
    void makeSound() {
        System.out.println("Lion roars");
    }
}

public class Zoo {
    public static void main(String[] args) {
        Animal a = new Lion(); // Upcasting
        a.makeSound(); // Runtime call
    }
}
