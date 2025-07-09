

#  Synchronization, Object Lock & Class Lock in Java 

##  What is Synchronization?
Synchronization in Java is a process of **controlling access** to shared resources by multiple threads to avoid data inconsistency.

It ensures that only **one thread can access** the critical section at a time.

---

## 🔹 Object Lock (Non Static-level Lock)
Each object in Java has a lock (monitor). When a thread accesses a `synchronized` **instance method or block**, it acquires the **object lock**.

###  Example: Object Lock with `synchronized` method
```java
class Printer {
    public synchronized void printMessage(String message) {
        for (int i = 0; i < 3; i++) {
            System.out.print("[ " + message);
            try { Thread.sleep(500); } catch (Exception e) {}
            System.out.println(" ]");
        }
    }
}

class MyThread extends Thread {
    Printer p;
    String msg;

    MyThread(Printer p, String msg) {
        this.p = p;
        this.msg = msg;
    }

    public void run() {
        p.printMessage(msg);
    }

    public static void main(String[] args) {
        Printer p = new Printer();
        MyThread t1 = new MyThread(p, "Hello");
        MyThread t2 = new MyThread(p, "World");

        t1.start();
        t2.start();
    }
}
````

####  Output:

```
[ Hello ]
[ Hello ]
[ Hello ]
[ World ]
[ World ]
[ World ]
```

---

##  Class Lock (Static-level Lock)

When a thread calls a `synchronized static` method, it acquires a **lock on the Class object**, not on the instance.

###  Example: Class Lock

```java
class Printer {
    public static synchronized void printStatic(String msg) {
        for (int i = 0; i < 3; i++) {
            System.out.print("[ " + msg);
            try { Thread.sleep(500); } catch (Exception e) {}
            System.out.println(" ]");
        }
    }
}

class MyStaticThread extends Thread {
    String msg;

    MyStaticThread(String msg) {
        this.msg = msg;
    }

    public void run() {
        Printer.printStatic(msg);
    }

    public static void main(String[] args) {
        MyStaticThread t1 = new MyStaticThread("Hi");
        MyStaticThread t2 = new MyStaticThread("Java");

        t1.start();
        t2.start();
    }
}
```

####  Output:

```
[ Hi ]
[ Hi ]
[ Hi ]
[ Java ]
[ Java ]
[ Java ]
```

---

##  Synchronized Block 

Used to **synchronize only part** of a method.

###  Example: Synchronized Block

```java
class Printer {
    void display(String name) {
        synchronized(this) {
            for (int i = 0; i < 3; i++) {
                System.out.print("[ " + name);
                try { Thread.sleep(400); } catch (Exception e) {}
                System.out.println(" ]");
            }
        }
    }
}

class SyncBlockThread extends Thread {
    Printer p;
    String name;

    SyncBlockThread(Printer p, String name) {
        this.p = p;
        this.name = name;
    }

    public void run() {
        p.display(name);
    }

    public static void main(String[] args) {
        Printer p = new Printer();
        SyncBlockThread t1 = new SyncBlockThread(p, "Alice");
        SyncBlockThread t2 = new SyncBlockThread(p, "Bob");

        t1.start();
        t2.start();
    }
}
```

####  Output:

```
[ Alice ]
[ Alice ]
[ Alice ]
[ Bob ]
[ Bob ]
[ Bob ]
```

---

## 🔹 `wish()` method with synchronized block and try-catch

```java
class Wisher {
    void wish(String name) {
        synchronized(this) {
            for (int i = 0; i < 3; i++) {
                System.out.print("Good Morning, " + name);
                try { Thread.sleep(500); } catch (InterruptedException e) {
                    System.out.println("Interrupted: " + e);
                }
                System.out.println();
            }
        }
    }
}

class WishThread extends Thread {
    Wisher w;
    String name;

    WishThread(Wisher w, String name) {
        this.w = w;
        this.name = name;
    }

    public void run() {
        w.wish(name);
    }

    public static void main(String[] args) {
        Wisher w = new Wisher();
        WishThread t1 = new WishThread(w, "Sathvika");
        WishThread t2 = new WishThread(w, "Appana");

        t1.start();
        t2.start();
    }
}
```

####  Output:

```
Good Morning, Sathvika
Good Morning, Sathvika
Good Morning, Sathvika
Good Morning, Appana
Good Morning, Appana
Good Morning, Appana
```
