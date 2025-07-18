//Demonstrate a deadlock using two synchronized methods and two threads. Then, modify your code to resolve the deadlock.

package com.tekgrads.multithreading;

class D1 {
    synchronized void methodA(D2 b) {
        System.out.println(Thread.currentThread().getName() + " is executing methodA");
        try { 
        	Thread.sleep(1000);
        	} catch (InterruptedException e) {
    			e.printStackTrace();

        	}
        System.out.println(Thread.currentThread().getName() + " is trying to call B's last()");
        b.last();
    }

    synchronized void last() {
        System.out.println("Inside A's last() method");
    }
}

class D2 {
    synchronized void methodB(D1 a) {
        System.out.println(Thread.currentThread().getName() + " is executing methodB");
        try {
        	Thread.sleep(1000); 
        	} catch (InterruptedException e) {
    			e.printStackTrace();

        	}
        System.out.println(Thread.currentThread().getName() + " is trying to call A's last()");
        a.last();
    }

    synchronized void last() {
        System.out.println("Inside B's last() method");
    }
}

class MyThread5 extends Thread {
    D1 a;
    D2 b;

    MyThread5(D1 a, D2 b) {
        this.a = a;
        this.b = b;
    }

    public void run() {
        a.methodA(b);
    }
}

class MyThread6 extends Thread {
    D1 a;
    D2 b;

    MyThread6(D1 a, D2 b) {
        this.a = a;
        this.b = b;
    }

    public void run() {
        b.methodB(a);
    }
}

public class DeadLockSynchronized {
    public static void main(String[] args) {
        D1 a = new D1();
        D2 b = new D2();

        MyThread5 t1 = new MyThread5(a, b);
        MyThread6 t2 = new MyThread6(a, b);

        t1.start();
        t2.start();
    }
}
