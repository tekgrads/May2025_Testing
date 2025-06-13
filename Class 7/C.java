class C {
    int i;

    void print() {
        System.out.println("C's i: " + i);
    }
    
}

class D extends C {
    int j;
     
    // Overriding the print method from class C
    @Override
    void print() {
        System.out.println("D's i: " + i);
        System.out.println("D's j: " + j);
    }
}

class Manager {
    public static void main(String[] args) {
        C c = new C();
        D d = new D();
        c.i = 10;
        d.i = 20;
        d.j = 30;

        System.out.println("C's i: " + c.i);
        System.out.println("D's i: " + d.i);
        System.out.println("D's j: " + d.j);

        System.out.println("Calling print method on C:");
        c.print();
        System.out.println("Calling print method on D:");
        d.print();
        // Demonstrating polymorphism
    }
}