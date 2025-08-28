package ioStreams;

import java.io.FileWriter;
import java.io.IOException;

public class Test3 {
public static void main(String[] args) throws IOException {
		
		//1. connecting to file for writing character
		FileWriter fw = new FileWriter("bbc.txt");
		
		//2. writing characters to the file
		fw.write('a');
		fw.write(98);
		fw.write(99);
		fw.write(65000);
		fw.write(66000);
		fw.write("Tekgrads");
		fw.flush();
		
		System.out.println("data is saved");
		fw.close();
		
	}

}
