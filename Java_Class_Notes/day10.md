
# Java: Abstract Classes and Interfaces with Simple Examples 

---

##  1. Abstract Class - Basic Example

An abstract class is a class that cannot be instantiated directly. It may contain abstract methods (without body) and concrete methods. It is declared by a keyword called "abstract".

###  Code:


abstract class Animal {
    abstract void sound(); // abstract method

    void eat() { // concrete method
        System.out.println("Animals eat food");
    }
}

class Dog extends Animal {
    void sound() {
        System.out.println("Dog barks");
    }
}

public class Main {
    public static void main(String[] args) {
        Dog dog = new Dog();
        dog.sound();
        dog.eat();
    }
}
```

### Output:
```
Dog barks
Animals eat food
```

---

##  2. Abstract Class with Static and Instance Members

###  Code:


abstract class Shape {
    static String type = "2D Shape"; // static member
    int sides; // instance variable

    Shape(int sides) {
        this.sides = sides;
    }

    void displaySides() {
        System.out.println("Sides: " + sides);
    }

    abstract void draw(); // abstract method
}

class Triangle extends Shape {
    Triangle() {
        super(3);
    }

    void draw() {
        System.out.println("Drawing Triangle");
    }
}

public class Main {
    public static void main(String[] args) {
        System.out.println(Shape.type);
        Triangle t = new Triangle();
        t.displaySides();
        t.draw();
    }
}
```

###  Output:
```
2D Shape
Sides: 3
Drawing Triangle
```

---

##  3. Two Abstract Classes with Inheritance

###  Code:


abstract class Machine {
    abstract void start();
}

abstract class Vehicle extends Machine {
    abstract void drive();
}

class Car extends Vehicle {
    void start() {
        System.out.println("Car started");
    }

    void drive() {
        System.out.println("Car is driving");
    }
}

public class Main {
    public static void main(String[] args) {
        Car car = new Car();
        car.start();
        car.drive();
    }
}
```

###  Output:
```
Car started
Car is driving
```

---
##  Interfaces

An **interface** defines a contract for classes to implement. It supports full abstraction and multiple inheritance. It is declared by a keyword called "implements".
By interfaces we get 100 percent abstractness.

##  4. Interface - Simple Example

###  Code:


interface Printer {
    void print();
}

class Document implements Printer {
    public void print() {
        System.out.println("Printing document");
    }
}

public class Main {
    public static void main(String[] args) {
        Document doc = new Document();
        doc.print();
    }
}
```

###  Output:
```
Printing document
```

---

## 5. Two Interfaces Implemented in One Class

###  Code:


interface A {
    void methodA();
}

interface B {
    void methodB();
}

class MyClass implements A, B {
    public void methodA() {
        System.out.println("Method A implementation");
    }

    public void methodB() {
        System.out.println("Method B implementation");
    }
}

public class Main {
    public static void main(String[] args) {
        MyClass obj = new MyClass();
        obj.methodA();
        obj.methodB();
    }
}
```

###  Output:
```
Method A implementation
Method B implementation
```

- Abstract classes are used when partial implementation is needed.
- Interfaces are used for full abstraction and multiple inheritance.
- Abstract classes can have static/instance members and constructors.
- Interfaces cannot have constructors and all fields are `public static final` by default.


##  Abstract Class vs Interface

| Feature                | Abstract Class                     | Interface                             |
|------------------------|------------------------------------|---------------------------------------|
| Methods                | Abstract & concrete                | Abstract, static, default             |
| Constructors           | Yes                                | No                                    |
| Fields                 | Instance variables allowed         | Only static & final                   |
| Inheritance            | Single                             | Multiple                              |


