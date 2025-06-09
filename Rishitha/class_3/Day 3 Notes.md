
# Java Basics - Step by Step Notes (Beginner Friendly)

---

## 📄 1. Data Types in Java
Data types specify the type of data a variable can store.

**Primitive Data Types:**
| Data Type | Meaning               | Example              |
|-----------|------------------------|----------------------|
| int       | Whole numbers          | int age = 20;        |
| float     | Decimal number (small) | float pi = 3.14f;    |
| double    | Decimal (large)        | double marks = 85.75;|
| char      | Single character       | char grade = 'A';    |
| boolean   | true or false values   | boolean pass = true; |

**Non-Primitive Data Type:**
- **String**: A sequence of characters.
  - Example: `String name = "Rishitha";`

---

## 🔐 2. Access Modifiers
They define where a variable or method can be accessed.

| Modifier | Access Level                        |
|----------|-------------------------------------|
| public   | Can be accessed from anywhere       |
| private  | Can be accessed only in that class  |

Example:
```java
public int a = 5;     // accessible anywhere
private int b = 10;   // only within the same class
```

---

## 📁 3. static vs non-static

| static                       | non-static                    |
|-----------------------------|-------------------------------|
| Belongs to class            | Belongs to object             |
| Access without object       | Requires object to access     |

Example:
```java
class Example {
    static int x = 5;   // static variable
    int y = 10;         // non-static variable
}
```

---

## ⚖️ 4. Method (Function)

Structure:
```java
returnType methodName(parameters) {
    // code
}
```

Example:
```java
int add(int a, int b) {
    return a + b;
}
```

---

## ➡️ 5. Return Type
Tells what type of value the method returns.

Example:
```java
int square(int x) {
    return x * x;
} // returns an int
```

---

## 📅 6. Arguments (Parameters)
Inputs passed to a method.

Example:
```java
void greet(String name) {
    System.out.println("Hi " + name);
}
```

---

## 🏢 7. Class and Object

**Class** is a blueprint.  
**Object** is a real instance of a class.

Example:
```java
class Student {
    String name;
    void display() {
        System.out.println(name);
    }
}

Student s = new Student();
s.name = "Rishi";
s.display();
```

---

## ❌ 8. void - Meaning
Means method does not return anything.

Example:
```java
void show() {
    System.out.println("Hello");
}
```

---

## ⭐ 9. main() Method
Starting point of any Java program.

Syntax:
```java
public static void main(String[] args) {
    // program starts here
}
```

---

## 📃 10. Command Line Arguments - args[0], args[1]...
Inputs passed from the command line.

Example:
```java
public static void main(String[] args) {
    System.out.println(args[0]);
    System.out.println(args[1]);
}
```

Run:
```bash
java A Hello Rishi
```

Output:
```
Hello
Rishi
```

---
