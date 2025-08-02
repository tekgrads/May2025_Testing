package com.tekgrads;

import org.springframework.context.annotation.DependsOn;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;

@Component
@DependsOn("taskB")
@Order(1)
public class TaskA implements Task {

	public TaskA() {
		System.out.println("Task A created");
	}

	@Override
	public void execute() {
		System.out.println("Task A executed");

	}

	@PostConstruct
	public void postInit() {
		System.out.println("After task A got created");
	}

	@PreDestroy
	public void preDestroy() {
		System.out.println("Before task A getting destroyed");
	}

}
