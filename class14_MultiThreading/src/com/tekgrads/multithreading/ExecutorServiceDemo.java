package com.tekgrads.multithreading;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

class PrintJob implements Runnable{
	String name;
	
	public PrintJob(String name) {
		this.name = name;
	}
	
	public void run() {
		System.out.println(name+" "+"job started by thread "+ 
	Thread.currentThread().getName());
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(name+" "+"job completed by thread "+ 
				Thread.currentThread().getName());
	}
}


public class ExecutorServiceDemo {

	public static void main(String[] args) {
		
		PrintJob [] jobs = {new PrintJob("Ramesh"),
				new PrintJob("Suresh"),
				new PrintJob("Rakesh"),
				new PrintJob("Ajay"),
				new PrintJob("Sumanth"),
				new PrintJob("Pavan"),
				};
		ExecutorService service = Executors.newFixedThreadPool(3);
		
		for(PrintJob job : jobs) {
			service.submit(job);
		}
		
		service.shutdown();
	}

}
