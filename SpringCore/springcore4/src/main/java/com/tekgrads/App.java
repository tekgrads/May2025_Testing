package com.tekgrads;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;

/**
 * Hello world!
 *
 */
@Configuration
public class App {
	public static void main(String[] args) {
		AnnotationConfigApplicationContext ctxt = new AnnotationConfigApplicationContext(App.class);
		System.out.println("Context Initialized");
		Greeter greeter = ctxt.getBean(Greeter.class);
		greeter.greet();

	}

	@Bean
	//@Lazy
	Greeter getGreeter(HelloWorldMessage helloWorldMessage) {
		return new Greeter(helloWorldMessage);
	}

	@Bean
	@Lazy
	HelloWorldMessage getHelloWorldMessage(String greetingMessage) {
		return new HelloWorldMessage(greetingMessage);
	}

	@Bean
	String getGreetingMessage() {
		return "Hello World";
	}
}
