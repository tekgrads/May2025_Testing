package com.tekgrads;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class Greeter {

	private Message message;

	public Greeter( Message message) {

		this.message = message;
	}

	public void greet() {
		System.out.println(message.getMessage());
	}

	
	
	

}
