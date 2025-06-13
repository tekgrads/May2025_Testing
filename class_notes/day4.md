# Java: Increment/Decrement Operators and Memory Management

## 1. Increment and Decrement Operators in Java

Java provides two types of operators to increase or decrease a value:

- **Increment (++)**: Increases a value by 1.
- **Decrement (--)**: Decreases a value by 1.

### Types

1. **Pre-Increment (++x) / Pre-Decrement (--x)**
   - The value is **updated first**, then used in the expression.
   - Example:
     ```java
     int x = 5;
     int y = ++x; // x = 6, y = 6
     ```

2. **Post-Increment (x++) / Post-Decrement (x--)**
   - The value is **used first**, then updated.
   - Example:
     ```java
     int x = 5;
     int y = x++; // y = 5, x = 6
     ```

---

## 2. Memory Management in Java

Java divides memory into two main parts:

### 🔹 Heap Memory

- Stores **objects** and **class instances**.
- Shared across all threads.
- Managed by **Garbage Collector**.
- Example: Objects created using `new` keyword reside here.

### 🔹 Stack Memory

- Stores **method calls**, **local variables**, and **references** to objects.
- Each thread has its own stack.
- Operates on **LIFO (Last In First Out)** principle.

---

## 3. Different Areas in Stack

The stack contains several sections:

- **Method Call Frames**: One for each method invoked.
- **Local Variables**: Primitives and references declared in the method.
- **Operand Stack**: Temporary data for computations.
- **Return Address**: Where to go after method finishes.
- **Dynamic Link**: Pointer to the calling method's frame (for returning).

---

## 4. Stack Unwinding

Stack unwinding occurs when a method exits (either normally or due to an exception), and its stack frame is removed.

### During Exception:

- If an exception is thrown and not caught in the current method, the stack **"unwinds"** by popping frames.
- This continues until:
  - A suitable catch block is found.
  - Or program terminates (if not caught).

Example:
```java
void a() { b(); }
void b() { c(); }
void c() { throw new RuntimeException(); }
