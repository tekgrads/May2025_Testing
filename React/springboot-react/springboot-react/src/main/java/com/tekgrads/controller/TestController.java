package com.tekgrads.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import pojo.Person;
import pojo.Test;

@RestController
@RequestMapping("test")
@CrossOrigin
public class TestController {
	@GetMapping("t1")
	public void test1() {
		System.out.println("I am from test1");

	}

	@GetMapping("t2")
	public String test2() {
		System.out.println("I am from test1");
		return "Hello to all from API";
	}

	@GetMapping("t3")
	public Test test3() {
		System.out.println("I am from test3");
		Test obj = new Test();
		obj.setMessage("I am from the server side API");
		return obj;
	}

	@GetMapping("t4")
	public String[] test4() {
		System.out.println("I am from test4");
		String[] names = { "ramu", "test", "hello" };
		return names;
	}

	@PostMapping("t12")
	public Person test12(@RequestBody Person person) {
		System.out.println(person.getFirstName());
		System.out.println(person.getLastName());
		System.out.println(person.getAge());
		return person;
	}
}