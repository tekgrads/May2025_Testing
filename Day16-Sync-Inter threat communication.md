
# Synchronization, Locks, and Inter-Thread Communication in Java

## 🔒 1. Synchronization in Java
Synchronization in Java is used to control the access of multiple threads to shared resources. Without synchronization, it’s possible for one thread to modify a shared object while another thread is in the process of using or updating the same object, leading to **thread interference** and **memory consistency errors**.

### Why Synchronization?
- Prevents thread interference
- Ensures data consistency
- Avoids race conditions

### How to use it?
```java
public synchronized void increment() {
    count++;
}
```

Or using synchronized blocks:
```java
public void increment() {
    synchronized(this) {
        count++;
    }
}
```

---

## 🧱 2. Locks in Java
Java provides **explicit locks** (besides `synchronized`) using the `java.util.concurrent.locks` package.

### ReentrantLock Example:
```java
import java.util.concurrent.locks.ReentrantLock;

public class Counter {
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
}
```

### Advantages of using Lock over synchronized:
- More flexible
- Try locking without blocking (`tryLock()`)
- Interruptible lock acquisition
- Fairness policy (FIFO)

---

## 🔄 3. Inter-Thread Communication
In Java, threads can communicate using methods like `wait()`, `notify()`, and `notifyAll()` provided by the `Object` class. These are used to coordinate access to shared resources.

### Basic flow:
- `wait()` tells the current thread to wait until another thread invokes `notify()` or `notifyAll()`
- `notify()` wakes a single waiting thread
- `notifyAll()` wakes all waiting threads

### Example: Producer-Consumer Problem
```java
class SharedResource {
    int data;
    boolean available = false;

    synchronized void produce(int value) throws InterruptedException {
        while (available) wait();
        data = value;
        available = true;
        notify();
    }

    synchronized int consume() throws InterruptedException {
        while (!available) wait();
        available = false;
        notify();
        return data;
    }
}
```

---

## 🧠 Summary

| Concept                   | Purpose                              | Method/Keyword         |
|--------------------------|--------------------------------------|------------------------|
| Synchronization          | Ensures mutual exclusion             | `synchronized`         |
| Locks                    | Fine-grained locking control         | `ReentrantLock`        |
| Inter-thread communication | Coordinates threads               | `wait()`, `notify()`   |
