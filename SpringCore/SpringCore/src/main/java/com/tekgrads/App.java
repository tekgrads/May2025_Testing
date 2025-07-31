package com.tekgrads;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * Hello world!
 */
@Configuration
@ComponentScan("com.tekgrads")
public class App {
    public static void main(String[] args) {
        //HelloWorldMessage helloWorldMessage = new HelloWorldMessage();
    	AnnotationConfigApplicationContext ctxt = new AnnotationConfigApplicationContext(App.class);
    	//HelloWorldMessage helloWorldMessage = ctxt.getBean(HelloWorldMessage.class);
    	Greeter greeter = ctxt.getBean(Greeter.class);
    	//System.out.println(helloWorldMessage.getMessage());
        //greeter.greet();
        
        String names[] = ctxt.getBeanDefinitionNames();
        for(String name: names) {
        	System.out.println(name);
        	System.out.println(ctxt.getBeanDefinition(name));
        }
        //HelloWorldMessage helloWorldMessage = new HelloWorldMessage();
        greeter.greet();
        		
    }
}
