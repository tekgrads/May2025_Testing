

##  Thread Implementation with Constructor Overloading

Java supports constructor overloading, which can be used to initialize threads with different parameters.

###  Example: Overloaded Constructor in Thread Class
```java
class MyThread extends Thread {
    String msg;

    MyThread() {
        msg = "Default message";
    }

    MyThread(String msg) {
        this.msg = msg;
    }

    public void run() {
        System.out.println("Thread says: " + msg);
    }

    public static void main(String[] args) {
        MyThread t1 = new MyThread();
        MyThread t2 = new MyThread("Hello from thread!");
        t1.start();
        t2.start();
    }
}
```
####  Output:
```
Thread says: Default message
Thread says: Hello from thread!
```

---

##  Different Types of Thread Constructors

| Constructor | Description |
|-------------|-------------|
| `Thread()` | Creates a new thread object without a task |
| `Thread(Runnable target)` | Accepts a runnable object |
| `Thread(Runnable target, String name)` | Runnable + name |
| `Thread(String name)` | Thread with name only |
| `Thread(ThreadGroup group, Runnable target)` | With thread group |
| `Thread(ThreadGroup group, Runnable target, String name)` | All combined |

---

##  Using `Thread.currentThread()`
```java
class CurrentThreadExample {
    public static void main(String[] args) {
        Thread t = Thread.currentThread();
        System.out.println("Current thread: " + t.getName());
    }
}
```
####  Output:
```
Current thread: main
```

---

##  Using Thread Priorities
```java
class PriorityExample extends Thread {
    public void run() {
        System.out.println(Thread.currentThread().getName() + " priority: " + Thread.currentThread().getPriority());
    }

    public static void main(String[] args) {
        PriorityExample t1 = new PriorityExample();
        PriorityExample t2 = new PriorityExample();
        
        t1.setPriority(Thread.MIN_PRIORITY); // 1
        t2.setPriority(Thread.MAX_PRIORITY); // 10

        t1.start();
        t2.start();
    }
}
```
####  Output (example, order may vary):
```
Thread-0 priority: 1
Thread-1 priority: 10
```

---

##  Using `Thread.currentThread().getPriority()`
```java
class GetPriority {
    public static void main(String[] args) {
        Thread t = Thread.currentThread();
        System.out.println("Main thread priority: " + t.getPriority());
    }
}
```
####  Output:
```
Main thread priority: 5
```

---

##  Using Priority Limits
```java
class PriorityLimit extends Thread {
    public void run() {
        System.out.println(getName() + " => " + getPriority());
    }

    public static void main(String[] args) {
        PriorityLimit t1 = new PriorityLimit();
        PriorityLimit t2 = new PriorityLimit();
        PriorityLimit t3 = new PriorityLimit();

        t1.setPriority(Thread.MIN_PRIORITY);   // 1
        t2.setPriority(Thread.NORM_PRIORITY);  // 5
        t3.setPriority(Thread.MAX_PRIORITY);   // 10

        t1.start();
        t2.start();
        t3.start();
    }
}
```
####  Output (order may vary):
```
Thread-0 => 1
Thread-1 => 5
Thread-2 => 10
```

---

##  Using `Thread.yield()`
```java
class YieldExample extends Thread {
    public void run() {
        for (int i = 0; i < 3; i++) {
            System.out.println(Thread.currentThread().getName() + " running");
            Thread.yield();
        }
    }

    public static void main(String[] args) {
        YieldExample t1 = new YieldExample();
        YieldExample t2 = new YieldExample();

        t1.start();
        t2.start();
    }
}
```
####  Output (may vary due to `yield()` behavior):
```
Thread-0 running
Thread-1 running
Thread-0 running
Thread-1 running
...
```

---

##  Multithreading Using `try-catch` Block
```java
class TryCatchThread extends Thread {
    public void run() {
        try {
            for (int i = 1; i <= 3; i++) {
                System.out.println(i);
                Thread.sleep(1000);
            }
        } catch (InterruptedException e) {
            System.out.println("Thread interrupted: " + e);
        }
    }

    public static void main(String[] args) {
        TryCatchThread t1 = new TryCatchThread();
        t1.start();
    }
}
```
####  Output:
```
1
(wait 1 sec)
2
(wait 1 sec)
3
```

---
