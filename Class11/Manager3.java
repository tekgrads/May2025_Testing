interface A {


    public void m1(); // abstract method

}

interface B extends A{

    
    public void m2(); // abstract method
}

class C implements B {

    public void m1() { // implementation of A's abstract method
        System.out.println("C.m1");
    }
    public void m2() { // implementation of B's abstract method
        System.out.println("C.m2");
    }   
}

public class Manager3 {

    public static void main(String[] args) {
        // A a = new A(); // Cannot instantiate interface A
        // B b = new B(); // Cannot instantiate interface B

        C c = new C();
        c.m1(); // Calls C's implementation of A's m1
        c.m2(); // Calls C's implementation of B's m2

        System.out.println("Manager2.main() completed successfully.");
    }
    
}
