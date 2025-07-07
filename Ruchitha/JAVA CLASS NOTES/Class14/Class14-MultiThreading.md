
# 🧵 Multi-Threading in Java

## 📌 Definition

- **Multi-Threading**: Executing several tasks simultaneously where each task is part of the same program.
- **Multi-Tasking**: Each task runs independently and is not connected to others.

---

## 🛠️ Setup Instructions

1. Download **Eclipse** IDE.
2. Create a project (choose default or custom folder).
3. Create a **package name** and **class name**.

---

## 🧪 Example 1: Main Thread Loop

```java
package com.tekgrads.multithreading;

public class Example1 {

    public static void main(String[] args) {
        for(int i = 0; i < 10; i++)
            System.out.println("Main Thread " + i);
    }
}
```

### 🧾 Output
```
Main Thread 0
Main Thread 1
...
Main Thread 9
```

---

## 🔧 Thread Basics

- Use `myThread.start();` to start a thread.
- Create a class that extends `Thread`.
- Code to be executed in `run()` method.
- `start()` registers thread in **Thread Scheduler**.
- Thread Scheduler manages execution based on **priority**.

---

## 🔄 Thread Lifecycle

```
New → Ready/Runnable → Running → Dead
```

---

## 🧪 Example 2: Creating a Thread using `Thread` class

```java
package com.tekgrads.multithreading;

class MyThread extends Thread {
    @Override
    public void run() {
        for(int i = 1; i <= 10; i++) {
            System.out.println("Child Thread " + i);
        }
    }
}

public class Example2 {
    public static void main(String[] args) {
        MyThread myThread = new MyThread();
        myThread.start();
        for(int i = 1; i <= 10; i++)
            System.out.println("Main Thread " + i);
    }
}
```

### 🧾 Sample Output
```
Main Thread 1
Child Thread 1
Main Thread 2
Child Thread 2
...
```

---

## 🧩 Thread Methods

- `Thread.currentThread().getPriority();`
- `Thread.currentThread().getName();`

---

## 🧪 Example 3: Overloaded run and multiple `start()` calls

```java
package com.tekgrads.multithreading;

class MyThread extends Thread {
    @Override
    public void run() {
        for(int i = 1; i <= 10; i++) {
            System.out.println("Child Thread " + i);
        }
    }
    public void run(int i) {
        System.out.println("Overloaded Run method");
    }
}

public class Example1 {
    public static void main(String[] args) {
        MyThread myThread = new MyThread();
        myThread.start();  // Only the no-arg run() will be called
        // myThread.start(); // Will throw IllegalThreadStateException if called twice
        for(int i = 1; i <= 10; i++) {
            System.out.println("Main Thread " + i);
        }
    }
}
```

---

## 🧪 Example 4: Creating Thread using `Runnable` Interface

```java
package com.tekgrads.multithreading;

class MyRunnable implements Runnable {
    @Override
    public void run() {
        for(int i = 1; i <= 10; i++) {
            System.out.println("Child Thread " + i);
        }
    }
}

public class Example4 {
    public static void main(String[] args) {
        MyRunnable r = new MyRunnable();
        Thread t = new Thread(r);
        t.start();
        for(int i = 1; i <= 10; i++) {
            System.out.println("Main Thread " + i);
        }
    }
}
```

---

## 🧪 Example 5: Thread object wrapping a Thread subclass

```java
package com.tekgrads.multithreading;

class MyThread2 extends Thread {
    @Override
    public void run() {
        for(int i = 1; i <= 10; i++) {
            System.out.println("Child Thread " + i);
        }
    }
}

public class Example3 {
    public static void main(String[] args) {
        MyThread2 myThread = new MyThread2();
        Thread t = new Thread(myThread);
        t.start();
        for(int i = 1; i <= 10; i++) {
            System.out.println("Main Thread " + i);
        }
    }
}
```

---

## 🧠 Key Points

- `start()` is in **Thread** class, not `Runnable` interface.
- Do **not** call `start()` twice on the same thread instance.
- Overloading `run()` does **not** override it.
- Prefer `Runnable` when you don’t want to extend `Thread`.

---
