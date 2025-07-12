# Classes, Pass by Value, Setters & Getters, Constructors

## 1. Classes in Java

A class is a blueprint for creating objects. It defines properties (fields) and behaviors (methods). Think of it as a cookie-cutter — the class is the cutter, and the cookies are the objects.

### Example:
```java
public class Cookie {
    String flavor;
    int size;

    void eat() {
        System.out.println("Nom nom... delicious " + flavor + " cookie!");
    }
}
```

## 2. Pass by Value

In Java, all primitive types are passed by value — like giving someone a photocopy instead of the original document. Objects are also passed by value, but the value is the reference.

### Example:
```java
public class ValueDemo {
    public static void changeNumber(int num) {
        num = 100;
    }

    public static void main(String[] args) {
        int x = 50;
        changeNumber(x);
        System.out.println("Value of x: " + x); // Still 50
    }
}
```

### Object Reference Example:
```java
class Person {
    String name;
}

public class ReferenceDemo {
    public static void changeName(Person p) {
        p.name = "Changed";
    }

    public static void main(String[] args) {
        Person p1 = new Person();
        p1.name = "Original";
        changeName(p1);
        System.out.println("Name: " + p1.name); // Changed
    }
}
```

## 3. Setter and Getter Methods

These are methods used to control access to fields. Like using a polite butler to handle all requests instead of letting people storm into your room.

### Example:
```java
public class Student {
    private String name;

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}

public class TestStudent {
    public static void main(String[] args) {
        Student s = new Student();
        s.setName("Alice");
        System.out.println("Student name: " + s.getName());
    }
}
```


## 4. Constructors

Constructors are special methods used to initialize objects. If a class were a house, constructors would be the builders who set everything up when the house is made.

### Example:
```java
public class Car {
    String model;

    // Constructor
    public Car(String model) {
        this.model = model;
    }

    void display() {
        System.out.println("Car model: " + model);
    }

    public static void main(String[] args) {
        Car myCar = new Car("Tesla");
        myCar.display();
    }
}
```


