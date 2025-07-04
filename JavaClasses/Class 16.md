# 🔐 Java Class 16 Notes – Synchronization, Locks, and Inter-Thread Communication

---

## ✅ Synchronization

Synchronization in Java is a mechanism to **control access to shared resources** in multithreaded applications.

### 🔐 Real-Time Example: Joint Bank Account

Imagine a **joint bank account** accessed by two people:

- If **Person A** is withdrawing money, and **Person B** also tries to withdraw at the same time, the **balance may go negative**.
- To avoid this, we use `synchronized` so **only one thread (person)** can access the account **at a time**.

---

## 🔄 ACID Properties (Database + Threading Concept)

ACID ensures **data consistency** during transactions (applies to threads accessing shared data too):

1. **A – Atomicity**  
   > All steps of a transaction **must complete**, or none at all.  
   > In threads, either the **entire task runs** or **rolls back**.

2. **C – Consistency**  
   > Data must be in a **consistent state** before and after thread execution.

3. **I – Isolation**  
   > Each thread should work **independently** (no interference).

4. **D – Durability**  
   > Once the thread completes work, the **result must be permanent** (not lost).

> Example: Online payment – either money is deducted and order placed, or nothing happens. **No halfway state.**

---

## 🔒 Object Lock vs Class Lock

| Type             | Used With             | Description                                      |
|------------------|------------------------|--------------------------------------------------|
| Object Lock      | Non-static methods     | Lock is applied to **instance** of class         |
| Class Lock       | Static methods         | Lock is applied to the **class** itself          |

### Example:

```java
public synchronized void bookTicket() {
    // Object lock: only 1 thread per object can access
}

public static synchronized void updateSystemLogs() {
    // Class lock: only 1 thread for the class can access
}
```

---

## 🔃 Synchronized vs Non-Synchronized

| Feature            | Synchronized              | Non-Synchronized            |
|--------------------|---------------------------|-----------------------------|
| Access             | Only 1 thread at a time   | Multiple threads can access |
| Thread Safety      | Yes                       | No                          |
| Performance        | Slower (due to locking)   | Faster but unsafe           |

---

## 💬 Wish Method – Conceptual Example

Imagine a **wish(String name)** method where multiple users send a greeting like "Good Morning".

If unsynchronized:
- Output may interleave (due to multiple threads printing at the same time).
  
If synchronized:
- One thread completes its entire greeting before another starts.

```java
public synchronized void wish(String name) {
    System.out.print("Good Morning ");
    try {
        Thread.sleep(1000);
    } catch (InterruptedException e) {}
    System.out.println(name);
}
```

---

## 🔁 Inter-Thread Communication

Used when **two or more threads** need to **cooperate** and **communicate**.

### ☑️ Methods Used:
| Method     | Defined In | Description                                       |
|------------|------------|---------------------------------------------------|
| `wait()`   | Object     | Makes thread wait and release lock               |
| `notify()` | Object     | Wakes up a single waiting thread                 |
| `notifyAll()` | Object  | Wakes up all waiting threads                     |

### 💡 Real-Time Example:

Imagine a **producer-consumer** model:
- **Producer** adds items to a buffer.
- **Consumer** takes items from buffer.
- If buffer is full, producer waits.
- If buffer is empty, consumer waits.

This communication is done using:
- `wait()` → makes thread pause
- `notify()` → resumes another thread

---

## 🔐 getLock Concept (Acquiring Lock)

- A thread must acquire a **lock** on an object before entering a synchronized block.
- If another thread already holds the lock, current thread will **wait**.
  
```java
synchronized(obj) {
    // thread gets lock on obj
    // executes critical section
}
```

> Only **one thread** can hold the lock at a time. This is called getting the **monitor lock** or **intrinsic lock**.

---

## 🔄 Summary Table

| Concept               | Description                                                  |
|------------------------|--------------------------------------------------------------|
| Synchronization        | Controls access to shared resource                           |
| Object Lock            | Used on instance methods                                     |
| Class Lock             | Used on static methods                                       |
| wait()                 | Pauses thread and releases lock                              |
| notify()               | Wakes up one thread waiting on object's monitor              |
| getLock                | Mechanism to enter synchronized block                        |
| ACID Properties        | Atomicity, Consistency, Isolation, Durability (transaction)  |

---
