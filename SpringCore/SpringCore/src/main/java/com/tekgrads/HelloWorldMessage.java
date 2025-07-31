package com.tekgrads;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class HelloWorldMessage {

	
	private Greeter greeter;

//	public HelloWorldMessage(Greeter greeter) {		
//		this.greeter = greeter;
//	}

	public Greeter getGreeter() {
		return greeter;
	}


	@Autowired
	public void setGreeter(Greeter greeter) {
		this.greeter = greeter;
	}

	public String getMessage() {
		return "Hello World";
	}
}
