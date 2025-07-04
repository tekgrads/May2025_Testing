# 🔐 Java Class 18 Notes 

---

## 🔁 ReentrantLock

### 🔎 What is ReentrantLock?

- Part of `java.util.concurrent.locks`
- Provides **explicit locking** (manual control over synchronization).
- Supports **reentrancy** – the same thread can acquire the lock multiple times without getting blocked.

---

### 🧠 Real-Life Example: Bank Locker Room

- Think of a **locker room in a bank**.
- A customer (thread) enters the locker room (critical section) by acquiring a **locker key (lock)**.
- If they need to access **multiple lockers**, they can reuse the **same key** (reentrant lock).
- Once done, they must **return the key (unlock)**.

---

### 🔒 Important Methods

| Method                   | Description |
|--------------------------|-------------|
| `lock()`                 | Acquires lock (waits if already held) |
| `unlock()`               | Releases lock |
| `tryLock()`              | Tries to get lock without waiting |
| `tryLock(timeout, unit)` | Waits up to a time to acquire lock |
| `lockInterruptibly()`    | Acquires lock unless interrupted |

---

### 📊 Utility Methods

| Method               | Description |
|----------------------|-------------|
| `getHoldCount()`     | How many times current thread holds the lock |
| `getQueueLength()`   | How many threads are waiting |
| `hasQueuedThreads()` | Are any threads waiting? |
| `getQueuedThreads()` | Returns list of threads waiting |
| `isFair()`           | Checks fairness policy |
| `getOwner()`         | Returns thread currently holding the lock |

---

## 💻 Java Example: Using ReentrantLock

```java
import java.util.concurrent.locks.ReentrantLock;

class Display {
    ReentrantLock lock = new ReentrantLock();

    public void wish(String name) {
        lock.lock(); // Acquire lock
        try {
            for (int i = 1; i <= 3; i++) {
                System.out.print("Good Morning: ");
                Thread.sleep(500);
                System.out.println(name);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock(); // Always release
        }
    }
}
```

---

## ⚙️ Executor Framework

### 🔍 What is Executor Framework?

- Manages a pool of threads internally.
- Separates **task submission** from **thread execution**.
- Reuses threads → **better performance** and **memory efficiency**.

---

### 🧠 Real-Life Example: Printing Station

- Think of a **printing shop** with **3 printers**.
- Multiple customers submit print jobs.
- Instead of creating 1 printer per customer, **printers are reused** for each job.
- This is how a **Thread Pool** (Executor) works.

---

### 💻 Code Example: Print Job with Executor

```java
import java.util.concurrent.*;

class PrintJob implements Runnable {
    private String name;

    PrintJob(String name) {
        this.name = name;
    }

    public void run() {
        System.out.println(name + " started by " + Thread.currentThread().getName());
        try {
            Thread.sleep(2000); // Simulating print time
        } catch (InterruptedException e) {}
        System.out.println(name + " completed by " + Thread.currentThread().getName());
    }
}

public class ExecutorDemo {
    public static void main(String[] args) {
        ExecutorService service = Executors.newFixedThreadPool(3); // 3 printers

        for (int i = 1; i <= 6; i++) {
            PrintJob job = new PrintJob("Job-" + i);
            service.submit(job);
        }

        service.shutdown();
    }
}
```

---

## 🧠 ThreadLocal

### 🔎 What is ThreadLocal?

- Provides each thread with its **own isolated copy** of a variable.
- Prevents sharing data between threads.

---

### 🧠 Real-Life Example: Online Shopping Cart

- Each **user (thread)** on an e-commerce site has a **separate cart (ThreadLocal)**.
- Even if multiple users shop at the same time, their carts are **not mixed up**.
- Internally, a shared `ThreadLocal<Cart>` can store user-specific data **per thread**.

---

### 💻 Code Example:

```java
class UserService {
    private static ThreadLocal<String> currentUser = new ThreadLocal<>();

    public static void setUser(String user) {
        currentUser.set(user);
    }

    public static String getUser() {
        return currentUser.get();
    }
}

public class ThreadLocalDemo {
    public static void main(String[] args) {
        Runnable task = () -> {
            String threadName = Thread.currentThread().getName();
            UserService.setUser("User_" + threadName);
            System.out.println(threadName + " → " + UserService.getUser());
        };

        Thread t1 = new Thread(task, "T1");
        Thread t2 = new Thread(task, "T2");
        t1.start();
        t2.start();
    }
}
```

---

## 👨‍👩‍👧 InheritableThreadLocal

### 🔎 What is InheritableThreadLocal?

- A subclass of ThreadLocal.
- Allows **child threads** to inherit **values from parent thread**.

---

### 🧠 Real-Life Example: Shared Settings in Software

- A **parent thread** loads some **default config** or user preferences.
- Any **child threads** launched from it will **inherit the same preferences** unless overridden.

---

### 💻 Example:

```java
public class InheritableThreadLocalDemo {
    public static void main(String[] args) {
        InheritableThreadLocal<String> local = new InheritableThreadLocal<>();
        local.set("Parent Config");

        Thread child = new Thread(() -> {
            System.out.println("Child thread → " + local.get()); // Inherits value
        });

        child.start();
    }
}
```

---

## 📝 Summary Table

| Concept                | Real-Life Analogy                              | Purpose                          |
|------------------------|-----------------------------------------------|----------------------------------|
| ReentrantLock          | Bank locker with re-entry permission           | Manual locking with flexibility |
| Executor Framework     | Print shop with limited printers               | Thread pool management          |
| ThreadLocal            | Individual shopping carts for each user        | Thread-safe user-specific data  |
| InheritableThreadLocal | Parent thread passes config to child threads   | Inheriting thread context       |

---
