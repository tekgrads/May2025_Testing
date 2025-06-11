🧠 Memory Areas of Stack in Java
In Java, Stack memory is one of the key memory areas used during method execution.stack memory is used when a method runs. It stores temporary data like method variables and helps the program remember where it left off after each method call. It stores method-level data and is organized in a Last-In, First-Out (LIFO) manner.
 What is Stack Memory?
Stack memory is like a stack of books — the last item added is the first to be removed.

Every time a method is called, a new block of memory (called a stack frame) is added.

When the method finishes, that block is removed automatically.
 Key Characteristics of Stack Memory in Java
✅ Stores local variables and method parameters

✅ Follows LIFO (Last-In, First-Out) structure

✅ Each method call creates a new stack frame

✅ Memory is automatically allocated and deallocated

✅ Each thread has its own stack

✅ Fast access compared to heap memory

✅ Stack memory is limited in size

✅ Causes StackOverflowError if memory is overused (e.g., infinite recursion)

✅ Does not require manual cleanup

✅ Only stores primitive data and references to objects, not the objects themselves

 What’s Stored in the Stack?
Each method call has its own stack frame with these parts:

1. Local Variables Area
Stores variables created inside the method.

Also stores any values passed into the method (called parameters).

🧾 Example:
void greet(String name) {
    int age = 20;
}
name and age are stored here.

2. Temporary Values Area (Operand Stack)
Used to do calculations and hold temporary results.

Example: When adding two numbers, the stack holds them before showing the result.

3. Return Address
Remembers where to go back after the method finishes.

Helps the program return to the right place after a method call.

4. Extra Info (Optional)
Can include extra information like exception handling or method metadata.

🔄 How Stack Works in Java
A method is called → a new stack frame is created.

The method runs → variables and values are stored temporarily.

The method finishes → the stack frame is removed automatically.

⚠️ Common Problem: Stack Overflow
Happens when a method keeps calling itself over and over (infinite recursion).

The stack gets full, and Java shows:
StackOverflowError

🧾 Example:

void callAgain() {
    callAgain();  // This will cause a StackOverflowError
}
