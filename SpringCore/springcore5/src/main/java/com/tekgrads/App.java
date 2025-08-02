package com.tekgrads;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan("com.tekgrads")
public class App {
	public static void main(String[] args) {
		AnnotationConfigApplicationContext ctxt = new AnnotationConfigApplicationContext(App.class);
		System.out.println("Context Initialized");
//		OrderTest orderTest = ctxt.getBean(OrderTest.class);
//
//		orderTest.getTaskA().execute();
//		orderTest.getTaskB().execute();
//
		OrderTest1 orderTest1 = ctxt.getBean(OrderTest1.class);

		for(Task task : orderTest1.getTasks()) {
			task.execute();
		}
		ctxt.close();
	}
}
