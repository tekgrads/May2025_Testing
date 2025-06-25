🔹 What is Stack Memory in Java?
Stack memory is a runtime memory area used by the Java Virtual Machine (JVM) to:

Manage method execution

Store local variables

Hold method parameters

Maintain return addresses

🔹 Key Purposes of Stack Memory
Feature	Description
🔸 Stores	Local variables, method parameters, and references to objects (not the objects themselves).
🔸 Thread-safe	Each thread has its own stack.
🔸 Temporary	Memory is allocated at method call and deallocated when the method exits.
🔸 Efficient	Operates in LIFO (Last In, First Out) order—very fast.

🔹 Stack Memory Structure (LIFO)
mathematica
Copy
Edit
|-------------------------|  ← Top of stack (most recent method call)
| Stack Frame: methodC()  |
|-------------------------|
| Stack Frame: methodB()  |
|-------------------------|
| Stack Frame: methodA()  |
|-------------------------|  ← Bottom of stack (main method or thread start)
Each method call creates a stack frame.

When a method ends, its frame is popped off the stack.

This process is called stack unwinding.

🔹 Components Inside a Stack Frame
Local Variables

Declared inside the method

Includes primitive types and object references

Stored in the Local Variable Array of the frame

Method Parameters

Passed to the method and stored just like local variables

Operand Stack

Used for intermediate calculations during bytecode execution

Return Address

Tells the JVM where to return after the method finishes

🔹 Characteristics of Stack Memory
Feature	Description
📌 Fast	Memory is allocated/deallocated quickly due to LIFO.
📌 Auto-managed	No need for manual memory management. JVM does it automatically.
📌 Limited size	If too deep (e.g., infinite recursion), StackOverflowError occurs.
📌 Thread-specific	Each thread gets its own isolated stack memory.

🔹 Stack Memory vs Heap Memory (Quick Comparison)
Feature	Stack Memory	Heap Memory
Scope	Per thread	Shared among all threads
Stores	Local variables, method calls	Objects, class variables
Speed	Very fast	Slower than stack
Lifespan	Short (tied to method call)	Long (until garbage collected)
Managed by	Automatically by JVM	Garbage Collector
Error on limit	StackOverflowError	OutOfMemoryError

🔹 Execution Flow Example
java
Copy
Edit
public class Test {
    public static void main(String[] args) {
        methodA();
    }

    static void methodA() {
        int x = 5;
        methodB(x);
    }

    static void methodB(int y) {
        int z = y + 10;
        System.out.println("z: " + z);
    }
}
Stack Flow:

main() → pushed to stack

methodA() → pushed

methodB() → pushed

After completion, methodB() → popped

Then methodA() → popped

Then main() → popped

This stack buildup and cleanup is what maintains the method execution order and context.