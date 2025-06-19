interface A{
    int x = 10; // static variable public static final variable
    void test1(); // abstract method
    abstract void test2(); // abstract method
    public abstract void test3(); // abstract method

    // // by default members are public and abstract in interface
    // public void test4() { // concrete method
    //     System.out.println("A.test4");
    // }
}

  class B implements  A {

    @Override
    public void test1() { // implementation of abstract method
        System.out.println("B.test1");
    }

    @Override
    public void test2() { // implementation of abstract method
        System.out.println("B.test2");
    }

    @Override
    public void test3() { // implementation of abstract method
        System.out.println("B.test3");
    }

    
}

public class Manager {
    public static void main(String[] args) {
        //A a = new A();

        B b = new B();
        b.test1(); // Calls B's implementation of test1
        b.test2(); // Calls B's implementation of test2
        b.test3(); // Calls B's implementation of test3
        System.out.println("Static variable x: " + A.x); 
        
        A.x = 20; // This line will cause a compilation error because x is final
        
        System.out.println("Manager.main() completed successfully.");
    }
}

