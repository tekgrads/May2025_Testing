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
        // A a = new A();
        // a.m1();
        // a.m2();

        // B b = new B();
        // b.m1(); // Calls B's implementation of m1
        // b.m2(); // Calls A's implementation of m2
        // b.m3(); // Calls B's implementation of m3

        A a = new A(); // Upcasting
        a.m1();
        a.m2();
        //a.m3(); // Calls A's implementation of m2, but B's m3 is not accessible through A reference

        A a1 = new B(); // Upcasting
        a1.m1();
        a1.m2();
        //a1.m3(); 

        A a2 = new C(); // Upcasting
        a2.m1();
        a2.m2();
        //a2.m3(); 

        B b = new B(); // Downcasting
        b.m1(); // Calls B's implementation of m1
        b.m2(); // Calls A's implementation of m2
        b.m3(); // Calls B's implementation of m3  
        
          A a3=null;// Upcasting
        a3.m1();
        a3.m2();
        //a2.m3(); 


        System.out.println("Manager2.main() completed successfully.");
    }

}
