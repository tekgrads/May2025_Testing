# ACID PROPERTIES

## AUTOMACITY

A transaction is done completely or not at all.

## CONSISTENCY

Data must be in a consistent state before and after other transaction execution.

## ISOLATION

Each transaction runs independently, without disturbing others.

## DURABILITY

Once saved, the data will not be lost, even if the system crashes.

---

# Synchronized Keyword

Using synchronization prevents multiple threads from accessing a shared resource simultaneously.
The keyword is: `synchronized`
By using the `synchronized` keyword, we can lock the code to prevent access by other threads.

## Types of Locks

### 1. Object Lock

* Applied to **non-static** methods.
* Lock is applied to the **instance** of the class.

💡 Example: If the main door is locked, we cannot open other doors.

**Syntax:**

```java
public synchronized void m1() {
    // only one thread can access this object at a time
}
```

### 2. Class Lock

* Applied to **static** methods.
* Lock is applied to the **class** itself.

**Syntax:**

```java
public static synchronized void m1() {
    // locks the class
}
```

## Execution Flow

* **Synchronized** area: Only one thread is executed at a time → **Slower**
* **Non-synchronized** area: Many threads are executed concurrently → **Faster**

---

# Example 1: Synchronized Using 2 Different Objects

```java
package com.tekgrads.multithreading;

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
        Display d = new Display();
        MyThreadSync t = new MyThreadSync(d, "thread1");
        t.start();

        Display d2 = new Display();
        MyThreadSync t2 = new MyThreadSync(d2, "thread2");
        t2.start();
    }
}
```

### Output:

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

---

### Notes:

* `Thread.sleep` throws `InterruptedException`, so use a `try-catch` block or declare `throws`.
* If **unsynchronized**: Output may interleave (due to multiple threads running simultaneously).
* If **synchronized**: One thread completes its task before another begins.
* When using **two different objects**, even with synchronization, output may be jumbled since the lock is not shared.


# Example 2: Program on Synchronized Block

```java
package com.tekgrads.multithreading;

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
        MyThreadSyncBlock t  = new MyThreadSyncBlock(d, "thread1");
        t.start();
        MyThreadSyncBlock t2  = new MyThreadSyncBlock(d, "thread2");
        t2.start();
    }
}
```

### Output:

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

> A single thread can acquire multiple locks on **different** objects, but not **multiple locks on the same object**.

---

# Inter-Thread Communication

Inter-thread communication means multiple threads talk to each other to work together.
It allows one thread to **wait**, and another to **notify** it when a task is done — using methods like:

* `wait()`
* `notify()`


## Method Descriptions

### `wait()`

* Defined in `Object` class
* Makes thread **wait** and **releases the lock**

### `notify()`

* Defined in `Object` class
* Wakes up **a single** waiting thread




> **Note:** The `wait()` and `notify()` methods are available on **objects**, not threads.

---

## Example 3: Program on Inter-Thread Communication

```java
package com.tekgrads.multithreading;

class InterThreadCommunication extends Thread {
    int total = 0;

    public void run() {
        synchronized(this) {
            System.out.println("Child Thread Execution Started");
            for(int i = 0; i <= 10; i++) {
                total = total + i;
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

### Output:

```
Child Thread Execution Started
Notification coming from Child Thread
wait() Main thread
Main Thread getting notification: 55
```

---

## Important Notes

* A thread must acquire a **lock** on an object before entering a `synchronized` block.
* If another thread already holds the lock, the current thread will **wait**.

```java
synchronized(obj) {
    // thread gets lock on obj
    // executes critical section
}
```

* Only one thread can hold the lock at a time. This is called getting the monitor lock.

