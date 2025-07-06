# Polymorphism

---

Polymorphism in Java, derived from the Greek words "poly" (many) and "morphs" (forms), is a core concept of Object-Oriented Programming (OOP) that enables objects to take on multiple forms or exhibit different behaviors depending on the context. It allows a single action to be performed in different ways.

Polymorphism enhances code reusability, flexibility, and maintainability by allowing a single interface to be used with multiple implementations.

---

## Types of Polymorphism in Java

### 1. Compile-time Polymorphism (Method Overloading)

* Also called **Static Polymorphism**.
* Achieved by defining multiple methods within the same class that share the same name but have different parameter lists (number, type, or order of parameters).
* The compiler determines which overloaded method to call based on the arguments provided.

### Example:

```java
class Calci {
    public int multiply(int a, int b) {
        return a * b;
    }

    public int multiply(int a, int b, int c) {
        return a * b * c;
    }

    public int multiply(int a, int b, int c, int d) {
        return a * b * c * d;
    }
}

class Main2 {
    public static void main(String[] args) {
        Calci a = new Calci();
        System.out.println("Multiplication of 2 numbers: " + a.multiply(9, 8));
        System.out.println("Multiplication of 3 numbers: " + a.multiply(8, 6, 4));
        System.out.println("Multiplication of 4 numbers: " + a.multiply(9, 7, 8, 5));
    }
}
```

### Output:

```
Multiplication of 2 numbers: 72
Multiplication of 3 numbers: 192
Multiplication of 4 numbers: 2520
```

---

### 2. Runtime Polymorphism (Method Overriding)

* Also called **Dynamic Polymorphism**.
* Achieved when a subclass provides a specific implementation for a method that is already defined in its parent class.
* The overridden method must have the same name, return type, and parameter list.
* The method that gets executed is determined at **runtime** based on the object type.

### Example:

```java
class A {
    public void m1() {
        System.out.println("method1 in class A");
    }

    public void m2() {
        System.out.println("method2 in class A");
    }
}

class B extends A {
    @Override
    public void m1() {
        System.out.println("method1 in class B");
    }

    public void m3() {
        System.out.println("method3 in class B");
    }
}

class C extends A {
    @Override
    public void m1() {
        System.out.println("method1 in class C");
    }

    public void m4() {
        System.out.println("method4 in class C");
    }
}

class Runtime {
    public static void main(String[] args) {
        A a = new A();
        a.m1();
        a.m2();

        System.out.println("\n");

        A a1 = new B();
        a1.m1();
        a1.m2();

        System.out.println("\n");

        A a2 = new C();
        a2.m1();
        a2.m2();

        System.out.println("\n");

        B b = new B();
        b.m1();
        b.m3();

        System.out.println("\n");

        C c = new C();
        c.m1();
        c.m4();
    }
}
```

### Output:

```
method1 in class A
method2 in class A

method1 in class B
method2 in class A

method1 in class C
method2 in class A

method1 in class B
method3 in class B

method1 in class C
method4 in class C
```

---

*This markdown is now ready for use in GitHub or any markdown-supported documentation platform.*
