package com.tekgrads.multithreading;

import java.util.LinkedList;

class Queue {
    LinkedList buffer = new LinkedList();  // No generics
    int capacity = 3;

    public synchronized void produce(int value) {
        while (buffer.size() == capacity) {
            try {
                wait(); // wait if full
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        buffer.add(value); // add as Object
        System.out.println("Producer: " + value);
        notify(); // notify consumer
    }

    public synchronized void consume() {
        while (buffer.isEmpty()) {
            try {
                wait(); // wait if empty
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        Object val = buffer.removeFirst(); // consume as Object
        System.out.println("Consumer: " + val);
        notify(); // notify producer
    }
}

class ProducerThread extends Thread {
	Queue q;

    public ProducerThread(Queue q) {
        this.q = q;
    }

    public void run() {
        for (int i = 1; i <= 5; i++) {
            q.produce(i);
            try {
                Thread.sleep(400);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

class ConsumerThread extends Thread {
	Queue q;

    public ConsumerThread(Queue q) {
        this.q = q;
    }

    public void run() {
        for (int i = 1; i <= 5; i++) {
            q.consume();
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

public class ProducerConsumer {
    public static void main(String[] args) {
    	Queue queue1 = new Queue();
        ProducerThread producer = new ProducerThread(queue1);
        ConsumerThread consumer = new ConsumerThread(queue1);

        producer.start();
        consumer.start();
    }
}
