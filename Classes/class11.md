Polymorphism in Java (One Name, Many Forms)
Polymorphism allows an object to behave in multiple ways based on context.
In Java, it means the same method name can perform different tasks.

🔸 Types of Polymorphism
✅ 1. Static Polymorphism (Compile-Time)
Achieved using Method Overloading

Same method name, but different parameters

Decided during compilation

✅ 2. Dynamic Polymorphism (Run-Time)
Achieved using Method Overriding

Subclass gives its own version of a method from the parent class

Decided during runtime

🔹 Example 1: Method Overloading (Static Polymorphism)

class Calc {
    public int add(int a, int b) {
        return a + b;
    }

    public int add(int a, int b, int c) {
        return a + b + c;
    }

    public int add(int a, int b, int c, int d) {
        return a + b; // Note: Only adding two numbers here
    }
}

public class Manager1 {
    public static void main(String[] args) {
        Calc calc = new Calc();
        System.out.println("Sum of 2 numbers: " + calc.add(10, 20));
        System.out.println("Sum of 3 numbers: " + calc.add(10, 20, 30));
        System.out.println("Sum of 4 numbers: " + calc.add(10, 20, 30, 40));
    }
}
✅ Output:

Sum of 2 numbers: 30
Sum of 3 numbers: 60
Sum of 4 numbers: 30
🔹 Example 2: Method Overriding (Dynamic Polymorphism)

class A {
    public void m1() {
        System.out.println("A.m1");
    }

    public void m2() {
        System.out.println("A.m2");
    }
}

class B extends A {
    @Override
    public void m1() {
        System.out.println("B.m1");
    }

    public void m3() {
        System.out.println("B.m3");
    }
}

class C extends A {
    @Override
    public void m1() {
        System.out.println("C.m1");
    }
}

public class Manager2 {
    public static void main(String[] args) {
        A a = new A();
        a.m1();  // A.m1
        a.m2();  // A.m2

        A a1 = new B();
        a1.m1(); // B.m1 (runtime decision)
        a1.m2(); // A.m2

        A a2 = new C();
        a2.m1(); // C.m1
        a2.m2(); // A.m2

        B b = new B();
        b.m1();  // B.m1
        b.m2();  // A.m2
        b.m3();  // B.m3

        A a3 = null;
        a3.m1(); // ❌ Throws NullPointerException
    }
}
⚠️ Output:
A.m1
A.m2
B.m1
A.m2
C.m1
A.m2
B.m1
A.m2
B.m3
Exception in thread "main" java.lang.NullPointerException
🧠 Summary
Feature	Method Overloading	Method Overriding
Type	Static Polymorphism	Dynamic Polymorphism
Binding	Compile Time (Early Binding)	Run Time (Late Binding)
Method Signature	Must be different	Must be same
Inheritance Needed?	❌ No	✅ Yes
Flexibility	Less flexible	More flexible (runtime behavior)