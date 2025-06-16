# Different Memory Areas of Stack in Java

In Java, memory is divided into several areas for efficient program execution. One important part of memory is the **Stack Area**, which is used for storing method-level data.

---

## What is Stack Memory?
Stack memory is a part of JVM memory used for:
- Method invocations
- Local variables
- Reference variables

It is created for each thread and follows **Last-In-First-Out (LIFO)** behavior. Once a method call ends, its stack frame is removed.

---

##  Key Components of Stack Memory

### 1. **Stack Frame**
Each time a method is invoked, a new **stack frame** is created and pushed onto the stack. It contains:
- Local Variables
- Operand Stack
- Frame Data (method info, return address)

### 2. **Local Variable Array**
- Stores all local variables defined inside a method.
- Includes method parameters.
```java
void exampleMethod(int a) {
    int b = 10; // 'a' and 'b' are stored in local variable array
}
```

### 3. **Operand Stack**
- Used for intermediate calculations by the JVM.
- Operands are pushed/popped during bytecode execution.
```java
int x = 2 + 3; // JVM uses operand stack to evaluate 2 + 3
```

### 4. **Dynamic Linking Data**
- Stores pointers to runtime constant pool items for method calls and field accesses.

### 5. **Return Address**
- Indicates the point to return after a method call.

---

## Per-Thread Memory
Each thread in Java gets its own stack. Therefore:
- Stack memory is **not shared** between threads.
- Each thread has its own call history.

---

## Stack Overflow Error
Occurs when the stack memory exceeds its allocated limit.
```java
public class StackOverflow {
    public static void recursive() {
        recursive();
    }
    public static void main(String[] args) {
        recursive();
    }
}
```
> This code causes `java.lang.StackOverflowError` due to deep recursion.

---

## Summary
| Component          | Description                                      |
|-------------------|--------------------------------------------------|
| Stack Frame        | Stores data for a single method call            |
| Local Variable     | Method parameters and local variables            |
| Operand Stack      | Intermediate values during execution            |
| Dynamic Link       | Resolves method/field references                |
| Return Address     | Points to next instruction after method return  |

---


