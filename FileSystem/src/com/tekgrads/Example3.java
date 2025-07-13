package com.tekgrads;

import java.io.FileWriter;
import java.io.IOException;

public class Example3 {

	public static void main(String[] args) {
		FileWriter out =null;
	try {
		 out = new FileWriter("test.txt");
		out.write("Hello");
	} catch (IOException e) {	
		e.printStackTrace();
	}finally {
		try {
			if(out != null) {
			out.flush();
			out.close();
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	

	}

}
