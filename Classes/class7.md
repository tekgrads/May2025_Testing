# 🧬 Java Inheritance, Overriding & More (Simplified)

---

## 🔹 1. What is Inheritance?

**Inheritance** means one class can **use things** (like methods or variables) from another class.

### ✅ Example:

```java
class Animal {
    void sleep() {
        System.out.println("Sleeping...");
    }
}

class Dog extends Animal {
    void bark() {
        System.out.println("Barking...");
    }
}
Now Dog can both bark() and sleep() — it got sleep from Animal!

🐶 Think of Dog as a superhero dog that got powers from Animal (like sleep and basic actions).

🔹 2. What is Method Overriding?
Method overriding is when a child class gives its own version of a method that it got from the parent class.

✅ Example:
java
Copy
Edit
class Parent {
    void cook() {
        System.out.println("Cooking plain rice");
    }
}

class Child extends Parent {
    @Override
    void cook() {
        System.out.println("Cooking biryani!");
    }
}
🍚 The parent cooks rice, but the child turns it into biryani — party time!

🔹 3. What is Multilevel Inheritance?
When a class inherits from another class which also inherited from a third class — this is multilevel inheritance.

✅ Example:
java
Copy
Edit
class Grandpa {
    void wisdom() {
        System.out.println("Save money!");
    }
}

class Dad extends Grandpa {
    void advice() {
        System.out.println("Invest wisely!");
    }
}

class Son extends Dad {
    void hobby() {
        System.out.println("Spend on video games!");
    }
}
👨‍👦‍👦 Grandpa teaches saving, Dad teaches investing, and Son spends it all — plus has Wi-Fi.

🔹 4. Accessing Static & Non-Static Variables
✅ Example:
java
Copy
Edit
class Vehicle {
    static int wheels = 4;      // shared by all vehicles
    String fuel = "Petrol";     // each vehicle has its own fuel
}

class Car extends Vehicle {
    void show() {
        System.out.println("Wheels: " + Vehicle.wheels); // Static variable
        System.out.println("Fuel: " + fuel);             // Non-static variable
    }
}
🔌 Static variables = shared Wi-Fi
🍕 Non-static = your own snacks

🔹 5. super Keyword (Calling Parent's Stuff)
Use super when you want to:

Call the parent class constructor

Call a method from the parent class

✅ Example:
java
Copy
Edit
class Animal {
    Animal() {
        System.out.println("Animal created");
    }

    void sound() {
        System.out.println("Animal sound");
    }
}

class Dog extends Animal {
    Dog() {
        super(); // Call Animal constructor
        System.out.println("Dog created");
    }

    void sound() {
        super.sound(); // Call Animal's sound()
        System.out.println("Bark!");
    }
}
📞 super is like calling your mom to help fix things from upstairs.

