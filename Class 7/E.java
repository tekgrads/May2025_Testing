class E  {
    E() {        
        // this or super
        // if first line of cosntructor is a call to this, then second line will not be a call to IIB
        // if first line of constructor is a call to super, then second line will be a call to IIB
        System.out.println("E's constructor");
    }

    {
        System.out.println("E's instance initializer block");
    }

    static {
        System.out.println("E's static initializer block");
    }
    
}

class F extends E {
    F() {
            //super(); constructor chainig happens automatically
        // super compiler will add a call to super() as first line
        System.out.println("F's constructor");
    }

    {
        System.out.println("F's instance initializer block");
    }

    static {
        System.out.println("F's static initializer block");
    }
}

class Manager1 {
    public static void main(String[] args) {
        System.out.println("Creating instance of E:");
        E e = new E();
        
        System.out.println("\nCreating instance of F:");
        F f = new F();
 System.out.println("\nCreating instance of F: again");
         F f2 = new F();
               
    }
}
