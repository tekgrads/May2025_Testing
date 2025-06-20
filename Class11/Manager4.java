class O {
    void test1() {
        System.out.println("O.test1");
    }
}

interface P{
    void test2(); // abstract method
}

interface Q {
    void test3();
}

class R extends O implements P, Q {
    @Override
    public void test2() { // implementation of P's abstract method
        System.out.println("R.test2");
    }

    @Override
    public void test3() { // implementation of Q's abstract method
        System.out.println("R.test3");
    }
}
public class Manager4 {

    public static void main(String[] args) {
         O o = new O(); // Cannot instantiate O directly
        // P p = new P(); // Cannot instantiate interface P
        // Q q = new Q(); // Cannot instantiate interface Q
            o.test1();
        R r = new R();
        r.test1(); // Calls O's test1
        r.test2(); // Calls R's implementation of P's test2
        r.test3(); // Calls R's implementation of Q's test3

        System.out.println("Manager4.main() completed successfully.");
    }
    
}
