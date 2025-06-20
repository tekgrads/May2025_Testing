interface S {
    void test1(); // abstract method
}

class T {
    void test1() {
        System.out.println("T.test1");
    }
}

class U extends T implements S {
    @Override
    public void test1() { // implementation of S's abstract method
        System.out.println("U.test1");
    }
}

class V extends T {
    // Inherits T's test1 method without overriding
}


public class Manager5 {

    public static void main(String[] args) {
        // S s = new S(); // Cannot instantiate interface S
         T t = new T(); // Can instantiate T
         t.test1();
        U u = new U();
        u.test1(); // Calls U's implementation of S's test1
        System.out.println("Manager5.main() completed successfully.");
    }
    
}
