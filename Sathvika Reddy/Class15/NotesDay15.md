
# Multithreading in Java (Threading, Synchronization, Locking)

Multithreading is like managing a team of overenthusiastic interns — everyone wants to do something, sometimes the same thing, and it can lead to chaos unless managed well.

## 1. Threading

Threads are individual paths of execution in a program.

### Example: Multiple Interns Doing Tasks
```java
class Intern extends Thread {
    private String task;

    Intern(String task) {
        this.task = task;
    }

    public void run() {
        System.out.println(task + " is being done by " + Thread.currentThread().getName());
    }
}

public class Office {
    public static void main(String[] args) {
        Intern intern1 = new Intern("Filing papers");
        Intern intern2 = new Intern("Making coffee");

        intern1.start();
        intern2.start();
    }
}
```


## 2. Synchronization

When multiple threads try to access the same resource, synchronization helps prevent conflict. It’s like having one intern at a time using the office printer.

### Example: Printing Without Collision
```java
class Printer {
    synchronized void print(String doc) {
        System.out.println("Printing: " + doc + " by " + Thread.currentThread().getName());
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            System.out.println("Printer was interrupted!");
        }
        System.out.println("Finished: " + doc);
    }
}

class PrintJob extends Thread {
    Printer printer;
    String document;

    PrintJob(Printer p, String doc) {
        this.printer = p;
        this.document = doc;
    }

    public void run() {
        printer.print(document);
    }
}

public class PrintOffice {
    public static void main(String[] args) {
        Printer printer = new Printer();
        PrintJob job1 = new PrintJob(printer, "Report.pdf");
        PrintJob job2 = new PrintJob(printer, "Resume.docx");

        job1.start();
        job2.start();
    }
}
```


## 3. Locking

Locks give you more control than `synchronized` blocks. It's like giving the intern a key to the file cabinet and making sure only one has it at a time.

### Example: Locking with ReentrantLock
```java
import java.util.concurrent.locks.ReentrantLock;

class SafeBox {
    private final ReentrantLock lock = new ReentrantLock();

    void access(String person) {
        lock.lock();
        try {
            System.out.println(person + " has the key and is accessing the box.");
            Thread.sleep(1000);
            System.out.println(person + " is done and returns the key.");
        } catch (InterruptedException e) {
            System.out.println(person + " got distracted and dropped the key.");
        } finally {
            lock.unlock();
        }
    }
}

class Person extends Thread {
    private SafeBox box;
    private String name;

    Person(SafeBox box, String name) {
        this.box = box;
        this.name = name;
    }

    public void run() {
        box.access(name);
    }
}

public class LockingExample {
    public static void main(String[] args) {
        SafeBox box = new SafeBox();
        Person p1 = new Person(box, "Alice");
        Person p2 = new Person(box, "Bob");

        p1.start();
        p2.start();
    }
}
```
