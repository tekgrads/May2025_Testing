package com.tekgrads;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

class A {
	public void test1() {
		System.out.println("In test1 method");
	};
	public void test2() {
		System.out.println("in test2");
	};
}

public class Example1 {

	public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		String className = "com.tekgrads.A";
		
		loadClass(className);
		
				

	}

	private static void loadClass(String className) throws ClassNotFoundException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		Class c1 = Class.forName(className);
		
		Class c2 = Class.forName(className);
		
		
		System.out.println(c1 == c2);
		
		Method [] methods = c1.getDeclaredMethods();
		
		Object obj = c1.newInstance();
		
		for(Method m : methods) {
			System.out.println("Calling "+ m.getName());
			
			m.invoke(obj);
		}
		
		
		
		
	}

}
