interface V{
    void test1(); // abstract method
}

abstract class W{
    public abstract void test1(); // abstract method
}

class X extends W implements V {
    @Override
    public void test1() { // implementation of V's abstract method
        System.out.println("X.test1");
    }
}

public class Manager6 {

    public static void main(String[] args) {
        // V v = new V(); // Cannot instantiate interface V
        // W w = new W(); // Cannot instantiate abstract class W

        X x = new X();
        x.test1(); // Calls X's implementation of V's test1

        System.out.println("Manager6.main() completed successfully.");
    }
    
}
