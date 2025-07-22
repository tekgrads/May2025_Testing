Java 8: Default Methods, Static Methods, Abstract Classes, Predicates, and Functions

---

## 🔸 1. Default Methods in Interfaces

### 📘 What is it?

- Introduced in Java 8.
- Allows interfaces to have **concrete methods** (methods with body) using the `default` keyword.
- Solves the **diamond problem** in multiple inheritance.

### 🧪 Example:

```java
interface Vehicle {
    default void start() {
        System.out.println("Vehicle is starting");
    }
}
✅ Benefits:
Backward compatibility for interfaces.

Code reuse in interfaces.

🔹 2. Static Methods in Interfaces
📘 What is it?
Interfaces can have static methods (Java 8+).

These methods belong to the interface, not the implementing class.

🧪 Example:
java
Copy
Edit
interface Utility {
    static void printMessage() {
        System.out.println("Hello from static method!");
    }
}
📝 Usage:
java
Copy
Edit
Utility.printMessage();
🧱 3. Abstract Classes
📘 What is it?
An abstract class can have both abstract and concrete methods.

It cannot be instantiated directly.

Can have constructors, fields, and method definitions.

🧪 Example:
java
Copy
Edit
abstract class Animal {
    abstract void makeSound();

    void eat() {
        System.out.println("Animal is eating");
    }
}

class Dog extends Animal {
    void makeSound() {
        System.out.println("Dog barks");
    }
}
🧪 4. Predicate (java.util.function.Predicate)
📘 What is it?
A functional interface with a method that returns a boolean value.

Method: boolean test(T t)

🧪 Example:
java
Copy
Edit
import java.util.function.Predicate;

Predicate<String> isLong = str -> str.length() > 5;

System.out.println(isLong.test("Hello"));     // false
System.out.println(isLong.test("Welcome"));   // true
🧪 5. Function (java.util.function.Function)
📘 What is it?
A functional interface for mapping input to output.

Method: R apply(T t)

🧪 Example:
java
Copy
Edit
import java.util.function.Function;

Function<String, Integer> lengthFunc = str -> str.length();

System.out.println(lengthFunc.apply("Java"));  // 4
🧠 Summary Table
Feature	Purpose	Keyword/Interface
Default Method	Provide default implementation in interfaces	default keyword
Static Method	Static utility method in interface	static keyword
Abstract Class	Base class with abstract and concrete methods	abstract keyword
Predicate	Returns true/false based on input	Predicate<T>
Function	Transforms input into output	Function<T, R>