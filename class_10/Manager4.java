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

abstract class C extends A {
    @Override
    void test1() { // implementation of abstract method
        System.out.println("C.test1");
    }
    
}

 abstract class D extends A {
    @Override
    void test2() { // implementation of abstract method
        System.out.println("D.test2");
    }
}

 class E extends C {
    @Override
    void test2() { // implementation of abstract method
        System.out.println("E.test2");
    }
}

class F extends E {

}




public class Manager4 {
    public static void main(String[] args) {
        //A a = new A();
        //C c = new C(); // E extends C, which extends A
        //D d = new D();

        E e = new E(); // E extends C, which extends A
        e.test1();
        e.test2();
        e.test3();
        e.test4();

        F f = new F(); // F extends E, which extends C, which extends A
        f.test1();  
        f.test2();
        f.test3();  
        f.test4();

    }
}
