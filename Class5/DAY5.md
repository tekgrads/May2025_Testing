 Static Initialization Blocks (SIB)
A static block is used to initialize static variables.

It runs only once, when the class is loaded.

Syntax:
static {
    // static initialization block
}
 Example: Static Block Execution
public class A {
    static int i;
    static int j = 10;

    static {
        i = 5;
        j = 20;
        System.out.println("Static block in A executed. i: " + i + ", j: " + j);
    }

    public static void main(String[] args) {
        System.out.println("Hello from A!");
    }
}
Multiple Static Blocks
public class A {

    static {
        System.out.println("SIB-1");
    }

    public static void main(String[] args) {
        System.out.println("Hello from A!");
    }

    static {
        System.out.println("SIB-2");
    }
}
 Static blocks are executed in the order they appear in the class.
Accessing Static Members of Other Classes
class F {
    static int i = 100;
}

class G {
    static int i = 200;
    public static void main(String[] args) {
        System.out.println("Hello from G!");
        System.out.println("Value of i from class G: " + i);
        System.out.println("Value of i from class F: " + F.i);
    }
}
 Only the class containing the main method is executed. Other classes  loaded only if referenced.

Object Creation and Instance Variables
public class L {
    int i;

    public static void main(String[] args) {
        L l1 = new L();
        System.out.println("Hello World from L!");
        System.out.println("Value of i from class L for l1: " + l1.i);
        
        l1.i = 10;
        System.out.println("After assignment in l1: " + l1.i);

        L l2 = new L();
        l2.i = 20;
        System.out.println("After assignment in l2: " + l2.i);

        L l3 = new L();
        l3.i = 30;
        System.out.println("After assignment in l3: " + l3.i);
    }
}

Orphan Objects
❓ What are Orphan Objects?
Objects that no longer have any reference pointing to them.

Java's Garbage Collector (GC) automatically removes these objects to free memory.

🔍 Example:
L obj = new L();  // Reference created
obj = null;       // Now 'L' object becomes orphan
GC handles such objects and reclaims memory in the background.



 
