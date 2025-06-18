# ☕ Java Notes - Class 7 (13/06/2025)

## 🧬 Java Inheritance and Method Overriding

---

## 📌 Inheritance

### 1. Definition
**Inheritance** in Java is a mechanism where one class (subclass/child) acquires the properties (fields) and behaviors (methods) of another class (superclass/parent).  
This promotes **code reuse** and supports **polymorphism**.

- **Subclass (Child)**: Inherits from another class.
- **Superclass (Parent)**: The class being inherited from.
- **Keyword Used**: `extends`

---

### 2. Benefits of Inheritance
- 🔁 **Code Reusability**: Common logic is written once and reused.
- 🎭 **Polymorphism**: Enables one interface to be used for a general class of actions.
- 🧩 **Code Modularity**: Separates common and specific behaviors.
- 🚀 **Extensibility**: Easily extend or modify existing code.

---

### 3. Types of Inheritance in Java

> Java supports these inheritance types (not multiple inheritance with classes):

#### 🔹 Single Inheritance
```java
class S {
    int i;
}

class P extends S {
    int j;
}
```

---

#### 🔹 Multilevel Inheritance
```java
class M {
    M() { System.out.println("Default constructor in class M"); }
}

class C extends M {
    C() { System.out.println("Default constructor in class C"); }
}

class G extends C {
    G() { System.out.println("Default constructor in class G"); }
}
```

---

#### 🔹 Hierarchical Inheritance
```java
class H { }

class C1 extends H { }

class C2 extends H { }

class C3 extends H { }
```

---

#### 🔹 Multiple Inheritance via Interfaces
```java
interface A { }

interface B { }

class C implements A, B { }
```

---

#### 🔹 Hybrid Inheritance via Interfaces
```java
interface X { }
interface Y { }

class Base { }

class Derived extends Base implements X, Y { }
```

---

## 🔁 Method Overriding

### 1. Definition
**Method Overriding** allows a subclass to provide a specific implementation for a method already defined in the superclass.

---

### 2. Rules for Method Overriding
- ✅ **Same Signature**: Method name, return type, and parameters must match.
- ✅ **Access Modifier**: Cannot be more restrictive than the overridden method.
- ✅ **@Override Annotation**: Optional but recommended for clarity and compiler checks.
- ✅ **Covariant Return Type**: Allowed (return type in subclass can be a subtype of the superclass's return type).

---

### 3. Example
```java
class O {
    void show() {
        System.out.println("Superclass implementation");
    }
}

class A extends O {
    @Override
    void show() {
        System.out.println("Subclass implementation");
    }
}
```

---

## 🧭 Accessing Parent Class Members

### Accessing Variables

- 🔹 **Static Variables**: Use `ClassName.variable`
- 🔹 **Non-static Variables**: Use `object.variable`

```java
class J {
    int i;
    static int j;
}

class K extends J {
    int k;
    static int l;
}
```

---

## 🧩 The `super` Keyword

### 1. Calling the Parent's Constructor
```java
class Base {
    Base() {
        System.out.println("Base constructor");
    }
}

class Derived extends Base {
    Derived() {
        super(); // Calls parent constructor
        System.out.println("Derived constructor");
    }
}
```

---

### 2. Calling Parent's Method
```java
class K {
    void display() {
        System.out.println("Display from class K");
    }
}

class L extends K {
    @Override
    void display() {
        super.display(); // Calls K's method
        System.out.println("Display from class L");
    }
}
```

---

### 3. Accessing Hidden Variables
```java
class K {
    int i = 5;
}

class L extends K {
    int i = 10;

    void display() {
        System.out.println("Parent value: " + super.i);
        System.out.println("Child value: " + i);
    }
}
```

---

## 🧾 Summary

- ✅ Inheritance enables new classes to reuse code from existing classes.
- ✅ Java supports single, multilevel, hierarchical, and hybrid inheritance.
- ✅ Method Overriding allows a subclass to modify inherited behavior.
- ✅ The `super` keyword accesses parent class methods, constructors, and fields.

---
