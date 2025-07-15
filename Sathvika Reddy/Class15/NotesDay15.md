# Java Notes – Multithreading (Threading, Synchronization, Locking):

---

### Threading

**Definition:**
Threading is the process of executing multiple parts of a program simultaneously using separate threads.
**Use:** Helps in achieving multitasking and efficient CPU utilization.

---

### Thread Scheduler

**Definition:**
Thread Scheduler is part of JVM responsible for deciding which thread runs at a given time.
**Use:** Controls execution order and time allocation for threads based on priority and availability.

---

### Thread using Runnable Interface

**Definition:**
A thread can be created by implementing the `Runnable` interface and passing it to a `Thread` object.
**Use:** Allows a class to extend another class while still being used as a thread.

```java
class MyRunnable implements Runnable {
    public void run() {
        System.out.println(Thread.currentThread().getName());
    }
}

public class GroupRunnable {
    public static void main(String[] args) {
        ThreadGroup tg = new ThreadGroup("GroupA");
        Runnable r = new MyRunnable();

        Thread t1 = new Thread(tg, r, "One");
        Thread t2 = new Thread(tg, r, "Two");

        t1.start();
        t2.start();
    }
}
```

---

### Thread Priority

**Definition:**
Thread priority decides the relative importance of a thread. Higher priority threads are more likely to be executed sooner.
**Use:** Helps in controlling thread execution order when multiple threads are in runnable state.

```java
class MyThread1 extends Thread {
    public void run() {
        System.out.println(Thread.currentThread().getPriority());
        System.out.println(Thread.currentThread().getName() + " in child");
        for (int i = 1; i < 5; i++) {
            System.out.println("Child Thread " + i);
        }
    }
}

public class Example3 {
    public static void main(String[] args) {
        MyThread1 myThread = new MyThread1();
        myThread.start();
        for (int i = 1; i < 5; i++) {
            System.out.println("Main thread " + i);
        }
        System.out.println(Thread.currentThread().getPriority());
        System.out.println(Thread.currentThread().getName() + " in main method");
        Thread.currentThread().setPriority(7);
        System.out.println(Thread.currentThread().getPriority());
    }
}
```

---

### run() Method Behavior

**Definition:**
The `run()` method contains the code that will execute when the thread starts.
**Use:** Overriding the `run()` method provides the thread's execution logic.

```java
class MyThread2 extends Thread {
    @Override
    public void run() {
        for (int i = 1; i <= 5; i++) {
            System.out.println("Child Thread " + i);
        }
    }
    public void run(int i) {
        System.out.println("Overloaded Run method");
    }
}

public class Example4 {
    public static void main(String[] args) {
        MyThread2 myThread = new MyThread2();
        myThread.start();
        for (int i = 1; i <= 5; i++) {
            System.out.println("Main Thread " + i);
        }
    }
}
```

---

### Thread with Runnable Interface

**Definition:**
Threads can also be created by passing a `Runnable` implementation to a `Thread` constructor.
**Use:** Allows reuse of a single `Runnable` object for multiple threads.

```java
class MyRunnable implements Runnable {
    @Override
    public void run() {
        for (int i = 1; i < 5; i++) {
            System.out.println("Child Thread " + i);
        }
    }
}

public class Example5 {
    public static void main(String[] args) {
        MyRunnable r = new MyRunnable();
        Thread t = new Thread(r);
        Thread t1 = new Thread(r); // Another child thread

        t.start();
        t1.start();
        r.run(); // This runs on the main thread

        for (int i = 1; i < 5; i++) {
            System.out.println("Main thread " + i);
        }
    }
}
```

---

### Create Thread Using Thread Object

**Definition:**
A thread can be created using a `Thread` object by passing another `Thread` class instance.
**Use:** Useful for separating logic and managing threads flexibly.

```java
class MyThread4 extends Thread {
    @Override
    public void run() {
        for (int i = 1; i < 5; i++) {
            System.out.println("Child Thread " + i);
        }
    }
}

public class Example6 {
    public static void main(String[] args) {
        MyThread4 myThread = new MyThread4();
        Thread t = new Thread(myThread);
        t.start();

        for (int i = 1; i < 5; i++) {
            System.out.println("Main Thread " + i);
        }
    }
}
```

---

### Synchronization

**Definition:**
Synchronization is the mechanism that controls access to shared resources by multiple threads to prevent data inconsistency.
**Use:** Ensures that only one thread can access the resource at a time to maintain thread safety.


