
#Java Notes - Day 3 (06-06-2025)

## 1. Data Types

Data types specify the kind of data a variable can hold.

### Common Data Types in Java

| Type     | Category       | Size     | Example                    |
|----------|----------------|----------|----------------------------|
| byte     | Primitive      | 1 byte   | `byte books = 5;`          |
| short    | Primitive      | 2 bytes  | `short pages = 1200;`      |
| int      | Primitive      | 4 bytes  | `int marks = 88;`          |
| long     | Primitive      | 8 bytes  | `long distance = 123456L;` |
| float    | Primitive      | 4 bytes  | `float temp = 36.6f;`      |
| double   | Primitive      | 8 bytes  | `double speed = 123.45;`   |
| char     | Primitive      | 2 bytes  | `char grade = 'B';`        |
| boolean  | Primitive      | 1 bit    | `boolean passed = false;`  |
| String   | Non-Primitive  | Varies   | `String city = "Hyderabad";` |

### Fun Example

```java
int apples = 12;
double cost = 49.99;
String superhero = "AppleMan";


## 2. Explain Object and Class in Java

* A **class** is a blueprint for creating objects.
* An **object** is an instance of a class.

### Fun Analogy

> A class is like a **Recipe Book**, and an object is the **Dish** you prepare!

### Code Example

```java
class IceCream {
  String flavor;
  void serve() {
    System.out.println("Serving " + flavor + " ice cream!");
  }
}

public class Main {
  public static void main(String[] args) {
    IceCream myDessert = new IceCream();  // Object
    myDessert.flavor = "Chocolate";
    myDessert.serve();  // Output: Serving Chocolate ice cream!
  }
}

## 3. Functions and Methods in Java

In Java:

* Methods are functions defined inside classes.
* They take arguments, perform tasks, and can return values.

### Fun Analogy

> Methods are like **calculators** — you give input, it processes and returns a result!

### Code Example

```java
// greetUser(name)
void greetUser(String name) {
  System.out.println("Welcome, " + name + "!");
}

// multiply(a, b)
int multiply(int a, int b) {
  return a * b;
}


## 4. Access Specifiers in Java

Access specifiers control the visibility of classes, methods, and variables.

| Specifier | Access Level          | Fun Analogy                             |
| --------- | --------------------- | --------------------------------------- |
| public    | Everywhere            | Like a public library 📚                |
| private   | Only inside the class | Like your personal diary 🔐             |
| protected | Package + subclasses  | Like your shared family photo album 🖼️ |
| default   | Package only          | Like your school’s notice board 🏫      |

---

## 5. Object Creation Using `new` for Student Class

### Example

```java
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

