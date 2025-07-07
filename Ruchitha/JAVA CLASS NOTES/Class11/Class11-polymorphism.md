
# Polymorphism in Java

**Polymorphism** means *one name, many forms*. It allows methods to perform different tasks based on the object that is invoking them.

---

## 📌 Types of Polymorphism

### ✅ Static Polymorphism (Compile-Time)

- Achieved via **method overloading**
- Decisions are made at compile time.

---

## 🔢 Example 1: Static Polymorphism

```java
class Calc {
    public int add(int a, int b) {
        return a + b;
    }

    public int add(int a, int b, int c) {
        return a + b + c;
    }

    public int add(int a, int b, int c, int d) {
        return a + b;
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

### ✅ Output:

```java
Sum of 2 numbers: 30  
Sum of 3 numbers: 60  
Sum of 4 numbers: 30
```

---

### ✅ Dynamic Polymorphism (Run-Time)

- Achieved via **method overriding**
- The call is resolved at runtime depending on the object.

---

## 🔢 Example 2: Dynamic Polymorphism

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
}

public class Manager2 {
    public static void main(String[] args) {
        A a = new A();     // Upcasting
        a.m1();
        a.m2();

        A a1 = new B();    // Upcasting
        a1.m1();
        a1.m2();

        A a2 = new C();    // Upcasting
        a2.m1();
        a2.m2();

        B b = new B();     // Direct instance
        b.m1();
        b.m2();
        b.m3();

        A a3 = null;       // Null reference
        a3.m1();
        a3.m2();

        System.out.println("Manager2.main() completed successfully.");
    }
}
```

### ✅ Output:

```java
A.m1  
A.m2  
B.m1  
A.m2  
C.m1  
A.m2  
B.m1  
A.m2  
B.m3  
Exception in thread "main" java.lang.NullPointerException
```

---

## 🧠 Summary

| Type | Description | Technique |
|------|-------------|-----------|
| Static Polymorphism | Resolved at compile time | Method Overloading |
| Dynamic Polymorphism | Resolved at runtime | Method Overriding |
