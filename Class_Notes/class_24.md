# Java 8 Features and Lambda Expressions

## Java 8 Key Features
1. **Lambda Expressions**
2. **Functional Interfaces**
3. **Stream API**
4. **Default and Static Methods in Interfaces**
5. **Method References**
6. **Optional Class**
7. **New Date and Time API**
8. **Nashorn JavaScript Engine**

---

## Lambda Expressions
A lambda expression is an anonymous function that provides a clear and concise way to represent a method using an expression.

### Syntax
```java
(parameters) -> expression
(parameters) -> { statements; }
```

### Lambda without Parameters
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

### Lambda with One Parameter
```java
@FunctionalInterface
interface B {
    void add(int x, int y);
}

public class Example2 {
    public static void main(String[] args) {
        B b = (x, y) 
         System.out.println(x + y + " is the result");
        b.add(50, 100);
        b.add(90, 80);
    }
}

### Lambda with Multiple Parameters
```java
BiFunction<Integer, Integer, Integer> add = (a, b) -> a + b;
System.out.println(add.apply(5, 3));
```

### Syntax Variants
```java
// With data type
(int a, int b) -> a + b

// Without data type
(a, b) -> a + b

// With block
(a, b) -> {
  int sum = a + b;
  return sum;
}
```

---

## Functional Interfaces
A functional interface has only one abstract method and can have multiple default or static methods.

### Syntax
```java
@FunctionalInterface
interface MyFunctionalInterface {
    void execute();
}
```

### Example with Lambda
```java
MyFunctionalInterface fi = () -> System.out.println("Executed via Lambda");
fi.execute();
```

---

## Functional Interface with Default and Static Methods
```java
@FunctionalInterface
interface MyInterface {
    void abstractMethod();

    default void defaultMethod() {
        System.out.println("Default Method");
    }

    static void staticMethod() {
        System.out.println("Static Method");
    }
}
```

```

---

## Inheritance in Functional Interfaces
```java
@FunctionalInterface
interface ParentInterface {
    void parentMethod();
}

@FunctionalInterface
interface ChildInterface extends ParentInterface {
    // Only one abstract method allowed
}
```

---

## Functional Interface with Parameters
```java
@FunctionalInterface
interface SumInterface {
    int sum(int a, int b);
}

SumInterface adder = (a, b) -> a + b;
System.out.println(adder.sum(4, 5));
```

---

## Functional Interface and Another Interface Using Lambda
```java
interface Printable {
    void print();
}

@FunctionalInterface
interface MessagePrinter extends Printable {
    void print();
}

MessagePrinter printer = () -> System.out.println("Hello World");
printer.print();
```


---

## Lambda vs Anonymous Inner Class

package com.tekgrads;

interface Inter1 {
    public void m1();
}

class Test1 {
    int y = 888;

    public void m2() {
        Inter1 i1 = new Inter1() {
            int y = 25;

            @Override
            public void m1() {
                System.out.println(this.x);
            }
        };
        i.m1();
    }
}

class Test2 {
    int y = 22;

    public void m2() {
        Inter1 i2 = () -> {
            int y = 25;
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

