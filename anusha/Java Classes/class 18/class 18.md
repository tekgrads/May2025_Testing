# Java Class 18 Notes – 🔁 ReentrantLock

## 🔎 What is ReentrantLock?

- Part of the `java.util.concurrent.locks` package.
- Provides **explicit locking** with more control than the `synchronized` keyword.
- Supports **reentrancy**, meaning:
  > A thread can acquire the same lock multiple times without getting blocked or deadlocked.

---

## 🧩 Why use ReentrantLock over `synchronized`?

| Feature                    | `synchronized`               | `ReentrantLock`                   |
|---------------------------|------------------------------|-----------------------------------|
| Locking mechanism         | Implicit                     | Explicit                          |
| Try to acquire lock?      | ❌ No                        | ✅ Yes (using `tryLock()`)        |
| Interruptible?            | ❌ No                        | ✅ Yes (using `lockInterruptibly()`) |
| Timeout capability        | ❌ No                        | ✅ Yes                            |
| Fairness policy           | ❌ No                        | ✅ Yes (constructor allows fairness) |
| Must manually release?    | ❌ No (automatic)            | ✅ Yes (must call `unlock()`)     |

---

## 🔐 Basic Syntax

```java
import java.util.concurrent.locks.ReentrantLock;

ReentrantLock lock = new ReentrantLock();

lock.lock();   // acquire the lock
try {
    // critical section
} finally {
    lock.unlock();  // always release the lock
}

package com.tekgrads.multithreading;

import java.util.concurrent.locks.ReentrantLock;

class DisplayReentrant {
	
	ReentrantLock l = new ReentrantLock();
	
	public  void wish(String name) {
		l.lock();
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
		l.unlock();
	}
}


class MyThreadReentrantDemo extends Thread {
	
	DisplayReentrant d;
	String name;
	MyThreadReentrantDemo(DisplayReentrant d, String name){
		this.d = d;
		this.name = name;
	}
	
	public void run() {
		d.wish(name);
	}
}


public class ReentrantDemo2 {

	public static void main(String[] args) {
		DisplayReentrant d = new DisplayReentrant();
		MyThreadReentrantDemo t  = new MyThreadReentrantDemo(d, "Dhoni");
		t.start();		
		MyThreadReentrantDemo t2  = new MyThreadReentrantDemo(d, "Sachin");
		t2.start();
		

	}

}


## 🔎 What is `ThreadLocal`?

- `ThreadLocal` is a special Java class provided in `java.lang` package.
- It provides **thread-local variables**, meaning:
  > Each thread accessing the variable gets its **own isolated copy**, independent from other threads.

---

## 🧠 Why use `ThreadLocal`?

- Helps avoid **shared mutable state** between threads.
- Removes the need for synchronization.
- Ideal for storing **user-specific or session-specific data** like:
  - User IDs
  - Security context
  - Database connections
  - Date formatters

---
Example:
package com.tekgrads.multithreading;

public class ThreadLocalDemo {

	public static void main(String[] args) {
		ThreadLocal tl = new ThreadLocal();
		System.out.println(tl.get());
		tl.set("ANUSHA");
		System.out.println(tl.get());
		tl.remove();
		System.out.println(tl.get());

	}

}

👨‍👩‍👧 InheritableThreadLocal
🔎 What is InheritableThreadLocal?
A child thread can inherit variable value from parent thread.
🧠 Real-Life Example: Recipe Book
Parent shares a recipe.
Child can modify or reuse.

EXAMPLE:
package com.tekgrads.multithreading;


class CustomerThread extends Thread {
	static Integer custId = 0;
	private static ThreadLocal tl = new ThreadLocal() {
		protected Object initialValue() {
			return ++custId;
		}
	};
	
	CustomerThread(String name){
		super(name);
	}
	
	public void run() {
		System.out.println(Thread.currentThread().getName()+" executing with customerid: "+ tl.get());
	}
}
public class ThreadLocalDemo3 {

	public static void main(String[] args) {
		
		CustomerThread c1 = new CustomerThread("Cutosmer Trhead 1");
		
		CustomerThread c2 = new CustomerThread("Cutosmer Trhead 2");
		
		CustomerThread c3 = new CustomerThread("Cutosmer Trhead 3");
		c1.start();
		c2.start();
		c3.start();

	}

}
