
# Java: Polymorphism:

---

##  What is Polymorphism in Java?

**Polymorphism** is one of the four core principles of Object-Oriented Programming (OOP) that means **"many forms."** It allows objects to be treated in multiple ways depending on the context, enhancing **flexibility, reusability, and scalability** in code design. Java supports two types of polymorphism:

- **Compile-Time Polymorphism** (also called Method Overloading): This happens when multiple methods in the same class have the same name but different parameters (type, number, or order). The method call is resolved at compile time based on the method signature.
  
- **Runtime Polymorphism** (also called Method Overriding): This occurs when a subclass provides a specific implementation of a method that is already defined in its superclass. The method call is resolved at runtime based on the actual object, not the reference type.

Polymorphism allows developers to **write general code** that works on objects of multiple types and lets the specific behavior be determined by the actual object at runtime.

---

# Java Program Examples

---

## Compile-Time Polymorphism (Method Overloading)

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
        System.out.println("Multiplication of 2 nos: " + a.multiply(2, 3));
        System.out.println("Multiplication of 3 nos: " + a.multiply(3, 4, 5));
        System.out.println("Multiplication of 4 nos: " + a.multiply(1, 5, 2, 4));
    }
}
````

---

##  Runtime Polymorphism (Method Overriding)

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

class Manager {
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
