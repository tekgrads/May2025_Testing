package com.tekgrads;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * Hello world!
 *
 */
@Configuration
@ComponentScan("com.tekgrads")
public class App {
	public static void main(String[] args) {
		AnnotationConfigApplicationContext ctxt = new AnnotationConfigApplicationContext(App.class);
		Greeter greeter = ctxt.getBean(Greeter.class);
		greeter.greet();

		HelloWorldMessage helloWorldMessage1 = ctxt.getBean(HelloWorldMessage.class);
		helloWorldMessage1.setGreetingMessage("New Hello world");
		
	
		HelloWorldMessage helloWorldMessage2 = ctxt.getBean(HelloWorldMessage.class);
		helloWorldMessage2.setGreetingMessage("New Hello world again");
		
		greeter.setHelloWorldMessage(helloWorldMessage1);
		greeter.greet();
		greeter.setHelloWorldMessage(helloWorldMessage2);
		greeter.greet();
		
		
		
	}

//	@Bean
//	Greeter getGreeter(HelloWorldMessage helloWorldMessage) {
//		return new Greeter(helloWorldMessage);
//	}
//
//	@Bean
//	HelloWorldMessage getHelloWorldMessage(String greetingMessage) {
//		return new HelloWorldMessage(greetingMessage);
//	}
//
//	@Bean
//	String getGreetingMessage() {
//		return "Hello World";
//	}
}
