//Write a program with two threads:- One prints even numbers from 1 to 20.- The other prints odd numbers from 1 to 20.  Use wait() and notify() to coordinate the threads.

package com.tekgrads.multithreading;
class EvenOddThread extends Thread {
    String even = "";
    String odd = "";

    public void run() {
        synchronized(this) {
            for (int i = 1; i <= 20; i++) {
                if (i % 2 == 0) {
                    even =even+i + " ";
                } else {
                    odd = odd+i + " ";
                }
            }
            notify(); // Notify main thread
        }
    }
}

public class InterThreadCommunicationEvenodd {
    public static void main(String[] args) {
        EvenOddThread t = new EvenOddThread();
        t.start();

        synchronized(t) {
            try {
                t.wait(); // Main thread waits for child
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        System.out.println("Even Numbers: " + t.even);
        System.out.println("Odd Numbers : " + t.odd);
    }
}
