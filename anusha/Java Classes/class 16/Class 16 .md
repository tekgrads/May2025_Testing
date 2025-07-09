# Java Class 16 Notes – Synchronization, Locks, and Inter-Thread Communication

## 🧵 1. Introduction to Thread Synchronization

**Multithreading** allows concurrent execution of two or more threads. However, when multiple threads access shared resources (like variables or objects), **thread interference** and **memory consistency errors** can occur.

### 🚧 Thread Interference Problem:
- Happens when multiple threads modify shared data simultaneously.
- Leads to **race conditions** where output is unpredictable.

### 🔐 Solution: Synchronization
- Synchronization ensures only one thread accesses a critical section at a time.

---

## 🔒 2. `synchronized` Keyword

The `synchronized` keyword prevents thread interference and memory consistency errors.

### 🔹 Syntax:

#### (i) Synchronized Method:
```java
public synchronized void increment() {
    count++;
}
EXAMPLE:
package com.tekgrads.multithreading;

class Display {
	
	public synchronized  void wish(String name) {
		for(int i =1;i<11;i++) {
			System.out.println("Good Morning "+i);
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println(name);
		}
	}
}


class MyThreadSyncDemo extends Thread {
	
	Display d;
	String name;
	MyThreadSyncDemo(Display d, String name){
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
		MyThreadSyncDemo t  = new MyThreadSyncDemo(d, "Dhoni");
		t.start();
		Display d2 = new Display();
		MyThreadSyncDemo t2  = new MyThreadSyncDemo(d2, "Sachin");
		t2.start();
		

	}

}

Reentrant Locks (from java.util.concurrent.locks)
Java 5 introduced explicit locking via Lock interface.

✅ ReentrantLock Class
Offers more control than synchronized.

Must manually acquire and release locks.

EXAMPLE:

package com.tekgrads.multithreading;

import java.util.concurrent.locks.ReentrantLock;

public class ReentrantLockDemo {

	public static void main(String[] args) {
		ReentrantLock l = new ReentrantLock();
		l.lock();
		l.lock();
		System.out.println(l.isLocked());
		System.out.println(l.isHeldByCurrentThread());
		System.out.println(l.getQueueLength());
		System.out.println(l.getHoldCount());
		l.unlock();
		System.out.println(l.getHoldCount());
		System.out.println(l.isFair());

	}

}

✅ Benefits of ReentrantLock:
Try-lock mechanisms

Timed lock attempts

Interruptible lock waits

 Inter-Thread Communication (wait(), notify(), notifyAll())
Used for coordinating actions between threads. Defined in the Object class.

📌 wait()
Causes current thread to wait until another thread invokes notify() or notifyAll().

📌 notify()
Wakes up a single thread waiting on that object.

📌 notifyAll()
Wakes up all threads waiting on that object.

⚠️ These must be called inside a synchronized block or method, or IllegalMonitorStateException will occur.
EXAMPLE:
package com.tekgrads.multithreading;


class ThreadComm extends Thread {
	int total = 0;
	public void run() {
		synchronized(this) {
			System.out.println("Child Thread Execution Started");
		for(int i=0;i<=100;i++) {
			total = total+i;
		}
		System.out.println("Child Thread Giving Notification");
		this.notify();
		}
	}
}

public class InterThreadComm {

	public static void main(String[] args)   {
		ThreadComm t = new ThreadComm();
		t.start();
//		try {
//			Thread.currentThread().sleep(2000);
//		} catch (InterruptedException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
				
		synchronized(t) {
		try {
			System.out.println("Main thread calling wait");
			t.wait(10000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		}
		System.out.println("Main Thread got notification "+t.total);

	}

}

Summary
Synchronization prevents race conditions.

Locks provide more flexibility (e.g., ReentrantLock).

Inter-thread communication allows coordination (wait(), notify()).

Understand proper locking to avoid deadlocks and resource contention.

