package com.tekgrads;

public class Greeter {

	private HelloWorldMessage helloWorldMessage;

	public Greeter(HelloWorldMessage helloWorldMessage) {
		System.out.println("Greeter Created");
		this.helloWorldMessage = helloWorldMessage;
	}

	public void greet() {
		System.out.println(helloWorldMessage.getMessage());
	}

}
