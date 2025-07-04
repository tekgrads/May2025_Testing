
# Java Inheritance, Types, Method Overloading, and `super` Keyword

## 1. What is Inheritance?

Inheritance in Java is an **object-oriented programming (OOP)** feature that allows a class (subclass) to **inherit fields and methods** from another class (superclass). It helps achieve code **reusability** and **hierarchical classification**.

**Syntax:**

```java
class Parent {
    // parent class members
}

class Child extends Parent {
    // child class members
}
```

---

## 2. Types of Inheritance in Java

> Note: Java does not support **multiple inheritance with classes** (to avoid ambiguity), but it supports **multiple inheritance using interfaces**.

### a) Single Inheritance

A class inherits from one superclass.

```java
class Animal {
    void eat() {
        System.out.println("This animal eats food.");
    }
}

class Dog extends Animal {
    void bark() {
        System.out.println("Dog barks.");
    }
}

public class Main {
    public static void main(String[] args) {
        Dog d = new Dog();
        d.eat();
        d.bark();
    }
}
```

### b) Multilevel Inheritance

A class inherits from a class which is already a child of another class.

```java
class Animal {
    void eat() {
        System.out.println("Eating...");
    }
}

class Dog extends Animal {
    void bark() {
        System.out.println("Barking...");
    }
}

class Puppy extends Dog {
    void weep() {
        System.out.println("Weeping...");
    }
}

public class Main {
    public static void main(String[] args) {
        Puppy p = new Puppy();
        p.eat();
        p.bark();
        p.weep();
    }
}
```

### c) Hierarchical Inheritance

Multiple classes inherit from a single superclass.

```java
class Animal {
    void eat() {
        System.out.println("Eating...");
    }
}

class Dog extends Animal {
    void bark() {
        System.out.println("Barking...");
    }
}

class Cat extends Animal {
    void meow() {
        System.out.println("Meowing...");
    }
}

public class Main {
    public static void main(String[] args) {
        Dog d = new Dog();
        d.eat();
        d.bark();

        Cat c = new Cat();
        c.eat();
        c.meow();
    }
}
```

### d) Multiple Inheritance (Using Interfaces)

```java
interface A {
    void show();
}

interface B {
    void display();
}

class C implements A, B {
    public void show() {
        System.out.println("Showing A");
    }

    public void display() {
        System.out.println("Displaying B");
    }
}

public class Main {
    public static void main(String[] args) {
        C obj = new C();
        obj.show();
        obj.display();
    }
}
```

---

## 3. Method Overloading

**Method overloading** occurs when multiple methods in the same class have the same name but different **parameter lists** (type, number, or both).

```java
class MathOperation {
    int add(int a, int b) {
        return a + b;
    }

    double add(double a, double b) {
        return a + b;
    }

    int add(int a, int b, int c) {
        return a + b + c;
    }
}

public class Main {
    public static void main(String[] args) {
        MathOperation m = new MathOperation();
        System.out.println(m.add(2, 3));
        System.out.println(m.add(2.5, 3.5));
        System.out.println(m.add(1, 2, 3));
    }
}
```

### Key Points:

- Happens in the **same class**.
- Return type can be same or different.
- Parameter list must be **different**.

---

## 4. The `super` Keyword

`super` refers to the **parent class object**. It is used for:

- Calling **parent class constructor**
- Accessing **parent class methods**
- Accessing **parent class variables**

### a) Calling Superclass Constructor

```java
class Animal {
    Animal() {
        System.out.println("Animal is created");
    }
}

class Dog extends Animal {
    Dog() {
        super();  // Calls Animal()
        System.out.println("Dog is created");
    }
}

public class Main {
    public static void main(String[] args) {
        Dog d = new Dog();
    }
}
```

### b) Calling Superclass Method

```java
class Animal {
    void eat() {
        System.out.println("Eating...");
    }
}

class Dog extends Animal {
    void eat() {
        super.eat(); // Calls parent eat()
        System.out.println("Eating dog food...");
    }
}

public class Main {
    public static void main(String[] args) {
        Dog d = new Dog();
        d.eat();
    }
}
```

### c) Accessing Superclass Variable

```java
class Animal {
    String color = "white";
}

class Dog extends Animal {
    String color = "black";

    void printColor() {
        System.out.println(super.color);  // Accesses Animal's color
        System.out.println(this.color);   // Accesses Dog's color
    }
}

public class Main {
    public static void main(String[] args) {
        Dog d = new Dog();
        d.printColor();
    }
}
