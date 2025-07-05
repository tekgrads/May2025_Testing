# More Java Concurrency Concepts – Explained with Fun

## ReentrantLock – The VIP Bathroom Key

**Concept:** A reentrant lock allows a thread to re-acquire the lock it already holds.

**Example:** Bob gets the key to a VIP bathroom. If he forgets his phone and re-enters, he doesn't need a new key.

```java
ReentrantLock lock = new ReentrantLock();

void enterBathroom() {
    lock.lock();
    try {
        System.out.println(Thread.currentThread().getName() + " has the VIP bathroom key.");
        // Bob remembers he left his phone
        lock.lock();
        try {
            System.out.println(Thread.currentThread().getName() + " re-entered for his phone.");
        } finally {
            lock.unlock();
        }
    } finally {
        lock.unlock();
    }
}
```

**Takeaway:** ReentrantLock lets you re-enter without being thrown out.

---

## Executor Framework – ThreadPool Pizza Delivery

**Concept:** Manages a pool of worker threads to execute tasks efficiently.

**Example:** Imagine you have 3 pizza delivery guys (threads) ready. You take orders and they deliver.

```java
ExecutorService pizzaShop = Executors.newFixedThreadPool(3);

Runnable order = () -> System.out.println(Thread.currentThread().getName() + ": Delivered pizza!");

for (int i = 0; i < 6; i++) {
    pizzaShop.submit(order);
}

pizzaShop.shutdown();
```

**Takeaway:** ExecutorService is your pizza manager. You give orders, it assigns workers.

---

## ThreadLocal – Personal Diary

**Concept:** Each thread gets its own copy of a variable.

**Example:** Every roommate has their own diary. They write secrets, and no one else can see them.

```java
ThreadLocal<String> diary = ThreadLocal.withInitial(() -> "Empty diary");

Runnable task = () -> {
    diary.set(Thread.currentThread().getName() + "'s secrets");
    System.out.println(Thread.currentThread().getName() + ": " + diary.get());
};

new Thread(task, "Alice").start();
new Thread(task, "Bob").start();
```

**Takeaway:** ThreadLocal is a secret notebook – strictly private.

---

## InheritableThreadLocal – Family Recipe

**Concept:** A child thread inherits the value from its parent thread.

**Example:** Mom passes her secret cookie recipe to her kid thread. Kid tweaks it later.

```java
InheritableThreadLocal<String> recipe = new InheritableThreadLocal<>();
recipe.set("Grandma's cookie recipe");

Thread child = new Thread(() -> {
    System.out.println("Child got: " + recipe.get());
    recipe.set("Child's new cookie recipe");
    System.out.println("Child changed to: " + recipe.get());
});

child.start();
```

**Takeaway:** InheritableThreadLocal passes values down the family tree – but kids do their own thing.