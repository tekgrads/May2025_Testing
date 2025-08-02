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
public class App 
{
    public static void main( String[] args )
    {
    	AnnotationConfigApplicationContext ctxt = new AnnotationConfigApplicationContext(App.class);
    	Greeter greeter = ctxt.getBean(Greeter.class);
    	greeter.greet();
    }
}
