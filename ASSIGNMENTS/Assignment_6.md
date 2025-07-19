
##  Part 1: Basics of Threads

###  Q1. Thread Creation

// Extending Thread class
class MyThread extends Thread {
    public void run() {
        System.out.println("Thread using Thread class: " + Thread.currentThread().getName());
    }
}

// Implementing Runnable interface
class MyRunnable implements Runnable {
    public void run() {
        System.out.println("Thread using Runnable interface: " + Thread.currentThread().getName());
    }
}

public class ThreadCreation {
    public static void main(String[] args) {
        MyThread t1 = new MyThread();
        Thread t2 = new Thread(new MyRunnable());

        t1.start();
        t2.start();
    }
}
```

---

###  Q2. Thread with Delay

```java
public class Printer extends Thread {
    public void run() {
        for (int i = 1; i <= 10; i++) {
            System.out.println("Number: " + i);
            try {
                Thread.sleep(1000); // 1-second delay
            } catch (InterruptedException e) {
                System.out.println("Thread interrupted");
            }
        }
    }

    public static void main(String[] args) {
        new Printer().start();
    }
}
```

---

##  Part 2: Synchronization

###  Q3. Bank Account Example

```java
class BankAccount {
    private int balance = 1000;

    public synchronized void deposit(int amount) {
        balance += amount;
        System.out.println("Deposited: " + amount + ", Balance: " + balance);
    }

    public synchronized void withdraw(int amount) {
        if (balance >= amount) {
            balance -= amount;
            System.out.println("Withdrawn: " + amount + ", Balance: " + balance);
        } else {
            System.out.println("Insufficient balance!");
        }
    }
}

public class BankTest {
    public static void main(String[] args) {
        BankAccount account = new BankAccount();

        Runnable task = () -> {
            account.deposit(500);
            account.withdraw(300);
        };

        Thread t1 = new Thread(task);
        Thread t2 = new Thread(task);
        t1.start();
        t2.start();
    }
}
```

---

###  Q4. Deadlock Scenario and Solution

```java
class A {
    synchronized void methodA(B b) {
        System.out.println("Thread A: locked A");
        try { Thread.sleep(100); } catch (Exception e) {}
        b.last();
    }

    synchronized void last() {
        System.out.println("Inside A.last()");
    }
}

class B {
    synchronized void methodB(A a) {
        System.out.println("Thread B: locked B");
        try { Thread.sleep(100); } catch (Exception e) {}
        a.last();
    }

    synchronized void last() {
        System.out.println("Inside B.last()");
    }
}

public class DeadlockDemo implements Runnable {
    A a = new A();
    B b = new B();

    public void run() {
        b.methodB(a); // Thread B
    }

    public static void main(String[] args) {
        DeadlockDemo demo = new DeadlockDemo();
        new Thread(demo).start();
        demo.a.methodA(demo.b); // Main Thread
    }
}
```


---

##  Part 3: Inter-thread Communication

###  Q5. Even-Odd Printing with wait() and notify()

```java
class PrintNumbers {
    private boolean isOdd = true;

    public synchronized void printOdd(int number) throws InterruptedException {
        while (!isOdd) wait();
        System.out.println("Odd: " + number);
        isOdd = false;
        notify();
    }

    public synchronized void printEven(int number) throws InterruptedException {
        while (isOdd) wait();
        System.out.println("Even: " + number);
        isOdd = true;
        notify();
    }
}

public class EvenOddTest {
    public static void main(String[] args) {
        PrintNumbers pn = new PrintNumbers();

        Thread t1 = new Thread(() -> {
            for (int i = 1; i <= 20; i += 2) {
                try {
                    pn.printOdd(i);
                } catch (InterruptedException e) {}
            }
        });

        Thread t2 = new Thread(() -> {
            for (int i = 2; i <= 20; i += 2) {
                try {
                    pn.printEven(i);
                } catch (InterruptedException e) {}
            }
        });

        t1.start();
        t2.start();
    }
}
```

---

##  Part 4: Thread Pool and Executors

###  Q6. Ticket Booking Simulation

```java
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

class TicketBooking implements Runnable {
    private String customerName;

    public TicketBooking(String name) {
        this.customerName = name;
    }

    public void run() {
        System.out.println("Booking ticket for " + customerName + " at " + Thread.currentThread().getName());
        try {
            Thread.sleep(500); // Simulate booking time
        } catch (InterruptedException e) {}
    }
}

public class TicketBookingApp {
    public static void main(String[] args) {
        ExecutorService service = Executors.newFixedThreadPool(3); // 3 counters

        for (int i = 1; i <= 10; i++) {
            service.execute(new TicketBooking("Customer " + i));
        }

        service.shutdown();
    }
}
```

---

##  Part 5: Real-world Simulation Project (Mini)

###  Q7. Producer-Consumer Problem

```java
import java.util.LinkedList;
import java.util.Queue;

class Buffer {
    private Queue<Integer> queue = new LinkedList<>();
    private final int SIZE = 5;

    public synchronized void produce(int value) throws InterruptedException {
        while (queue.size() == SIZE) {
            wait();
        }
        queue.add(value);
        System.out.println("Produced: " + value);
        notify();
    }

    public synchronized void consume() throws InterruptedException {
        while (queue.isEmpty()) {
            wait();
        }
        int val = queue.poll();
        System.out.println("Consumed: " + val);
        notify();
    }
}

public class ProducerConsumer {
    public static void main(String[] args) {
        Buffer buffer = new Buffer();

        Thread producer = new Thread(() -> {
            for (int i = 1; i <= 10; i++) {
                try {
                    buffer.produce(i);
                    Thread.sleep(300);
                } catch (InterruptedException e) {}
            }
        });

        Thread consumer = new Thread(() -> {
            for (int i = 1; i <= 10; i++) {
                try {
                    buffer.consume();
                    Thread.sleep(500);
                } catch (InterruptedException e) {}
            }
        });

        producer.start();
        consumer.start();
    }
}

