# ✅ Day 14 – Multithreading in Java (Threading Basics)

## 🔹 What is Multithreading?
Multithreading is a process of executing multiple threads (smallest units of a process) simultaneously for better CPU utilization and faster performance.

➡️ **Thread** = Lightweight sub-process  
➡️ It runs independently within a program.  
➡️ Multithreading improves the performance by executing multiple tasks in parallel.

## 🔹 Why Multithreading?
- Efficient use of CPU
- Executes multiple tasks concurrently
- Better system responsiveness (Ex: UI + Downloading)

## 🔹 Ways to Create Threads in Java

### 1. By Extending Thread class
```java
class MyThread extends Thread {
    public void run() {
        System.out.println("Thread is running...");
    }
}

public class Main {
    public static void main(String[] args) {
        MyThread t1 = new MyThread();
        t1.start(); // starts a new thread
    }
}
```

### 2. By Implementing Runnable Interface
```java
class MyRunnable implements Runnable {
    public void run() {
        System.out.println("Runnable thread running...");
    }
}

public class Main {
    public static void main(String[] args) {
        MyRunnable obj = new MyRunnable();
        Thread t1 = new Thread(obj);
        t1.start();
    }
}
```

## 🔹 Thread Methods

| Method        | Description                       |
|---------------|------------------------------------|
| `start()`     | Starts the thread                  |
| `run()`       | Defines thread logic               |
| `sleep(ms)`   | Pause the thread for ms time       |
| `join()`      | Wait for the thread to die         |
| `isAlive()`   | Checks if thread is running        |
| `getName()`/`setName()` | Thread naming             |

## 🔹 Thread Lifecycle
```
NEW → RUNNABLE → RUNNING → TERMINATED
             ↓
          BLOCKED / WAITING (sleep, wait)
```

## 🔹 Example with Multiple Threads
```java
class A extends Thread {
    public void run() {
        for (int i = 1; i <= 3; i++) {
            System.out.println("A Thread: " + i);
        }
    }
}

class B extends Thread {
    public void run() {
        for (int i = 1; i <= 3; i++) {
            System.out.println("B Thread: " + i);
        }
    }
}

public class Main {
    public static void main(String[] args) {
        A t1 = new A();
        B t2 = new B();
        t1.start();
        t2.start();
    }
}
```