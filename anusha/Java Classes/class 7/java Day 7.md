## JAVA DAY 7

### POLYMORPHISM:

Polymorphism is one of the four fundamental OOP (Object-Oriented Programming) concepts in Java.
The word polymorphism means "many forms." In Java, polymorphism allows objects to be treated as instances of their parent class rather than their actual class. There are two types of polymorphism:

### 🧠 Types of Polymorphism:

#### 1. Compile-Time Polymorphism (Static Binding / Method Overloading):

Occurs when multiple methods have the same name but different parameters within the same class.

```java
class MathOperations {
    int add(int a, int b) {
        return a + b;
    }

    double add(double a, double b) {
        return a + b;
    }

    int add(int a, int b, int c) {
        return a + b + c;
    }
}

public class Main {
    public static void main(String[] args) {
        MathOperations obj = new MathOperations();
        System.out.println(obj.add(10, 20));
        System.out.println(obj.add(2.5, 3.5));
        System.out.println(obj.add(1, 2, 3));
    }
}
```

#### 2. Run-Time Polymorphism (Dynamic Binding / Method Overriding):

Occurs when a subclass provides a specific implementation of a method already defined in its superclass.

```java
class Animal {
    void sound() {
        System.out.println("Animal makes a sound");
    }
}

class Dog extends Animal {
    void sound() {
        System.out.println("Dog barks");
    }
}

class Cat extends Animal {
    void sound() {
        System.out.println("Cat meows");
    }
}

public class Main {
    public static void main(String[] args) {
        Animal a;
        a = new Dog();
        a.sound();

        a = new Cat();
        a.sound();
    }
}
```

### 🔁 Why Use Polymorphism?

* ✅ Improves code reusability
* ✅ Enhances flexibility and maintainability
* ✅ Supports loose coupling
* ✅ Enables dynamic method resolution

---

### ✅ Inheritance in Java

Inheritance allows one class (child/subclass) to inherit properties and methods from another (parent/superclass).

#### 🧠 Why Use Inheritance?

* ✔ Code reusability
* ✔ Reduces duplication
* ✔ Helps achieve runtime polymorphism
* ✔ Enhances maintainability

#### Syntax:

```java
class Parent {
    // parent members
}

class Child extends Parent {
    // child members
}
```

#### Memory Diagram:

```java
class A {
    int x = 10;
}

class B extends A {
    int y = 20;
}

public class Main {
    public static void main(String[] args) {
        B obj = new B();
        System.out.println(obj.x);
        System.out.println(obj.y);
    }
}
```

#### 🔍 Memory Layout:

```
         [ Stack Memory ]
    ┌────────────────┐
    │   obj         │──┐
    └───────────────┘  │
                        ▼
                [ Heap Memory ]
        ┌─────────────────────────┐
        │  Object of B           │
        │------------------------│
        │  x = 10   (from A)     │
        │  y = 20   (from B)     │
        └────────────────────────┘
```

---

### ✅ Use of `this` and `super` Keywords in Java

#### 🔹 `this` Keyword

Refers to the **current object**.

**Uses:**

1. To refer current class instance variable

```java
class Student {
    int id;
    String name;

    Student(int id, String name) {
        this.id = id;
        this.name = name;
    }

    void display() {
        System.out.println(id + " " + name);
    }
}
```

2. To call current class methods

```java
void show() {
    this.display();
}
```

3. To call current class constructor

```java
class A {
    A() {
        this(10);
        System.out.println("Default constructor");
    }

    A(int x) {
        System.out.println("Parameterized constructor: " + x);
    }
}
```

#### 🔹 `super` Keyword

Refers to the **parent class object**.

**Uses:**

1. To refer parent class variable

```java
class Animal {
    String type = "Animal";
}

class Dog extends Animal {
    String type = "Dog";

    void printType() {
        System.out.println(super.type);
    }
}
```

2. To call parent class method

```java
class Animal {
    void sound() {
        System.out.println("Animal sound");
    }
}

class Dog extends Animal {
    void sound() {
        super.sound();
        System.out.println("Dog barks");
    }
}
```

3. To call parent class constructor

```java
class Animal {
    Animal(String name) {
        System.out.println("Animal: " + name);
    }
}

class Dog extends Animal {
    Dog() {
        super("Tommy");
        System.out.println("Dog constructor");
    }
}
```

---

### 🔄 Flow of Program using `this` and `super`:

```java
class Employee {
    static {
        System.out.println("Employee SIB");
    }

    {
        System.out.println("Employee IIB");
    }

    private String name;
    private int id;

    public Employee() {
        this("Unknown", 0);
        System.out.println("Employee Default Constructor");
    }

    public Employee(String name, int id) {
        this.name = name;
        this.id = id;
        System.out.println("Employee Parameterized Constructor");
    }

    public void displayInfo() {
        System.out.println("Employee Name: " + name + ", ID: " + id);
    }
}

class Manager extends Employee {
    static {
        System.out.println("Manager SIB");
    }

    {
        System.out.println("Manager IIB");
    }

    private int teamSize;

    public Manager() {
        this("Default Manager", 100, 5);
        System.out.println("Manager Default Constructor");
    }

    public Manager(String name, int id) {
        super(name, id);
        this.teamSize = 0;
        System.out.println("Manager 2-arg Constructor");
    }

    public Manager(String name, int id, int teamSize) {
        super(name, id);
        this.teamSize = teamSize;
        System.out.println("Manager Parameterized Constructor");
    }

    @Override
    public void displayInfo() {
        super.displayInfo();
        System.out.println("Team Size: " + teamSize);
    }
}

public class Main {
    public static void main(String[] args) {
        System.out.println("Creating Manager Object:");
        Manager manager = new Manager("Anusha", 101, 8);
        manager.displayInfo();
    }
}
```

#### 📈 Output:

```
Employee SIB
Manager SIB
Creating Manager Object:
Employee IIB
Employee Parameterized Constructor
Manager IIB
Manager Parameterized Constructor
Employee Name: Anusha, ID: 101
Team Size: 8
```
