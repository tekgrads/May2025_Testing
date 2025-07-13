package com.tekgrads;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class Example7 {

    public static void main(String[] args) {
        File file = new File("abc_new.txt");

        // Writing to the file using OutputStream
        try (FileOutputStream fos = new FileOutputStream(file)) {
            String content = "abc\nthis is next line\nthis is last line";
            byte[] bytes = content.getBytes();
            fos.write(bytes);
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Reading from the file using InputStream
        try (FileInputStream fis = new FileInputStream(file)) {
            int ch;
            while ((ch = fis.read()) != -1) {
                System.out.print((char) ch); // cast byte to char
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

