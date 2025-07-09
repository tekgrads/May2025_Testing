
# Synchronization, Locks, and Inter-Thread Communication in Java

Java provides robust tools for handling multithreaded applications. Understanding **Synchronization**, **Locks**, and **Inter-Thread Communication** is essential for writing thread-safe and efficient code.

---

## 🔒 Synchronization in Java

### What is Synchronization?
Synchronization ensures that only one thread can access a shared resource at a time, preventing **race conditions** and data inconsistencies.

### Types of Synchronization

#### 1. Synchronized Method
```java
public synchronized void printTable(int n) {
    // only one thread can access this method at a time
}
```

#### 2. Synchronized Block
```java
synchronized(this) {
    // block of code for thread-safe execution
}
```

#### 3. Static Synchronization
```java
synchronized static void printStatic() {
    // synchronizing static methods
}
```

---

## 🔐 Locks in Java

Java provides more control and flexibility with **Locks** through the `java.util.concurrent.locks` package.

### ReentrantLock Example
```java
import java.util.concurrent.locks.ReentrantLock;

class Counter {
    private final ReentrantLock lock = new ReentrantLock();
    private int count = 0;

    public void increment() {
        lock.lock();
        try {
            count++;
        } finally {
            lock.unlock();
        }
    }

    public int getCount() {
        return count;
    }
}
```

### Key Methods of ReentrantLock
- `lock()` – Acquires the lock.
- `unlock()` – Releases the lock.
- `tryLock()` – Tries to acquire the lock without blocking.
- `lockInterruptibly()` – Acquires the lock unless the thread is interrupted.

### Fairness
```java
ReentrantLock lock = new ReentrantLock(true);  // fair lock
```

---

## 🔁 Inter-Thread Communication

### Why Inter-Thread Communication?
Allows threads to **coordinate and share state**, reducing CPU usage compared to busy waiting.

### Methods Used
- `wait()` – Causes the current thread to wait until another thread invokes `notify()` or `notifyAll()` on the same object.
- `notify()` – Wakes up a single thread waiting on the object's monitor.
- `notifyAll()` – Wakes up all threads waiting on the object's monitor.

### Example
```java
class SharedResource {
    boolean available = false;

    synchronized void produce() {
        while (available) {
            try { wait(); } catch (InterruptedException e) {}
        }
        System.out.println("Produced item");
        available = true;
        notify();
    }

    synchronized void consume() {
        while (!available) {
            try { wait(); } catch (InterruptedException e) {}
        }
        System.out.println("Consumed item");
        available = false;
        notify();
    }
}
```

---

## 🚫 Deadlock

Occurs when two or more threads are waiting for each other to release resources. Common in synchronized blocks or when using multiple locks.

### How to Prevent Deadlock
- Always acquire locks in a consistent order.
- Use `tryLock()` to avoid indefinite blocking.
- Avoid holding multiple locks when possible.

---

## 🧵 Summary

| Concept                    | Description |
|---------------------------|-------------|
| Synchronization           | Ensures mutual exclusion for critical sections. |
| Locks                     | Advanced locking mechanism with better control. |
| Inter-thread Communication| Helps threads work together and share data. |

---

## ✅ Conclusion

Using **Synchronization**, **Locks**, and **Inter-Thread Communication** properly is critical to developing reliable, thread-safe applications in Java. Mastering these tools allows developers to build responsive and scalable systems.

