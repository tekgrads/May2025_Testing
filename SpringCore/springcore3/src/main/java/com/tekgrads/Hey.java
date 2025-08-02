package com.tekgrads;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
@Qualifier("hey")
@Primary
public class Hey implements Message{

	@Override
	public String getMessage() {
		// TODO Auto-generated method stub
		return "Hey";
	}

}
