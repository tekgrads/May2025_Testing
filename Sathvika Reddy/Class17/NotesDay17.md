# Java Notes – notify, Deadlock, Daemon Threads, Thread Groups

---

### notify()

**Definition:**
`notify()` is used to wake up a single thread that is waiting on the object's monitor.
**Use:** It signals one of the waiting threads to resume execution when a resource is available.

---

### notifyAll()

**Definition:**
`notifyAll()` wakes up all the threads that are waiting on the object's monitor.
**Use:** It is used when multiple threads need to be notified simultaneously to continue execution.

---

### Deadlock

**Definition:**
A deadlock is a condition where two or more threads are blocked forever, each waiting on the other to release a resource.
**Use:** Used to understand thread dependencies and design thread-safe programs by avoiding circular locks.

```java
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

---

### Daemon Thread

**Definition:**
A daemon thread is a low-priority thread that runs in the background to perform supporting tasks.
**Use:** Used for tasks like garbage collection, monitoring, or background services.

```java
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

---

### Thread Groups

**Definition:**
A thread group represents a group of threads as a single unit and allows managing multiple threads together.
**Use:** Helps to organize and control multiple threads under a single group.

```java
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


