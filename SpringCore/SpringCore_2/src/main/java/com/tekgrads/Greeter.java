package com.tekgrads;

import org.springframework.stereotype.Component;

@Component
public class Greeter {

	private HelloWorldMessage helloWorldMessage;

	public Greeter(HelloWorldMessage helloWorldMessage) {

		this.helloWorldMessage = helloWorldMessage;
	}

	public void greet() {
		System.out.println(helloWorldMessage.getMessage());
	}

	public HelloWorldMessage getHelloWorldMessage() {
		return helloWorldMessage;
	}

	public void setHelloWorldMessage(HelloWorldMessage helloWorldMessage) {
		this.helloWorldMessage = helloWorldMessage;
	}
	
	

}
