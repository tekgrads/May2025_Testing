
abstract class A {
   static int x = 10; // static variable
   int y = 20; // instance variable
    abstract void m1(); // abstract method
    void m2() { // concrete method
        System.out.println("A.m2");
    }
    static void m3() { // static method
        System.out.println("A.m3");
    }
}

class B extends A {
    @Override
    void m1() { // implementation of abstract method
        System.out.println("B.m1");
    }
}



class Manager2 {
    public static void main(String[] args) {
       //A a = new A();

       System.out.println("Static variable x: " + A.x); 
       A.m3();// Accessing static variable

       B b = new B();
        b.m1();
        b.m2(); // Calls A's implementation of m2
        System.out.println("Instance variable y: " + b.y); // Accessing instance variable
    }
}