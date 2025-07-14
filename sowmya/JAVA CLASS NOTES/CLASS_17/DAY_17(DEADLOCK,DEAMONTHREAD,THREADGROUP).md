
# Inter-Thread Communication

### `join()`
Waits for the thread to finish before continuing.

### `wait()`
It is defined in Object class and makes thread wait and release the lock.

### `notify()`
It is defined in Object class and wakes up a single waiting thread.

### `notifyAll()`
It is defined in Object class and wakes up all waiting threads.

> Even if all threads are awakened, the thread scheduler decides which thread will execute.

- If we put a time on `wait()`, after completion of that time, the notification will not occur.
- We can use these methods if the class extends Object and is synchronized.

---

# Deadlock

A **deadlock** happens when two or more threads are waiting for each other to release resources, but none can proceed.

**Reason:** Caused by improper use of `synchronized` blocks.

### Real-time Example:
Friend A: "I'll wait for your black pen."  
Friend B: "I'll wait for your blue pen."  
**Result:** Both are waiting — no one proceeds → Deadlock

### Programming Example:

Thread A has Lock 1 and waits for Lock 2.  
Thread B has Lock 2 and waits for Lock 1.

> Both are waiting forever → Deadlock

### Example: Deadlock Program

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

**Output:**
```
d1 on class A
d2 on class B
Thread calling the d1 method
Thread calling d2 method
```
This results in a **deadlock**.

---

# Daemon Threads

Daemon threads do background tasks and die automatically when main threads are done.

- By default, any thread is **non-daemon**.
- They work only while user threads are running.
- Garbage Collector is a daemon thread.

> If a thread is non-daemon, we can set it as a daemon thread, but vice-versa is not possible.

### Example: Daemon Thread Program

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

**Output:**
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

# ThreadGroup

A **ThreadGroup** is a way to group multiple threads together so they can be managed as a single unit.

- Parent of all thread groups is the **system thread group**.

### Useful Methods

- `.activeCount()`: Returns number of active threads.
- `.activeGroupCount()`: Returns number of active thread groups.
- `Thread.currentThread().getThreadGroup().getName()`: Gets name of current thread group.
- `Thread.currentThread().getThreadGroup().getParent().getName()`: Gets name of parent thread group.

### Example: ThreadGroup Program

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

**Output:**
```
main
system
```
