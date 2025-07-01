# Java - Class 6 (12/06/2025)

## 🌱 Abundant (Orphan) Objects

- **Definition**: Objects in heap memory that **do not have any valid reference in the stack memory** are called **abundant** or **orphan** objects.
- These objects become eligible for **Garbage Collection (GC)**.
- Example:
  ```java
  F f1 = new F();
  f1 = null; // now the object created by 'new F()' is an orphan.
  ```

---

## 🔁 Similar Concepts

- Just like **SIB (Static Initialization Block)**, there is also **IIB (Instance Initialization Block)**.

---

## 🧱 Constructor

- A **constructor** is a block of code that is called when an object is created.
- Its primary role is to **initialize the object**.

### ✅ Rules of Constructor

1. Constructor **name must be same as the class name**.
2. It **may or may not have parameters**.
3. If a constructor **does not have parameters**, it's called a **non-parameterized constructor**.
4. If it has parameters, it's called a **parameterized constructor**.
5. If **only a parameterized constructor** is provided, the compiler **does not generate a default (non-parameterized) constructor**.
6. Therefore, if you need both, you must **explicitly define both**.

### 💡 Syntax Example:
```java
public class F {
    int i;

    F() { // Non-parameterized constructor
        System.out.println("Non-p");
    }

    F(int x) { // Parameterized constructor
        i = x;
        System.out.println("P");
    }
}
```

---

## 🔍 The `this` Keyword

- **`this`** refers to the **current object** of the class.
- It is used to **differentiate instance variables from parameters or local variables** when they share the same name.
- **Usage Examples**:
  ```java
  public class F {
      int i;

      F(int i) {
          this.i = i; // 'this.i' refers to instance variable, 'i' is the parameter
      }
  }
  ```

### 🔁 Use Cases of `this`:
1. **Access current object variables and methods**
2. **Invoke current class constructor** using `this()` (constructor chaining)
3. **Pass the current object** as a parameter
4. **Return the current object**

---

## 🧬 The `super` Keyword

- **`super`** is used to refer to **parent (superclass) members** — variables, methods, and constructors.
- It is commonly used in **inheritance**.

### 🚀 Use Cases of `super`:
1. **Access parent class variables/methods**:
   ```java
   class A {
       int x = 10;
   }

   class B extends A {
       int x = 20;

       void display() {
           System.out.println(super.x); // Output: 10
       }
   }
   ```

2. **Call parent class constructor**:
   ```java
   class A {
       A() {
           System.out.println("Parent Constructor");
       }
   }

   class B extends A {
       B() {
           super(); // Call parent constructor
           System.out.println("Child Constructor");
       }
   }
   ```

---

## 🧠 Memory Flow Diagram (Execution Steps)

1. JVM is launched and memory is allocated.
2. `main()` method is loaded into **stack memory**.
3. Within `main()`, object `f1` is created and its constructor runs.
4. Object `f2` is created similarly.
5. Object `f3` is created.
6. After `main()` completes execution, all objects (`f1`, `f2`, `f3`) become unreachable.
7. These become **abundant/orphan objects**, and **Garbage Collector** reclaims them.

---

## 🧩 Instance Initialization Block (IIB)

- An **Instance Initialization Block (IIB)** is a block of code inside `{}` directly within a class.
- It is **executed every time a new object is created**, **before the constructor is called**.

### ✅ Example:
```java
public class Test {
    {
        System.out.println("IIB");
    }

    Test() {
        System.out.println("Non-p");
    }

    Test(int x) {
        System.out.println("P");
    }

    static {
        System.out.println("SIB");
    }

    public static void main(String[] args) {
        Test t1 = new Test();
        Test t2 = new Test(10);
        Test t3 = new Test(20);
    }
}
```

### ✅ Output:
```
SIB
IIB
Non-p
IIB
P
IIB
P
```

---

## 🔁 Polymorphism

- **Definition**: The ability to use **a single name to represent multiple forms or behaviors**.
- In Java, this is achieved via **method overloading** and **method overriding**.

---

## 🎯 Constructor Overloading

- **Definition**: Using **multiple constructors with different parameter lists** in the same class.
- This allows creating objects in different ways.

### ✅ Example:
```java
public class Example {
    Example() {
        System.out.println("Default Constructor");
    }

    Example(int a) {
        System.out.println("Parameterized Constructor with int");
    }

    Example(String s) {
        System.out.println("Parameterized Constructor with String");
    }
}
```

---

## ✅ Summary

| Concept                | Explanation |
|------------------------|-------------|
| Abundant Objects       | Objects without stack references, ready for GC |
| Constructor            | Code to initialize objects |
| `this` keyword         | Refers to current object |
| `super` keyword        | Refers to parent class members |
| IIB                    | Runs before constructor, every time object is created |
| SIB                    | Runs once when class is loaded |
| Constructor Overloading| Multiple constructors in a class with different signatures |
| Polymorphism           | Same method name with different behavior |

---
