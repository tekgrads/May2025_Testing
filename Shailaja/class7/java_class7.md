🔶 1. What is Inheritance?
Inheritance allows a class (subclass/child) to inherit fields and methods from another class (superclass/parent) using the extends keyword.

✅ Benefits:
Code Reusability

Method Overriding

Extensibility

Better Code Organization

java
Copy
Edit
class Animal {
    void sound() {
        System.out.println("Animal makes sound");
    }
}

class Dog extends Animal {
    void bark() {
        System.out.println("Dog barks");
    }
}
🔷 2. Types of Inheritance in Java
Type	Description	Java Support
Single	One subclass extends one superclass	✅ Yes
Multilevel	Inheritance chain of 3+ classes	✅ Yes
Hierarchical	Multiple classes inherit one class	✅ Yes
Multiple	One class inherits from many	❌ Classes (only via interfaces)
Hybrid	Mix of above (via interfaces)	✅ Partially

🟢 3. Method Overriding
Allows a subclass to redefine a method from its superclass.

✅ Rules:
Must be in an inheritance hierarchy

Same method signature

Same or covariant return type

Cannot reduce visibility

Use @Override annotation

java
Copy
Edit
class A {
    void display() {
        System.out.println("Superclass method");
    }
}

class B extends A {
    @Override
    void display() {
        System.out.println("Subclass method");
    }
}
🔶 4. super Keyword
Used to access parent class members:

super() → Call parent constructor (first line)

super.method() → Call overridden method

super.variable → Access parent class variable

java
Copy
Edit
class Parent {
    int x = 5;
}

class Child extends Parent {
    int x = 10;
    void print() {
        System.out.println("Child x: " + x);
        System.out.println("Parent x: " + super.x);
    }
}
🔷 5. Accessing Superclass Members
Member Type	Access Method
Static variable	ClassName.varName
Non-static variable	object.varName or super.var
Static method	ClassName.method()
Non-static method	object.method() or super.method()

🔵 6. Order of Execution (Inheritance + Blocks)
✅ Execution Order:
Superclass SIB (Static block)

Subclass SIB

Superclass IIB (Instance block)

Superclass Constructor

Subclass IIB

Subclass Constructor

✅ Top 10 Java Interview Questions & Answers
1. What is inheritance in Java?
Answer:
Inheritance is a mechanism where one class (subclass) acquires properties and behavior (methods and fields) from another class (superclass) using the extends keyword.

2. What types of inheritance does Java support?
Answer:
Java supports:

Single

Multilevel

Hierarchical

Multiple & Hybrid (via interfaces only)

3. Why doesn’t Java support multiple inheritance with classes?
Answer:
To avoid ambiguity caused by the Diamond Problem, Java doesn’t support multiple inheritance through classes. However, it allows it through interfaces.

4. What is method overriding?
Answer:
When a subclass provides its own version of a method already defined in its superclass, using the same signature, it’s called overriding.

Method must have same name, parameters, return type (or covariant), and cannot reduce visibility.

5. What is the use of the super keyword in Java?
Answer:
super is used to:

Access superclass variables/methods

Call the superclass constructor
Useful when a variable or method is overridden in the subclass.

6. What is the difference between static and non-static variables in inheritance?
Answer:

Static: Shared across all instances, accessed via ClassName.var

Non-static: Unique to each object, accessed via object or super

7. In what order do static blocks, instance blocks, and constructors execute in multilevel inheritance?
Answer:

Superclass Static Block (SIB)

Subclass Static Block (SIB)

Superclass Instance Block (IIB)

Superclass Constructor

Subclass Instance Block (IIB)

Subclass Constructor

For each level, Java completes the parent class before the child class.

8. Can we override static methods in Java?
Answer:
❌ No. Static methods are not overridden, they are hidden. Method hiding occurs if a static method in a subclass has the same signature as one in its superclass.

9. What is the difference between method overloading and overriding?
Feature	Overloading	Overriding
Parameters	Must differ	Must be the same
Inheritance	Not required	Required
Polymorphism Type	Compile-time	Runtime

10. What is covariant return type in method overriding?
Answer:
If the superclass method returns a class type, the overriding method in the subclass can return a subclass of that return type.

java
Copy
Edit
class Animal {}
class Dog extends Animal {}

class Parent {
    Animal get() { return new Animal(); }
}

class Child extends Parent {
    @Override
    Dog get() { return new Dog(); } // Covariant return
}