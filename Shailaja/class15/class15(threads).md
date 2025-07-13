Thread Concepts in Java
Ways to Create a Thread
By extending the Thread class

By implementing the Runnable interface

By passing a thread class object to a Thread constructor

Constructor Overloading
A class can have multiple constructors with different parameter lists.

java
Copy
Edit
class Test {
    Test() {}
    Test(int a) {}
    Test(int a, int b) {}
}
Example 1: Constructor Overloading in Threads and Thread Priority
java
Copy
Edit
class MyRunnable1 implements Runnable {
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
Output:

yaml
Copy
Edit
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
Note: If priority is not set, it inherits from the parent. Execution order may vary.

Thread Group
Represents a group of threads.

Helps manage threads logically as one unit.

Example 2: ThreadGroup Usage
java
Copy
Edit
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
Output:

Copy
Edit
1stgroup
2ndgroup
Thread Scheduler
Decides which thread runs when.

Influenced by thread priority.

Default = 5, Min = 1, Max = 10

Thread Life Cycle
sql
Copy
Edit
New → Runnable → Running → (Blocked/Waiting/Timed Waiting) → Runnable → Running → Terminated
yield()
Temporarily pauses the current thread to allow other threads of equal priority to run.

Example 3: yield()
java
Copy
Edit
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
Output:

cpp
Copy
Edit
Child-0 1
Child-0 2
Child-0 3
Main thread 1
Main thread 2
Child-0 4
Main thread 3
Main thread 4
join()
Waits for a thread to complete before continuing execution.

Example 4: join()
java
Copy
Edit
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
        t.join(); // waits for thread t
        System.out.println("Main thread waits after child thread.");
    }
}
Output:

makefile
Copy
Edit
Child: 1
Child: 2
Child: 3
Child: 4
Child: 5
Main thread waits after child thread.
sleep()
Pauses the thread for the given milliseconds.

Example 5: sleep() with join()
java
Copy
Edit
class Thread3 extends Thread {
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

public class Example11 {
    public static void main(String[] args) {
        Thread3 t = new Thread3();
        t.start();
        try {
            t.join(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        for(int i = 1; i < 5; i++) {
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
Main Thread 1
Main Thread 2
Main Thread 3
Main Thread 4
Child Thread 3
Child Thread 4
e.printStackTrace()
Prints error message, class name, method, and line number.

Useful for debugging.

Example:
java
Copy
Edit
try {
    int x = 10 / 0;
} catch (ArithmeticException e) {
    e.printStackTrace();
}
Deadlock
When threads wait for each other to release resources — results in no progress.

Example 6: Deadlock using join()
java
Copy
Edit
public class Example12 {
    public static void main(String[] args) {
        try {
            Thread.currentThread().join(); // thread waits on itself
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        for(int i = 1; i < 5; i++) {
            System.out.println("Main Thread " + i);
        }
    }
}
Output: (No output – program hangs)

interrupt()
Used to interrupt a sleeping or waiting thread.

Causes InterruptedException if the thread is in sleep/wait state.

Example 7: interrupt()
java
Copy
Edit
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
        t.interrupt(); // interrupts child thread
        for(int i = 1; i < 5; i++) {
            System.out.println("Main Thread " + i);
        }
    }
}
Output:

mathematica
Copy
Edit
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
Synchronization – Thread Safety
Why?
To prevent multiple threads from accessing shared data simultaneously.

How?
Using synchronized keyword.

Example:
java
Copy
Edit
class Counter {
    int count = 0;

    synchronized void increment() {
        count++;
    }
}
Types of Locks in Java
1. Object Lock
Used for non-static synchronized methods.
Only one thread per object can access the method.

java
Copy
Edit
public synchronized void m1() {
    // Only one thread can access this object at a time
}
2. Class Lock
Used for static synchronized methods.
Locks at the class level.

java
Copy
Edit
public static synchronized void m1() {
    // Only one thread can access this class at a time
}