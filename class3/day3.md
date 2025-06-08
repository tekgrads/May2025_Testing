# Java Programming Basics

## 📌 Data Types in Java

### 🔹 Primitive Data Types

Java provides 8 built-in data types to store simple values:

| Data Type | Size     | Description                          | Example                     |
|-----------|----------|--------------------------------------|-----------------------------|
| `byte`    | 1 byte   | Whole numbers from -128 to 127       | `byte b = 100;`             |
| `short`   | 2 bytes  | Whole numbers from -32,768 to 32,767 | `short s = 20000;`          |
| `int`     | 4 bytes  | Whole numbers up to ±2 billion       | `int i = 123456;`           |
| `long`    | 8 bytes  | Larger integers                      | `long l = 12345678900L;`    |
| `float`   | 4 bytes  | Decimal numbers (single precision)   | `float f = 12.5f;`          |
| `double`  | 8 bytes  | Decimal numbers (double precision)   | `double d = 12.5;`          |
| `char`    | 2 bytes  | A single Unicode character           | `char c = 'A';`             |
| `boolean` | 1 bit    | True or false                        | `boolean b = true;`         |

### 🔹 Non-Primitive (Reference) Data Types

These are objects or references to objects:

| Type       | Description                          | Example                        |
|------------|--------------------------------------|--------------------------------|
| `String`   | A sequence of characters              | `String str = "Hello";`        |
| `Array`    | Stores multiple values of same type   | `int[] arr = {1, 2, 3};`       |
| `Class`    | User-defined structure                | `class MyClass { ... }`        |
| `Enum`     | Group of fixed constants              | `enum Day { MON, TUE, ... }`   |
| `Interface`| Contract for implementing classes     | `interface Drawable { ... }`   |

---

## 🧱 Class and Object

### ✅ Class
A **class** is a blueprint or template for creating objects. It defines variables (properties) and methods (behavior).

```java
public class Student {
    String name;
    int age;

    void printStudentDetails() {
        System.out.println("Name is " + name + ", Age is " + age);
    }
}
