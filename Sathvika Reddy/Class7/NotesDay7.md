
# Java Concepts with Examples

## 1. Inheritance
- Mechanism where one class inherits features from another.
- `class Dog extends Animal {}` — Dog gets animal powers like barking and sleeping!

## 2. Method Overriding
- Subclass redefines a parent class method.
- Example:
```java
class Parent {
    void cook() { System.out.println("Cooking plain rice"); }
}
class Child extends Parent {
    void cook() { System.out.println("Cooking biryani!"); }
}
```
- When child cooks, it's a party, not a diet!

## 3. Multilevel Inheritance
- Class inherits from a subclass of another class.
- Example:
```java
class Grandpa {
    void wisdom() { System.out.println("Save money!"); }
}
class Dad extends Grandpa {
    void advice() { System.out.println("Invest wisely!"); }
}
class Son extends Dad {
    void hobby() { System.out.println("Spend on video games!"); }
}
```
- Each generation, same advice, but more Wi-Fi.

## 4. Accessing Static and Non-Static Variables from Superclasses
```java
class Vehicle {
    static int wheels = 4;
    String fuel = "Petrol";
}
class Car extends Vehicle {
    void show() {
        System.out.println("Wheels: " + Vehicle.wheels); // Static
        System.out.println("Fuel: " + fuel); // Non-static
    }
}
```
- Static variables are like shared Wi-Fi, non-static are your personal snacks.

## 5. `super` Keyword
- Used to access superclass methods and constructors.
- Example:
```java
class Animal {
    Animal() { System.out.println("Animal created"); }
    void sound() { System.out.println("Animal sound"); }
}
class Dog extends Animal {
    Dog() {
        super();
        System.out.println("Dog created");
    }
    void sound() {
        super.sound();
        System.out.println("Bark!");
    }
}
```
- `super` is like calling your mom to handle things.

## Pros and Cons

### Pros
- Code reuse, less repetition.
- Easier maintenance and understanding.
- Clear hierarchy and better organization.

### Cons
- Tight coupling between classes.
- Can lead to complexity in multilevel setups.
- Overuse of `super` may reduce flexibility.
