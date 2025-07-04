
# Java Packages and Access Specifiers

## What is a Package?

A package in Java is a group of similar types of classes, interfaces, and sub-packages. It helps organize code and prevent name conflicts.

### Advantages of Packages:
- Code reusability and modularity
- Easy to locate and use classes/interfaces
- Encapsulation of related classes

## Types of Packages

1. **Built-in Packages** – Provided by Java (e.g., `java.util`, `java.io`, `java.sql`)
2. **User-defined Packages** – Created by programmers for grouping their own classes

## Creating a Package

```java
// File: mypack/MyClass.java
package mypack;

public class MyClass {
    public void greet() {
        System.out.println("Hello from MyClass");
    }
}
```

## Using a Package

```java
// File: Main.java
import mypack.MyClass;

public class Main {
    public static void main(String[] args) {
        MyClass obj = new MyClass();
        obj.greet();
    }
}
```

## Access Specifiers in Java

Access specifiers define the scope of accessibility of classes, methods, and variables.

| Modifier     | Class | Package | Subclass | World |
|--------------|-------|---------|----------|--------|
| `public`     | Yes   | Yes     | Yes      | Yes    |
| `protected`  | Yes   | Yes     | Yes      | No     |
| (default)    | Yes   | Yes     | No       | No     |
| `private`    | Yes   | No      | No       | No     |

## Example of Access Levels

```java
// File: mypack/Animal.java
package mypack;

public class Animal {
    public String name = "Lion";
    protected int age = 3;
    String color = "Golden"; // default
    private double weight = 190.5;

    public void showInfo() {
        System.out.println(name + ", " + age + ", " + color + ", " + weight);
    }
}
```

```java
// File: otherpackage/TestAnimal.java
package otherpackage;
import mypack.Animal;

public class TestAnimal {
    public static void main(String[] args) {
        Animal a = new Animal();
        System.out.println(a.name);      // Accessible (public)
        // System.out.println(a.age);    // Not accessible (protected)
        // System.out.println(a.color);  // Not accessible (default)
        // System.out.println(a.weight); // Not accessible (private)
    }
}
```

## Folder Structure

```
project/
├── mypack/
│   └── Animal.java
├── otherpackage/
│   └── TestAnimal.java
└── Main.java
```


- Packages help organize Java code.
- Access specifiers define how accessible a class or class member is.
- Use `javac -d . filename.java` to compile with proper package structure.
- Always follow best practices for encapsulation and modularity.
