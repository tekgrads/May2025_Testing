🔹 1. What is a Static Initialization Block (SIB)?
A SIB is a static block that runs once when the class is loaded, before the main() method or any object is created.

Useful for initializing static variables or performing one-time setup.

java
Copy
Edit
public class A {
    static {
        System.out.println("SIB block");
    }

    public static void main(String[] args) {
        System.out.println("hello");
    }
}
📌 Key Points:
Declared using static { }.

Executes in order of appearance in the class.

Can access static variables (even private).

Cannot access non-static (instance) members.

If a program has only static blocks but no main() method, it throws:
Error: Main method not found.

🔹 2. Multiple Static Blocks – Execution Order
java
Copy
Edit
public class A {
    static {
        System.out.println("SIB1");
    }

    public static void main(String[] args) {
        System.out.println("hello");
    }

    static {
        System.out.println("SIB2");
    }
}
📝 Output:

nginx
Copy
Edit
SIB1
SIB2
hello
Static blocks are executed in the order they appear before main.

🔹 3. Accessing Static Variables
java
Copy
Edit
public class A {
    static int i;
    static int j = 10;

    static {
        A.i = 100;
        A.j = 200;
        System.out.println("i: " + i + ", j: " + j);
    }

    public static void main(String[] args) {
        System.out.println("hello");
    }
}
Static variables can be accessed using class name or directly within the same class.

🔹 4. Using Static as a Global Variable
java
Copy
Edit
public class A {
    static int i = 90;

    static {
        i = 100;
        System.out.println("SIB1");
    }

    public static void main(String[] args) {
        System.out.println("hello");
        System.out.println("i: " + i);
    }

    static {
        System.out.println("SIB2");
    }
}
📝 Output:

css
Copy
Edit
SIB1
SIB2
hello
i: 100
Shows that i retains the last assigned value from static blocks.

🔹 5. Two Classes with Main Methods
java
Copy
Edit
class A {
    public static void main(String[] args) {
        System.out.println("hello");
    }
}

class B {
    public static void main(String[] args) {
        System.out.println("hii");
    }
}
When you execute Class A, only A’s main() runs. Output: hello.

🔹 6. Accessing Variables Across Classes
java
Copy
Edit
class F {
    static int i = 1000;
}

class G {
    static int i = 10;

    public static void main(String[] args) {
        System.out.println("hii");
        System.out.println("F.i: " + F.i);
        System.out.println("G.i: " + i);
    }
}
📝 Output:

yaml
Copy
Edit
hii
F.i: 1000
G.i: 10
🔹 7. Multiple Classes with Multiple SIBs
java
Copy
Edit
class A {
    static int i = 90;

    static {
        System.out.println("SIB1 in A");
    }

    static {
        System.out.println("SIB2 in A");
    }
}

class B {
    static int i = 10;

    static {
        System.out.println("SIB1 in B");
    }

    public static void main(String[] args) {
        System.out.println("B class");
        System.out.println("A.i: " + A.i);
        System.out.println("B.i: " + i);
    }

    static {
        System.out.println("SIB2 in B");
    }
}
📝 Output:

less
Copy
Edit
SIB1 in B
SIB2 in B
B class
SIB1 in A
SIB2 in A
A.i: 90
B.i: 10
Static blocks from B are executed first (class B loads first), then A is loaded when A.i is accessed.

🔸 Object Creation and Memory
8. Object Creation Using new Keyword
java
Copy
Edit
public class L {
    int i;

    public static void main(String[] args) {
        L l1 = new L();
        System.out.println("l1.i: " + l1.i);
        l1.i = 10;

        L l2 = new L();
        l2.i = 20;

        L l3 = new L();
        l3.i = 30;

        System.out.println("l2.i: " + l2.i);
        System.out.println("l3.i: " + l3.i);
    }
}
Every object has its own copy of non-static variables.