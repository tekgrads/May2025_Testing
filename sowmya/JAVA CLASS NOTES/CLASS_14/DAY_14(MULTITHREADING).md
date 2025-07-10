					# Multithreading 

## Multitasking

Multitasking means performing multiple tasks at the same time.

**Example:** Running Zoom, Chrome, and Notepad on a system simultaneously.

### Primitive Execution

The CPU swaps between tasks with some break time, deciding which task or thread to run next.

**Example:** Switching from Zoom to Notepad; a slight delay is observed.

---

## Synchronous vs Asynchronous

### Synchronous Processing

Tasks are executed one after another. Each task waits for the previous to finish.

### Asynchronous Processing

Tasks are executed independently. A task doesn't wait for another to finish.

Use synchronous or asynchronous depending on the situation.

---

## Multithreading

Multithreading allows multiple threads to run concurrently, improving performance.

**Real-world example:** While a washing machine runs, you can cook — both tasks are independent. Washing = one thread, Cooking = another.

### Thread

A thread is an independent path of execution. Java uses the **main thread** by default.

### Example 1: Basic Thread Program

```java
public class Example1 {
    public static void main(String[] args) {
        for (int i = 0; i < 10; i++)
            System.out.println("Main Thread " + i);
    }
}
```

**Output:**

```
Main Thread 0
Main Thread 1
...
Main Thread 9
```

---

## Creating Threads

Threads can be created by extending the `Thread` class and overriding the `run()` method.

### Important Thread Methods

* `start()` – Starts a thread
* `run()` – Code executed by the thread
* `sleep(ms)` – Pause the thread
* `join()` – Wait for a thread to finish
* `isAlive()` – Check if thread is running
* `setName()`, `getName()` – Manage thread names
* `setPriority()`, `getPriority()` – Manage priorities (1 to 10)
* `yield()` – Temporarily pause the current thread
* `interrupt()`, `isInterrupted()` – Manage interruptions

---

## Thread Scheduler

Manages multiple threads and their execution order.

**Example:** Traffic controller deciding which vehicle (thread) goes next.

### Example 2: Create a Thread

```java
class MyThread extends Thread {
    public void run() {
        for (int i = 1; i <= 10; i++) {
            System.out.println("Child Thread " + i);
        }
    }
}

public class Example2 {
    public static void main(String[] args) {
        MyThread myThread = new MyThread();
        myThread.start();
        for (int i = 1; i <= 10; i++) {
            System.out.println("Main thread " + i);
        }
    }
}
```

---

## Thread Lifecycle

1. **New** – Thread created
2. **Runnable** – `start()` is called
3. **Running** – Thread is running
4. **Blocked/Waiting** – Waiting for a resource or another thread
5. **Terminated** – Thread finishes execution

```
New → Runnable → Running → (Blocked/Waiting) → Runnable → Running → Terminated
```

---

## Thread Priority

Helps Thread Scheduler decide execution order. Default = 5.

### Example 3: Get/Set Thread Priority and Name

```java
class MyThread1 extends Thread {
    public void run() {
        System.out.println(Thread.currentThread().getPriority());
        System.out.println(Thread.currentThread().getName() + " in child");
        for (int i = 1; i < 5; i++) {
            System.out.println("Child Thread " + i);
        }
    }
}

public class Example3 {
    public static void main(String[] args) {
        MyThread1 myThread = new MyThread1();
        myThread.start();
        for (int i = 1; i < 5; i++) {
            System.out.println("Main thread " + i);
        }
        System.out.println(Thread.currentThread().getPriority());
        System.out.println(Thread.currentThread().getName() + " in main method");
        Thread.currentThread().setPriority(7);
        System.out.println(Thread.currentThread().getPriority());
    }
}
```

---



### Output 
```
5
Thread-0 in child
Main thread 1
Main thread 2
Main thread 3
Main thread 4
5
main in main method
7
Child Thread 1
Child Thread 2
Child Thread 3
Child Thread 4
```

---

## Example 4: Overloading `run()` in a Thread Class
```java
package com.tekgrads.multithreading;

class MyThread2 extends Thread {
    @Override
    public void run() {
        for (int i = 1; i <= 5; i++) {
            System.out.println("Child Thread " + i);
        }
    }
    public void run(int i) {
        System.out.println("Overloaded Run method");
    }
}

public class Example4 {
    public static void main(String[] args) {
        MyThread2 myThread = new MyThread2();
        myThread.start();
        for (int i = 1; i <= 5; i++) {
            System.out.println("Main Thread " + i);
        }
    }
}
```

### Output
```
Child Thread 1
Child Thread 2
Child Thread 3
Child Thread 4
Child Thread 5
Main Thread 1
Main Thread 2
Main Thread 3
Main Thread 4
Main Thread 5
```

> **Note:** There is no use in overloading the `run()` method. The `Thread` class always invokes the no-argument `run()` method when `start()` is called.

---

## Runnable Interface
Java doesn't allow multiple inheritance. To overcome this, we can implement the `Runnable` interface instead of extending `Thread`.

## Example 5: Creating Threads Using the Runnable Interface
```java
package com.tekgrads.multithreading;

class MyRunnable implements Runnable {
    @Override
    public void run() {
        for (int i = 1; i < 5; i++) {
            System.out.println("Child Thread " + i);
        }
    }
}

public class Example5 {
    public static void main(String[] args) {
        MyRunnable r = new MyRunnable();
        Thread t = new Thread(r);
        Thread t1 = new Thread(r); // Another child thread

        t.start();
        t1.start();
        r.run(); // This runs on the main thread

        for (int i = 1; i < 5; i++) {
            System.out.println("Main thread " + i);
        }
    }
}
```

### Output
```
Child Thread 1
Child Thread 2
Child Thread 3
Child Thread 4
Child Thread 1
Child Thread 2
Child Thread 3
Child Thread 4
Main thread 1
Main thread 2
Main thread 3
Main thread 4
```

---

## Example 6: Creating Thread Using a Thread Object
```java
package com.tekgrads.multithreading;

class MyThread4 extends Thread {
    @Override
    public void run() {
        for (int i = 1; i < 5; i++) {
            System.out.println("Child Thread " + i);
        }
    }
}

public class Example6 {
    public static void main(String[] args) {
        MyThread4 myThread = new MyThread4();
        Thread t = new Thread(myThread);
        t.start();

        for (int i = 1; i < 5; i++) {
            System.out.println("Main Thread " + i);
        }
    }
}
```

### Output
```
Child Thread 1
Child Thread 2
Child Thread 3
Child Thread 4
Main Thread 1
Main Thread 2
Main Thread 3
Main Thread 4
```

---


