//Ticket Booking Simulation  
//Create a thread pool using Executors.newFixedThreadPool() to simulate a ticket booking system where 10 customers book from 3 ticket counters.

package com.tekgrads.multithreading;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

class TicketBooking implements Runnable {
    String customerName;

    public TicketBooking(String customerName) {
        this.customerName = customerName;
    }

    public void run() {
        System.out.println("Customer " + customerName + " started booking at counter " + 
            Thread.currentThread().getName());
        try {
            Thread.sleep(2000); // Simulate booking time
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Customer " + customerName + " completed booking at counter " + 
            Thread.currentThread().getName());
    }
}

public class ExecutorThreadPoolBooking {

    public static void main(String[] args) {

        // 10 customers
        TicketBooking[] bookings = {
            new TicketBooking("Ramya"),
            new TicketBooking("Sowmya"),
            new TicketBooking("Laxmi"),
            new TicketBooking("Ruchitha"),
            new TicketBooking("Sneha"),
            new TicketBooking("Navya"),
            new TicketBooking("kavya"),
            new TicketBooking("Rani"),
            new TicketBooking("Meena"),
            new TicketBooking("Roja")
        };

        // 3 ticket counters
        ExecutorService service = Executors.newFixedThreadPool(3);

        for (TicketBooking booking : bookings) {
            service.submit(booking);
        }

        service.shutdown(); // No new tasks will be accepted
    }
}
