Java Notes - class 6(12/06/025)
# ☕ Java Concepts: Constructors, Keywords, IIB, and Polymorphism

---

## 1️⃣ Constructors

A **constructor** is a special method used to initialize objects. It is called automatically when an object of a class is created.

### ✅ Example:
```java
class Car {
    String model;

    Car() {  // Constructor
        model = "Default Model";
    }
}
```

---

## 2️⃣ Constructor Overloading

**Constructor Overloading** means defining multiple constructors with different parameter lists in the same class.

### ✅ Example:
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

---

## 3️⃣ `this` Keyword

The **`this` keyword** refers to the current object inside a method or constructor.

### ✅ Example:
```java
class Car {
    String model;

    Car(String model) {
        this.model = model;  // Refers to instance variable
    }
}
```

---

## 4️⃣ `super` Keyword

The **`super` keyword** is used to refer to the immediate parent class object. It can be used to call parent class methods or constructors.

### ✅ Example:
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

---

## 5️⃣ Instance Initialization Block (IIB)

An **Instance Initialization Block** is a block of code that runs **before the constructor** whenever an object is created.

### ✅ Example:
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

---

## 6️⃣ Polymorphism

**Polymorphism** means the ability of one entity (method or object) to take multiple forms.

There are two types:
- **Compile-time Polymorphism** (Method Overloading)
- **Runtime Polymorphism** (Method Overriding)

---

### 🔹 Method Overloading (Compile-time Polymorphism)
Multiple methods with the same name but different parameters.

#### ✅ Example:
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

---

### 🔸 Method Overriding (Runtime Polymorphism)
A subclass provides a specific implementation of a method already defined in its superclass.

#### ✅ Example:
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

---