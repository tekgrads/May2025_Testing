
# Java Concepts: Inheritance, `super` Keyword, and Method Overriding

## 1. Inheritance

Inheritance in Java is a mechanism where one class acquires the properties and behaviors (methods) of another class. The class that inherits is called the **subclass (child)**, and the class being inherited from is called the **superclass (parent)**.

### Syntax:
```java
class Parent {
    // parent class code
}

class Child extends Parent {
    // child class code
}
```

### Example:
```java
class Animal {
    void eat() {
        System.out.println("This animal eats food");
    }
}

class Dog extends Animal {
    void bark() {
        System.out.println("The dog barks");
    }
}

public class Main {
    public static void main(String[] args) {
        Dog d = new Dog();
        d.eat();  // Inherited method
        d.bark();
    }
}
```

## 2. Types of Inheritance in Java

| Type               | Description                                | Supported in Java? |
|--------------------|--------------------------------------------|--------------------|
| Single Inheritance | One child class inherits one parent class  | ✅ Yes              |
| Multilevel         | A class inherits a class which inherits another | ✅ Yes          |
| Hierarchical       | Multiple classes inherit a single class    | ✅ Yes              |
| Multiple           | One class inherits from more than one class | ❌ Not directly (Use interfaces instead) |
| Hybrid             | Combination of above types                 | ❌ Not directly (Use interfaces)         |

### Example of Multilevel Inheritance:
```java
class Animal {
    void eat() {
        System.out.println("This animal eats food");
    }
}

class Mammal extends Animal {
    void walk() {
        System.out.println("This mammal walks");
    }
}

class Dog extends Mammal {
    void bark() {
        System.out.println("Dog barks");
    }
}
```

## 3. `super` Keyword

The `super` keyword is used to refer to the immediate parent class object. It can be used to:

- Call parent class constructor.
- Call parent class method.

### Example: Calling parent method using `super`
```java
class Animal {
    void sound() {
        System.out.println("Animal makes sound");
    }
}

class Dog extends Animal {
    void sound() {
        super.sound();  // Calls Animal's sound()
        System.out.println("Dog barks");
    }
}
```

## 4. Method Overriding

Method overriding means redefining a method of the superclass in the subclass to provide a specific implementation.

### Rules:
- Method name and parameters must be the same as in the superclass.
- There must be inheritance.
- The access level should not be more restrictive.

### Example:
```java
class Animal {
    void sound() {
        System.out.println("Animal sound");
    }
}

class Dog extends Animal {
    @Override
    void sound() {
        System.out.println("Dog barks");
    }
}

public class Main {
    public static void main(String[] args) {
        Animal obj = new Dog();
        obj.sound();  // Output: Dog barks (runtime polymorphism)
    }
}
```

## Summary
- **Inheritance** helps in code reusability.
- **`super` keyword** allows access to parent class features.
- **Method overriding** enables runtime polymorphism.
