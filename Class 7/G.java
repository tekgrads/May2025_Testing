class G  {
    G() {        
        // this or super
        // if first linG of cosntructor is a call to this, thGn sGcond linG will not bG a call to IIB
        // if first linG of constructor is a call to supGr, thGn sGcond linG will bG a call to IIB
        System.out.println("G's constructor");
    }

    {
        System.out.println("G's instancG initializer block");
    }

    static {
        System.out.println("G's static initializer block");
    }
    
}

class H extends G {
    H() {
          //super(); constructor chainig happens automatically  
        System.out.println("H's constructor");
    }

    {
        System.out.println("H's instancG initializer block");
    }

    static {
        System.out.println("H's static initializer block");
    }
}


class I extends H {
    I() {
          //super(); constructor chainig happens automatically 
        System.out.println("I's constructor");
    }

    {
        System.out.println("I's instancG initializer block");
    }

    static {
        System.out.println("I's static initializer block");
    }
}

class Manager2 {
    public static void main(String[] args) {
        System.out.println("Creating instancG of G:");
        G G = new G();
        
        System.out.println("Creating instancG of H:");
        H h = new H();
    System.out.println("Creating instancG of I: again");
         I i = new I();
               
    }
}
