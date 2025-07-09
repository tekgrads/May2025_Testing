# ✅ Day 17 – Synchronization, Locks, and Inter-Thread Communication in Java (Advanced)

## 🔹 Deadlock
Occurs when two or more threads are blocked forever, each waiting on the other.

```java
class A {
    synchronized void methodA(B b) {
        System.out.println("Thread1 starts execution of methodA");
        try { Thread.sleep(1000); } catch (InterruptedException e) {}
        b.last();
    }

    synchronized void last() {
        System.out.println("Inside A.last()");
    }
}

class B {
    synchronized void methodB(A a) {
        System.out.println("Thread2 starts execution of methodB");
        try { Thread.sleep(1000); } catch (InterruptedException e) {}
        a.last();
    }

    synchronized void last() {
        System.out.println("Inside B.last()");
    }
}

public class DeadlockExample extends Thread {
    A a = new A();
    B b = new B();

    public void run() {
        b.methodB(a);
    }

    public static void main(String[] args) {
        DeadlockExample d = new DeadlockExample();
        d.start();
        d.a.methodA(d.b);
    }
}
```

## 🔹 Avoiding Deadlock
- Lock ordering
- Use `tryLock()` with timeout (from `ReentrantLock`)

## 🔹 Thread.sleep() vs wait()
| Feature        | sleep()                | wait()                  |
|----------------|------------------------|--------------------------|
| Type           | Static method          | Object method            |
| Lock release   | Does **not** release   | Releases the lock        |
| Where used     | Any code block         | Inside synchronized only |

## 🔹 Daemon Thread
Background threads which run in support of user threads.  
Example: Garbage Collector

```java
Thread t = new Thread();
t.setDaemon(true);
```

## 🔹 yield() Method
Causes currently executing thread to pause and allow other threads of same priority to execute.

```java
Thread.yield();
```