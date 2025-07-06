🧵 Java Day 14 – Multithreading in Java

🌀Multithreading in Java

Multithreading in Java allows concurrent execution of two or more parts of a program.
It's like hosting a party and asking multiple friends to do different tasks at the same time.

🧵 What is a Thread?

A thread is a lightweight subprocess.
It's like a party guest who either eats, dances, or chats — sometimes all at once.

🔨Creating Threads

1.Extending the Thread Class

class DancingThread extends Thread {
    public void run() {
        System.out.println("Dancing like nobody's watching.");
    }
}

public class Party {
    public static void main(String[] args) {
        DancingThread thread = new DancingThread();
        thread.start();
    }
}

 2.Implementing the Runnable Interface

class SingingThread implements Runnable {
    public void run() {
        System.out.println("Singing the wrong lyrics with confidence.");
    }
}

public class KaraokeParty {
    public static void main(String[] args) {
        Thread thread = new Thread(new SingingThread());
        thread.start();
    }
}

🔄 Thread Lifecycle

* New
* Runnable
* Running
* Blocked/Waiting
* Terminated

Explanation:
Imagine a friend getting ready (New), starting the task (Runnable), doing the task (Running), waiting in line for food (Blocked), and finally going home (Terminated).

😴 Thread Sleep Example

public class LazyFriend extends Thread {
    public void run() {
        try {
            System.out.println("Starting task... then taking a nap.");
            Thread.sleep(2000);
            System.out.println("Woke up and finished the task.");
        } catch (InterruptedException e) {
            System.out.println("Someone rudely woke me up.");
        }
    }

    public static void main(String[] args) {
        LazyFriend friend = new LazyFriend();
        friend.start();
    }
}



