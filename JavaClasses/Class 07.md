# Java - Class 7 (13/06/2025)

## 🧬 Inheritance

- **Definition**: Inheritance allows a class (**child class**) to acquire the properties (fields) and behaviors (methods) of another class (**parent class**).
- **Keyword Used**: `extends`
- Inheritance promotes **code reusability**.

### ✅ Example:
```java
class Employee {
    void displayInfo() {
        System.out.println("I am an Employee.");
    }
}

class Manager extends Employee {
    void manageTeam() {
        System.out.println("I manage a team.");
    }
}
```

- Here, `Manager` **inherits** `displayInfo()` method from `Employee`.

---

## 🔁 Method Overriding

- **Definition**: When a **child class defines a method with the same name, return type, and parameters** as in the parent class, it overrides the parent class method.
- This allows **runtime polymorphism** and **dynamic method dispatch**.
- Use **`@Override` annotation** to ensure you're correctly overriding a method.

### ❌ Your Original Code (Corrected and Improved):
```java
class A {
    void sound() {
        System.out.println("Parent sound");
    }
}

class B extends A {
    @Override
    void sound() {
        System.out.println("Child sound");
    }
}
```

---

## 🧭 Purpose of `this` and `super` in Inheritance

### 🔹 `this`
- Refers to the **current object** of the class.
- Used to **access instance variables and methods** of the current class.
- Can also be used to **call another constructor** within the same class.

### 🔹 `super`
- Refers to the **parent class**.
- Used to:
  - Access **parent class fields/methods**
  - Call **parent class constructor**

### ✅ Example:
```java
class A {
    int x = 10;
    A() {
        System.out.println("A's Constructor");
    }

    void show() {
        System.out.println("Parent show(): x = " + x);
    }
}

class B extends A {
    int x = 20;

    B() {
        super(); // calls A's constructor
        System.out.println("B's Constructor");
        System.out.println("super.x = " + super.x); // Access parent variable
        System.out.println("this.x = " + this.x);   // Access current class variable
    }

    void show() {
        super.show(); // call parent class method
        System.out.println("Child show(): x = " + this.x);
    }
}
```

---

## 🧱 Multilevel Inheritance

- **Definition**: When a class is derived from a child class, which is already derived from another class.
- Forms a **chain of inheritance**.

### ✅ Example:
```java
class A {
    A() {
        System.out.println("Constructor A");
    }
}

class B extends A {
    B() {
        System.out.println("Constructor B");
    }
}

class C extends B {
    C() {
        System.out.println("Constructor C");
    }
}

public class Main {
    public static void main(String[] args) {
        C obj = new C();
    }
}
```

### 🔄 Output:
```
Constructor A
Constructor B
Constructor C
```

---

## 🔥 Example with `SIB`, `IIB`, `this`, and `super`

```java
class A {
    static {
        System.out.println("SIB in A");
    }

    {
        System.out.println("IIB in A");
    }

    A() {
        System.out.println("Constructor of A");
    }

    void show() {
        System.out.println("Method in A");
    }
}

class B extends A {
    static {
        System.out.println("SIB in B");
    }

    {
        System.out.println("IIB in B");
    }

    B() {
        super(); // calls A's constructor
        System.out.println("Constructor of B");
    }

    @Override
    void show() {
        super.show(); // calling parent method
        System.out.println("Method in B");
    }
}

class C extends B {
    static {
        System.out.println("SIB in C");
    }

    {
        System.out.println("IIB in C");
    }

    C() {
        this.display(); // calling current class method using 'this'
        System.out.println("Constructor of C");
    }

    void display() {
        System.out.println("Display method in C using this");
    }
}

public class Main {
    public static void main(String[] args) {
        System.out.println("Main Started");
        C obj = new C();
        obj.show();
    }
}
```

### 🔄 Output:
```
SIB in A
SIB in B
SIB in C
Main Started
IIB in A
Constructor of A
IIB in B
Constructor of B
IIB in C
Display method in C using this
Constructor of C
Method in A
Method in B
```

---

## 📌 Summary Table

| Concept                   | Explanation |
|---------------------------|-------------|
| Inheritance               | Mechanism for one class to acquire another class’s properties |
| extends keyword           | Used to implement inheritance |
| Method Overriding         | Redefining a parent method in child class |
| `this` keyword            | Refers to current class instance |
| `super` keyword           | Refers to parent class instance |
| Multilevel Inheritance    | Inheriting from a child class which in turn inherits from another |
| SIB (Static Init Block)   | Runs once when class is loaded |
| IIB (Instance Init Block) | Runs before every constructor call |
| Constructor Chaining      | Using `this()` or `super()` to call constructors |
| Dynamic Dispatch          | Overridden method called at runtime based on object |

---
