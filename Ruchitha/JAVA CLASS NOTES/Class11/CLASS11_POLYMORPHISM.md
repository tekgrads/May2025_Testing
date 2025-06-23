
# Polymorphism in Java

Polymorphism means **one name, many forms**. It allows objects to be treated as instances of their parent class rather than their actual class.

---

## Types of Polymorphism

### ➤ Static Polymorphism (Compile Time)
Achieved through **method overloading** — multiple methods with the same name but different parameters.

### ➤ Dynamic Polymorphism (Run Time)
Achieved through **method overriding** — subclass provides a specific implementation of a method already defined in the superclass.

---

## 🔹 Example 1: Method Overloading (Static Polymorphism)


class Calc {
    public int add(int a, int b) {
        return a + b;
    }

    public int add(int a, int b, int c) {
        return a + b + c;
    }

    public int add(int a, int b, int c, int d) {
        return a + b;
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
        a.m1();
        a.m2();

        A a1 = new B(); 
        a1.m1();
        a1.m2();

        A a2 = new C(); 
        a2.m1();
        a2.m2();

        B b = new B(); 
        b.m1();
        b.m2();
        b.m3();  

        A a3 = null;
        a3.m1(); // This will throw NullPointerException
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

Summary:

Method Overloading = Static Binding (Compile Time)

Method Overriding = Dynamic Binding (Run Time)


