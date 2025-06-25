Java Notes: Abstract Classes & Interfaces (For Interviews)
🔶 1. Abstract Classes in Java
🔹 What is an Abstract Class?
An abstract class in Java:

Is declared using the abstract keyword.

Cannot be instantiated.

Can contain:

Abstract methods (methods without body)

Concrete methods (with implementation)

Static/Instance variables & methods.

🔹 Abstract Method
Declared using abstract keyword.

No body.

Must be implemented by child class (unless the child is also abstract).

✅ Example 1: Abstract Class with One Abstract Method
java
Copy
Edit
abstract class A {
    abstract void m1();
    void m2() {
        System.out.println("method2 on abstract method");
    }
}

class B extends A {
    @Override
    void m1() {
        System.out.println("method1 is calling on subclass");
    }
}

class Main1 {
    public static void main(String[] args) {
        B b = new B();
        b.m1();
        b.m2();
    }
}
📌 Output:

csharp
Copy
Edit
method1 is calling on subclass
method2 on abstract method
✅ Example 2: Abstract Class with Multiple Methods
java
Copy
Edit
abstract class A {
    abstract void m1();
    abstract void m2();
    public void m3() {
        System.out.println("method 3 is calling on abstract");
    }
    public void m4() {
        System.out.println("method 4 is calling on abstract");
    }
}

class B extends A {
    public void m1() {
        System.out.println("method1 is calling on subclass B");
    }
    public void m2() {
        System.out.println("method 2 is calling on subclass");
    }
}
📌 Output:

pgsql
Copy
Edit
method1 is calling on subclass B
method 2 is calling on subclass
method 3 is calling on abstract
method 4 is calling on abstract
🔶 2. Interfaces in Java
🔹 Key Features
Declared with interface keyword.

All methods are implicitly public and abstract (before Java 8).

No constructor or instance fields.

Can contain constants (public static final).

Supports default and static methods (from Java 8).

A class can implement multiple interfaces.

✅ Example: Implementing Interface
java
Copy
Edit
interface A {
    void m1();
    int x = 10;
    void m2();
    void m3();
}

class B implements A {
    public void m1() {
        System.out.println("method1 on class B");
    }
    public void m2() {
        System.out.println("method2 on class B");
    }
    public void m3() {
        System.out.println("method3 on class B");
    }
}

class Main1 {
    public static void main(String[] args) {
        B b = new B();
        b.m1();
        b.m2();
        b.m3();
        System.out.println("value of x is :" + A.x);
    }
}
📌 Output:

kotlin
Copy
Edit
method1 on class B
method2 on class B
method3 on class B
value of x is :10