# Java Day 6

## Constructors in Java

A **constructor** in Java is a special method used to **initialize objects** of a class. It is called **automatically** when an object is created.

### Key Points

* Constructor name must **match the class name**.
* It is a **block of code** used for object initialization.
* A **constructor is called after IIB (Instance Initialization Block)**.
* Constructors have **no return type** (not even `void`).
* Automatically invoked when using `new` to create an object.

### Types of Constructors

#### 1. Default Constructor

A constructor with **no parameters**.

```java
class Car {
    Car() {
        System.out.println("Car object created");
    }

    public static void main(String[] args) {
        Car myCar = new Car();  // Calls the default constructor
    }
}
```

#### 2. Parameterized Constructor

Takes **arguments** to initialize object values.

```java
class Student {
    String name;
    int age;

    Student(String n, int a) {
        name = n;
        age = a;
    }

    void display() {
        System.out.println(name + " " + age);
    }

    public static void main(String[] args) {
        Student s1 = new Student("Anusha", 21);
        s1.display();
    }
}
```

---

## Instance Initialization Block (IIB)

### 🔷 What is an IIB in Java?

* **IIB** stands for **Instance Initialization Block**.
* It is a block of code inside a class that runs **every time an object is created**, and **before the constructor is called**.

```java
{
    // instance initialization block
    System.out.println("IIB executed");
}
```

### ⚙️ How It Works

* Java runs IIBs **before constructors**.
* Used to **share common initialization logic** across multiple constructors.
* You can have **multiple IIBs**, and they execute in the **order they appear** in the class.

---

## `this` Keyword in Java

### 🔍 What is `this`?

* The `this` keyword is a **reference variable** in Java.
* It refers to the **current object** — the one whose method or constructor is being called.

### 🧠 Why is `this` used?

1. To refer to **current class instance variables**
2. To call **current class methods or constructors**
3. To **pass the current object** as a parameter
4. To **return the current object** from a method

---

### ✅ 1. Referring to Instance Variables

```java
class Student {
    String name;

    Student(String name) {
        this.name = name;  // Refers to the instance variable
    }
}
```

### ✅ 2. Calling Current Class Methods

```java
class Example {
    void show() {
        System.out.println("Hello");
    }

    void display() {
        this.show();  // same as just calling show();
    }
}
```

### ✅ 3. Calling a Constructor from Another Constructor

```java
class Student {
    String name;
    int age;

    Student() {
        this("Anusha", 22);  // Calls the parameterized constructor
    }

    Student(String name, int age) {
        this.name = name;
        this.age = age;
    }
}
```

### ✅ 4. Passing `this` as a Parameter

```java
class A {
    void show(A obj) {
        System.out.println("Object received");
    }

    void call() {
        show(this);  // Passing current object
    }
}
```
