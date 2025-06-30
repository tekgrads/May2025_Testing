Polymorphism
Polymorphism in Java, derived from the Greek words "poly" (many) and "morphs" (forms).        
Ploymorphism is a core concept of Object-Oriented Programming (OOP) that enables objects to take on multiple forms or exhibit different behaviors depending on the context. It allows a single action to be performed in different ways.

Polymorphism enhances code reusability, flexibility, and maintainability by allowing a single interface to be used with multiple implementations.

Types of Polymorphism in Java
1.  Static Polymorphism (Method Overloading)
Also called Compile-Time Polymorphism.
Achieved by defining multiple methods within the same class that share the same name but have different parameter lists (number, type, or order of parameters).
The compiler determines which overloaded method to call based on the arguments provided.
Example:
class Calci {
    public int add(int a, int b) {
        return a + b;
    }
    public int add(int a, int b, int c) {
        return a + b + c;
    }
}

class Main {
    public static void main(String[] args) {
        Calci c = new Calci();
        System.out.println(c.add(2, 3));
        System.out.println(c.add(1, 2, 3));
    }
}
Output:
5
6
2. Dynamic Polymorphism (Method Overriding)
Also called Run-Time Polymorphism.
Achieved when a subclass provides a specific implementation for a method that is already defined in its parent class.
The overridden method must have the same name, return type, and parameter list.
The method that gets executed is determined at runtime based on the object type.
Example:
class A {
    void show() {
        System.out.println("A class method");
    }
}
class B extends A {
    void show() {
        System.out.println("B class method");
    }
}
class Main {
    public static void main(String[] args) {
        A obj = new B();  // Upcasting
        obj.show();       // Calls B's method at runtime
    }
}
Output:
B class method
