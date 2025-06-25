Java Polymorphism – Interview Preparation Notes
🔹 What is Polymorphism?
Polymorphism means “many forms”. It allows a single interface to behave differently based on the object or input.

🧠 In Java, polymorphism enables method overloading (compile-time) and method overriding (runtime).

🔸 Types of Polymorphism in Java
1️⃣ Compile-Time Polymorphism (Method Overloading)
Also called static binding.

Multiple methods in the same class with the same name but different parameters.

Decision is made by the compiler at compile time.

✅ Example:
java
Copy
Edit
class Calci {
    public int multiply(int a, int b) {
        return a * b;
    }

    public int multiply(int a, int b, int c) {
        return a * b * c;
    }

    public int multiply(int a, int b, int c, int d) {
        return a * b * c * d;
    }
}

class Main1 {
    public static void main(String[] args) {
        Calci calc = new Calci();
        System.out.println("2 numbers: " + calc.multiply(5, 4));
        System.out.println("3 numbers: " + calc.multiply(2, 3, 4));
        System.out.println("4 numbers: " + calc.multiply(2, 3, 4, 5));
    }
}
🧾 Output:
yaml
Copy
Edit
2 numbers: 20
3 numbers: 24
4 numbers: 120
2️⃣ Runtime Polymorphism (Method Overriding)
Also called dynamic binding.

A subclass provides a specific implementation of a method defined in the superclass.

Decided by the JVM at runtime based on object type, not reference type.

✅ Example:
java
Copy
Edit
class A {
    public void m1() {
        System.out.println("method1 in class A");
    }

    public void m2() {
        System.out.println("method2 in class A");
    }
}

class B extends A {
    @Override
    public void m1() {
        System.out.println("method1 in class B");
    }

    public void m3() {
        System.out.println("method3 in class B");
    }
}

class C extends A {
    @Override
    public void m1() {
        System.out.println("method1 in class C");
    }

    public void m4() {
        System.out.println("method4 in class C");
    }
}

class Runtime {
    public static void main(String[] args) {
        A a = new A();
        A a1 = new B();  // Upcasting
        A a2 = new C();  // Upcasting
        B b = new B();
        C c = new C();

        a.m1(); a.m2();
        System.out.println();

        a1.m1(); a1.m2();  // B’s m1()
        System.out.println();

        a2.m1(); a2.m2();  // C’s m1()
        System.out.println();

        b.m1(); b.m3();
        System.out.println();

        c.m1(); c.m4();
    }
}
🧾 Output:
kotlin
Copy
Edit
method1 in class A
method2 in class A

method1 in class B
method2 in class A

method1 in class C
method2 in class A

method1 in class B
method3 in class B

method1 in class C
method4 in class C
🎯 Top 10 Java Polymorphism Interview Questions with Answers
1. What is polymorphism in Java?

Polymorphism allows one method or object to behave differently in different contexts. It supports method overloading (compile-time) and overriding (runtime).

2. What is method overloading?

Multiple methods in the same class with the same name but different parameters. It’s an example of compile-time polymorphism.

java
Copy
Edit
void show(int a)
void show(String b)
3. What is method overriding?

When a subclass provides a specific implementation of a method already defined in its superclass. It’s runtime polymorphism.

4. Can we override static methods?

❌ No. Static methods belong to the class, not to the object. So they cannot be overridden, only hidden.

5. What is the difference between overloading and overriding?

Feature	Overloading (Compile-Time)	Overriding (Runtime)
Scope	Same class	Subclass extends superclass
Parameters	Must differ	Must be same
Return Type	Can be different	Must be same
Binding	Compile-time	Runtime

6. Can we overload main() method in Java?

✅ Yes. We can overload main() but only the standard public static void main(String[] args) will be used by JVM.

7. Can a constructor be overloaded?

✅ Yes. Constructor overloading is a valid form of compile-time polymorphism.

java
Copy
Edit
class Test {
    Test() {}
    Test(int x) {}
}
8. Why is method overriding called runtime polymorphism?

Because the method to be invoked is decided at runtime depending on the object’s actual class.

9. What happens if you use super.m1() inside the child class?

It calls the parent class version of the method, bypassing the override.

10. Can we achieve runtime polymorphism with data members?

❌ No. Only methods are polymorphic. Variables are not overridden, they are hidden.