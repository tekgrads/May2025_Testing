# ✅ Day 15 – Threading, Synchronization, Locking

## 🔹 Synchronization Introduction
Multiple threads accessing the same data may cause **data inconsistency**.  
To prevent this, Java uses **synchronization**.

➡️ Only one thread can access the synchronized method/block at a time.

## 🔹 Synchronized Methods
```java
class Counter {
    int count = 0;

    synchronized void increment() {
        count++;
    }
}
```

## 🔹 Synchronized Block
```java
synchronized (obj) {
    // critical section
}
```

## 🔹 Example:
```java
class Table {
    synchronized void printTable(int n) {
        for (int i = 1; i <= 5; i++) {
            System.out.println(n * i);
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

public class Main {
    public static void main(String[] args) {
        Table obj = new Table();
        MyThread1 t1 = new MyThread1(obj);
        MyThread2 t2 = new MyThread2(obj);
        t1.start();
        t2.start();
    }
}
```

## 🔹 Locking (Using ReentrantLock)
```java
import java.util.concurrent.locks.*;

class Shared {
    private final Lock lock = new ReentrantLock();
    int count = 0;

    void increment() {
        lock.lock();
        try {
            count++;
        } finally {
            lock.unlock();
        }
    }
}
```