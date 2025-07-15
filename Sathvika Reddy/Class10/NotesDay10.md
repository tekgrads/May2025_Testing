
### Java: Abstract Classes and Interfaces:

---

##  What is an Abstract Class?

An **abstract class** in Java is a class that is declared with the `abstract` keyword and **cannot be instantiated directly**. It can contain both **abstract methods** (methods without a body) and **concrete methods** (methods with implementation). Abstract classes are mainly used to provide a **common base** for subclasses, allowing the developer to define some **shared behavior** while also enforcing certain methods that subclasses must implement. Abstract classes can also have constructors, static methods, instance variables, and access modifiers like `private`, `protected`, and `public`.

---

##  What is an Interface?

An **interface** in Java is a reference type used to define a **contract or set of rules** that a class must follow. All methods in an interface are **implicitly public and abstract** (unless default or static from Java 8 onwards). Interfaces **cannot have constructors**, and they **cannot hold instance variables**, only `public static final` constants. A class implements an interface using the `implements` keyword and must provide concrete implementations for all its methods. Interfaces support **multiple inheritance**, making them ideal when a class needs to adhere to multiple behaviors or functionalities.

---

##  Key Differences Between Abstract Class and Interface

An abstract class can have a mix of abstract and concrete methods, while an interface (prior to Java 8) only has abstract methods. Abstract classes are used when classes share a common structure or behavior, but not everything is defined yet. Interfaces are used when unrelated classes need to implement the same set of methods, ensuring a consistent API. A class can **extend only one abstract class**, but it can **implement multiple interfaces**, allowing for more flexible code design.

---

# Java Code Examples

---

##  Manager.java

```java
abstract class A {
    abstract void m1();

    void m2() {
        System.out.println("A.m2");
    }
}

abstract class C {
    void m1_C() {
        System.out.println("C.m1");
    }

    void m2_C() {
        System.out.println("C.m2");
    }
}

class B extends A {
    @Override
    void m1() {
        System.out.println("B.m1");
    }
}

abstract class D extends A {
    // Abstract subclass without implementation
}

public class Manager {
    public static void main(String[] args) {
        B b = new B();
        b.m1(); // Calls B's implementation of m1
        b.m2(); // Calls A's implementation of m2
    }
}
````

---

##  Manager2.java

```java
abstract class A2 {
    static int x = 10;      // static variable
    int y = 20;             // instance variable

    abstract void m1();     // abstract method

    void m2() {             // concrete method
        System.out.println("A.m2");
    }

    static void m3() {      // static method
        System.out.println("A.m3");
    }
}

class Manager2 {
    public static void main(String[] args) {
        // A2 a = new A2(); // Cannot instantiate abstract class
        System.out.println("Static variable x: " + A2.x);
        A2.m3(); // Accessing static method
    }
}
```

---

##  Manager3.java

```java
abstract class A3 {
    abstract void test1();
    abstract void test2();

    void test3() {
        System.out.println("A.test3");
    }

    void test4() {
        System.out.println("A.test4");
    }
}

class B3 extends A3 {
    @Override
    void test1() {
        System.out.println("B.test1");
    }

    @Override
    void test2() {
        System.out.println("B.test2");
    }
}

public class Manager3 {
    public static void main(String[] args) {
        B3 b = new B3();
        b.test1();
        b.test2();
        b.test3();
        b.test4();
        System.out.println("Manager3.main() completed successfully.");
    }
}
```

---

##  Manager4.java

```java
abstract class A4 {
    abstract void test1();
    abstract void test2();

    void test3() {
        System.out.println("A.test3");
    }

    void test4() {
        System.out.println("A.test4");
    }
}

abstract class C4 extends A4 {
    @Override
    void test1() {
        System.out.println("C.test1");
    }
}

abstract class D4 extends A4 {
    @Override
    void test2() {
        System.out.println("D.test2");
    }
}

class E extends C4 {
    @Override
    void test2() {
        System.out.println("E.test2");
    }
}

class F extends E {
    // Inherits all implementations
}

public class Manager4 {
    public static void main(String[] args) {
        E e = new E();
        e.test1();
        e.test2();
        e.test3();
        e.test4();

        F f = new F();
        f.test1();
        f.test2();
        f.test3();
        f.test4();
    }
}
```

---

##  Interface Example (Manager5.java)

```java
interface IA {
    void test1();
    void test2();
    void test3();
}

class B4 implements IA {
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

public class Manager5 {
    public static void main(String[] args) {
        IA a = new B4();
        a.test1();
        a.test2();
        a.test3();
        System.out.println("Manager.main() completed successfully.");
    }
}
```



