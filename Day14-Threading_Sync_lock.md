
# Multithreading in Java

Multithreading in Java is a technique that allows concurrent execution of two or more parts of a program to maximize CPU utilization. Each part is called a thread, and each thread defines a separate path of execution.

---

## 🧵 Threading in Java

### What is a Thread?
A **thread** is a lightweight subprocess, the smallest unit of processing. Java supports multithreading, which allows multiple threads to run concurrently.

### Creating Threads
You can create threads in Java using two approaches:

#### 1. Extending the `Thread` class
```java
class MyThread extends Thread {
    public void run() {
        System.out.println("Thread is running");
    }
    public static void main(String args[]) {
        MyThread t1 = new MyThread();
        t1.start();  // starts the thread
    }
}
```

#### 2. Implementing the `Runnable` interface
```java
class MyRunnable implements Runnable {
    public void run() {
        System.out.println("Runnable thread is running");
    }
    public static void main(String args[]) {
        Thread t1 = new Thread(new MyRunnable());
        t1.start();
    }
}
```

---

## 🔄 Synchronization in Java

### Why Synchronization?
When multiple threads access shared resources (like variables or objects), there is a risk of **race conditions**. Synchronization is used to ensure only one thread accesses a block of code at a time.

### Synchronized Method
```java
public synchronized void increment() {
    count++;
}
```

### Synchronized Block
```java
synchronized(this) {
    count++;
}
```

### Static Synchronization
```java
synchronized static void display() {
    // code
}
```

---

## 🔐 Locking in Java

Java provides more advanced thread control using the `java.util.concurrent.locks` package.

### ReentrantLock
```java
import java.util.concurrent.locks.ReentrantLock;

class Example {
    private final ReentrantLock lock = new ReentrantLock();

    public void safeMethod() {
        lock.lock();
        try {
            // critical section
            System.out.println("Thread-safe operation");
        } finally {
            lock.unlock();
        }
    }
}
```

### Features of Locks
- Can try to acquire without blocking using `tryLock()`
- Can interrupt lock acquisition with `lockInterruptibly()`
- Can provide fairness (queue-like behavior)

---

## 🔄 Thread Communication

Java uses:
- `wait()` – Makes the current thread wait until another thread calls `notify()` or `notifyAll()`.
- `notify()` – Wakes up a single waiting thread.
- `notifyAll()` – Wakes up all waiting threads.

```java
synchronized(obj) {
    while(condition) {
        obj.wait();
    }
    // continue once notified
}
```

---

## ⚠️ Deadlock and Avoidance

### Deadlock
Occurs when two or more threads are waiting for each other to release resources, causing all of them to block indefinitely.

### Avoiding Deadlock
- Avoid nested locks.
- Acquire locks in a consistent order.
- Use `tryLock()` with timeout.

---

## ✅ Daemon Threads

Daemon threads run in the background to support user threads.
```java
Thread t = new Thread(new Task());
t.setDaemon(true);
t.start();
```

---

## 🔚 Conclusion

Multithreading, Synchronization, and Locking are essential concepts in Java for building high-performance and thread-safe applications. Java offers simple constructs like `synchronized` as well as advanced features like `ReentrantLock` to manage concurrency effectively.

