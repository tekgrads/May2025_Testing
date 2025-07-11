# Thread Concepts in Java

## Ways to Create a Thread

1. By extending the `Thread` class
2. By implementing the `Runnable` interface
3. By creating a `Thread` class object

---

## Constructor Overloading

On a class, we can define multiple constructors with different parameters:

```java
class Test {
    Test() {}
    Test(int a) {}
    Test(int a, int b) {}
}
```

### Example 1: Constructor Overloading in Threads and Thread Priority

```java
package com.tekgrads.multithreading;

class MyRunnable1 implements Runnable {
    @Override
    public void run() {
        for(int i = 1; i <= 5; i++) {
            System.out.println(Thread.currentThread().getName() + " " + i);
        }
    }
}

public class Example7 {
    public static void main(String[] args) {
        MyRunnable1 mr = new MyRunnable1();
        Thread t = new Thread(mr, "child-0");
        System.out.println("Priority of child-0: " + t.getPriority());
        System.out.println("Priority of main: " + Thread.currentThread().getPriority());
        t.setPriority(4);
        t.start();
        for(int i = 1; i <= 5; i++) {
            System.out.println("Main Thread: " + i);
        }
    }
}
```

**Output:**

```
Priority of child-0: 5
Priority of main: 5
Main Thread: 1
Main Thread: 2
Main Thread: 3
Main Thread: 4
Main Thread: 5
child-0 1
child-0 2
child-0 3
child-0 4
child-0 5
```

> Note: If we don't set any priority, it inherits from the parent thread.
> Thread execution can vary each time due to priority and scheduler behavior.

---

## Thread Group

A **ThreadGroup** represents a group of threads.

**Real-time Example**: In a school, each class contains different groups — each group acts like a ThreadGroup.

### Example 2: ThreadGroup Usage

```java
package com.tekgrads.multithreading;

class MyRunnable2 implements Runnable {
    public void run() {
        System.out.println(Thread.currentThread().getName());
    }
}

public class Example8 {
    public static void main(String[] args) {
        ThreadGroup tg = new ThreadGroup("GroupA");
        Runnable r = new MyRunnable2();

        Thread t1 = new Thread(tg, r, "1stgroup");
        Thread t2 = new Thread(tg, r, "2ndgroup");

        t1.start();
        t2.start();
    }
}
```

**Output:**

```
1stgroup
2ndgroup
```

---

## Thread Scheduler

Responsible for managing multiple threads and deciding the execution order based on priorities.

* **Default priority:** 5
* **Min priority:** 1
* **Max priority:** 10

**Real-time Example**: A traffic controller decides which vehicle (thread) goes next.

---

## Thread Life Cycle

1. **New**: Thread is created.
2. **Runnable**: Thread is ready to run after calling `start()`.
3. **Running**: Thread scheduler picks the thread for execution.
4. **Blocked / Waiting / Timed Waiting**: Thread is waiting (for resource, another thread, or for time).
5. **Terminated**: Thread completes execution.

**Diagram:**

```
New --> Runnable --> Running --> (Blocked / Waiting / Timed Waiting) --> Runnable --> Running --> Terminated
```

# `yield()`

**`yield()`**: Temporarily pauses the current thread and allows others to run.

### Example 3: Program on `yield()`

```java
package com.tekgrads.multithreading;

class MyThreadYeild extends Thread {
    public void run() {
        for(int i = 1; i < 5; i++) {
            System.out.println(Thread.currentThread().getName() + " " + i);
            Thread.yield();
        }
    }
}

public class Example9 {
    public static void main(String[] args) {
        MyThreadYeild t = new MyThreadYeild();
        t.setName("Child-0");
        t.start();
        for(int i = 1; i < 5; i++) {
            System.out.println("Main thread " + i);
        }
    }
}
```

**Output:**

```
Child-0 1
Child-0 2
Child-0 3
Main thread 1
Main thread 2
Child-0 4
Main thread 3
Main thread 4
```

> When both threads have the same priority, the thread scheduler decides which one to run.
> Execution is not predictable even with `yield()`.

---

# `join()`

**`join()`**: Waits for the thread to finish before continuing.

### Example 4:

```java
package com.tekgrads.multithreading;

class Thread2 extends Thread {
    public void run() {
        for(int i = 1; i <= 5; i++) {
            System.out.println("Child: " + i);
        }
    }
}

public class Example10 {
    public static void main(String[] args) throws InterruptedException {
        Thread2 t = new Thread2();
        t.start();
        t.join(); // main thread waits for t to finish
        System.out.println("Main thread waits after child thread.");
    }
}
```

**Output:**

```
Child: 1
Child: 2
Child: 3
Child: 4
Child: 5
Main thread waits after child thread.
```

---

# `sleep()`

**`sleep(ms)`**: Pauses the thread for the specified time in milliseconds.
It throws `InterruptedException`, so you must handle it with `try-catch`.

### Example 5:

```java
package com.tekgrads.multithreading;

class Thread3 extends Thread {
    public void run() {
        for(int i = 1; i < 5; i++) {
            System.out.println("Child Thread " + i);
            try {
                Thread.sleep(2000); // 2 seconds
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

public class Example11 {
    public static void main(String[] args) {
        Thread3 t = new Thread3();
        t.start();
        try {
            t.join(3000); // main thread waits max 3 seconds
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        for(int i = 1; i < 5; i++) {
            System.out.println("Main Thread " + i);
        }
    }
}
```

**Output:**

```
Child Thread 1
Child Thread 2
Main Thread 1
Main Thread 2
Main Thread 3
Main Thread 4
Child Thread 3
Child Thread 4
```

> While execution switches between threads, `sleep()` causes delays, making the thread wait for the given milliseconds.

---

# `e.printStackTrace()`

A method from the `Throwable` class.
Prints the exception stack trace with line number to the console — helpful for debugging.

### Example:

```java
try {
    int x = 10 / 0;
} catch (ArithmeticException e) {
    e.printStackTrace();
}
```

---

# Deadlock

Occurs when two or more threads are permanently blocked, waiting for each other to release resources — none of them can proceed.

### Example 6:

```java
package com.tekgrads.multithreading;

public class Example12 {
    public static void main(String[] args) {
        try {
            Thread.currentThread().join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        for(int i = 1; i < 5; i++) {
            System.out.println("Main Thread " + i);
        }
    }
}
```

**Output:**

```
(no output)
```

> The current thread waits on itself using `join()`, causing a deadlock. Hence, no output is printed.


# `interrupt()`

**`interrupt()`**: Interrupts the thread (used to stop sleeping or waiting threads).

### Example 7

```java
package com.tekgrads.multithreading;

class Thread4 extends Thread {
    public void run() {
        for(int i = 1; i < 5; i++) {
            System.out.println("Child Thread " + i);
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

public class Example13 {
    public static void main(String[] args) {
        Thread4 t = new Thread4();
        t.start();
        t.interrupt();
        for(int i = 1; i < 5; i++) {
            System.out.println("Main Thread " + i);
        }
    }
}
```

**Output:**

```
Main Thread 1
Main Thread 2
Main Thread 3
Main Thread 4
Child Thread 1
java.lang.InterruptedException: sleep interrupted
	at java.base/java.lang.Thread.sleep0(Native Method)
	at java.base/java.lang.Thread.sleep(Thread.java:509)
	at com.tekgrads.multithreading.MyThread6.run(Example13.java:9)
Child Thread 2
Child Thread 3
Child Thread 4
```

---

# Synchronization – Thread Safety

Using synchronization prevents multiple threads from accessing shared resources simultaneously.

> The keyword for synchronization is `synchronized`.

By using `synchronized`, we can lock the code and prevent simultaneous access.

### Example:

```java
class Counter {
    int count = 0;

    synchronized void increment() {
        count++;
    }
}
```

---

## Types of Locks in Java

### 1. Object Lock

Applied for **non-static** methods.

**Real-world analogy:** Vacating a house — only one person can use it at a time.

```java
public synchronized void m1() {
    // only one thread can access this object at a time
}
```

### 2. Class Lock

Applied for **static** methods.

```java
public static synchronized void m1() {
    // locks the class, only one thread can access this static method at a time
}
```
