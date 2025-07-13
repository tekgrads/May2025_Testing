package com.tekgrads;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Example5 {

    public static void main(String[] args) {
        File file = new File("abc.txt");

        try (FileWriter fw = new FileWriter(file);
             BufferedWriter bw = new BufferedWriter(fw)) {

            bw.write("abc");
            bw.newLine();
            bw.write("this is next line");
            bw.newLine();
            bw.write("this is last line");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
