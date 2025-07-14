
# Java 8 Features

## 1. Lambda Expression
Used to implement the functional Interfaces (interface with single abstract method).

**Syntax:** `(parameters) -> expression`

**Example:**
```java
interface Greeting {
    void sayHello();
}
public class LambdaExample {
    public static void main(String[] args) {
        Greeting greet = () -> System.out.println("Hello, Java 8!");
        greet.sayHello();
    }
}
```

## 2. Functional Interfaces
Functional Interfaces are interfaces with a single abstract method.

**Example:**
```java
@FunctionalInterface
interface Calculator {
    int add(int a, int b);
}
public class FunctionalInterfaceDemo {
    public static void main(String[] args) {
        Calculator calc = (a, b) -> a + b;
        System.out.println(calc.add(5, 3)); // Output: 8
    }
}
```

## 3. Default Methods in Interfaces
Interfaces can now have method implementations using the `default` keyword.

**Example:**
```java
interface MyInterface {
    default void show() {
        System.out.println("Default method in interface");
    }
}
public class DefaultMethodDemo implements MyInterface {
    public static void main(String[] args) {
        new DefaultMethodDemo().show();
    }
}
```

## 4. Static Methods in Interfaces
Interfaces can include static methods.

**Example:**
```java
interface MyInterface {
    static void display() {
        System.out.println("Static method in interface");
    }
}

public class StaticMethodDemo {
    public static void main(String[] args) {
        MyInterface.display();
    }
}
```

## 5. Stream API
Used to process collections of objects in a functional style.

**Example:**
```java
import java.util.*;
import java.util.stream.*;

public class StreamDemo {
    public static void main(String[] args) {
        List<String> names = Arrays.asList("Ram", "Sham", "John", "Alex");
        names.stream()
             .filter(n -> n.startsWith("J"))
             .forEach(System.out::println);  // Output: John
    }
}
```

## 6. Date and Time API
New package: `java.time.*`

**Example:**
```java
import java.time.LocalDate;
import java.time.LocalTime;

public class DateTimeDemo {
    public static void main(String[] args) {
        System.out.println(LocalDate.now());
        System.out.println(LocalTime.now());
    }
}
```

# Different Ways of Using Interfaces in Java

## 1. Traditional Implementation
```java
interface Animal {
    void sound();
}
class Dog implements Animal {
    public void sound() {
        System.out.println("Bark");
    }
}
```

## 2. Anonymous Class
It is declared and instantiated in a single expression, typically used when a specific class implementation is needed only once.

**Example:**
```java
Animal cat = new Animal() {
    public void sound() {
        System.out.println("Meow");
    }
};
cat.sound();
```

## 3. Multiple Interfaces
**Example:**
```java
interface A {
    void show();
}
interface B {
    void display();
}
class C implements A, B {
    public void show() {
        System.out.println("Showing A");
    }
    public void display() {
        System.out.println("Displaying B");
    }
}
```
