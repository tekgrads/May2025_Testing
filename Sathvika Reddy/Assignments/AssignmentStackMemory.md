
# TG Assignment – Different Memory Areas of Stack – 08/06/25

## ✨ Introduction:
In Java, memory is primarily divided into two regions: **Stack** and **Heap**.  
- The **Heap** stores objects.  
- The **Stack** is used for execution – storing method calls, local variables, and control flow data.  

Every thread in Java has its own private stack, which helps in achieving thread safety for method execution.

Let us dive into the structure of Stack memory, its components, and how it works during a method call lifecycle.

---

## 📦 What is Stack Memory?
Stack memory is a **Last-In-First-Out (LIFO)** data structure.  
Whenever a method is invoked, a new **Stack Frame** is created and pushed onto the stack.  
Once the method completes execution, its frame is popped out.

📌 **Analogy:** Think of the stack like a pile of trays in a cafeteria. You keep placing a tray on top (method call), and when you're done, you take the top one off (method return).

---

## 🧩 Memory Areas Inside a Stack Frame:

### 1. Local Variable Array (Local Variables):
- Stores primitive values (`int`, `float`, `boolean`, etc.) and references to heap objects.
- Allocated at the beginning of method execution.
- Variables are only visible to the current method.

📌 **Example:**
```java
public void add(int a, int b) {
    int result = a + b;
}
```
In this example, `a`, `b`, and `result` are stored in the local variable array.

---

### 2. Operand Stack:
- Temporary workbench for intermediate results.
- Used by the JVM during bytecode execution to push/pop operands and results.

📌 **Example:**  
For the operation `result = a + b`, JVM pushes `a` and `b` to operand stack, adds them, and stores the result.

---

### 3. Frame Data / Control Information:
- Stores method return address, exception handling info, and dynamic linking data.
- Helps JVM resume execution after a method returns.
- Used internally by JVM for managing control flow.

📌 Think of this as the map that tells the JVM, "Once done here, go back there!"

---

## 📊 Visual Representation of a Stack Frame:

```
+------------------------+
| Frame Data             | ← Return address, dynamic linking
+------------------------+
| Operand Stack          | ← Intermediate results for operations
+------------------------+
| Local Variable Array   | ← a, b, result
+------------------------+
```

### Now, imagine multiple method calls:

```
+------------------------+  ← Method C (top of stack)
| Frame for method C     |
+------------------------+
| Frame for method B     |
+------------------------+
| Frame for method A     |
+------------------------+  ← Main method (bottom of stack)
```

As each method completes, its frame is popped off the stack.

---

## 🤹 Fun Analogy – Stack as a Call Tower:

Imagine you are a chef handling multiple orders.  
Each time an order comes in (method call), you put it on your "to-do" tray (stack frame). You work on the most recent one first (LIFO). Once you're done (method ends), you remove that tray and go back to the previous one.

Each tray has:
- **Ingredients** = Local variables  
- **Recipe steps** = Operand stack  
- **Customer address** = Return info  

---

## 💥 Stack Overflow Error:

If the stack memory exceeds its limit (e.g., due to deep or infinite recursion), the JVM throws a **StackOverflowError**.

📌 **Example:**
```java
public void infinite() {
    infinite();  // Recursion without base case
}
```
This keeps pushing new frames onto the stack until memory is exhausted.

---

## 🔁 Stack Unwinding:

When an exception is thrown or a method returns, stack frames are **unwound** in reverse order.  
JVM pops out frames one by one until it finds a suitable `catch` block or completes execution.

---

## 📌 Summary of Stack Memory Areas:

| Area                | Purpose                              | Example                           |
|---------------------|---------------------------------------|-----------------------------------|
| Local Variable Array| Store variables and references        | `int a = 5; String s = "hello";`  |
| Operand Stack       | Intermediate results during execution | `a + b`, `a * b`                  |
| Frame Data          | Return address, linking, control data | Where to return after method ends|

---

## 🔍 Always remember:
- **Stack = Temporary & Fast**  
- **Heap = Persistent & Shared**
