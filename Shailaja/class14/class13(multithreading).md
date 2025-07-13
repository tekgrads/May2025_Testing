Multitasking
Definition: Performing multiple tasks at the same time.

Example: Running Zoom, Chrome, and Notepad simultaneously on a system.

Primitive Execution
CPU switches between tasks with small delays.

Example: Switching from Zoom to Notepad involves a slight delay.

Synchronous vs Asynchronous Processing
Synchronous Processing
Tasks execute one after another.

Each task waits for the previous one to finish.

Asynchronous Processing
Tasks execute independently.

A task does not wait for another to complete.

Choose based on requirement: synchronous is predictable, asynchronous offers better performance for independent tasks.

Multithreading
Allows concurrent execution of multiple threads.

Enhances performance by utilizing CPU efficiently.

Real-world example: Cooking while the washing machine runs.
Washing = one thread, Cooking = another thread.

Thread
A thread is an independent execution path.

Java has one default thread: the main thread.

Example 1: Basic Thread Program
java
Copy
Edit
public class Example1 {
    public static void main(String[] args) {
        for (int i = 0; i < 10; i++)
            System.out.println("Main Thread " + i);
    }
}
Output:

css
Copy
Edit
Main Thread 0
Main Thread 1
...
Main Thread 9
Creating Threads
Extend the Thread class.

Override the run() method.

Important Thread Methods
start() – Starts a thread

run() – Contains the thread logic

sleep(ms) – Pauses the thread

join() – Waits for another thread to finish

isAlive() – Checks if the thread is running

setName(), getName() – Sets/gets thread name

setPriority(), getPriority() – Sets/gets thread priority (range 1–10)

yield() – Suggests the scheduler to switch threads

interrupt(), isInterrupted() – Handles interruptions

Thread Scheduler
Manages execution order of threads.

Example: Like a traffic controller managing vehicle flow.

Example 2: Create a Thread
java
Copy
Edit
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
Thread Lifecycle
New – Thread created

Runnable – After start() is called

Running – Currently executing

Blocked/Waiting – Waiting for resource or thread

Terminated – Thread has finished execution

Lifecycle Path:
New → Runnable → Running → (Blocked/Waiting) → Runnable → Running → Terminated

Thread Priority
Helps the scheduler decide the execution order.

Priority range: 1 (lowest) to 10 (highest)

Default = 5

Example 3: Get/Set Thread Priority and Name
java
Copy
Edit
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
Output:

css
Copy
Edit
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
Overloading run() Method
Note: Thread always invokes the run() method with no arguments. Overloaded versions will not be called by start().

Example 4: Overloading run() in a Thread Class
java
Copy
Edit
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
Output:

mathematica
Copy
Edit
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
Using Runnable Interface
Java doesn't support multiple inheritance.

To avoid extending Thread, implement the Runnable interface.

Example 5: Creating Threads Using Runnable Interface
java
Copy
Edit
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
        r.run(); // Runs on main thread

        for (int i = 1; i < 5; i++) {
            System.out.println("Main thread " + i);
        }
    }
}
Output:

mathematica
Copy
Edit
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
Example 6: Creating Thread Using a Thread Object
java
Copy
Edit
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
Output:

mathematica
Copy
Edit
Child Thread 1
Child Thread 2
Child Thread 3
Child Thread 4
Main Thread 1
Main Thread 2
Main Thread 3
Main Thread 4