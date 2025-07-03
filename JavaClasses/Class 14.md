# 📘 Class 14: (26/06/2025)

## 🔷 MULTITHREADING IN JAVA

---

### 🔹 **Multithreading**
- Capability of the **CPU** to provide **concurrent execution** of multiple threads within a single program.
- Threads run **independently** but share the same memory.

---

### 🔹 **Multitasking**
- Ability of the **Operating System (OS)** or program to **perform multiple tasks simultaneously**.
- Example: Listening to music while browsing.

---

### 🔹 **Preemptive Execution**
- The **CPU decides** which thread or task to run.
- It can **interrupt one thread** to switch to another, even if the first thread hasn't finished.
- Used in modern operating systems for fairness and responsiveness.

---

### 🔹 **Synchronous Execution**
- Tasks are performed **one after another**.
- **Each task waits** for the previous one to finish before starting.

---

### 🔹 **Asynchronous Execution**
- Tasks are performed **independently**.
- A task **does not wait** for the previous one to finish.
- Improves performance when waiting for slow operations like I/O.

---

## 🛠️ How to Create a Thread?

### ✅ Method 1: Extending the `Thread` class

```java
class MyThread extends Thread {
    public void run() {
        System.out.println("Thread is running...");
    }
}

public class Test {
    public static void main(String[] args) {
        MyThread t1 = new MyThread();
        t1.start(); // starts the thread
    }
}
```

> `start()` method calls `run()` internally and begins a new thread.

---

## 🧠 Thread Scheduler

- Part of the **JVM** that decides **which thread runs next** when multiple threads are ready.
- Scheduling is **non-deterministic**; order of execution **cannot be predicted**.

---

## 👨‍👦 Main Thread and Child Thread Example

```java
class ChildThread extends Thread {
    public void run() {
        for (int i = 0; i < 5; i++) {
            System.out.println("Child Thread: " + i);
        }
    }
}

public class Test {
    public static void main(String[] args) {
        ChildThread t = new ChildThread();
        t.start(); // child thread

        for (int i = 0; i < 5; i++) {
            System.out.println("Main Thread: " + i);
        }
    }
}
```

🧾 **Output (sample, may vary):**
```
Main Thread: 0
Child Thread: 0
Main Thread: 1
Child Thread: 1
...
```

> Both threads run **concurrently**; output order is not fixed.

---

## 🔄 Thread Life Cycle

1. **New**  
   - Thread is created using `new Thread()`

2. **Runnable**  
   - After calling `start()`, thread is ready to run but waiting for CPU

3. **Running**  
   - Thread is **executing** its `run()` method

4. **Blocked/Waiting**  
   - Thread is **paused** (e.g., waiting for I/O or lock)

5. **Terminated (Dead)**  
   - Thread **finishes** or is **stopped**

### 🖼️ Diagram Overview:
```
New --> Runnable --> Running --> Terminated
                    ↘
                 Waiting / Blocked
```

---

Let me know if you'd like a diagram image or examples using `Runnable` interface too!
