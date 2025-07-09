
# Java Class – Day 17 Notes

## 🔄 ReentrantLock with tryLock()

```java
if (lock.tryLock(5000, TimeUnit.MILLISECONDS)) {
    System.out.println("Got the lock and performing safe operations");
    Thread.sleep(30000);
    lock.unlock();
} else {
    System.out.println("Unable to get lock, retrying...");
}
```

✅ Safe for concurrent threads trying to acquire the same lock with timeout.

---

## 🔄 Synchronized ThreadLocal Example

```java
ThreadLocal tl = new ThreadLocal() {
    protected Object initialValue() {
        return ++custId;
    }
};

CustomerThread c1 = new CustomerThread("Thread 1");
CustomerThread c2 = new CustomerThread("Thread 2");
CustomerThread c3 = new CustomerThread("Thread 3");
c1.start();
c2.start();
c3.start();
```

✅ Each thread prints a unique customer ID using thread-local storage.
