# 📘 Multithreading - Advanced Concepts

---

## 🔄 Inter-Thread Communication

Java provides methods like `wait()`, `notify()`, and `notifyAll()` for **communication between threads**. These methods are present in the `Object` class and must be called inside **synchronized blocks**.

### ✅ `join()`  
- Makes the current thread **wait until the thread on which it is called terminates**.

### ✅ `wait()`
- Causes the current thread to **wait and release the lock** until another thread invokes `notify()` or `notifyAll()`.

### ✅ `notify()`
- Wakes up **a single thread** that is waiting on the object’s monitor.

### ✅ `notifyAll()`
- Wakes up **all threads** that are waiting on the object’s monitor.

> ⚠️ Even if all threads are notified, the thread scheduler decides which one will proceed.

---

## ❌ Deadlock in Java

A **deadlock** occurs when two or more threads wait for each other indefinitely to release locks.

### 💡 Real-World Analogy

```
Friend A: I’ll wait for your black pen.
Friend B: I’ll wait for your blue pen.
→ Result: Both wait forever — DEADLOCK.
```

---

### 🔁 **Deadlock Code Example**

```java
package com.tekgrads.multithreading;

class A {
    public synchronized void d1(B b) {
        System.out.println("d1 on class A");
        try { Thread.sleep(1000); } catch (InterruptedException e) { e.printStackTrace(); }
        System.out.println("Thread calling the d1 method");
        b.last();
    }

    public synchronized void last() {
        System.out.println("Inside A Synchronized method");
    }
}

class B {
    public synchronized void d2(A a) {
        System.out.println("d2 on class B");
        try { Thread.sleep(2000); } catch(InterruptedException e) { e.printStackTrace(); }
        System.out.println("Thread calling d2 method");
        a.last();
    }

    public synchronized void last() {
        System.out.println("Inside B Synchronized method");
    }
}

class MyThreadDeadLock extends Thread {
    A a = new A();
    B b = new B();

    public void m1() {
        this.start();
        a.d1(b);
    }

    public void run() {
        b.d2(a);
    }
}

public class DeadLock {
    public static void main(String[] args) {
        MyThreadDeadLock t = new MyThreadDeadLock();
        t.m1();
    }
}
```

### 🖥️ Output:

```
d1 on class A
d2 on class B
Thread calling the d1 method
Thread calling d2 method
// Program freezes here due to deadlock
```

---

## 👻 Daemon Threads

- Daemon threads are **low-priority threads** that run in the background (e.g., garbage collector).
- They **die automatically** when all user threads are finished.
- We can set a thread as **daemon only before starting** it.

---

### 🧪 Daemon Thread Example

```java
package com.tekgrads.multithreading;

class MyThreadDaemon extends Thread {
    public void run() {
        for(int i = 0; i < 3; i++) {
            System.out.println("Child Thread");
            try { Thread.sleep(2000); } catch (InterruptedException e) { e.printStackTrace(); }
        }
    }
}

public class DeamonThread {
    public static void main(String[] args) {
        System.out.println(Thread.currentThread().getName());
        System.out.println(Thread.currentThread().isDaemon());

        MyThreadDaemon t  = new MyThreadDaemon();
        System.out.println(t.isDaemon());

        t.start();
        System.out.println("Main Completed");
    }
}
```

### 🖥️ Output:

```
main
false
false
Main Completed
Child Thread
Child Thread
Child Thread
```

---

## 👥 ThreadGroup in Java

- A `ThreadGroup` is used to group multiple threads.
- All thread groups are part of the **system thread group** hierarchy.

### 🔧 Common Methods:

| Method | Description |
|--------|-------------|
| `activeCount()` | Returns number of active threads |
| `activeGroupCount()` | Returns number of active thread groups |
| `getThreadGroup().getName()` | Returns current thread group name |
| `getThreadGroup().getParent().getName()` | Returns parent group name |

---

### 🧪 ThreadGroup Example

```java
package com.tekgrads.multithreading;

class MyThreadGroup extends Thread {
    MyThreadGroup(ThreadGroup tg, String name) {
        super(tg, name);
    }

    public void run() {
        System.out.println("Child Thread");
        try { Thread.sleep(5000); } catch (InterruptedException e) { e.printStackTrace(); }
    }
}

public class ThreadGroupDemo {
    public static void main(String[] args) throws InterruptedException {
        System.out.println(Thread.currentThread().getThreadGroup().getName());
        System.out.println(Thread.currentThread().getThreadGroup().getParent().getName());
    }
}
```

### 🖥️ Output:

```
main
system
```
