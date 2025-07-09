# ✅ Day 16 – Synchronization, Locks & Inter-thread Communication

## 🔹 wait(), notify(), notifyAll()
Used for **communication between threads**.  
Must be used inside synchronized blocks/methods.

- `wait()` – thread waits  
- `notify()` – wakes up one waiting thread  
- `notifyAll()` – wakes up all waiting threads

## 🔹 Example:
```java
class Shared {
    boolean flag = false;

    synchronized void produce() throws InterruptedException {
        if (flag)
            wait(); // wait until consumed
        System.out.println("Producing item...");
        flag = true;
        notify();
    }

    synchronized void consume() throws InterruptedException {
        if (!flag)
            wait(); // wait until produced
        System.out.println("Consuming item...");
        flag = false;
        notify();
    }
}

public class Main {
    public static void main(String[] args) {
        Shared s = new Shared();

        Thread producer = new Thread(() -> {
            try {
                s.produce();
            } catch (InterruptedException e) {}
        });

        Thread consumer = new Thread(() -> {
            try {
                s.consume();
            } catch (InterruptedException e) {}
        });

        producer.start();
        consumer.start();
    }
}
```

## 🔹 Summary
- Synchronization: Controls access to shared data  
- Locks: Advanced control for synchronization  
- wait/notify: Used for thread communication