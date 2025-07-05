
#  Abstract Classes and Interfaces in Java – Funny Animal School Edition



## 🧠 Concepts Covered:

| Concept                  | Description |
|--------------------------|-------------|
| Abstract Class           | `Animal`, `Pet` |
| Interface                | `SchoolRules` |
| Normal Methods           | `eat()`, `showAffection()` |
| Static Members           | `principalName`, `schoolTiming()` |
| Hierarchical Inheritance | `Dog` and `Cat` from `Pet` |

---

##  Code Example

```java
// Interface defining basic rules in Animal School
interface SchoolRules {
    void followDressCode(); // abstract method
    static void schoolTiming() {
        System.out.println("School opens at 8:00 AM sharp! 🕗");
    }
}

// Abstract class: Animal
abstract class Animal {
    String name;

    Animal(String name) {
        this.name = name;
    }

    abstract void makeSound(); // abstract method

    void eat() {
        System.out.println(name + " is munching snacks during break 🍪");
    }

    static String principalName = "Principal Lion 🦁";
}

// Abstract class: Pet extends Animal
abstract class Pet extends Animal {
    Pet(String name) {
        super(name);
    }

    void showAffection() {
        System.out.println(name + " is wagging tail with love ❤️");
    }
}

// Subclass 1: Dog
class Dog extends Pet implements SchoolRules {
    Dog(String name) {
        super(name);
    }

    public void makeSound() {
        System.out.println(name + " says: Woof! Woof! 🐶");
    }

    public void followDressCode() {
        System.out.println(name + " wears a shiny red collar 🎀");
    }
}

// Subclass 2: Cat
class Cat extends Pet implements SchoolRules {
    Cat(String name) {
        super(name);
    }

    public void makeSound() {
        System.out.println(name + " says: Meow! Meow! 🐱");
    }

    public void followDressCode() {
        System.out.println(name + " wears a sassy scarf 🧣");
    }
}

// Runner class
public class AnimalSchool {
    public static void main(String[] args) {
        Dog d = new Dog("Charlie");
        Cat c = new Cat("Luna");

        System.out.println("Principal: " + Animal.principalName);
        SchoolRules.schoolTiming();

        System.out.println("\n🐾 Dog Activities:");
        d.makeSound();
        d.eat();
        d.followDressCode();
        d.showAffection();

        System.out.println("\n🐾 Cat Activities:");
        c.makeSound();
        c.eat();
        c.followDressCode();
        c.showAffection();
    }
}
```




