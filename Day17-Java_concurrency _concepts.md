
# More Java Concurrency Concepts

Java provides a rich set of concurrency utilities and concepts beyond basic synchronization. Below are detailed explanations of key advanced concurrency concepts in Java.

---

## 1. Thread Lifecycle

Java threads have the following lifecycle stages:

- **New** – Thread is created but not started.
- **Runnable** – Thread is ready to run.
- **Running** – Thread is actively executing.
- **Blocked/Waiting** – Thread is waiting for a monitor lock or condition.
- **Terminated** – Thread has finished execution.

```java
Thread t = new Thread(() -> System.out.println("Running"));
t.start();
```

---

## 2. Executor Framework

The Executor framework simplifies thread management by separating task submission from thread creation.

### Example:
```java
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {
    public static void main(String[] args) {
        ExecutorService executor = Executors.newFixedThreadPool(2);
        executor.submit(() -> System.out.println("Task executed"));
        executor.shutdown();
    }
}
```

### Key Interfaces:
- `Executor`
- `ExecutorService`
- `ScheduledExecutorService`

---

## 3. Callable and Future

- `Callable` is like `Runnable`, but it can return a result and throw exceptions.
- `Future` is used to retrieve the result of a `Callable` asynchronously.

### Example:
```java
import java.util.concurrent.*;

public class FutureExample {
    public static void main(String[] args) throws Exception {
        ExecutorService executor = Executors.newSingleThreadExecutor();
        Future<Integer> future = executor.submit(() -> 123);
        System.out.println("Result: " + future.get());
        executor.shutdown();
    }
}
```

---

## 4. Thread Pools

Thread pools reuse threads to execute multiple tasks, reducing overhead.

- `FixedThreadPool`
- `CachedThreadPool`
- `ScheduledThreadPool`
- `SingleThreadExecutor`

```java
ExecutorService pool = Executors.newFixedThreadPool(5);
```

---

## 5. Synchronizers

Java provides classes like `CountDownLatch`, `CyclicBarrier`, and `Semaphore` to coordinate threads.

### CountDownLatch Example:
```java
CountDownLatch latch = new CountDownLatch(1);

new Thread(() -> {
    try {
        latch.await();
        System.out.println("Thread released");
    } catch (InterruptedException e) {}
}).start();

Thread.sleep(1000);
latch.countDown();
```

---

## 6. Concurrent Collections

These collections handle concurrent access without external synchronization.

- `ConcurrentHashMap`
- `CopyOnWriteArrayList`
- `BlockingQueue`

```java
ConcurrentHashMap<String, Integer> map = new ConcurrentHashMap<>();
map.put("A", 1);
```

---

## 7. Atomic Variables

Atomic classes (`AtomicInteger`, `AtomicBoolean`, etc.) provide lock-free thread-safe operations.

```java
AtomicInteger counter = new AtomicInteger(0);
counter.incrementAndGet();
```

---

## 8. Volatile Keyword

The `volatile` keyword ensures visibility of changes to variables across threads.

```java
volatile boolean running = true;
```

It does **not** ensure atomicity or mutual exclusion.

---

## 9. Deadlock

Occurs when two or more threads are blocked forever, each waiting for the other.

### Prevention Tips:
- Avoid nested locks
- Use timeout when trying to acquire locks
- Lock ordering

---

## 🧠 Summary

| Concept               | Description                             |
|------------------------|-----------------------------------------|
| Thread Lifecycle       | States from creation to termination     |
| Executor Framework     | Efficient task execution mechanism      |
| Callable/Future        | Return values from threads              |
| Synchronizers          | Coordinate thread behavior              |
| Concurrent Collections | Safe collections for multi-threading    |
| Atomic Variables       | Lock-free thread-safe primitives        |
| Volatile Keyword       | Ensures visibility across threads       |
| Deadlock               | Circular locking causing a freeze       |
