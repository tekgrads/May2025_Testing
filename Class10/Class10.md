## 🧩 Abstract Class in Java

An **abstract class** in Java is a class that cannot be instantiated and may contain abstract methods (methods without implementation).

### ✅ Key Points:

- It has method declarations but **no implementations** for abstract methods.
- The keyword `abstract` is used to declare both **abstract classes** and **abstract methods**.
- **Objects cannot be created** directly from an abstract class.
- A class can have **one or more abstract methods**.
- Subclasses (child classes) must provide implementations for all abstract methods.

---

### 🔧 Declaring an Abstract Class


abstract class A {
    abstract public void printName(String[] args); // Abstract method - no body
}

❗ Note: Abstract methods must not have a body.

# Java Abstract Class Example

This is a basic Java program demonstrating the use of **abstract classes**, **method overriding**, and **runtime polymorphism**.

abstract class A {
    abstract void m1();

    void m2() {
        System.out.println("A.m2");
    }
}

class B extends A {

    @override
    void m1() {
        System.out.println("B.m1");
    }
}

class Manager {

    public static void main(String[] args) {
        A a = new B();
        a.m1();
        a.m2();
    }
}

✅ Output
B.m1
A.m2

🔷 Java Program: Declaring Static Members in Abstract Class

abstract class A {
    static int x = 10;        // static variable
    int y = 20;               // instance variable

    abstract void m1();       // abstract method

    void m2() {               // concrete method
        System.out.println("A.m2");
    }

    static void m3() {        // static method
        System.out.println("A.m3");
    }
}

class B extends A {
    @Override
    void m1() {               // implementation of abstract method
        System.out.println("B.m1");
    }
}

public class Manager2 {
    public static void main(String[] args) {
        // Cannot instantiate abstract class
        // A a = new A(); // ❌ Compilation Error

        // Accessing static variable and static method
        System.out.println("Static variable x: " + A.x); 
        A.m3();  // ✅ A's static method

        // Creating instance of subclass
        B b = new B();        
        b.m1();               // B's implementation
        b.m2();               // A's concrete method
        System.out.println("Instance variable y: " + b.y); 
    }
}

✅ Output:

Static variable x: 10
A.m3
B.m1
A.m2
Instance variable y: 20

 🔷 Java Program: Abstract and Concrete Methods in Abstract Class

abstract class A {
    abstract void test1(); // abstract method
    abstract void test2(); // abstract method

    void test3() { // concrete method
        System.out.println("A.test3");
    }

    void test4() { // concrete method
        System.out.println("A.test4");
    }
}

class B extends A {
    @Override
    void test1() { // implementation of abstract method
        System.out.println("B.test1");
    }
    
    @Override
    void test2() { // implementation of abstract method
        System.out.println("B.test2");
    }
}

public class Manager3 {
    public static void main(String[] args) {
        B b = new B();
        b.test1();  // B's implementation
        b.test2();  // B's implementation
        b.test3();  // Inherited from A
        b.test4();  // Inherited from A
        System.out.println("Manager3.main() completed successfully.");
    }   
}
✅ Output:
B.test1
B.test2
A.test3
A.test4
Manager3.main() completed successfully.

🔷 Hierarchical Inheritance in Java
abstract class A {
    abstract void test1(); // abstract method
    abstract void test2(); // abstract method

    void test3() { // concrete method
        System.out.println("A.test3");
    }

    void test4() { // concrete method
        System.out.println("A.test4");
    }
}

abstract class C extends A {
    @Override
    void test1() {
        System.out.println("C.test1");
    }
}

abstract class D extends A {
    @Override
    void test2() {
        System.out.println("D.test2");
    }
}

class E extends C {
    @Override
    void test2() {
        System.out.println("E.test2");
    }
}

class F extends E {
    // Inherits all methods from E, C, and A
}

public class Manager4 {
    public static void main(String[] args) {
        E e = new E();
        e.test1(); // C.test1
        e.test2(); // E.test2
        e.test3(); // A.test3
        e.test4(); // A.test4
    }
}
✅ Output:
C.test1
E.test2
A.test3
A.test4


🔷 Interface in Java

📜 Definition:
Interfaces define a contract that implementing classes must fulfill.

All variables in interfaces are:

public static final (i.e., constants)

All methods are:

public abstract (unless marked default or static from Java 8+)

interface A {
    int x = 10; // public static final variable

    void test1();                  // public abstract by default
    abstract void test2();        // also public abstract
    public abstract void test3(); // fully declared

    // Interfaces can't have concrete methods before Java 8
    // public void test4() {
    //     System.out.println("A.test4");
    // }
}

class B implements A {

    @Override
    public void test1() {
        System.out.println("B.test1");
    }

    @Override
    public void test2() {
        System.out.println("B.test2");
    }

    @Override
    public void test3() {
        System.out.println("B.test3");
    }
}

public class Manager {
    public static void main(String[] args) {
        B b = new B();
        b.test1(); // Output: B.test1
        b.test2(); // Output: B.test2
        b.test3(); // Output: B.test3

        System.out.println("Static variable x: " + A.x); 
        
        // A.x = 20; ❌ Error: final variable cannot be reassigned

        System.out.println("Manager.main() completed successfully.");
    }
}

✅ Output:

B.test1
B.test2
B.test3
Static variable x: 10
Manager.main() completed successfully.

 Key Interface Concepts:
| Feature              | Behavior in Interface                   |
| -------------------- | --------------------------------------- |
| Variables            | `public static final` by default        |
| Methods (pre-Java 8) | `public abstract` by default            |
| Keyword Used         | `implements`                            |
| Object Creation      | Cannot instantiate an interface         |
| Multiple Inheritance | Supports multiple interface inheritance |



