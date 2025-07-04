package com.tekgrads;

import java.util.Arrays;

public class Example1 {

	public static void main(String[] args) {
		int x[] = new int[10];
		
		
		for(int i=0;i<x.length;i++) {
			x[i]=i;
		}
		
		for(int i=0;i<x.length;i++) {
			System.out.println(x[i]);
		}
		System.out.println("----------------------");
		for(int i : x) {
			System.out.println(x[i]);
		}
		
		System.out.println(x);
		
		System.out.println(Arrays.toString(x));
		
	}

}
