
INHERITANCE :  

### ➤ Superclass & Subclass
- **Superclass**: The class whose properties and methods are inherited.
- **Subclass**: The class that inherits from the superclass.
- **`extends` keyword**: Used to establish inheritance between a subclass and a superclass.

---
Initializer Blocks:

Static Initializer Block (SIB) – Runs once when the class is loaded.

Instance Initializer Block (IIB) – Runs every time an object is created (before constructor).

Constructor Chaining using super() and this().

Multilevel Inheritance – Class I inherits from H, which inherits from G.

Static and Instance Variables – Demonstrates access and modification of static and instance fields.

Overloaded Constructors – Different constructors in both base and derived classes.


## 🧵 Single Inheritance


class C {
    int i;
}

class D extends C {
    int j;
}

class Manager {
    public static void main(String[] args) {
        C c = new C();
        D d = new D();
        c.i = 10;
        d.i = 20;
        d.j = 30;

        System.out.println("C's i:" + c.i);
        System.out.println("D's i:" + d.i);
        System.out.println("D's j:" + d.j);
    }
}
Output:

C's i: 10  
D's i: 20  
D's j: 30


🔁 Method Overriding
Method Overriding – Subclass (D) overrides superclass (C) methods.

class C {
    int i;

    void print() {
        System.out.println("C's i: " + i);
    }
}

class D extends C {
    int j;

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

        c.print();
        d.print();
    }
}
🔄 SIB, IIB, Constructor, this() & super()

this(...) must be the first line in a constructor.
You cannot have both this() and super() in the same constructor because both must be the first line.

class E {
    E() {
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

        System.out.println("\nCreating instance of F again:");
        F f2 = new F();
    }
}


🏛️ Multilevel Inheritance
class G {
    G() {
        System.out.println("G's constructor");
    }

    {
        System.out.println("G's instance initializer block");
    }

    static {
        System.out.println("G's static initializer block");
    }
}

class H extends G {
    H() {
        System.out.println("H's constructor");
    }

    {
        System.out.println("H's instance initializer block");
    }

    static {
        System.out.println("H's static initializer block");
    }
}

class I extends H {
    I() {
        System.out.println("I's constructor");
    }

    {
        System.out.println("I's instance initializer block");
    }

    static {
        System.out.println("I's static initializer block");
    }
}

class Manager2 {
    public static void main(String[] args) {
        System.out.println("Creating instance of G:");
        G g = new G();

        System.out.println("Creating instance of H:");
        H h = new H();

        System.out.println("Creating instance of I:");
        I i = new I();
    }
}


🧠 Static & Instance Variables
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
        this(10);
        System.out.println("K's constructor");
    }

    K(int k) {
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
        System.out.println("J class instance variable i: " + j.i + ", static variable j: " + J.j);

        System.out.println("\nCreating instance of K:");
        K k = new K();
        System.out.println("K class instance variable k: " + k.k + ", static variable l: " + K.l);
        System.out.println("J class instance variable i: " + k.i);
        System.out.println("J class static variable j via K: " + K.j);
        
        K.j = 10;
        System.out.println("J class static variable j after modification: " + J.j);
    }
}


🔧 Constructor Overloading with super()
class A {
    int i;

    A(int i) {
        this.i = i;
        System.out.println("A's constructor with parameter: " + i);
    }

    A() {
        System.out.println("A's default constructor");
    }

    {
        System.out.println("A's instance initializer block");
    }

    public void print() {
        System.out.println("A's print method, i: " + i);
    }
}

class B extends A {
    int j;

    B(int i, int j) {
        super(i);
        this.j = j;
        System.out.println("B's constructor with parameters: " + i + ", " + j);
    }

    {
        System.out.println("B IIB");
    }

    public void printAll() {
        System.out.println(i);
        System.out.println(j);
    }
}

class Manager4 {
    public static void main(String[] args) {
        A a1 = new A(10);
        System.out.println("------------------");
        B b1 = new B(200, 300);
        System.out.println(a1.i);
        System.out.println(b1.i);
        System.out.println(b1.j);
    }
}


🧪 Static Blocks & Constructor Overload Order
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
        super(10);
        System.out.println("B's default constructor");
    }

    B(int i) {
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

✅ Key Concepts Demonstrated:
Single Inheritance – One class (D) inherits from another (C).

Method Overriding – Subclass (D) overrides superclass (C) methods.

Polymorphism – The overridden method behaves differently depending on the object type.

Initializer Blocks:

Static Initializer Block (SIB) – Runs once when the class is loaded.

Instance Initializer Block (IIB) – Runs every time an object is created (before constructor).

Constructor Chaining using super() and this().

Multilevel Inheritance – Class I inherits from H, which inherits from G.

Static and Instance Variables – Demonstrates access and modification of static and instance fields.

Overloaded Constructors – Different constructors in both base and derived classes.



✅ Summary
super() calls parent class constructor.

this() calls another constructor in the same class.

Static initializer block runs once per class.

Instance initializer block runs before every constructor call.

Method Overriding enables runtime polymorphism.

extends enables inheritance.

Constructors chain from parent to child.



