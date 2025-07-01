# 📘 Polymorphism in Java

Polymorphism is a core concept of Object-Oriented Programming (OOP) that allows an object to behave in **multiple ways** depending on the context.

🧾 **Word Origin**:  
- "Poly" = many  
- "Morph" = forms  

So, **Polymorphism = Many Forms**

---

## 🔍 Definition
Polymorphism allows a single method name or interface to be used for different types (forms) of behavior. In Java, it enables:
- Code reusability
- Method flexibility
- Easier maintenance and readability

---

## ✅ Types of Polymorphism in Java

### 1. **Static Polymorphism** (Compile-Time Polymorphism)
- Also known as **Method Overloading**.
- Same method name but different parameter list (number, type, or order).
- Decision is made during **compile time**.
- No inheritance required.

#### 📌 Example:
```java
class Calc {
    public int add(int a, int b) {
        return a + b;
    }

    public int add(int a, int b, int c) {
        return a + b + c;
    }

    public int add(int a, int b, int c, int d) {
        return a + b; // Just adding 2 for example
    }
}

public class Manager1 {
    public static void main(String[] args) {
        Calc calc = new Calc();
        System.out.println("Sum of 2 numbers: " + calc.add(10, 20));
        System.out.println("Sum of 3 numbers: " + calc.add(10, 20, 30));
        System.out.println("Sum of 4 numbers: " + calc.add(10, 20, 30, 40));
    }
}
```

#### ✅ Output:
```
Sum of 2 numbers: 30
Sum of 3 numbers: 60
Sum of 4 numbers: 30
```

---

### 2. **Dynamic Polymorphism** (Run-Time Polymorphism)
- Also known as **Method Overriding**.
- Involves **inheritance**: Subclass overrides the parent class’s method.
- Decision is made during **runtime** based on the object type.

#### 🔁 Rules:
- Method signature must be the **same**.
- Return type should be same or covariant.
- Must involve **inheritance** (extends).

#### 📌 Example:
```java
class A {
    public void m1() {
        System.out.println("A.m1");
    }

    public void m2() {
        System.out.println("A.m2");
    }
}

class B extends A {
    @Override
    public void m1() {
        System.out.println("B.m1");
    }

    public void m3() {
        System.out.println("B.m3");
    }
}

class C extends A {
    @Override
    public void m1() {
        System.out.println("C.m1");
    }

    public void m4() {
        System.out.println("C.m4");
    }
}

public class Manager2 {
    public static void main(String[] args) {
        A a = new A();
        a.m1(); // A.m1
        a.m2(); // A.m2

        System.out.println();

        A a1 = new B(); // Upcasting
        a1.m1(); // B.m1 (runtime decision)
        a1.m2(); // A.m2

        System.out.println();

        A a2 = new C();
        a2.m1(); // C.m1
        a2.m2(); // A.m2

        System.out.println();

        B b = new B();
        b.m1();  // B.m1
        b.m3();  // B.m3

        System.out.println();

        C c = new C();
        c.m1();  // C.m1
        c.m4();  // C.m4

        System.out.println();

        A a3 = null;
        // a3.m1(); // ❌ NullPointerException
    }
}
```

#### ✅ Output:
```
A.m1
A.m2

B.m1
A.m2

C.m1
A.m2

B.m1
B.m3

C.m1
C.m4
```

---

## 📊 Summary Table: Method Overloading vs Overriding

| Feature                | Method Overloading               | Method Overriding                   |
|------------------------|----------------------------------|-------------------------------------|
| Type                   | Static Polymorphism              | Dynamic Polymorphism                |
| Binding Time           | Compile Time (Early Binding)     | Run Time (Late Binding)             |
| Method Signature       | Must be **different**            | Must be **same**                    |
| Inheritance Needed?    | ❌ No                            | ✅ Yes                              |
| Flexibility            | Less flexible                    | More flexible (runtime behavior)    |
| Return Type            | Can vary                         | Must be same (or covariant)         |

---

## 💡 Benefits of Polymorphism
- **Extensibility**: Easy to add new classes and functionality.
- **Reusability**: Same method works with different types.
- **Maintainability**: Less code changes needed.
- **Abstraction**: You can program to interfaces and abstract classes.

---

## ✅ Real-Life Analogy
A person behaves differently in different contexts:
- As a **student** in school
- As a **child** at home
- As a **customer** in a shop

Same person (object), different behaviors (methods) — this is **Polymorphism** in action.

---
