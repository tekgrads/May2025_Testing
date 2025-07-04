# 📮 Java Class 17 Notes 

---

## 📨 Real-Time Example: Post Box (wait & notify)

### 📖 Scenario:
- Imagine a person is **waiting for a letter** in a post box.
- He keeps **checking again and again**, but there's no letter.
- Instead of checking repeatedly (wasting CPU), he decides to **wait**.
- When the **postman drops the letter**, he **notifies** the person.

This is how **inter-thread communication** works:
- One thread waits (`wait()`).
- Another thread notifies (`notify()` or `notifyAll()`).

---

## 💡 Code Example: wait() & notify()

```java
class PostBox {
    boolean hasLetter = false;

    synchronized void waitForLetter() {
        try {
            while (!hasLetter) {
                System.out.println("No letter. Waiting...");
                wait(); // releases lock and waits
            }
            System.out.println("Letter received!");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    synchronized void deliverLetter() {
        System.out.println("Postman delivered the letter.");
        hasLetter = true;
        notify(); // notifies one waiting thread
    }
}

public class PostBoxTest {
    public static void main(String[] args) {
        PostBox box = new PostBox();

        // Waiting thread
        new Thread(() -> box.waitForLetter()).start();

        // Simulate delay before delivering
        new Thread(() -> {
            try {
                Thread.sleep(3000);
                box.deliverLetter();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
    }
}
```

---

## 🔔 `notify()` Method
- Wakes up **one** thread waiting on the object's monitor.
- That thread can proceed **only after acquiring the lock**.

```java
synchronized(obj) {
    obj.notify();
}
```

---

## 🔔 `notifyAll()` Method
- Wakes up **all** waiting threads on the object.
- Only **one thread** gets the lock at a time; others will wait.

```java
synchronized(obj) {
    obj.notifyAll();
}
```

---

## 📍 `a.last()` – Concept

Assuming `a` is an object of a class with `last()` method in a `synchronized` block:

```java
class A {
    synchronized void last() {
        System.out.println("Inside A.last()");
    }
}
```

- The method is protected by **object lock**.
- Only one thread at a time can execute this method on the same object.

---

## 🔒 Deadlock

### 💥 What is Deadlock?
Deadlock occurs when **two or more threads** wait for **each other’s lock** indefinitely — and none can proceed.

### 🧠 Real-Life Example:
- Person A has **Pen**, wants **Paper**.
- Person B has **Paper**, wants **Pen**.
- Both wait forever.

### 🧱 Code Example:

```java
class A {
    synchronized void methodA(B b) {
        System.out.println("Thread A trying to call B's last()");
        b.last();
    }

    synchronized void last() {
        System.out.println("Inside A.last()");
    }
}

class B {
    synchronized void methodB(A a) {
        System.out.println("Thread B trying to call A's last()");
        a.last();
    }

    synchronized void last() {
        System.out.println("Inside B.last()");
    }
}

public class DeadlockExample {
    public static void main(String[] args) {
        A a = new A();
        B b = new B();

        Thread t1 = new Thread(() -> a.methodA(b));
        Thread t2 = new Thread(() -> b.methodB(a));

        t1.start();
        t2.start();
    }
}
```

> ⚠️ This will result in **deadlock**, as each thread is waiting for the other to release a lock.

---

## 👻 Daemon Threads

### 🔄 What is a Daemon Thread?
- A **background thread** that provides **services to user threads**.
- JVM terminates them **automatically** once all user threads finish.

### ✅ Real-Life Example:
- Garbage Collector is a daemon thread.
- Think of it like a **housekeeping robot**—it works in the background but **stops when the house is empty**.

---

### 🔁 Daemon Thread Life Cycle

1. **New**
2. **Runnable**
3. **Running**
4. **Terminated** (automatically when no user threads)

> Daemon threads **cannot prevent JVM shutdown**.

---

### 🧪 Daemon Thread Code Example:

```java
public class DaemonExample extends Thread {
    public void run() {
        if (Thread.currentThread().isDaemon())
            System.out.println("Daemon thread running");
        else
            System.out.println("User thread running");
    }

    public static void main(String[] args) {
        DaemonExample t1 = new DaemonExample();
        DaemonExample t2 = new DaemonExample();

        t1.setDaemon(true); // must be set before start()
        t1.start();
        t2.start();
    }
}
```

---

## 🔢 `Thread.activeCount()` Method

- Returns the **number of active threads** in the current thread group.

```java
System.out.println(Thread.activeCount());
```

> Helpful for **monitoring** and **debugging** thread usage in an application.

---

## 📋 Summary Table

| Concept             | Description                                                  |
|---------------------|--------------------------------------------------------------|
| `wait()`            | Makes thread wait and releases object lock                   |
| `notify()`          | Wakes up one waiting thread                                  |
| `notifyAll()`       | Wakes up all waiting threads                                 |
| Daemon Thread       | Background thread that ends when user threads finish         |
| Deadlock            | Threads wait on each other forever (circular wait)           |
| `a.last()`          | Method in synchronized block – requires object lock          |
| `activeCount()`     | Returns number of currently active threads                   |

---
