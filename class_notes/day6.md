
# Java Concepts: Constructors, Keywords, IIB, and Polymorphism

## 1. Constructor

A constructor in Java is a special method used to initialize objects. It is called when an object is created.

### Example:
```java
class Car {
    String model;

    Car() {  // Constructor
        model = "Default Model";
    }
}
```

## 2. Constructor Overloading

Constructor overloading means creating multiple constructors with different parameter lists in the same class.

### Example:
```java
class Car {
    String model;
    int year;

    Car() {
        model = "Default Model";
        year = 2000;
    }

    Car(String m) {
        model = m;
        year = 2000;
    }

    Car(String m, int y) {
        model = m;
        year = y;
    }
}
```

## 3. `this` Keyword

`this` keyword refers to the current object. It is used to differentiate between instance variables and parameters when they have the same name.

### Example:
```java
class Car {
    String model;

    Car(String model) {
        this.model = model;  // Refers to the instance variable
    }
}
```

## 4. `super` Keyword

`super` refers to the parent class (superclass) and is used to call superclass constructors and methods.

### Example:
```java
class Vehicle {
    Vehicle() {
        System.out.println("Vehicle constructor");
    }
}

class Car extends Vehicle {
    Car() {
        super(); // Calls Vehicle constructor
        System.out.println("Car constructor");
    }
}
```

## 5. Instance Initialization Block (IIB)

An IIB is a block of code that runs every time an object is created, before the constructor.

### Example:
```java
class Car {
    {
        System.out.println("IIB Block Executed");
    }

    Car() {
        System.out.println("Constructor Executed");
    }
}
```

## 6. Polymorphism

Polymorphism means one action behaving differently in different situations. It is of two types:

- **Compile-time polymorphism (Method Overloading)**
- **Runtime polymorphism (Method Overriding)**

### Method Overloading Example:
```java
class MathOperation {
    int add(int a, int b) {
        return a + b;
    }

    double add(double a, double b) {
        return a + b;
    }
}
```

### Method Overriding Example:
```java
class Animal {
    void sound() {
        System.out.println("Animal makes sound");
    }
}

class Dog extends Animal {
    void sound() {
        System.out.println("Dog barks");
    }
}
```

### Usage:
```java
Animal a = new Dog();
a.sound();  // Output: Dog barks
```
