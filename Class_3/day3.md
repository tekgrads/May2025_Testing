# 📘 Programming Concepts in Java 

---

## 1. 📊 Data Types

### ➤ Definition:
Data types specify the kind of data a variable can hold.

### ➤ Common Data Types in Java:

| Data Type | Example                     | Description          |
|-----------|-----------------------------|----------------------|
| int       | `int x = 10;`               | Integer values       |
| double    | `double y = 3.14;`          | Floating point       |
| char      | `char ch = 'A';`            | Single character     |
| boolean   | `boolean flag = true;`      | True or false        |
| String    | `String name = "Sathvika";` | Sequence of chars    |

### ➤ Example:
public class DataTypeExample {
    public static void main(String[] args) {
        int x = 10;
        double y = 3.5;
        String name = "Sathvika";

        System.out.println(x);         // 10
        System.out.println(y);         // 3.5
        System.out.println(name);      // Sathvika
    }
}


## 2. 🧱 OOPs Concepts

### ➤ 1. Class
A class is a blueprint for creating objects.
class Person {
    String name;

    Person(String name) {
        this.name = name;
    }
}


### ➤ 2. Object
An object is an instance of a class.
Person p = new Person("Sathvika");


### ➤ 3. Encapsulation
Hiding internal state and accessing via methods.


### ➤ 4. Abstraction
Hiding implementation details and showing essential features.

### ➤ 5. Inheritance
A class inherits properties and methods of another class.

### ➤ 6. Polymorphism
Same method behaves differently in different classes.

## 3. 🔁 Functions (Methods)

### ➤ Definition:
Functions (methods) are reusable blocks of code in Java.

### ➤ Syntax:
returnType methodName(parameters) {
    // code
}


### ➤ Example:
public class Calculator {
    public int add(int a, int b) {
        return a + b;
    }

    public static void main(String[] args) {
        Calculator calc = new Calculator();
        System.out.println(calc.add(5, 3));  // Output: 8
    }
}


## 4. 🔐 Access Specifiers

| Specifier   | Visibility                                   |
|-------------|----------------------------------------------|
| public      | Accessible from everywhere                   |
| private     | Accessible only within the class             |
| protected   | Accessible within package and subclass       |
| default     | Accessible only within the package           |

### ➤ Example:

public class Demo {
    public String publicVar = "Public";
    protected String protectedVar = "Protected";
    private String privateVar = "Private";

    public String getPrivateVar() {
        return privateVar;
    }
}



## 5. 🧱 Object Creation

### ➤ Example:
class Car {
    void drive() {
        System.out.println("Driving...");
    }
}

public class Main {
    public static void main(String[] args) {
        Car myCar = new Car();  
        myCar.drive();          
    }
}

