Java Notes: Variables, Operators, Memory, and More
➤ Packages
A group of classes is called a package.

➤ Increment Operator
public class A {
    // Global variable declaration
    int i;

    public static void main(String[] args) {
        // Local variable declaration
        int i = 0;
        i = i + 1;
        System.out.println("Hello " + i);
    }
}
Global variable: Declared at the class level.

Local variable: Declared inside a method.

⚠️ Local variables must be initialized before use.

🔹 Two types of increment operators:
i++ → Post-increment: Value used first, then incremented.

++i → Pre-increment: Value incremented first, then used.

Note: Pre and post increment don’t show change when assigning to the same variable.
public class A {
    int i;

    public static void main(String[] args) {
        int i = 0;
        i = i++;       // post-increment
        System.out.println(i);
        ++i;           // pre-increment
        System.out.println(i);
    }
}
 Using Different Variables:

public class A {
    int i;

    public static void main(String[] args) {
        int i = 0;
        int j = i++;   // post-increment
        System.out.println(i); // 1
        System.out.println(j); // 0

        int k = ++i;   // pre-increment
        System.out.println(i); // 2
        System.out.println(k); // 2
    }
}
➤ Visual Studio Code Setup for Java
Install Visual Studio Code

Open folder with your Java programs

Install extensions:

Prettier

Live Preview

Code Runner

Java Extension Pack

Enable:

Mouse wheel zoom

Create a .java file and start coding
Static Method Example
public class A {
    public static void main(String[] args) {
        System.out.println("Hello from A!");
        methodA();
    }

    public static void methodA() {
        System.out.println("Method A in class A");
    }
}
➤ Memory Diagram in Java
Memory divided into:

Stack → Used for execution (method calls, local variables)

Heap → Used for storage (objects, instance variables)

➤ Example: Stack Memory Flow
public class A {
    public static void main(String[] args) {
        System.out.println("Hello from A!");
        int i = 0;
        methodA(i);
        System.out.println("Value of i after methodA: " + i);
    }

    public static void methodA(int i) {
        System.out.println("Method A in class A");
        System.out.println("Value of i: " + i);
        i = 100;
        System.out.println("Updated value of i: " + i);
    }
}
Here, i in main and i in methodA are separate copies in stack memory.


➤ Static Member Access and Shadowing
public class A {
    static int i = 10;

    public static void main(String[] args) {
        System.out.println("Hello from A!");
        System.out.println("Global value of i in main: " + i);

        int i = 0;  // shadows the global 'i'
        System.out.println("Local value of i in main: " + i);

        methodA(i);
        System.out.println("Value of i after methodA: " + i);
    }

    public static void methodA(int i) {
        System.out.println("Method A in class A");
        System.out.println("Value of i in methodA: " + i);
        i = 100;
        System.out.println("Updated value of i in methodA: " + i);
    }
}
➤ StackOverflowError
Occurs when:

Infinite recursion

Deeply nested method calls exceed the stack memory limit
public class A {
    public static void recurse() {
        recurse(); // infinite recursion
    }

    public static void main(String[] args) {
        recurse(); // causes StackOverflowError
    }
}










