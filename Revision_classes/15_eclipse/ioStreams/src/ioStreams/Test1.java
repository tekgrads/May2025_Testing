package ioStreams;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class Test1 {
public static void main(String[] args) throws FileNotFoundException, IOException {
		
		//connection is established to the abc.txt file for writing
		FileOutputStream fos = new FileOutputStream("abc.txt");
		
		//writing data to abc.txt file
		fos.write(5);
		fos.write(97);
		fos.write('b');
		fos.write(150);
		
		fos.write("abc".getBytes());	//for writing String, we must convert it into byte[]
		fos.write("xyz".getBytes());	
		
		System.out.println("data is saved");

		fos.close();
	}

}
