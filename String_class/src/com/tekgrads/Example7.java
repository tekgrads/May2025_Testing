package com.tekgrads;

public class Example7 {

	public static void main(String[] args) {
		String names = "rakesh,suresh,ramesh,harish";
		
		String [] nameArray = names.split(",");
		
		for(String name : nameArray) {
			System.out.println(name);
		}

	}

}
