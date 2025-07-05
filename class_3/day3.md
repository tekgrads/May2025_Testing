# Data Types in Java

## Primitive Data Types

Java has 8 primitive data types:

| Data Type | Size    | Description                           | Example                  |
| --------- | ------- | ------------------------------------- | ------------------------ |
| byte      | 1 byte  | Stores whole numbers from -128 to 127 | `byte b = 100;`          |
| short     | 2 bytes | Whole numbers from -32,768 to 32,767  | `short s = 20000;`       |
| int       | 4 bytes | Whole numbers from \~-2B to +2B       | `int i = 123456;`        |
| long      | 8 bytes | Larger whole numbers                  | `long l = 12345678900L;` |
| float     | 4 bytes | Decimal numbers (single precision)    | `float f = 12.5f;`       |
| double    | 8 bytes | Decimal numbers (double precision)    | `double d = 12.5;`       |
| char      | 2 bytes | A single 16-bit Unicode character     | `char c = 'A';`          |
| boolean   | 1 bit   | True or false values                  | `boolean b = true;`      |

## Non-Primitive (Reference) Data Types

These are objects or references to objects and include:

| Type       | Description                      | Example                      |
| ---------- | -------------------------------- | ---------------------------- |
| String     | Sequence of characters           | `String str = "Hello";`      |
| Arrays     | Collection of similar data types | `int[] arr = {1, 2, 3};`     |
| Classes    | User-defined types               | `class MyClass { ... }`      |
| Enums      | Constants with fixed values      | `enum Day { MON, TUE, ... }` |
| Interfaces | Blueprint for classes            | `interface Drawable { ... }` |

# Class and Object

## Class

A class is a blueprint for creating objects. It defines the properties (data/variables) and behaviours (methods/functions).

**Example:**

```java
public class Student {
    String name;
    int age;

    void printStudentDetails() {
        System.out.println("Name is " + name + ", Age is " + age);
    }
}
```

## Object

An object is an instance of a class. The `new` keyword is used to create an object.

**Example:**

```java
public class Main {
    public static void main(String[] args) {
        Student student1 = new Student();
        student1.name = "Sowmya";
        student1.age = 20;
        student1.printStudentDetails();
    }
}
```

# Functions or Methods

Functions in Java are called methods. They are blocks of code that perform specific tasks and can be reused.

**Example: Multiplication of two numbers**

```java
public class Multiplication {
    public static int multiply(int a, int b) {
        return a * b;
    }

    public static void main(String[] args) {
        int num1 = 90;
        int num2 = 98;
        int result = multiply(num1, num2);
        System.out.println("Output is: " + result);
    }
}
```

# Access Specifiers in Java

Java has 4 access specifiers:

## 1. `public`

Accessible from any other class.

```java
class Show {
    public int age = 19;
    public void print() {
        System.out.println("Age is " + age);
    }
}
```

## 2. `private`

Accessible only within the class.

```java
class EmployeeDetails {
    private int salary = 50000;
    private void display() {
        System.out.println("Private method");
    }
}
```

## 3. Default (no specifier)

Accessible only within the same package.

```java
class Show1 {
    int number = 5; // default access
    void display() {
        System.out.println("Default");
    }
}
```

## 4. `protected`

Accessible within the same package and by subclasses in other packages.

```java
class Show2 {
    protected int number = 5;
    protected void display() {
        System.out.println("Protected method");
    }
}
```

# Static Keyword

`static` is used for memory management. Static members belong to the class rather than any instance.

**Example:**

```java
class Student {
    String name;
    int rollno;
    static String clgname;

    void studentInfo() {
        System.out.println("Name: " + name);
        System.out.println("Roll No: " + rollno);
        System.out.println("College: " + clgname);
    }
}

public class Main {
    public static void main(String[] args) {
        Student.clgname = "CVR";

        Student student1 = new Student();
        student1.name = "Sowmya";
        student1.rollno = 19;

        Student student2 = new Student();
        student2.name = "Kavitha";
        student2.rollno = 20;

        student1.studentInfo();
        student2.studentInfo();
    }
}
```
