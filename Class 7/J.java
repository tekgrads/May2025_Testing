 class J {
    int i;
    static int j;
    static {
        System.out.println("J's static initializer block");
    }
    J() {
        System.out.println("J's constructor");
    }

    {
        System.out.println("J's instance initializer block");
    }
}

class K extends J {
    int k;
    static int l;
   
    K() {
        //super(); // constructor chaining happens automatically
        this(10);
        System.out.println("K's constructor");
    }

    K(int k){
        //super();
        //this();
        this.k = k;
        System.out.println("K's constructor with parameter: " + k);
    }

    static {
        System.out.println("K's static initializer block");
    }

   

    {
        System.out.println("K's instance initializer block");
    }
}

class Manager3 {
    public static void main(String[] args) {
        System.out.println("Creating instance of J:");
        J j = new J();

        System.out.println("J class instance variable i: " + j.i  + ", static variable j: " + J.j);
        
        System.out.println("\nCreating instance of K:");
        K k = new K();
        System.out.println("K class instance variable k: " + k.k + ", static variable l: " + K.l);        
        System.out.println("J class instance variable i: " + k.i);
        System.out.println("J class Static variable j accessing using K: " + K.j);
        K.j = 10; // modifying static variable j using K reference
        System.out.println("J class Static variable j after modification: " + J.j);
    }
}
