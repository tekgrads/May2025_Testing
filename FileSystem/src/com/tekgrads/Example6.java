package com.tekgrads;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class Example6 {

    public static void main(String[] args) {
        File file = new File("abc.txt");

        try (FileReader fr = new FileReader(file);
             BufferedReader br = new BufferedReader(fr)) {

        	String s = br.readLine();
        	while(s!=null) {
        		System.out.println(s);
        		s=br.readLine();
        	}

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
