package com.tekgrads;

public class HelloWorldMessage {

	String greetingMessage;

	public HelloWorldMessage(String greetingMessage) {		
		System.out.println("HelloWorldMessage Created");
		this.greetingMessage = greetingMessage;
	}

	public String getMessage() {
		return this.greetingMessage;
	}

	public String getGreetingMessage() {
		return greetingMessage;
	}

	public void setGreetingMessage(String greetingMessage) {
		this.greetingMessage = greetingMessage;
	}

}
