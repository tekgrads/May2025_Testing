

## Accessing Local and Global Variables in Java

In Java, variables behave differently based on where and how they are declared.

### Local Variables
- Declared inside methods, constructors, or blocks.
- Can be used only within the scope of the method or block.

**Example:**
public void showDetails() {
    int age = 25; // Local variable
    System.out.println(age);
}


### Global Variables (Instance Variables)
- Declared inside a class but outside any method.
- Can be accessed by all non-static methods of the class.

**Example:**

public class Person {
    String name = "Alex"; // Instance variable

    public void displayName() {
        System.out.println(name); // Accessing instance variable
    }
}

## Static Initialization Block (SIB)

A static initialization block is used to initialize static variables. It runs once when the class is loaded into memory.

**Example:**

public class AppConfig {
    static int version;

    static {
        version = 2; // Static block used for initialization
        System.out.println("Static block executed");
    }
}
```

## Declaring and Accessing Static and Global Variables

- **Static variables** belong to the class, not objects.
- Can be accessed directly using the class name.

**Example:**

public class Counter {
    static int count = 0; // Static variable

    public static void showCount() {
        System.out.println(Counter.count);
    }
}


## Multiple Classes with Multiple Static Initialization Blocks

Each class can have its own static blocks, and they are executed when the class is first used.

**Example:**
class A {
    static {
        System.out.println("Static block in class A");
    }
}

class B {
    static {
        System.out.println("Static block in class B");
    }
}


When you run a program that uses both classes, both static blocks execute, depending on usage.

## Object Creation in Java

Objects are created using the `new` keyword. This allocates memory and calls the constructor.

**Example:**
Person p = new Person();

- `p` is a reference to the `Person` object.
- You can create multiple objects for the same class.

## Orphan Objects and Out of Memory Error

### Orphan Objects
An object that no longer has any reference pointing to it is called an orphan object. These are cleared by the garbage collector.

**Example:**
Person p = new Person();
p = null; // Now the object is an orphan

### Out of Memory Error
Occurs when too many objects are created and the heap space is exhausted.

**Example:**
while (true) {
    new Person(); // Creates unlimited objects
}

- This may cause `java.lang.OutOfMemoryError` if the memory is not released.

## Accessing Variables Across Classes

You can access variables from one class in another by using object references or by declaring variables as static.

**Using Object Reference:**
public class Car {
    int speed = 100;
}

public class Test {
    public static void main(String[] args) {
        Car c = new Car();
        System.out.println(c.speed); // Accessing variable from Car
    }
}

**Using Static Variable:**
public class Engine {
    static int power = 500;
}

public class Test {
    public static void main(String[] args) {
        System.out.println(Engine.power); // Access static directly
    }
}

