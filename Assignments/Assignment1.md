# ☕ Stack Memory in Java (Made Easy)

---

## 🔹 What is Stack Memory?

**Stack Memory** is a part of memory that Java uses to:

- Run methods
- Store method parameters (inputs)
- Store local variables (created inside methods)
- Remember where to go back after a method finishes

✅ Managed by the **JVM (Java Virtual Machine)**.

---

## 🔑 Key Features of Stack Memory

| Feature       | What It Means                                                                 |
|---------------|--------------------------------------------------------------------------------|
| 🧠 Stores      | Local variables, method parameters, and object **references** (not the objects) |
| 🔒 Thread-safe | Each thread gets its **own private stack**                                    |
| ⏳ Temporary   | Memory is **given** when a method starts, and **removed** when it ends         |
| 🚀 Fast        | Works like a **stack** (Last In, First Out – LIFO), which is very quick        |

---

## 🧱 How Stack Memory Works

Every time a method is called, Java makes a **Stack Frame** (a small memory box):

|-------------------------| ← Top of stack (latest method)
| Stack Frame: methodC() |

Stack Frame: methodB()
Stack Frame: methodA()
-------------------------

yaml
Copy
Edit

- Each method gets its own **stack frame**
- When a method finishes, its frame is **removed** from the stack  
  👉 This is called **stack unwinding**

---

## 🔍 What's Inside a Stack Frame?

| Part             | Description                                                                 |
|------------------|-----------------------------------------------------------------------------|
| 🧮 Local Variables | Variables created inside the method                                         |
| 📥 Method Parameters | Values passed into the method (like inputs)                              |
| 🔧 Operand Stack   | Used for temporary calculations by the JVM                                 |
| 🔙 Return Address  | Tells JVM **where to go back** after the method ends                       |

---

## 📌 Why Stack Memory is Useful

| Feature             | Description                                      |
|---------------------|--------------------------------------------------|
| ⚡ Fast              | LIFO makes execution quick and efficient         |
| ✅ Auto-managed      | JVM automatically handles it                     |
| ⛔ Limited size      | If too deep (like infinite recursion), crash!    |
| 🔐 Thread-specific   | Every thread has its own separate stack memory   |

---

## 🆚 Stack vs Heap Memory

| Feature         | Stack Memory                      | Heap Memory                             |
|------------------|------------------------------------|------------------------------------------|
| Scope            | Per thread                         | Shared by all threads                    |
| Stores           | Method calls, local variables      | Objects and class-level variables        |
| Speed            | Very fast                          | Slower than stack                        |
| Lifespan         | Short (ends with method)           | Long (until garbage collected)           |
| Managed by       | JVM automatically                  | JVM Garbage Collector                    |
| Common Errors    | StackOverflowError (too deep call) | OutOfMemoryError (too many objects)      |

---

## 🧭 Example: Execution Flow

```java
public class Test {
    public static void main(String[] args) {
        methodA();               // Step 1
    }

    static void methodA() {
        int x = 5;               // Step 2
        methodB(x);              // Step 3
    }

    static void methodB(int y) {
        int z = y + 10;          // Step 4
        System.out.println("z: " + z); // Step 5
    }
}
🔄 Stack Flow (Step by Step):
main() method → pushed onto stack

methodA() → pushed

methodB() → pushed

methodB() finishes → removed

methodA() finishes → removed

main() finishes → removed

🧠 This is how Java keeps track of what to do and where to return after a method is done.

✅ Summary
Stack memory is temporary and fast

It manages method calls and local variables

Each thread has its own stack

JVM takes care of memory allocation/deallocation

Used in every Java program behind the scenes!