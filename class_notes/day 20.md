
# 📘 Java Concepts: Object Methods, Pass by Value, Pass by Reference, Shallow Copy

---

## 🧱 1. Object Methods

Object methods are functions defined inside a class that operate on objects (instances) of that class. They can access instance variables and perform actions specific to the object.

### 🔧 Example:
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

### ✅ Key Points:
- Called using an object reference: `obj.methodName();`
- Can access and modify instance variables.
- Can return values or perform specific tasks.

---

## 🎯 2. Pass by Value in Java

Java uses **Pass by Value** for all variables.

### 📌 Meaning:
When a variable is passed to a method, a **copy of its value** is passed.

### 🔍 Two Scenarios:

#### ➤ Primitive Data Types:
```java
void changeValue(int x) {
    x = 50;
}
```
- The original variable outside the method remains unchanged.

#### ➤ Object References:
```java
void modifyObject(Student s) {
    s.name = "New Name";
}
```
- The object itself can be modified because the reference (address) is passed by value, but both references point to the same object.

---

## 🔁 3. Pass by Reference (Not in Java)

Java does **not** support **Pass by Reference**.

### ⚠️ Clarification:
- In Pass by Reference (like in C++), a method receives the actual memory address.
- In Java, only a **copy of the reference** is passed, not the actual reference.

So, Java is **Pass by Value only**, even for objects.

---

## 🌊 4. Shallow Copy

A **shallow copy** creates a new object and copies the values of all fields to it. However, if the fields are objects themselves, only their references are copied.

### 📘 Example:
```java
class Person implements Cloneable {
    String name;
    int[] scores;

    public Object clone() throws CloneNotSupportedException {
        return super.clone(); // Shallow copy
    }
}
```

### 🔎 Behavior:
- Fields with primitive types are copied.
- Fields that are references (like arrays, objects) are **not deeply copied**—they still point to the same object.


