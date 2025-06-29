package com.tekgrads.multithreading;

public class ThreadLocalDemo2 {

	public static void main(String[] args) {
		ThreadLocal tl = new ThreadLocal() {
			protected Object initialValue() {
				return "abc";
			}
		};
		System.out.println(tl.get());
		tl.set("Ramesh");
		System.out.println(tl.get());
		tl.remove();
		System.out.println(tl.get());

	}

}
