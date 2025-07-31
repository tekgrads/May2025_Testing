package com.tekgrads;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Greeter {
	
	@Autowired
	HelloWorldMessage helloWorldMessage;
	
//	public Greeter(HelloWorldMessage helloWorldMessage) {
//		this.helloWorldMessage = helloWorldMessage;
//	}
	
	public void greet() {
		if(this.helloWorldMessage != null) {
			System.out.println(this.helloWorldMessage.getMessage());
		} else {
			System.out.println("Hello World message is not there.");
		}
		
	}

//	public HelloWorldMessage getHelloWorldMessage() {
//		return helloWorldMessage;
//	}
//
//	@Autowired
//	public void setHelloWorldMessage(HelloWorldMessage helloWorldMessage) {
//		this.helloWorldMessage = helloWorldMessage;
//	}
	
	
}
