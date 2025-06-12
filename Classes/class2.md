# 📘 Java Basics - Easy Explanation

---

## 📌 1. Data Types  
Data types tell Java **what kind of data** a variable can store.

### 👉 a. Primitive Data Types (Built-in types)

| Type     | Description             | Example                  |
|----------|-------------------------|--------------------------|
| `int`    | Whole numbers            | `int x = 10;`            |
| `float`  | Decimal numbers          | `float y = 3.14f;`       |
| `double` | Larger decimal numbers   | `double z = 99.99;`      |
| `char`   | Single character         | `char c = 'A';`          |
| `boolean`| True or false            | `boolean flag = true;`   |
| `byte`   | Small whole number       | `byte b = 127;`          |
| `short`  | Small whole number       | `short s = 32000;`       |
| `long`   | Large whole number       | `long l = 123456789L;`   |

### 👉 b. Non-Primitive Data Types (Reference types)
- Examples: `String`, `Array`, `Class`, `Interface`, etc.
- These are not built-in but created by the programmer or Java.

---

## 📌 2. Class  
A **class** is like a **blueprint** to create objects.

### ➕ Example:
```java
class Car {
    String color;
    int speed;

    void drive() {
        System.out.println("The car is driving");
    }
}
📌 3. Object
An object is an actual item made using a class (like a real car made from the blueprint).

➕ Example:
java
Copy
Edit
public class Main {
    public static void main(String[] args) {
        Car myCar = new Car();     // Create object
        myCar.color = "Red";       // Set property
        myCar.drive();             // Call method
    }
}
📌 4. Access Modifiers
Access modifiers define who can see or use a class, method, or variable.

Modifier	Access Level
public	Accessible from anywhere
private	Only within the same class
protected	Within the same package and subclasses
(default)	Only within the same package

📌 5. public static void main(String[] args)
This is the starting point of every Java program.

✅ Breakdown:
public → Accessible by anyone (even JVM)

static → Can run without creating an object

void → Does not return any value

main → The method name the JVM looks for

String[] args → Accepts command-line arguments (text input)

➕ Example:
java
Copy
Edit
public class HelloWorld {
    public static void main(String[] args) {
        System.out.println("Hello, World!");
    }
}
✅ Summary
Data Types: Define the kind of data (e.g., int, float, String)

Class: A blueprint/template for creating objects

Object: A real instance of a class

Access Modifiers: Control visibility (public, private, etc.)

main() Method: Starting point for the Java application

