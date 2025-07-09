# Day 15 Notes

## What is Threading?

Threading refers to the process of executing multiple threads (independent paths of execution) simultaneously within a single program.

In Java, a thread is a lightweight subprocess. Threads run independently but share the same memory space.

---

## ✅ Why Use Threads?

- Improves performance by utilizing CPU efficiently  
- Handles multiple tasks concurrently  
- Ideal for responsive applications (e.g., GUI, web servers)  
- Used in asynchronous programming (background tasks, timers, etc.)  

---

## 🚦 Types of Threads in Java

- **User Threads** – Created by the programmer  
- **Daemon Threads** – Background service threads (e.g., garbage collector)  

---

## 👨‍💻 Daemon Thread Example (Code)

```java
package com.tekgrads.multithreading;

class MyThreadDaemon extends Thread {
    public void run() {
        for(int i = 0; i < 10; i++) {
            System.out.println("Child Thread");
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

public class DaemonThreads {
    public static void main(String[] args) {
        System.out.println(Thread.currentThread().getName());
        System.out.println(Thread.currentThread().isDaemon());

        MyThreadDaemon t = new MyThreadDaemon();
        System.out.println(t.isDaemon());
        t.start();

        System.out.println("Main Completed");
    }
}
🔐 Synchronization in Threading
When multiple threads access shared resources, you must prevent data inconsistency using synchronization.

👨‍💻 Synchronization Example (Code)

package com.tekgrads.multithreading;

class Display {
    public synchronized void wish(String name) {
        for(int i = 1; i <= 10; i++) {
            System.out.println("Good Morning " + i);
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(name);
        }
    }
}

class MyThreadSyncDemo extends Thread {
    Display d;
    String name;

    MyThreadSyncDemo(Display d, String name) {
        this.d = d;
        this.name = name;
    }

    public void run() {
        d.wish(name);
    }
}

public class SynchronizedDemo {
    public static void main(String[] args) {
        Display d = new Display();
        MyThreadSyncDemo t = new MyThreadSyncDemo(d, "Dhoni");
        t.start();

        Display d2 = new Display();
        MyThreadSyncDemo t2 = new MyThreadSyncDemo(d2, "Sachin");
        t2.start();
    }
}