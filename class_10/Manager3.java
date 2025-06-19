abstract class A {
    abstract void test1(); // abstract method
    abstract void test2(); // abstract method
    void test3() { // concrete method
        System.out.println("A.test3");
    }
    void test4() { // concrete method
        System.out.println("A.test4");
    }
}

class B extends A {
    @Override
    void test1() { // implementation of abstract method
        System.out.println("B.test1");
    }
    
    @Override
    void test2() { // implementation of abstract method
        System.out.println("B.test2");
    }
}


public class Manager3 {
    public static void main(String[] args) {
      B b = new B();
      b.test1();
        b.test2();
        b.test3(); // Calls A's implementation of test3
        b.test4(); // Calls A's implementation of test4 
        System.out.println("Manager3.main() completed successfully.");

    }   
}
