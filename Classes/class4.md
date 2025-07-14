🧠 Java Concepts: Local/Global Variables, Increment/Decrement, Stack, Heap, Errors, and More
1. Local Variables
In Java, a local variable is declared inside a method or block of code. It is only accessible within that specific block and has a lifetime limited to that block.

🔹 Example:
java
Copy
Edit
public class LocalVariable {
    public static void main(String[] args) {
        int number = 10; // Local variable
        System.out.println("The number is: " + number);
    }

    public void someOtherMethod() {
        System.out.println(number); // ❌ Error: number is not accessible here
    }
}
2. Global Variables
Java does not support traditional global variables, but similar functionality can be achieved using static variables inside a class.

3–4. Pre-Increment vs Post-Increment
Pre-Increment (++x): Increments before using the value.

Post-Increment (x++): Increments after using the value.

🔹 Example:
java
Copy
Edit
public class Increment {
    public static void main(String[] args) {
        int a = 5;
        int b = 5;

        System.out.println("Post-increment:");
        System.out.println("a = " + a);      // 5
        System.out.println("a++ = " + a++);  // 5
        System.out.println("After post-increment, a = " + a);  // 6

        System.out.println("Pre-increment:");
        System.out.println("b = " + b);      // 5
        System.out.println("++b = " + ++b);  // 6
        System.out.println("After pre-increment, b = " + b);  // 6
    }
}
5–6. Pre-Decrement vs Post-Decrement
Pre-Decrement (--x): Decreases value before using it.

Post-Decrement (x--): Uses value first, then decreases.

🔹 Example:
java
Copy
Edit
public class Decrement {
    public static void main(String[] args) {
        int a = 5;
        int b = 5;

        System.out.println("Post-decrement:");
        System.out.println("a = " + a);      // 5
        System.out.println("a-- = " + a--);  // 5
        System.out.println("After post-decrement, a = " + a);  // 4

        System.out.println("Pre-decrement:");
        System.out.println("b = " + b);      // 5
        System.out.println("--b = " + --b);  // 4
        System.out.println("After pre-decrement, b = " + b);  // 4
    }
}
7. Hard Disk
Java interacts with the hard disk through:

java.io and java.nio packages.

File operations: reading/writing files, creating/deleting directories.

8. RAM in Java
🧩 Java divides RAM usage into:
🔸 Heap Memory
Stores objects and class instances.

Managed by Garbage Collector.

Larger than stack memory.

If full, throws OutOfMemoryError.

🔸 Stack Memory
Stores method calls, local variables, and references.

Follows LIFO.

Limited size.

If full, throws StackOverflowError.

9. Stack Unwinding
Stack Unwinding is the process of unwinding the call stack when an exception is thrown. The JVM searches up the stack for a matching catch block.

10. Stack (Data Structure)
LIFO: Last In, First Out

Operations: push, pop, isEmpty

🔹 Analogy:
Imagine stacking bricks:

Copy
Edit
| brick3 |
| brick2 |
| brick1 |
Remove order: brick3 → brick2 → brick1

11. Queue (Data Structure)
FIFO: First In, First Out

Operations: add, remove, offer

🔹 Analogy:
Buying tickets at a counter – first come, first served.

css
Copy
Edit
Front → [5, 4, 3, 2, 1] → Rear
12. StackOverflowError
Occurs when:

Too many method calls

Deep or infinite recursion

Stack memory limit is exceeded

✅ To Prevent:
Add proper termination conditions

Avoid deep recursion

Increase stack size if needed

13. ClassNotFoundException
This checked exception occurs when the JVM cannot find a class during runtime.

✅ Fixes:
Verify classpath

Check for missing dependencies

14. Static (Keyword)
Belongs to the class, not instances.

Used for memory management.

Can only access other static members.

🔹 Example:
java
Copy
Edit
public class A {
    public static void main(String[] args) {
        System.out.println("Hello");
        int i = 10;
        methodA(i);
        System.out.println("Updated i value is " + i);
    }

    public static void methodA(int i) {
        System.out.println("Method A in class A");
        System.out.println("Value of i is " + i);
        i = 100;
        System.out.println("New i value is " + i);
    }
}
15. Static Variables
Declared using static keyword.

Memory is allocated once when class is loaded.

Accessed using the class name.

🔹 Example:
java
Copy
Edit
public class Var {
    static int i = 10;

    public static void main(String[] args) {
        System.out.println("Value of i is " + i);
    }
}
16. Static Methods
Belong to the class.

Cannot access instance variables directly.

Accessed using the class name.

🔹 Example:
java
Copy
Edit
class Statmethod {
    public static int show(int i) {
        return i;
    }

    public static int show1(int j) {
        return j;
    }
}

public class Main {
    public static void main(String[] args) {
        int a = Statmethod.show(8);
        int b = Statmethod.show1(10);
        System.out.println("a value is " + a);
        System.out.println("b value is " + b);
    }
}
17. Stack Memory Area
🔸 Purpose:
Executes methods

Stores local data

🔸 Works on:
LIFO structure

Stack Frames: For each method call

Method Completion: Frees memory by popping the frame

🔸 Stores:
Local variables

Method parameters

Return addresses

References to heap objects