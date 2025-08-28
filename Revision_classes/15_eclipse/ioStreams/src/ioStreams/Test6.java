package ioStreams;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Test6 {
public static void main(String[] args) throws IOException {
		
		BufferedReader br = 
				new BufferedReader(new FileReader("abc.txt"));
		
		FileWriter fw = new FileWriter("bbc.txt");
		
		String line;
		while((line=br.readLine()) != null) {
			fw.write(line);
			fw.write('\n');
		}
		fw.flush();
		
		System.out.println("file is copied");
		
		br.close();
		fw.close();

	}

}
