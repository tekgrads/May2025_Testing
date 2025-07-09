
# Java Class 18 Notes – 🔁 ReentrantLock & ThreadLocal

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
```

### ✅ Full Example: `DisplayReentrant`, `MyThreadReentrantDemo`, `ReentrantDemo2`

---

## 🔎 What is `ThreadLocal`?

- `ThreadLocal` is a special Java class in `java.lang`.
- Each thread gets its **own isolated copy** of a variable.

---

## 🧠 Why use `ThreadLocal`?

- Avoids shared mutable state.
- No need for synchronization.
- Great for user/session-specific data like:
  - User ID, context, DB connection

### ✅ Example:
```java
ThreadLocal tl = new ThreadLocal();
System.out.println(tl.get());
tl.set("ANUSHA");
System.out.println(tl.get());
tl.remove();
System.out.println(tl.get());
```

---

### 👨‍👩‍👧 InheritableThreadLocal
- Children inherit thread-local values from parent.

```java
protected Object initialValue() {
    return ++custId;
}
```
