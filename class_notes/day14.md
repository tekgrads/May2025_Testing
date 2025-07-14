# Thread Synchronization in Java

## What is Synchronization?

**Thread Synchronization** in Java is the process of controlling the access of multiple threads to shared resources to prevent data inconsistency and thread interference.

When multiple threads access a shared resource (like variables or methods) simultaneously, and at least one thread modifies the resource, it can lead to incorrect results.

---

## Why Synchronization is Needed

* To prevent **race conditions**
* To ensure **data consistency**
* To avoid **unexpected behavior** when multiple threads operate on shared data

---

## Types of Synchronization

### 1. **Synchronized Method**

* Locks the entire method for one thread at a time.

```java
class Table {
    synchronized void printTable(int n) {
        for (int i = 1; i <= 5; i++) {
            System.out.println(n * i);
            try { Thread.sleep(400); } catch (Exception e) { }
        }
    }
}
```

### 2. **Synchronized Block**

* Only a part of the method is synchronized.
* Reduces locking time and improves performance.

```java
class Table {
    void printTable(int n) {
        synchronized (this) {
            for (int i = 1; i <= 5; i++) {
                System.out.println(n * i);
                try { Thread.sleep(400); } catch (Exception e) { }
            }
        }
    }
}
```

### 3. **Static Synchronization**

* Locks on the class, not the object.

```java
class Table {
    synchronized static void printTable(int n) {
        for (int i = 1; i <= 5; i++) {
            System.out.println(n * i);
            try { Thread.sleep(400); } catch (Exception e) { }
        }
    }
}
```

---

## Example with Multiple Threads

```java
class Table {
    void printTable(int n) {
        synchronized (this) {
            for (int i = 1; i <= 5; i++) {
                System.out.println(n * i);
                try { Thread.sleep(400); } catch (Exception e) {}
            }
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

class MyThread2 extends Thread {
    Table t;
    MyThread2(Table t) {
        this.t = t;
    }
    public void run() {
        t.printTable(100);
    }
}

public class TestSynchronization {
    public static void main(String[] args) {
        Table obj = new Table();
        MyThread1 t1 = new MyThread1(obj);
        MyThread2 t2 = new MyThread2(obj);
        t1.start();
        t2.start();
    }
}
```

---

## Lock Concept

Every object in Java has a **monitor lock**. When a thread enters a synchronized block or method, it locks the object. Other threads trying to enter any synchronized block/method of the same object will be blocked until the lock is released.

---

## Deadlock

Occurs when two or more threads are blocked forever, each waiting on the other to release a lock.

### Example:

```java
class A {
    synchronized void foo(B b) {
        System.out.println("Thread 1: Holding A and waiting for B...");
        b.last();
    }

    synchronized void last() {
        System.out.println("Inside A.last()");
    }
}

class B {
    synchronized void bar(A a) {
        System.out.println("Thread 2: Holding B and waiting for A...");
        a.last();
    }

    synchronized void last() {
        System.out.println("Inside B.last()");
    }
}
```

---

