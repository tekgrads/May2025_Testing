
# SOLID Design Principles in OOP

**SOLID** is an acronym for five design principles in object-oriented programming that help create well-structured, maintainable, and scalable software.

---

## 1. Single Responsibility Principle (SRP)

### Definition:
A class should have only one reason to change. It should do only one job or responsibility.

### Example:
```java
class Invoice {
    void calculateTotal() {
        // logic to calculate total
    }
}

class InvoicePrinter {
    void printInvoice(Invoice invoice) {
        // logic to print invoice
    }
}
```

Each class is responsible for only one task. `Invoice` handles calculations, and `InvoicePrinter` handles printing.

---

## 2. Open/Closed Principle (OCP)

### Definition:
Software entities (classes, modules, functions) should be open for extension but closed for modification.

### Example:
```java
interface Shape {
    double area();
}

class Circle implements Shape {
    double radius;
    Circle(double r) { radius = r; }

    public double area() {
        return Math.PI * radius * radius;
    }
}

class Rectangle implements Shape {
    double length, width;
    Rectangle(double l, double w) { length = l; width = w; }

    public double area() {
        return length * width;
    }
}

class AreaCalculator {
    double totalArea(List<Shape> shapes) {
        double area = 0;
        for (Shape shape : shapes) {
            area += shape.area();
        }
        return area;
    }
}
```

New shapes can be added without changing the `AreaCalculator` class.

---

## 3. Liskov Substitution Principle (LSP)

### Definition:
Subtypes must be substitutable for their base types without altering the correctness of the program.

### Valid Example:
```java
class Bird {
    void fly() {
        System.out.println("Bird can fly");
    }
}

class Sparrow extends Bird {
    void fly() {
        System.out.println("Sparrow flies");
    }
}
```

Replacing `Bird` with `Sparrow` still works correctly.

### Violation Example:
```java
class Bird {
    void fly() {
        System.out.println("Bird can fly");
    }
}

class Ostrich extends Bird {
    void fly() {
        throw new UnsupportedOperationException("Ostriches can't fly");
    }
}
```

`Ostrich` violates LSP since it cannot behave as a `Bird`.

---

## 4. Interface Segregation Principle (ISP)

### Definition:
Clients should not be forced to depend on interfaces they do not use. Use multiple specific interfaces rather than a single general-purpose interface.

### Example:
```java
interface Printer {
    void print();
}

interface Scanner {
    void scan();
}

class MultiFunctionPrinter implements Printer, Scanner {
    public void print() {
        // print logic
    }

    public void scan() {
        // scan logic
    }
}

class SimplePrinter implements Printer {
    public void print() {
        // print logic
    }
}
```

Each class implements only the methods it actually needs.

---

## 5. Dependency Inversion Principle (DIP)

### Definition:
High-level modules should not depend on low-level modules. Both should depend on abstractions. Abstractions should not depend on details; details should depend on abstractions.

### Example:
```java
interface Keyboard {
    void input();
}

class WiredKeyboard implements Keyboard {
    public void input() {
        System.out.println("Typing from Wired Keyboard");
    }
}

class Computer {
    private Keyboard keyboard;

    Computer(Keyboard keyboard) {
        this.keyboard = keyboard;
    }

    void start() {
        keyboard.input();
    }
}
```

`Computer` depends on the `Keyboard` abstraction, not on a specific keyboard implementation.

---

## Summary Table

| Principle | Full Form                         | Responsibility                     |
|-----------|----------------------------------|------------------------------------|
| SRP       | Single Responsibility Principle  | One reason to change               |
| OCP       | Open/Closed Principle            | Open for extension, closed for modification |
| LSP       | Liskov Substitution Principle    | Subtypes must behave like base types |
| ISP       | Interface Segregation Principle  | No client should depend on unused methods |
| DIP       | Dependency Inversion Principle   | High-level modules depend on abstractions |

---
