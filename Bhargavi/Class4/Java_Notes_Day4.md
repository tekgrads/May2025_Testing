
# ☕ Java Notes - Day 4 (07-06-2025)

## 🖥️ Command Line Usage in Java
Java command line usage involves compiling code with `javac` and executing it with `java`.

- `javac`: Compiles `.java` files into `.class` files.
- `java`: Runs the compiled `.class` files on the JVM.

**Which environment identifies `java` and `javac` commands?**  
➡️ **PATH environment variable**

---

## 🧠 Variables in Java

### 🔸 Local Variable
- Declared **inside a method**.

### 🔹 Global Variable
- Declared **inside a class** (but **outside methods**).

### ⚠️ Variable Initialization
- A declared variable **must be initialized before use**.

**Example:**
```java
int i = 0;
```

---

## 🔼 Increment in Java

**Incrementing** means increasing a variable’s value by `1` using the `++` operator.

Java supports two types of increment operators:

* **Post-increment (`i++`)**:
  Use current value, **then** increase by 1.

* **Pre-increment (`++i`)**:
  Increase by 1, **then** use the updated value.

---

## 💾 Memory Management in Java

### Frequently Used Memories:

* **Hard Disk**
* **RAM**

### Types of Memory:

* **Stack**:
  Stores **method calls** and **local variables**.

* **Heap**:
  Stores **objects** and **instance variables**.

---

## ⚙️ Working Process of Java Execution

1. `java` command starts execution in **stack memory**.
2. Stack identifies space in **heap memory**.
3. **Class area** is created inside the heap.
4. **Static members** (e.g., `main`, methods) are loaded.
5. **Static variables** are initialized (if any).
6. `main()` is brought into **stack memory** for execution.
7. Inside `main()`, `System.out.println("Hello")` is executed.
8. If `main()` calls another method `A()`, it's loaded into stack.
9. Method `A()` executes in the stack, then is removed (➡️ stack unwinding).
10. Control returns to `main()`, finishes execution and is removed.
11. Java process is cleared from stack memory.

---

## 🔄 Stack Unwinding Operation

* **Definition**:
  The process of **removing methods from the stack** after execution.

* **Order**:
  Follows **LIFO** (Last In, First Out).

---

## ❌ Stack Overflow Error

Occurs when:

* **Too much memory is used on the stack**
* Often caused by **infinite recursion**
* Leads to a **crash** as the call stack exceeds its limit.

---

## ⚔️ Local vs Global Variable Conflict

* If **local and global variables** have the same name,
  ➡️ **Local variable** is given **preference**.
