package ioStreams;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class Test2 {
	public static void main(String[] args) throws FileNotFoundException, IOException {
		
		//connection is established to the abc.txt file for reading
		FileInputStream fis = new FileInputStream("abc.txt");
		
		//reading data from abc.txt file
	/*	int data1 = fis.read();
		int data2 = fis.read();
		int data3 = fis.read();
		int data4 = fis.read();
		int data5 = fis.read();
		int data6 = fis.read();
		
		System.out.println(data1);
		System.out.println(data2);
		System.out.println(data3);
		System.out.println(data4);
		System.out.println(data5 + " " + (char)data5);
		System.out.println(data6 + " " + (char)data6);
	*/	
		int data;
		while((data = fis.read()) != -1) {
			System.out.println(data +"\t"+(char)data);
		}

		System.out.println("data retrived");
		fis.close();
	}

}
