package com.tekgrads;

import java.io.File;
import java.io.IOException;

public class Example2 {

	public static void main(String[] args) {
		File f = new File("test.txt");
		try {
			f.createNewFile();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
