Java Interfaces 
🔹 What is an Interface?
An interface in Java is a reference type, similar to a class, that can contain:

Constants (public static final)

Abstract methods (no body)

Default methods (from Java 8)

Static methods (from Java 8)

Private methods (from Java 9)

Interfaces are used to achieve abstraction and support multiple inheritance.

🔹 Key Rules:
Feature	Interface
Inheritance	implements keyword
Variables	Public, static, and final by default
Methods before Java 8	Only abstract methods
Methods since Java 8	default, static methods are allowed
Method implementation	Not allowed (except default/static)
Object creation	Not allowed directly
Multiple inheritance	Supported

🔹 Example Programs
🧪 1. Basic Interface Implementation
java
Copy
Edit
interface A {
    void m1();
    int x = 10;  // public static final
    void m2();
    void m3();
}

class B implements A {
    public void m1() { System.out.println("method1 on class B"); }
    public void m2() { System.out.println("method2 on class B"); }
    public void m3() { System.out.println("method3 on class B"); }
}

public class Main1 {
    public static void main(String[] args) {
        B b = new B();
        b.m1();
        b.m2();
        b.m3();
        System.out.println("value of x is :" + A.x);
    }
}
🧪 2. Multiple Interfaces
java
Copy
Edit
interface A { void m1(); void m2(); }
interface B { void m3(); void m4(); }

class C implements A, B {
    public void m1() { System.out.println("method1 on class C"); }
    public void m2() { System.out.println("method2 on class C"); }
    public void m3() { System.out.println("method3 on class C"); }
    public void m4() { System.out.println("method4 on class C"); }
}
🧪 3. Interface Extending Another Interface
java
Copy
Edit
interface A {
    void m1();
    static void m2() {
        System.out.println("static method2 on interface A");
    }
}

interface B extends A {
    void m3();
    static void m4() {
        System.out.println("static method4 on interface B");
    }
}
🧪 4. Interface Inheritance Chain
java
Copy
Edit
interface A { void m1(); void m2(); }
interface B extends A { void m3(); }

class C implements B {
    public void m1() { System.out.println("method1 on class C"); }
    public void m2() { System.out.println("method2 on class C"); }
    public void m3() { System.out.println("method3 on class C"); }
}
🧪 5. Class + Interface Combination
java
Copy
Edit
class A {
    void m1() { System.out.println("method1 on class A"); }
}

interface B { void m2(); }
interface C { void m3(); }

class D extends A implements B, C {
    public void m2() { System.out.println("method2 on class D"); }
    public void m3() { System.out.println("method3 on class D"); }
}
🎯 10 Most Asked Java Interface Interview Questions (With Answers)
1. What is the difference between an interface and an abstract class?

Interfaces can only have abstract, default, and static methods (since Java 8).

Abstract classes can have constructors and instance variables.

A class can implement multiple interfaces but only extend one abstract class.

2. Can we create an object of an interface?

No. Interfaces cannot be instantiated. They must be implemented by a class.

3. What are default and static methods in interfaces?

default: Method with implementation inside interface, used for backward compatibility.

static: Can be called using Interface name. Cannot be overridden.

4. Can a class implement multiple interfaces in Java?

Yes. Java supports multiple inheritance via interfaces.

java
Copy
Edit
class A implements B, C {
    // must implement all methods from both interfaces
}
5. What is the use of interface variables being public static final by default?

Interface variables are constants. They are shared among all implementing classes.

6. Can interfaces extend other interfaces?

Yes. An interface can extend one or more interfaces using extends.

java
Copy
Edit
interface B extends A {
    void m2();
}
7. How is method conflict handled when two interfaces have the same default method?

You must override the method in your class and resolve the ambiguity.

8. Can we override static methods from interface in implementing class?

No. Static methods are not overridden, they are hidden.

9. Can we declare constructor inside interface?

No. Interfaces cannot have constructors because they cannot be instantiated.

10. Why use interfaces if we already have abstract classes?

Interfaces provide full abstraction and multiple inheritance. They are used when you want unrelated classes to share a common contract.