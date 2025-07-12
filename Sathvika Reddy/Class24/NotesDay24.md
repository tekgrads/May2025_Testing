
# Java 8 Features & Different Ways of Using Interfaces

## 1. Java 8 Features

### a. Lambda Expressions

```java
interface Sayable {
    void say();
}

public class LambdaExample {
    public static void main(String[] args) {
        Sayable s = () -> System.out.println("Hello using Lambda!");
        s.say();
    }
}
```

### b. Functional Interfaces

```java
@FunctionalInterface
interface Greet {
    void greet(String name);
}

public class FunctionalInterfaceExample {
    public static void main(String[] args) {
        Greet g = (name) -> System.out.println("Hi " + name);
        g.greet("Alice");
    }
}
```

### c. Default Methods in Interfaces

```java
interface Car {
    default void start() {
        System.out.println("Car is starting");
    }
}

class Honda implements Car {
    // inherits default start()
}

public class DefaultMethodDemo {
    public static void main(String[] args) {
        Honda h = new Honda();
        h.start();
    }
}
```

### d. Static Methods in Interfaces

```java
interface MathUtil {
    static int square(int x) {
        return x * x;
    }
}

public class StaticMethodDemo {
    public static void main(String[] args) {
        System.out.println(MathUtil.square(5));
    }
}
```

### e. Stream API

```java
import java.util.Arrays;
import java.util.List;

public class StreamDemo {
    public static void main(String[] args) {
        List<String> names = Arrays.asList("Ram", "Shyam", "Geeta");
        names.stream()
             .filter(name -> name.startsWith("S"))
             .forEach(System.out::println);
    }
}
```

---

## 2. Different Ways of Using Interfaces

### a. Using Interface with a Concrete Class

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

### b. Using Interface with Anonymous Class

```java
interface Greeting {
    void sayHello();
}

public class AnonymousDemo {
    public static void main(String[] args) {
        Greeting g = new Greeting() {
            public void sayHello() {
                System.out.println("Hello from anonymous class");
            }
        };
        g.sayHello();
    }
}
```

### c. Using Interface with Lambda Expression (Functional Interface Only)

```java
interface Calculator {
    int add(int a, int b);
}

public class LambdaCalc {
    public static void main(String[] args) {
        Calculator c = (a, b) -> a + b;
        System.out.println("Sum: " + c.add(3, 4));
    }
}
```

### d. Interface with Default & Static Methods

```java
interface Mobile {
    default void call() {
        System.out.println("Calling...");
    }

    static void message() {
        System.out.println("Messaging...");
    }
}

class Smartphone implements Mobile {}

public class InterfaceDemo {
    public static void main(String[] args) {
        Smartphone s = new Smartphone();
        s.call();
        Mobile.message();
    }
}
```

