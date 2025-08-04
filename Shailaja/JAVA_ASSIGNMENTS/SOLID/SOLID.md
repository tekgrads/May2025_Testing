SOLID Design Principles
The SOLID principles are a set of five design principles intended to make software designs more understandable, flexible, and maintainable. These principles were introduced by Robert C. Martin (Uncle Bob).

1. S – Single Responsibility Principle (SRP)
Definition: A class should have only one reason to change — it should do only one job.

Why?
Reduces complexity, improves readability, and simplifies maintenance.

✅ Good Example:
class Invoice {
    void calculateTotal() { ... }
}

class InvoicePrinter {
    void print(Invoice invoice) { ... }
}

class InvoiceSaver {
    void saveToDatabase(Invoice invoice) { ... }
}
❌ Bad Example:
class Invoice {
    void calculateTotal() { ... }
    void print() { ... }
    void saveToDatabase() { ... }
}
2. O – Open/Closed Principle (OCP)
Definition: Software entities (classes, modules, functions) should be open for extension but closed for modification.

Why?
You shouldn't have to change existing code to add new behavior.

✅ Good Example (Using Interface & Inheritance):
interface Shape {
    double area();
}

class Circle implements Shape {
    public double area() { return Math.PI * r * r; }
}

class Rectangle implements Shape {
    public double area() { return length * width; }
}

class AreaCalculator {
    double calculateArea(Shape shape) {
        return shape.area();
    }
}
3. L – Liskov Substitution Principle (LSP)
Definition: Subclasses should be substitutable for their base classes without altering the correctness of the program.

Why?
Inheritance should guarantee that a subclass can stand in for its parent.

✅ Good Example:
class Bird {
    void fly() { ... }
}

class Sparrow extends Bird {
    void fly() { ... }
}
❌ Bad Example:
class Bird {
    void fly() { ... }
}

class Ostrich extends Bird {
    void fly() {
        throw new UnsupportedOperationException(); // Ostrich can't fly
    }
}
Fix: Create a FlyingBird subclass and use it only where flying birds are expected.

4. I – Interface Segregation Principle (ISP)
Definition: Clients should not be forced to depend on interfaces they do not use.

Why?
Fewer responsibilities per interface makes implementation easier and cleaner.

✅ Good Example:
interface Workable {
    void work();
}

interface Feedable {
    void eat();
}

class Robot implements Workable {
    public void work() { ... }
}

class Human implements Workable, Feedable {
    public void work() { ... }
    public void eat() { ... }
}
5. D – Dependency Inversion Principle (DIP)
Definition:

High-level modules should not depend on low-level modules. Both should depend on abstractions.
Abstractions should not depend on details. Details should depend on abstractions.
Why?
Improves modularity and allows swapping components with minimal changes.

✅ Good Example:
interface Keyboard {
    void input();
}

class MechanicalKeyboard implements Keyboard {
    public void input() { ... }
}

class Computer {
    private Keyboard keyboard;

    Computer(Keyboard keyboard) {
        this.keyboard = keyboard;
    }
}
Use Dependency Injection (DI) to inject dependencies like Keyboard.

Summary Table
Principle	Description	Goal
SRP	One class = One responsibility	Separation of concerns
OCP	Open for extension, closed for modification	Extend without breaking code
LSP	Subtypes must be substitutable	Safe inheritance
ISP	No client should depend on unused methods	Keep interfaces small
DIP	Depend on abstractions, not concretions	Flexibility and decoupling