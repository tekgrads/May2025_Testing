
# Java Memory and Operators Concepts

## 1. Post and Pre Increment in Java

Java provides two increment operators:
- **Pre-increment (`++i`)**: Increments the value, then returns the result.
- **Post-increment (`i++`)**: Returns the current value, then increments.

### Example:
```java
int i = 5;
System.out.println(++i); // Output: 6 (pre-increment)
System.out.println(i++); // Output: 6 (post-increment, then i becomes 7)
System.out.println(i);   // Output: 7
```

Use them wisely, especially in expressions or loops, as they change variable values differently depending on their position.

---

## 2. Stack and Heap in Java

Java memory is broadly divided into two areas:

### a. Stack Memory
- Stores method calls, local variables, and reference variables.
- Memory is organized in LIFO (Last-In-First-Out) order.
- Fast access and automatically cleaned up when method exits.

### b. Heap Memory
- Stores objects and class instances.
- Accessed via references stored in stack.
- Garbage collector reclaims memory for unused objects.

### Example Flow:
```java
public class MemoryExample {
    public static void main(String[] args) {
        int a = 10;              // 'a' is in stack
        String name = "Java";   // 'name' is reference in stack, object in heap
    }
}
```

---

## 3. Stack Unwinding Operation

**Stack Unwinding** is the process of cleaning up the call stack during exception handling.

### When It Happens:
- When an exception is thrown and not caught in the current method, the stack starts "unwinding" – i.e., methods are popped off the stack until a matching `catch` block is found.

### Example:
```java
public class UnwindDemo {
    static void methodA() {
        methodB();
    }

    static void methodB() {
        int x = 5 / 0; // ArithmeticException
    }

    public static void main(String[] args) {
        try {
            methodA();
        } catch (ArithmeticException e) {
            System.out.println("Exception caught!");
        }
    }
}
```
- Here, `methodB` throws the exception.
- Stack unwinds to `methodA`, and then to `main` where the exception is caught.

This ensures proper exception flow and resource cleanup during errors.

