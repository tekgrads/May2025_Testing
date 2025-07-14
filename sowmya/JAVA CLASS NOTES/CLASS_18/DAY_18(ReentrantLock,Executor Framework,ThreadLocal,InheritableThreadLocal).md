## ReentrantLock in Java

## Overview

`ReentrantLock` is a lock implementation that allows the same thread to acquire the lock multiple times. It is part of the `java.util.concurrent.locks` package.

* A thread's **hold count** increases every time it locks and decreases with each unlock.
* Once the hold count is 0, the lock is available.

## Lock Interface Methods

1. `lock()`: Acquires the lock, blocks if unavailable.
2. `tryLock()`: Attempts to acquire the lock without blocking.
3. `tryLock(long timeout, TimeUnit unit)`: Waits up to the given time.
4. `unlock()`: Releases the lock.
5. `lockInterruptibly()`: Acquires the lock unless interrupted.

## ReentrantLock Methods

1. `getHoldCount()`: Returns the hold count for the current thread.
2. `getQueueLength()`: Number of threads waiting.
3. `hasQueuedThreads()`: Checks if threads are waiting.
4. `getQueuedThreads()`: Returns collection of waiting threads.
5. `isFair()`: Checks if the lock is fair.
6. `getOwner()`: Returns the thread holding the lock.

---

## Example 1: Basic ReentrantLock

```java
package com.tekgrads.multithreading;

import java.util.concurrent.locks.ReentrantLock;

public class ReentrantLocking {
    public static void main(String[] args) {
        ReentrantLock l = new ReentrantLock();
        l.lock();
        l.lock();

        System.out.println("ReentrantLock : " + l.isLocked());
        System.out.println("Held by current thread: " + l.isHeldByCurrentThread());
        System.out.println("Queue length: " + l.getQueueLength());
        System.out.println("Hold count: " + l.getHoldCount());

        l.unlock();
        System.out.println("Hold count after unlock: " + l.getHoldCount());
        System.out.println("Is fair lock: " + l.isFair());
    }
}
```

### Output:

```
ReentrantLock : true
Held by current thread: true
Queue length: 0
Hold count: 2
Hold count after unlock: 1
Is fair lock: false
```

---

## Example 2: tryLock()

```java
package com.tekgrads.multithreading;

import java.util.concurrent.locks.ReentrantLock;

class MyThreadReentrant extends Thread {
    ReentrantLock l;

    public MyThreadReentrant(String name, ReentrantLock l) {
        super(name);
        this.l = l;
    }

    public void run() {
        if (l.tryLock()) {
            System.out.println(Thread.currentThread().getName() + " got the lock and performing safe operations");
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            l.unlock();
        } else {
            System.out.println(Thread.currentThread().getName() + " unable to get the lock and hence performing alternative operations");
        }
    }
}

public class ReentrantLocking1 {
    public static void main(String[] args) {
        ReentrantLock l = new ReentrantLock();
        MyThreadReentrant t1 = new MyThreadReentrant("First Thread", l);
        MyThreadReentrant t2 = new MyThreadReentrant("Second Thread", l);
        t1.start();
        t2.start();
    }
}
```

### Output:

```
First Thread got the lock and performing safe operations
Second Thread unable to get the lock and hence performing alternative operations
```

---

## Example 3: Locking with Shared Resource

```java
package com.tekgrads.multithreading;

import java.util.concurrent.locks.ReentrantLock;

class Display1 {
    ReentrantLock l = new ReentrantLock();

    public void m1(String name) {
        l.lock();
        try {
            for (int i = 0; i < 2; i++) {
                System.out.println("value of i is " + i);
                Thread.sleep(2000);
                System.out.println(name);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            l.unlock();
        }
    }
}

class MyThreadReentrant1 extends Thread {
    Display1 d;
    String name;

    MyThreadReentrant1(Display1 d, String name) {
        this.d = d;
        this.name = name;
    }

    public void run() {
        d.m1(name);
    }
}

public class ReentrantLocking2 {
    public static void main(String[] args) {
        Display1 d = new Display1();
        MyThreadReentrant1 t1 = new MyThreadReentrant1(d, "core");
        MyThreadReentrant1 t2 = new MyThreadReentrant1(d, "java");
        t1.start();
        t2.start();
    }
}
```

### Output:

```
value of i is 0
core
value of i is 1
core
value of i is 0
java
value of i is 1
java
```

---

## Executor Framework

## What is Executor Framework?

The Executor Framework in Java is like a thread manager — you give it tasks, and it handles when and how they run using available threads.

### Benefits:

* Improves performance.
* Simplifies multithreading code.
* Saves system resources by using thread pools.
* Threads can be reused.
* It deals with Checked Exceptions.

---

## Real-time Example

Imagine you're running an e-commerce platform. Whenever a customer places an order, it needs to be processed in the background without blocking the main application.

The Executor Framework helps you process multiple orders concurrently using a thread pool.

---

## Example 4: Program on Executor Framework

```java
package com.tekgrads.multithreading;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

class Job implements Runnable {
    String name;

    public Job(String name) {
        this.name = name;
    }

    public void run() {
        System.out.println(name + " job started by thread " + Thread.currentThread().getName());
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(name + " job completed by thread " + Thread.currentThread().getName());
    }
}

public class ExecutorFramework1 {
    public static void main(String[] args) {
        Job[] jobs = {
            new Job("Ramya"),
            new Job("Sowmya"),
            new Job("Laxmi"),
            new Job("Ruchitha"),
            new Job("Sneha"),
            new Job("Navya")
        };

        ExecutorService service = Executors.newFixedThreadPool(3);

        for (Job job : jobs) {
            service.submit(job);
        }

        service.shutdown();
    }
}
```

### Output:

```
laxmi job started by thread pool-1-thread-3
Ramya job started by thread pool-1-thread-1
Sowmya job started by thread pool-1-thread-2
laxmi job completed by thread pool-1-thread-3
Ramya job completed by thread pool-1-thread-1
ruchitha job started by thread pool-1-thread-1
Sneha job started by thread pool-1-thread-3
Sowmya job completed by thread pool-1-thread-2
navya job started by thread pool-1-thread-2
ruchitha job completed by thread pool-1-thread-1
Sneha job completed by thread pool-1-thread-3
navya job completed by thread pool-1-thread-2
```

---

## ThreadLocal in Java

`ThreadLocal` is a special class that allows you to create variables local to each thread.

### When to use:

Used when multiple threads need to use the same variable name but with different values, without interfering with each other.

### Real-time Example:

In a chat app, each thread handles a different user’s message. We want to store and access the user's name without passing it to every method.

## Example 5: Program on ThreadLocal

```java
package com.tekgrads.multithreading;

public class ThreadLocal2 {
    public static void main(String[] args) {
        ThreadLocal tl = new ThreadLocal() {
            protected Object initialValue() {
                return "core";
            }
        };

        System.out.println(tl.get());
        tl.set("java");
        System.out.println(tl.get());
        tl.remove();
        System.out.println(tl.get());
    }
}
```

### Output:

```
core
java
core
```

---

## InheritableThreadLocal

`InheritableThreadLocal` is a child class of `ThreadLocal` that allows child threads to inherit values from parent threads.

## Example 6: Program on InheritableThreadLocal

```java
package com.tekgrads.multithreading;

public class InheritableThreadLocal1 {
    static InheritableThreadLocal user = new InheritableThreadLocal();

    public static void main(String[] args) {
        user.set("Parent");
        ChildThread t1 = new ChildThread();
        t1.start();
    }
}

class ChildThread extends Thread {
    public void run() {
        System.out.println("Child Thread before change: " + InheritableThreadLocal1.user.get());
        InheritableThreadLocal1.user.set("Child");
        System.out.println("Child Thread after change: " + InheritableThreadLocal1.user.get());
    }
}
```

### Output:

```
Child Thread before change: Parent
Child Thread after change: Child
```

---

