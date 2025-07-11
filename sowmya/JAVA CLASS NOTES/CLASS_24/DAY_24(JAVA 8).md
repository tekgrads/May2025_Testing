# Java 8 

Java 8 introduced significant improvements to the language and libraries, bringing in a more functional programming style.

---

## 🧠 Types of Programming Languages

### 1. Procedural Language

* Programs are written step-by-step using functions/methods
* Focuses on "what to do" and "how to do it"
* Uses variables, loops, and conditionals

### 2. Object-Oriented Programming (OOP)

* Programs are structured using classes and objects
* Includes:

  * **Class**: Blueprint for creating objects
  * **Object**: Instance of a class
  * **Encapsulation**: Hiding internal details
  * **Inheritance**: Reusing code via `extends`
  * **Polymorphism**: Methods with different behaviors
  * **Abstraction**: Hiding complexity and showing essentials

### 3. Scripting Language

* Used for short, automated scripts
* Examples: JavaScript, Python, Bash

---

## 🚀 Java 8 Core Features

1. Lambda Expressions
2. Functional Interfaces
3. Default & Static Methods in Interfaces
4. Predicates & Functions
5. Method References (`::`)
6. Stream API
7. Date and Time API

---

## 🔁 1. Lambda Expressions

Lambda = Anonymous (nameless) function
Useful for functional programming without boilerplate code

### Example 1: No parameters

```java
@FunctionalInterface
interface A {
    void m1();
}

public class Example1 {
    public static void main(String[] args) {
        A a = () -> System.out.println("lambda example");
        a.m1();
    }
}
```

**Output:**

```
lambda example
```

### Example 2: With parameters

```java
@FunctionalInterface
interface B {
    void add(int x, int y);
}

public class Example2 {
    public static void main(String[] args) {
        B b = (x, y) -> System.out.println(x + y + " is the result");
        b.add(10, 20);
        b.add(30, 80);
    }
}
```

**Output:**

```
30 is the result
110 is the result
```

---

🔹 Lambda expressions can:

* Have zero or more parameters
* Skip type declarations (type inference)
* Omit `{}` for single-line expressions

**Examples:**

```java
() -> System.out.println("Hi")
(a) -> System.out.println(a)
(a, b) -> a + b
```

---


# Java 8 Lambda Expression: Example 3 and Rules

## 🔹 Example 3: Lambda with One Parameter

### Traditional Java Method

```java
public String(String str) {
    return str;
}
```

### Lambda Equivalent

```java
(str) -> str
```

### Full Java Example

```java
package com.tekgrads;

@FunctionalInterface
interface C {
    public void String(String str);
}

public class Example3 {
    public static void main(String[] args) {
        C c = (str) -> System.out.println(str);
        c.String("this is using lambda expression");
    }
}
```

### Output

```
this is using lambda expression
```

---

## 📘 Lambda Expression Notes

### ✅ Syntax Variants

1. A lambda expression can have 0 or more parameters.

```java
() -> System.out.println("hii");
(int a) -> System.out.println(a);
(int a, int b) -> { return a + b; }
```

2. Type inference allows omitting data types:

```java
(a, b) -> System.out.println(a + b);
```

3. Parameters are separated by commas if more than one:

```java
(a, b) -> a * b
```

4. Use `()` if no parameters:

```java
() -> System.out.println("Hello");
```

5. For one parameter, parentheses and curly braces are optional:

```java
a -> System.out.println(a);
```

6. Use `{}` if the method body has multiple statements.

7. Lambda expressions can be invoked like regular methods:

```java
MyInterface ref = (a) -> System.out.println(a);
ref.myMethod(10);
```

---




## Functional Interfaces 


An **interface** that contains a **Single Abstract Method (SAM)** is called a **Functional Interface**.

---

## Examples of Functional Interfaces

* `Runnable` – contains `run()` method
* `Comparable` – contains `compareTo()` method
* `Comparator` – contains `compare()` method
* `ActionListener` – contains `actionPerformed()` method
* `Callable` – contains `call()` method

---

## Additional Methods in Functional Interfaces

In addition to the Single Abstract Method (SAM), a functional interface can also contain any number of:

* `default` methods
* `static` methods

---

## Syntax Example

```java
interface Interf1 {
    void m1(); // SAM

    default void m2() {
        System.out.println("Hi");
    }
}
```

---

## Example 4: Functional Interface with Default and Static Methods

```java
package com.tekgrads;

@FunctionalInterface
interface D {
    void m1();

    default void m2() {
        System.out.println("this is a default method on functional interface");
    }

    static void m3() {
        System.out.println("this is a static method on functional interface");
    }
}

public class Example4 {
    public static void main(String[] args) {
        D d = () -> System.out.println("this is an abstract method");
        d.m1();
        d.m2();
        D.m3(); // static method accessed via interface name
    }
}
```

### Output

```
this is an abstract method  
this is a default method on functional interface  
this is a static method on functional interface
```

---

## Note: @FunctionalInterface

* The annotation `@FunctionalInterface` is optional, but recommended.
* If the interface has more than one abstract method, the compiler will throw an error.

---

## Inheritance in Functional Interfaces

If a child interface is created from a functional interface, it must **not declare new abstract methods** unless:

* It inherits the same abstract method as the parent.

### Valid Example

```java
@FunctionalInterface
interface A {
    void m1();
}

@FunctionalInterface
interface B extends A {
    void m1(); // same method as parent
}
```

---

## Example 5: Functional Interface with Parameters

```java
package com.tekgrads;

@FunctionalInterface
interface E {
    void m1(int a);
}

@FunctionalInterface
interface F extends E {
    void m1(int a); // must be same as in E
}

public class Example5 {
    public static void main(String[] args) {
        F f = (a) -> System.out.println("value of a is " + a);
        E e = (a) -> System.out.println("value of a is " + a);

        e.m1(10);
        f.m1(20);
    }
}
```

### Output

```
value of a is 10  
value of a is 20
```

---





## Inheritance Rules for Functional Interfaces

### ✅ Valid Example

```java
@FunctionalInterface
interface A {
    public void m1();
}

@FunctionalInterface
interface B extends A {
    public void m1();
}
```

> ✅ The above code will execute because even though B extends A, the method name `m1()` is the same.

---

### ❌ Invalid Example

```java
@FunctionalInterface
interface A {
    public void m1();
}

@FunctionalInterface
interface B extends A {
    public void m2();
}
```

> ❌ This code will NOT compile. It results in **two abstract methods** (`m1()` from A and `m2()` in B), violating the **single abstract method** rule for functional interfaces.

---

## Another Inheritance Example

```java
@FunctionalInterface
interface A {
    public void m1();
}

interface B extends A {
    public void m2();
}
```

> ✅ This will compile because interface `B` is **not marked** as a functional interface.

---

## Example 6: Functional Interface with Lambda Expression

```java
package com.tekgrads;

@FunctionalInterface
interface G {
    void m1(int a);
}

interface H extends G {
    void m2(int a);
}

public class Example6 {
    public static void main(String[] args) {
        G g = (a) -> System.out.println("value of a is " + a);
        g.m1(90);

        H h = new H() {
            public void m1(int a) {
                System.out.println("a value in m1 is " + a);
            }
            public void m2(int a) {
                System.out.println("a value in m2 is " + a);
            }
        };
        h.m1(10);
        h.m2(20);
    }
}
```

### Output

```
value of a is 90
a value in m1 is 10
a value in m2 is 20
```

---

## Example 7: Functional Interface and Another Interface Using Lambda

```java
package com.tekgrads;

@FunctionalInterface
interface G {
    void m1(int a);
}

interface H {
    void m2(int x, int y);
}

public class Example6 {
    public static void main(String[] args) {
        G g = (a) -> System.out.println("value of a is " + a);
        H h = (x, y) -> System.out.println(x + y + " is the result");

        g.m1(90);
        h.m2(30, 70);
    }
}
```

### Output

```
value of a is 90
100 is the result
```

> ✅ This code works because `G` is a functional interface, while `H` is a normal interface used for lambda expression.

---

## Notes

* A **Functional Interface** can have **any number of default and static methods**.
* Type inference allows Java to automatically guess the **data type** of a variable based on the value assigned.

---





* Java 8 doesn't support multiple inheritance with classes, so we can use **interfaces**.

---

## Example 8

```java
package com.tekgrads;

interface K {
    public void m1();
}

class L implements K {
    @Override
    public void m1() {
        System.out.println("Inside m1 on L interface");
    }
}

public class Example8 {
    public static void main(String[] args) {
        L l = new L();
        l.m1();
    }
}
```

**Output:**

```
Inside m1 on L interface
```

---

## Example 9: Possible Interface and Class Combinations

```java
package com.tekgrads;

interface M {
    public void m1();
}

abstract class N {
    public abstract void m1();
}

class P {
    public void m1() {
        System.out.println("In P m1 method");
    }
}

class T extends N {
    @Override
    public void m1() {
        System.out.println("In T m1 method");
    }
}

public class Example9 {
    public static void main(String[] args) {
        M m = new M() {
            @Override
            public void m1() {
                System.out.println("Inside m1 on M");
            }
        };
        m.m1();

        N n = new T();
        n.m1();

        N n2 = new N() {
            @Override
            public void m1() {
                System.out.println("calling m1 on N interface");
            }
        };
        n2.m1();

        P n3 = new P() {
            @Override
            public void m1() {
                System.out.println("In Anonymous m1 method");
            }
        };
        n3.m1();
    }
}
```

**Output:**

```
Inside m1 on M
In T m1 method
calling m1 on N interface
In Anonymous m1 method
```

---

## Example 10: Lambda vs Anonymous Inner Class

```java
package com.tekgrads;

interface Inter1 {
    public void m1();
}

class Test1 {
    int x = 888;

    public void m2() {
        Inter1 i = new Inter1() {
            int x = 999;

            @Override
            public void m1() {
                System.out.println(this.x);
            }
        };
        i.m1();
    }
}

class Test2 {
    int x = 888;

    public void m2() {
        Inter1 i2 = () -> {
            int x = 999;
            System.out.println(this.x);
        };
        i2.m1();
    }
}

public class Example10 {
    public static void main(String[] args) {
        Test1 t1 = new Test1();
        t1.m2();

        Test2 t2 = new Test2();
        t2.m2();
    }
}
```

**Output:**

```
999
888
```

---




## Difference between Anonymous Inner Classes and Lambda Expressions

### Anonymous Inner Classes

* An **Anonymous inner class** is a class that has no name.
* Can extend concrete classes, abstract classes, or implement interfaces.
* Can implement interfaces with **multiple abstract methods**.
* Variables **can** be declared inside anonymous inner classes.
* Anonymous inner classes **can be instantiated**.
* The `this` keyword refers to the **anonymous inner class object**, not the outer class object.
* Best choice when **multiple methods** need to be handled.
* During compilation, a separate `.class` file **is generated**.
* Memory is allocated **when the object is created**.

### Lambda Expressions

* A **Lambda Expression** is a method with no name.
* Cannot extend concrete or abstract classes.
* Can implement interfaces with a **Single Abstract Method (SAM)**.
* Variables **cannot** be declared inside lambda expressions.
* Lambda expressions **cannot be instantiated**.
* The `this` keyword refers to the **outer class object**.
* Best choice when only **one abstract method (SAM)** is needed.
* During compilation, a `.class` file **is not generated**.
* Resides in the **permanent memory** of the JVM (method area).


### Advantages of Lambda Expressions

* Reduces code length
* Can be used in place of objects
* Can be passed as arguments to methods

### Notes

* Anonymous inner classes can extend concrete or abstract classes and implement interfaces
* Lambda expressions implement a **Single Abstract Method (SAM)** from a Functional Interface
* Anonymous inner classes and lambda expressions are **different concepts**

---
