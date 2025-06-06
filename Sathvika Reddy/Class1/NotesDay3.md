
# TG Notes Day 3- 06/06/2025

---

## 1. What are Data Types in Java?

Java supports two categories of data types:

| Type        | Category      | Size           | Example                 |
|-------------|----------------|----------------|-------------------------|
| `byte`      | Primitive      | 1 byte         | `byte age = 10;`        |
| `short`     | Primitive      | 2 bytes        | `short temp = 250;`     |
| `int`       | Primitive      | 4 bytes        | `int score = 99;`       |
| `long`      | Primitive      | 8 bytes        | `long views = 100000L;` |
| `float`     | Primitive      | 4 bytes        | `float pi = 3.14f;`     |
| `double`    | Primitive      | 8 bytes        | `double gpa = 9.8;`     |
| `char`      | Primitive      | 2 bytes        | `char grade = 'A';`     |
| `boolean`   | Primitive      | 1 bit          | `boolean isCool = true;`|
| `String`    | Non-Primitive  | Varies         | `String name = "Buzz";` |

🧃 **Fun Example:**
```java
int bananas = 6;
double price = 19.99;
String hero = "BananaMan";
```

---

## 2. Explain Object and Class in Java

- A **class** is a blueprint for creating objects.
- An **object** is an instance of a class.

🍕 **Fun Analogy:**  
A **class** is like a Pizza Recipe, and an **object** is the actual Pizza you eat!

```java
class Pizza {
  String topping;
  void bake() {
    System.out.println("Baking " + topping + " pizza!");
  }
}

public class Main {
  public static void main(String[] args) {
    Pizza p1 = new Pizza();  // Object
    p1.topping = "Cheese";
    p1.bake();  // Output: Baking Cheese pizza!
  }
}
```

---

## 3. Functions and Methods in Java

In Java:
- **Methods** are functions defined inside classes.
- They take **arguments**, perform tasks, and can return values.

🎮 **Fun Analogy:**  
Think of methods like vending machines — you insert input (arguments), and get something back!

```java
// greet(name)
void greet(name) {
  System.out.println("Hello " + name);
}

// add(a, b)
int add(a, b) {
  return a + b;
}
```

---

## 4. Access Specifiers in Java

Access specifiers control the **visibility** of classes, methods, and variables.

| Specifier     | Access Level              | Fun Analogy                                |
|---------------|---------------------------|---------------------------------------------|
| `public`      | Everywhere                | Like a public park 🏞️                      |
| `private`     | Only inside the class     | Like your secret snack drawer 🍫            |
| `protected`   | Package + subclasses      | Like your family Netflix account 🎬         |
| *default*     | Package only              | Like your school canteen 🏫                 |

---

## 5. Object Creation Using `new` for Student Class

🎓 Here's how to create a Student object using the `new` keyword:

```java
class Student {
  String studentName;
  int Id;
  char Grade;
  int Rank;
  String schoolName;
}

public class Main {
  public static void main(String[] args) {
    Student s1 = new Student();
    s1.studentName = "Sathvika Reddy";
    s1.Id = 101;
    s1.Grade = 'A';
    s1.Rank = 1;
    s1.schoolName = "Sage High School";

    System.out.println(s1.studentName + " | " + s1.schoolName);
  }
}
```

🧑‍🏫 **Output:** `Sathvika Reddy | Sage High School`


