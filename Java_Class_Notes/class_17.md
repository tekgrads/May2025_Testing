

#  Inter-Thread Communication in Java 

##  What is Inter-Thread Communication?
Inter-thread communication in Java allows synchronized threads to communicate with each other to achieve coordination.

Java provides:
- `wait()` – causes the thread to wait and release the lock.
- `notify()` – wakes up a single waiting thread.
- `notifyAll()` – wakes up all waiting threads.
- Locks and Conditions – from `java.util.concurrent.locks` package.
- `sleep()` – causes the thread to pause without releasing the lock.

> All of these methods, except `sleep()`, must be used inside synchronized blocks/methods.

---

##  1. Using `wait()` and `notify()`

###  Example: Producer and Consumer
```java
class Shared {
    int num;
    boolean available = false;

    synchronized void produce(int n) {
        try {
            while (available) wait();
            num = n;
            System.out.println("Produced: " + num);
            available = true;
            notify();
        } catch (InterruptedException e) {
            System.out.println(e);
        }
    }

    synchronized void consume() {
        try {
            while (!available) wait();
            System.out.println("Consumed: " + num);
            available = false;
            notify();
        } catch (InterruptedException e) {
            System.out.println(e);
        }
    }
}

class Producer extends Thread {
    Shared s;
    Producer(Shared s) { this.s = s; }
    public void run() { s.produce(10); }
}

class Consumer extends Thread {
    Shared s;
    Consumer(Shared s) { this.s = s; }
    public void run() { s.consume(); }
}

public class Main {
    public static void main(String[] args) {
        Shared shared = new Shared();
        new Producer(shared).start();
        new Consumer(shared).start();
    }
}
````

####  Output:

```
Produced: 10
Consumed: 10
```

---

## 🔸 2. Using `Lock` and `Condition`

###  Example: Using ReentrantLock and Condition

```java
import java.util.concurrent.locks.*;

class SharedLock {
    private int num;
    private boolean available = false;
    private final Lock lock = new ReentrantLock();
    private final Condition condition = lock.newCondition();

    void produce(int val) {
        lock.lock();
        try {
            while (available) condition.await();
            num = val;
            System.out.println("Produced: " + num);
            available = true;
            condition.signal();
        } catch (InterruptedException e) {
            System.out.println(e);
        } finally {
            lock.unlock();
        }
    }

    void consume() {
        lock.lock();
        try {
            while (!available) condition.await();
            System.out.println("Consumed: " + num);
            available = false;
            condition.signal();
        } catch (InterruptedException e) {
            System.out.println(e);
        } finally {
            lock.unlock();
        }
    }
}

public class LockMain {
    public static void main(String[] args) {
        SharedLock s = new SharedLock();
        new Thread(() -> s.produce(20)).start();
        new Thread(() -> s.consume()).start();
    }
}
```

####  Output:

```
Produced: 20
Consumed: 20
```

---

##  3. Using `Thread.sleep()` inside synchronized block

###  Example: sleep() demonstration

```java
class SleepExample {
    synchronized void show(String name) {
        for (int i = 1; i <= 2; i++) {
            System.out.println(name + " - Step " + i);
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                System.out.println(e);
            }
        }
    }
}

class SleepThread extends Thread {
    SleepExample se;
    String name;

    SleepThread(SleepExample se, String name) {
        this.se = se;
        this.name = name;
    }

    public void run() {
        se.show(name);
    }

    public static void main(String[] args) {
        SleepExample s = new SleepExample();
        new SleepThread(s, "Thread-1").start();
        new SleepThread(s, "Thread-2").start();
    }
}
```

####  Output 

```
Thread-1 - Step 1
Thread-1 - Step 2
Thread-2 - Step 1
Thread-2 - Step 2
```


```
