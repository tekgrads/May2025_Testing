SOLID Principles in Java

### 1. Introduction
**SOLID** is an acronym for five design principles that help in writing **clean, maintainable, and scalable** object-oriented code.

These principles are:
1. **S** – Single Responsibility Principle (SRP)
2. **O** – Open/Closed Principle (OCP)
3. **L** – Liskov Substitution Principle (LSP)
4. **I** – Interface Segregation Principle (ISP)
5. **D** – Dependency Inversion Principle (DIP)

---

### 2. Principles Explained

#### 2.1 Single Responsibility Principle (SRP)
**Definition:**  
A class should have **only one reason to change**, meaning it should have only **one job** or **responsibility**.

**Example (Violation):**
```java
class Invoice {
    public void calculateTotal() { /* logic */ }
    public void printInvoice() { /* logic */ }
    public void saveToDatabase() { /* logic */ }
}
Correct (SRP Applied):

class Invoice {
    public void calculateTotal() { /* logic */ }
}

class InvoicePrinter {
    public void printInvoice(Invoice invoice) { /* logic */ }
}

class InvoiceRepository {
    public void saveToDatabase(Invoice invoice) { /* logic */ }
}
2.2 Open/Closed Principle (OCP)
Definition:
A class should be open for extension but closed for modification.

Example (Violation):

class Shape {
    String type;
}

class AreaCalculator {
    public double calculateArea(Shape shape) {
        if (shape.type.equals("circle")) { /* logic */ }
        else if (shape.type.equals("square")) { /* logic */ }
        return 0;
    }
}
Correct (OCP Applied):


interface Shape {
    double area();
}

class Circle implements Shape {
    public double area() { return /* logic */; }
}

class Square implements Shape {
    public double area() { return /* logic */; }
}

class AreaCalculator {
    public double calculateArea(Shape shape) {
        return shape.area();
    }
}
2.3 Liskov Substitution Principle (LSP)
Definition:
Subclasses should be replaceable with their superclass without breaking the application.

Example (Violation):

class Bird {
    public void fly() { /* logic */ }
}

class Ostrich extends Bird {
    public void fly() {
        throw new UnsupportedOperationException("Ostrich can't fly");
    }
}
Correct (LSP Applied):


interface Bird { }

interface FlyingBird extends Bird {
    void fly();
}

class Sparrow implements FlyingBird {
    public void fly() { /* logic */ }
}

class Ostrich implements Bird { }
2.4 Interface Segregation Principle (ISP)
Definition:
No client should be forced to implement methods it doesn’t use.

Example (Violation):

interface Worker {
    void work();
    void eat();
}

class Robot implements Worker {
    public void work() { /* logic */ }
    public void eat() { /* not needed */ }
}
Correct (ISP Applied):

interface Workable {
    void work();
}

interface Eatable {
    void eat();
}

class Human implements Workable, Eatable {
    public void work() { /* logic */ }
    public void eat() { /* logic */ }
}

class Robot implements Workable {
    public void work() { /* logic */ }
}
2.5 Dependency Inversion Principle (DIP)
Definition:
High-level modules should not depend on low-level modules.
Both should depend on abstractions.

Example (Violation):

class MySQLDatabase {
    public void connect() { /* logic */ }
}

class Application {
    private MySQLDatabase db = new MySQLDatabase();
    public void start() { db.connect(); }
}
Correct (DIP Applied):

interface Database {
    void connect();
}

class MySQLDatabase implements Database {
    public void connect() { /* logic */ }
}

class MongoDBDatabase implements Database {
    public void connect() { /* logic */ }
}

class Application {
    private Database db;
    public Application(Database db) { this.db = db; }
    public void start() { db.connect(); }
}
3. Summary Table
Principle	Definition
SRP	A class should have only one responsibility.
OCP	Open for extension, closed for modification.
LSP	Subclasses must be replaceable with their superclass without breaking functionality.
ISP	No client should be forced to depend on methods it does not use.
DIP	Depend on abstractions, not concrete implementations.