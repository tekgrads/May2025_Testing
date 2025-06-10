# Understanding Memory Areas of the Stack in Java

When a Java program runs, it uses memory divided into several parts. One important part is the **stack memory**, which handles method calls and local variables.easy-to-understand way.

## What is Stack Memory?

The stack is a memory area used for storing:
- Method execution information
- Local variables
- Reference addresses for temporary data

Each time a method is called, a new block called a **stack frame** is created for that method.

## Key Components of Stack Memory

### 1. Stack Frames
A stack frame is created every time a method is called. It contains all the data that the method needs to run, such as:
- Local variables declared in the method
- Parameters passed to the method
- Return address (where to go after method finishes)

When the method completes, its frame is removed (popped) from the stack.

**Example:**
```java
public void greet(String name) {
    String message = "Hello " + name;
    System.out.println(message);
}
```
In this method:
- `name` and `message` are stored in the stack frame.

### 2. Local Variables
Variables defined within a method are stored in the stack. These exist only during the method's execution and are removed afterward.

### 3. Parameters
When methods receive input values (parameters), they are placed into the stack frame just like local variables.

### 4. Return Address
When one method calls another, the JVM stores where it should return after the call. This return point is kept in the stack.

## Stack Growth and Shrinking

As methods call other methods, new frames are added on top of the stack. This is called **stack growth**. When methods finish, their frames are removed, which is called **stack shrinking**.

### Visual Representation (Conceptual)
```
Top of Stack
+--------------------+
| Frame: methodC()   |
+--------------------+
| Frame: methodB()   |
+--------------------+
| Frame: methodA()   |
+--------------------+
Bottom of Stack
```

## Stack Overflow Error

If too many method calls are made without returning (such as with infinite recursion), the stack becomes full. This results in a `StackOverflowError`.

**Example:**

public void recurse() {
    recurse(); // No base case leads to stack overflow
}

