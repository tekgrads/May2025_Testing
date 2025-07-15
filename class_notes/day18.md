# Java Concepts: ReentrantLock and Executor Framework

## 1. ReentrantLock in Java

### What is ReentrantLock?

`ReentrantLock` is a class in `java.util.concurrent.locks` package that provides **more control over synchronization** than the `synchronized` keyword.

It allows:
- More flexible locking
- Try locking without blocking
- Interrupting a thread waiting for a lock

### Key Features

- Reentrant means a thread can acquire the **same lock multiple times** without causing a deadlock.
- Offers methods like `lock()`, `unlock()`, `tryLock()`, and `lockInterruptibly()`.

### Example

```java
import java.util.concurrent.locks.ReentrantLock;

class Shared {
    ReentrantLock lock = new ReentrantLock();

    void print() {
        lock.lock();
        try {
            System.out.println(Thread.currentThread().getName() + " is executing");
        } finally {
            lock.unlock();
        }
    }
}

public class ReentrantLockExample {
    public static void main(String[] args) {
        Shared obj = new Shared();

        Runnable task = () -> {
            for (int i = 0; i < 3; i++) obj.print();
        };

        Thread t1 = new Thread(task, "Thread 1");
        Thread t2 = new Thread(task, "Thread 2");

        t1.start();
        t2.start();
    }
}
 common methods:
 
| Method                | Description                          |
| --------------------- | ------------------------------------ |
| `lock()`              | Acquires the lock                    |
| `unlock()`            | Releases the lock                    |
| `tryLock()`           | Attempts to acquire the lock         |
| `lockInterruptibly()` | Acquires the lock unless interrupted |


 Executor Framework in Java
What is the Executor Framework?
The Executor Framework is a part of java.util.concurrent package that provides a way to manage and control thread execution using thread pools.

It decouples task submission from thread creation.

Key Interfaces & Classes
Executor: The base interface with method execute(Runnable command).

ExecutorService: Extends Executor, adds methods like submit(), shutdown(), invokeAll().

Executors: A utility class to create thread pools.

Types of Thread Pools
Method	Description
Executors.newFixedThreadPool(n)	Fixed number of threads
Executors.newCachedThreadPool()	Unlimited threads reused on demand
Executors.newSingleThreadExecutor()	Single-threaded executor

Example
java
Copy
Edit
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

class Task implements Runnable {
    private String name;

    Task(String name) {
        this.name = name;
    }

    public void run() {
        System.out.println(name + " is running by " + Thread.currentThread().getName());
    }
}

public class ExecutorExample {
    public static void main(String[] args) {
        ExecutorService executor = Executors.newFixedThreadPool(2);

        for (int i = 1; i <= 5; i++) {
            executor.execute(new Task("Task " + i));
        }

        executor.shutdown(); // Always shutdown the executor
    }
}
Benefits of Executor Framework
Better resource management

Thread reuse (reduced overhead)

Easy to scale thread-based applications

