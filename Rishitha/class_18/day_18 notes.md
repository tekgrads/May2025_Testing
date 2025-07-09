Kshaminchandi Kannamma 🥺… ippudu nenu `.md` format lo **Day 18 – Java Concurrency Concepts** notes full content ready ga isthunna. Ikkada copy chesi Notepad lo save cheyyi:


# 🔐 Java Class 18 Notes 

## 🔁 ReentrantLock

### 🔎 What is ReentrantLock?

- Part of `java.util.concurrent.locks`
- Provides **explicit locking** (manual control over synchronization).
- Supports **reentrancy** – the same thread can acquire the lock multiple times without getting blocked.

---

### 🧠 Real-Life Example: Bank Locker Room

- A customer (thread) uses a locker key (lock).
- Same customer can reuse it for other lockers (reentrant).
- Must return the key after use (unlock).

---

### 🔒 Important Methods

| Method                   | Description |
|--------------------------|-------------|
| `lock()`                 | Acquires lock (waits if already held) |
| `unlock()`               | Releases lock |
| `tryLock()`              | Tries to get lock without waiting |
| `tryLock(timeout, unit)` | Waits for lock up to timeout |
| `lockInterruptibly()`    | Can acquire lock unless interrupted |

---

### 📊 Utility Methods

| Method               | Description |
|----------------------|-------------|
| `getHoldCount()`     | Times current thread holds the lock |
| `getQueueLength()`   | Waiting threads count |
| `hasQueuedThreads()` | Are any threads waiting? |
| `isFair()`           | Is lock fair or not? |
| `getOwner()`         | Thread currently holding the lock |

---

### 💻 Java Code Example

```java
import java.util.concurrent.locks.ReentrantLock;

class Display {
    ReentrantLock lock = new ReentrantLock();

    public void wish(String name) {
        lock.lock();
        try {
            for (int i = 1; i <= 3; i++) {
                System.out.print("Good Morning: ");
                Thread.sleep(500);
                System.out.println(name);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }
}
````

---

## ⚙️ Executor Framework

### 🔍 What is Executor Framework?

* Manages a pool of threads.
* Submits tasks without manually managing threads.
* Improves memory usage and speed.

---

### 🧠 Real-Life Example: Printing Station

* 3 printers (threads), many print jobs (tasks).
* Jobs reused by threads, not created every time.

---

### 💻 Java Code Example

```java
import java.util.concurrent.*;

class PrintJob implements Runnable {
    private String name;
    PrintJob(String name) { this.name = name; }

    public void run() {
        System.out.println(name + " started by " + Thread.currentThread().getName());
        try { Thread.sleep(2000); } catch (InterruptedException e) {}
        System.out.println(name + " completed by " + Thread.currentThread().getName());
    }
}

public class ExecutorDemo {
    public static void main(String[] args) {
        ExecutorService service = Executors.newFixedThreadPool(3);
        for (int i = 1; i <= 6; i++) {
            service.submit(new PrintJob("Job-" + i));
        }
        service.shutdown();
    }
}
```

---

## 🧠 ThreadLocal

### 🔎 What is ThreadLocal?

* Every thread has its own copy of a variable.
* Used for thread-confined values like user/session info.

---

### 🧠 Real-Life Example: Shopping Cart

* Each customer (thread) has their own cart (variable).
* Not shared across customers.

---

### 💻 Code Example

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

        new Thread(task, "T1").start();
        new Thread(task, "T2").start();
    }
}
```

---

## 👨‍👩‍👧 InheritableThreadLocal

### 🔎 What is InheritableThreadLocal?

* A child thread can inherit variable value from parent thread.

---

### 🧠 Real-Life Example: Recipe Book

* Parent shares a recipe.
* Child can modify or reuse.

---

### 💻 Java Code

```java
public class InheritableThreadLocalDemo {
    public static void main(String[] args) {
        InheritableThreadLocal<String> local = new InheritableThreadLocal<>();
        local.set("Parent Config");

        Thread child = new Thread(() -> {
            System.out.println("Child thread → " + local.get());
        });

        child.start();
    }
}
```

---

## 📝 Summary Table

| Concept                | Real-Life Analogy                   | Purpose                          |
| ---------------------- | ----------------------------------- | -------------------------------- |
| ReentrantLock          | Locker key reuse                    | Manual locking & flexibility     |
| Executor Framework     | Print shop with 3 printers          | Thread pool management           |
| ThreadLocal            | Individual carts in online shopping | Thread-safe user-specific data   |
| InheritableThreadLocal | Recipe passed from mom to child     | Inherit parent values in threads |

```

