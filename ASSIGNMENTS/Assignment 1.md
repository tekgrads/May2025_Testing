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


