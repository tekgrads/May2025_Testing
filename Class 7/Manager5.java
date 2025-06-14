class A {
    int i;
    static int j;

    A(int i) {
        System.out.println("A(int)");
    }

    A() {
        System.out.println("A's default constructor");
    }

static {
    System.out.println("SIB-A");
}

    {
        System.out.println("A's instance initializer block");
    }
}

class B extends A {
    int k;
    static int l;
    static {
        System.out.println("SIB-B");
    }

    B() {
        // super(); // constructor chaining happens automatically
        super(10);
        System.out.println("B's default constructor");
    }

    B(int i) {
       //super     
        System.out.println("B's constructor with parameters: ");
        this.i = i;
    }

    {
        System.out.println("B IIB");
    }
   
}

class Manager5 {
    public static void main(String[] args) {
        A a1 = new A();
        System.out.println("------------------");
        A a2 = new A(1000);
        System.out.println("------------------");

        B b1 = new B(2000);
        System.out.println("------------------");
        B b2 = new B();
        System.out.println("------------------");
    }
}