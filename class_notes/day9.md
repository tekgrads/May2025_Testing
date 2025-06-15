
# Java Concepts: Packages, Accessing Packages, and Encapsulation

## 1. Packages in Java

A **package** in Java is a namespace that organizes a set of related classes and interfaces. It helps avoid name conflicts and controls access.

### Types of Packages:
- **Built-in Packages**: Provided by Java API (`java.util`, `java.io`, etc.)
- **User-defined Packages**: Created by the programmer

### Creating a Package:
```java
package mypackage;

public class MyClass {
    public void display() {
        System.out.println("Hello from MyClass in mypackage");
    }
}
```

## 2. How to Access Packages

To use a class from another package, use the `import` statement.

### Example: Accessing a class from a package
```java
// File: mypackage/MyClass.java
package mypackage;

public class MyClass {
    public void display() {
        System.out.println("Hello from MyClass");
    }
}
```

```java
// File: Test.java
import mypackage.MyClass;  // Importing the package

public class Test {
    public static void main(String[] args) {
        MyClass obj = new MyClass();
        obj.display();
    }
}
```

## 3. Encapsulation

**Encapsulation** is the process of wrapping data (variables) and code (methods) together as a single unit. It restricts direct access to some components, which is a way of implementing **data hiding**.

### How to achieve encapsulation:
1. Make variables `private`.
2. Provide `public` getters and setters.

### Example:
```java
class Student {
    private String name;  // Private variable

    // Getter method
    public String getName() {
        return name;
    }

    // Setter method
    public void setName(String newName) {
        name = newName;
    }
}

public class Main {
    public static void main(String[] args) {
        Student s = new Student();
        s.setName("John");  // Setting value via setter
        System.out.println(s.getName());  // Getting value via getter
    }
}
```

### Benefits of Encapsulation:
- Data hiding: Internal object details are hidden from outside.
- Controlled access: You can control how variables are accessed/modified.
- Increased flexibility and maintainability.
