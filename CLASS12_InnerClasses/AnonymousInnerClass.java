abstract class A {
    public abstract void m1(); // Abstract method    
}

class B extends A {
    @Override
    public void m1() {
        System.out.println("B.m1");
    }
}


public class AnonymousInnerClass {
    public static void main(String[] args) {
        B b1 = new B();
        b1.m1();
    
        A a1 = new A() { // Anonymous inner class
            @Override
            public void m1() {
                System.out.println("Anonymous Inner Class m1");
            }
        };

        a1.m1();

    }
}
