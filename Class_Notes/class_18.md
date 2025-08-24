
###  Locks, ReentrantLock & Executor Framework in Java 

# Locks, Reentrant Locks & Executor Framework in Java (with Examples and Output)

##  1. What is a Lock?
A `Lock` is an alternative to the `synchronized` keyword in Java. It offers more flexibility and control over thread synchronization.

Java provides several lock implementations in the `java.util.concurrent.locks` package.

---

##  2. ReentrantLock

- A `ReentrantLock` is a **mutual exclusion lock** with the same basic behavior as the implicit monitor lock accessed using `synchronized` methods and blocks.
- It allows a thread to **re-enter** into the lock it already holds.

###  Example: Using ReentrantLock with `lock()` and `unlock()`
```java
import java.util.concurrent.locks.ReentrantLock;

class ReLockDemo {
    private final ReentrantLock lock = new ReentrantLock();

    void print() {
        lock.lock();
        try {
            for (int i = 0; i < 3; i++) {
                System.out.println(Thread.currentThread().getName() + " printing " + i);
                Thread.sleep(300);
            }
        } catch (InterruptedException e) {
            System.out.println(e);
        } finally {
            lock.unlock();
        }
    }

    public static void main(String[] args) {
        ReLockDemo demo = new ReLockDemo();

        Runnable task = () -> demo.print();
        Thread t1 = new Thread(task, "Thread-A");
        Thread t2 = new Thread(task, "Thread-B");

        t1.start();
        t2.start();
    }
}
````

####  Output:

```
Thread-A printing 0
Thread-A printing 1
Thread-A printing 2
Thread-B printing 0
Thread-B printing 1
Thread-B printing 2
```

---

##  3. `lock()` and `unlock()`

* `lock()` acquires the lock (blocks if already held by another thread).
* `unlock()` releases the lock.
* Always place `unlock()` in a `finally` block to avoid deadlocks.

---

##  4. Executor Framework

###  What is Executor Framework?

Java provides the **Executor Framework** to manage thread execution efficiently without manually managing `Thread` objects.

It includes:

* `ExecutorService`
* `Executors`
* `Callable` and `Future`

###  Example: Using `Executors.newFixedThreadPool()`

```java
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

class Task implements Runnable {
    private final String name;

    Task(String name) {
        this.name = name;
    }

    public void run() {
        System.out.println(Thread.currentThread().getName() + " is executing " + name);
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            System.out.println(e);
        }
    }
}

public class ExecutorExample {
    public static void main(String[] args) {
        ExecutorService executor = Executors.newFixedThreadPool(2);

        for (int i = 1; i <= 4; i++) {
            executor.execute(new Task("Task-" + i));
        }

        executor.shutdown();
    }
}
```

####  Output:

```
pool-1-thread-1 is executing Task-1
pool-1-thread-2 is executing Task-2
pool-1-thread-1 is executing Task-3
pool-1-thread-2 is executing Task-4
```


