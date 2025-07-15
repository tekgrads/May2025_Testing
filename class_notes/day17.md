
# Java Concepts: Deadlock and Daemon Threads

## 1. Deadlock in Java

### What is Deadlock?

A **deadlock** is a situation in multithreaded programming where **two or more threads are waiting forever** for resources locked by each other. This causes the threads to be stuck indefinitely.

### Example Scenario

- Thread 1 locks Resource A and waits for Resource B
- Thread 2 locks Resource B and waits for Resource A

Both threads wait for each other to release resources, causing a deadlock.

### Code Example

```java
class A {
    synchronized void methodA(B b) {
        System.out.println("Thread 1: locked A");
        try { Thread.sleep(100); } catch (Exception e) {}
        b.last();
    }

    synchronized void last() {
        System.out.println("Inside A.last()");
    }
}

class B {
    synchronized void methodB(A a) {
        System.out.println("Thread 2: locked B");
        try { Thread.sleep(100); } catch (Exception e) {}
        a.last();
    }

    synchronized void last() {
        System.out.println("Inside B.last()");
    }
}

public class DeadlockDemo implements Runnable {
    A a = new A();
    B b = new B();

    DeadlockDemo() {
        Thread t = new Thread(this);
        t.start();
        a.methodA(b); // main thread
    }

    public void run() {
        b.methodB(a); // child thread
    }

    public static void main(String[] args) {
        new DeadlockDemo();
    }
}
```

### How to Prevent Deadlock

- Avoid nested synchronized blocks
- Use a lock hierarchy
- Use timeout for locks (e.g., `tryLock()` in `ReentrantLock`)

---

## 2. Daemon Threads in Java

### What is a Daemon Thread?

A **daemon thread** is a background service thread that provides support to other threads. It runs in the background and **does not prevent the JVM from exiting**.

### Key Features

- Daemon threads are **low priority** threads.
- When all user threads finish, JVM exits even if daemon threads are running.
- Common examples: **Garbage Collector**, background loggers, etc.

### How to Create a Daemon Thread

```java
public class DaemonExample extends Thread {
    public void run() {
        if (Thread.currentThread().isDaemon()) {
            System.out.println("Daemon thread is running");
        } else {
            System.out.println("User thread is running");
        }
    }

    public static void main(String[] args) {
        DaemonExample t1 = new DaemonExample();
        DaemonExample t2 = new DaemonExample();

        t1.setDaemon(true); // Set t1 as daemon before starting

        t1.start();
        t2.start();
    }
}
```

### Important Points

- Call `setDaemon(true)` **before** starting the thread.
- You cannot make a thread daemon **after it has started** — it will throw `IllegalThreadStateException`.

---

