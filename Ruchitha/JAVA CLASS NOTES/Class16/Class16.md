
# 🧵 Multithreading Synchronization in Java

---

## 🔐 ACID Properties

ACID is a set of properties that ensure database transactions are processed reliably:

1. **Atomicity** – All operations of a transaction are completed; otherwise, none are.
2. **Consistency** – A transaction takes the database from one valid state to another.
3. **Isolation** – Concurrent transactions do not interfere with each other.
4. **Durability** – Once a transaction is committed, it remains so even in case of a system failure.

---

## 🔑 `synchronized` Keyword in Java

### 🔒 Purpose:
Used to restrict access to critical sections of code to one thread at a time, avoiding **race conditions**.

### ✅ Types of Locks

#### 1. **Object Lock**
- Applied to **non-static** methods.
- Lock is on the **instance** of the class.

```java
public synchronized void m1() {
    // only one thread can access this object at a time
}
```

#### 2. **Class Lock**
- Applied to **static** methods.
- Lock is on the **class** itself.

```java
public static synchronized void m1() {
    // locks the class
}
```

### 🧭 Execution Flow
- **Synchronized block:** One thread at a time → safer but slower
- **Non-synchronized block:** Multiple threads can run → faster but unsafe

---

## 🧪 Example 1: Synchronized with Two Objects

```java
class Display {
    public synchronized void m1(String name) {
        for (int i = 1; i < 5; i++) {
            System.out.println("value is " + i);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(name);
        }
    }
}

class MyThreadSync extends Thread {
    Display d;
    String name;

    MyThreadSync(Display d, String name) {
        this.d = d;
        this.name = name;
    }

    public void run() {
        d.m1(name);
    }
}

public class Synchronize {
    public static void main(String[] args) {
        Display d1 = new Display();
        MyThreadSync t1 = new MyThreadSync(d1, "thread1");
        t1.start();

        Display d2 = new Display();
        MyThreadSync t2 = new MyThreadSync(d2, "thread2");
        t2.start();
    }
}
```

### ✅ Output:

```
value is 1
value is 1
thread1
value is 2
thread2
value is 2
thread1
value is 3
thread2
value is 3
thread1
value is 4
thread2
value is 4
thread1
thread2
```

### 📝 Notes:
- Thread sleeps for 1 second in each iteration.
- Since two different `Display` objects are used, the synchronization does **not** prevent both threads from running at the same time.

---

## 🧪 Example 2: Synchronized Block

```java
class DisplayBlock {
    public void m1(String name) {
        System.out.println("Before Synchronized Block");
        synchronized(this) {
            for(int i = 1; i < 3; i++) {
                System.out.println("value of i is: " + i);
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(name);
            }
        }
    }
}

class MyThreadSyncBlock extends Thread {
    DisplayBlock d;
    String name;

    MyThreadSyncBlock(DisplayBlock d, String name) {
        this.d = d;
        this.name = name;
    }

    public void run() {
        d.m1(name);
    }
}

public class SynchronizeBlock {
    public static void main(String[] args) {
        DisplayBlock d = new DisplayBlock();
        MyThreadSyncBlock t1 = new MyThreadSyncBlock(d, "thread1");
        t1.start();
        MyThreadSyncBlock t2 = new MyThreadSyncBlock(d, "thread2");
        t2.start();
    }
}
```

### ✅ Output:

```
Before Synchronized Block
Before Synchronized Block
value of i is: 1
thread2
value of i is: 2
thread2
value of i is: 1
thread1
value of i is: 2
thread1
```

---

## 🔄 Inter-Thread Communication

### 🗨️ Definition:
Allows threads to communicate with each other using `wait()`, `notify()`, and `notifyAll()` methods.

### 🔧 Methods:

- `wait()` – Causes current thread to release lock and wait.
- `notify()` – Wakes one waiting thread.
- `notifyAll()` – Wakes all waiting threads.

⚠️ These methods are defined in the `Object` class, **not** `Thread`.

---

## 🧪 Example 3: Inter-Thread Communication

```java
class InterThreadCommunication extends Thread {
    int total = 0;

    public void run() {
        synchronized(this) {
            System.out.println("Child Thread Execution Started");
            for(int i = 0; i <= 10; i++) {
                total += i;
            }
            System.out.println("Notification coming from Child Thread");
            this.notify();
        }
    }
}

public class InterThread {
    public static void main(String[] args) {
        InterThreadCommunication t = new InterThreadCommunication();
        t.start();

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        synchronized(t) {
            try {
                System.out.println("wait() Main thread");
                t.wait(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        System.out.println("Main Thread getting notification: " + t.total);
    }
}
```

### ✅ Output:

```
Child Thread Execution Started
Notification coming from Child Thread
wait() Main thread
Main Thread getting notification: 55
```

---

## 📝 Final Notes

- A thread **must own** the object's lock to call `wait()` or `notify()`.
- `wait()` releases the lock, `notify()` does not.
- Always call these inside a `synchronized` block.
