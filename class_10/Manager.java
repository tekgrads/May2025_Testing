 abstract class A {
    abstract void m1();

    void m2() {
        System.out.println("A.m2");
    } 
}

abstract class C {

    void m1_C() {
        System.out.println("C.m1");
    }

    void m2_C() {
        System.out.println("C.m2");
    }
}

class B extends A {

    @Override // this 
    void m1() {
       System.out.println("B.m1");
    }     
}

abstract class D extends A {

}

class Manager {
    public static void main(String[] args) {
       B b = new B();
       b.m1(); // Calls B's implementation of m1
        b.m2(); // Calls A's implementation of m
        A a = new A();
       a.m2(); // Calls A's implementation of m2

       C c = new C() ; // object cant be created for abstract class
         c.m1_C(); // Calls C's implementation of m1_C
       
    }
}