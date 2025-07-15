
# Java Concepts: ACID Properties, Synchronized Threads, and Inter-Thread Communication

## 1. ACID Properties (Database Transactions)

ACID stands for **Atomicity, Consistency, Isolation, and Durability**. These are essential properties of database transactions to ensure data integrity.

| Property     | Description |
|--------------|-------------|
| **Atomicity** | A transaction is **all-or-nothing**. If one part fails, the whole transaction fails, and the database is unchanged. |
| **Consistency** | A transaction brings the database from one **valid state to another**, maintaining database rules. |
| **Isolation** | Multiple transactions can occur **independently** without interference. |
| **Durability** | Once a transaction is **committed**, it remains so even in case of power loss or crash. |

### Example: Bank Transfer

Transferring ₹500 from Account A to B:
1. Debit ₹500 from A
2. Credit ₹500 to B

This must be **atomic**, maintain **consistency** (e.g., no negative balance), be **isolated** from other transfers, and changes must be **durable** after commit.

---

## 2. Synchronized Threads in Java

### What is Synchronization?

Synchronization in Java is used to prevent thread interference and memory consistency errors when multiple threads access shared resources.

### Why Use It?

- Prevent data corruption
- Avoid race conditions

### 1. Using `synchronized` Method

```java
class Counter {
    int count = 0;

    public synchronized void increment() {
        count++;
    }
}
```

### 2. Using Synchronized Block

```java
synchronized (object) {
    // Critical section
}
```

### Example

```java
class Counter {
    int count = 0;

    public synchronized void increment() {
        count++;
    }
}

public class Test {
    public static void main(String[] args) {
        Counter counter = new Counter();

        Thread t1 = new Thread(() -> {
            for (int i = 0; i < 1000; i++) counter.increment();
        });

        Thread t2 = new Thread(() -> {
            for (int i = 0; i < 1000; i++) counter.increment();
        });

        t1.start();
        t2.start();
    }
}
```

---

## 3. Inter-Thread Communication in Java

### What is It?

Inter-thread communication allows threads to **cooperate** by **waiting** and **notifying** each other instead of busy waiting.

### Key Methods (from `Object` class)

- `wait()` – causes the current thread to wait until another thread invokes `notify()` or `notifyAll()`.
- `notify()` – wakes up a single thread waiting on that object’s monitor.
- `notifyAll()` – wakes up all threads waiting on that object’s monitor.

### Example

```java
class SharedResource {
    boolean flag = false;

    synchronized void produce() throws InterruptedException {
        while (flag) wait();
        System.out.println("Produced");
        flag = true;
        notify();
    }

    synchronized void consume() throws InterruptedException {
        while (!flag) wait();
        System.out.println("Consumed");
        flag = false;
        notify();
    }
}

public class Test {
    public static void main(String[] args) {
        SharedResource resource = new SharedResource();

        Thread producer = new Thread(() -> {
            try {
                while (true) resource.produce();
            } catch (InterruptedException e) { e.printStackTrace(); }
        });

        Thread consumer = new Thread(() -> {
            try {
                while (true) resource.consume();
            } catch (InterruptedException e) { e.printStackTrace(); }
        });

        producer.start();
        consumer.start();
    }
}
```

### Key Points

- `wait()` releases the lock and pauses the thread.
- `notify()` wakes one waiting thread.
- `notifyAll()` wakes all waiting threads.

---

