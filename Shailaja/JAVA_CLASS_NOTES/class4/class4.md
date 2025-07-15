1. 🧠 Local Variables
Definition:
Local variables are declared inside methods, constructors, or blocks. They are created when the method is called and destroyed after the method ends.

Key Points:

Scope is limited to the block/method they are defined in.

Cannot be accessed from other methods.

Do not have default values; must be initialized before use.

Example:

java
Copy
Edit
public class LocalVariable {
    public static void main(String[] args) {
        int number = 10;
        System.out.println("Number is: " + number);
    }

    public void anotherMethod() {
        // System.out.println(number); // Error: number not accessible here
    }
}
2. 🌍 Global Variables in Java (Using Static)
Java does not support traditional global variables.
However, you can simulate global behavior using static variables.

Key Characteristics:

Belong to the class, not to instances.

Accessible across all instances of the class.

Useful for constants and shared data.

3 & 4. ➕ Pre-Increment vs Post-Increment
Pre-Increment (++x): Increases value before using it in an expression.
Post-Increment (x++): Uses the value, then increments it.

Example:

java
Copy
Edit
int a = 5;
System.out.println(a++); // Outputs 5, then a becomes 6
System.out.println(++a); // a becomes 7, then prints 7
5 & 6. ➖ Pre-Decrement vs Post-Decrement
Pre-Decrement (--x): Decreases value before using it.
Post-Decrement (x--): Uses the value, then decreases it.

7. 💽 Hard Disk (File Storage in Java)
Java provides java.io and java.nio packages to interact with the file system.

Examples: reading/writing text files, creating folders, deleting files, etc.

8. 🧬 RAM Usage in Java
Heap Memory:
Stores objects and class-level data.

Managed by Garbage Collector.

Larger in size, used for dynamic memory allocation.

Stack Memory:
Stores method calls, parameters, and local variables.

Follows LIFO structure.

Smaller, fast, and tied to threads.

9. 🔄 Stack Unwinding
Happens during exception handling.

JVM moves up the call stack to find a matching catch block.

If not found, program terminates abnormally.

10. 🧱 Stack (LIFO)
Last-In-First-Out structure.

Operations: push(), pop(), peek(), isEmpty().

Useful in recursion, undo features, expression evaluation.

11. 🚶 Queue (FIFO)
First-In-First-Out structure.

Operations: add(), remove(), offer(), poll().

Used in task scheduling, printers, etc.

12. 🚫 StackOverflowError
Occurs when stack memory exceeds limit.

Usually due to deep or infinite recursion.

Preventive Measures:

Use proper base cases in recursion.

Avoid unnecessary method calls.

Optimize recursive logic.

13. ❗ ClassNotFoundException
Checked exception thrown when JVM can’t find the class during runtime.

Common in dynamic class loading, JDBC, or reflection.

Fix: Ensure the class is in the classpath or dependencies are properly configured.

14. 🧍 Static Keyword
Usage:
Used to declare class-level members.

Static Variables:
Shared by all instances.

Memory allocated once per class.

Example:

java
Copy
Edit
class Example {
    static int count = 0;
}
Static Methods:
Called without creating objects.

Can access only static data.

Example:

java
Copy
Edit
class StaticDemo {
    static void display() {
        System.out.println("Static method");
    }
}
15. 🧠 Stack Memory Area in JVM
What it Stores:

Local variables

Method calls

Reference variables

Working:

Follows LIFO.

Each method call creates a new stack frame.

When the method completes, its frame is removed.

Memory Errors:

StackOverflowError occurs if too many nested calls or deep recursion.

✅ 15 Key Interview Points Summary:
Local variables are block-specific and temporary.

Global behavior in Java is simulated using static variables.

Pre-increment modifies before usage, post-increment after usage.

Same logic applies to decrement operators.

Java handles file storage via java.io and java.nio.

Heap memory is for objects; stack is for methods and local variables.

Stack memory is LIFO and causes StackOverflow on overuse.

Exception handling uses stack unwinding to trace method calls.

Stack data structure is LIFO (like a pile of books).

Queue is FIFO (like a ticket line).

StackOverflowError is caused by too many nested calls.

ClassNotFoundException is a checked exception due to missing classes.

Static allows members to be shared and accessed without objects.

Static methods can’t access instance data directly.

JVM uses stack memory for method execution and local variable storage.
