package ioStreams;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Test5 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = 
				new BufferedReader(new FileReader("bbc.txt"));

	/*	System.out.println(br.read());
		System.out.println(br.read());
		System.out.println(br.read());
		System.out.println(br.read());
		
		System.out.println(br.readLine());
		*/

		String line;
		while((line=br.readLine()) != null) {
			System.out.println(line);
		}
		
		br.close();
	}

}
