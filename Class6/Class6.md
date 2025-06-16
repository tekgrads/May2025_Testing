

# Java Constructors and Initialization Blocks

## IIB - Instance Initialization Block

---

## Constructor

A **constructor** is a block of code that is required for object initialization.

- **Default constructor**
- **Parameterized constructor**

---

## Default Constructor

### Example:


public class F {
    int i;

    F() { // default constructor
        i = 10;
    }

    public static void main(String[] args) {
        F f = new F(); // creating an object of class F
        System.out.println("Value of i: " + f.i); // accessing the instance variable i
    }
}
Output:
Value of i: 10

Parameterized Constructor:

Example:
public class F {
    int i;

    F() { // non-parameterized constructor
        i = 10;
    }

    F(int i) { // parameterized constructor
        this.i = i;
    }

    public static void main(String[] args) {
        F f = new F();
        F f2 = new F(20); // object with parameter
        System.out.println("Value of i: " + f.i);
        System.out.println("Value of i: " + f2.i);
    }
}
Output:
Value of i: 10
Value of i: 20


Combination of SIB, IIB, Default Constructor and Parameterized Constructor
Example:
public class G {
    int i = 5; // instance variable
    static int j = 20; // static variable

    G() {
        System.out.println("Non-parameterized constructor called G()");
        i = 10;
    }

    {
        System.out.println("Instance initializer block called");
        i = 15;
        System.out.println("Instance variable i initialized to: " + i);
    }

    static {
        System.out.println("Static initializer block called");
        j = 30;
        System.out.println("Static variable j initialized to: " + j);
    }

    G(int i) {
        System.out.println("Parameterized constructor called G(int i)");
        this.i = i;
    }

    public static void main(String[] args) {
        G g = new G();
        System.out.println("Value of i: " + g.i);

        G g2 = new G(20);
        System.out.println("Value of i: " + g2.i);

        G g3 = new G(30);
        System.out.println("Value of i: " + g3.i);

        System.out.println("Value of j: " + G.j);
    }
}
Output:
Static initializer block called
Static variable j initialized to: 30
Instance initializer block called
Instance variable i initialized to: 15
Non-parameterized constructor called G()
Value of i: 10
Instance initializer block called
Instance variable i initialized to: 15
Parameterized constructor called G(int i)
Value of i: 20
Instance initializer block called
Instance variable i initialized to: 15
Parameterized constructor called G(int i)
Value of i: 30
Value of j: 30


this() Constructor Call

Example:
public class I {
    int i;

    I(int i) {
        System.out.println("Parameterized constructor called I(int i)");
        this.i = i;
        System.out.println("Instance variable i initialized to: " + this.i);
    }

    I() {
        this(10); // call to another constructor must be the first statement
        System.out.println("Non-parameterized constructor called I()");
        System.out.println("Instance variable i initialized to: " + this.i);
    }

    {
        System.out.println("Instance initializer block-1 called");
    }

    {
        System.out.println("Instance initializer block-2 called");
    }

    public static void main(String[] args) {
        I I1 = new I();
        System.out.println("Value of i: " + I1.i);

        I I2 = new I(20);
        System.out.println("Value of i: " + I2.i);

        I I3 = new I(30);
        System.out.println("Value of i: " + I3.i);
    }
}







