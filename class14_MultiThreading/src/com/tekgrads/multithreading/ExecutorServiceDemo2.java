package com.tekgrads.multithreading;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

class CountJob implements Callable{
	Integer  num;
	
	public CountJob(Integer num) {
		this.num = num;
	}
	
	public Object call() {
		System.out.println(Thread.currentThread().getName()+" "
				+ "is responsible to find sum of first "+ num+" numbers");
		Integer sum = 0;
		for(int i=0;i<num;i++) {
			sum = sum+i;
		}
		return sum;
	}
}


public class ExecutorServiceDemo2 {

	public static void main(String[] args) {
		
		CountJob [] jobs = {new CountJob(10),
				new CountJob(20),
				new CountJob(30),
				new CountJob(40),
				new CountJob(50),
				new CountJob(60),
				};
		ExecutorService service = Executors.newFixedThreadPool(3);
		
		for(CountJob job : jobs) {
			Future f = service.submit(job);
			try {
				System.out.println(f.get());
			} catch (InterruptedException | ExecutionException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		service.shutdown();
	}

}
