# 🧵 Java Class 15 Notes – Multithreading (Threading, Synchronization, Locking)

---

## ✅ Creating Threads in Java

### 💡 3 Ways to Create Threads:

1. **By extending `Thread` class**
2. **By implementing `Runnable` interface**
3. **Using `ExecutorService` (Thread Pool)**

---

## 🔁 Constructor Overloading – Definition
- Having **multiple constructors** in a class with **different parameter lists**.
- Java differentiates constructors by **number/type/order of parameters**.

```java
class Sample {
    Sample() { }
    Sample(int a) { }
    Sample(String s, int a) { }
}
```

---

## 👥 Thread Group
- A **ThreadGroup** is a set of threads.
- Used to manage multiple threads as a group.
- Created using:
```java
ThreadGroup group = new ThreadGroup("MyGroup");
Thread t1 = new Thread(group, new MyRunnable(), "Thread1");
```

---

## 👥 Thread Group + Runnable
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

## 💻 Program using Runnable Interface

```java
class MyRunnable implements Runnable {
    public void run() {
        for (int i = 1; i <= 5; i++) {
            System.out.println("Runnable Thread: " + i);
        }
    }
}

public class RunnableTest {
    public static void main(String[] args) {
        Thread t = new Thread(new MyRunnable());
        t.start();
    }
}
```

---

## ⏲️ Thread Scheduler (Priority)
- Thread scheduling is managed by **Thread Scheduler** (JVM component).
- You can set priority:  
  `Thread.MIN_PRIORITY = 1`,  
  `Thread.NORM_PRIORITY = 5`,  
  `Thread.MAX_PRIORITY = 10`

```java
Thread t1 = new Thread();
t1.setPriority(Thread.MAX_PRIORITY);
```
> Note: Priority is **just a hint**, not guaranteed.

---

## 🔗 `join()` Method – Real-Time Example

- Allows one thread to **wait for completion** of another.
- Useful when a thread depends on another thread's result.

### Example:
```java
class MyThread extends Thread {
    public void run() {
        for(int i = 1; i <= 5; i++) {
            System.out.println("Child: " + i);
        }
    }
}

public class JoinExample {
    public static void main(String[] args) throws InterruptedException {
        MyThread t = new MyThread();
        t.start();
        t.join(); // main thread waits for t to finish

        System.out.println("Main thread resumed after child thread.");
    }
}
```

---

## 🌀 Thread Life Cycle

1. **New** – Thread object created
2. **Runnable** – `.start()` called
3. **Running** – Scheduler picks thread
4. **Blocked/Waiting** – Waiting for resource
5. **Terminated** – Finished execution

---

## ⏸️ `yield()` Method – Real-Time Example

- Suggests the CPU to **pause current thread** and give chance to others (same/equal priority).

```java
class YieldDemo extends Thread {
    public void run() {
        for(int i = 0; i < 3; i++) {
            System.out.println(Thread.currentThread().getName() + " is running");
            Thread.yield(); // voluntarily pause
        }
    }
}

public class YieldTest {
    public static void main(String[] args) {
        YieldDemo t1 = new YieldDemo();
        YieldDemo t2 = new YieldDemo();
        t1.start();
        t2.start();
    }
}
```

---

## 😴 `sleep()` Method – Real-Time Example

- Puts thread in sleep (pause) for given milliseconds.

```java
class SleepDemo extends Thread {
    public void run() {
        for(int i = 1; i <= 3; i++) {
            System.out.println("Thread: " + i);
            try {
                Thread.sleep(1000); // 1 sec
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
```

---

## 🧯 `e.printStackTrace()`
- A method from `Throwable` class.
- **Prints the error** (exception) stack trace with line number to the console.
- Useful for **debugging**.

```java
try {
    int x = 5 / 0;
} catch (ArithmeticException e) {
    e.printStackTrace();
}
```

---

## 🔒 Synchronization – Thread Safety
- Prevents multiple threads from accessing **shared resource** simultaneously.
- Keyword: `synchronized`

### 🔐 Locking Mechanism

#### 1️⃣ Object Lock
- Applied when using **synchronized non-static methods**.

```java
public synchronized void printData() {
    // only one thread can access this object at a time
}
```

#### 2️⃣ Class Lock (Static Lock)
- Applied using **synchronized static methods**.

```java
public static synchronized void printStatic() {
    // locks the class
}
```

---

## 🎫 Online Ticket Booking – Synchronization Example (Theoretical Explanation)

Imagine an online ticket booking system where multiple users try to book tickets **at the same time**. All users access the same shared resource — the **total number of available tickets**.

If synchronization is **not used**, two users may book the **same ticket**, leading to overbooking and data inconsistency.

To handle this:
- We create a `bookTicket()` method and mark it as `synchronized`.
- When one thread (user) is booking a ticket, others must **wait**.
- This ensures that the ticket count is updated safely, and **only one user** gets to book at a time.

This models **real-world scenarios** where concurrent access to resources must be controlled.

---

