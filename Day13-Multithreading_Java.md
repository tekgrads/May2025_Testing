
# Multithreading in Java

Multithreading in Java is a process of executing two or more threads simultaneously. A thread is a lightweight subprocess, the smallest unit of processing. Multithreading is used to achieve multitasking and better resource utilization.

## Benefits of Multithreading
- **Improved performance**: Multiple operations can run concurrently.
- **Resource sharing**: Threads share the same memory space.
- **Responsiveness**: Applications remain responsive (e.g., in GUI applications).
- **Better system utilization**: Exploits multicore processors more efficiently.

## Lifecycle of a Thread
1. **New** – Thread is created but not yet started.
2. **Runnable** – Thread is ready to run and is waiting for CPU allocation.
3. **Running** – Thread is executing.
4. **Blocked/Waiting** – Thread is waiting for a resource or signal.
5. **Terminated** – Thread has completed execution.

## Creating Threads in Java

### 1. By extending the `Thread` class
```java
class MyThread extends Thread {
    public void run() {
        System.out.println("Thread is running...");
    }

    public static void main(String args[]) {
        MyThread t1 = new MyThread();
        t1.start();
    }
}
```

### 2. By implementing the `Runnable` interface
```java
class MyRunnable implements Runnable {
    public void run() {
        System.out.println("Thread is running...");
    }

    public static void main(String args[]) {
        Thread t1 = new Thread(new MyRunnable());
        t1.start();
    }
}
```

## Thread Methods
- `start()` – Starts the thread.
- `run()` – Contains the code executed by the thread.
- `sleep(milliseconds)` – Makes the thread sleep.
- `join()` – Waits for a thread to die.
- `isAlive()` – Checks if a thread is alive.

## Thread Synchronization
When multiple threads try to access a shared resource, data inconsistency can occur. Synchronization is used to control access.

### Synchronized Block
```java
synchronized(object) {
    // code block
}
```

### Synchronized Method
```java
public synchronized void method() {
    // code
}
```

## Inter-thread Communication
- Uses `wait()`, `notify()`, and `notifyAll()` methods.
- Helps threads communicate with each other about changes in state.

## Example: Thread Communication
```java
class Shared {
    synchronized void printTable(int n) {
        for (int i = 1; i <= 5; i++) {
            System.out.println(n * i);
            try {
                Thread.sleep(400);
            } catch (Exception e) {
                System.out.println(e);
            }
        }
    }
}

class MyThread1 extends Thread {
    Shared t;
    MyThread1(Shared t) {
        this.t = t;
    }
    public void run() {
        t.printTable(5);
    }
}

class MyThread2 extends Thread {
    Shared t;
    MyThread2(Shared t) {
        this.t = t;
    }
    public void run() {
        t.printTable(100);
    }
}

public class Test {
    public static void main(String args[]) {
        Shared obj = new Shared();
        MyThread1 t1 = new MyThread1(obj);
        MyThread2 t2 = new MyThread2(obj);
        t1.start();
        t2.start();
    }
}
```

## Daemon Threads
- Background threads that provide services to user threads.
- Use `setDaemon(true)` method before calling `start()`.

## Conclusion
Multithreading enhances the performance of Java applications by executing multiple threads simultaneously. Proper synchronization and communication are key to managing shared resources and avoiding data inconsistencies.
