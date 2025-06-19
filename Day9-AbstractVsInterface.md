
#  Java: Abstract Classes, Interfaces, and Their Interaction

##  Abstract Class in Java

An **abstract class** is a class that cannot be instantiated and may contain **abstract methods** (methods without a body) and **concrete methods** (with implementation).

### Example:
```java
abstract class Animal {
    abstract void sound(); // abstract method

    void eat() {
        System.out.println("Animals eat food.");
    }
}
```

##  Interface in Java

An **interface** is a completely abstract class in older versions of Java, it can have **default** and **static** methods with implementations.

###  Example:
```java
interface Flyable {
    void fly(); // abstract method
}
```

## Using Abstract Class and Interface Together

Java allows a class (including abstract ones) to **implement interfaces**.

### Example: Abstract Class Implementing Interface

```java
interface Movable {
    void move();
}

abstract class Vehicle implements Movable {
    abstract void fuel();

    public void move() {
        System.out.println("Vehicle is moving...");
    }
}
```

### Subclass Implementing Abstract Methods

```java
class Car extends Vehicle {
    public void fuel() {
        System.out.println("Car uses petrol.");
    }
}
```

###  Execution:

```java
public class Demo {
    public static void main(String[] args) {
        Car myCar = new Car();
        myCar.move();    // from interface via abstract class
        myCar.fuel();    // implemented in subclass
    }
}
```

###  Output:

```
Vehicle is moving...
Car uses petrol.
```

##  Key Notes:

- An abstract class **can implement** an interface **partially** or **fully**.
- If not all methods are implemented, then the abstract class **must be declared abstract**.
- A concrete class (like `Car`) must implement all abstract methods inherited from both the abstract class and the interface.

---

##  Summary

| Feature                  | Abstract Class     | Interface           |
|--------------------------|--------------------|---------------------|
| Constructors             | Yes                | No                  |
| Method types             | Abstract + Concrete| Only Abstract (until Java 7), + Default/Static (Java 8+) |
| Multiple Inheritance     | Not supported      | Supported (via interfaces) |
| Inheritance              | `extends`          | `implements`        |

