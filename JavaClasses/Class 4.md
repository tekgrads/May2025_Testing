# ☕ Java Notes - Class 4 (07/06/2025)

---

## 🧭 Command Line Usage

- `-d` command: used to specify the destination for `.class` files.
  ```bash
  javac -d ../classes A.java  # go one directory up and place .class files there
  cd ../classes
  java A
  ```

---

## 🧬 Java Environment

- **Which environment identifies `java` and `javac` commands?**  
  ➤ `PATH` environment variable

---

## 🧠 Variables

### 🔸 Local Variable
- Declared **inside** a method

### 🔹 Global Variable
- Declared **inside** a class (but outside methods)

### ⚠️ Variable Initialization
- A declared variable must be initialized before use  
  Example:
  ```java
  int i = 0;
  ```

---

## 🔁 Increments in Java

### Post-Increment: `i++`
- Assign current value, then increment.
- Internally uses a temporary variable.
- Initialization happens first, then value increases.

### Pre-Increment: `++i`
- Increment first, then initialize or use.

---

## 🛠 VS Code Setup for Java Development

1. Install **Visual Studio Code**
2. Recommended Extensions:
   - ✅ VS Code Icons
   - ✅ Prettier
   - ✅ Live Preview (for HTML)
   - ✅ Java Run
   - ✅ Code Runner (for JavaScript)
3. Enable:
   - `Mouse Wheel Zoom` in VS Code settings for better accessibility.

---

## 💾 Memory Management in Java

### Frequently Used Memories:
- **Hard Disk** & **RAM**

### Stack Memory:
- Used for **execution**

### Heap Memory:
- Used for **storage**

---

## 🔧 Working Process of Java Execution

1. `java` command starts execution in **stack memory**
2. Stack identifies space in **heap memory**
3. Class area is created inside heap
4. Static members (`main`, methods) are loaded
5. Initialization of static variables happens (if any)
6. `main()` is brought into **stack memory** for execution
7. Inside `main()`, `System.out.println("Hello")` is executed
8. If `main()` calls another method `A()`, it's loaded into stack
9. Method `A()` executes in the stack, then gets removed (stack unwinding)
10. Control returns to `main()`, finishes execution and is removed
11. `java` process is then cleared from stack memory

---

## 🔄 Stack Unwinding Operation

- The process of **removing methods** from the stack after execution.
- Follows **LIFO (Last In, First Out)** order.

---

## ⚠️ Stack Overflow Error

- Occurs when:
  - Too much memory is used on the stack
  - Typically from **infinite recursion**
- Leads to a **crash** as call stack exceeds its limit.

---

## ⚔️ Local vs Global Variable Conflict

- **Preference is given to the local variable** when both local and global variables exist with the same name.

---

## 🔍 Further Topics to Explore

- Stack's internal areas (e.g., **method area**, call stack layout, etc.)

---
