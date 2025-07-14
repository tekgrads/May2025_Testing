# Multithreading in Java

## What is Multithreading?

**Multithreading** in Java is a process of executing two or more threads simultaneously for maximum CPU utilization. Each thread runs in parallel, performing independent tasks.

### Key Concepts:

* **Thread**: A lightweight sub-process, the smallest unit of processing.
* **Multitasking**: Performing multiple tasks at the same time.
* **Concurrency**: Executing multiple threads simultaneously.

---

## Advantages of Multithreading

* Efficient CPU utilization
* Perform multiple operations simultaneously
* Saves time
* Useful for games, animation, real-time systems

---

## Creating Threads in Java

### 1. By extending the `Thread` class

```java
class MyThread extends Thread {
    public void run() {
        System.out.println("Thread is running...");
    }

    public static void main(String[] args) {
        MyThread t1 = new MyThread();
        t1.start(); // start() calls run() internally
    }
}
```

### 2. By implementing the `Runnable` interface

```java
class MyRunnable implements Runnable {
    public void run() {
        System.out.println("Runnable thread is running...");
    }

    public static void main(String[] args) {
        MyRunnable r = new MyRunnable();
        Thread t1 = new Thread(r);
        t1.start();
    }
}
```

---

## Thread Lifecycle

1. **New** – Thread is created.
2. **Runnable** – Thread is ready to run.
3. **Running** – Thread is executing.
4. **Blocked/Waiting** – Waiting to acquire lock or resource.
5. **Terminated** – Execution complete.

---

## Important Thread Methods

| Method      | Description                           |
| ----------- | ------------------------------------- |
| `start()`   | Starts the thread                     |
| `run()`     | Entry point for the thread            |
| `sleep(ms)` | Makes thread sleep for given time     |
| `join()`    | Waits for a thread to die             |
| `isAlive()` | Checks if thread is alive             |
| `yield()`   | Pauses the current thread temporarily |

### Example:

```java
class Demo extends Thread {
    public void run() {
        for (int i = 1; i <= 5; i++) {
            System.out.println(i);
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                System.out.println(e);
            }
        }
    }

    public static void main(String[] args) {
        Demo t1 = new Demo();
        t1.start();
    }
}
```

---

## Thread Synchronization

When multiple threads try to access a shared resource, **synchronization** is used to prevent inconsistency.

### Synchronized Method Example:

```java
class Table {
    synchronized void printTable(int n) {
        for (int i = 1; i <= 5; i++) {
            System.out.println(n * i);
            try { Thread.sleep(400); } catch (Exception e) {}
        }
    }
}

class MyThread1 extends Thread {
    Table t;
    MyThread1(Table t) {
        this.t = t;
    }
    public void run() {
        t.printTable(5);
    }
}
```

---

## Daemon Threads

* Low-priority threads that run in the background.
* Dies when main thread finishes.

### Example:

```java
public class DaemonExample extends Thread {
    public void run() {
        if (Thread.currentThread().isDaemon()) {
            System.out.println("Daemon thread working");
        } else {
            System.out.println("User thread working");
        }
    }
    public static void main(String[] args) {
        DaemonExample t1 = new DaemonExample();
        DaemonExample t2 = new DaemonExample();
        t1.setDaemon(true);  // must be set before start()
        t1.start();
        t2.start();
    }
}
```

---

