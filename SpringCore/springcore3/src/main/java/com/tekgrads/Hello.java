package com.tekgrads;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
@Qualifier("hello")

public class Hello implements Message{

	@Override
	public String getMessage() {
		
		return "Hello";
	}

}
