
# Java Concepts: Multithreading and Constructor Overloading

## 1. Multithreading in Java

### What is Multithreading?

Multithreading is a Java feature that allows the execution of two or more parts of a program simultaneously. Each part of such a program is called a thread, and each thread runs parallel to others.

Java multithreading is used to perform multiple tasks at the same time, making applications more efficient.

### Key Concepts

- **Thread**: A thread is a lightweight subprocess, the smallest unit of processing.
- **Main Thread**: When a Java program starts, one thread runs — known as the main thread.
- **Thread Class**: Java provides a `Thread` class to create and control threads.
- **Runnable Interface**: You can also create threads by implementing the `Runnable` interface.

### Ways to Create a Thread

#### 1. By Extending the `Thread` Class

```java
class MyThread extends Thread {
    public void run() {
        System.out.println("Thread is running...");
    }

    public static void main(String[] args) {
        MyThread t1 = new MyThread();
        t1.start();  // Start the thread
    }
}
```

#### 2. By Implementing the `Runnable` Interface

```java
class MyRunnable implements Runnable {
    public void run() {
        System.out.println("Runnable thread is running...");
    }

    public static void main(String[] args) {
        Thread t1 = new Thread(new MyRunnable());
        t1.start();
    }
}
```

### Benefits of Multithreading

- Efficient CPU usage
- Improved performance
- Better resource sharing
- Simultaneous multitasking

---

## 2. Constructor Overloading in Java

### What is a Constructor?

A constructor is a special method in Java used to initialize objects. It has the same name as the class and no return type.

### Constructor Overloading

Constructor overloading means having more than one constructor in a class with different parameter lists.

Java determines which constructor to call based on the number and type of arguments passed.

### Example:

```java
class Student {
    int id;
    String name;

    // Constructor with no parameters
    Student() {
        id = 0;
        name = "Not Assigned";
    }

    // Constructor with one parameter
    Student(int i) {
        id = i;
        name = "Unknown";
    }

    // Constructor with two parameters
    Student(int i, String n) {
        id = i;
        name = n;
    }

    void display() {
        System.out.println("ID: " + id + ", Name: " + name);
    }

    public static void main(String[] args) {
        Student s1 = new Student();
        Student s2 = new Student(101);
        Student s3 = new Student(102, "Alice");

        s1.display();
        s2.display();
        s3.display();
    }
}
```

### Benefits of Constructor Overloading

- Increases code readability and reusability.
- Allows different ways of initializing objects.
- Reduces code duplication.

---

