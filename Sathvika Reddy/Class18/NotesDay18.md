
# Java Notes – ReentrantLock, tryLock, Executor Framework, ThreadLocal

---

### ReentrantLock

**Definition:**
`ReentrantLock` is a class in `java.util.concurrent.locks` that provides a more flexible lock mechanism than `synchronized`.
**Use:** Allows a thread to re-acquire the same lock multiple times without getting blocked.

```java
import java.util.concurrent.locks.ReentrantLock;

public class ReentrantLocking {
    public static void main(String[] args) {
        ReentrantLock l = new ReentrantLock();
        l.lock();
        l.lock();

        System.out.println("ReentrantLock : " + l.isLocked());
        System.out.println("Held by current thread: " + l.isHeldByCurrentThread());
        System.out.println("Queue length: " + l.getQueueLength());
        System.out.println("Hold count: " + l.getHoldCount());

        l.unlock();
        System.out.println("Hold count after unlock: " + l.getHoldCount());
        System.out.println("Is fair lock: " + l.isFair());
    }
}
```

---

### tryLock()

**Definition:**
`tryLock()` is a non-blocking attempt to acquire the lock. It returns `true` if the lock is acquired, otherwise `false`.
**Use:** Prevents a thread from waiting indefinitely for a lock.

```java
import java.util.concurrent.locks.ReentrantLock;

class MyThreadReentrant extends Thread {
    ReentrantLock l;

    public MyThreadReentrant(String name, ReentrantLock l) {
        super(name);
        this.l = l;
    }

    public void run() {
        if (l.tryLock()) {
            System.out.println(Thread.currentThread().getName() + " got the lock and performing safe operations");
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            l.unlock();
        } else {
            System.out.println(Thread.currentThread().getName() + " unable to get the lock and hence performing alternative operations");
        }
    }
}

public class ReentrantLocking1 {
    public static void main(String[] args) {
        ReentrantLock l = new ReentrantLock();
        MyThreadReentrant t1 = new MyThreadReentrant("First Thread", l);
        MyThreadReentrant t2 = new MyThreadReentrant("Second Thread", l);
        t1.start();
        t2.start();
    }
}
```

---

### ReentrantLock with Shared Resource

**Definition:**
ReentrantLock ensures mutual exclusion when multiple threads access shared data or logic.
**Use:** Provides thread-safe operations over shared resources.

```java
import java.util.concurrent.locks.ReentrantLock;

class Display1 {
    ReentrantLock l = new ReentrantLock();

    public void m1(String name) {
        l.lock();
        try {
            for (int i = 0; i < 2; i++) {
                System.out.println("value of i is " + i);
                Thread.sleep(2000);
                System.out.println(name);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            l.unlock();
        }
    }
}

class MyThreadReentrant1 extends Thread {
    Display1 d;
    String name;

    MyThreadReentrant1(Display1 d, String name) {
        this.d = d;
        this.name = name;
    }

    public void run() {
        d.m1(name);
    }
}

public class ReentrantLocking2 {
    public static void main(String[] args) {
        Display1 d = new Display1();
        MyThreadReentrant1 t1 = new MyThreadReentrant1(d, "core");
        MyThreadReentrant1 t2 = new MyThreadReentrant1(d, "java");
        t1.start();
        t2.start();
    }
}
```

---

### Executor Framework

**Definition:**
The Executor Framework is used to manage a pool of threads and execute submitted tasks asynchronously.
**Use:** Simplifies thread management by decoupling task submission from execution.

```java
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

class Job implements Runnable {
    String name;

    public Job(String name) {
        this.name = name;
    }

    public void run() {
        System.out.println(name + " job started by thread " + Thread.currentThread().getName());
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(name + " job completed by thread " + Thread.currentThread().getName());
    }
}

public class ExecutorFramework1 {
    public static void main(String[] args) {
        Job[] jobs = {
            new Job("Ramya"),
            new Job("Sowmya"),
            new Job("Laxmi"),
            new Job("Ruchitha"),
            new Job("Sneha"),
            new Job("Navya")
        };

        ExecutorService service = Executors.newFixedThreadPool(3);

        for (Job job : jobs) {
            service.submit(job);
        }

        service.shutdown();
    }
}
```

---

### ThreadLocal

**Definition:**
`ThreadLocal` provides thread-local variables, meaning each thread accessing it has its own independent copy.
**Use:** Useful for maintaining user context or per-thread data without interference.

```java
public class ThreadLocal2 {
    public static void main(String[] args) {
        ThreadLocal tl = new ThreadLocal() {
            protected Object initialValue() {
                return "core";
            }
        };

        System.out.println(tl.get());
        tl.set("java");
        System.out.println(tl.get());
        tl.remove();
        System.out.println(tl.get());
    }
}
```


