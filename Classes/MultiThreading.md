# 🧵 Multithreading in Java – Complete Notes

---

## 1. ✅ Basics of Multithreading

- A **thread** is a lightweight process.
- By default, Java runs the **main thread**.
- Multithreading allows concurrent execution of multiple tasks, increasing efficiency, especially in CPU- or I/O-bound operations.

---

## 2. 🛠️ Creating Threads

### a) Extending `Thread` Class


class MyThread extends Thread {
    public void run() {
        // thread task
    }
}
new MyThread().start();

b) Implementing Runnable Interface

class MyTask implements Runnable {
    public void run() {
        // task
    }
}
new Thread(new MyTask()).start();

3. 🔁 Thread Lifecycle
New – Thread object created.

Runnable – Ready to run.

Running – run() is executing.

Blocked/Waiting – Paused waiting for lock/signal.

Terminated – Execution finished or crashed.

4. 🔄 Inter-thread Communication & Synchronization


a) synchronized Keyword

synchronized(obj) {
    // critical section
}

b) wait(), notify(), notifyAll()

synchronized(obj) {
    while (!condition) obj.wait();
    // task
    obj.notify();
}

c) volatile Keyword


volatile boolean running = true;

d) Locks and Conditions

Lock lock = new ReentrantLock();
Condition cond = lock.newCondition();

lock.lock();
try {
    cond.await();      // like wait()
    cond.signal();     // like notify()
} finally {
    lock.unlock();
}

5. 📦 Executor Framework

a) ExecutorService

ExecutorService ex = Executors.newFixedThreadPool(4);
ex.submit(new MyRunnable());
ex.shutdown();

b) ScheduledExecutorService

ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(1);
scheduler.scheduleAtFixedRate(task, 1, 3, TimeUnit.SECONDS);

6. ⚠️ Concurrency Issues
a) Race Conditions
Occur when multiple threads access shared data without synchronization.

b) Deadlock
Two or more threads wait for each other to release locks.

c) Livelock
Threads are active but not progressing.

d) Starvation
A thread is perpetually denied access to resources.

7. 🧠 Thread Safety & Best Practices
Minimize synchronization scope.

Use immutable objects when possible.

Prefer thread-safe collections like ConcurrentHashMap.

Use atomic classes: AtomicInteger, AtomicBoolean.

8. 📚 High-Level Utilities (java.util.concurrent)
Executors – Manage thread pools

Futures – Handle results from threads

BlockingQueue – Thread-safe queue (ArrayBlockingQueue, LinkedBlockingQueue)

CountDownLatch, CyclicBarrier, Semaphore – Thread coordination

ConcurrentHashMap, CopyOnWriteArrayList – Safe shared collections

9. 🧰 Useful Thread Methods
Method	Purpose
start()	Starts the thread
run()	Thread’s task
sleep(ms)	Pauses thread temporarily
join()	Waits for another thread to finish
interrupt()	Interrupts a sleeping/waiting thread
setDaemon(true)	Makes a thread a background thread
setName(), getName()	Thread naming and identification

10. 🧠 Debugging & Best Practices
Use thread dumps (jstack, IDE tools) to analyze thread states.

Log Thread.currentThread().getName() for better traceability.

Avoid deadlocks by consistent lock ordering.

Minimize the number of threads — prefer thread pools over raw threads.

📘 Quick Summary Table
Concept	Description
extends Thread	Inherit thread class
implements Runnable	Implement run logic separately
synchronized	Lock on shared resource
wait()/notify()	Inter-thread coordination
volatile	Variable visibility between threads
Lock/Condition	Fine-grained lock control
ExecutorService	Managed thread pools
Atomic classes	Lock-free thread-safe operations
Concurrent Collections	Safe structures for shared access











 























