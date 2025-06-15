# Day 6: Core Java

## Inheritance

- Inheritance is one of the OOPs concepts where **one class inherits another**.
- The `extends` keyword is used for inheritance in Java.

```java
class Fruits {
    public void display() {
        System.out.println("Fruits are sweet");
    }
}

class Mango extends Fruits {
    public void display() {
        System.out.println("Mango is yellow");
    }
}

public class Demo {
    public static void main(String[] args) {
        Fruits f = new Mango();
        f.display();
    }
}

##Method Overloading
-Method Overloading allows creating multiple methods with the same name but different parameter lists.

-It increases code readability.

class Calculator {
    public int add(int a, int b) {
        return a + b;
    }

    public double add(int a, double b, float c) {
        return a + b + c;
    }

    public double add(int a, double b) {
        return a + b;
    }
}

public class Test {
    public static void main(String[] args) {
        Calculator calci = new Calculator();
        System.out.println(calci.add(1, 2));
        System.out.println(calci.add(3, 3.4, 5));
        System.out.println(calci.add(9, 3));
    }
}
##Multi-Level Inheritance
-In multi-level inheritance, a class inherits from a class that itself inherits from another class.

class Principal {
    public void show() {
        System.out.println("Principal is head of the organization");
    }
}

class HOD extends Principal {
    public void manage() {
        System.out.println("Maintains the department");
    }
}

class Staff extends HOD {
    public void teach() {
        System.out.println("Teaches the students");
    }
}

##Super Keyword
-The super keyword is used to refer to the immediate parent class object.

-It is used to access parent class methods or variables.

class Animal {
    void sound() {
        System.out.println("Animal makes sound");
    }
}

class Dog extends Animal {
    void sound() {
        super.sound(); // calls Animal's sound()
        System.out.println("Dog barks");
    }
}
##Accessing Static and Non-Static Variables from the Superclass:
class Student {
    static int rollno = 280;
    String name = "Cherry";
}

class Charitha extends Student {
    public void show() {
        System.out.println("Rollno: " + Student.rollno);
        System.out.println("Name: " + name);
    }
}



