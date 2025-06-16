# Stack Memory in Java

In Java, stack memory is a part of memory that stores temporary variables created by each method. It is organized in a **Last-In-First-Out (LIFO)** manner.

## 📌 Characteristics of Stack Memory
- Fast access
- Stores primitive variables and object references (not the actual objects)
- Memory is automatically freed when the method ends
- Each thread has its own stack memory

---

## 🧱 Different Areas of Stack Memory
Each time a method is invoked, a **stack frame** is created in stack memory. Here's what a stack frame typically contains:

### 1. **Local Variables Area**
- Stores all the local variables defined inside the method
- Includes primitive data types (int, float, etc.) and references to objects

### 2. **Operand Stack**
- Temporary workspace for performing intermediate calculations
- Operands for bytecode instructions are pushed and popped here

### 3. **Frame Data (Method Call Info)**
- Stores metadata like:
  - Return address
  - Method arguments
  - Exception handlers

### 4. **Reference to Constant Pool**
- Points to runtime constant pool for method/class-specific data (e.g., field names, literals)

---

## 🧪 Example
```java
public class StackExample {
    public static void main(String[] args) {
        int x = 10; // stored in stack
        int y = 20;
        int result = add(x, y);
        System.out.println(result);
    }

    static int add(int a, int b) {
        int sum = a + b; // local variables in a new stack frame
        return sum;
    }
}
```

### Stack Trace:
1. `main()` method called → stack frame created
2. `add()` method called → new stack frame created
3. When `add()` finishes → its frame is removed
4. `main()` continues → then removed after finishing

---

## 🔁 Stack Overflow
Occurs when:
- Methods keep calling themselves recursively
- Stack frames accumulate and exceed memory limit

```java
public void infiniteRecursion() {
    infiniteRecursion();
}
```

**Error:** `java.lang.StackOverflowError`

---

## ✅ Summary
| Component        | Purpose                                     |
|------------------|---------------------------------------------|
| Local Variables  | Stores variables declared inside a method   |
| Operand Stack    | Used for bytecode instruction calculations  |
| Frame Data       | Holds return address and method info        |
| Constant Pool Ref| Points to method-related constants          |

Stack memory is essential for method execution and managing variables efficiently.

---

# Java Heap Out of Memory Error

In Java, the **heap** is the part of memory used to store objects and class instances. When an application creates too many objects or has memory leaks, and the JVM cannot allocate more memory, it throws an **OutOfMemoryError**.

## 🚨 What is Heap Memory?
- Used to store objects, arrays, and class metadata
- Shared across all threads
- Managed by the Garbage Collector (GC)

## ❗ What is `java.lang.OutOfMemoryError`?
This error occurs when the JVM cannot allocate more objects in the heap due to memory limits.

### Example:
```java
import java.util.ArrayList;

public class HeapErrorExample {
    public static void main(String[] args) {
        ArrayList<int[]> list = new ArrayList<>();
        while (true) {
            list.add(new int[1000000]);
        }
    }
}
```

This code creates an infinite number of large arrays, eventually exhausting heap space.

### Output:
```
Exception in thread "main" java.lang.OutOfMemoryError: Java heap space
```

---

## 🛠️ Common Causes
- Infinite object creation
- Memory leaks (unreleased references)
- Holding large data in memory (caches, collections)
- Misconfigured JVM heap size settings

---

## 💡 How to Fix
1. **Increase JVM heap size**:
```bash
java -Xmx1024m YourProgram
```

2. **Analyze memory usage**:
   - Use tools like VisualVM, Eclipse MAT, or JProfiler

3. **Fix memory leaks**:
   - Ensure unused objects are dereferenced
   - Use weak references if applicable

4. **Optimize data structures**:
   - Avoid keeping unnecessary large collections in memory

---

## ✅ Summary
| Error Type              | `java.lang.OutOfMemoryError`            |
|------------------------|------------------------------------------|
| Occurs in              | Heap Memory                              |
| Reason                 | JVM can't allocate memory for new object |
| Fixes                  | Increase heap size, fix memory leaks     |

Managing heap memory effectively is critical for building scalable and stable Java applications.
