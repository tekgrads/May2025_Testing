
# 📘 Java Concepts: Object Methods, Pass by Value, Pass by Reference, Shallow Copy

---

## 🧱 1. Object Methods

Object methods are functions defined inside a class that operate on objects (instances) of that class. They can access instance variables and perform actions specific to the object.

### Example:
```java
class Student {
    String name;
    int age;

    // Object method
    void displayInfo() {
        System.out.println("Name: " + name + ", Age: " + age);
    }
}
```

### Key Points:
- Called using an object reference: `obj.methodName();`
- Can access and modify instance variables.
- Can return values or perform actions.

---

## 🎯 2. Pass by Value in Java

Java is strictly **Pass by Value**, **not Pass by Reference**.

### What it means:
When you pass a variable to a method, Java passes **a copy of the variable's value**, not the actual variable itself.

### Two Cases:

#### ➤ Case 1: Primitive Data Types
```java
void changeValue(int x) {
    x = 50;
}
```
- Original variable remains unchanged outside the method.

#### ➤ Case 2: Object References
```java
void modifyObject(Student s) {
    s.name = "New Name";
}
```
- The reference value is copied, but both references point to the same object. So the object's content can be changed.

### Summary:
- Java always passes **copies of variables**.
- For primitives, the **value** is copied.
- For objects, the **reference (address)** is copied.

---

## 🔁 3. Pass by Reference (Not in Java)

Java **does NOT support Pass by Reference** directly.

### Clarification:
- In languages like C++, you can pass the **actual memory address**, allowing methods to modify the original variable itself.
- Java passes object **references by value**, not the object itself.

---

## 🌊 4. Shallow Copy

A **shallow copy** is a copy of an object **where the object itself is duplicated**, but **its nested objects (like arrays or other objects)** are **shared** between the original and the copy.

### Example:
```java
class Student {
    String name;
}

Student s1 = new Student();
s1.name = "Alice";

Student s2 = s1;  // Shallow copy - both point to the same object

s2.name = "Bob";  // Changes will reflect in s1 too
```

### With Clone:
```java
class Person implements Cloneable {
    String name;
    int[] scores;

    public Object clone() throws CloneNotSupportedException {
        return super.clone(); // Shallow copy
    }
}
```

### Summary:
- Copies the **object structure** but **not deeply nested objects**.
- Changes to nested objects affect both original and copied instances.

---

          |
