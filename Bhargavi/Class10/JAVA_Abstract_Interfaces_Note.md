JAVA Notes                                                                                                                                           ABSTRACT CLASSES AND INTERFACES IN JAVA
ABSTRACT CLASS
Definition:
An abstract class is a class declared with the abstract keyword.

Key Points:
Cannot be instantiated directly.
Can have abstract methods (without body) and concrete methods (with body).
A subclass must extend it and implement all abstract methods.
Can contain variables, constructors, static blocks, instance blocks, and methods.
Syntax:
abstract class Animal {
    abstract void sound();
    void eat() {
        System.out.println("This animal eats food");
    }
}
Example 1: Basic Abstract Class
abstract class A {
    abstract void m1();
    void m2() {
        System.out.println("Concrete method in abstract class");
    }
}

class B extends A {
    void m1() {
        System.out.println("Implemented m1 in subclass");
    }
}

class Main1 {
    public static void main(String[] args) {
        B b = new B();
        b.m1();
        b.m2();
    }
}
Example 2: Abstract and Normal Methods
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
    @Override
    void m1() {
        System.out.println("method1 is calling on subclass B");
    }

    @Override
    void m2() {
        System.out.println("method 2 is calling on subclass");
    }
}

class Main2 {
    public static void main(String[] args) {
        B b = new B();
        b.m1();
        b.m2();
        b.m3();
        b.m4();
    }
}
Example 3: Two Abstract Classes
abstract class A {
    abstract void m1();
    void m2() {
        System.out.println("method on class A");
    }
}

class B extends A {
    @Override
    void m1() {
        System.out.println("method1 on subclass");
    }
}

abstract class C {
    void m1_C() {
        System.out.println("Abstract method on class C");
    }
    void m2_C() {
        System.out.println("abstract method on class C");
    }
}

class D extends C {
    @Override
    void m1_C() {
        System.out.println("method1 on C class");
    }
    @Override
    void m2_C() {
        System.out.println("method 2 on c class");
    }
}

class Main3 {
    public static void main(String[] args) {
        B b = new B();
        b.m1();
        b.m2();

        D d = new D();
        d.m1_C();
        d.m2_C();
    }
}
Example 4: Static/Instance Members and Abstract Method
abstract class A {
    static int y = 10;
    int x = 20;

    abstract void m1();
    void m2() {
        System.out.println("method2 on class A");
    }
    static void m3() {
        System.out.println("method 3 on static");
    }
}

class B extends A {
    @Override
    void m1() {
        System.out.println("method1 is calling in subclass");
    }
}

class Main4 {
    public static void main(String[] args) {
        B b = new B();
        b.m1();
        b.m2();
        A.m3();

        System.out.println("The instance variable value is :" + b.x);
        System.out.println("the static variable value is :" + A.y);
    }
}
Example 5: Hierarchical Inheritance with Abstract Class
abstract class A {
    abstract void m1();
    abstract void m2();
    void m3() {
        System.out.println("method3 on abstract class");
    }
    void m4() {
        System.out.println("method4 on abstract class");
    }
}

abstract class B extends A {
    @Override
    void m1() {
        System.out.println("method1 on class B");
    }
}

abstract class C extends A {
    @Override
    void m2() {
        System.out.println("method2 on class c");
    }
}

class D extends B {
    @Override
    void m2() {
        System.out.println("method2 on class c");
    }
}

class Main5 {
    public static void main(String[] args) {
        D d = new D();
        d.m1();
        d.m2();
        d.m3();
        d.m4();
    }
}
Example 6: Alternate Hierarchical Inheritance
abstract class A {
    abstract void m1();
    abstract void m2();
    void m3() {
        System.out.println("method3 on abstract class");
    }
    void m4() {
        System.out.println("method4 on abstract class");
    }
}

abstract class B extends A {
    @Override
    void m1() {
        System.out.println("method1 on class B");
    }
}

abstract class C extends A {
    @Override
    void m2() {
        System.out.println("method2 on class c");
    }
}

class D extends C {
    @Override
    void m1() {
        System.out.println("method1 on class d");
    }
}

class E extends D {}

class Main6 {
    public static void main(String[] args) {
        E e = new E();
        e.m1();
        e.m2();
        e.m3();
        e.m4();
    }
}
INTERFACES
Definition:
Interfaces in Java help avoid multiple inheritance issues by allowing classes to implement multiple interfaces.

Key Points:
Declared using interface keyword.
Cannot be instantiated.
Cannot have constructors.
All methods are public and abstract by default.
All variables are public static final (constants).
A class implements an interface using the implements keyword.
A class can implement multiple interfaces.
From Java 8: interfaces can have default and static methods.
Syntax:
interface Animal {
    void sound();
}

class Dog implements Animal {
    public void sound() {
        System.out.println("Dog barks");
    }
}
Example: Interface Implementation
interface A {
    public abstract void m1();
    int x = 10;
    void m2(); // Implicitly abstract
    abstract void m3();
}

class B implements A {
    @Override
    public void m1() {
        System.out.println("method1 on class B");
    }
    @Override
    public void m2() {
        System.out.println("method2 on class B");
    }
    @Override
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
Example: Interface with Default Method
interface Vehicle {
    void run();

    default void fuelType() {
        System.out.println("Uses petrol or diesel");
    }
}

class Car implements Vehicle {
    public void run() {
        System.out.println("Car is running");
    }
}

class Main {
    public static void main(String[] args) {
        Car c = new Car();
        c.run();
        c.fuelType();
    }
}
