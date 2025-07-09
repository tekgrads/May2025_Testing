# Java Class – Day 17 Notes 🧵

## 🔐 More Java Concurrency Concepts – Explained with Fun

### 🔁 ReentrantLock (with tryLock and timeout)

```java
package com.tekgrads.multithreading;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

class MyThreadReentrantDemo4 extends Thread {

    ReentrantLock l;
    public MyThreadReentrantDemo4(String name, ReentrantLock l) {
        super(name);
        this.l = l;        
    }

    public void run() {
        do {
            try {
                if (l.tryLock(5000, TimeUnit.MILLISECONDS)) {
                    System.out.println(Thread.currentThread().getName() + " got the lock and performing safe operations");

                    try {
                        Thread.sleep(30000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                    l.unlock();
                    System.out.println(Thread.currentThread().getName() + " releasing the lock");
                    break;
                } else {
                    System.out.println(Thread.currentThread().getName() + " unable to get the lock and hence try again");
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        } while (true);
    }
}

public class ReentrantLockDemo4 {
    public static void main(String[] args) {
        ReentrantLock l = new ReentrantLock();
        MyThreadReentrantDemo4 t1 = new MyThreadReentrantDemo4("First Thread", l);
        MyThreadReentrantDemo4 t2 = new MyThreadReentrantDemo4("Second Thread", l);
        t1.start();
        t2.start();
    }
}
🔄 Synchronized ThreadLocal Demo

package com.tekgrads.multithreading;

class CustomerThread extends Thread {
    static Integer custId = 0;
    private static ThreadLocal tl = new ThreadLocal() {
        protected Object initialValue() {
            return ++custId;
        }
    };

    CustomerThread(String name) {
        super(name);
    }

    public void run() {
        System.out.println(Thread.currentThread().getName() + " executing with customerid: " + tl.get());
    }
}

public class ThreadLocalDemo3 {
    public static void main(String[] args) {
        CustomerThread c1 = new CustomerThread("Customer Thread 1");
        CustomerThread c2 = new CustomerThread("Customer Thread 2");
        CustomerThread c3 = new CustomerThread("Customer Thread 3");
        c1.start();
        c2.start();
        c3.start();
    }
}