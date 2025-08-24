
# Java Constructors, Keywords, and Polymorphism

## 1. Constructors

A constructor is a special method that is used to initialize objects. It is called when an object of a class is created.

### Example:
```java
class Person {
    String name;

    // Constructor
    Person(String name) {
        this.name = name;
    }

    void display() {
        System.out.println("Name: " + name);
    }
}
```

## 2. `this` Keyword

`this` refers to the current object in a method or constructor.

### Example:
```java
class Student {
    int id;

    Student(int id) {
        this.id = id; // refers to the instance variable
    }
}
```

## 3. `super` Keyword

`super` is used to refer to the immediate parent class object. It can call parent class methods or constructors.

### Example:
```java
class Animal {
    Animal() {
        System.out.println("Animal constructor called");
    }
}

class Dog extends Animal {
    Dog() {
        super(); // calls Animal constructor
        System.out.println("Dog constructor called");
    }
}
```

## 4. IIB (Instance Initialization Block)

An IIB is a block of code inside a class that is executed every time an object is created, before the constructor.

### Example:
```java
class Example {
    {
        System.out.println("IIB block executed");
    }

    Example() {
        System.out.println("Constructor executed");
    }
}
```

## 5. Constructor Overloading

Constructor overloading means having multiple constructors with different parameters.

### Example:
```java
class OverloadExample {
    int x;
    String y;

    OverloadExample() {
        x = 0;
        y = "Default";
    }

    OverloadExample(int x) {
        this.x = x;
        y = "Given";
    }

    OverloadExample(int x, String y) {
        this.x = x;
        this.y = y;
    }
}
```

## 6. Polymorphism

Polymorphism means the ability to take many forms. In Java, this can be achieved through method overloading and method overriding.

### Compile-Time Polymorphism (Method Overloading)
```java
class Add {
    int sum(int a, int b) {
        return a + b;
    }

    double sum(double a, double b) {
        return a + b;
    }
}
```

### Runtime Polymorphism (Method Overriding)
```java
class Animal {
    void sound() {
        System.out.println("Animal makes a sound");
    }
}

class Dog extends Animal {
    @Override
    void sound() {
        System.out.println("Dog barks");
    }
}
```

