
# Assessment: Analyze Different Memory Areas of Stack

---

In Java, **stack memory** is a region in RAM used to manage the execution of threads and store method-level information. Each time a method is called, a **stack frame** is created to hold that method’s data. When the method completes, the frame is removed (popped) from the stack. Let’s analyze the different areas inside the **stack memory**:

---

## 🔹 1. Method Invocation Area (Call Stack)
- Stores **stack frames** for each method call.
- Follows **LIFO (Last-In-First-Out)** principle.
- Each frame contains:
  - Method name
  - Return address
  - Line number of code execution

🧠 *When a method is invoked, a frame is pushed; when it returns, the frame is popped.*

---

## 🔹 2. Local Variable Area
- Stores **local variables** declared inside the method.
- Includes primitives (like `int`, `char`) and references to objects (objects themselves go to heap).
- Each method has its own separate local variable area.

🧠 *Variables declared inside a method (like `int a = 10;`) are stored here.*

---

## 🔹 3. Operand Stack
- Temporarily stores **intermediate values** during computation.
- Used for operations like addition, subtraction, pushing and popping values.

🧠 *JVM uses this to calculate expressions during execution.*

---

## 🔹 4. Frame Data / Control Data
- Holds references to the **constant pool**, **exception table**, and **return address**.
- Helps JVM to maintain control of method execution and return flow.

🧠 *It helps resume the program after a method call completes.*

---

## 🔹 5. Exception Handling Area (Optional)
- Stores **exception handlers** related to the method.
- If an exception is thrown, the stack unwinds (removes frames one by one) until it finds a handler or crashes with an error.

🧠 *This is used for stack unwinding during exceptions.*

---

## ✨ Example Illustration:
```java
public class StackExample {
    public static void methodA() {
        int x = 10;
        methodB();
    }

    public static void methodB() {
        int y = 20;
    }

    public static void main(String[] args) {
        methodA();
    }
}
```

📌 When `main()` calls `methodA()`, then `methodA()` calls `methodB()`:
- Stack Frame for `main()` → pushed
- Stack Frame for `methodA()` → pushed
- Stack Frame for `methodB()` → pushed
- Each frame has its **local variables**, **control info**, and **execution context**

---

## 🚨 Stack Overflow Note:
If too many method calls happen (like recursion without base case), stack gets full → causes `StackOverflowError`.

---

## ✅ Conclusion:
Stack memory is essential for **method execution**, **local variable storage**, and **program flow control**. It ensures efficient use of memory and supports multi-threaded execution, as each thread has its own stack.
