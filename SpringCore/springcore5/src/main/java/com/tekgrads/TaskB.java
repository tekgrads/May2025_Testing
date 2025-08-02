package com.tekgrads;

import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
//@Order(1)
public class TaskB implements Task{
	
	public TaskB() {
		System.out.println("Task B created");
	}


	@Override
	public void execute() {
		System.out.println("Task B executed");
		
	}

}
