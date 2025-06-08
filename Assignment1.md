# 🧠 Analyze Different Memory Areas of Stack (Java JVM)

In the **Java Virtual Machine (JVM)**, the **stack memory** is essential for method execution and managing function calls. Each thread in Java has its own **stack**, and it operates in a **Last In First Out (LIFO)** manner.

Below is a detailed analysis of the different memory areas of the stack:

---

## 1. 📦 Stack Frames

Each time a method is invoked, the JVM creates a **stack frame** and pushes it onto the stack.  
When the method completes, its frame is popped off the stack (this is called **stack unwinding**).

Each **Stack Frame** contains:
- Local Variable Array
- Operand Stack
- Frame Data (Control Information)

---

## 2. 🧮 Local Variable Array

- Stores:
  - Method parameters
  - Local variables (e.g., `int`, `float`, object references)
- Indexed for fast access.
- Only accessible within that method.

### 📌 Example:
```java
void add(int a, int b) {
    int sum = a + b; // All these values are stored in the local variable array
}
```

---

## 3. 🧰 Operand Stack

- A temporary storage used to:
  - Evaluate expressions
  - Hold intermediate computation results
- Works in **push and pop** fashion.
- JVM bytecode instructions operate on this stack.

### 📌 Example:
For this code:
```java
int c = a + b;
```
- JVM pushes `a` and `b` onto the operand stack.
- Performs the addition.
- Stores the result in `c`.

---

## 4. 🔁 Frame Data / Control Information

This area stores:
- Return address (to resume execution after method completes)
- Dynamic linking information
- Exception handling information

It ensures the correct **control flow** and method resolution at runtime.

---

## 5. 📍 Program Counter (PC) Register

> Though not part of the stack frame itself, it's **closely associated with stack-based execution.**

- Each thread has its own **PC Register**.
- Stores the **address of the currently executing bytecode instruction**.
- Updates as the JVM moves through the method.

---

## 🔄 Execution Flow in Stack

1. Method is called → JVM pushes a new **stack frame**.
2. Method executes using the **local variable array** and **operand stack**.
3. After method finishes → **stack frame is removed**.
4. JVM resumes execution from the previous method frame.
5. This cleanup is called **stack unwinding**.

---

## 🚨 Stack Overflow Error

A **Stack Overflow Error** occurs when:
- There are **too many method calls** (e.g., infinite recursion).
- The stack grows beyond its allocated size.
- JVM crashes due to exhausted stack memory.

---

## ✅ Summary Table

| Stack Area             | Purpose                                                  |
|------------------------|----------------------------------------------------------|
| **Stack Frame**        | Holds all data related to a method call                  |
| **Local Variable Array** | Stores method arguments and local variables             |
| **Operand Stack**      | Used for temporary computations and expression evaluation|
| **Frame Data**         | Manages return addresses and exception handling info     |
| **PC Register**        | Points to the current bytecode instruction               |

---

📚 **End of Stack Memory Analysis**
