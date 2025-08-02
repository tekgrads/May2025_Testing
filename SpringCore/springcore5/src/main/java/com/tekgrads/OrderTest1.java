package com.tekgrads;

import java.util.List;

import org.springframework.stereotype.Component;

@Component
public class OrderTest1 {
	
	private List<Task> tasks;

	public OrderTest1(List<Task> tasks) {	
		this.tasks = tasks;
	}

	public List<Task> getTasks() {
		return tasks;
	}

	public void setTasks(List<Task> tasks) {
		this.tasks = tasks;
	}
	
	

}
