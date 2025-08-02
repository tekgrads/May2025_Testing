package com.tekgrads;

import org.springframework.stereotype.Component;

@Component
public class OrderTest {
	
	private TaskA taskA;
	private TaskB taskB;

	public OrderTest(TaskA taskA, TaskB taskB) {
		this.taskA = taskA;
		this.taskB = taskB;
	}

	public TaskA getTaskA() {
		return taskA;
	}

	public void setTaskA(TaskA taskA) {
		this.taskA = taskA;
	}

	public TaskB getTaskB() {
		return taskB;
	}

	public void setTaskB(TaskB taskB) {
		this.taskB = taskB;
	}
	
	
	
	

}
