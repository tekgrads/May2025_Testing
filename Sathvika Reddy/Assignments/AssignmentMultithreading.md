# Assignment-Multithreading

## Q1. Thread Creation

### By Extending Thread Class

```java
class MyThread extends Thread {
    public void run() {
        System.out.println("Thread running using Thread class: " + Thread.currentThread().getName());
    }
}

public class ThreadExample1 {
    public static void main(String[] args) {
        MyThread t1 = new MyThread();
        t1.start();
    }
}
```

### By Implementing Runnable Interface

```java
class MyRunnable implements Runnable {
    public void run() {
        System.out.println("Thread running using Runnable interface: " + Thread.currentThread().getName());
    }
}

public class ThreadExample2 {
    public static void main(String[] args) {
        Thread t2 = new Thread(new MyRunnable());
        t2.start();
    }
}
```

**Explanation:**

* The first method uses inheritance by extending the `Thread` class.
* The second uses composition by passing a `Runnable` object to a `Thread` constructor.
* Both start their own execution when `start()` is called.

---

## Q2. Thread with Delay

```java
public class NumberPrinter extends Thread {
    public void run() {
        for (int i = 1; i <= 10; i++) {
            System.out.println("Number: " + i);
            try {
                Thread.sleep(1000); // wait for 1 second
            } catch (InterruptedException e) {
                System.out.println("Thread interrupted");
            }
        }
    }

    public static void main(String[] args) {
        new NumberPrinter().start();
    }
}
```

**Explanation:**

* The thread prints numbers from 1 to 10 with a one-second interval using `Thread.sleep(1000)`.
* This simulates a simple timed operation in a separate thread.

---

## Q3. Bank Account Example with Synchronization

```java
class BankAccount {
    private int balance = 1000;

    public synchronized void deposit(int amount) {
        balance += amount;
        System.out.println("Deposited " + amount + ", New Balance: " + balance);
    }

    public synchronized void withdraw(int amount) {
        if (balance >= amount) {
            balance -= amount;
            System.out.println("Withdrawn " + amount + ", New Balance: " + balance);
        } else {
            System.out.println("Insufficient funds. Balance: " + balance);
        }
    }
}

public class BankApp {
    public static void main(String[] args) {
        BankAccount account = new BankAccount();

        Runnable task1 = () -> {
            account.deposit(500);
            account.withdraw(700);
        };

        Runnable task2 = () -> {
            account.withdraw(300);
            account.deposit(100);
        };

        Thread t1 = new Thread(task1);
        Thread t2 = new Thread(task2);

        t1.start();
        t2.start();
    }
}
```

**Explanation:**

* The `synchronized` keyword ensures thread-safe access to the account.
* Without it, inconsistent balance updates may occur.

---

## Q4. Deadlock Scenario and Resolution

### Deadlock Example

```java
class DeadlockExample {
    private final Object lockA = new Object();
    private final Object lockB = new Object();

    public void methodOne() {
        synchronized (lockA) {
            System.out.println("Thread 1: Locked A");
            try { Thread.sleep(100); } catch (Exception e) {}
            synchronized (lockB) {
                System.out.println("Thread 1: Locked B");
            }
        }
    }

    public void methodTwo() {
        synchronized (lockB) {
            System.out.println("Thread 2: Locked B");
            try { Thread.sleep(100); } catch (Exception e) {}
            synchronized (lockA) {
                System.out.println("Thread 2: Locked A");
            }
        }
    }
}
```

### Deadlock Fix

```java
public class DeadlockFixed {
    public static void main(String[] args) {
        DeadlockExample obj = new DeadlockExample();

        Thread t1 = new Thread(() -> obj.methodOne());
        Thread t2 = new Thread(() -> obj.methodTwo());

        t1.start();
        t2.start();
    }
}
```

**Fix:**
Use the same locking order in both methods to prevent circular waiting.

---

## Q5. Even-Odd Printing using wait/notify

```java
class Printer {
    private boolean isOddTurn = true;

    public synchronized void printOdd(int number) throws InterruptedException {
        while (!isOddTurn) wait();
        System.out.println("Odd: " + number);
        isOddTurn = false;
        notify();
    }

    public synchronized void printEven(int number) throws InterruptedException {
        while (isOddTurn) wait();
        System.out.println("Even: " + number);
        isOddTurn = true;
        notify();
    }
}

public class EvenOddThreads {
    public static void main(String[] args) {
        Printer printer = new Printer();

        Thread oddThread = new Thread(() -> {
            for (int i = 1; i <= 20; i += 2) {
                try {
                    printer.printOdd(i);
                } catch (Exception e) {}
            }
        });

        Thread evenThread = new Thread(() -> {
            for (int i = 2; i <= 20; i += 2) {
                try {
                    printer.printEven(i);
                } catch (Exception e) {}
            }
        });

        oddThread.start();
        evenThread.start();
    }
}
```

**Explanation:**

* Odd and even threads take turns using `wait()` and `notify()`.
* Shared state `isOddTurn` controls whose turn it is.

---

## Q6. Ticket Booking Simulation with Executor

```java
import java.util.concurrent.*;

class BookingTask implements Runnable {
    private final int customerId;

    BookingTask(int id) {
        this.customerId = id;
    }

    public void run() {
        System.out.println("Customer " + customerId + " booked a ticket from counter " + Thread.currentThread().getName());
    }
}

public class TicketBookingSystem {
    public static void main(String[] args) {
        ExecutorService service = Executors.newFixedThreadPool(3);

        for (int i = 1; i <= 10; i++) {
            service.execute(new BookingTask(i));
        }

        service.shutdown();
    }
}
```

**Explanation:**

* A fixed-size thread pool simulates 3 counters handling 10 customer requests.
* `Executors.newFixedThreadPool()` manages thread reuse efficiently.

---

## Q7. Producer-Consumer Problem with wait/notify

```java
import java.util.LinkedList;
import java.util.Queue;

class SharedBuffer {
    private final Queue<Integer> buffer = new LinkedList<>();
    private final int SIZE = 5;

    public synchronized void produce(int value) throws InterruptedException {
        while (buffer.size() == SIZE) {
            wait();
        }
        buffer.add(value);
        System.out.println("Produced: " + value);
        notify();
    }

    public synchronized void consume() throws InterruptedException {
        while (buffer.isEmpty()) {
            wait();
        }
        int value = buffer.poll();
        System.out.println("Consumed: " + value);
        notify();
    }
}

public class ProducerConsumer {
    public static void main(String[] args) {
        SharedBuffer buffer = new SharedBuffer();

        Thread producer = new Thread(() -> {
            for (int i = 1; i <= 10; i++) {
                try {
                    buffer.produce(i);
                    Thread.sleep(200);
                } catch (InterruptedException e) {}
            }
        });

        Thread consumer = new Thread(() -> {
            for (int i = 1; i <= 10; i++) {
                try {
                    buffer.consume();
                    Thread.sleep(300);
                } catch (InterruptedException e) {}
            }
        });

        producer.start();
        consumer.start();
    }
}
```

**Explanation:**

* Producer waits if buffer is full; consumer waits if empty.
* Synchronization and condition handling done via `wait()`/`notify()`.


