# Java Notes – Synchronization, Locks, and Inter-thread Communication

---

### ACID Properties

**Definition:**
ACID stands for Atomicity, Consistency, Isolation, and Durability; it defines the properties of reliable transactions in systems like databases.
**Use:** Ensures that concurrent operations result in a consistent and correct system state.

---

### Object Lock

**Definition:**
An object lock is a monitor lock acquired on a specific instance using synchronized methods or blocks.
**Use:** Ensures only one thread at a time can execute synchronized code on that object.

---

### Class Lock

**Definition:**
A class lock is obtained when a static synchronized method is accessed. It is shared across all instances of the class.
**Use:** Used when static members or operations shared by all instances need synchronized access.

---

### Synchronization Using Objects

**Definition:**
Synchronization using objects ensures thread-safe access to instance-level data.
**Use:** Prevents thread interference when multiple threads work on the same object.

```java
class Display {
    public synchronized void m1(String name) {
        for (int i = 1; i < 5; i++) {
            System.out.println("value is " + i);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(name);
        }
    }
}

class MyThreadSync extends Thread {
    Display d;
    String name;

    MyThreadSync(Display d, String name) {
        this.d = d;
        this.name = name;
    }

    public void run() {
        d.m1(name);
    }
}

public class Synchronize {
    public static void main(String[] args) {
        Display d = new Display();
        MyThreadSync t = new MyThreadSync(d, "thread1");
        t.start();

        Display d2 = new Display();
        MyThreadSync t2 = new MyThreadSync(d2, "thread2");
        t2.start();
    }
}
```

---

### Synchronization by Block

**Definition:**
A synchronized block locks only a specific portion of code using a reference object.
**Use:** Improves performance by reducing the scope of locking.

```java
class DisplayBlock {
    public void m1(String name) {
        System.out.println("Before Synchronized Block");
        synchronized(this) {
            for(int i = 1; i < 3; i++) {
                System.out.println("value of i is: " + i);
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(name);
            }
        }
    }
}

class MyThreadSyncBlock extends Thread {
    DisplayBlock d;
    String name;

    MyThreadSyncBlock(DisplayBlock d, String name) {
        this.d = d;
        this.name = name;
    }

    public void run() {
        d.m1(name);
    }
}

public class SynchronizeBlock {
    public static void main(String[] args) {
        DisplayBlock d = new DisplayBlock();
        MyThreadSyncBlock t  = new MyThreadSyncBlock(d, "thread1");
        t.start();
        MyThreadSyncBlock t2  = new MyThreadSyncBlock(d, "thread2");
        t2.start();
    }
}
```

---

### Inter-thread Communication

**Definition:**
Inter-thread communication allows threads to communicate and coordinate execution using `wait()`, `notify()`, and `notifyAll()`.
**Use:** Useful when threads need to wait for some condition or result from another thread.

```java
class InterThreadCommunication extends Thread {
    int total = 0;

    public void run() {
        synchronized(this) {
            System.out.println("Child Thread Execution Started");
            for(int i = 0; i <= 10; i++) {
                total = total + i;
            }
            System.out.println("Notification coming from Child Thread");
            this.notify();
        }
    }
}

public class InterThread {
    public static void main(String[] args) {
        InterThreadCommunication t = new InterThreadCommunication();
        t.start();

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        synchronized(t) {
            try {
                System.out.println("wait() Main thread");
                t.wait(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        System.out.println("Main Thread getting notification: " + t.total);
    }
}
```


