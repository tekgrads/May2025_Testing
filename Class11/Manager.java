abstract class A {

    abstract void m1(); // abstract method
    static  void m2(){
        System.out.println("A.m2");
    } // concrete static method    

    void m3() { // concrete method
        System.out.println("A.m3");
    }
}

class B extends A {
    @Override
    void m1() { // implementation of abstract method
        System.out.println("B.m1");
    }
   
    //@Override
    static  void m2(){
        System.out.println("B.m2");
    // super.m2(); // Call A's static method //this and super
    } // concrete static method
    
    @Override
    void m3() { // overriding concrete method
        System.out.println("B.m3");
    }
}


public class Manager {

    public static void main(String[] args) {
       //A a = new A(); // Upcasting

       B b = new B();
        b.m1(); // Calls B's implementation of m1
        A.m2(); // Calls A's static method m2
        B.m2();
        b.m3(); // Calls A's concrete method m3
        System.out.println("Manager.main() completed successfully.");
    }
    
}
