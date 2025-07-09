
#  Threads and Multithreading in Java

##  What is a Thread?
A **thread** is a lightweight subprocess, the smallest unit of processing. It is a separate path of execution. Java allows concurrent execution of two or more parts of a program using **multithreading**.

##  What is Multithreading?
**Multithreading** is a Java feature that allows simultaneous execution of two or more threads. Each thread runs parallel to others.

>  Multithreading is mostly used in games, animation, servers, real-time systems, etc.

##  Benefits of Multithreading
- Efficient CPU utilization
- Better system performance
- Simultaneous task execution
- Cost-effective (shared memory)
- Useful for responsive UI applications

##  Thread Life Cycle
1. **New** → Thread is created  
2. **Runnable** → Ready to run  
3. **Running** → Currently executing  
4. **Blocked/Waiting** → Waiting for a resource  
5. **Terminated/Dead** → Execution completed  

##  Creating Threads in Java

###  1. By Extending `Thread` Class
```java
class MyThread extends Thread {
    public void run() {
        System.out.println("Thread is running...");
    }

    public static void main(String args[]) {
        MyThread t1 = new MyThread();
        t1.start(); // starts a new thread
    }
}
```

###  2. By Implementing `Runnable` Interface
```java
class MyRunnable implements Runnable {
    public void run() {
        System.out.println("Runnable thread running...");
    }

    public static void main(String args[]) {
        MyRunnable obj = new MyRunnable();
        Thread t1 = new Thread(obj);
        t1.start(); // starts the thread
    }
}
```

##  Difference Between `Thread` vs `Runnable`
| Feature               | Extending Thread           | Implementing Runnable         |
|----------------------|----------------------------|-------------------------------|
| Inheritance          | Not possible with other classes | Allows multiple inheritance |
| Code Sharing         | Difficult                  | Easier                        |
| Flexibility          | Less                       | More                          |

##  Creating Multiple Threads Example
```java
class MultiThreadDemo implements Runnable {
    public void run() {
        System.out.println(Thread.currentThread().getName() + " is running.");
    }

    public static void main(String args[]) {
        Thread t1 = new Thread(new MultiThreadDemo(), "Thread-1");
        Thread t2 = new Thread(new MultiThreadDemo(), "Thread-2");
        t1.start();
        t2.start();
    }
}
```

##  Useful Thread Methods
| Method               | Description                                |
|----------------------|--------------------------------------------|
| `start()`            | Starts thread                              |
| `run()`              | Contains code to run                       |
| `sleep(ms)`          | Pauses thread                              |
| `join()`             | Waits for thread to die                    |
| `setPriority(int)`   | Sets thread priority                       |
| `getPriority()`      | Returns thread priority                    |
| `currentThread()`    | Returns reference to current thread        |
| `isAlive()`          | Checks if thread is still running          |

##  Example with `sleep()` and `join()`
```java
class SleepJoinExample extends Thread {
    public void run() {
        for(int i = 1; i <= 3; i++) {
            try {
                Thread.sleep(1000);
            } catch(Exception e) {
                System.out.println(e);
            }
            System.out.println(i);
        }
    }

    public static void main(String args[]) {
        SleepJoinExample t1 = new SleepJoinExample();
        SleepJoinExample t2 = new SleepJoinExample();
        t1.start();
        try {
            t1.join(); // t2 will wait till t1 finishes
        } catch(Exception e) {
            System.out.println(e);
        }
        t2.start();
    }
}
```

##  Daemon Threads
- Threads running in background
- JVM terminates them when main thread dies

```java
class DaemonExample extends Thread {
    public void run() {
        if(Thread.currentThread().isDaemon())
            System.out.println("Daemon thread running...");
        else
            System.out.println("User thread running...");
    }

    public static void main(String[] args) {
        DaemonExample t1 = new DaemonExample();
        DaemonExample t2 = new DaemonExample();

        t1.setDaemon(true); // must be set before start()
        t1.start();
        t2.start();
    }
}
```
