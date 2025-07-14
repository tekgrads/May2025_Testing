
# Anonymous Inner Class vs Lambda Expression

## Anonymous Inner Class
An anonymous inner class is a class without a name and is used to implement an interface or extend a class on the fly.

**Use Case:** When you need to override more than one method, access local variables, or need more structure (like constructors or fields).

**Example:**
```java
interface Animal {
    void sound();
}
public class Test {
    public static void main(String[] args) {
        Animal dog = new Animal() {
            public void sound() {
                System.out.println("Bark");
            }
        };
        dog.sound();
    }
}
```

---

## Lambda Expression
A lambda expression is a concise way to represent a functional interface (an interface with only one abstract method).

**Use Case:** Used for simple implementations of functional interfaces.

**Example:**
```java
@FunctionalInterface
interface Animal {
    void sound();
}
public class Test {
    public static void main(String[] args) {
        Animal dog = () -> System.out.println("Bark");
        dog.sound();
    }
}
```

---

# Difference Between Interface and Functional Interface

## Interface
- Interface is the blueprint of a class.
- Can have any number of abstract methods.
- From Java 8, can also have **default**, **static**, and **private** methods.

## Functional Interface
- Can have **only one abstract method**.
- Can have multiple **default** or **static** methods.
- Can be annotated with `@FunctionalInterface`.

**Example:**
```java
@FunctionalInterface
interface Greeting {
    void sayHello();  // Only one abstract method
}
```

**Lambda Expression using Functional Interface:**
```java
public class Test {
    public static void main(String[] args) {
        Greeting greet = () -> System.out.println("Hello!");
        greet.sayHello();
    }
}
```
