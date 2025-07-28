
# 🧵 Java Multithreading Concepts

## ✅ Ways to Create a Thread

- **Extending the `Thread` class**
- **Implementing the `Runnable` interface**
- **Creating a `Thread` class object**

---

## 🔁 Constructor Overloading

Allows multiple constructors with different parameters.

---

## 💡 Example 1: Constructor Overloading + Thread Priority

```java
package com.tekgrads.multithreading;

class MyRunnable1 implements Runnable {
    @Override
    public void run() {
        for(int i = 1; i <= 5; i++) {
            System.out.println(Thread.currentThread().getName() + " " + i);
        }
    }
}

public class Example7 {
    public static void main(String[] args) {
        MyRunnable1 mr = new MyRunnable1();
        Thread t = new Thread(mr, "child-0");

        System.out.println("Priority of child-0: " + t.getPriority());
        System.out.println("Priority of main: " + Thread.currentThread().getPriority());

        t.setPriority(4);
        t.start();

        for(int i = 1; i <= 5; i++) {
            System.out.println("Main Thread: " + i);
        }
    }
}
```

### 🖨 Output:

```
Priority of child-0: 5
Priority of main: 5
Main Thread: 1
Main Thread: 2
Main Thread: 3
Main Thread: 4
Main Thread: 5
child-0 1
child-0 2
child-0 3
child-0 4
child-0 5
```

---

## 🧑‍🤝‍🧑 Thread Group

A **ThreadGroup** represents a group of threads.

### 🔸 Example 2:

```java
package com.tekgrads.multithreading;

class MyRunnable2 implements Runnable {
    public void run() {
        System.out.println(Thread.currentThread().getName());
    }
}

public class Example8 {
    public static void main(String[] args) {
        ThreadGroup tg = new ThreadGroup("GroupA");
        Runnable r = new MyRunnable2();

        Thread t1 = new Thread(tg, r, "1stgroup");
        Thread t2 = new Thread(tg, r, "2ndgroup");

        t1.start();
        t2.start();
    }
}
```

---

## 🧠 Thread Scheduler

- Manages execution order of threads.
- Based on **priority**.
- Default Priority: **5**
- Min Priority: **1**
- Max Priority: **10**

---

## 🔄 Thread Life Cycle

1. **New**
2. **Runnable**
3. **Running**
4. **Blocked/Waiting**
5. **Terminated**

---

## 💤 yield()

- Temporarily pauses the current thread, allowing others of same priority to execute.

### 🔸 Example 3:

```java
package com.tekgrads.multithreading;

class MyThreadYeild extends Thread {
    public void run() {
        for(int i = 1; i < 5; i++) {
            System.out.println(Thread.currentThread().getName() + " " + i);
            Thread.yield();
        }
    }
}

public class Example9 {
    public static void main(String[] args) {
        MyThreadYeild t = new MyThreadYeild();
        t.setName("Child-0");
        t.start();

        for(int i = 1; i < 5; i++) {
            System.out.println("Main thread " + i);
        }
    }
}
```

### 🖨 Output:
```
Child-0 1
Child-0 2
Child-0 3
Main thread 1
Main thread 2
Child-0 4
Main thread 3
Main thread 4
```

---

## 🔗 join()

Waits for a thread to complete before continuing.

### 🔸 Example 4:

```java
package com.tekgrads.multithreading;

class Thread2 extends Thread {
    public void run() {
        for(int i = 1; i <= 5; i++) {
            System.out.println("Child: " + i);
        }
    }
}

public class Example10 {
    public static void main(String[] args) throws InterruptedException {
        Thread2 t = new Thread2();
        t.start();
        t.join(); // main thread waits for t to finish
        System.out.println("Main thread waits after child thread.");
    }
}
```

### 🖨 Output:
```
Child: 1
Child: 2
Child: 3
Child: 4
Child: 5
Main thread waits after child thread.
```

---

## 🕓 sleep()

- `Thread.sleep(ms)` pauses the thread for a specified time.
- Throws `InterruptedException`.

### 🔸 Example 5:

```java
package com.tekgrads.multithreading;

class Thread3 extends Thread {
    public void run() {
        for(int i = 1; i < 5; i++) {
            System.out.println("Child Thread " + i);
            try {
                Thread.sleep(2000); // 2 seconds
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

public class Example11 {
    public static void main(String[] args) {
        Thread3 t = new Thread3();
        t.start();
        try {
            t.join(3000); // main thread waits max 3 seconds
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        for(int i = 1; i < 5; i++) {
            System.out.println("Main Thread " + i);
        }
    }
}
```

### 🖨 Output:
```
Child Thread 1
Child Thread 2
Main Thread 1
Main Thread 2
Main Thread 3
Main Thread 4
Child Thread 3
Child Thread 4
```

---

## 🐞 e.printStackTrace()

- Prints the exception and stack trace to the console.
- Helps in debugging.

### 🔸 Example:

```java
try {
    int x = 10 / 0;
} catch (ArithmeticException e) {
    e.printStackTrace();
}
```

---

## 🚫 Deadlock

Occurs when threads are **waiting on each other** forever.

### 🔸 Example 6:

```java
package com.tekgrads.multithreading;

public class Example12 {
    public static void main(String[] args) {
        try {
            Thread.currentThread().join(); // waits for itself
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        for(int i = 1; i < 5; i++) {
            System.out.println("Main Thread " + i);
        }
    }
}
```

### 🖨 Output:
```
(no output - deadlock)
```

---

## ⛔ interrupt()

Interrupts a sleeping or waiting thread.

### 🔸 Example 7:

```java
package com.tekgrads.multithreading;

class Thread4 extends Thread {
    public void run() {
        for(int i = 1; i < 5; i++) {
            System.out.println("Child Thread " + i);
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

public class Example13 {
    public static void main(String[] args) {
        Thread4 t = new Thread4();
        t.start();
        t.interrupt(); // send interrupt signal

        for(int i = 1; i < 5; i++) {
            System.out.println("Main Thread " + i);
        }
    }
}
```

---

## 🔒 Synchronization – Thread Safety

### Types of Locks in Java

1. **Object Lock** – synchronized methods/blocks on instance
2. **Class Lock** – synchronized static methods or blocks
