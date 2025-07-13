package com.tekgrads;
import java.io.File;

public class Example1 {

	public static void main(String[] args) {
		File f = new File("test");
		f.mkdir();
		System.out.println("done");

	}

}
